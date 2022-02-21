package modelo.entidad;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="libros")

public class Libro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_libro;
	private String titulo;
	private double precio;
	
	@ManyToOne (cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_id_editorial", referencedColumnName = "id_editorial")    
	private Editorial editorial;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "fk_id_autor", referencedColumnName = "id_autor")   
	private Autor autor;
	
	@ManyToMany(cascade=CascadeType.PERSIST)
	@JoinTable(name="libro_libreria", 
			   joinColumns = {@JoinColumn(name="fk_id_libro", referencedColumnName="id_libro")},
			   inverseJoinColumns = {@JoinColumn(name="fk_id_libreria", referencedColumnName="id_libreria")})
	
    private List<Libreria> librerias;
	
	
	
	public Libro() {
		super();
	}
	
	
	public Libro(String titulo, double precio, Editorial editorial, Autor autor) {
		super();
		this.titulo = titulo;
		this.precio = precio;
		this.editorial = editorial;
		this.autor = autor;
		this.librerias = new ArrayList<Libreria>();
	}
	public Libro(String titulo, double precio) {
		this.titulo = titulo;
		this.precio = precio;
	}


	public int getId() {
		return id_libro;
	}
	public void setId(int id) {
		this.id_libro = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Editorial getEditorial() {
		return editorial;
	}
	public void setEditorial(Editorial editorial) {
		this.editorial = editorial;
	}
	public Autor getAutor() {
		return autor;
	}
	public void setAutor(Autor autor) {
		this.autor = autor;
	}
	
	
	
	public List<Libreria> getLibrerias() {
		return librerias;
	}


	public void setLibrerias(List<Libreria> librerias) {
		this.librerias = librerias;
	}


	@Override
	public String toString() {
		return "Libro [id=" + id_libro + ", titulo=" + titulo + ", precio=" + precio + ", editorial=" + editorial + ", autor="
				+ autor + "]";
	}
	
	
}
