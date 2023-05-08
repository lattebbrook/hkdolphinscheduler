package com.example.hk.hkdolphinscheduler.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "hkfile")
public class FileSweeper {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long id;
	@Column(name = "name")
	String name;
	@Column(name = "content")
	String content;
	@Column(name = "status")
	String status;
	
	public FileSweeper() {}

	public FileSweeper(Long id, String name, String content, String status) {
		this.id = id;
		this.name = name;
		this.content = content;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setConent(String conent) {
		this.content = conent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
