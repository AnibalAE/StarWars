package com.phoebus.StarWars.repositories;




import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.phoebus.StarWars.model.Rebelde;
import com.phoebus.StarWars.repository.RebeldeRepository;
import com.phoebus.StarWars.resource.RebeldeResource;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RebeldeRepositoryTest {

	@Autowired
	private RebeldeRepository rebeldeRepository;
	
	
	@Autowired
    private RebeldeResource rebeldeResource;
	
	@Test
	public void excluirRebelde(){
		Rebelde rebelde = new Rebelde("Luke", 30, "Masculino", "Tatooine", false, 0);
		this.rebeldeResource.salvaRebelde(rebelde);
		rebeldeRepository.delete(rebelde);
	}
	
	@Test
	public void salvarRebelde() throws Exception{
		Rebelde rebelde = new Rebelde("Luke", 30, "Masculino", "Tatooine", false, 0);
        this.rebeldeResource.salvaRebelde(rebelde);
	}
	
	@Test
	public void atualizarLocalizacaoRebelde() throws Exception{
		Rebelde rebelde = new Rebelde("Luke", 30, "Masculino", "Tatooine", false, 0);
        this.rebeldeResource.salvaRebelde(rebelde);
        rebelde.setLocalidade("Coruscant");
        this.rebeldeResource.salvaRebelde(rebelde);
	}
}
