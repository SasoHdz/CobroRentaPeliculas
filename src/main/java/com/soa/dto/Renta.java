package com.soa.dto;

import com.google.gson.Gson;

/**
 * Clase que modela la informacion de un usuario.
 */
public class Renta {
    
    private String titulo;
    private Integer time;
    private String noTC;
    
    @Override
    public String toString() {
        Gson gson = new Gson();
        String json = gson.toJson(this);
        return json;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public String getNoTC() {
        return noTC;
    }

    public void setNoTC(String noTC) {
        this.noTC = noTC;
    }

   
    
  
}
