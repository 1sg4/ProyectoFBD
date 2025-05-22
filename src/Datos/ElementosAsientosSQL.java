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

    public int insertar(String idAsientoFuncion, String disponibilidad, String noBoleto)
    {
        try
        {
            // Establecer los parámetros en el PreparedStatement
            pstmt.setString(1, idAsientoFuncion);
            pstmt.setString(2, disponibilidad);
            pstmt.setString(3, noBoleto);
            // Ejecutar la inserción
            int reg = pstmt.executeUpdate();
            return 1;
        } catch (SQLException ex)
        {
            ex.printStackTrace();
            return -1;
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

    public int modificar(String idAsientoFuncion, String disponibilidad, String noBoleto)
    {
        try
        {
            pstmt.setString(1, idAsientoFuncion);
            pstmt.setString(2, disponibilidad);
            pstmt.setString(3, noBoleto);
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

    public ElementosAsientos buscar(String idAsientoFuncion)
    {
        try
        {
            pstmt.setString(1, idAsientoFuncion);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
            {
                String disponibilidad = rs.getString("disponibilidad");
                String noBoleto = rs.getString("noBoleto");
                return new ElementosAsientos(idAsientoFuncion,disponibilidad,noBoleto);
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

    public ArrayList<ElementosAsientos> listarEA()
    {
        ArrayList<ElementosAsientos> lista = new ArrayList<>();
        try
        {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                ElementosAsientos ea = new ElementosAsientos(rs.getString("idAsientoFuncion"), rs.getString("disponibilidad"),rs.getString("noBoleto"));
                lista.add(ea);
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return lista;
    }
}
