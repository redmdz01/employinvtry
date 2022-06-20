package com.grupo.empresa.modelo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class validador {

	public boolean validaCi(String cedula) {
		String regx = "[0-9]{10}";
		Pattern pattern = Pattern.compile(regx);
		Matcher matcher = pattern.matcher(cedula.trim());
		if (!matcher.matches()) {
			System.out.println("Error. Cedula sólo debe tener números 0-9 y tamaño 10.");
			return false;
		} else {

			return true;
		}

	}

	public boolean validaMail(String correo) {
		String regx = "^[A-Za-z0-9+_.-]+@(.+)[^!@#\\\\$%\\\\^\\\\&*\\\\)\\\\(+=.;,_-]$";
		Pattern pattern = Pattern.compile(regx);
		Matcher matcher = pattern.matcher(correo.trim());
		if (!matcher.matches()) {
			System.out.println("Error de dirección de correo electrónico.");
			return false;
		} else {
			return true;
		}
	}

	public boolean validaLetras(String campo) {
		String regx = "^[a-zA-Z ]*$";
		Pattern pattern = Pattern.compile(regx);
		Matcher matcher = pattern.matcher(campo.trim());
		if (!matcher.matches()) {
			System.out.println("Error de validacion de texto.");
			return false;
		} else {
			return true;
		}
	}

	public boolean validaEmp(EmpleadoEntity empleado) {
		try {
			int err = 0;
			if (!empleado.getCedula().isEmpty() && !empleado.getNombre().isEmpty() && !empleado.getApellido().isEmpty()
					&& !empleado.getCorreo().isEmpty()) {

				if (!validaCi(empleado.getCedula().trim())) {
					err = 1;
				}
				if (!validaMail(empleado.getCorreo().trim())) {
					err = 1;
				}
				if (!validaLetras(empleado.getNombre().trim())) {
					err = 1;
				}
				if (!validaLetras(empleado.getApellido().trim())) {
					err = 1;
				}

				if (err == 1) {
					return false;
				} else {
					return true;
				}

			}
		} catch (NullPointerException ex) {
			return false;
		}
		return false;
	}
}
