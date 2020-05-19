package com.dc.model;


import java.util.Date;

public class Car {
    private  int brand_id;
    private String brand;
    private String  model;
    private  String  color;
    private  String state;
  private  String  configuration;
  private String market_time;
  private  String money;
   private int is_deleted;

    public int getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(int is_deleted) {
        this.is_deleted = is_deleted;
    }

    public String getMoney() {
        return money;
    }

    public void setMoney(String money) {
        this.money = money;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getConfiguration() {
        return configuration;
    }

    public void setConfiguration(String configuration) {
        this.configuration = configuration;
    }

    public String getMarket_time() {
        return market_time;
    }

    public void setMarket_time(String market_time) {
        this.market_time = market_time;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Car{");
        sb.append("brand_id=").append(brand_id);
        sb.append(", brand='").append(brand).append('\'');
        sb.append(", model='").append(model).append('\'');
        sb.append(", color='").append(color).append('\'');
        sb.append(", state='").append(state).append('\'');
        sb.append(", configuration='").append(configuration).append('\'');
        sb.append(", market_time='").append(market_time).append('\'');
        sb.append(", money='").append(money).append('\'');
        sb.append(", is_deleted=").append(is_deleted);
        sb.append('}');
        return sb.toString();
    }
}
