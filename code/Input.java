/*
 * Input.java
 * Autor: Marely Jácome
 * Fecha: 2025-11-27
 * Versión: 1.1
 * Descripción: Clase para lectura de archivos de texto en PSP Program 3.
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Input
{
    /**
     * Lee el contenido completo de un archivo y lo devuelve como un String.
     *
     * @param file nombre del archivo
     * @return contenido del archivo
     */
    public String readData(String file)
    {
        StringBuilder sb = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(file)))
        {
            String line;

            while ((line = br.readLine()) != null)
            {
                sb.append(line).append("\n");
            }
        }
        catch (IOException e)
        {
            throw new RuntimeException("Error al leer archivo: " + file, e);
        }

        return sb.toString();
    }
}

