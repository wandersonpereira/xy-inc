package com.zup.poi.repository;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.zup.poi.models.Poi;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PoiRepositoryTest {

	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private PoiRepository poiRepository;
	
	@Test
	public void whenAddCoordinate_thenCreatePoi() {
		entityManager.persist(new Poi("Lanchonete", 27, 12));
		entityManager.persist(new Poi("Posto", 31, 18));
		entityManager.persist(new Poi("Joalheria", 15, 12));
		entityManager.persist(new Poi("Floricultura", 19, 21));
		entityManager.persist(new Poi("Pub", 12, 8));
		entityManager.persist(new Poi("Supermercado", 23, 6));
		entityManager.persist(new Poi("Churrascaria", 28, 2));
		entityManager.flush();
	}
	
	@Test
	public void whenFindByCoordinate_thenReturnPoi() {		
	
		List<String> list = poiRepository.findAllByCoordinate(20, 10, 10);
		
		List<String> listItems = new ArrayList<String>();
		listItems.add("Lanchonete");
		listItems.add("Joalheria");
		listItems.add("Pub");
		listItems.add("Supermercado");
		
		assertThat(list).isNotEmpty().containsAll(listItems);
	}
	
	@Test
	public void whenFindByCoordinate_thenFailTest() {		
	
		List<String> list = poiRepository.findAllByCoordinate(20, 10, 10);
		assertThat(list).isNotEmpty().doesNotContain("Churrascaria");
	}
	
	@Test
	public void whenFindAllItems_thenReturnPoi() {		
		Iterable<Poi> listPois = poiRepository.findAll();	
		assertThat(listPois).isNotEmpty().hasSize(7);
	}
	
	@Test
	public void whenDeleteAllPois_thenFinishedTest() {
		poiRepository.deleteAll();
		Iterable<Poi> listPois = poiRepository.findAll();
		assertThat(listPois).isEmpty();
	}
}
