/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ej;

/**
 *
 * @author santi
 */
import java.sql.*;

public class ConexionEj
{
    public static void main(String[] args)
    {
        String url = "jdbc:oracle:thin:@//25.50.80.247:1521/xepdb1";
        String usuario = "equipoFBD";
        String contraseña = "10714223";

        try (Connection conexion = DriverManager.getConnection(url, usuario, contraseña))
        {
            System.out.println("Conexión exitosa a Oracle");
<<<<<<< HEAD
            System.out.println("Jonathan");
=======
            System.out.println("xd");
>>>>>>> 275d1a534485bd05f10b863283e64f851546b3b7
        } catch (SQLException e)
        {
            System.out.println("Error al conectar: " + e.getMessage());
        }
    }
}

