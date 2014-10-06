package com.dtv.controllers;

import com.dtv.models.FeedbackEntity;
import com.dtv.models.FeedbackForm;
import com.dtv.service.DataBaseService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;

/**
 * Created with IntelliJ IDEA.
 * User: florianbessiere
 * Date: 21.08.14
 * Time: 10:02
 * To change this template use File | Settings | File Templates.
 *
 * export MAVEN_OPTS="-Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,address=4000,server=y,suspend=n"
 *
 */
@Controller
public class FeedbackController {

    private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(FeedbackController.class);


    @Autowired
    private DataBaseService dataBaseService;


    @Autowired
    private Validator validator;

    @ModelAttribute("feedbackForm")
    public FeedbackForm getFeedbackForm() {
        return new FeedbackForm();
    }

    @RequestMapping(value="/feedback", method = RequestMethod.GET)
    public ModelAndView getFeedbackForm(HttpServletRequest request)
    {



        return new ModelAndView("eventform/feedback.ftl");
    }


    /*@RequestMapping(value="/post_feedback", method = RequestMethod.POST)
    public ModelAndView postFeedback(HttpServletRequest request,@Valid @ModelAttribute("feedbackForm") FeedbackForm feedbackForm, BindingResult feedbackFormResult,Model model)
    {



        return new ModelAndView("eventform/feedback.ftl",model.asMap());
    }*/


    @RequestMapping(value="/post_feedback", method = RequestMethod.POST)
    public ModelAndView postFeedback( @ModelAttribute("feedbackForm") FeedbackForm feedbackForm)
    {

        //Map
        FeedbackEntity entity = new FeedbackEntity();

        try {
            BeanUtils.copyProperties(entity,feedbackForm);
            dataBaseService.storeFeedback(entity);

        } catch (IllegalAccessException e) {
            logger.error(e.getMessage(),e);
        } catch (InvocationTargetException e) {
            logger.error(e.getMessage(),e);
        }

        return new ModelAndView("eventform/thankyou.ftl");
    }


}
