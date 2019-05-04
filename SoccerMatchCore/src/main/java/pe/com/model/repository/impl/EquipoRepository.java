package pe.com.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.com.model.entity.Equipo;
import pe.com.model.entity.Jugador;
import pe.com.model.repository.IEquipoRepository;
@Named
public class EquipoRepository implements IEquipoRepository,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName="SoccerMatchPU")
	private EntityManager em;
	
	@Override
	public Integer Insert(Equipo t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer Update(Equipo t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer Delete(Equipo t) throws Exception {
		em.remove(t);
		return 1;
	}

	@Override
	public List<Equipo> FindAll() throws Exception {
		List<Equipo> cursos = new ArrayList<Equipo>();

		TypedQuery<Equipo> query = em.createQuery("SELECT c FROM Equipo c", Equipo.class);

		cursos = query.getResultList();

		return cursos;
	}

	@Override
	public Equipo FindById(Equipo t) throws Exception {
		List<Equipo> usuarios=new ArrayList<>();
		TypedQuery<Equipo> query=em.createQuery("select*from Equipo where t.id=?1",Equipo.class);
		query.setParameter(1, t.getId());
		usuarios=query.getResultList();
		return usuarios != null && !usuarios.isEmpty() ? usuarios.get(0) : new Equipo();
	}

}
