/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author santi
 */
public class BoletosSQL
{
    PreparedStatement pstmt;

    public BoletosSQL(PreparedStatement pstmt)
    {
        this.pstmt = pstmt;
    }
    public boolean insertar (String noBoleto, String idPago, String idAsientoFuncion, String cvePromocion, String tipoBoleto, Date fechaCompra, double precioFinal) throws  SQLException
    {
        try
        {
            pstmt.setString(1, noBoleto);
            pstmt.setString(2, idPago);
            pstmt.setString(3, idAsientoFuncion);
            pstmt.setString(4, cvePromocion);
            pstmt.setString(5, tipoBoleto);
            pstmt.setDate(6, fechaCompra);
            pstmt.setDouble(7,precioFinal);
            int reg = pstmt.executeUpdate();
            return true;
        } catch (SQLException ex)
        {
            System.out.println("java.sql.SQLIntegrityConstraintViolationException: " + ex.getMessage());

             return false;
        }
    }
}
