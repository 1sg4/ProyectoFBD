/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

/**
 *
 * @author santi
 */
public class Validaciones
{
    public static boolean noVacio(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }
    public static boolean esTexto(String texto) {
        return texto.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+");
    }
    public static boolean esNumeroEntero(String texto) {
        return texto.matches("\\d+");
    }
    public static boolean esNumeroDecimal(String texto) {
        return texto.matches("\\d+(\\.\\d+)?");
    }
    public static String primeraMayuscula(String texto) {
        if (texto == null || texto.isEmpty()) {
            return texto;
        }
        texto = texto.trim();
        return texto.substring(0, 1).toUpperCase() + texto.substring(1).toLowerCase();
    }
}
