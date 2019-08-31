package jp.co.systena.tigerscave.shopingcart.application.controller;

import java.util.ArrayList;
import java.util.List;

public class ListService {

  public List<Item> getItemList(){
    Item item1 = new Item(1, "item1", 111);
    Item item2 = new Item(2, "item2", 222);
    Item item3 = new Item(3, "item3", 333);

    List<Item> list = new ArrayList<Item>();
    list.add(item1);
    list.add(item2);
    list.add(item3);

    return list;
  }
}
