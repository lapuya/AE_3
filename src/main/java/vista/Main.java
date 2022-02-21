package vista;

import modelo.persistencia.AutorDao;
import modelo.persistencia.BaseDatosDao;
import modelo.persistencia.LibreriaDao;
import modelo.persistencia.LibroDao;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AutorDao autorDao = new AutorDao();
		LibreriaDao libreriaDao = new LibreriaDao();
		LibroDao libroDao = new LibroDao();
		BaseDatosDao baseDatosDao = new BaseDatosDao();
		
		baseDatosDao.init();
	}

}
