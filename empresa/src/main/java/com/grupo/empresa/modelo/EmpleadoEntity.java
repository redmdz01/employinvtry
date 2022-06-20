package com.grupo.empresa.modelo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "empleado")
public class EmpleadoEntity {

	    @Id
	    @Column(name = "cedula", nullable = false)
	    private String cedula;
	    
	    @Column(name = "nombre", nullable = false)
	    private String nombre;
	    
	    @Column(name = "apellido", nullable = false)
	    private String apellido;
	    
	    @Column(name = "correo", nullable = false)
	    private String correo;

	    @Column(name = "fecha_nacimiento", nullable = true)
	    private Date fecha_nac;
	    
	    @Column(name = "direccion", nullable = true)
	    private String direccion;
	    
	    @Column(name = "telefono", nullable = true)
	    private String telefono;
	    
	    @Column(name = "vacunado", nullable = true)
	    private String vacunado;
	    
	    	    
	    public EmpleadoEntity() {
	  
	    }
	 
	    public EmpleadoEntity(String ci, String nom, String ape, String correo) {
	         this.cedula = ci;
	         this.nombre = nom;
	         this.apellido = ape;
	         this.correo= correo;
	    }
	    
	    public Date getFecha_nac() {
			return fecha_nac;
		}

		public void setFecha_nac(Date fecha_nac) {
			this.fecha_nac = fecha_nac;
		}

		public String getDireccion() {
			return direccion;
		}

		public void setDireccion(String direccion) {
			this.direccion = direccion;
		}

		public String getTelefono() {
			return telefono;
		}

		public void setTelefono(String telefono) {
			this.telefono = telefono;
		}

		public String getVacunado() {
			return vacunado;
		}

		public void setVacunado(String vacunado) {
			this.vacunado = vacunado;
		}

		public String getCedula() {
			return cedula;
		}

		public void setCedula(String cedula) {
			this.cedula = cedula;
		}

		public String getNombre() {
			return nombre;
		}

		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public String getApellido() {
			return apellido;
		}

		public void setApellido(String apellido) {
			this.apellido = apellido;
		}

		public String getCorreo() {
			return correo;
		}

		public void setCorreo(String correo) {
			this.correo = correo;
		}

		@Override
	    public String toString() {
	        return "Employee [cedula=" + cedula + ", nombre=" + nombre + ", correo=" + correo
	       + "]";
	    }
	 
	}