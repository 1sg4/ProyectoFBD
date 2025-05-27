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
public class ClientesSQL
{

    PreparedStatement pstmt;

    public ClientesSQL(PreparedStatement pstmt)
    {
        this.pstmt = pstmt;
    }

    public void insertar(String idCliente, String idCine, String correoElectronico, long telefono, String nombre, String primerApellido, String segundoApellido) throws SQLException
    {
        try
        {
            pstmt.setString(1, idCliente);
            pstmt.setString(7, idCine);
            pstmt.setString(2, correoElectronico);
            pstmt.setLong(3, telefono);
            pstmt.setString(4, nombre);
            pstmt.setString(5, primerApellido);
            pstmt.setString(6, segundoApellido);
            int reg = pstmt.executeUpdate();
        } catch (SQLException ex)
        {
            
            System.out.println("java.sql.SQLIntegrityConstraintViolationException: " + ex.getMessage());
        }

    }
}
