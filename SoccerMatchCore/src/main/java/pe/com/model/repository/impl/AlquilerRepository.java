package pe.com.model.repository.impl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.com.model.entity.Alquiler;
import pe.com.model.entity.Calle;
import pe.com.model.repository.IAlquilerRepository;

@Named
public class AlquilerRepository implements IAlquilerRepository,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="SoccerMatchPU")
	private EntityManager em;
	
	@Override
	public Integer Insert(Alquiler t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer Update(Alquiler t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer Delete(Alquiler t) throws Exception {
		em.remove(t);
		return 1;
	}

	@Override
	public List<Alquiler> FindAll() throws Exception {
		List<Alquiler> cursos = new ArrayList<Alquiler>();

		TypedQuery<Alquiler> query = em.createQuery("SELECT c FROM Alquiler c", Alquiler.class);

		cursos = query.getResultList();

		return cursos;
	}

	@Override
	public Alquiler FindById(Alquiler t) throws Exception {
		List<Alquiler> usuarios=new ArrayList<>();
		TypedQuery<Alquiler> query=em.createQuery("select*from Alquiler where t.id=?1",Alquiler.class);
		query.setParameter(1, t.getId());
		usuarios=query.getResultList();
		return usuarios != null && !usuarios.isEmpty() ? usuarios.get(0) : new Alquiler();
	}

}
