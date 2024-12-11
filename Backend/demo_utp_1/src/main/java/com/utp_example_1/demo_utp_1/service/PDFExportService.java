package com.utp_example_1.demo_utp_1.service;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.*;
import com.utp_example_1.demo_utp_1.entity.Envio;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class PDFExportService {

    public byte[] exportEnviosToPDF(List<Envio> envios) throws DocumentException {
        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {
            PdfWriter.getInstance(document, out);
            document.open();

            // Add title
            Font titleFont = new Font(Font.FontFamily.HELVETICA, 18, Font.BOLD);
            Paragraph title = new Paragraph("Reporte de Envíos", titleFont);
            title.setAlignment(Element.ALIGN_CENTER);
            document.add(title);
            document.add(new Paragraph(" ")); // Add some space

            // Create table
            PdfPTable table = new PdfPTable(6); // 6 columns
            table.setWidthPercentage(100);
            
            // Set column widths
            float[] columnWidths = {1f, 2f, 1.5f, 1.5f, 1.5f, 1f};
            table.setWidths(columnWidths);

            // Add headers
            Font headerFont = new Font(Font.FontFamily.HELVETICA, 12, Font.BOLD);
            String[] headers = {"ID Envío", "Nombre Remitente", "DNI Remitente", "Origen", "Destino", "Volumen"};
            for (String header : headers) {
                PdfPCell cell = new PdfPCell(new Phrase(header, headerFont));
                cell.setHorizontalAlignment(Element.ALIGN_CENTER);
                cell.setBackgroundColor(BaseColor.LIGHT_GRAY);
                cell.setPadding(5);
                table.addCell(cell);
            }

            // Add data
            Font dataFont = new Font(Font.FontFamily.HELVETICA, 10);
            for (Envio envio : envios) {
                table.addCell(new Phrase(String.valueOf(envio.getIdEnvio()), dataFont));
                table.addCell(new Phrase(envio.getNombreRemitente(), dataFont));
                table.addCell(new Phrase(envio.getDniRemitente(), dataFont));
                table.addCell(new Phrase(envio.getLugarEnvio(), dataFont));
                table.addCell(new Phrase(envio.getLugarDestino(), dataFont));
                table.addCell(new Phrase(String.valueOf(envio.getVolumen()), dataFont));
            }

            document.add(table);

        } finally {
            document.close();
        }

        return out.toByteArray();
    }
}
