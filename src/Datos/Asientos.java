/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

/**
 *
 * @author santi
 */
public class Asientos
{
    private String noAsiento;
    private String fila;
    private int columna;

    public Asientos()
    {
    }

    public Asientos(String noAsiento, String fila, int columna)
    {
        this.noAsiento = noAsiento;
        this.fila = fila;
        this.columna = columna;
    }

    public String getNoAsiento()
    {
        return noAsiento;
    }

    public void setNoAsiento(String noAsiento)
    {
        this.noAsiento = noAsiento;
    }

    public String getFila()
    {
        return fila;
    }

    public void setFila(String fila)
    {
        this.fila = fila;
    }

    public int getColumna()
    {
        return columna;
    }

    public void setColumna(int columna)
    {
        this.columna = columna;
    }
    
    
}
