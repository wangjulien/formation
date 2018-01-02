package entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * La classe VisaPremium h�rite de Carte et a un num�ro de carte.
 * 
 * @author JW NH
 *
 */

@Entity
@DiscriminatorValue(value = "PREMIUM")
public class VisaPremium extends Carte {
	
		
	public VisaPremium() {
		super();
	}

	public VisaPremium(String noCarte) {
		super(noCarte);
	}
}