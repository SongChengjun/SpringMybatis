package cn.com.carsmart.song.mapper;

import cn.com.carsmart.song.dao.Lot;

public interface LotMapper {

    Lot findById(Long id);

    int insert(Lot lot);

    int updatePrice(Lot lot);

    int updateStatus(Lot lot);

}
