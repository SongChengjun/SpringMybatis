package cn.com.carsmart.song.mapper;

import cn.com.carsmart.song.dao.Bidder;

public interface BidderMapper {

    Bidder selectByName(String name);

    Bidder selectById(long id);

    int insertBidder(Bidder bidder);

    int updateBidder(Bidder bidder);

    int deleteById(long id);
}
