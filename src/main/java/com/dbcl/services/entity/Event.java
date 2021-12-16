package com.dbcl.services.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.sql.Clob;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "event")
public class Event {
	@Id
	@Column(name = "evt_id", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long evtId;

	@Column(name = "created", nullable = false)
	private LocalDateTime created;

	@Column(name = "createdBy", nullable = false, length = 45)
	private String createdBy;

	@Column(name = "modified", nullable = false)
	private LocalDateTime modified;

	@Column(name = "modifiedBy", nullable = false, length = 45)
	private String modifiedBy;

	@Lob
	@Column(name = "evt_description", nullable = false)
	private Clob evtDescription;

	@Column(name = "ent_website")
	private String entWebsite;

	@Column(name = "event_location")
	private String eventLocation;

	@ManyToMany
	@JoinTable(name = "event_member",
			joinColumns = @JoinColumn(name = "event_evt_id"),
			inverseJoinColumns = @JoinColumn(name = "member_mbr_id"))
	private List<Member> members = new ArrayList<>();

	@OneToMany(mappedBy = "event", orphanRemoval = true)
	private List<ShootingRange> ranges = new ArrayList<>();

	public Long getEvtId() {
		return evtId;
	}

	public void setEvtId(Long evtId) {
		this.evtId = evtId;
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

	public Clob getEvtDescription() {
		return evtDescription;
	}

	public void setEvtDescription(Clob evtDescription) {
		this.evtDescription = evtDescription;
	}

	public String getEntWebsite() {
		return entWebsite;
	}

	public void setEntWebsite(String entWebsite) {
		this.entWebsite = entWebsite;
	}

	public String getEventLocation() {
		return eventLocation;
	}

	public void setEventLocation(String eventLocation) {
		this.eventLocation = eventLocation;
	}

	public List<Member> getMembers() {
		return members;
	}

	public void setMembers(List<Member> members) {
		this.members = members;
	}

	public List<ShootingRange> getRanges() {
		return ranges;
	}

	public void setRanges(List<ShootingRange> ranges) {
		this.ranges = ranges;
	}
}