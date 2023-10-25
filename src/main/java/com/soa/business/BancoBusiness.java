/**
 * 
 */
package com.soa.business;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.soa.dao.BancoDao;
import com.soa.dto.CargoTarjeta;
import com.soa.dto.Respuesta;

/**
 * Clase para concatenación de datos personales.
 */
@Component
public class BancoBusiness {
    /** Objeto de acceso a datos. */
    @Autowired
    private BancoDao bancoDao;
    
    public Respuesta checkData(CargoTarjeta cargo) {

        Respuesta resp = new Respuesta();
        
         try {
             if(!bancoDao.find(cargo).getStatus()) {
                 resp.setMessage("Datos de tarjeta correctos");
                 resp.setStatus(true);
             } 
             else {
                 resp.setMessage("Datos de tarjeta incorrectos");
                 resp.setStatus(false);
                 
             }
         }catch(Exception e) {
             e.printStackTrace();
             resp.setStatus(false);
             resp.setMessage("500 Error en BD al consultar tarjeta: " +cargo.getNoTc());
         }
         
         return resp;
    }


    public Respuesta cargo(CargoTarjeta cargo) {
        
        Respuesta resp = new Respuesta();
        
        try {
            if(bancoDao.cargo(cargo).getStatus()) {
                resp.setMessage("Cargo a tarjeta "+cargo.getNoTc()+" correcto");
                resp.setStatus(true);
            } 
            else {
                resp.setMessage("Cargo a tarjeta "+cargo.getNoTc()+" incorrecto");
                resp.setStatus(false);
                
            }
        }catch(Exception e) {
            e.printStackTrace();
            resp.setStatus(false);
            resp.setMessage("500 Error en BD hacer UPDATE a tarjeta: " +cargo.getNoTc());
        }
        
        return resp;
        
    }
   
}
