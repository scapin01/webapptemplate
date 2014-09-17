package com.dtv.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: florianbessiere
 * Date: 16.09.14
 * Time: 16:16
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ImpresumController {



    @RequestMapping(value="/impressum", method = RequestMethod.GET)
    public ModelAndView getImpressum(HttpServletRequest request)
    {





        return new ModelAndView("impressum.ftl");
    }


}
