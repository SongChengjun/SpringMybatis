package cn.com.carsmart.song.mapper;

import cn.com.carsmart.song.dao.Bidder;

import java.util.List;

public interface BidderMapper {

    List<Bidder> findAll();

    Bidder selectByName(String name);

    Bidder selectById(long id);

    int insertBidder(Bidder bidder);

    int updateBidder(Bidder bidder);

    int deleteById(long id);
}
