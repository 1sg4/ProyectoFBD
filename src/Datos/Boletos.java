/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;
import java.sql.Date;
/**
 *
 * @author santi
 */
public class Boletos
{
    private String noBoleto;
    private String idPago;
    private String idAsientoFuncion;
    private String cvePromocion;
    private String tipoBoleto;
    private Date fechaCompra;
    private double precioFinal;

    public Boletos()
    {
    }

    public Boletos(String noBoleto, String idPago, String idAsientoFuncion, String cvePromocion, String tipoBoleto, Date fechaCompra, double precioFinal)
    {
        this.noBoleto = noBoleto;
        this.idPago = idPago;
        this.idAsientoFuncion = idAsientoFuncion;
        this.cvePromocion = cvePromocion;
        this.tipoBoleto = tipoBoleto;
        this.fechaCompra = fechaCompra;
        this.precioFinal = precioFinal;
    }

    public String getNoBoleto()
    {
        return noBoleto;
    }

    public void setNoBoleto(String noBoleto)
    {
        this.noBoleto = noBoleto;
    }

    public String getIdPago()
    {
        return idPago;
    }

    public void setIdPago(String idPago)
    {
        this.idPago = idPago;
    }

    public String getIdAsientoFuncion()
    {
        return idAsientoFuncion;
    }

    public void setIdAsientoFuncion(String idAsientoFuncion)
    {
        this.idAsientoFuncion = idAsientoFuncion;
    }

    public String getCvePromocion()
    {
        return cvePromocion;
    }

    public void setCvePromocion(String cvePromocion)
    {
        this.cvePromocion = cvePromocion;
    }

    public String getTipoBoleto()
    {
        return tipoBoleto;
    }

    public void setTipoBoleto(String tipoBoleto)
    {
        this.tipoBoleto = tipoBoleto;
    }

    public Date getFechaCompra()
    {
        return fechaCompra;
    }

    public void setFechaCompra(Date fechaCompra)
    {
        this.fechaCompra = fechaCompra;
    }

    public double getPrecioFinal()
    {
        return precioFinal;
    }

    public void setPrecioFinal(int precioFinal)
    {
        this.precioFinal = precioFinal;
    }
    
    
}
