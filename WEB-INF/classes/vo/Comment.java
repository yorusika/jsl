package vo;

import java.sql.Timestamp;

public class Comment {
	
	private String comment_id;
	private String id;
	private String book_id;
	private String comment;
	private Timestamp date;
	
	public Comment() {}
	
	public Comment(String id, String book_id, String comment, Timestamp date) {
		super();
		this.id = id;
		this.book_id = book_id;
		this.comment = comment;
		this.date = date;
	}	
	
	public Comment(String comment_id, String id, String book_id, String comment, Timestamp date) {
		super();
		this.comment_id = comment_id;
		this.id = id;
		this.book_id = book_id;
		this.comment = comment;
		this.date = date;
	}

	public String getComment_id() {
		return comment_id;
	}

	public void setComment_id(String comment_id) {
		this.comment_id = comment_id;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBook_id() {
		return book_id;
	}
	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	
	
	

}
