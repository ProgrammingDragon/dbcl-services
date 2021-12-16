package com.dbcl.services.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "shooting_range")
public class ShootingRange {
	@Id
	@Column(name = "id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long rangeId;

	@Column(name = "created", nullable = false)
	private LocalDateTime created;

	@Column(name = "createdBy", nullable = false, length = 45)
	private String createdBy;

	@Column(name = "modified", nullable = false)
	private LocalDateTime modified;

	@Column(name = "modifiedBy", nullable = false, length = 45)
	private String modifiedBy;

	@Column(name = "description", nullable = false)
	private String rangeDescription;

	@Column(name = "open")
	private Boolean rangeOpen;

	@ManyToOne
	@JoinColumn(name = "event_evt_id")
	private Event event;

	public Event getEvents() {
		return event;
	}

	public void setEvents(Event event) {
		this.event = event;
	}

	public Long getRangeId() {
		return rangeId;
	}

	public void setRangeId(Long rangeId) {
		this.rangeId = rangeId;
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

	public String getRangeDescription() {
		return rangeDescription;
	}

	public void setRangeDescription(String rangeDescription) {
		this.rangeDescription = rangeDescription;
	}

	public Boolean getRangeOpen() {
		return rangeOpen;
	}

	public void setRangeOpen(Boolean rangeOpen) {
		this.rangeOpen = rangeOpen;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
}