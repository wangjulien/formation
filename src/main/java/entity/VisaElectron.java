package entity;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * La classe VisaElectron h�rite de Carte et a un num�ro de carte.
 * 
 * @author JW NH
 *
 */

@XmlRootElement
@Entity
@DiscriminatorValue(value = "ELECTRON")
public class VisaElectron extends Carte {
	
	
	
	public VisaElectron() {
		super();
	}

	public VisaElectron(String noCarte) {
		super(noCarte);
	}
}