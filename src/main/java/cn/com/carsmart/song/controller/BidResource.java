package cn.com.carsmart.song.controller;

import cn.com.carsmart.song.dao.Bidder;
import cn.com.carsmart.song.service.BidderService;
import cn.com.carsmart.song.util.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BidResource {

    private static Logger LOGGER = LoggerFactory.getLogger(BidResource.class);

    @Autowired
    BidderService bidderService;

    @RequestMapping(value = "/bid/bidder/list", method = RequestMethod.GET)
    @ResponseBody
    public Page<Bidder> getBidder() {
        return bidderService.findAll();
    }


}
