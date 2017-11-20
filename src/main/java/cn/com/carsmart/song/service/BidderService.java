package cn.com.carsmart.song.service;

import cn.com.carsmart.song.dao.Bidder;
import cn.com.carsmart.song.util.Page;

public interface BidderService {

    Page<Bidder> findAll();

    Bidder selectById(long id);

}