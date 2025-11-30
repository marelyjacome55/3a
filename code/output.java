/*
 * output.java
 * Autor: Marely Jácome
 * Fecha: 2025-11-27
 * Versión: 1.1
 * Descripción: Clase para escribir archivos de texto en PSP Program 3.
 */

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class output
{
    /**
     * Escribe un texto en un archivo.
     *
     * @param outFile nombre del archivo
     * @param outText contenido a escribir
     */
    public void writeData(String outFile, String outText)
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(outFile)))
        {
            bw.write(outText);
        }
        catch (IOException e)
        {
            throw new RuntimeException("Error al escribir archivo: " + outFile, e);
        }
    }
}

