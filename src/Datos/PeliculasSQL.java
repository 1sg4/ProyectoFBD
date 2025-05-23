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
public class PeliculasSQL
{

    PreparedStatement pstmt;

    public PeliculasSQL(PreparedStatement pstmt)
    {
        this.pstmt = pstmt;
    }

    public void insertar(String idCliente, String idCine, String correoElectronico, long telefono, String nombre, String primerApellido, String segundoApellido)
    {
        try
        {
            // Establecer los parámetros en el PreparedStatement
            pstmt.setString(1, idCliente);
            pstmt.setString(7, idCine);
            pstmt.setString(2, correoElectronico);
            pstmt.setLong(3, telefono);
            pstmt.setString(4, nombre);
            pstmt.setString(5, primerApellido);
            pstmt.setString(6, segundoApellido);
            // Ejecutar la inserción
            int reg = pstmt.executeUpdate();
        } catch (SQLException ex)
        {
            
            System.out.println("java.sql.SQLIntegrityConstraintViolationException: " + ex.getMessage());
        }

    }

    public int eliminar(String correoElectronico)
    {
        try
        {
            pstmt.setString(1, correoElectronico);
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

    public int modificar(String idCliente, String idCine, String correoElectronico, long telefono, String nombre, String primerApellido, String segundoApellido)
    {
        try
        {
            pstmt.setString(1, idCliente);
            pstmt.setString(2, idCine);
            pstmt.setString(3, correoElectronico);
            pstmt.setLong(4, telefono);
            pstmt.setString(5, nombre);
            pstmt.setString(6, primerApellido);
            pstmt.setString(7, segundoApellido);
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
            return -1;
        }
    }

    public Clientes buscar(String correoElectronico)
    {
        try
        {
            pstmt.setString(1, correoElectronico);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
            {
                String idCliente = rs.getString("idCliente");
                String idCine = rs.getString("idCine");
                int telefono = rs.getInt("telefono");
                String nombre = rs.getString("nombre");
                String primerApellido = rs.getString("primerApellido");
                String segundoApellido = rs.getString("segundoApellido");
                return new Clientes(idCliente, idCine, correoElectronico, telefono, nombre, primerApellido, segundoApellido);
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

    public ArrayList<Clientes> listarC()
    {
        ArrayList<Clientes> lista = new ArrayList<>();
        try
        {
            ResultSet rs = pstmt.executeQuery();
            while (rs.next())
            {
                Clientes c = new Clientes(rs.getString("idCliente"), rs.getString("idCine"), rs.getString("correoElectronico"), rs.getInt("telefono"), rs.getString("nombre"), rs.getString("primerApellido"), rs.getString("segundoApellido"));
                lista.add(c);
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return lista;
    }

    public String generarNuevoID()
    {
        try
        {
            ResultSet rs = pstmt.executeQuery();
            if (rs.next())
            {
                String ultimoID = rs.getString("ULTIMO_ID");

                if (ultimoID == null)
                {
                    return "C00000001"; // Primer cliente
                } else
                {
                    int numero = Integer.parseInt(ultimoID.substring(1));
                    numero++;
                    return String.format("C%08d", numero);
                }
            }
        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

}
