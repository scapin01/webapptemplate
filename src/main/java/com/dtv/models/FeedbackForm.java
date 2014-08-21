package com.dtv.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

/**
 * Created with IntelliJ IDEA.
 * User: florianbessiere
 * Date: 21.08.14
 * Time: 09:53
 * To change this template use File | Settings | File Templates.
 */
public class FeedbackForm {

    @Min(1)@Max(5)
    private int orgQuestion1;

    @Min(1)@Max(5)
    private int orgQuestion2;

    @Min(1)@Max(5)
    private int orgQuestion3;

    @Min(1)@Max(5)
    private int orgQuestion4;

    @Min(1)@Max(5)
    private int orgQuestion5;

    @Min(1)@Max(5)
    private int orgQuestion6;
    @Min(1)@Max(5)
    private int orgQuestion7;

    private String remarkOrganisation;

    @Min(1)@Max(5)
    private int contentQuestion1;

    @Min(1)@Max(5)
    private int contentQuestion2;

    @Min(1)@Max(5)
    private int contentQuestion3;

    @Min(1)@Max(5)
    private int contentQuestion4;

    @Min(1)@Max(5)
    private int contentQuestion5;

    @Min(1)@Max(5)
    private int contentQuestion6;


    private String remarkContent;

    @Min(1)@Max(5)
    private int moderation;


    public int getOrgQuestion1() {
        return orgQuestion1;
    }

    public void setOrgQuestion1(int orgQuestion1) {
        this.orgQuestion1 = orgQuestion1;
    }

    public int getOrgQuestion2() {
        return orgQuestion2;
    }

    public void setOrgQuestion2(int orgQuestion2) {
        this.orgQuestion2 = orgQuestion2;
    }

    public int getOrgQuestion3() {
        return orgQuestion3;
    }

    public void setOrgQuestion3(int orgQuestion3) {
        this.orgQuestion3 = orgQuestion3;
    }

    public int getOrgQuestion4() {
        return orgQuestion4;
    }

    public void setOrgQuestion4(int orgQuestion4) {
        this.orgQuestion4 = orgQuestion4;
    }

    public int getOrgQuestion5() {
        return orgQuestion5;
    }

    public void setOrgQuestion5(int orgQuestion5) {
        this.orgQuestion5 = orgQuestion5;
    }

    public int getOrgQuestion6() {
        return orgQuestion6;
    }

    public void setOrgQuestion6(int orgQuestion6) {
        this.orgQuestion6 = orgQuestion6;
    }

    public int getOrgQuestion7() {
        return orgQuestion7;
    }

    public void setOrgQuestion7(int orgQuestion7) {
        this.orgQuestion7 = orgQuestion7;
    }

    public String getRemarkOrganisation() {
        return remarkOrganisation;
    }

    public void setRemarkOrganisation(String remarkOrganisation) {
        this.remarkOrganisation = remarkOrganisation;
    }

    public int getContentQuestion1() {
        return contentQuestion1;
    }

    public void setContentQuestion1(int contentQuestion1) {
        this.contentQuestion1 = contentQuestion1;
    }

    public int getContentQuestion2() {
        return contentQuestion2;
    }

    public void setContentQuestion2(int contentQuestion2) {
        this.contentQuestion2 = contentQuestion2;
    }

    public int getContentQuestion3() {
        return contentQuestion3;
    }

    public void setContentQuestion3(int contentQuestion3) {
        this.contentQuestion3 = contentQuestion3;
    }

    public int getContentQuestion4() {
        return contentQuestion4;
    }

    public void setContentQuestion4(int contentQuestion4) {
        this.contentQuestion4 = contentQuestion4;
    }

    public int getContentQuestion5() {
        return contentQuestion5;
    }

    public void setContentQuestion5(int contentQuestion5) {
        this.contentQuestion5 = contentQuestion5;
    }

    public int getContentQuestion6() {
        return contentQuestion6;
    }

    public void setContentQuestion6(int contentQuestion6) {
        this.contentQuestion6 = contentQuestion6;
    }

    public String getRemarkContent() {
        return remarkContent;
    }

    public void setRemarkContent(String remarkContent) {
        this.remarkContent = remarkContent;
    }

    public int getModeration() {
        return moderation;
    }

    public void setModeration(int moderation) {
        this.moderation = moderation;
    }
}
