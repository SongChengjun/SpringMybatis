package cn.com.carsmart.song.service.impl;

import cn.com.carsmart.song.dao.BidPriceLog;
import cn.com.carsmart.song.dao.Bidder;
import cn.com.carsmart.song.dao.Lot;
import cn.com.carsmart.song.exception.BidException;
import cn.com.carsmart.song.mapper.BidPriceLogMapper;
import cn.com.carsmart.song.mapper.BidderMapper;
import cn.com.carsmart.song.mapper.LotMapper;
import cn.com.carsmart.song.service.BidService;
import cn.com.carsmart.song.service.BidderService;
import cn.com.carsmart.song.util.DateFormatUtil;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.framework.AopContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class BidServiceImpl implements BidService {

    private static Logger LOGGER = LoggerFactory.getLogger(BidServiceImpl.class);

    @Autowired
    BidderService bidderService;

    @Autowired
    LotMapper lotMapper;

    @Autowired
    BidPriceLogMapper bidPriceLogMapper;

    public void bid(JSONObject bid) throws BidException {
        Date bidTime = new Date();
        LOGGER.info(String.format("竞价:%s, bidTime:%s", bid, DateFormatUtil.format(bidTime)));


        BigDecimal price = bid.getBigDecimal("price");

        Long lotId = bid.getLong("lotId");
        Lot lot = lotMapper.findById(lotId);
        if (lot == null) {
            throw new BidException("拍品不存在");
        }

        Long bidderId = bid.getLong("bidderId");
        Bidder bidder = bidderService.selectById(bidderId);
        if (bidder == null) {
            throw new BidException("用户不存在");
        }

        if (bidTime.before(lot.getStartTime())) {
            throw new BidException("竞拍未开始！");
        } else if (bidTime.after(lot.getEndTime())) {
            throw new BidException("竞拍已结束！");
        }//TODO 拍品状态检查

        this.checkPrice(lot, price);

        if (lot.getCurrentPrice() != null && lot.getBidderId() != null) {
            BigDecimal currMaxPrice = lot.getCurrentPrice();
            if (price.compareTo(currMaxPrice) <= 0) {
                throw new BidException("当前出价已被超越，请加价后再次出价！");
            } else {
                ((BidService)AopContext.currentProxy())
                        .updateLotAndPriceLog(lot, price, bidder, bidTime);
            }
        } else {
            //首次出价
            ((BidService)AopContext.currentProxy())
                    .updateLotAndPriceLog(lot, price, bidder, bidTime);
        }
    }

    private void checkPrice(Lot lot, BigDecimal price) throws BidException {
        Long nowBidderId = lot.getBidderId();
        if (nowBidderId == null) { // 首次出价
            if (price.compareTo(lot.getStartPrice()) < 0) {
                throw new BidException("首次出价必须大于起拍价！");
            }
        }
    }

    @Transactional
    public void updateLotAndPriceLog(Lot lot, BigDecimal price, Bidder bidder, Date bidTime) {
        lot.setCurrentPrice(price);
        lot.setBidderId(bidder.getId());
        lotMapper.updatePrice(lot);

        //添加竞买记录
        addPriceLog(lot, price, bidder, bidTime);
    }

    private void addPriceLog(Lot lot, BigDecimal price, Bidder bidder, Date bidTime) {
        BidPriceLog log = new BidPriceLog();
        log.setLotId(lot.getId());
        log.setBidderId(bidder.getId());
        log.setBidTime(bidTime);
        log.setPrice(price);
        bidPriceLogMapper.insert(log);
    }

}
