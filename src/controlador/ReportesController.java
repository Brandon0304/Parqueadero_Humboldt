package controlador;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import conexion.Conexion;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author ortiz
 */
public class ReportesController {

    //metodo para crear el ticket
    public void TicketRetiro(int idVehiculo) {

        Document documento = new Document();
        try {

            String ruta = System.getProperty("user.home");
            PdfWriter.getInstance(documento, new FileOutputStream(ruta + "/Desktop/Ticket Parqueadero.pdf"));
            Image header = Image.getInstance("src/img/logo2universidad.jpg");
            header.scaleToFit(100, 1000);
            header.setAlignment(Chunk.ALIGN_CENTER);

            try {
                Connection cn = Conexion.conectar();
                PreparedStatement pst = cn.prepareStatement(
                        "select * from tb_vehiculo where id_vehiculo = '" + idVehiculo + "';");
                ResultSet rs = pst.executeQuery();

                if (rs.next()) {
                    Paragraph parrafo = new Paragraph();
                    parrafo.setAlignment(Paragraph.ALIGN_CENTER);
                    parrafo.add("Parqueadero Von Humboldt \n ® Innova Software\n\n");
                    parrafo.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.DARK_GRAY));
                    parrafo.add("______________________________________________________\n\n");
                    Timestamp timestamp = rs.getTimestamp("hora_salida");
                    Date fecha = new Date(timestamp.getTime());
                    parrafo.add("Ticket de Retiro de " + rs.getString("tipo_vehiculo") + " - (Placa: " + rs.getString("placa") + ")\n\n");
                    parrafo.add(fecha + "\n");
                    parrafo.add("______________________________________________________\n\n");

                    Paragraph contenido = new Paragraph();
                    contenido.setAlignment(Paragraph.ALIGN_CENTER);
                    contenido.add("Propietario: " + rs.getString("propietario") + "\n");

                    Timestamp timestampEntrada = rs.getTimestamp("hora_entrada");
                    Time horaEntrada = new Time(timestampEntrada.getTime());
                    contenido.add("Entrada: " + horaEntrada + "\n");

                    Timestamp timestampSalida = rs.getTimestamp("hora_salida");
                    Time horaSalida = new Time(timestampSalida.getTime());
                    contenido.add("Salida: " + horaSalida + "\n");

                    contenido.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.RED));
                    contenido.add("\nValor Pagado: $" + rs.getString("Valor_pagado") + "\n");
                    contenido.setFont(FontFactory.getFont("Tahoma", 16, Font.BOLD, BaseColor.DARK_GRAY));
                    parrafo.add("______________________________________________________\n\n");

                    documento.open();
                    //agregar datos
                    documento.add(header);
                    documento.add(parrafo);
                    documento.add(contenido);
                }

            } catch (SQLException e) {
                System.out.println("Error 1 en: " + e);

            }
            documento.close();
            JOptionPane.showMessageDialog(null, "Ticket Creado");

        } catch (DocumentException e) {
            System.out.println("Error 2 en: " + e);

        } catch (FileNotFoundException ex) {
            System.out.println("Error 3 en: " + ex);

        } catch (IOException ex) {
            System.out.println("Error 4 en: " + ex);

        }

    }

}
