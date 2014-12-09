package com.webapptemplate.controllers;

import com.webapptemplate.entities.Participant;
import com.webapptemplate.models.ParticipantModel;
import com.webapptemplate.service.DataBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: florianbessiere
 * Date: 09.12.14
 * Time: 15:12
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class ApiController {


    @Autowired
    private DataBaseService dataBaseService;

    @RequestMapping(value="/api/participants", method = RequestMethod.GET)
    @ResponseBody
    public List<ParticipantModel> getMainPage(HttpServletRequest request,@ModelAttribute("model") ModelMap model,
                                    @RequestParam(value = "srch-term", required = false,defaultValue="") String query,
                                    @RequestParam(value = "start", required = false,defaultValue="0") int start,
                                    @RequestParam(value = "max", required = false,defaultValue="45") int max)
    {

        List<Participant> participantsFromDb = dataBaseService.searchParticipants(query,start,max);

        //Map to our model

        List<ParticipantModel> participantsToExpose = new ArrayList<ParticipantModel>();

        for(Participant p:participantsFromDb){
            ParticipantModel pModel = new ParticipantModel();
            pModel.setFirstName(p.getFirstName());
            pModel.setLastName(p.getLastName());
            participantsToExpose.add(pModel);
        }

        return participantsToExpose;

    }

}
