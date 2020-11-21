package org.zzz.web.shop.web.admin.web.controller;

import org.zzz.web.shop.commons.dto.BaseResult;
import org.zzz.web.shop.domain.TbUser;
import org.zzz.web.shop.web.admin.service.TbUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

/**
 * 用户管理
 */
@Controller
@RequestMapping(value = "user") //这样所有的访问都是以user开头，再继续往下追加
public class UserController {

    @Autowired //自动注入
    private TbUserService tbUserService;

    /**
     * 跳转到用户列表页
     */
    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {
        List<TbUser> tbUsers = tbUserService.selectAll();
        model.addAttribute("tbUsers" , tbUsers);
        return "user_list";
    }


    /**
     * 跳转用户表单页
     */
    @RequestMapping(value = "form" , method = RequestMethod.GET)
    public String form() {
        return "user_form";
    }


    /**
     * 保存用户信息
     */
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(TbUser tbUser, Model model, RedirectAttributes redirectAttributes) {
        BaseResult baseResult = tbUserService.save(tbUser);

        //保存成功
        if (baseResult.getStatus() == 200) {
            redirectAttributes.addFlashAttribute("baseResult", baseResult);
            return "redirect:/user/list";
        }

        //保存失败
        else {
            model.addAttribute("baseResult" , baseResult);
            return "user_form";
        }
    }
}
