package jp.co.systena.tigerscave.shopingcart.application.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListController {

  @Autowired
  HttpSession session; // セッション管理

  @RequestMapping(value = "/list", method = RequestMethod.GET) // URLとのマッピング
  public ModelAndView show(ModelAndView mav) {
    Cart cart = (Cart) session.getAttribute("cart");
    if (cart == null) {
      cart = new Cart();
    }
    session.setAttribute("cart", cart);
    mav.addObject("cart",cart);

    mav.addObject("listForm", new ListForm());
    // Viewに渡すデータを設定
    // // セッション情報から保存したデータを取得してメッセージを生成
    // ListForm listForm = (ListForm) session.getAttribute("cart");
    // session.removeAttribute("form");
    // if (listForm != null) {
    // mav.addObject("message", listForm.getName() + "を保存しました");
    // }
    // mav.addObject("listForm", new ListForm()); // 新規クラスを設定

    // List<Item> itemList = (List<Item>) session.getAttribute("itemList");
    // if (itemList == null) {
    // itemList = new ArrayList<Item>();
    // session.setAttribute("itemList", itemList);
    // }

    // 商品一覧設定
    ListService listService = new ListService();
    mav.addObject("itemList", listService.getItemList());

    // BindingResult bindingResult = (BindingResult) session.getAttribute("result");
    // if (bindingResult != null) {
    // mav.addObject("bindingResult", bindingResult);
    // }
    // Viewのテンプレート名を設定
    mav.setViewName("ListView");
    return mav;
  }

  @RequestMapping(value = "/list", method = RequestMethod.POST) // URLとのマッピング
  private ModelAndView order(ModelAndView mav, @Valid ListForm listForm,
      BindingResult bindingResult, HttpServletRequest request) {

    if (listForm == null) {
      return new ModelAndView("redirect:/list"); // リダイレクト
    }

    Cart cart = (Cart) session.getAttribute("cart");
    if (cart == null) {
      cart = new Cart();
    }
    addOrder(cart, listForm);

    // if (shoppingList == null) {
    // shoppingList = new ArrayList<Item>();
    // session.setAttribute("itemList", users);
    // }

    // if (bindingResult.getAllErrors().size() > 0) {
    // // エラーがある場合はそのまま戻す
    // mav.addObject("userForm", userForm); // 新規クラスを設定
    //
    // mav.addObject("users", users);
    //
    // // Viewのテンプレート名を設定
    // mav.setViewName("userlist");
    // return mav;
    //
    // }
    // User user = new User();
    // user.setName(userForm.getName());
    // users.add(user);
    // // データをセッションへ保存
    // session.setAttribute("form", userForm);
    return new ModelAndView("redirect:/list"); // リダイレクト
  }

  private void addOrder(Cart cart, ListForm listform) {
    Order order = new Order();
    order.setItemId(listform.getItemId());
    order.setNum(listform.getNumber());
    cart.getOrderList().add(order);
    session.setAttribute("cart", cart);
  }
}
