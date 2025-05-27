/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

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
public class PagosSQL
{

    PreparedStatement pstmt;

    public PagosSQL(PreparedStatement pstmt)
    {
        this.pstmt = pstmt;
    }

    public boolean insertar(String idPago, String idCliente, String metodoPago, double montoPagado)throws SQLException
    {
        try
        {
            pstmt.setString(1, idPago);
            pstmt.setString(2, metodoPago);
            pstmt.setDouble(3, montoPagado);
            pstmt.setString(4, idCliente);
            int reg = pstmt.executeUpdate();
            return reg>0;
        } catch (SQLException ex)
        {
            System.out.println("java.sql.SQLIntegrityConstraintViolationException: " + ex.getMessage());
             return false;
        }
    }
}
