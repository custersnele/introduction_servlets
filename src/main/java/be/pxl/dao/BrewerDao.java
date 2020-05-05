package be.pxl.dao;


import be.pxl.domain.Brewer;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class BrewerDao {
	private EntityManager entityManager;

	public BrewerDao(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	public List<Brewer> findByCity(String city) {
		TypedQuery<Brewer> findByCity = entityManager.createNamedQuery("findByCity", Brewer.class);
		System.out.println("findByCity" + findByCity);
		findByCity.setParameter("city", city);
		
		return findByCity.getResultList();
	}

}
