package com.soa.dto;

import com.google.gson.Gson;

/**
 * Clase que modela la informacion de un usuario.
 */
public class CargoTarjeta {
    
    private String noTC;
    private String cvv;
    private String fechaExp;
    private Float costoRenta;
    
    public CargoTarjeta(String noTC, String cvv, String fechaExp, Float costoRenta) {
        super();
        this.noTC = noTC;
        this.cvv = cvv;
        this.fechaExp = fechaExp;
        this.costoRenta = costoRenta;
    }
    
    public CargoTarjeta() {}
    
    public String getNoTc() {
        return noTC;
    }
    public void setNoTc(String noTc) {
        this.noTC = noTc;
    }
    public String getCvv() {
        return cvv;
    }
    public void setCvv(String cvv) {
        this.cvv = cvv;
    }
    public String getFechaExp() {
        return fechaExp;
    }
    public void setFechaExp(String fechaExp) {
        this.fechaExp = fechaExp;
    }
    public Float getCostoRenta() {
        return costoRenta;
    }
    public void setCostoRenta(Float costoRenta) {
        this.costoRenta = costoRenta;
    }
    
    @Override
    public String toString() {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }
}
