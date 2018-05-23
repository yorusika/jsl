package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import vo.Book;
import vo.Comment;
import vo.Library;
import vo.Member;

import static db.JdbcUtils.*;
public class HongDAO {
	
	private final int BANNER_INDEX = 8;
	
	//생성자 작성. 싱글톤 패턴으로 만들어도 무관.
	private static HongDAO instance=new HongDAO();
//	public HongDAO() {}
	
	public static HongDAO getInstance() {
		return instance;
	}
	
	

	public ArrayList<Book> getSearchList(String search, int stratCount, int endCount) { //제목 검색
		// BOOK테이블의 NAME이 search를 포함하는 모든 레코드의
		// BOOK_ID와 책이름과, 이미지 파일명과, 작가이름을 찾아서 책 객체에 담은 후에
		//	ArrayList<Book>형태로 반환하는 메소드
		//검색 결과가 없을 경우 null을 반환한다.
	
		ArrayList<Book> list = null;
		String sql = "SELECT * FROM (SELECT ROWNUM RNUM, "+"book_id, name, image_name, author from book where name like '%"+ search +"%') WHERE RNUM BETWEEN "+ stratCount+" AND "+endCount;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				list = new ArrayList<Book>();
				do {
		
				list.add(new Book(rs.getString(2),
						rs.getString(3), rs.getString(4),
						rs.getString(5)));}while(rs.next());
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs != null) close(rs);
			if(pstmt != null) close(pstmt);
			if(conn != null) close(conn);
		}
	
		return list;
	}
	
	 public ArrayList<Book>  getKindSearchList(String kind, int startCount, int endCount){// 장르별 검색
			// BOOK테이블의 KIND가 kind와 일치하는 모든 레코드의
			// BOOK_ID와 책이름과, 이미지 파일명과, 작가이름을 찾아서 책 객체에 담은 후에
			//	ArrayList<Book>형태로 반환하는 메소드
		 	//검색 결과가 없을 경우 null을 반환한다.
		 
		 ArrayList<Book> list = new ArrayList<Book>();
		 
		 
		 String sql = "SELECT * FROM(SELECT ROWNUM RNUM, BOOK_ID, NAME, IMAGE_NAME, AUTHOR FROM BOOK WHERE KIND=? ORDER BY BOOK_ID DESC)WHERE RNUM BETWEEN "+startCount+" AND "+endCount;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 Connection conn = null;
		
		 
		 try {
			 conn = getConnection();
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, kind);
			 rs = pstmt.executeQuery();
		
			 while(rs.next()) {
				 list.add(new Book(
						 rs.getString("book_id"), 
						 rs.getString("name"),
						 rs.getString("image_name"),
						 rs.getString("author")));
				 

			 }
			 

		 }catch(SQLException e) {
			 e.printStackTrace();
		 }finally {
			 close(rs);
			 close(pstmt);
			 close(conn);
		 }
		return list;
		 
		 
	 }

		public int insertMember(Member dto) { //회원가입
			// MEMBER 테이블에 member 객체를 insert하고 
			// 실행 결과를 int형으로 return한다.
			String sql = "insert into member(id, pass, name) values(?, ?, ?)";
			PreparedStatement pstmt = null;
			int result = 0;
			Connection conn = null;
			
			try {
				conn = getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, dto.getId());
				pstmt.setString(2, dto.getPass());
				pstmt.setString(3, dto.getName());
				result = pstmt.executeUpdate();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			return result;
		}



	 
	public Member getLoginMember(String id, String pass) { //로그인 기능
		//MEMBER 테이블에서 ID와 PASS가 입력된 정보와 일치하는 레코드를 찾아서
		//반환하는 메소드
		//만약 입력된 정보와 일치하는 레코드가 없을 경우
		//NULL을 반환한다.
		
		Member dto = null;
		String sql = "select * from member where id = ? and pass = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pass);
			rs = pstmt.executeQuery();	
			
			if(rs.next()) {
				dto = new Member(rs.getString("id"), rs.getString("pass"));
				dto.setName(rs.getString("name"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
			close(conn);
		}
		return dto;
	}



	public int removeMember(String id) { //회원 삭제
		// Member 테이블의 ID가 받아온 id와 같은 레코드를 삭제하고,
		// 성공 여부를 int형으로 반환한다.
		String sql = "delete from member where id = ?";
		PreparedStatement pstmt = null;
		int check = 0;
		Connection conn = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			check=pstmt.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
		}
		
		return check;
	}

	public ArrayList<Book> getNewBookList() { //신간 목록 받아오기
		// ORDER BY DESC를 이용해서 
		// BOOK 테이블의 BOOK_ID 숫자가 높은 순으로 책 객체를 가져오되 다음 세가지 조건에 맞춰서 가져온다.
		// 1. 책객체에는 IMAGE_NAME과 BOOK_ID 두가지만 담는다.
		// 2. BOOK_ID가 가장 높은 책객체 10개만 ArrayList에 담는다.
		// 3. 만약 신간이 없을 경우 null을 반환한다.
		
		ArrayList<Book> list = new ArrayList<Book>();
		String sql = "select image_name, book_id, name from book order by TO_NUMBER(book_id) desc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<Book>();
			while(rs.next()) {
					Book book = new Book();
					book.setBook_id(rs.getString("book_id"));
					book.setImage_name(rs.getString("image_name"));
					book.setName(rs.getString("name"));
					list.add(book);
					
					if(list.size()>=10) {
						break;
					}
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			close(pstmt);
			if(rs!=null) close(rs);
			close(conn);
		}
		return list;
	}
	

	public ArrayList<Book> getRankinBookList() {//조회수 랭킹 도서 가져오기
		// ORDER BY DESC를 이용해서 
		// BOOK 테이블의 HIT 숫자가 높은 순으로 책 객체를 가져오되 다음 세가지 조건에 맞춰서 가져온다.
		// 1. 책객체에는 IMAGE_NAME과 BOOK_ID, HIT 세가지를 담는다.
		// 2. HIT수가 가장 높은 책객체 5개만 ArrayList에 담는다.
		// 3. 만약 결과값이 없을 경우 null을 반환한다.
		ArrayList<Book> list = null;
		String sql = "select image_name, book_id, name, hit from book order by hit desc";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			list = new ArrayList<Book>();
			while(rs.next()) {
					Book book = new Book();
					book.setBook_id(rs.getString("book_id"));
					book.setImage_name(rs.getString("image_name"));
					book.setName(rs.getString("name"));
					book.setHit(rs.getInt("hit"));
					list.add(book);
					if(list.size()>=10)break;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			if(rs!=null) close(rs);
			close(conn);
		}
		return list;
	}

	public ArrayList<Book> getLibraryList(String id, int startCount, int endCount) {// 내 서재 보기
		//LIBRARY.ID가 받아온 id와 일치하는 레코드의   
		//LIBRARY.BOOK_ID, BOOK.NAME, BOOK.AUTHOR, BOOK.IMAGE_NAME를 
		//LIBRARY와 BOOK을 JOIN해서 가져온다.
		//조인이란: http://blog.ngelmaum.org/entry/lab-note-sql-join-method
		//만약 검색 결과가 하나도 나오지 않을 경우, NULL을 반환한다. 
		
		
//		ArrayList<Book> list = new ArrayList<Book>();
		ArrayList<Book> list = null;
		String sql = "SELECT * FROM (SELECT ROWNUM RNUM, "+"library.book_id, book.name, book.author,"
				+ "book.image_name from library, book where library.book_id = book.book_id"
				+ " and library.id = ? )WHERE RNUM BETWEEN "+ startCount+" AND "+endCount;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;		
		
		
		try {			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				list = new ArrayList<Book>();
				do {list.add(new Book(
							rs.getString(2),
							rs.getString(3),
							rs.getString(5),
							rs.getString(4)							
							));
//					librarylist.add(new Library(id,rs.getString("book_id")));
//				librarylist.add(new Library(id,rs.getString("book_id")));
//				System.out.println(librarylist.get(i++).getBook_id());
				
				}while(rs.next());
					
			}else
				list=null;
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
			close(conn);
		}

		
		return list;
	}
	
	public ArrayList<Library> addLibrary(String id, ArrayList<Book> book){
		ArrayList<Library> list = new ArrayList<Library>();		
		int i=0;
		
		do{ 
			list.add(new Library(id,book.get(i).getBook_id()));
			i++;
			System.out.println(list.get(i).getBook_id());
		}while(i<book.size());		
		return list;
	}


	public Book getOneBook(String book_id) {//책 자세히 보기
		// BOOK테이블에서 BOOK_ID가 가져온 book_id와 일치하는 레코드의
		// 모든 속성(책 번호, 책 제목, 조회수, 책종류, 이미지 이름, 저자명, 목차, 소개, 저자소개)를 가져와
		// Book객체에 담아 반환한다.
		Book book = null;
		String sql = "select * from book where book_id = ?";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book_id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				book = new Book();
				book.setName(rs.getString("name"));
				book.setAuthor_introduce(rs.getString("author_introduce"));
				book.setList(rs.getString("list"));
				book.setIntroduce(rs.getString("introduce"));
				book.setImage_name(rs.getString("image_name"));
				book.setBook_id(rs.getString("book_id"));
				book.setAuthor(rs.getString("author"));
				book.setBook_folder(rs.getString("book_folder"));
				book.setBook_page(rs.getInt("book_page"));
				book.setKind(rs.getString("kind"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
			close(conn);
		}
		
		return book;
	}
	
	public Book getOneBook(String id, String book_id) {//책 자세히 보기 (대여 여부 확인)
		/* SELECT BOOK.BOOK_ID, BOOK.NAME, BOOK.HIT, BOOK.KIND, BOOK.IMAGE_NAME, BOOK.AUTHOR, BOOK.LIST, BOOK.INTRODUCE, BOOK.AUTHOR_INTRODUCE, COUNT(LIBRARY.BOOK_ID) 
		 FROM BOOK JOIN LIBRARY ON BOOK.BOOK_ID=LIBRARY.BOOK_ID WHERE LIBRARY.ID=? AND BOOK.BOOK_ID=? GROUP BY  BOOK.BOOK_ID, BOOK.NAME, BOOK.HIT, BOOK.KIND, BOOK.IMAGE_NAME, BOOK.AUTHOR, BOOK.LIST, BOOK.INTRODUCE, BOOK.AUTHOR_INTRODUCE;*/
		
		//위에 적은 SQL문을 사용하여 책번호, 책이름, 조회수, 책 종류, 이미지 이름, 저자명, 목차, 소개, 작가 소개, 대출여부를 가져와서 BOOK객체로만들어 반환한다.
		//첫번째 ?(String타입)에는 id가 두번째 ?(int 타입)에는 book_id가 들어간다.
		Book book = new Book();
		String sql = "SELECT BOOK.BOOK_ID, BOOK.NAME, BOOK.HIT, BOOK.KIND, "
				+ "BOOK.IMAGE_NAME, BOOK.AUTHOR, BOOK.LIST, BOOK.INTRODUCE, "
				+ "BOOK.AUTHOR_INTRODUCE, COUNT(LIBRARY.BOOK_ID)" + 
				" FROM BOOK LEFT OUTER JOIN LIBRARY ON BOOK.BOOK_ID=LIBRARY.BOOK_ID  AND LIBRARY.ID=? "
				+ "WHERE BOOK.BOOK_ID=? "
				+ "GROUP BY  BOOK.BOOK_ID, BOOK.NAME, BOOK.HIT, "
				+ "BOOK.KIND, BOOK.IMAGE_NAME, BOOK.AUTHOR, BOOK.LIST, BOOK.INTRODUCE, "
				+ "BOOK.AUTHOR_INTRODUCE"; 
				
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, book_id);
			
			System.out.println("id="+id);
			System.out.println("bookId="+book_id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				book= new Book(rs.getString(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7),
						rs.getString(8), rs.getString(9), rs.getInt(10));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
			close(conn);
		}
		return book;
	}
	
	
	
	public int registerCheck(String id) {
		int result=-1;
		String sql="select id from member where id=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=0;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(rs);
			close(conn);
		}
		return result;
	}
	
	
	
	public int removeshelf(String id, String book_id) {
		int result=-1;
		String sql="delete from library where id=? and book_id=?";
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, book_id);
			result=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
		}
		
		
		return result;
	}
	

	
	
	public int rent(String id, String book_id) {//라이브러리에 책 추가. 성공여부를 리턴.
		int result = 0;
		String sql = "INSERT INTO LIBRARY VALUES(?, ?, 0)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
		
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, book_id);
			result=pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
		}
		return result;
	}



	public int countCheck(String id) {
		String sql="SELECT COUNT(*) FROM LIBRARY WHERE ID=?";
		ResultSet rs = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=rs.getInt(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		return result;
		

	}



	public ArrayList<Book> getKindSearchList(String id, String kind) {
		 ArrayList<Book> list = null;
		 String sql = "select book.book_id, book.name, book.image_name, book.author, library.book_id from book LEFT OUTER JOIN library"
		 		+ " ON BOOK.BOOK_ID=LIBRARY.BOOK_ID and library.id=? WHERE book.kind = ?";
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 Connection conn = null;
		 
		 
		 
		 try {
			 conn = getConnection();
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, id);
			 pstmt.setString(2, kind);
			 rs = pstmt.executeQuery();
		if(rs.next()) {
			
		list=new ArrayList<Book>();
		
			 do {
				 Book book=new Book(
						 rs.getString(1), 
						 rs.getString(2),
						 rs.getString(3),
						 rs.getString(4));
				 
			
				 
				 book.setIsRent(rs.getString(5)!=null? 1:0);
				 
				 list.add(book);
			 }while(rs.next());
		}
		
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
				close(conn);
			}
		 
		 return list;
	}


	public int addBook(Book newBook) {
		String sql = "insert into book values (book_id_seq.nextval, ?, ?, ?, ?, ?,"
				+ "?, ?, ?, ?, ?)";
		int addCk = 0;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newBook.getName());
			pstmt.setInt(2, 0);
			pstmt.setString(3, newBook.getKind());
			pstmt.setString(4, newBook.getImage_name());
			pstmt.setString(5, newBook.getAuthor());
			pstmt.setString(6, newBook.getList());
			pstmt.setString(7, newBook.getIntroduce());
			pstmt.setString(8, newBook.getAuthor_introduce());
			pstmt.setString(9, newBook.getBook_folder());
			pstmt.setInt(10, newBook.getBook_page());
			addCk = pstmt.executeUpdate();
		} catch (SQLException e ) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
		
		System.out.println("등록된 책 페이지"+newBook.getBook_page());
		
		return addCk;
		
	}
	
	public int modifyBook(Book thisBook) {
		String sql = "update book set name = ?, kind = ?, image_name = ?, "
				+ "author = ?, list = ?, introduce = ?, author_introduce=?, "
				+ "BOOK_FOLDER=?, book_page=? where book_id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int modifyCk = 0;
		
		try {
		
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, thisBook.getName());
			pstmt.setString(2, thisBook.getKind());
			pstmt.setString(3, thisBook.getImage_name());
			pstmt.setString(4, thisBook.getAuthor());
			pstmt.setString(5, thisBook.getList());
			pstmt.setString(6, thisBook.getIntroduce());
			pstmt.setString(7, thisBook.getAuthor_introduce());
			pstmt.setString(8, thisBook.getBook_folder());
			pstmt.setInt(9, thisBook.getBook_page());
			pstmt.setString(10, thisBook.getBook_id());
			modifyCk = pstmt.executeUpdate();
			
			
			System.out.println(thisBook.getName()+","+thisBook.getKind()+","+thisBook.getImage_name()+","+thisBook.getBook_id());
			System.out.println("성공여부"+modifyCk);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
		
		return modifyCk;
		
	}
	
	public int deleteBook(String book_id) {
		String sql = "delete book where book_id = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		int deleteCk = 0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book_id);
			deleteCk = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(conn);
		}
		
		return deleteCk;
	}
	
	public ArrayList<Book> searchBook(String search) {
		String sql = "select * from book where (name like '%"+ search +"%' or author like '%"+search+"%')";
		System.out.println("sql문은"+sql);
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<Book> bookList = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			if(rs.next()) {
				bookList=new ArrayList<Book>();
				do{
					System.out.println(rs.getString("name"));
				bookList.add( new Book(rs.getString("book_id"), 
						rs.getString("name"), 
						rs.getInt("hit"), 
						rs.getString("kind"), 
						rs.getString("image_name"), 
						rs.getString("author"), 
						rs.getString("list"), 
						rs.getString("introduce"), 
						rs.getString("author_introduce")));
				}while(rs.next());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
	
	return bookList;
	

	}


	public Book getPage(String book_id) {
		String sql = "select book_id, book_folder, book_page, name from book where book_id=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Book book = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				book = new Book();
				book.setBook_id(rs.getString("book_id"));
				book.setBook_folder(rs.getString("book_folder"));
				book.setBook_page(rs.getInt("book_page"));
				book.setName(rs.getString("name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
	
	return book;		
				
	}



	public void hitUpdate(String book_id) {
		String sql = "UPDATE BOOK SET HIT=HIT+1 WHERE BOOK_ID=?";
		PreparedStatement pstmt = null;
		Connection conn = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book_id);
			
			pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return;
		
	}



	public int getTotalCount(String kind) {
		String sql = "SELECT COUNT(*) FROM BOOK WHERE KIND=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int totalCount=0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, kind);
			rs = pstmt.executeQuery();
			if(rs.next()) {
			totalCount=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
	
	return totalCount;		
				
	}



	public ArrayList<Book> getKindSearchList(String id, String kind, int startCount, int endCount) {
		 ArrayList<Book> list = null;
		 String sql ="SELECT * FROM (SELECT ROWNUM RNUM, book.book_id, book.name, book.image_name, book.author, library.book_id library_book from book LEFT OUTER JOIN library ON BOOK.BOOK_ID=LIBRARY.BOOK_ID and library.id=? WHERE book.kind = ?) WHERE RNUM BETWEEN "+ startCount+" AND "+endCount;
		 PreparedStatement pstmt = null;
		 ResultSet rs = null;
		 Connection conn = null;
		 
		 
		 
		 try {
			 conn = getConnection();
			 pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, id);
			 pstmt.setString(2, kind);
			 rs = pstmt.executeQuery();
		if(rs.next()) {
			
		list=new ArrayList<Book>();
		
			 do {
				 Book book=new Book(
						 rs.getString(2), 
						 rs.getString(3),
						 rs.getString(4),
						 rs.getString(5));
				 
			
				 
				 book.setIsRent(rs.getString(6)!=null? 1:0);
				 
				 list.add(book);
			 }while(rs.next());
		}
		
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
				close(conn);
			}
		 
		 return list;
	}



	public int getLibraryTotal(String id) {
		String sql = "SELECT COUNT(*) FROM LIBRARY WHERE ID=?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int totalCount=0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
			totalCount=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
	
	return totalCount;		
				
	}



	public int getSearchTotal(String search) {
		String sql = "SELECT COUNT(*) FROM BOOK WHERE name like '%"+ search +"%'";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int totalCount=0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if(rs.next()) {
			totalCount=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
	
	return totalCount;
	}



	public int getBook_mark(String book_id, String id) {
		String sql = "SELECT BOOK_MARK FROM LIBRARY WHERE BOOK_ID=? AND ID=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int book_mark=0;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book_id);
			pstmt.setString(2, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
			book_mark=rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
	
	return book_mark;
	}



	public void book_mark(String id, String book_id, int book_mark) {
		String sql = "UPDATE LIBRARY SET BOOK_MARK=? WHERE ID=? AND BOOK_ID=?";
		PreparedStatement pstmt = null;
		Connection conn = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, book_mark);
			pstmt.setString(2, id);
			pstmt.setString(3, book_id);
			pstmt.executeUpdate();	
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public int getComment(String id, String book_id, String comment){		
		String sql = "insert into comment_user values(comment_seq.nextval, ?, ?, ?, sysdate)";
		PreparedStatement pstmt = null;
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, book_id);
			pstmt.setString(3, comment);	
			result=pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			
			close(pstmt);
			close(conn);
		}
		return result;
		
	}

	
	public ArrayList<Comment> getCommentList(String book_id, int startCount, int endCount){
		
		
//		String sql="select * from comment_user where book_id=?";
//		String sql="select comment_user.commend_id, comment_user.id, commend_user.book_id, commend_user.inputday"
//				+ "from commend_user, commend_user where commend_user.book_id = book.book_id";
		String sql="SELECT * FROM (SELECT ROWNUM RNUM,comment_id,id,book_id,ment,inputday FROM(SELECT * FROM COMMENT_USER where BOOK_ID=? ORDER BY TO_NUMBER(comment_id) DESC))WHERE RNUM BETWEEN "+startCount+" AND "+endCount;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		
		
		ArrayList<Comment> list=null;
//		Comment com=null;
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {				
				list=new ArrayList<Comment>();			
				do {
					System.out.println("ROWNUM="+rs.getInt(1));
					
					list.add(new Comment(
							rs.getString("comment_id"),
							rs.getString("id"), 
							rs.getString("book_id"), 
							rs.getString("ment"),
							rs.getTimestamp("inputday")));
					
				} while (rs.next());
				
				
				
			}else {
				System.out.println("왜.......들어가질 않지..?");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
			close(conn);
			
		}
		
		return list;
	}
	
	public int deleteComment(String comment) {
		
		String sql = "delete from comment_user where comment_id = ?";
		PreparedStatement pstmt = null;
		Connection conn = null;
		int result = -1;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, comment);
			result = pstmt.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
			close(conn);
		}
		return result;
	}



	public int getTotalComment(String book_id) {
		String sql = "SELECT COUNT(*) from COMMENT_USER where BOOK_ID=?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Connection conn = null;
		
		int total = 0;
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, book_id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {				
				total=rs.getInt(1);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
			close(conn);
			
		}
		
		return total;
	}
}
