package pe.com.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.com.model.business.ICalleService;
import pe.com.model.entity.Calle;
import pe.com.util.Message;

@Named
@ViewScoped
public class CalleController implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private ICalleService CalleService;
	
	private Calle Calle;
	private Calle CalleSelec;
	
	private List<Calle> Calles;
	
	@PostConstruct
	public void init() {
		Calle = new Calle();
		CalleSelec = new Calle();
		this.loadCalles();
				
	}
	
	public void loadCalles()  {
		
		try {
			this.Calles = CalleService.FindAll();
		} catch (Exception e) {
			Message.messageError("Error Calle:" + e.getMessage());
		}
		
	}
	
	public void saveCalle() {
		try {
			//if(Calle.getId() != null)
			Message.messageInfo("Calle guardada exitosamente");
			CalleService.Insert(Calle);
			loadCalles();
			clearForm();
		} catch (Exception e) {
			Message.messageError("Error Calle:" + e.getStackTrace());
		}
	}
	
	public void editCalle() {
		
		try {
			if(this.CalleSelec!= null) {
				this.Calle = CalleSelec;
			} else {
				Message.messageInfo("Debe seleccionar una Calle");
			}
		} catch (Exception e) {
			Message.messageError("Error Calle:" + e.getMessage());
		}
	}
	
	public void selectCalle(SelectEvent e) {
		this.CalleSelec = (Calle) e.getObject();
	}
	
	public void clearForm() {
		this.Calle = new Calle();
		this.CalleSelec = null;
	}

	public Calle getCalle() {
		return Calle;
	}

	public void setCalle(Calle Calle) {
		this.Calle = Calle;
	}

	public Calle getCalleSelec() {
		return CalleSelec;
	}

	public void setCalleSelec(Calle CalleSelec) {
		this.CalleSelec = CalleSelec;
	}

	public List<Calle> getCalles() {
		return Calles;
	}

	public void setCalles(List<Calle> Calles) {
		this.Calles = Calles;
	}
	
	
	
}
