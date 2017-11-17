package cn.com.carsmart.song.controller;

import cn.com.carsmart.song.dao.Bidder;
import cn.com.carsmart.song.dto.ResultStatusObject;
import cn.com.carsmart.song.exception.BidException;
import cn.com.carsmart.song.service.BidService;
import cn.com.carsmart.song.service.BidderService;
import cn.com.carsmart.song.util.Page;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BidResource {

    private static Logger LOGGER = LoggerFactory.getLogger(BidResource.class);

    @Autowired
    BidderService bidderService;

    @Autowired
    BidService bidService;

    @RequestMapping(value = "/bid/bidder/list", method = RequestMethod.GET)
    @ResponseBody
    public Page<Bidder> getBidder() {
        return bidderService.findAll();
    }

    @RequestMapping(value = "/bid", method = RequestMethod.POST)
    @ResponseBody
    public ResultStatusObject bid(@RequestBody JSONObject bid) {
        ResultStatusObject result = new ResultStatusObject();
        try {
            bidService.bid(bid);
            result.setStatus(true);
            result.setMsg("success");
            LOGGER.info("竞价成功");
        } catch (BidException e) {
            LOGGER.error("出价失败:" + e.getMessage(), e);
            result.setStatus(false);
            result.setMsg(e.getMessage());
        }

        return result;
    }


}
