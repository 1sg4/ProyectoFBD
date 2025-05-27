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
            pstmt.setString(1, idFuncion);
            pstmt.setString(2, cvePelicula);
            pstmt.setString(3, idCineSalas);
            pstmt.setDate(4, (java.sql.Date) fecha);
            pstmt.setString(5, hora);
            int reg = pstmt.executeUpdate();
        } catch (SQLException ex)
        {
            System.out.println("java.sql.SQLIntegrityConstraintViolationException: " + ex.getMessage());
        }
    }
}
