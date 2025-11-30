/*
 * Logic.java
 * Autor: Marely Jácome
 * Fecha: 2025-11-27
 * Versión: 1.1
 * Descripción: Controla el flujo principal del PSP Program 3.
 *              Gestiona lectura, procesamiento, cálculos y salida.
 */

public class Logic
{
    private String dataX;
    private String dataY;
    private String[] arrDataX;
    private String[] arrDataY;
    private double thisXk;

    /**
     * Ejecuta todo el proceso de regresión lineal del PSP Program 3.
     *
     * @param testNumber número de test (1-4)
     */
    public void executeRegression(int testNumber)
    {
        String xFile = "";
        String yFile = "";

        if (testNumber == 1)
        {
            xFile = "x1.txt";
            yFile = "y1.txt";
        }
        else if (testNumber == 2)
        {
            xFile = "x2.txt";
            yFile = "y2.txt";
        }
        else if (testNumber == 3)
        {
            xFile = "x3.txt";
            yFile = "y3.txt";
        }
        else if (testNumber == 4)
        {
            xFile = "x4.txt";
            yFile = "y4.txt";
        }
        else
        {
            System.out.println("Número de test inválido.");
            return;
        }

        Input input = new Input();
        dataX = input.readData(xFile);
        dataY = input.readData(yFile);

        Data data = new Data();
        arrDataX = data.saveData(dataX);
        arrDataY = data.saveData(dataY);

        thisXk = 386.0;

        EstimacionCorLineal est = new EstimacionCorLineal();
        est.setXk(thisXk);

        est.sumX(arrDataX);
        est.sumY(arrDataY);
        est.sumXY(arrDataX, arrDataY);
        est.sumXX(arrDataX);
        est.sumYY(arrDataY);

        est.getAvgX(arrDataX);
        est.getAvgY(arrDataY);

        double b1 = est.getB1();
        double b0 = est.getB0();
        double rxy = est.getRXY();
        double r2 = est.getR();
        double yk = est.getYk();

        StringBuilder sb = new StringBuilder();
        sb.append("RESULTADOS REGRESIÓN LINEAL PSP\n");
        sb.append("--------------------------------\n");
        sb.append("β0  = ").append(b0).append("\n");
        sb.append("β1  = ").append(b1).append("\n");
        sb.append("rxy = ").append(rxy).append("\n");
        sb.append("r²  = ").append(r2).append("\n");
        sb.append("xk  = ").append(thisXk).append("\n");
        sb.append("yk  = ").append(yk).append("\n");

        output outWriter = new output();
        outWriter.writeData("salida_regresion.txt", sb.toString());

        System.out.println(sb.toString());
    }
}

