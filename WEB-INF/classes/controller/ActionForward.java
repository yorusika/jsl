package controller;

public class ActionForward {
	private String path;
	private boolean redirec;
	
	public ActionForward(String path, boolean redirec) {
		super();
		this.path = path;
		this.redirec = redirec;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isRedirec() {
		return redirec;
	}

	public void setRedirec(boolean redirec) {
		this.redirec = redirec;
	}
	
	
}
