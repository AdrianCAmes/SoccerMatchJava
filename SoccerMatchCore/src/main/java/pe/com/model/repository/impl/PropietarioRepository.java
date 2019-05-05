package pe.com.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.com.model.entity.Propietario;
import pe.com.model.repository.IPropietarioRepository;
@Named
public class PropietarioRepository implements IPropietarioRepository,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName="SoccerMatchPU")
	private EntityManager em;
	@Override
	public Integer Insert(Propietario t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer Update(Propietario t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer Delete(Propietario t) throws Exception {
		em.remove(t);
		return 1;
	}

	@Override
	public List<Propietario> FindAll() throws Exception {
		List<Propietario> cursos = new ArrayList<Propietario>();

		TypedQuery<Propietario> query = em.createQuery("SELECT c FROM Propietario c", Propietario.class);

		cursos = query.getResultList();

		return cursos;
	}

	@SuppressWarnings("null")
	@Override
	public Propietario FindById(Propietario t) throws Exception {
		List<Propietario> cursos = new ArrayList<Propietario>();

		TypedQuery<Propietario> query = em.createQuery("SELECT c FROM Propietario c WHERE c.id = ?", Propietario.class);
		query.setParameter(1, t.getId());

		cursos = query.getResultList();

		if (cursos != null || !cursos.isEmpty()) {
			return cursos.get(0);
		} else {
			return new Propietario();
		
	}
	}
}
