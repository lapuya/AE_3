package modelo.persistencia;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import modelo.entidad.Autor;

public class AutorDao {
	
	private EntityManager em;
	
	private boolean abrirConexion(){
		try {
			EntityManagerFactory factoria = Persistence.createEntityManagerFactory("Actividad3");
			em = factoria.createEntityManager();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private boolean cerrarConexion(){
		try {
			em.close();
			return true;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public int insertar(Autor a) {
		if(!abrirConexion()) {
			return 0;
		}
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(a);
		et.commit();
		cerrarConexion();
		
		return a.getId();
	}

	@SuppressWarnings("unchecked")
	public List<Autor> listar() {
		if(!abrirConexion()) {
			return null;
		}		
		//para hacer la consulta debemos de usar JPQL
		Query query = em.createQuery("select from Autor a");
		List<Autor> listaAutores = query.getResultList();
		return listaAutores;
	}
}
