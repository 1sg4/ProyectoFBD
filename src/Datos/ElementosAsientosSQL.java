/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author santi
 */
public class ElementosAsientosSQL
{
     PreparedStatement pstmt;

    public ElementosAsientosSQL(PreparedStatement pstmt)
    {
        this.pstmt = pstmt;
    }

    public void insertar(String idAsientoFuncion, String idFuncion,String noAsiento,String disponibilidad, String noBoleto) throws SQLException
    {
        try
        {
            pstmt.setString(1, idAsientoFuncion);
            pstmt.setString(2, idFuncion);
            pstmt.setString(3, noAsiento);
            pstmt.setString(4, disponibilidad);
            pstmt.setString(5, noBoleto);
            int reg = pstmt.executeUpdate();
        } catch (SQLException ex)
        {
            System.out.println("java.sql.SQLIntegrityConstraintViolationException: " + ex.getMessage());
        }
    }
    public boolean modificar(String idAsientoFuncion, String disponibilidad,String noBoleto) throws SQLException
    {
        try
        {
            System.out.println("dentro de modificar");
            pstmt.setString(1, disponibilidad);
            pstmt.setString(2, noBoleto);
            pstmt.setString(3,idAsientoFuncion);
            System.out.println("EJECUTANDO UPDATE CON: ");
            System.out.println("ID ASIENTO FUNCION: "+idAsientoFuncion);
            System.out.println("DISPONIBILIDAD: "+disponibilidad);
            System.out.println("NOBOLETO: "+noBoleto);
            int reg = pstmt.executeUpdate();
            System.out.println("Filas modificadas: "+reg);
            return true;
        } catch (SQLException ex)
        {
            System.out.println("VTNEAjava.sql.SQLIntegrityConstraintViolationException: " + ex.getMessage());
             return false;
        }
    }

}
