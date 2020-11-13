import java.io.File;
import java.util.ArrayList;

public class PruebaBuscarPatronEnFichero {

	public static void main(String[] args) {
		String patron = "repa";
		//--------------------------------------
		String ruta = "src";
		String fichero = "diccionario.txt";
		File f = new File(ruta,fichero);
		//--------------------------------------
		long tiempoinicial =System.currentTimeMillis();
		//--------------------------------------
		ArrayList<String> palabrasEncontradas = FicherosTexto.buscarPatronEnFichero(f, patron);
		//--------------------------------------
		long tiempofinal = System.currentTimeMillis();
		long tiempobusqueda = tiempofinal - tiempoinicial;
		System.out.println("tiempo empleado en la busqueda (milisegundos): " + tiempobusqueda);
		//--------------------------------------------------------------------------------------
		if(palabrasEncontradas == null)
		{
			System.out.println("problema al recuperar listado de palabras");
			return;
		}
		if(palabrasEncontradas.size() == 0)
		{
			System.out.println("no encontré ninguna palabra que coincida con el patron buscado");
			return;			
		}
		System.out.println("palabras encontradas: " + palabrasEncontradas.size());
		for (String palabra : palabrasEncontradas) {
			System.out.println(palabra);
		}
	}

}
