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
    private String naam;
    private String barcode;
    private String type;
    private String merk;
    private String ingekocht;
    private double inkoopprijsDouble;
    private String inkoopprijs;
    private String verkocht;
    private String verkoopDatum;
    private double verkoopprijsDouble;
    private String verkoopprijs;
    private String grVerloopt;
    private String specs;
    private String opmerking;
    private String klant;

    public InventoryList(String id, String naam, String barcode, String type, String merk, String ingekocht, double inkoopprijs, String verkoopDatum, double verkoopprijs, String grVerloopt, String specs, String opmerking, String klant) {
        this.id = id;
        this.naam = naam;
        this.barcode = barcode;
        this.type = type;
        this.merk = merk;
        this.ingekocht = ingekocht;
        this.inkoopprijsDouble = inkoopprijs;
        this.verkoopDatum = verkoopDatum;
        this.verkoopprijsDouble = verkoopprijs;
        this.grVerloopt = grVerloopt;
        this.specs = specs;
        this.opmerking = opmerking;
        this.klant = klant;
    }
    
    public InventoryList(String id, String naam, String barcode, String type, String merk, String ingekocht, double inkoopprijs, String grVerloopt, String specs, String opmerking) {
        this.id = id;
        this.naam = naam;
        this.barcode = barcode;
        this.type = type;
        this.merk = merk;
        this.ingekocht = ingekocht;
        this.inkoopprijsDouble = inkoopprijs;
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
    public String getInkoopprijs() {
        inkoopprijs = String.format("€" + "%.2f", inkoopprijsDouble);
        return inkoopprijs;
    }

    /**
     * @param inkoopprijs the inkoopprijs to set
     */
    public void setInkoopprijs(String inkoopprijs) {
        this.inkoopprijs = inkoopprijs;
    }

    /**
     * @return the verkoopprijs
     */
    public String getVerkoopprijs() {
        verkoopprijs = String.format("€" + "%.2f", verkoopprijsDouble);
        return verkoopprijs;
    }

    /**
     * @param verkoopprijs the verkoopprijs to set
     */
    public void setVerkoopprijs(String verkoopprijs) {
        this.verkoopprijs = verkoopprijs;
    }

    /**
     * @return the naam
     */
    public String getNaam() {
        return naam;
    }

    /**
     * @param naam the naam to set
     */
    public void setNaam(String naam) {
        this.naam = naam;
    }

    /**
     * @return the verkoopDatum
     */
    public String getVerkoopDatum() {
        return verkoopDatum;
    }

    /**
     * @param verkoopDatum the verkoopDatum to set
     */
    public void setVerkoopDatum(String verkoopDatum) {
        this.verkoopDatum = verkoopDatum;
    }

    /**
     * @return the klant
     */
    public String getKlant() {
        return klant;
    }

    /**
     * @param klant the klant to set
     */
    public void setKlant(String klant) {
        this.klant = klant;
    }

    /**
     * @return the inkoopprijsDouble
     */
    public double getInkoopprijsDouble() {
        return inkoopprijsDouble;
    }

    /**
     * @return the verkoopprijsDouble
     */
    public double getVerkoopprijsDouble() {
        return verkoopprijsDouble;
    }


    
    
    
}
