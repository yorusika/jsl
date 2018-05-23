package vo;

public class Paging {
	private int currentPage; //현재 페이지
	private int totalCount; //총 컨텐츠 수
	private int totalPage; //총 페이지 수
	private int blockCount;//한번에 표시할 컨텐츠 수
	private int blockPage; //한번에 표시할 페이지 수
	private int startCount;// 시작 컨텐츠 번호. rownum between을 위해 필요
	private int endCount;// 끝 컨텐츠 번호. rownum between을 위해 필요
	private int startPage; //시작 페이지 번호
	private int endPage; //끝 페이지 번호
	
	public Paging(int currentPage, int totalCount, int totalPage, int blockCount, int blockPage, int startCount,
			int endCount, int startPage, int endPage) {
		super();
		this.currentPage = currentPage;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
		this.blockCount = blockCount;
		this.blockPage = blockPage;
		this.startCount = startCount;
		this.endCount = endCount;
		this.startPage = startPage;
		this.endPage = endPage;
	}
	
	public Paging() {
		super();
	}
	
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getBlockCount() {
		return blockCount;
	}
	public void setBlockCount(int blockCount) {
		this.blockCount = blockCount;
	}
	public int getBlockPage() {
		return blockPage;
	}
	public void setBlockPage(int blockPage) {
		this.blockPage = blockPage;
	}
	public int getStartCount() {
		return startCount;
	}
	public void setStartCount(int startCount) {
		this.startCount = startCount;
	}
	public int getEndCount() {
		return endCount;
	}
	public void setEndCount(int endCount) {
		this.endCount = endCount;
	}
	public int getStartPage() {
		return startPage;
	}
	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}
	public int getEndPage() {
		return endPage;
	}
	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}
	
	public void pagingAction() {
		//사전에 알아야 할 것. 총 컨텐츠, 한번에 표시할 컨텐츠 수, 현재 페이지, 한번에 표시할 페이지 수
		
		//총 페이지 수는 (총 컨텐츠/한번에 표시할 컨텐츠 수)의 올림
		totalPage=(int)Math.ceil((double)this.totalCount/this.blockCount);
		if(currentPage > totalPage) {
			currentPage = totalPage;
		}
	//시작 컨텐츠 = 현재 페이지*표시할 컨텐츠 수 -(표시할 컨텐츠 수-1);
	startCount = currentPage*blockCount - (blockCount-1);
	//끝 컨텐츠 =  현재 페이지*표시할 컨텐츠 수
	endCount = currentPage*blockCount;
	//시작 페이지=(int)((현재 페이지-1)/표시할 페이지 수)*표시할 페이지 수 +1;
	startPage=(int)((currentPage-1)/blockPage)*blockPage +1;
	
	
	//마지막 페이지=시작페이지 + 표시할 페이지 수 -1;
	endPage=startPage + blockPage-1;
	if(endPage>totalPage) {
		endPage=totalPage;
	}
	
	}
	
	
	public String toString() {
		return "currentPage:"+currentPage+"totalCount"+totalCount+"totalPage"+totalPage+"blockCount"+blockCount+"blockPage"+blockPage+"startCount"+startCount+"endCount"+endCount
				+"startPage"+startPage+"endPage"+endPage;

	}
	
}
