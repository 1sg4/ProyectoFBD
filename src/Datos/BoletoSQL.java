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
public class BoletoSQL
{
    PreparedStatement pstmt;

    public BoletoSQL(PreparedStatement pstmt)
    {
        this.pstmt = pstmt;
    }
    public int insertar (String noBoleto, String idPago, String idAsientoFuncion, String cvePromocion, String tipoBoleto, Date fechaCompra, int precioFinal)
    {
        try
        {
            // Establecer los parámetros en el PreparedStatement
            pstmt.setString(1, noBoleto);
            pstmt.setString(2, idPago);
            pstmt.setString(3, idAsientoFuncion);
            pstmt.setString(4, cvePromocion);
            pstmt.setString(5, tipoBoleto);
            pstmt.setDate(6, fechaCompra);
            pstmt.setInt(7,precioFinal);
            // Ejecutar la inserción
            int reg = pstmt.executeUpdate();
            return 1;
        } catch (SQLException ex)
        {
            ex.printStackTrace();
            return -1;
        }
    }
//     public int eliminar(String noBoleto)
//    {
//        try
//        {
//            pstmt.setString(1, noBoleto);
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
//    public int modificar(String noBoleto, String idPago, String idAsientoFuncion, String cvePromocion, String tipoBoleto, Date fechaCompra, int precioFinal)
//    {
//        try
//        {
//            pstmt.setString(1, noBoleto);
//            pstmt.setString(2, idPago);
//            pstmt.setString(3, idAsientoFuncion);
//            pstmt.setString(4, cvePromocion);
//            pstmt.setString(5, tipoBoleto);
//            pstmt.setDate(6, fechaCompra);
//            pstmt.setInt(7,precioFinal);
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
//    public Boletos buscar(String noBoleto)
//    {
//        try
//        {
//            pstmt.setString(1, noBoleto);
//            ResultSet rs = pstmt.executeQuery();
//            if (rs.next())
//            {
//                String idPago = rs.getString("idPago");
//                String idAsientoFuncion = rs.getString("idAsientoFuncion");
//                String cvePromocion = rs.getString("cvePromocion");
//                String tipoBoleto = rs.getString("tipoBoleto");
//                Date fechaCompra = rs.getDate("fechaCompra");
//                int precioFinal=rs.getInt("precioFinal");
//                return new Boletos(noBoleto,idPago,idAsientoFuncion,cvePromocion,tipoBoleto,fechaCompra,precioFinal);
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

    public ArrayList<Boletos> listarB()
    {
        ArrayList<Boletos> lista = new ArrayList<>();
        try
        {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                Boletos b = new Boletos(rs.getString("noBoleto"), rs.getString("idPago"), rs.getString("idAsientoFuncion"), rs.getString("cvePromocion"),rs.getString("cvePromocion"),rs.getDate("fechaCompra"),rs.getInt("precioFinal"));
                lista.add(b);
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return lista;
    }

}
