/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author santi
 */
public class PeliculasSQL
{

 private PreparedStatement pstmt;
    private Connection conn;


    // Constructor que recibe una conexión y prepara el statement para la inserción
    public PeliculasSQL(Connection conn) {
        this.conn = conn;
        try {
            // Consulta SQL para la inserción de una película
            String sqlInsert = "INSERT INTO PELICULA (CVE_PELICULA, NOMBRE_PELICULA, FECHA_ESTRENO, ID_IDIOMA, ID_CLASIFICACION, SUBTITULOS, DURACION, SIPNOSIS, REPARTO, TRAILER, FOTO_REPRESENTATIVA) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            // Se prepara el statement de inserción
            this.pstmt = conn.prepareStatement(sqlInsert);
        } catch (SQLException ex) {
            System.err.println("Error al preparar el statement de inserción: " + ex.getMessage());
        }
    }

    public void insertar(String cvePelicula, String nombrePelicula, String fechaEstreno, String idIdioma, String idClasificacion, String subtitulos, String duracion, String sipnosis, String reparto, String trailer, String fotoRepresentativa) throws FileNotFoundException
    {
        FileInputStream trailerBD= null;
        FileInputStream fotoBD= null;
        try
        {
            // Establecer los parámetros en el PreparedStatement
            pstmt.setString(1, cvePelicula);
            pstmt.setString(2, nombrePelicula);
            pstmt.setString(3, fechaEstreno);
            pstmt.setString(4, idIdioma);
            pstmt.setString(5, idClasificacion);
            pstmt.setString(6, subtitulos);
            pstmt.setString(7, duracion);
            pstmt.setString(8, sipnosis);
            pstmt.setString(9, reparto);

            // Ejecutar la inserción
            File fileTrailer = new File(trailer);
            if (!fileTrailer.exists()) {
                System.err.println("El archivo del trailer no existe: " + trailer);
                return;
            }
            trailerBD = new FileInputStream(fileTrailer);
            pstmt.setBinaryStream(10, trailerBD, (int) fileTrailer.length());
            
            // Procesar el archivo de la foto (imagen)
            File fileFoto = new File(fotoRepresentativa);
            if (!fileFoto.exists()) {
                System.err.println("El archivo de la foto no existe: " + fotoRepresentativa);
                return;
            }
           fotoBD = new FileInputStream(fileFoto);
            pstmt.setBinaryStream(11, fotoBD, (int) fileFoto.length());
            
            // Ejecutar la inserción
            int reg = pstmt.executeUpdate();
            if (reg > 0) {
                System.out.println("El registro se insertó correctamente.");
            } else {
                System.out.println("No se pudo insertar el registro.");
            }
        } catch (SQLException ex) {
            System.out.println("java.sql.SQLIntegrityConstraintViolationException: " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            System.err.println("Archivo no encontrado: " + ex.getMessage());
        }finally {
            try {
                if (trailerBD != null) {
                    trailerBD.close();
                }
                if (fotoBD != null) {
                    fotoBD.close();
                }
            } catch (IOException e) {
                System.err.println("Error al cerrar los streams: " + e.getMessage());
            }
        }

    }

    public int eliminar(String cvePelicula)
    {
        try
        {
            pstmt.setString(1, cvePelicula);
            int reg = pstmt.executeUpdate();
            if (reg > 0)
            {
                return 0;
            } else
            {
                return 1;
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace();
            return -1;
        }
    }

    public int modificar(String cvePelicula, String nombrePelicula, String fechaEstreno, String idIdioma, String idClasificacion, String subtitulos, String duracion, String sipnosis, String reparto, String trailer, String fotoRepresentativa)
    {
        try
        {
            pstmt.setString(1, cvePelicula);
            pstmt.setString(2, nombrePelicula);
            pstmt.setString(3, fechaEstreno);
            pstmt.setString(4, idIdioma);
            pstmt.setString(5, idClasificacion);
            pstmt.setString(6, subtitulos);
            pstmt.setString(7, duracion);
            pstmt.setString(8, sipnosis);
            pstmt.setString(9, reparto);
            pstmt.setString(10, trailer);
            pstmt.setString(11, fotoRepresentativa);
            int reg = pstmt.executeUpdate();
            if (reg > 0)
            {
                return 0;
            } else
            {
                return 1;
            }
        } catch (SQLException ex)
        {
            return -1;
        }
    }

    public Peliculas buscar(String cvePelicula)
    {
        try
        {
            pstmt.setString(1, cvePelicula);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
            {
                String nombrePelicula = rs.getString("nombrePelicula");
                String fechaEstreno = rs.getString("fechaEstreno");
                String idIdioma = rs.getString("idIdioma");
                String idClasificacion = rs.getString("idClasificacion");
                String subtitulos = rs.getString("subtitulos");
                String duracion = rs.getString("duracion");
                String sipnosis = rs.getString("sipnosis");
                String reparto = rs.getString("repparto");
                String trailer = rs.getString("trailer");
                String fotoRepresentativa = rs.getString("fotoRepresentativa");
                return new Peliculas(cvePelicula, nombrePelicula, fechaEstreno, idIdioma,idClasificacion, subtitulos, duracion, sipnosis, reparto, trailer, fotoRepresentativa);
            } else
            {
                return null;
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<Peliculas> listarP()
    {
        ArrayList<Peliculas> lista = new ArrayList<>();
        try
        {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                Peliculas p = new Peliculas(rs.getString("cvePelicula"), rs.getString("nombrePelicula"), rs.getString("fechaEstreno"), rs.getString("idIdioma"), rs.getString("idClasificaion"), rs.getString("subtitulos"), rs.getString("duracion"), rs.getString("sipnosis"), rs.getString("reparto"),rs.getString("trailer"),rs.getString("fotoRepresentativa"));
                lista.add(p);
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return lista;
    }

    public String generarNuevoCve()
    {
        try
        {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
            {
                String ultimoID = rs.getString("ULTIMO_ID");

                if (ultimoID == null)
                {
                    return "C00000001"; // Primer cliente
                } else
                {
                    int numero = Integer.parseInt(ultimoID.substring(1));
                    numero++;
                    return String.format("C%08d", numero);
                }
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

}
