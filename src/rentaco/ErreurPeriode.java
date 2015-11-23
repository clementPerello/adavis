package rentaco;

public class ErreurPeriode extends Exception {
		
		private Location source;
		
		public ErreurPeriode(String message, Location source){
		super(message);		
		this.source=source;
		}
		
		public Location getSource(){
			
			return this.source;
			
		}
	
}
