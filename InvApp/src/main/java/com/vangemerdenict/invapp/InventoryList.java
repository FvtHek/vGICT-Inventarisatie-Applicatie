/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vangemerdenict.invapp;

/**
 *
 * @author Frans
 */
public class InventoryList {

    private String id;
    private String datatest;
    private String opmerking;

    public InventoryList(String id, String datatest, String opmerking) {
        this.id = id;
        this.datatest = datatest;
        this.opmerking = opmerking;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the datatest
     */
    public String getDatatest() {
        return datatest;
    }

    /**
     * @param datatest the datatest to set
     */
    public void setDatatest(String datatest) {
        this.datatest = datatest;
    }

    /**
     * @return the opmerking
     */
    public String getOpmerking() {
        return opmerking;
    }

    /**
     * @param opmerking the opmerking to set
     */
    public void setOpmerking(String opmerking) {
        this.opmerking = opmerking;
    }
    
    
}
