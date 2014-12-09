package com.webapptemplate.controllers;

import com.webapptemplate.entities.Participant;
import com.webapptemplate.service.DataBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: florianbessiere
 * Date: 14.08.14
 * Time: 11:27
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ParticipantController {



    @Autowired
    private DataBaseService dataBaseService;


    /**
     * Display participants with pagination
     *
     * @param request
     * @param model
     * @param query
     * @param start
     * @param max
     * @return
     */
    @RequestMapping(value="/participants", method = RequestMethod.GET)
    public ModelAndView getMainPage(HttpServletRequest request,@ModelAttribute("model") ModelMap model,
                                    @RequestParam(value = "srch-term", required = false,defaultValue="") String query,
                                    @RequestParam(value = "start", required = false,defaultValue="0") int start,
                                    @RequestParam(value = "max", required = false,defaultValue="45") int max)
    {

        List<Participant> participants = dataBaseService.searchParticipants(query,start,max);
        model.put("participants",participants);
        model.put("query",query);




        return new ModelAndView("participants/participants.ftl",model);
    }






































    @RequestMapping(value="/add_participants", method = RequestMethod.GET)
    public ModelAndView addParticipants(HttpServletRequest request)
    {
        Participant participant = new Participant();
        participant.setFirstName("Pat");
        participant.setLastName("Riot");
        participant.setAge(20);

        dataBaseService.storeParticipants(participant);

        Participant p = new Participant();
        p.setAge(30);

        p.setFirstName("Ann");
        p.setLastName("Tenne");

        dataBaseService.storeParticipants(p);

        Participant p3 = new Participant();
        p3.setFirstName("Johannes");
        p3.setLastName("Burg");
        p3.setAge(15);


        dataBaseService.storeParticipants(p3);

        Participant p4 = new Participant();
        p4.setFirstName("Ann");
        p4.setLastName("Scheinend");
        p4.setAge(50);
        dataBaseService.storeParticipants(p4);


        return new ModelAndView("index.ftl");
    }


}
