/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author santi
 */
public class TipoBoleto
{
    private String tipoBoleto;
    private int precio;

    public TipoBoleto()
    {
    }

    public TipoBoleto(String tipoBoleto, int precio)
    {
        this.tipoBoleto = tipoBoleto;
        this.precio = precio;
    }

    public String getTipoBoleto()
    {
        return tipoBoleto;
    }

    public void setTipoBoleto(String tipoBoleto)
    {
        this.tipoBoleto = tipoBoleto;
    }

    public int getPrecio()
    {
        return precio;
    }

    public void setPrecio(int precio)
    {
        this.precio = precio;
    }
    
    
}
