package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class RelationshipsModel {

	@SequenceGenerator(name = "relationId", sequenceName = "RELATION_SEQUENCE", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "relationId")
	@Id
	private int id;

	@ManyToOne
	private UserModel userfollower;
	
	@ManyToOne
	private UserModel userfollowed;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserModel getUserfollower() {
		return userfollower;
	}

	public void setUserfollower(UserModel userfollower) {
		this.userfollower = userfollower;
	}

	public UserModel getUserfollowed() {
		return userfollowed;
	}

	public void setUserfollowed(UserModel userfollowed) {
		this.userfollowed = userfollowed;
	}
	
}
