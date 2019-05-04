package pe.com.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.com.model.entity.Participante;
import pe.com.model.repository.IParticipanteRepository;
@Named
public class ParticipanteRepository implements IParticipanteRepository,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@PersistenceContext(unitName="SoccerMatchPU")
	private EntityManager em;
	@Override
	public Integer Insert(Participante t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer Update(Participante t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer Delete(Participante t) throws Exception {
		em.remove(t);
		return 1;
	}

	@Override
	public List<Participante> FindAll() throws Exception {
		List<Participante> cursos = new ArrayList<Participante>();

		TypedQuery<Participante> query = em.createQuery("SELECT c FROM Participante c", Participante.class);

		cursos = query.getResultList();

		return cursos;
	}

	@Override
	public Participante FindById(Participante t) throws Exception {
		List<Participante> usuarios=new ArrayList<>();
		TypedQuery<Participante> query=em.createQuery("select*from Participante where t.id=?1",Participante.class);
		query.setParameter(1, t.getId());
		usuarios=query.getResultList();
		return usuarios != null && !usuarios.isEmpty() ? usuarios.get(0) : new Participante();
	}

}
