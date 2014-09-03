package com.dtv.importers;

import org.apache.log4j.PropertyConfigurator;

import java.net.URL;

/**
 * Created with IntelliJ IDEA.
 * User: florianbessiere
 * Date: 03.09.14
 * Time: 12:03
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main( String[] args ) {

        try{
            String jobName = args[0];
            Class c = Class.forName("com.dtv.importers."+jobName);

            ClassLoader loader = Thread.currentThread().getContextClassLoader();
            URL url = loader.getResource("dev-log4j.xml");
            PropertyConfigurator.configure(url);

            Job job = (Job)c.newInstance();
            job.init();
            job.start();

        }catch(Exception e){
            throw new RuntimeException(e);
        }


    }
}