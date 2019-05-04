package pe.com.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.com.model.business.ICalleService;
import pe.com.model.business.IJugadorService;
import pe.com.model.entity.Calle;
import pe.com.model.entity.Jugador;
import pe.com.util.Message;

@Named
@ViewScoped
public class JugadorController implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private IJugadorService JugadorService;
	
	@Inject
	private ICalleService CalleService;
	
	private Jugador Jugador;
	private Jugador JugadorSelec;
	
	private List<Jugador> Jugadors;
	
	private Calle Calle;
	private List<Calle> Calles;
	
	@PostConstruct
	public void init() {
		Jugador = new Jugador();
		JugadorSelec = new Jugador();
		this.loadJugadors();
				
	}
	
	public void loadJugadors()  {
		
		try {
			this.Jugadors = JugadorService.FindAll();
		} catch (Exception e) {
			Message.messageError("Error Jugador:" + e.getMessage());
		}
		
	}
	
	public void saveJugador() {
		try {
			//if(Jugador.getId() != null)
			Jugador.setCalle(Calle);
			JugadorService.Insert(Jugador);
			Message.messageInfo("Jugador guardada exitosamente");
			loadJugadors();
			clearForm();
		} catch (Exception e) {
			Message.messageError("Error Jugador:" + e.getStackTrace());
		}
	}
	
	public void editJugador() {
		
		try {
			if(this.JugadorSelec!= null) {
				this.Jugador = JugadorSelec;
			} else {
				Message.messageInfo("Debe seleccionar una Jugador");
			}
		} catch (Exception e) {
			Message.messageError("Error Jugador:" + e.getMessage());
		}
	}
	
	public void selectJugador(SelectEvent e) {
		this.JugadorSelec = (Jugador) e.getObject();
	}
	
	public void clearForm() {
		this.Jugador = new Jugador();
		this.JugadorSelec = null;
	}

	public Jugador getJugador() {
		return Jugador;
	}

	public void setJugador(Jugador Jugador) {
		this.Jugador = Jugador;
	}

	public Jugador getJugadorSelec() {
		return JugadorSelec;
	}

	public void setJugadorSelec(Jugador JugadorSelec) {
		this.JugadorSelec = JugadorSelec;
	}

	public List<Jugador> getJugadors() {
		return Jugadors;
	}

	public void setJugadors(List<Jugador> Jugadors) {
		this.Jugadors = Jugadors;
	}
	
	
	
}

