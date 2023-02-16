package net.javaguide.springboot.model;

import org.springframework.lang.NonNull;

//import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
//import lombok.NonNull;

@Data
@Entity
@Table(name="employees")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private long id;
	
@NonNull	
@Column(name = "first_name" )	
private String firstName;
@NonNull	
@Column(name = "last_name" )
private String lastName;
@NonNull	
@Column(name = "email" )
private String email;


}
