package com.dtv.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: florianbessiere
 * Date: 05.09.14
 * Time: 11:38
 * To change this template use File | Settings | File Templates.
 */

@Controller
public class TwitterWallController {

    @RequestMapping(value="/twitter", method = RequestMethod.GET)
    public ModelAndView getLocations(HttpServletRequest request)
    {





        return new ModelAndView("twitter/twitterwall.ftl");
    }

}
