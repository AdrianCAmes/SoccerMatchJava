package pe.com.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.com.model.entity.Cancha;
import pe.com.model.entity.Ciudad;
import pe.com.model.repository.ICanchaRepository;
@Named
public class CanchaRepository implements ICanchaRepository,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="SoccerMatchPU")
	private EntityManager em;
	
	@Override
	public Integer Insert(Cancha t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer Update(Cancha t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer Delete(Cancha t) throws Exception {
		em.remove(t);
		return 1;
	}

	@Override
	public List<Cancha> FindAll() throws Exception {
		List<Cancha> cursos = new ArrayList<Cancha>();

		TypedQuery<Cancha> query = em.createQuery("SELECT c FROM Cancha c", Cancha.class);

		cursos = query.getResultList();

		return cursos;
	}

	@Override
	public Cancha FindById(Cancha t) throws Exception {
		List<Cancha> usuarios=new ArrayList<>();
		TypedQuery<Cancha> query=em.createQuery("select*from Cancha where t.id=?1",Cancha.class);
		query.setParameter(1, t.getId());
		usuarios=query.getResultList();
		return usuarios != null && !usuarios.isEmpty() ? usuarios.get(0) : new Cancha();
	}

}
