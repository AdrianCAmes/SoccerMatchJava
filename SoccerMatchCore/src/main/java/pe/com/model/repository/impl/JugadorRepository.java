package pe.com.model.repository.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import pe.com.model.entity.Jugador;
import pe.com.model.repository.IJugadorRepository;
@Named
public class JugadorRepository implements IJugadorRepository,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@PersistenceContext(unitName = "SoccerMatchPU")
	private EntityManager em;
	
	@Override
	public Integer Insert(Jugador t) throws Exception {
		em.persist(t);
		return t.getId();
	}

	@Override
	public Integer Update(Jugador t) throws Exception {
		em.merge(t);
		return t.getId();
	}

	@Override
	public Integer Delete(Jugador t) throws Exception {
		em.remove(t);
		return 1;
	}

	@Override
	public List<Jugador> FindAll() throws Exception {
		List<Jugador> cursos = new ArrayList<Jugador>();

		TypedQuery<Jugador> query = em.createQuery("SELECT c FROM Jugador c", Jugador.class);

		cursos = query.getResultList();

		return cursos;
	}

	@Override
	public Jugador FindById(Jugador t) throws Exception {
		List<Jugador> usuarios=new ArrayList<>();
		TypedQuery<Jugador> query=em.createQuery("select*from Jugador where t.id=?1",Jugador.class);
		query.setParameter(1, t.getId());
		usuarios=query.getResultList();
		return usuarios != null && !usuarios.isEmpty() ? usuarios.get(0) : new Jugador();
	}

}
