/**
 * 
 */
package com.soa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.soa.dto.CargoTarjeta;
import com.soa.dto.Respuesta;
import com.soa.dto.Tarjeta;

/**
 * Capa de acceso a datos.
 */
@Repository
public class BancoDao {

    /**
     * Objeto especializado en acceso a la BD.
     */
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    /**
     * Verifica que la tarjeta, cvv, fechaExp existen y coinciden los datos
     * @param usuario
     * @return
     */
    public Respuesta find(CargoTarjeta cargo) {
      Respuesta resp = new Respuesta();
      List<Tarjeta> tarjetas = jdbcTemplate.query(
       "SELECT noTC, cvv, fechaExp, saldo FROM Tarjetas WHERE noTC = '" + cargo.getNoTc() + 
       "' AND cvv = "+cargo.getCvv()+" AND fechaExp = '"+cargo.getFechaExp()+"'", 
       new BeanPropertyRowMapper<Tarjeta>(Tarjeta.class));
       resp.setStatus(true);
       
       if(tarjetas.size()==1) {
           if(tarjetas.get(0).getSaldo()>=cargo.getCostoRenta()) {
               resp.setStatus(true);
               resp.setMessage("Datos correctos y saldo suficiente");
           }
           else {
               resp.setStatus(false);
               resp.setMessage("Saldo no suficiente");
           }
       }
       else {
           resp.setStatus(false);
           resp.setMessage("Datos incorrectos");
       }
      
       return resp;
    }
    
    public Respuesta cargo(CargoTarjeta cargo) {
        String sql = "UPDATE Tarjetas SET saldo = saldo - ? WHERE noTC = ?";
        int filasAfectadas = jdbcTemplate.update(sql, cargo.getCostoRenta(), cargo.getNoTc());
        
        if (filasAfectadas > 0) {
            return new Respuesta("Cargo exitoso", true);
        } else {
            return new Respuesta("No se pudo realizar el cargo", false);
        }
    }
    
}
