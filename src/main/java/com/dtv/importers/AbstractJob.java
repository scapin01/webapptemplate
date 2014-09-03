package com.dtv.importers;

import de.caluga.morphium.Morphium;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created with IntelliJ IDEA.
 * User: florianbessiere
 * Date: 03.09.14
 * Time: 11:56
 * To change this template use File | Settings | File Templates.
 */
public class AbstractJob implements Job {

    protected Morphium morphium;

    @Override
    public void start() {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public void init() {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{ "classpath:/applicationContext.xml" });
        context.start();
        morphium = (Morphium)context.getBean("morphium") ;

    }
}

