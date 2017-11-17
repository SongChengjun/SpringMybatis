package cn.com.carsmart.song.service;

import cn.com.carsmart.song.dao.Bidder;
import cn.com.carsmart.song.dao.Lot;
import cn.com.carsmart.song.exception.BidException;
import com.alibaba.fastjson.JSONObject;

import java.math.BigDecimal;
import java.util.Date;

public interface BidService {

    void bid(JSONObject bid) throws BidException;

    void updateLotAndPriceLog(Lot lot, BigDecimal price, Bidder bidder, Date bidTime);

}
