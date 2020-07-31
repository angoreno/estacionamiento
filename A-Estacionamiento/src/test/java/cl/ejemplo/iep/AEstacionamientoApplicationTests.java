package cl.ejemplo.iep;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import cl.ejemplo.iep.Entity.Usuario;
import cl.ejemplo.iep.repository.UsuarioRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AEstacionamientoApplicationTests {
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	public void crearUsuarioTest() {
		
		Usuario us = new Usuario();
	
		us.setUsuario("admin");
		us.setPass(encoder.encode("admin"));
		Usuario retorno = usuarioRepo.save(us);
		
		assertTrue(retorno.getUsuario().equals(us.getUsuario()));
		
	}

}
