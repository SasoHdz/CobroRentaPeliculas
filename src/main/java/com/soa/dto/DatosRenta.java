package com.soa.dto;

import com.google.gson.Gson;

/**
 * Clase que modela la informacion de un usuario.
 */
public class DatosRenta {
    
    private String correo;
    private String tarjeta;
    private String cvv;
    private String fechaExp;
    private String titulo;
    private Integer tiempo;
    private Float costoRenta; 
    private Boolean status;

    
  
    @Override
    public String toString() {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }


    public String getCorreo() {
        return correo;
    }


    public void setCorreo(String correo) {
        this.correo = correo;
    }


    public String getTarjeta() {
        return tarjeta;
    }


    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
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


    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public Integer getTiempo() {
        return tiempo;
    }


    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }


    public Float getCostoRenta() {
        return costoRenta;
    }


    public void setCostoRenta(Float costoRenta) {
        this.costoRenta = costoRenta;
    }


    public Boolean getStatus() {
        return status;
    }


    public void setStatus(Boolean status) {
        this.status = status;
    }
    
    
}
