package vo;

public class Book {
	private String book_id; //책의 고유 번호. 시퀀스
	private String name; //책의 타이틀
	private int hit;	//조회수
	private String kind; //책의 종류
	private String image_name; //책 이미지의 파일명
	private String author; //저자 이름
	private String list; //목차
	private String introduce; //책 소개
	private String author_introduce; //저자소개
	private int isRent; //대여 여부를 확인하는 변수
	private String book_folder;	
	private int book_page;
	private int book_mark;
	
	



	//디폴트 생성자
	public Book() {}
	
	
	//index페이지에서 새 책 목록이나, 책 순위를 찍어주기 위한 생성자
	public Book(String book_id, String image_name) {
		super();
		this.book_id = book_id;
		this.image_name = image_name;
	}

	
	
	//검색 페이지나, 내 서재목록에서 간략화된 정보를 보여주기 위한 생성자
	
	public Book(String book_id, String name, String image_name, String author) {
		super();
		this.book_id = book_id;
		this.name = name;
		this.image_name = image_name;
		this.author = author;
	}
	//관리자 기능을 위한 생성자
	public Book(String book_id, String name, String kind, String image_name, String author, String list,
			String introduce, String author_introduce) {
		super();
		this.book_id = book_id;
		this.name = name;
		this.kind = kind;
		this.image_name = image_name;
		this.author = author;
		this.list = list;
		this.introduce = introduce;
		this.author_introduce = author_introduce;
	}
	
	//비로그인 회원에게 자세한 정보를 보여주기 위한 생성자
	public Book(String book_id, String name, int hit, String kind, String image_name, String author, String list,
			String introduce, String author_introduce) {
		super();
		this.book_id = book_id;
		this.name = name;
		this.hit = hit;
		this.kind = kind;
		this.image_name = image_name;
		this.author = author;
		this.list = list;
		this.introduce = introduce;
		this.author_introduce = author_introduce;
	}

	//로그인 회원에게 자세한 정보를 보여주기 위한 생성자
	public Book(String book_id, String name, int hit, String kind, String image_name, String author, String list,
			String introduce, String author_introduce, int isRent) {
		super();
		this.book_id = book_id;
		this.name = name;
		this.hit = hit;
		this.kind = kind;
		this.image_name = image_name;
		this.author = author;
		this.list = list;
		this.introduce = introduce;
		this.author_introduce = author_introduce;
		this.isRent = isRent;
	}





	public String getBook_id() {
		return book_id;
	}


	public void setBook_id(String book_id) {
		this.book_id = book_id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getHit() {
		return hit;
	}


	public void setHit(int hit) {
		this.hit = hit;
	}


	public String getKind() {
		return kind;
	}


	public void setKind(String kind) {
		this.kind = kind;
	}


	public String getImage_name() {
		return image_name;
	}


	public void setImage_name(String image_name) {
		this.image_name = image_name;
	}


	public String getAuthor() {
		return author;
	}


	public void setAuthor(String author) {
		this.author = author;
	}


	public String getList() {
		return list;
	}


	public void setList(String list) {
		this.list = list;
	}


	public String getIntroduce() {
		return introduce;
	}


	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}


	public String getAuthor_introduce() {
		return author_introduce;
	}


	public void setAuthor_introduce(String author_introduce) {
		this.author_introduce = author_introduce;
	}


	public int getIsRent() {
		return isRent;
	}


	public void setIsRent(int isRent) {
		this.isRent = isRent;
	}
	
	
	public String getBook_folder() {
		return book_folder;
	}


	public void setBook_folder(String book_folder) {
		this.book_folder = book_folder;
	}


	public int getBook_page() {
		return book_page;
	}


	public void setBook_page(int book_page) {
		this.book_page = book_page;
	}
	
	
	public int getBook_mark() {
		return book_mark;
	}


	public void setBook_mark(int book_mark) {
		this.book_mark = book_mark;
	}
}
