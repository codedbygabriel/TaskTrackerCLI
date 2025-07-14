package br.student.gabriel.entities;

import java.util.Date;

public class Task {
	private int ID;
	private String status;
	private String description;
	private Date createdAt;
	private Date updatedAt;


	public Task(int ID, String description) {
		this.ID = ID;
		this.status = "todo";
		this.description = description;
		this.createdAt = new Date();
		this.updatedAt = new Date();
	}

	public Task(int ID, String description, Date createdAt, Date updatedAt, String status) {
		this.ID = ID;
		this.status = status;
		this.description = description;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}

	@Override
	public String toString() {
		return "Task{" +
				"ID=" + ID +
				", status='" + status + '\'' +
				", description='" + description + '\'' +
				", createdAt=" + createdAt +
				", updatedAt=" + updatedAt +
				'}';
	}

// Getters and Setters

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt() {
		this.updatedAt = new Date();
	}
}
