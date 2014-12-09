package com.webapptemplate.controllers;

import com.webapptemplate.models.PaginationModel;
import com.webapptemplate.entities.Participant;
import com.webapptemplate.models.ParticipantRequestResult;
import com.webapptemplate.service.DataBaseService;
import de.caluga.morphium.Morphium;
import org.apache.commons.lang3.StringUtils;
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
import java.util.ArrayList;
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

        ParticipantRequestResult p = dataBaseService.searchParticipants(query,start,max);
        model.put("participants",p.getParticipants());
        model.put("numFound",p.getNumFound());

        model.put("start",start);
        model.put("max",max);

        if(StringUtils.isNotEmpty(query)){
            model.put("query",query);
        }

        //Pagination Model
        //define currentPage. max is the number of item per page
        //Page 1 is first Page

        int pageIndex = start/max +1 ;
        model.put("pageIndex",pageIndex);
        List<PaginationModel> pagesIndexes = new ArrayList<PaginationModel>();
        int d = (int) Math.ceil((double)p.getNumFound() / max);
        for(int i=1;i<=d;i++){

            PaginationModel paginationModel = new PaginationModel();
            paginationModel.setPageIndex(i);
            paginationModel.setStart(max * (i - 1));
            paginationModel.setMax(max);
            pagesIndexes.add(paginationModel);
        }
        model.put("pagesIndexes",pagesIndexes);
        return new ModelAndView("participants/participants.ftl",model);
    }














    @RequestMapping(value="/add_participants", method = RequestMethod.GET)
    public ModelAndView addParticipants(HttpServletRequest request)
    {


        Participant participant = new Participant();
        participant.setFirstName("Pat");
        participant.setLastName("Riot");
        participant.setAge(20);

        morphium.store(participant);

        Participant p = new Participant();
        p.setAge(30);

        p.setFirstName("Ann");
        p.setLastName("Tenne");

        morphium.store(p);

        Participant p3 = new Participant();
        p3.setFirstName("Johannes");
        p3.setLastName("Burg");
        p3.setAge(15);


        morphium.store(p3);

        Participant p4 = new Participant();
        p4.setFirstName("Ann");
        p4.setLastName("Scheinend");
        p4.setAge(50);
        morphium.store(p4);


        return new ModelAndView("index.ftl");
    }


}
