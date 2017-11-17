package cn.com.carsmart.song.service.impl;

import cn.com.carsmart.song.dao.Bidder;
import cn.com.carsmart.song.mapper.BidderMapper;
import cn.com.carsmart.song.service.BidderService;
import cn.com.carsmart.song.util.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BidderServiceImpl implements BidderService {

    private static Logger LOGGRE = LoggerFactory.getLogger(BidderServiceImpl.class);

    @Autowired
    BidderMapper bidderMapper;

    public Page<Bidder> findAll() {
        Page page = new Page();
        List<Bidder> list = bidderMapper.findAll();
        page.setItems(list);
        return page;
    }
}
