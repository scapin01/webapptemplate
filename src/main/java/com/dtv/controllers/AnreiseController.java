package com.dtv.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: tobiasstobe
 * Date: 12.09.14
 * Time: 08:01
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class AnreiseController {

    @RequestMapping(value="/anreise", method = RequestMethod.GET)
    public ModelAndView getAnreise(HttpServletRequest request)
    {

        return new ModelAndView("anreise.ftl");
    }

}
