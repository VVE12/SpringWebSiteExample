package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import com.example.model.App;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.example.service.AppService;

@Controller
@RequestMapping("/firstpage")
public class AppController {

    @Autowired
    private AppService appService;

    @RequestMapping
    public String AppPage(Model model) {
        model.addAttribute("apps", appService.getAll());
        return "main";
    }
    @RequestMapping(value = "/editor")
    public String editorPage(Model model) {
        model.addAttribute("app", new App());
        return "editor";
    }

    @RequestMapping(value = "/editor/submit", method = RequestMethod.POST)
    public String submitApp(@ModelAttribute App app) {
        appService.save(app);
        return "redirect:../";
    }

    @RequestMapping(value = "/editor/delete/{app_id}")
    public String deteleApp(@PathVariable("app_id") Integer appId) {
        appService.delete(appId);
        return "redirect:../";
    }

    @RequestMapping(value = "/login")
    public String loginApp() {
        return "login";
    }
}
