package com.dtv.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: florianbessiere
 * Date: 11.09.14
 * Time: 09:31
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class InfoOrganizationController {

    @RequestMapping(value="/organisatorische_hinweise", method = RequestMethod.GET)
    public ModelAndView getOrga(HttpServletRequest request)
    {

        return new ModelAndView("info_organization.ftl");
    }

}
