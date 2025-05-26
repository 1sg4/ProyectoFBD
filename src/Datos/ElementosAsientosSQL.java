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
            // Establecer los parámetros en el PreparedStatement
            pstmt.setString(1, idAsientoFuncion);
            pstmt.setString(2, idFuncion);
            pstmt.setString(3, noAsiento);
            pstmt.setString(4, disponibilidad);
            pstmt.setString(5, noBoleto);
            // Ejecutar la inserción
            int reg = pstmt.executeUpdate();
        } catch (SQLException ex)
        {
            System.out.println("java.sql.SQLIntegrityConstraintViolationException: " + ex.getMessage());
        }
    }
//    public int eliminar(String idAsientoFuncion)
//    {
//        try
//        {
//            pstmt.setString(1, idAsientoFuncion);
//            int reg = pstmt.executeUpdate();
//            if (reg > 0)
//            {
//                return 0;
//            } else
//            {
//                return 1;
//            }
//        } catch (SQLException ex)
//        {
//            ex.printStackTrace();
//            return -1;
//        }
//    }

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
//            pstmt.setQueryTimeout(10);
            int reg = pstmt.executeUpdate();
            System.out.println("Filas modificadas: "+reg);
            return reg>0;
        } catch (SQLException ex)
        {
            System.out.println("java.sql.SQLIntegrityConstraintViolationException: " + ex.getMessage());
             ex.printStackTrace();
             return false;
        }
    }

    public ElementosAsientos buscar(String idAsientoFuncion)
    {
        try
        {
            pstmt.setString(1, idAsientoFuncion);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
            {
                String idFuncion = rs.getString("idFuncion");
                String noAsiento=rs.getString("noAsiento");
                String disponibilidad = rs.getString("disponibilidad");
                String noBoleto = rs.getString("noBoleto");
                return new ElementosAsientos(idAsientoFuncion,idFuncion,noAsiento,disponibilidad,noBoleto);
            } else
            {
                return null;
            }
        } catch (SQLException ex)
        {
            System.out.println("java.sql.SQLIntegrityConstraintViolationException: " + ex.getMessage());
            return null;
        }
    }

    public ArrayList<ElementosAsientos> listarEA()
    {
        ArrayList<ElementosAsientos> lista = new ArrayList<>();
        try
        {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                ElementosAsientos ea = new ElementosAsientos(rs.getString("idAsientoFuncion"),rs.getString("idFuncion"),rs.getString("noAsiento"), rs.getString("disponibilidad"),rs.getString("noBoleto"));
                lista.add(ea);
            }
        } catch (SQLException ex)
        {
           System.out.println("java.sql.SQLIntegrityConstraintViolationException: " + ex.getMessage());
        }
        return lista;
    }
}
