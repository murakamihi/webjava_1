package jp.co.systena.tigerscave.shopingcart.application.controller;

import java.util.ArrayList;
import java.util.List;

public class Cart {
  public List<Order> orderList;

  Cart(){
    orderList = new ArrayList<Order>();
  }

  public void setOrderList(List<Order> orderList) {
    this.orderList = orderList;
  }

  public List<Order> getOrderList() {
    return orderList;
  }
}
