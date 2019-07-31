package jp.co.systena.tigerscave.shopingcart.application.controller;

import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

public class ListForm {

  @Autowired
  HttpSession session; // セッション管理

  @RequestMapping(value = "/List", method = RequestMethod.GET) // URLとのマッピング
  public ModelAndView index(ModelAndView mav) {
    // Viewに渡すデータを設定
    // セッション情報から保存したデータを取得してメッセージを生成
    Item itemForm = (Item) session.getAttribute("form");
    session.removeAttribute("form");
    if (itemForm != null) {
      mav.addObject("message", itemForm.name + "を保存しました");
    }
    mav.addObject("itemForm", new Item()); // 新規クラスを設定

    List<Item> shoppingList = (List<Item>) session.getAttribute("itemList");
    if (shoppingList == null) {
      shoppingList = new ArrayList<Item>();
      session.setAttribute("itemList", shoppingList);
    }
    mav.addObject("itemList", shoppingList);

    BindingResult bindingResult = (BindingResult) session.getAttribute("result");
    if (bindingResult != null) {
      mav.addObject("bindingResult", bindingResult);
    }
    // Viewのテンプレート名を設定
    mav.setViewName("ListView");
    return mav;
  }

  @RequestMapping(value = "/List", method = RequestMethod.POST) // URLとのマッピング
  private ModelAndView adduser(ModelAndView mav, @Valid Item itemForm,
      BindingResult bindingResult, HttpServletRequest request) {

    List<Item> shoppingList = (List<Item>) session.getAttribute("userList");
    if (shoppingList == null) {
      shoppingList = new ArrayList<Item>();
      session.setAttribute("itemList", shoppingList);
    }

    if (bindingResult.getAllErrors().size() > 0) {
      // エラーがある場合はそのまま戻す
      mav.addObject("itemForm", itemForm); // 新規クラスを設定

      mav.addObject("itemList", shoppingList);

      // Viewのテンプレート名を設定
      mav.setViewName("ListView");
      return mav;

    }
    Item item = new Item();
    user.setName(userForm.getName());
    users.add(user);
    // データをセッションへ保存
    session.setAttribute("form", userForm);
    return new ModelAndView("redirect:/userlist"); // リダイレクト
  }
}
