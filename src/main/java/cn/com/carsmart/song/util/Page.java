package cn.com.carsmart.song.util;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Page<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    public Page() {
    }

    private Long totalCount;

    private int totalPages;

    private int page;

    private int count;

    private List<T> items = new ArrayList<T>();

    @XmlElementWrapper(name = "items")
    @XmlElement(name = "item")
    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }


    @XmlElement()
    public Long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;

    }

    @XmlElement()
    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;

    }

    @XmlElement()
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;

    }

    @XmlElement()
    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;

    }

}
