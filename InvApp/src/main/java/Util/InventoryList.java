/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

/**
 *
 * @author Frans
 */
public class InventoryList {

    private String id;
    private String barcode;
    private String type;
    private String merk;
    private String ingekocht;
    private double inkoopprijs;
    private String verkocht;
    private String verkoopprijs;
    private String grVerloopt;
    private String specs;
    private String opmerking;

    public InventoryList(String id, String barcode, String type, String merk, String ingekocht, double inkoopprijs, String verkocht, String verkoopprijs, String grVerloopt, String specs, String opmerking) {
        this.id = id;
        this.barcode = barcode;
        this.type = type;
        this.merk = merk;
        this.ingekocht = ingekocht;
        this.inkoopprijs = inkoopprijs;
        this.verkocht = verkocht;
        this.verkoopprijs = verkoopprijs;
        this.grVerloopt = grVerloopt;
        this.specs = specs;
        this.opmerking = opmerking;
    }
    
    public InventoryList(String id, String barcode, String type, String merk, String ingekocht, double inkoopprijs, String grVerloopt, String specs, String opmerking) {
        this.id = id;
        this.barcode = barcode;
        this.type = type;
        this.merk = merk;
        this.ingekocht = ingekocht;
        this.inkoopprijs = inkoopprijs;
        this.grVerloopt = grVerloopt;
        this.specs = specs;
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
     * @return the barcode
     */
    public String getBarcode() {
        return barcode;
    }

    /**
     * @param barcode the barcode to set
     */
    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the merk
     */
    public String getMerk() {
        return merk;
    }

    /**
     * @param merk the merk to set
     */
    public void setMerk(String merk) {
        this.merk = merk;
    }

    /**
     * @return the ingekocht
     */
    public String getIngekocht() {
        return ingekocht;
    }

    /**
     * @param ingekocht the ingekocht to set
     */
    public void setIngekocht(String ingekocht) {
        this.ingekocht = ingekocht;
    }

    /**
     * @return the verkocht
     */
    public String getVerkocht() {
        return verkocht;
    }

    /**
     * @param verkocht the verkocht to set
     */
    public void setVerkocht(String verkocht) {
        this.verkocht = verkocht;
    }

    /**
     * @return the specs
     */
    public String getSpecs() {
        return specs;
    }

    /**
     * @param specs the specs to set
     */
    public void setSpecs(String specs) {
        this.specs = specs;
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

    /**
     * @return the grVerloopt
     */
    public String getGrVerloopt() {
        return grVerloopt;
    }

    /**
     * @param grVerloopt the grVerloopt to set
     */
    public void setGrVerloopt(String grVerloopt) {
        this.grVerloopt = grVerloopt;
    }

    /**
     * @return the inkoopprijs
     */
    public double getInkoopprijs() {
        return inkoopprijs;
    }

    /**
     * @param inkoopprijs the inkoopprijs to set
     */
    public void setInkoopprijs(double inkoopprijs) {
        this.inkoopprijs = inkoopprijs;
    }

    /**
     * @return the verkoopprijs
     */
    public String getVerkoopprijs() {
        return verkoopprijs;
    }

    /**
     * @param verkoopprijs the verkoopprijs to set
     */
    public void setVerkoopprijs(String verkoopprijs) {
        this.verkoopprijs = verkoopprijs;
    }

    
    
    
}
