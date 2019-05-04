package pe.com.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.com.model.business.IAlquilerService;
import pe.com.model.business.ICanchaService;
import pe.com.model.business.IEquipoService;
import pe.com.model.entity.Alquiler;
import pe.com.util.Message;

@Named
@ViewScoped
public class AlquilerController implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private IAlquilerService AlquilerService;
	
	@Inject
	private IEquipoService EquipoService;
	
	@Inject
	private ICanchaService canchaService;
	
	private Alquiler Alquiler;
	private Alquiler AlquilerSelec;
	private List<Alquiler> Alquilers;
	
	private Equipo equipo;
	private List<Equipo> equipos;
	
	private Cancha cancha;
	private List<Cancha> cancha;
	
	@PostConstruct
	public void init() {
		Alquiler = new Alquiler();
		AlquilerSelec = new Alquiler();
		this.loadAlquilers();
				
	}
	
	public void loadAlquilers()  {
		
		try {
			this.Alquilers = AlquilerService.FindAll();
		} catch (Exception e) {
			Message.messageError("Error Alquiler:" + e.getMessage());
		}
		
	}
	
	public void saveAlquiler() {
		try {
			//if(Alquiler.getId() != null)
			Alquiler.setEquipo(equipo);
			Alquiler.setCancha(cancha);
			AlquilerService.Insert(Alquiler);
			Message.messageInfo("Alquiler guardada exitosamente");
			
			loadAlquilers();
			clearForm();
		} catch (Exception e) {
			Message.messageError("Error Alquiler:" + e.getStackTrace());
		}
	}
	
	public void editAlquiler() {
		
		try {
			if(this.AlquilerSelec!= null) {
				this.Alquiler = AlquilerSelec;
			} else {
				Message.messageInfo("Debe seleccionar una Alquiler");
			}
		} catch (Exception e) {
			Message.messageError("Error Alquiler:" + e.getMessage());
		}
	}
	
	public void selectAlquiler(SelectEvent e) {
		this.AlquilerSelec = (Alquiler) e.getObject();
	}
	
	public void clearForm() {
		this.Alquiler = new Alquiler();
		this.AlquilerSelec = null;
	}

	public Alquiler getAlquiler() {
		return Alquiler;
	}

	public void setAlquiler(Alquiler Alquiler) {
		this.Alquiler = Alquiler;
	}

	public Alquiler getAlquilerSelec() {
		return AlquilerSelec;
	}

	public void setAlquilerSelec(Alquiler AlquilerSelec) {
		this.AlquilerSelec = AlquilerSelec;
	}

	public List<Alquiler> getAlquilers() {
		return Alquilers;
	}

	public void setAlquilers(List<Alquiler> Alquilers) {
		this.Alquilers = Alquilers;
	}
	
	
	
}
