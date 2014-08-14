package com.dtv.service;

import com.dtv.models.Participant;
import de.caluga.morphium.Morphium;
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
    public List<Participant> searchParticipants(String query, int startIndex,int maxResults){

        if(StringUtils.isEmpty(query)){
             return morphium.createQueryFor(Participant.class).asList();
        }else{
            return morphium.createQueryFor(Participant.class).text(query).sort("last_name").asList();
        }
    }

}
