package com.dtv.service;

import com.dtv.models.Participant;
import com.dtv.models.ParticipantRequestResult;
import de.caluga.morphium.Morphium;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
    public ParticipantRequestResult searchParticipants(String query, int startIndex, int maxResults){

        ParticipantRequestResult result = new ParticipantRequestResult();

        if(StringUtils.isEmpty(query)){

            result.setParticipants(morphium.createQueryFor(Participant.class).skip(startIndex).limit(maxResults).asList());
            result.setNumFound(morphium.createQueryFor(Participant.class).countAll());

        }else{

            result.setParticipants(morphium.createQueryFor(Participant.class).text(query).sort("last_name").skip(startIndex).limit(maxResults).asList());
            result.setNumFound(morphium.createQueryFor(Participant.class).text(query).countAll());

        }
        return result;

    }

}
