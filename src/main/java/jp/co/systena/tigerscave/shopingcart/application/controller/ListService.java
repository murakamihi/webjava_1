package jp.co.systena.tigerscave.shopingcart.application.controller;

import java.util.ArrayList;
import java.util.List;

public class ListService {

  public List<Item> getItemList(){
    Item item1 = new Item();
    Item item2 = new Item();
    Item item3 = new Item();

    item1.itemId = 1;
    item2.itemId = 2;
    item3.itemId = 3;

    item1.name = "item1";
    item2.name = "item2";
    item3.name = "item3";

    item1.price = 111;
    item2.price = 222;
    item3.price = 333;


    List<Item> list = new ArrayList<Item>();
    list.add(item1);
    list.add(item2);
    list.add(item3);

    return list;
  }
}
