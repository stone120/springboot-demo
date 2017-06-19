package com.demo.web;

import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {
	
    @RequestMapping("/hello")
	public String hello(Locale locale, Model model) {
		model.addAttribute("greeting", "hello world");
        return "hello";
	}

    @RequestMapping("/freemarker")
    public String freemarker(Model model) {
        model.addAttribute("name", "freemarker");
        return "freemarkerTest";}
    @RequestMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }

}