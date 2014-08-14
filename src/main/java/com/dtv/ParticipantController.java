package com.dtv;

import com.dtv.models.Participant;
import de.caluga.morphium.Morphium;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created with IntelliJ IDEA.
 * User: florianbessiere
 * Date: 14.08.14
 * Time: 11:27
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ParticipantController {

    @Resource(name = "mongo-primary")
    private Morphium morphium;

    @RequestMapping(value="/participants", method = RequestMethod.GET)
    public ModelAndView getMainPage(HttpServletRequest request)
    {


        Participant participant = new Participant();
        participant.setName("Jakob Braun");
        participant.setOrganization("Siemens");
        participant.setPosition("Praktikant");
        morphium.store();






        return new ModelAndView("index.ftl");
    }


}
