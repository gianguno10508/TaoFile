package updateFile;


public class Exel_Data {
	private int id;
	private String urlName;
	
	public Exel_Data(int id, String urlName) {
		this.id = id;
		this.urlName = urlName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUrlName() {
		return urlName;
	}

	public void setUrlName(String urlName) {
		this.urlName = urlName;
	}
	
}
