import java.util.Arrays;
import java.lang.reflect.*;
import java.lang.Math;

public class Main
{
    public static void main(String[] args)
    {
        if(args.length == 0)
        {
            System.out.println("Nie podano nic do obliczenia!");
            return;
        }
        String splittedArgs[] = splitArgs(args[0]);

        Double[] parameters = new Double[splittedArgs.length - 1];
        Class[] parameterTypes = new Class[splittedArgs.length - 1];
        try
        {
            for(int i = 0; i < splittedArgs.length - 1; i++)
            {
                parameters[i] = Double.parseDouble(splittedArgs[i + 1]);
                parameterTypes[i] = double.class;
            }
        }
        catch (NumberFormatException exception)
        {
            System.out.println("Argumenty funkcji musza byc liczbami!");
            return;
        }

        java.lang.reflect.Method method;
        try
        {
            method = Math.class.getMethod(splittedArgs[0], parameterTypes);
        }
        catch(NoSuchMethodException exception)
        {
            System.out.println("Nie ma takiej metody!");
            return;
        }

        Object result = null;
        try
        {
            switch(parameters.length)
            {
                case 0:
                    result = method.invoke(null);
                    break;
                
                case 1:
                    result = method.invoke(null, parameters[0]);
                    break;

                case 2:
                    result = method.invoke(null, parameters[0], parameters[1]);
                    break;

                case 3:
                    result = method.invoke(null, parameters[0], parameters[1], parameters[2]);
                    break;
            }
        }
        catch(IllegalAccessException exception)
        {
            System.out.println(exception);
            return;
        }
        catch(InvocationTargetException exception)
        {
            System.out.println(exception);
            return;
        }

        System.out.println("wynik: " + result);
    }

    public static String[] splitArgs(String arg)
    {
        return Arrays.stream(arg.split("[\\s+(),]")).filter(w -> w.isEmpty() == false).toArray(String[]::new);
    }
}