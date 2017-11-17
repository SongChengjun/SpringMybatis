package cn.com.carsmart.song.service.impl;

import cn.com.carsmart.song.dto.ResultStatusObject;
import cn.com.carsmart.song.mapper.BidPriceLogMapper;
import cn.com.carsmart.song.mapper.BidderMapper;
import cn.com.carsmart.song.mapper.LotMapper;
import cn.com.carsmart.song.service.BidService;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class BidServiceImpl implements BidService {

    private static Logger LOGGER = LoggerFactory.getLogger(BidServiceImpl.class);

    @Autowired
    BidderMapper bidderMapper;

    @Autowired
    LotMapper lotMapper;

    @Autowired
    BidPriceLogMapper bidPriceLogMapper;

    public ResultStatusObject bid(JSONObject bid) {






        
        return null;
    }
}
