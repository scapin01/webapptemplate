package com.webapptemplate.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: florianbessiere
 * Date: 11.08.14
 * Time: 10:56
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class IndexController {


    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView getMainPage(HttpServletRequest request,@ModelAttribute("model") ModelMap model)
    {





        return new ModelAndView("index.ftl");
    }

}
