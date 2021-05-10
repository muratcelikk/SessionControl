package com.cal.pro;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SettingController {

    @RequestMapping(value = "/setting", method = RequestMethod.GET)
    public String setting(HttpServletRequest req, Model model) {
        return Util.control(req, "setting");
    }
}
