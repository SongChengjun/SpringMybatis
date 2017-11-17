package cn.com.carsmart.song.mapper;

import cn.com.carsmart.song.dao.Bidder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class BidderMapperTest {

    private static Logger LOGGER = LoggerFactory.getLogger(BidderMapperTest.class);

    @Autowired
    BidderMapper bidderMapper;

    @Test
    public void findAll() throws Exception {
        List<Bidder> list = bidderMapper.findAll();
        LOGGER.info(list != null && list.size() >0 ? list.get(0).toString() : "");

    }

    @Test
    public void insertBidder() throws Exception {
        Bidder bidder = new Bidder();
        bidder.setName("songchengjun");
        bidder.setMobile("151****8381");
        bidder.setPassword("123456");
        int count = bidderMapper.insertBidder(bidder);
        LOGGER.info("插入数据条数：" + count);
    }

    @Test
    public void selectByName() throws Exception {
        Bidder bidder = bidderMapper.selectByName("songchengjun");
        LOGGER.info(bidder.toString());
    }

    @Test
    public void selectById() throws Exception {
        Bidder bidder = bidderMapper.selectById(1);
        if (bidder != null) {
            LOGGER.info(bidder.toString());
        }
    }

    @Test
    public void updateBidder() throws Exception {
        Bidder bidder = new Bidder();
        bidder.setId(bidderMapper.selectByName("songchengjun").getId());
        bidder.setName("songchengjun");
        bidder.setMobile("151****8381");
        bidder.setPassword("888888");
        int count = bidderMapper.updateBidder(bidder);
    }

    @Test
    public void deleteById() throws Exception {
        Bidder bidder = bidderMapper.selectByName("songchengjun");
        if (bidder != null) {
            int count = bidderMapper.deleteById(bidder.getId());
            LOGGER.info("删除数据条数：" + count);
        }
    }

}