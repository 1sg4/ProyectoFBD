/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author santi
 */
public class Conexion
{
    private static Connection con;
    static String url = "jdbc:oracle:thin:@//25.50.80.247:1521/xepdb1";
    static String usuario = "equipoFBD";
    static String contraseña = "10714223";

    // Método para establecer conexión
    public static boolean conectar()
    {
        boolean b = false;
        try
        {
            if (con == null || con.isClosed())
            {
                con = DriverManager.getConnection(url, usuario, contraseña);
                System.out.println("Conexion establecida");
                b = true;
            }
        } catch (SQLException ex)
        {
            b = false;
            System.out.println("error en la conexion");
        }
        return b;
    }

    public static PreparedStatement creaConsulta(Connection con, String sql)
    {
        try
        {
            return con.prepareStatement(sql);

        } catch (SQLException e)
        {
            System.out.println("error al crear consulta" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

    // Método para crear consultas preparadas
    public static PreparedStatement creaConsultagenerada(Connection con, String sql)
    {
        try
        {
            // Crear PreparedStatement con el parámetro Statement.RETURN_GENERATED_KEYS
            return con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);  // Importante: esto permite obtener las claves generadas

        } catch (SQLException e)
        {
            System.err.println("Error al crear PreparedStatement: " + e.getMessage());
            e.printStackTrace();
            return null;  // Si hubo un error, devolvemos null
        }
    }

    // Método para cerrar conexión (IMPORTANTE)
    public static void desconectar()
    {
        try
        {
            if (con != null && !con.isClosed())
            {
                con.close();
                System.out.println("Conexión cerrada");
            }
        } catch (SQLException ex)
        {
            System.err.println("Error al cerrar conexión: " + ex.getMessage());
        }
    }

    // Método para obtener la conexión actual (útil para transacciones)
    public static Connection getConnection() throws SQLException
    {
        try
        {
            if (con == null || con.isClosed())
            {
                con = DriverManager.getConnection(url, usuario, contraseña);
            }
            return con; // Retorna directamente la Connection
        } catch (SQLException ex)
        {
            System.err.println("Error al conectar: " + ex.getMessage());
            return null;
        }
    }
}

