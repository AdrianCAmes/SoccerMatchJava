package pe.com.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.com.model.entity.DetalleParticipante;
import pe.com.model.entity.Distrito;
import pe.com.model.repository.IDetalleParticipanteRepository;
@Named
public class DetalleParticipanteRepository implements IDetalleParticipanteRepository,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="SoccerMatchPU")
	private EntityManager em;
	
	@Override
	public Integer Insert(DetalleParticipante t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer Update(DetalleParticipante t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer Delete(DetalleParticipante t) throws Exception {
		em.remove(t);
		return 1;
	}

	@Override
	public List<DetalleParticipante> FindAll() throws Exception {
		List<DetalleParticipante> cursos = new ArrayList<DetalleParticipante>();

		TypedQuery<DetalleParticipante> query = em.createQuery("SELECT c FROM DetalleParticipante c", DetalleParticipante.class);

		cursos = query.getResultList();

		return cursos;
	}

	@Override
	public DetalleParticipante FindById(DetalleParticipante t) throws Exception {
		List<DetalleParticipante> usuarios=new ArrayList<>();
		TypedQuery<DetalleParticipante> query=em.createQuery("select*from DetalleParticipante where t.id=?1",DetalleParticipante.class);
		query.setParameter(1, t.getId());
		usuarios=query.getResultList();
		return usuarios != null && !usuarios.isEmpty() ? usuarios.get(0) : new DetalleParticipante();
	}

}
