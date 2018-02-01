package tn.iit.spring.tp2.entite;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Mot implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String mot;
	private long cle;
	@ManyToOne
	private Langue langue;
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Mot other = (Mot) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Mot [id=" + id + ", mot=" + mot + ", cle=" + cle + ", langue=" + langue + "]";
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getMot() {
		return mot;
	}
	public void setMot(String mot) {
		this.mot = mot;
	}
	public long getCle() {
		return cle;
	}
	public void setCle(long cle) {
		this.cle = cle;
	}
	public Langue getLangue() {
		return langue;
	}
	public void setLangue(Langue langue) {
		this.langue = langue;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Mot(Long id, String mot, long cle, Langue langue) {
		super();
		this.id = id;
		this.mot = mot;
		this.cle = cle;
		this.langue = langue;
	}
	public Mot(String mot, long cle, Langue langue) {
		super();
		this.mot = mot;
		this.cle = cle;
		this.langue = langue;
	}
	public Mot() {
		super();
	}
	
}
