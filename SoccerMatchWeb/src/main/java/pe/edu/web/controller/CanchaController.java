package pe.edu.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.com.model.business.ICalleService;
import pe.com.model.business.ICanchaService;
import pe.com.model.business.IPropietarioService;
import pe.com.model.entity.Calle;
import pe.com.model.entity.Cancha;
import pe.com.model.entity.Propietario;
import pe.com.util.Message;

@Named
@ViewScoped
public class CanchaController implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private ICanchaService canchaService;
	
	@Inject
	private ICalleService CalleService;
	
	@Inject
	private IPropietarioService PropietarioService;
	
	private Cancha cancha;
	private Cancha canchaSelec;
	
	private List<Cancha> canchas;
	
	private Calle Calle;
	private List<Calle> Calles;
	
	private Propietario Propietario;
	private List<Propietario> Propietarios;
	
	@PostConstruct
	public void init() {
		cancha = new Cancha();
		canchaSelec = new Cancha();
		this.loadCanchas();
				
	}
	
	public void loadCanchas()  {
		
		try {
			this.canchas = canchaService.FindAll();
		} catch (Exception e) {
			Message.messageError("Error Cancha:" + e.getMessage());
		}
		
	}
	
	public void saveCancha() {
		try {
			//if(cancha.getId() != null)
			cancha.setCalle(Calle);
			cancha.setPropietario(Propietario);
			canchaService.Insert(cancha);
			Message.messageInfo("Cancha guardada exitosamente");
			loadCanchas();
			clearForm();
		} catch (Exception e) {
			Message.messageError("Error Cancha:" + e.getStackTrace());
		}
	}
	
	public void editCancha() {
		
		try {
			if(this.canchaSelec!= null) {
				this.cancha = canchaSelec;
			} else {
				Message.messageInfo("Debe seleccionar una cancha");
			}
		} catch (Exception e) {
			Message.messageError("Error Cancha:" + e.getMessage());
		}
	}
	
	public void selectCancha(SelectEvent e) {
		this.canchaSelec = (Cancha) e.getObject();
	}
	
	public void clearForm() {
		this.cancha = new Cancha();
		this.canchaSelec = null;
	}

	public Cancha getCancha() {
		return cancha;
	}

	public void setCancha(Cancha cancha) {
		this.cancha = cancha;
	}

	public Cancha getCanchaSelec() {
		return canchaSelec;
	}

	public void setCanchaSelec(Cancha canchaSelec) {
		this.canchaSelec = canchaSelec;
	}

	public List<Cancha> getCanchas() {
		return canchas;
	}

	public void setCanchas(List<Cancha> canchas) {
		this.canchas = canchas;
	}
	
	
	
}
