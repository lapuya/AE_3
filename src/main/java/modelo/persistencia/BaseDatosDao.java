package modelo.persistencia;

import java.util.ArrayList;
import java.util.List;

import modelo.entidad.Autor;
import modelo.entidad.Direccion;
import modelo.entidad.Editorial;
import modelo.entidad.Libreria;
import modelo.entidad.Libro;

public class BaseDatosDao {
	
	
	public void init() {
		//3 autores,
		Autor a1 = new Autor("Isaac", "Asimov", "2 de enero de 1920");
		Autor a2 = new Autor("Edgar", "Allan Poe", "19 de enero de 1809");
		Autor a3 = new Autor("Arthur", "Conan Doyle", "22 de mayo de 1859");
		
		//2 editoriales
		Direccion d1 = new Direccion ("Alcala", 42, "Madrid", "España", "28272");
		Direccion d2 = new Direccion ("Gran vía", 2, "Madrid", "España", "23322");
		
		Editorial ed1 = new Editorial("RBA", d1);
		Editorial ed2 = new Editorial("Grupo Anaya", d2);


		//8 libros
		Libro l1 = new Libro("Fundacion", 23.9, ed1, a1); //isaac, RBA
		Libro l2 = new Libro("El corazon delator", 20.9, ed2, a2); //edgar, grupo anaya
		Libro l3 = new Libro("Sherlock Holmes", 24.9, ed1, a3); // arthur, RBA
		Libro l4 = new Libro("Yo, robot", 17.9, ed2, a1); //isaac, grupo anaya
		Libro l5 = new Libro("El gato negro", 12.9, ed1, a2); //edgar, RBA
		Libro l6 = new Libro("El sabueso de los Baskerville", 16.9, ed2, a3); //arthur, grupo anaya
		Libro l7 = new Libro("Robots e Imperio", 14.9, ed1, a1); //isaac, RBA
		Libro l8 = new Libro("El pozo y el pendulo", 10.9, ed2, a2); //edgar, grupo anaya

		//2 Librerias 
		Direccion d3 = new Direccion ("Leganitos", 5, "Madrid", "España", "28045");
		Direccion d4 = new Direccion ("San Bernardo", 33, "Madrid", "España", "23982");
		
		Libreria libreria1 = new Libreria("Casa del Libro", "Tomas", d3);
		Libreria libreria2 = new Libreria("Librerias Felix", "Felix", d4);
		
		//Un libro puede estar en diferentes librerias
		//Una libreria puede tener una coleccion de libros
		List<Libreria> librerias1 = new ArrayList<Libreria>();
		List<Libreria> librerias2 = new ArrayList<Libreria>();
		List<Libro> libros1 = new ArrayList<Libro>();
		List<Libro> libros2 = new ArrayList<Libro>();
		
		librerias1.add(libreria1);
		//primera coleccion de libros
		libros1.add(l1);
		libros1.add(l2);
		libros1.add(l3);
		libros1.add(l4);
		//libros 1 y 4 estaran en la primera lista de librerias
		l1.setLibrerias(librerias1);
		l2.setLibrerias(librerias1);
		l3.setLibrerias(librerias1);
		l4.setLibrerias(librerias1);
		//la libreria 1 tendra la coleccion de libros "libros1"
		libreria1.setColeccionLibros(libros1); 

		//segunda lista de librerias que tendra a la libreria 2 y a la 1
		librerias2.add(libreria2);
		librerias2.add(libreria1);
		//segunda coleccion de libros
		libros2.add(l5);
		libros2.add(l6);
		libros2.add(l7);
		libros2.add(l8);
		//los libros 5 a 8 estan en la segunda lista de librerias
		l5.setLibrerias(librerias2);
		l6.setLibrerias(librerias2);
		l7.setLibrerias(librerias2);
		l8.setLibrerias(librerias2);
		//la segunda libreria tendra la segunda coleccion de libros
		libreria2.setColeccionLibros(libros2);
		
		AutorDao autorDao = new AutorDao();
		autorDao.insertar(a1);
		autorDao.insertar(a2);
		autorDao.insertar(a3);

		
	}
}
