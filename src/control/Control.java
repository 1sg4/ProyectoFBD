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
import Datos.Conexion;

/**
 *
 * @author santi
 */
public class Control
{

    Connection conn;

//Metodos Boleto

    public boolean insertarB(Connection conn,String noBoleto, String idPago, String idAsientoFuncion, String cvePromocion, String tipoBoleto, Date fechaCompra, double precioFinal) throws SQLException
    {
        try{
            String sql = "insert INTO BOLETOS (NO_BOLETO, ID_PAGO, ID_ASIENTO_FUNCION,CVE_PROMOCION,TIPO_BOLETO,FECHA_COMPRA,PRECIO_FINAL) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pstmt = Conexion.creaConsultagenerada(conn, sql);
            BoletosSQL insBol = new BoletosSQL(pstmt);
             return insBol.insertar(noBoleto, idPago, idAsientoFuncion, cvePromocion, tipoBoleto, fechaCompra, precioFinal);
        }catch(SQLException ex){
            System.out.println("java.sql.SQLIntegrityConstraintViolationException: " + ex.getMessage());
            return false;
        }
    }

    //Metodos Clientes
    public void insertarC(String idCliente, String idCine, String correoElectronico, long telefono, String nombre, String primerApellido, String segundoApellido)throws SQLException
    {
        
            conn = Conexion.getConnection();
            String sql = "insert INTO CLIENTES (ID_CLIENTE, CORREO_ELECTRONICO, TELEFONO,NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,ID_CINE) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pstmt = Conexion.creaConsultagenerada(conn, sql);
            ClientesSQL insC = new ClientesSQL(pstmt);
             insC.insertar(idCliente, idCine, correoElectronico, telefono, nombre, primerApellido, segundoApellido);

        
    }

//    public String generarIDCliente()
//    {
//        String nuevoID = null;
//
//        try
//        {
//            conn = Conexion.getConnection();
//            String sql = "SELECT MAX(ID_CLIENTE) AS ULTIMO_ID FROM CLIENTES";
//            PreparedStatement pstmt = Conexion.creaConsultagenerada(conn, sql);
//
//            ClientesSQL consultaID = new ClientesSQL(pstmt);
//            nuevoID = consultaID.generarNuevoID();
//
//        } catch (SQLException ex)
//        {
//            ex.printStackTrace();
//        }
//
//        return nuevoID;
//    }

    //Metodo ElementosAsientos
    public void insertarEA(Connection conn,String idAsientoFuncion,String idFuncion,String noAsiento, String disponibilidad, String noBoleto)throws SQLException
    {
        
            String sql = "insert INTO ELEMENTOS_ASIENTO (ID_ASIENTO_FUNCION,ID_FUNCION, NO_ASIENTO, DISPONIBILIDAD, NO_BOLETO) VALUES (?,?,?,?,?)";
            PreparedStatement pstmt = Conexion.creaConsultagenerada(conn, sql);
            ElementosAsientosSQL insEA = new ElementosAsientosSQL(pstmt);
             insEA.insertar(idAsientoFuncion,idFuncion,noAsiento, disponibilidad, noBoleto);
             
        
    }

    public boolean modificarEA(Connection conn,String idAsientoFuncion, String disponibilidad,String noBoleto) throws SQLException
    {
        try{
            String sql = "UPDATE ELEMENTOS_ASIENTO SET DISPONIBILIDAD = ?, NO_BOLETO = ? WHERE ID_ASIENTO_FUNCION = ?";
            PreparedStatement pstmt = Conexion.creaConsulta(conn, sql);
            ElementosAsientosSQL modEA = new ElementosAsientosSQL(pstmt);
            return modEA.modificar(idAsientoFuncion,disponibilidad,noBoleto);
        }catch(SQLException ex){
            System.out.println("java.sql.SQLIntegrityConstraintViolationException: " + ex.getMessage());
            return false;
        }

    }


