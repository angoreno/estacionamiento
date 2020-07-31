package cl.ejemplo.iep.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name="usuario")
	private String usuario;
	@Column(name="pass")
	private String pass;
	
	
	public Long getId() {
		return id;
	}
	public void setId(long i) {
		this.id = i;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", usuario=" + usuario + ", pass=" + pass + "]";
	}
	
	
	
	

}
