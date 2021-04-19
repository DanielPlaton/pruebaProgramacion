package modelo;

import java.util.Collection;
import java.util.Random;

public interface Vacunable {

	public default void vacunar(Infectable infectado) {
		 Random r = new Random();
			int numero = r.nextInt(5) + 1;
			//este if es para vacunar a 1 de 5 estadisticamente
		  if(numero== 1) {
			  infectado.infectar(false);
		  }
		

	}

	public default void vacunar(Collection<Infectable> personas) {
		  for(Infectable i : personas) {
			  Random r = new Random();
				int numero = r.nextInt(5) + 1;
				//este if es para vacunar a 1 o 2 personas de 5 
			  if(numero== 1 || numero ==2) {
				  vacunar(i); 
			  }
	            
	        }
	}
}