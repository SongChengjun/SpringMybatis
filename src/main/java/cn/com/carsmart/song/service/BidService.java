package cn.com.carsmart.song.service;

import cn.com.carsmart.song.dto.ResultStatusObject;
import com.alibaba.fastjson.JSONObject;

public interface BidService {

    ResultStatusObject bid(JSONObject bid);

}
