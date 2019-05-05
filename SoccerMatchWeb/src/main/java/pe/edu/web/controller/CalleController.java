package pe.edu.web.controller;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import pe.com.model.business.ICalleService;
import pe.com.model.business.IDistritoService;
import pe.com.model.entity.Calle;
import pe.com.model.entity.Distrito;
import pe.com.util.Message;

@Named
@ViewScoped
public class CalleController implements Serializable{

	private static final long serialVersionUID = 1L;

	@Inject
	private ICalleService CalleService;
	
	@Inject
	private IDistritoService DistritoService;
	
	private Calle Calle;
	private Calle CalleSelec;
	
	private List<Calle> Calles;
	
	private Distrito Distrito;
	private List<Distrito> Distritos;
	
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
			Calle.setDistrito(Distrito);
			CalleService.Insert(Calle);
			Message.messageInfo("Calle guardada exitosamente");
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
