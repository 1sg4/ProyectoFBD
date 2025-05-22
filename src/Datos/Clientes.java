/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author santi
 */
public class Clientes
{
    private String idCliente;
    private String idCine;
    private String correoElectronico;
    private long telefono;
    private String nombre;
    private String primerApellido;
    private String segundoApellido;

    public Clientes()
    {
    }

    public Clientes(String idCliente, String idCine, String correoElectronico, long telefono, String nombre, String primerApellido, String segundoApellido)
    {
        this.idCliente = idCliente;
        this.idCine = idCine;
        this.correoElectronico = correoElectronico;
        this.telefono = telefono;
        this.nombre = nombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
    }

    public String getIdCliente()
    {
        return idCliente;
    }

    public void setIdCliente(String idCliente)
    {
        this.idCliente = idCliente;
    }

    public String getIdCine()
    {
        return idCine;
    }

    public void setIdCine(String idCine)
    {
        this.idCine = idCine;
    }

    public String getCorreoElectronico()
    {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico)
    {
        this.correoElectronico = correoElectronico;
    }

    public long getTelefono()
    {
        return telefono;
    }

    public void setTelefono(int telefono)
    {
        this.telefono = telefono;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getPrimerApellido()
    {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido)
    {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido()
    {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido)
    {
        this.segundoApellido = segundoApellido;
    }
    
    
}
