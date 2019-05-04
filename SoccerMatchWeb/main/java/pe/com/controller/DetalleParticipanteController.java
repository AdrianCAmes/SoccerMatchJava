package pe.com.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.com.model.business.IAlquilerService;
import pe.com.model.business.IDetalleParticipanteService;
import pe.com.model.business.IParticipanteService;
import pe.com.model.entity.DetalleParticipante;
import pe.com.util.Message;

@Named
@ViewScoped
public class DetalleParticipanteController implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private IDetalleParticipanteService DetalleParticipanteService;
	
	@Inject
	private IAlquilerService AlquilerService;
	
	@Inject
	private IParticipanteService ParticipanteService;
	
	private DetalleParticipante DetalleParticipante;
	private DetalleParticipante DetalleParticipanteSelec;
	private List<DetalleParticipante> DetalleParticipantes;
	
	private Alquiler alquiler;
	private List<Alquiler> alquilers;
	
	private Participante participante;
	private List<Participante> participante;
	
	@PostConstruct
	public void init() {
		DetalleParticipante = new DetalleParticipante();
		DetalleParticipanteSelec = new DetalleParticipante();
		this.loadDetalleParticipantes();
				
	}
	
	public void loadDetalleParticipantes()  {
		
		try {
			this.DetalleParticipantes = DetalleParticipanteService.FindAll();
		} catch (Exception e) {
			Message.messageError("Error DetalleParticipante:" + e.getMessage());
		}
		
	}
	
	public void saveDetalleParticipante() {
		try {
			//if(DetalleParticipante.getId() != null)
			DetalleParticipante.setAlquiler(alquiler);
			DetalleParticipante.setParticipante(participante);
			DetalleParticipanteService.Insert(DetalleParticipante);
			Message.messageInfo("DetalleParticipante guardada exitosamente");
			loadDetalleParticipantes();
			clearForm();
		} catch (Exception e) {
			Message.messageError("Error DetalleParticipante:" + e.getStackTrace());
		}
	}
	
	public void editDetalleParticipante() {
		
		try {
			if(this.DetalleParticipanteSelec!= null) {
				this.DetalleParticipante = DetalleParticipanteSelec;
			} else {
				Message.messageInfo("Debe seleccionar una DetalleParticipante");
			}
		} catch (Exception e) {
			Message.messageError("Error DetalleParticipante:" + e.getMessage());
		}
	}
	
	public void selectDetalleParticipante(SelectEvent e) {
		this.DetalleParticipanteSelec = (DetalleParticipante) e.getObject();
	}
	
	public void clearForm() {
		this.DetalleParticipante = new DetalleParticipante();
		this.DetalleParticipanteSelec = null;
	}

	public DetalleParticipante getDetalleParticipante() {
		return DetalleParticipante;
	}

	public void setDetalleParticipante(DetalleParticipante DetalleParticipante) {
		this.DetalleParticipante = DetalleParticipante;
	}

	public DetalleParticipante getDetalleParticipanteSelec() {
		return DetalleParticipanteSelec;
	}

	public void setDetalleParticipanteSelec(DetalleParticipante DetalleParticipanteSelec) {
		this.DetalleParticipanteSelec = DetalleParticipanteSelec;
	}

	public List<DetalleParticipante> getDetalleParticipantes() {
		return DetalleParticipantes;
	}

	public void setDetalleParticipantes(List<DetalleParticipante> DetalleParticipantes) {
		this.DetalleParticipantes = DetalleParticipantes;
	}
	
	
	
}

