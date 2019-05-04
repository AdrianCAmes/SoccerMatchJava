package pe.com.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.com.model.entity.Distrito;
import pe.com.model.repository.IDistritoRepository;
@Named
public class DistritoRepository implements IDistritoRepository,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="SoccerMatchPU")
	
	private EntityManager em;
	
	@Override
	public Integer Insert(Distrito t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer Update(Distrito t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer Delete(Distrito t) throws Exception {
		em.remove(t);
		return 1;
	}

	@Override
	public List<Distrito> FindAll() throws Exception {
		List<Distrito> cursos = new ArrayList<Distrito>();

		TypedQuery<Distrito> query = em.createQuery("SELECT c FROM Distrito c", Distrito.class);

		cursos = query.getResultList();

		return cursos;
	}

	@Override
	public Distrito FindById(Distrito t) throws Exception {
		List<Distrito> usuarios=new ArrayList<>();
		TypedQuery<Distrito> query=em.createQuery("select*from Distrito where t.id=?1",Distrito.class);
		query.setParameter(1, t.getId());
		usuarios=query.getResultList();
		return usuarios != null && !usuarios.isEmpty() ? usuarios.get(0) : new Distrito();
	}

}
