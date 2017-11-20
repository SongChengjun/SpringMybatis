package cn.com.carsmart.song.service.impl;

import cn.com.carsmart.song.dao.Bidder;
import cn.com.carsmart.song.mapper.BidderMapper;
import cn.com.carsmart.song.service.BidderService;
import cn.com.carsmart.song.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BidderServiceImpl implements BidderService {

    @Autowired
    BidderMapper bidderMapper;

    public Page<Bidder> findAll() {
        Page page = new Page();
        List<Bidder> list = bidderMapper.findAll();
        page.setItems(list);
        return page;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public Bidder selectById(long id) {
        return bidderMapper.selectById(id);
    }
}
