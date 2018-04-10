package cn.one;

import java.util.Date;

/**
 * 房屋信息表
 */
public class House {
    private int id;//房屋信息编号
    private String title;//标题
    private String description;//描述
    private Integer price;//出租价格
    private Date pubDate;//发布时间
    private Integer floorage;//面积
    private String contact;//联系人
    private int user_id;//用户编号，外键引用用户表主键
    private int type_id;//类型编号，外键引用类型表主键
    private int street_id;//街道编号，外键引用街道表主键

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public Integer getFloorage() {
        return floorage;
    }

    public void setFloorage(int floorage) {
        this.floorage = floorage;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getType_id() {
        return type_id;
    }

    public void setType_id(int type_id) {
        this.type_id = type_id;
    }

    public int getStreet_id() {
        return street_id;
    }

    public void setStreet_id(int street_id) {
        this.street_id = street_id;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", pubDate=" + pubDate +
                ", floorage=" + floorage +
                ", contact='" + contact + '\'' +
                ", user_id=" + user_id +
                ", type_id=" + type_id +
                ", street_id=" + street_id +
                '}';
    }
}
