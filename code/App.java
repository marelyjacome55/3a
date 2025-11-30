/*
 * App.java
 * Autor: Marely Jácome
 * Fecha: 2025-11-27
 * Versión: 1.1
 * Descripción: Punto de entrada del PSP Program 3. 
 *              Ejecuta el método executeRegression() para el test seleccionado.
 */

public class App
{
    /**
     * Método principal del programa.
     *
     * @param args argumentos de consola (no utilizados)
     */
    public static void main(String[] args)
    {
        Logic logic = new Logic();

        // CAMBIAR ESTE NÚMERO MANUALMENTE PARA EL TEST
        int testSeleccionado = 4;  // 1, 2, 3 o 4

        logic.executeRegression(testSeleccionado);
    }
}

