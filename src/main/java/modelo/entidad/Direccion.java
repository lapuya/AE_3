package modelo.entidad;

import javax.persistence.Embeddable;

@Embeddable
public class Direccion {
	private String calle, ciudad, pais, codigoPostal;
	private int numero;
	
	public Direccion() {
		super();
	}
	
	public Direccion(String calle, int numero, String ciudad, String pais, String codigoPostal) {
        super();
        this.calle = calle;
        this.numero = numero;
        this.ciudad = ciudad;
        this.pais = pais;
        this.codigoPostal = codigoPostal;
}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	@Override
	public String toString() {
		return "Direccion [calle=" + calle + ", ciudad=" + ciudad + ", pais=" + pais + ", codigoPostal=" + codigoPostal
				+ ", numero=" + numero + "]";
	}
	
	
	 
	
	 


}
