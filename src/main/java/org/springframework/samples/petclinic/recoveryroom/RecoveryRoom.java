package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Transient;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Getter
@Setter
@Entity
public class RecoveryRoom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
	
	@NotNull
	@Size(min = 3, max = 50)
    String name;
	
	@NotNull
	@Min(0)
    double size;
	
	@NotNull
    boolean secure;
	
	@NotNull
    @ManyToOne(optional=false)
	@JoinColumn(name = "roomType", referencedColumnName = "id")
    RecoveryRoomType roomType;
}
