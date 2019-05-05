package pe.edu.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.com.model.business.IEquipoService;
import pe.com.model.business.IJugadorService;
import pe.com.model.business.IParticipanteService;
import pe.com.model.entity.Equipo;
import pe.com.model.entity.Jugador;
import pe.com.model.entity.Participante;
import pe.com.util.Message;

@Named
@ViewScoped
public class ParticipanteController implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private IParticipanteService ParticipanteService;
	
	@Inject
	private IJugadorService JugadorService;
	
	@Inject
	private IEquipoService EquipoService;
	
	private Participante Participante;
	private Participante ParticipanteSelec;
	private List<Participante> Participantes;
	
	private Equipo equipo;
	private List<Equipo> equipos;
	
	private Jugador Jugador;
	private List<Jugador> Jugadors;
	
	@PostConstruct
	public void init() {
		Participante = new Participante();
		ParticipanteSelec = new Participante();
		this.loadParticipantes();
				
	}
	
	public void loadParticipantes()  {
		
		try {
			this.Participantes = ParticipanteService.FindAll();
		} catch (Exception e) {
			Message.messageError("Error Participante:" + e.getMessage());
		}
		
	}
	
	public void saveParticipante() {
		try {
			//if(Participante.getId() != null)
			Participante.setEquipo(equipo);
			Participante.setJugador(Jugador);
			ParticipanteService.Insert(Participante);
			Message.messageInfo("Participante guardada exitosamente");
			loadParticipantes();
			clearForm();
		} catch (Exception e) {
			Message.messageError("Error Participante:" + e.getStackTrace());
		}
	}
	
	public void editParticipante() {
		
		try {
			if(this.ParticipanteSelec!= null) {
				this.Participante = ParticipanteSelec;
			} else {
				Message.messageInfo("Debe seleccionar una Participante");
			}
		} catch (Exception e) {
			Message.messageError("Error Participante:" + e.getMessage());
		}
	}
	
	public void selectParticipante(SelectEvent e) {
		this.ParticipanteSelec = (Participante) e.getObject();
	}
	
	public void clearForm() {
		this.Participante = new Participante();
		this.ParticipanteSelec = null;
	}

	public Participante getParticipante() {
		return Participante;
	}

	public void setParticipante(Participante Participante) {
		this.Participante = Participante;
	}

	public Participante getParticipanteSelec() {
		return ParticipanteSelec;
	}

	public void setParticipanteSelec(Participante ParticipanteSelec) {
		this.ParticipanteSelec = ParticipanteSelec;
	}

	public List<Participante> getParticipantes() {
		return Participantes;
	}

	public void setParticipantes(List<Participante> Participantes) {
		this.Participantes = Participantes;
	}
	
	
	
}

