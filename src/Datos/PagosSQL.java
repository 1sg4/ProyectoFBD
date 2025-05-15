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

    public int insertar(String idPago, String idCliente, int cantBoletos, String metodoPago, int montoPagado)
    {
        try
        {
            // Establecer los parámetros en el PreparedStatement
            pstmt.setString(1, idPago);
            pstmt.setString(2, idCliente);
            pstmt.setInt(3, cantBoletos);
            pstmt.setString(4, metodoPago);
            pstmt.setInt(5, montoPagado);
            // Ejecutar la inserción
            int reg = pstmt.executeUpdate();
            return 1;
        } catch (SQLException ex)
        {
            ex.printStackTrace();
            return -1;
        }
    }
    
    public int eliminar()
}
