package vista;

import java.util.List;
import java.util.Scanner;

import modelo.entidad.Autor;
import modelo.entidad.Libreria;
import modelo.entidad.Libro;
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
		
		//drop and create no funciona como esperabamos (se borran las tablas, no da valores...)
		//se ha optado por el update y añadir un crear si no existe
		//asi que hemos decidido incluir una funcion que comprueba si ya hay valores en la tabla
		//para que no meta los valores por defecto cada vez que se ejecuta el programa
		if (!baseDatosDao.conValores()) {
			baseDatosDao.init();
		}
		
		
		int op;
		Scanner sc = new Scanner(System.in);
		
		op = menu();
		while (op != 5) {
			switch (op)
			{
				case 1:
					List<Libro> libros = libroDao.listar();
					if(libros != null)
						mostrarLibros(libros);
					 else
						System.out.println("No se ha podido establecer conexión con la BBDD");
					break;
				case 2:
					List<Autor> autores = autorDao.listar();
					if (autores != null)
						mostrarAutores(autores);
					else
						System.out.println("No se ha podido establecer conexión con la BBDD");
					break;
				case 3:
					List<Libreria> librerias = libreriaDao.listar();
					if (librerias != null)
						mostrarLibrosEnLibrerias(librerias);
					else
						System.out.println("No se ha podido establecer conexión con la BBDD");
					break;
				case 4:
					List<Libro> librosEnLibreria = libroDao.listar();
					if (librosEnLibreria != null)
						mostrarLibrosYLibreria(librosEnLibreria);
					else
						System.out.println("No se ha podido establecer conexión con la BBDD");
					break;
			}
			op = menu();
		}
	}
		

	

	private static void mostrarLibrosYLibreria(List<Libro> librosEnLibreria) {
		for (Libro libro : librosEnLibreria) {
			System.out.println("Libro: " + libro.getTitulo());
			for (Libreria libreria : libro.getLibrerias())
				System.out.println("Libreria: " +libreria.getNombre());
		}
		
	}




	private static void mostrarLibrosEnLibrerias(List<Libreria> librerias) {
		for (Libreria libreria : librerias){
			System.out.println("Libreria: " +libreria.getNombre());
			for (Libro libro : libreria.getColeccionLibros())
				System.out.println("Libro: " + libro.getTitulo());
		}
		
	}

	private static void mostrarAutores(List<Autor> autores) {
		for(Autor autor : autores) {
			System.out.println("Autor: " + autor.getNombre() + " " + autor.getApellidos());
			for (Libro libro : autor.getLibros())
				System.out.println("Libro: " +libro.getTitulo());
		}
		
		
	}

	private static void mostrarLibros(List<Libro> libros) {
		for(Libro libro : libros)
			System.out.println("Titulo: " + libro.getTitulo() + ", precio: " +libro.getPrecio() + 
					", autor: " +libro.getAutor().getNombre() + " " + libro.getAutor().getApellidos() + ", editorial: " +libro.getEditorial().getNombre());
		
	}

	private static int menu() {
		// TODO Auto-generated method stub
		int op;
		Scanner sc = new Scanner(System.in);
		System.out.println(" ---------- LIBRERIA ----------");
		System.out.println("1. Mostrar todos los libros dados de alta, con su editorial y su autor");
		System.out.println("2. Mostrar todos los autores dados de alta, con sus libros asociados");
		System.out.println("3. Mostrar todas las librerías, con solamente sus libros asociados");
		System.out.println("4. Mostrar todos los libros dados de alta, y en la librería en la que están.");
		System.out.println("5. Salir");
		op = sc.nextInt();
		
		while(op < 1 || op > 5) {
			System.out.println("ERROR EN LA ELECCION. ELIJA UN VALOR ENTRE 1 Y 4");
			System.out.println("1. Mostrar todos los libros dados de alta, con su editorial y su autor");
			System.out.println("2. Mostrar todos los autores dados de alta, con sus libros asociados");
			System.out.println("3. Mostrar todas las librerías, con solamente sus libros asociados");
			System.out.println("4. Mostrar todos los libros dados de alta, y en la librería en la que están.");
			System.out.println("5. Salir");

			op = sc.nextInt();
		}
		return op;
	}

}
