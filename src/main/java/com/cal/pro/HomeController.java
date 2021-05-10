package com.cal.pro;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Model model) {
        return "home";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String mail, @RequestParam String password, HttpServletRequest req, HttpServletResponse res) throws Exception {
        if (mail.equals("muratcelik11@gmail.com") && password.equals("12345")) {
//            session yarat:
            req.getSession().setAttribute("user_id",10);
//            session ID console a yaz; Login olunca "SessionID" yi alır.
            HttpSession session = req.getSession();
            System.out.println("Session ID: " + session.getId());
            return "redirect:/dashboard";
        }
        return "redirect:/";
    }
    @RequestMapping(value = "/exit", method = RequestMethod.GET)
    public String exit(HttpServletRequest req){
//        req.getSession().removeAttribute("user_id"); //user_id session sil.
        req.getSession().invalidate();//tüm sessionları siler.Yeni Session ile giriş yapılır.
        return "redirect:/";
    }
}
