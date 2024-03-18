package mvc.com.bean;

import java.sql.Date;
import java.time.LocalDate;

public class todosBEAN {
	private int id;
	private String title, description, status;
	private LocalDate target_date;
	
	
	public LocalDate getTarget_date() {
		return target_date;
	}
	public void setTarget_date(LocalDate target_date) {
		this.target_date = target_date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "todosBEAN [id=" + id + ", title=" + title + ", description=" + description + ", status=" + status
				+ ", target_date=" + target_date + "]";
	}
	
}
