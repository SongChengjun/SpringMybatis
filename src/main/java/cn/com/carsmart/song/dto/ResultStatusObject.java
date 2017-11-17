package cn.com.carsmart.song.dto;

import javax.xml.bind.annotation.XmlElement;
import java.io.Serializable;

public class ResultStatusObject implements Serializable{

    private static final long serialVersionUID = 1L;

    private boolean status;
    private String msg;
    private String additional;

    public ResultStatusObject() {
    }

    @XmlElement()
    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;

    }

    @XmlElement()
    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;

    }

    @XmlElement()
    public String getAdditional() {
        return additional;
    }

    public void setAdditional(String additional) {
        this.additional = additional;

    }

}
