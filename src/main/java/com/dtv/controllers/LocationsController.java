package com.dtv.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: florianbessiere
 * Date: 04.09.14
 * Time: 10:52
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class LocationsController {


    @RequestMapping(value="/locations", method = RequestMethod.GET)
    public ModelAndView getLocations(HttpServletRequest request)
    {



        return new ModelAndView("locations/locations.ftl");
    }
}
