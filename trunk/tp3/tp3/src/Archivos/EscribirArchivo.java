package Archivos;
import java.io.*;

public class EscribirArchivo {
	public static void escribir(String dir, String[] result)
    {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter(dir);
            pw = new PrintWriter(fichero);
            for (int i = 0; i < result.length; i++)
                pw.println(result[i]);

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }

}
