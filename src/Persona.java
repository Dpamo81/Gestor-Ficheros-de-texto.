import java.io.Serializable;

public class Persona implements Serializable{
//	Definimos los atributos.	
	protected String nombre;
	protected String apellido;
	protected String ciudad;
	protected String nacionalidad;
	protected int edad;
//	Creamos el constructor.	
	public Persona(String nombre, String apellido, String ciudad, String nacionalidad, int edad){
		this.nombre= nombre;
		this.apellido = apellido;
		this.ciudad = ciudad;
		this.nacionalidad = nacionalidad;
		this.edad = edad;
	}
//	Guetters and setters.
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido() {
		this.apellido = apellido;
	}
	public String getCiudad() {
		return ciudad;
	}
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	public String getNacionalidad() {
		return nacionalidad;
	}
	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}
	public int getEdad () {
		return edad;
	}
	public void setEdad( int edad) {
		this.edad = edad;
	}	
// creamos un metodo para mostrar el resultado.
	public String print() {
		String cadena = this.getNombre() + " - " + this.getApellido() + " - " + this.getCiudad() + " - " + this.getNacionalidad() + " - " + this.getEdad();
		return cadena;
	}
}
