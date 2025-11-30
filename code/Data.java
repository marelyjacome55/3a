/*
 * Data.java
 * Autor: Marely Jácome
 * Fecha: 2025-11-27
 * Versión: 1.1
 * Descripción: Convierte texto en un arreglo de líneas independientes.
 */

public class Data
{
    /**
     * Convierte un bloque de texto en un arreglo de líneas.
     *
     * @param data texto sin procesar
     * @return arreglo de Strings
     */
    public String[] saveData(String data)
    {
        if (data == null)
        {
            return new String[0];
        }

        String normalized = data.replace("\r\n", "\n").replace("\r", "\n");

        return normalized.split("\n");
    }
}

