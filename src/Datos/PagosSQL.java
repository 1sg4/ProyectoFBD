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
            pstmt.setString(5, idCliente);
            pstmt.setInt(2, cantBoletos);
            pstmt.setString(3, metodoPago);
            pstmt.setInt(4, montoPagado);
            // Ejecutar la inserción
            int reg = pstmt.executeUpdate();
            return 1;
        } catch (SQLException ex)
        {
            ex.printStackTrace();
            return -1;
        }
    }
//    public int eliminar(String idPago)
//    {
//        try
//        {
//            pstmt.setString(1, idPago);
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
//
//    public int modificar(String idPago, String idCliente,int cantBoletos, String metodoPago, int montoPagado)
//    {
//        try
//        {
//            pstmt.setString(1, idPago);
//            pstmt.setString(2, idCliente);
//            pstmt.setInt(3, cantBoletos);
//            pstmt.setString(4, metodoPago);
//            pstmt.setInt(5, montoPagado);
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

//    public Pagos buscar(String idPago)
//    {
//        try
//        {
//            pstmt.setString(1, idPago);
//            ResultSet rs = pstmt.executeQuery();
//            if (rs.next())
//            {
//                String idCliente = rs.getString("idCliente");
//                int cantBoletos = rs.getInt("cantBoletos");
//                String metodoPago = rs.getString("metodoPago");
//                int montoPagado=rs.getInt("montoPagado");
//                return new Pagos(idPago,idCliente,cantBoletos,metodoPago,montoPagado);
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

    public ArrayList<Pagos> listarP()
    {
        ArrayList<Pagos> lista = new ArrayList<>();
        try
        {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                Pagos p = new Pagos(rs.getString("idPago"), rs.getString("idCliente"), rs.getInt("cantBoeltos"), rs.getString("metodoPago"),rs.getInt("montoPagado"));
                lista.add(p);
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return lista;
    }
}
