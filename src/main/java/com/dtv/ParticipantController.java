package com.dtv;

import com.dtv.models.Participant;
import com.dtv.service.DataBaseService;
import de.caluga.morphium.Morphium;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
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

    @Resource(name = "mongo-primary")
    private Morphium morphium;

    @Autowired
    private DataBaseService dataBaseService;

    @RequestMapping(value="/participants", method = RequestMethod.GET)
    public ModelAndView getMainPage(HttpServletRequest request,@ModelAttribute("model") ModelMap model,
                                    @RequestParam(value = "srch-term", required = false,defaultValue="") String query)
    {

        List<Participant> participants = dataBaseService.searchParticipants(query);
        model.put("participants",participants);

        return new ModelAndView("participants/participants.ftl",model);
    }



    @RequestMapping(value="/add_participants", method = RequestMethod.GET)
    public ModelAndView addParticipants(HttpServletRequest request)
    {


        Participant participant = new Participant();
        participant.setFirstName("Jakob");
        participant.setLastName("Schnitzel");
        participant.setOrganization("Siemens");
        participant.setPosition("Praktikant");
        morphium.store(participant);


        Participant p = new Participant();
        p.setFirstName("Lorrenz");
        p.setLastName("Salami");
        p.setOrganization("Holiday Insider");
        p.setPosition("Developer");
        morphium.store(p);


        Participant p3 = new Participant();
        p3.setFirstName("Franz");
        p3.setLastName("Ferdinand");
        p3.setOrganization("Holiday Insider");
        p3.setPosition("Developer");
        morphium.store(p3);

        Participant p4 = new Participant();
        p4.setFirstName("Roman");
        p4.setLastName("Nachname");
        p4.setOrganization("Deutsche Tousirmus Verband");
        p4.setPosition("Marketing");
        morphium.store(p4);

        Participant p5 = new Participant();
        p5.setFirstName("Thomas");
        p5.setLastName("Fritzzz");
        p5.setOrganization("Deutsche Tousirmus Verband");
        p5.setPosition("Sales");
        morphium.store(p5);

        Participant p6 = new Participant();
        p6.setFirstName("Willy");
        p6.setLastName("Sagnol");
        p6.setOrganization("FC Bayern");
        p6.setPosition("Spieler");
        morphium.store(p6);

        return new ModelAndView("index.ftl");
    }


}
