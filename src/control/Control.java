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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author santi
 */
public class Control
{
      Connection conn;
//Metodos Boleto
    public int insertarB(String noBoleto, String idPago, String idAsientoFuncion, String cvePromocion, String tipoBoleto, Date fechaCompra, int precioFinal) throws SQLException
    {
        try
        {
            conn = Conexion.getConnection();
            String sql = "insert INTO BOLETOS (NO_BOLETO, ID_PAGO, ID_ASIENTO_FUNCION,CVE_PROMOCION,TIPO_BOLETO,FECHA_COMPRA,PRECIO_FINAL) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pstmt = Conexion.creaConsultagenerada(conn, sql);
            BoletoSQL insBol = new BoletoSQL(pstmt);
            return insBol.insertar(noBoleto, idPago, idAsientoFuncion,cvePromocion,tipoBoleto,fechaCompra,precioFinal);

        } catch(SQLException ex){
            return -1;
        }
    }

 //Metodos Clientes
    public int insertarC(String idCliente, String idCine, String correoElectronico, int telefono, String nombre, String primerApellido, String segundoApellido)
    {
        try
        {
            conn = Conexion.getConnection();
            String sql = "insert INTO CLIENTES (ID_CLIENTE, CORREO_ELECTRONICO, TELEFONO,NOMBRE,PRIMER_APELLIDO,SEGUNDO_APELLIDO,ID_CINE) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement pstmt = Conexion.creaConsultagenerada(conn, sql);
            ClientesSQL insC = new ClientesSQL(pstmt);
            return insC.insertar(idCliente, idCine, correoElectronico,telefono,nombre,primerApellido,segundoApellido);

        } catch(SQLException ex){
            return -1;
        }
    }
    
    //Metodo ElementosAsientos
    public int insertarEA(String idAsientoFuncion, String disponibilidad, String noBoleto)
    {
        try
        {
            conn = Conexion.getConnection();
            String sql = "insert INTO ELEMENTOS_ASIENTOS (ID_ASIENTO_FUNCION, DISPONIBILIDAD, NO_BOLETO) VALUES (?,?,?)";
            PreparedStatement pstmt = Conexion.creaConsultagenerada(conn, sql);
            ElementosAsientosSQL insEA = new ElementosAsientosSQL(pstmt);
            return insEA.insertar(idAsientoFuncion, disponibilidad, noBoleto);

        } catch(SQLException ex){
            return -1;
        }
    }
    public int modificarEA(String idAsientoFuncion, String disponibilidad, String noBoleto) throws SQLException
    {
        try
        {
            conn = Conexion.getConnection();
            String sql = "update ELEMENTOS_ASIENTOS set DISPONIBILIDAD=?, NO_BOLETO=? where ID_ASIENTO_FUNCION=?";
            PreparedStatement pstmt = Conexion.creaConsulta(conn, sql);
            ElementosAsientosSQL modP = new ElementosAsientosSQL(pstmt);
            return modP.modificar(idAsientoFuncion, disponibilidad, noBoleto);
        } catch(SQLException ex){
            return -1;
        }
    }
    
    //Metodo Funciones
    public int insertarF(String idFuncion, String cvePelicula, String idCineSalas, java.util.Date fecha, String hora)
    {
        try
        {
            conn = Conexion.getConnection();
            String sql = "insert INTO FUNCIONES (ID_FUNCION, CVE_PELICULA, ID_CINE_SALAS,FECHA,HORA) VALUES (?,?,?,?,?)";
            PreparedStatement pstmt = Conexion.creaConsultagenerada(conn, sql);
            FuncionesSQL insF = new FuncionesSQL(pstmt);
            return insF.insertar(idFuncion, cvePelicula, idCineSalas,fecha,hora);

        } catch(SQLException ex){
            return -1;
        }
    }
    
    //Metodo Pagos
    public int insertarP(String idPago, String idCliente, int cantBoletos, String metodoPago, int montoPagado)
    {
        try
        {
            conn = Conexion.getConnection();
            String sql = "insert INTO PAGOS (ID_PAGO, CANT_BOLETOS, METODO_PAGO,MONTO_PAGADO,ID_CLIENTE) VALUES (?,?,?,?,?)";
            PreparedStatement pstmt = Conexion.creaConsultagenerada(conn, sql);
            PagosSQL insF = new PagosSQL(pstmt);
            return insF.insertar(idPago, idCliente, cantBoletos,metodoPago,montoPagado);

        } catch(SQLException ex){
            return -1;
        }
    }
    
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
