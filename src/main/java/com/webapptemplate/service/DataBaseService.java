package com.webapptemplate.service;

import com.webapptemplate.entities.Participant;
import de.caluga.morphium.Morphium;
import de.caluga.morphium.query.Query;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: florianbessiere
 * Date: 14.08.14
 * Time: 13:25
 * To change this template use File | Settings | File Templates.
 */
@Service
public class DataBaseService {

    @Resource(name = "mongo-primary")
    private Morphium morphium;


    /**
     * Search participants
     *
     *
     * @param query
     * @return
     */
    public List<Participant> searchParticipants(String query, int startIndex, int maxResults){


        if(StringUtils.isEmpty(query)){

            return morphium.createQueryFor(Participant.class).sort("last_name").skip(startIndex).limit(maxResults).asList();

        }else{

            if(query.length()<4){

                Query<Participant> q=morphium.createQueryFor(Participant.class);
                query = query.toLowerCase();
                q=q.or(q.q().f("last_name").matches("^"+query),q.q().f("first_name").matches("^"+query));
                return q.asList();


            }else{
                return morphium.createQueryFor(Participant.class).text(query).sort("last_name").skip(startIndex).limit(maxResults).asList();
            }
        }
    }

    public List<Participant> searchParticipantsPat(){



            return morphium.createQueryFor(Participant.class).f("first_name").eq("Pat").asList();


    }



    public void storeParticipants(Participant participant) {

        morphium.store(participant);

    }




}
