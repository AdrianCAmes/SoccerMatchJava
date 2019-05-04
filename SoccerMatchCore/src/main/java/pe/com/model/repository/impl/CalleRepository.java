package pe.com.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.com.model.entity.Calle;
import pe.com.model.entity.Cancha;
import pe.com.model.repository.ICalleRepository;
@Named
public class CalleRepository implements ICalleRepository,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="SoccerMatchPU")
	private EntityManager em;
	
	@Override
	public Integer Insert(Calle t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer Update(Calle t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer Delete(Calle t) throws Exception {
		em.remove(t);
		return 1;
	}

	@Override
	public List<Calle> FindAll() throws Exception {
		List<Calle> cursos = new ArrayList<Calle>();

		TypedQuery<Calle> query = em.createQuery("SELECT c FROM Calle c", Calle.class);

		cursos = query.getResultList();

		return cursos;
	}

	@Override
	public Calle FindById(Calle t) throws Exception {
		List<Calle> usuarios=new ArrayList<>();
		TypedQuery<Calle> query=em.createQuery("select*from Calle where t.id=?1",Calle.class);
		query.setParameter(1, t.getId());
		usuarios=query.getResultList();
		return usuarios != null && !usuarios.isEmpty() ? usuarios.get(0) : new Calle();
	}

}
