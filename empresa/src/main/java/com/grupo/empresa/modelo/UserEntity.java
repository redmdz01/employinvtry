package com.grupo.empresa.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class UserEntity {

	    @Id
	    @Column(name = "usuari", nullable = false)
	    private String usuari;
	    
	    @Column(name = "clave", nullable = false)
	    private String clave;

		public String getUsuari() {
			return usuari;
		}

		public void setUsuari(String usuari) {
			this.usuari = usuari;
		}

		public String getClave() {
			return clave;
		}

		public void setClave(String clave) {
			this.clave = clave;
		}
	 
}
