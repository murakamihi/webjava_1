package jp.co.systena.tigerscave.shopingcart.application.controller;

import org.springframework.stereotype.Controller;

@Controller
public class ListController {

//  @RequestMapping("/List") // URLとのマッピング
//  public String show(HttpSession session, Model model,
//      @RequestParam(name = "name", required = false) String name) {
//
//    ListService listService = new ListService();
//    List<Item> shoppingList = listService.getItemList();
//
////    Item item = new Item();
////    item.name="a";
////    shoppingList.add(item);
//
//    // Viewに渡すデータを設定
////    model.addAttribute("shoppinglist", shoppingList);
//
//     int i = 0;
//     for (Item item : shoppingList) {
//     model.addAttribute("list_itemId_" + i, item.itemId);
//     model.addAttribute("list_itemName_" + i, item.name);
//     model.addAttribute("list_itemPrice_" + i, item.price);
//     i++;
//     }
////     model.addAttribute("list")
////     model.addAttribute("message", new java.util.Date());
//
//
//    // Viewのテンプレート名を返す
//    return "ListView";
//  }

  public void order(Order order) {
    Cart.ordarList.add(order);
  }
}
