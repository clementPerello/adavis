package rentaco;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Location {
	
	private int numero ;
	private GregorianCalendar dateDebut ;
	private GregorianCalendar dateFin ;
	
	public Location(int numero){
		this.numero = numero ;
		this.dateDebut = new GregorianCalendar() ;
	}
	
	public Location(int numero, GregorianCalendar dateDebut){
		this.numero = numero ;
		this.dateDebut = dateDebut ;
	}
	
	public Location(int numero, GregorianCalendar dateDebut, GregorianCalendar dateFin) {
		super();
		this.numero = numero;
		
			if(dateFin.equals(dateDebut) || dateFin.before(dateDebut)){
				
			}
			else{		
				System.out.println("[ErreurPeriode] Constructeur(int,GC,GC) : Date de fin incohérente");
			}
			
		// Votre code ici
	}

	public int getNumero() {
		return numero;
	}

	public GregorianCalendar getDateDebut() {
		return dateDebut;
	}

	public GregorianCalendar getDateFin() {
		return dateFin;
	}
	
	public boolean estEnCours(){
		if(this.dateFin == null && ! this.estAVenir()){
			return true ;
		}
		else {
			return false ;
		}
	}
	
	public boolean estAVenir(){
		GregorianCalendar aujourdhui = new GregorianCalendar() ;
		if(aujourdhui.before(this.dateDebut)){
			return true ;
		}
		else {
			return false ;
		}
	}
	
	public boolean estTerminee(){
		if(this.dateFin != null){
			return true ;
		}
		else {
			return false ;
		}
	}
	
	public void terminer() {
		GregorianCalendar aujourdhui = new GregorianCalendar() ;
		if(! aujourdhui.before(this.dateDebut)){
			this.dateFin = aujourdhui ;
		}
		// Votre code ici
	}
	
	public void terminer(GregorianCalendar dateFin) {
		// Votre code ici
	}
	
	public void terminer(String dateFin) throws ParseException{
			DateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy") ;
			Date date = formatDate.parse(dateFin) ;
			GregorianCalendar fin = (GregorianCalendar)Calendar.getInstance() ;
			fin.setTime(date);
			if(! fin.before(this.dateDebut)){
				this.dateFin = fin ;
			}
			// Votre code ici
	}
	
	public long calculerDuree() {
		long nbJours = 0 ;
		if(this.dateFin != null){
			nbJours = (this.dateFin.getTimeInMillis() - this.dateDebut.getTimeInMillis()) / 86400000 ;
		}
		// Votre code ici
		return nbJours + 1L ;
	}

	public String toString() {
		SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy") ;
		if(this.estEnCours()){
			return "Location [numero=" + numero + 
				", debut=" + formatDate.format(this.dateDebut.getTime()) + "]";
		}
		else {
			return "Location [numero=" + numero + 
				", debut=" + formatDate.format(this.dateDebut.getTime()) + 
				", fin=" + formatDate.format(this.dateFin.getTime()) + "]";
		}
	}
	
}
