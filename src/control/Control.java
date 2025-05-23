/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;


import Datos.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;

/**
 *
 * @author santi
 */
public class Control
{

    Connection conn;

//Metodos Boleto

    public void insertarB(String noBoleto, String idPago, String idAsientoFuncion, String cvePromocion, String tipoBoleto, Date fechaCompra, int precioFinal) throws SQLException
    {
        try
        {
            conn = Conexion.getConnection();
            String sql = "insert INTO BOLETOS (NO_BOLETO, ID_PAGO, ID_ASIENTO_FUNCION,CVE_PROMOCION,TIPO_BOLETO,FECHA_COMPRA,PRECIO_FINAL) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pstmt = Conexion.creaConsultagenerada(conn, sql);
            BoletoSQL insBol = new BoletoSQL(pstmt);
             insBol.insertar(noBoleto, idPago, idAsientoFuncion, cvePromocion, tipoBoleto, fechaCompra, precioFinal);

        } catch (SQLException ex)
        {
            System.out.println("java.sql.SQLIntegrityConstraintViolationException: " + ex.getMessage());
        }
    }

    //Metodos Clientes
    public void insertarC(String idCliente, String idCine, String correoElectronico, long telefono, String nombre, String primerApellido, String segundoApellido)throws SQLException
    {
        try
        {
            conn = Conexion.getConnection();
            String sql = "insert INTO CLIENTES (ID_CLIENTE, CORREO_ELECTRONICO, TELEFONO,NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,ID_CINE) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pstmt = Conexion.creaConsultagenerada(conn, sql);
            ClientesSQL insC = new ClientesSQL(pstmt);
             insC.insertar(idCliente, idCine, correoElectronico, telefono, nombre, primerApellido, segundoApellido);

        } catch (SQLException ex)
        {
            System.out.println("java.sql.SQLIntegrityConstraintViolationException: " + ex.getMessage());
        }
    }

    public String generarIDCliente()
    {
        String nuevoID = null;

        try
        {
            conn = Conexion.getConnection();
            String sql = "SELECT MAX(ID_CLIENTE) AS ULTIMO_ID FROM CLIENTES";
            PreparedStatement pstmt = Conexion.creaConsultagenerada(conn, sql);

            ClientesSQL consultaID = new ClientesSQL(pstmt);
            nuevoID = consultaID.generarNuevoID();

        } catch (SQLException ex)
        {
            ex.printStackTrace();
        }

        return nuevoID;
    }

    //Metodo ElementosAsientos
    public void insertarEA(String idAsientoFuncion, String disponibilidad, String noBoleto)throws SQLException
    {
        try
        {
            conn = Conexion.getConnection();
            String sql = "insert INTO ELEMENTOS_ASIENTOS (ID_ASIENTO_FUNCION, DISPONIBILIDAD, NO_BOLETO) VALUES (?,?,?)";
            PreparedStatement pstmt = Conexion.creaConsultagenerada(conn, sql);
            ElementosAsientosSQL insEA = new ElementosAsientosSQL(pstmt);
             insEA.insertar(idAsientoFuncion, disponibilidad, noBoleto);

        } catch (SQLException ex)
        {
            System.out.println("java.sql.SQLIntegrityConstraintViolationException: " + ex.getMessage());
        }
    }


    //Metodo Funciones
    public void insertarF(String idFuncion, String cvePelicula, String idCineSalas, java.util.Date fecha, String hora)throws SQLException
    {
        try
        {
            conn = Conexion.getConnection();
            String sql = "insert INTO FUNCIONES (ID_FUNCION, CVE_PELICULA, ID_CINE_SALAS,FECHA,HORA) VALUES (?,?,?,?,?)";
            PreparedStatement pstmt = Conexion.creaConsultagenerada(conn, sql);
            FuncionesSQL insF = new FuncionesSQL(pstmt);
             insF.insertar(idFuncion, cvePelicula, idCineSalas, fecha, hora);

        } catch (SQLException ex)
        {
            System.out.println("java.sql.SQLIntegrityConstraintViolationException: " + ex.getMessage());
        }
    }

    //Metodo Pagos
    public void insertarP(String idPago, String idCliente, int cantBoletos, String metodoPago, int montoPagado)throws SQLException
    {
        try
        {
            conn = Conexion.getConnection();
            String sql = "insert INTO PAGOS (ID_PAGO, CANT_BOLETOS, METODO_PAGO,MONTO_PAGADO,ID_CLIENTE) VALUES (?,?,?,?,?)";
            PreparedStatement pstmt = Conexion.creaConsultagenerada(conn, sql);
            PagosSQL insF = new PagosSQL(pstmt);
             insF.insertar(idPago, idCliente, cantBoletos, metodoPago, montoPagado);

        } catch (SQLException ex)
        {
            System.out.println("java.sql.SQLIntegrityConstraintViolationException: " + ex.getMessage());
        }
    }

    //Metodo cine
    //Meotodo Peliculas
    //No he buscado bien lo de insertar un video o imagen
    //Por lo tanto no he puesto nada de peliculas
    
    
    public ArrayList<Cines> leerTodosCines()
    {
        ArrayList<Cines> cines = new ArrayList<>();
        PreparedStatement selectStmt = null;
        ResultSet rs = null;
        try
        {
            conn = Conexion.getConnection();
            String readSQL = "SELECT * FROM cines";
            selectStmt = conn.prepareStatement(readSQL);
            rs = selectStmt.executeQuery(readSQL);
            while (rs.next())
            {
                String id = rs.getString("id_cine");
                String nomCine = rs.getString("nombre_cine");
                String idDir = rs.getString("id_direccion");
                Cines cn = new Cines(id, nomCine, idDir);
                cines.add(cn);
            }
        } catch (SQLException ex)
        {
            System.out.println(ex.getMessage());
            System.out.println("Failed to establish a connection with the DB");
        } finally
        {
            try
            {
                if (rs != null) rs.close();
                if (selectStmt != null) selectStmt.close();
            } catch (SQLException ex)
            {
                System.out.println(ex.getMessage());
            }
        }
        return cines;
    }
    
}
