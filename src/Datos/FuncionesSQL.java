/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author santi
 */
public class FuncionesSQL
{
     PreparedStatement pstmt;

    public FuncionesSQL(PreparedStatement pstmt)
    {
        this.pstmt = pstmt;
    }

    public void insertar(String idFuncion, String cvePelicula, String idCineSalas, Date fecha, String hora)
    {
        try
        {
            // Establecer los parámetros en el PreparedStatement
            pstmt.setString(1, idFuncion);
            pstmt.setString(2, cvePelicula);
            pstmt.setString(3, idCineSalas);
            pstmt.setDate(4, (java.sql.Date) fecha);
            pstmt.setString(5, hora);
            // Ejecutar la inserción
            int reg = pstmt.executeUpdate();
        } catch (SQLException ex)
        {
            System.out.println("java.sql.SQLIntegrityConstraintViolationException: " + ex.getMessage());
        }
    }
    public int eliminar(String idFuncion)
    {
        try
        {
            pstmt.setString(1, idFuncion);
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

    public int modificar(String idFuncion, String cvePelicula, String idCineSalas, Date fecha, String hora)
    {
        try
        {
            pstmt.setString(1, idFuncion);
            pstmt.setString(2, cvePelicula);
            pstmt.setString(3, idCineSalas);
            pstmt.setDate(4, (java.sql.Date) fecha);
            pstmt.setString(5, hora);
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

//    public Funciones buscar(String idFuncion)
//    {
//        try
//        {
//            pstmt.setString(1, idFuncion);
//            ResultSet rs = pstmt.executeQuery();
//            if (rs.next())
//            {
//                String cvePelicula = rs.getString("cvePelicula");
//                String idCineSalas = rs.getString("idCineSalas");
//                Date fecha = rs.getDate("fecha");
//                String hora=rs.getString("hora");
//                return new Funciones(idFuncion,cvePelicula,idCineSalas,fecha,hora);
//            } else
//            {
//                return null;
//            }
//        } catch (SQLException ex)
//        {
//            ex.printStackTrace();
//            return null;
//        }
//    }

    public ArrayList<Funciones> listarF()
    {
        ArrayList<Funciones> lista = new ArrayList<>();
        try
        {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                Funciones f = new Funciones(rs.getString("idFuncion"), rs.getString("cvePelicula"), rs.getString("idCineSalas"), rs.getDate("fecha"),rs.getString("hora"));
                lista.add(f);
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return lista;
    }
}
