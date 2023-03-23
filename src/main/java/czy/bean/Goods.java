package czy.bean;

import java.util.Date;

public class Goods {
    private Long id;

    private String name;

    private Integer stock;

    private String des;

    private String data;

    public Goods( String name ) {
        this.name = name;
    }
    public Goods() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String name(int  i) {
        return "name方法" + i;
    }

    public Goods setName(String name) {
        this.name = name == null ? null : name.trim();
        return this;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des == null ? null : des.trim();
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data == null ? null : data.trim();
    }





    @Override
    public String toString() {
        return "Goods [id=" + id + ", name=" + name + ", stock=" + stock + ", des=" + des + ", data=" + data + "]";
    }


    public static Goods randomGoods() {
        Goods goods = new Goods();
        goods.setData(""+new Date());
        goods.setDes("222");
        goods.setName("111");
        return goods;
    }

    public static void main(String[] args) {
        System.out.println( Long.MAX_VALUE );
    }

}
