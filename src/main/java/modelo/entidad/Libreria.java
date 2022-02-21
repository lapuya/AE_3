package modelo.entidad;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="librerias")
public class Libreria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre, nombreDue�o;
	@Embedded
	private Direccion direccion;
	
	@ManyToMany(mappedBy="librerias", cascade = CascadeType.PERSIST)
	private List<Libro> coleccionLibros;
	
	public Libreria () {
		super();
		coleccionLibros = new ArrayList<Libro>();
	}
	public Libreria(String nombre, String nombreDue�o, Direccion direccion) {
		super();
		this.nombre = nombre;
		this.nombreDue�o = nombreDue�o;
		this.direccion = direccion;
		coleccionLibros = new ArrayList<Libro>();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNombreDue�o() {
		return nombreDue�o;
	}
	public void setNombreDue�o(String nombreDue�o) {
		this.nombreDue�o = nombreDue�o;
	}
	public Direccion getDireccion() {
		return direccion;
	}
	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
	public List<Libro> getColeccionLibros() {
		return coleccionLibros;
	}
	public void setColeccionLibros(List<Libro> libros1) {
		this.coleccionLibros = libros1;
	}
	
	public void a�adirLibro(Libro l) {
		coleccionLibros.add(l);
	}
	@Override
	public String toString() {
		return "Libreria [id=" + id + ", nombre=" + nombre + ", nombreDue�o=" + nombreDue�o + ", direccion=" + direccion
				+ ", coleccionLibros=" + coleccionLibros + "]";
	}
	
	
	
	

}
