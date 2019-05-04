package pe.com.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.com.model.entity.Ciudad;
import pe.com.model.repository.ICiudadRepository;
@Named
public class CiudadRepository implements ICiudadRepository,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="SoccerMatchPU")
	private EntityManager em;
	
	@Override
	public Integer Insert(Ciudad t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer Update(Ciudad t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer Delete(Ciudad t) throws Exception {
		em.remove(t);
		return 1;
	}

	@Override
	public List<Ciudad> FindAll() throws Exception {
		List<Ciudad> cursos = new ArrayList<Ciudad>();

		TypedQuery<Ciudad> query = em.createQuery("SELECT c FROM Ciudad c", Ciudad.class);

		cursos = query.getResultList();

		return cursos;
	}

	@Override
	public Ciudad FindById(Ciudad t) throws Exception {
		List<Ciudad> usuarios=new ArrayList<>();
		TypedQuery<Ciudad> query=em.createQuery("select*from Ciudad where t.id=?1",Ciudad.class);
		query.setParameter(1, t.getId());
		usuarios=query.getResultList();
		return usuarios != null && !usuarios.isEmpty() ? usuarios.get(0) : new Ciudad();
	}

}