    //Metodo Funciones
    public void insertarF(String idFuncion, String cvePelicula, String idCineSalas, java.util.Date fecha, String hora)throws SQLException
    {
       
            conn = Conexion.getConnection();
            String sql = "insert INTO FUNCIONES (ID_FUNCION, CVE_PELICULA, ID_CINE_SALAS,FECHA,HORA) VALUES (?,?,?,?,?)";
            PreparedStatement pstmt = Conexion.creaConsultagenerada(conn, sql);
            FuncionesSQL insF = new FuncionesSQL(pstmt);
             insF.insertar(idFuncion, cvePelicula, idCineSalas, fecha, hora);

        
    }

    //Metodo Pagos
    public boolean insertarP(Connection conn,String idPago, String idCliente, String metodoPago, double montoPagado)throws SQLException
    {
        try{
        String sql = "insert INTO PAGOS (ID_PAGO, METODO_PAGO,MONTO_PAGADO,ID_CLIENTE) VALUES (?,?,?,?,?)";
        PreparedStatement pstmt = Conexion.creaConsultagenerada(conn, sql);
        PagosSQL insF = new PagosSQL(pstmt);
        return insF.insertar(idPago, idCliente, metodoPago, montoPagado);
        }catch(SQLException ex){
            System.out.println("java.sql.SQLIntegrityConstraintViolationException: " + ex.getMessage());
            return false;
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
    
    
    public ArrayList<Promociones> leerTodasPromociones()
    {
        ArrayList<Promociones> prom = new ArrayList<>();
        PreparedStatement selectStmt = null;
        ResultSet rs = null;
        try
        {
            conn = Conexion.getConnection();
            String readSQL = "SELECT * FROM promociones";
            selectStmt = conn.prepareStatement(readSQL);
            rs = selectStmt.executeQuery(readSQL);
            while (rs.next())
            {
                String idProm = rs.getString("cve_promocion");
                String nomProm = rs.getString("nombre_promocion");
                String desc = rs.getString("descuento");
                String dia = rs.getString("dia");
                String idCine = rs.getString("id_cine");
                Promociones pr = new Promociones(idProm, idCine, nomProm, desc, dia);
                prom.add(pr);
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
        return prom;
    }
    
    
    public ArrayList<TipoBoleto> leerTodosTipoBoleto()
    {
        ArrayList<TipoBoleto> tipoBol = new ArrayList<>();
        PreparedStatement selectStmt = null;
        ResultSet rs = null;
        try
        {
            conn = Conexion.getConnection();
            String readSQL = "SELECT * FROM tipoboleto";
            selectStmt = conn.prepareStatement(readSQL);
            rs = selectStmt.executeQuery(readSQL);
            while (rs.next())
            {
                String tipoBoleto = rs.getString("tipo_boleto");
                int precio = rs.getInt("precio");
                TipoBoleto tb = new TipoBoleto(tipoBoleto, precio);
                tipoBol.add(tb);
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
        return tipoBol;
    }
    
    
    public ArrayList<Clientes> leerTodosClientes()
    {
        ArrayList<Clientes> clientes = new ArrayList<>();
        PreparedStatement selectStmt = null;
        ResultSet rs = null;
        try
        {
            conn = Conexion.getConnection();
            String readSQL = "SELECT * FROM clientes";
            selectStmt = conn.prepareStatement(readSQL);
            rs = selectStmt.executeQuery(readSQL);
            while (rs.next())
            {
                String idCliente = rs.getString("id_cliente");
                String idCine = rs.getString("id_cine");
                String correo = rs.getString("correo_electronico");
                long telefono = rs.getLong("telefono");
                String nombre = rs.getString("nombre");
                String primAp = rs.getString("primer_apellido");
                String segAp = rs.getString("segundo_apellido");
                Clientes cs = new Clientes(idCliente, idCine, correo, telefono, nombre, primAp, segAp);
                clientes.add(cs);
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
        return clientes;
    }
    
}
