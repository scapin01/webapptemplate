package com.dtv.models;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: florianbessiere
 * Date: 18.08.14
 * Time: 10:17
 * To change this template use File | Settings | File Templates.
 */
public class AusstellerRequestResult {

    private List<Aussteller> aussteller;
    private long numFound;

    public List<Aussteller> getAussteller() {
        return aussteller;
    }

    public void setAussteller(List<Aussteller> aussteller) {
        this.aussteller = aussteller;
    }

    public long getNumFound() {
        return numFound;
    }

    public void setNumFound(long numFound) {
        this.numFound = numFound;
    }
}
