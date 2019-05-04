package pe.com.model.business.impl;

import java.io.Serializable;
import java.util.List;

import pe.com.model.business.IJugadorService;
import pe.com.model.entity.Jugador;
import pe.com.model.repository.IJugadorRepository;
import pe.com.model.repository.impl.JugadorRepository;

public class JugadorService implements IJugadorService,Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IJugadorRepository jugadorrp=new JugadorRepository();
	@Override
	public Integer Insert(Jugador t) throws Exception {
		// TODO Auto-generated method stub
		return jugadorrp.Insert(t);
	}

	@Override
	public Integer Update(Jugador t) throws Exception {
		// TODO Auto-generated method stub
		return jugadorrp.Update(t);
	}

	@Override
	public Integer Delete(Jugador t) throws Exception {
		// TODO Auto-generated method stub
		return jugadorrp.Delete(t);
	}

	@Override
	public List<Jugador> FindAll() throws Exception {
		// TODO Auto-generated method stub
		return jugadorrp.FindAll();
	}

	@Override
	public Jugador FindById(Jugador t) throws Exception {
		// TODO Auto-generated method stub
		return jugadorrp.FindById(t);
	}

}
