package com.utp_example_1.demo_utp_1.service;

import com.utp_example_1.demo_utp_1.entity.Envio;
import com.utp_example_1.demo_utp_1.interfaces.EnvioRepository;
import net.*;
import net.sf.jasperreports.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.ErrorManager;

@Service
public class EnvioService {

    @Autowired
    private EnvioRepository envioRepository;

    public void eliminarEnvio(Long id) {
        envioRepository.deleteById(id); // Elimina el envio usando el repositorio
    }

    public byte[] generarpdf(Long id) throws SQLException {
        byte[] bytes = null;

        try {
            if (id == null) {
                throw new IllegalArgumentException("El ID no puede ser nulo");
            }

            Envio envio = envioRepository.findById(id).orElseThrow(() -> new RuntimeException("Envio no encontrado"));

            Map<String, Object> parameter = new HashMap<>();
            parameter.put("nombre_re", envio.getNombreRemitente());
            parameter.put("lugar_en", envio.getLugarEnvio());
            parameter.put("lugar_de", envio.getLugarDestino());

            URL imageUrl = getClass().getClassLoader().getResource("static/Imagenes/logo_prueba.png");
            if (imageUrl == null) {
                throw new IllegalArgumentException("El archivo de imagen no se encuentra en el directorio de recursos.");
            }
            String imagePath = imageUrl.getPath();
            parameter.put("logo_image", imagePath);

            URL jasperUrl = getClass().getClassLoader().getResource("static/reports/RECIBO.jrxml");
            if (jasperUrl == null) {
                throw new IllegalArgumentException("El archivo Jasper no se encuentra en el directorio de recursos.");
            }
            String jasperPath = jasperUrl.getPath();
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperPath);
	        bytes = JasperRunManager.runReportToPdf(jasperReport, parameter, new JREmptyDataSource());

        } catch (JRException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        return bytes;
    }

}
