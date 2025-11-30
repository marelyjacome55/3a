/*
 * EstimacionCorLineal.java
 * Autor: Marely Jácome
 * Fecha: 2025-11-27
 * Versión: 1.1
 * Descripción: Clase que implementa los cálculos estadísticos necesarios
 *              para la regresión lineal usada en el PSP Program 3.
 *              Calcula sumatorias, promedios, coeficientes β0, β1,
 *              correlación rxy, r² y predicción yk.
 */

/**
 * Clase encargada de realizar los cálculos de regresión lineal y correlación
 * usados en PSP Program 3.
 */
public class EstimacionCorLineal
{
    /* --------------------------------------------------------------- */
    /*                         Atributos UML                           */
    /* --------------------------------------------------------------- */

    private double dblSumX;
    private double dblSumY;
    private double dblSumXY;
    private double dblSumXX;
    private double dblSumYY;
    private double dblAvgX;
    private double dblAvgY;
    private int intN;
    private double dblB1;
    private double dblRXY;
    private double dblB0;
    private double dblR;
    private double dblXk;
    private double dblYk;

    /* --------------------------------------------------------------- */
    /*                        SUMATORIAS PSP                           */
    /* --------------------------------------------------------------- */

    /**
     * Calcula ΣX y determina n.
     *
     * @param datalist arreglo de Strings convertibles a double
     * @return suma de X
     */
    public double sumX(String[] datalist)
    {
        dblSumX = 0;
        intN = 0;

        for (String s : datalist)
        {
            if (s == null)
            {
                continue;
            }

            s = s.trim();

            if (s.isEmpty())
            {
                continue;
            }

            dblSumX += Double.parseDouble(s);
            intN++;
        }

        return dblSumX;
    }

    /**
     * Calcula ΣY.
     *
     * @param datalist arreglo de Strings convertibles a double
     * @return suma de Y
     */
    public double sumY(String[] datalist)
    {
        dblSumY = 0;

        for (String s : datalist)
        {
            if (s == null)
            {
                continue;
            }

            s = s.trim();

            if (s.isEmpty())
            {
                continue;
            }

            dblSumY += Double.parseDouble(s);
        }

        return dblSumY;
    }

    /**
     * Calcula Σ(XY).
     *
     * @param dataX arreglo X
     * @param dataY arreglo Y
     * @return suma de productos X * Y
     */
    public double sumXY(String[] dataX, String[] dataY)
    {
        dblSumXY = 0;

        int n = Math.min(dataX.length, dataY.length);

        for (int i = 0; i < n; i++)
        {
            String sx = dataX[i];
            String sy = dataY[i];

            if (sx == null || sy == null)
            {
                continue;
            }

            sx = sx.trim();
            sy = sy.trim();

            if (sx.isEmpty() || sy.isEmpty())
            {
                continue;
            }

            dblSumXY += Double.parseDouble(sx) * Double.parseDouble(sy);
        }

        return dblSumXY;
    }

    /**
     * Calcula Σ(X²).
     *
     * @param datalist arreglo de Strings
     * @return suma de X²
     */
    public double sumXX(String[] datalist)
    {
        dblSumXX = 0;

        for (String s : datalist)
        {
            if (s == null)
            {
                continue;
            }

            s = s.trim();

            if (s.isEmpty())
            {
                continue;
            }

            double x = Double.parseDouble(s);
            dblSumXX += x * x;
        }

        return dblSumXX;
    }

    /**
     * Calcula Σ(Y²).
     *
     * @param datalist arreglo de Strings
     * @return suma de Y²
     */
    public double sumYY(String[] datalist)
    {
        dblSumYY = 0;

        for (String s : datalist)
        {
            if (s == null)
            {
                continue;
            }

            s = s.trim();

            if (s.isEmpty())
            {
                continue;
            }

            double y = Double.parseDouble(s);
            dblSumYY += y * y;
        }

        return dblSumYY;
    }

    /* --------------------------------------------------------------- */
    /*                         PROMEDIOS                               */
    /* --------------------------------------------------------------- */

    /**
     * Calcula el promedio X̄.
     *
     * @param datalist arreglo de Strings
     * @return promedio de X
     */
    public double getAvgX(String[] datalist)
    {
        double sum = 0;
        int count = 0;

        for (String s : datalist)
        {
            if (s == null)
            {
                continue;
            }

            s = s.trim();

            if (s.isEmpty())
            {
                continue;
            }

            sum += Double.parseDouble(s);
            count++;
        }

        dblAvgX = (count == 0) ? 0 : sum / count;

        return dblAvgX;
    }

    /**
     * Calcula el promedio Ȳ.
     *
     * @param datalist arreglo de Strings
     * @return promedio de Y
     */
    public double getAvgY(String[] datalist)
    {
        double sum = 0;
        int count = 0;

        for (String s : datalist)
        {
            if (s == null)
            {
                continue;
            }

            s = s.trim();

            if (s.isEmpty())
            {
                continue;
            }

            sum += Double.parseDouble(s);
            count++;
        }

        dblAvgY = (count == 0) ? 0 : sum / count;

        return dblAvgY;
    }

    /* --------------------------------------------------------------- */
    /*                    PARÁMETROS DE REGRESIÓN                      */
    /* --------------------------------------------------------------- */

    /**
     * Calcula la pendiente β1.
     *
     * @return β1
     */
    public double getB1()
    {
        double num = dblSumXY - (intN * dblAvgX * dblAvgY);
        double den = dblSumXX - (intN * dblAvgX * dblAvgX);

        dblB1 = num / den;

        return dblB1;
    }

    /**
     * Calcula la intersección β0.
     *
     * @return β0
     */
    public double getB0()
    {
        dblB0 = dblAvgY - (dblB1 * dblAvgX);

        return dblB0;
    }

    /* --------------------------------------------------------------- */
    /*                     CORRELACIÓN Y r²                            */
    /* --------------------------------------------------------------- */

    /**
     * Calcula el coeficiente de correlación rxy.
     *
     * @return rxy
     */
    public double getRXY()
    {
        double num = (intN * dblSumXY) - (dblSumX * dblSumY);

        double denX = (intN * dblSumXX) - (dblSumX * dblSumX);
        double denY = (intN * dblSumYY) - (dblSumY * dblSumY);

        double den = Math.sqrt(denX * denY);

        dblRXY = num / den;

        return dblRXY;
    }

    /**
     * Calcula el coeficiente de determinación r².
     *
     * @return r²
     */
    public double getR()
    {
        dblR = dblRXY * dblRXY;

        return dblR;
    }

    /* --------------------------------------------------------------- */
    /*                          PREDICCIÓN Yk                           */
    /* --------------------------------------------------------------- */

    /**
     * Establece el valor de Xk para la predicción.
     *
     * @param xk valor predictor
     */
    public void setXk(double xk)
    {
        this.dblXk = xk;
    }

    /**
     * Calcula la predicción Yk = β0 + β1 * Xk.
     *
     * @return yk
     */
    public double getYk()
    {
        dblYk = dblB0 + (dblB1 * dblXk);

        return dblYk;
    }
}

