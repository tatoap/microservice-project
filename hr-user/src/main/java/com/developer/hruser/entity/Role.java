package com.developer.hruser.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_role")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Role implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@EqualsAndHashCode.Include
	private String roleName;
	
	public Role() {
		
	}

	public Role(Long id, @NotBlank String roleName) {
		this.id = id;
		this.roleName = roleName;
	}
	
}
