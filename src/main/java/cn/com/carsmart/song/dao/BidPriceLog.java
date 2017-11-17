package cn.com.carsmart.song.dao;

import java.math.BigDecimal;
import java.util.Date;

public class BidPriceLog {

    private Long id;

    private Long lotId;

    private Long bidderId;

    private BigDecimal price;

    private Date bidTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLotId() {
        return lotId;
    }

    public void setLotId(Long lotId) {
        this.lotId = lotId;
    }

    public Long getBidderId() {
        return bidderId;
    }

    public void setBidderId(Long bidderId) {
        this.bidderId = bidderId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getBidTime() {
        return bidTime;
    }

    public void setBidTime(Date bidTime) {
        this.bidTime = bidTime;
    }

    @Override
    public String toString() {
        return "BidPriceLog{" +
                "lotId=" + lotId +
                ", bidderId=" + bidderId +
                ", price=" + price +
                ", bidTime=" + bidTime +
                '}';
    }
}
