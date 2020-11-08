import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class FicherosTexto {
	//------------------------------------------------------------------------------------------
	public static ArrayList<String> buscarPatronEnFichero(File f, String patron)
	{
		if(f.exists() && f.isFile() && f.canRead())
		{	patron = patron.toLowerCase();
			ArrayList<String> palabrasEncontradas = new ArrayList<String>();
			FileInputStream fis;
			try {
				fis = new FileInputStream(f);
				InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.UTF_8);
				BufferedReader br = new BufferedReader(isr);
				String linea = "";
				while( (linea = br.readLine() ) != null)
						{
						String[] palabrasLinea = linea.split("\\s+"); //separo la línea en palabras	
						for (int i = 0; i < palabrasLinea.length; i++) {
							if(palabrasLinea[i].toLowerCase().contains(patron)) // miro si la palabra contiene el patron buscado
							{
								if(!palabrasEncontradas.contains(palabrasLinea[i])) //compruebo que no está la palabra en el conjunto de palabras encontradas
								{
									palabrasEncontradas.add(palabrasLinea[i]); // guardo la palabra encontrada
								}
							}
						}
						}
				        br.close();
				        isr.close();
						fis.close();
						return palabrasEncontradas;
					} catch (IOException e) {
						return null;
					}
		} 
		return null;
	}
	//--------------------------------------------------------------------
}
