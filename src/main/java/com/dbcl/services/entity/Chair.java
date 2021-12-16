package com.dbcl.services.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "chair")
public class Chair {
	@Id
	@Column(name = "chair_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long chairId;

	@Column(name = "created", nullable = false)
	private LocalDateTime created;

	@Column(name = "createdBy", nullable = false, length = 45)
	private String createdBy;

	@Column(name = "modified", nullable = false)
	private LocalDateTime modified;

	@Column(name = "modifiedBy", nullable = false, length = 45)
	private String modifiedBy;

	@Column(name = "chair_description", nullable = false)
	private String chairDescription;

	public Long getChairId() {
		return chairId;
	}

	public void setChairId(Long chairId) {
		this.chairId = chairId;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDateTime getModified() {
		return modified;
	}

	public void setModified(LocalDateTime modified) {
		this.modified = modified;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public String getChairDescription() {
		return chairDescription;
	}

	public void setChairDescription(String chairDescription) {
		this.chairDescription = chairDescription;
	}
}