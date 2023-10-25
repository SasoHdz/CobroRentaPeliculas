/**
 * 
 */
package com.soa.jms;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.soa.business.BancoBusiness;
import com.soa.dto.CargoTarjeta;
import com.soa.dto.DatosRenta;
import com.soa.dto.Respuesta;

/**
 * Class for receiving messages in an artemis queue.
 */
@Component
public class ArtemisListenerCheckTarjet {
    @Autowired
    private BancoBusiness business;

    @Autowired
    private JmsSender sender;

    /** Nombre de la cola de respuesta del microservicio. */
    @Value("${cargo.queue.name.in}")
    private String outQueueName;

    @JmsListener(destination = "${tarjeta.queue.name.in}")
    public void receive(String message) {
        System.out.println(String.format("Received message: %s",
                message));
        Gson gson = new Gson();
        DatosRenta data = gson.fromJson(message, DatosRenta.class);
        CargoTarjeta cargo = new CargoTarjeta(data.getTarjeta(), data.getCvv(), data.getFechaExp(),data.getCostoRenta());
        Respuesta respuesta = business.checkData(cargo);
        System.out.println("Resultado de consulta: "+respuesta);
        try {
            sender.sendMessage(data.toString(), outQueueName); //Pasa mensaje a siguiente cola
            System.out.println(String.format("Mensaje enviado: %s", 
                    respuesta.toString()));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
