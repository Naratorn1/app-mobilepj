package com.example.app_pizza;

public class Order {
    private String name_product;
    private String first_name;
    private String last_name;
    private Long Phone;
    private Integer qty_order;
    private String Address;

    public Order() {

    }

    public String getName_product() {
        return name_product;
    }

    public void setName_product(String name_product) {
        this.name_product = name_product;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Long getPhone() {
        return Phone;
    }

    public void setPhone(Long phone) {
        Phone = phone;
    }

    public Integer getQty_order() {
        return qty_order;
    }

    public void setQty_order(Integer qty_order) {
        this.qty_order = qty_order;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }
}
