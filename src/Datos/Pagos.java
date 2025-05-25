/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author santi
 */
public class Pagos
{
    private String idPago;
    private String idCliente;
    private int cantBoletos;
    private String metodoPago;
    private double montoPagado;

    public Pagos()
    {
    }

    public Pagos(String idPago, String idCliente, int cantBoletos, String metodoPago, double montoPagado)
    {
        this.idPago = idPago;
        this.idCliente = idCliente;
        this.cantBoletos = cantBoletos;
        this.metodoPago = metodoPago;
        this.montoPagado = montoPagado;
    }

    public String getIdPago()
    {
        return idPago;
    }

    public void setIdPago(String idPago)
    {
        this.idPago = idPago;
    }

    public String getIdCliente()
    {
        return idCliente;
    }

    public void setIdCliente(String idCliente)
    {
        this.idCliente = idCliente;
    }

    public int getCantBoletos()
    {
        return cantBoletos;
    }

    public void setCantBoletos(int cantBoletos)
    {
        this.cantBoletos = cantBoletos;
    }

    public String getMetodoPago()
    {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago)
    {
        this.metodoPago = metodoPago;
    }

    public double getMontoPagado()
    {
        return montoPagado;
    }

    public void setMontoPagado(int montoPagado)
    {
        this.montoPagado = montoPagado;
    }
    
    
}
