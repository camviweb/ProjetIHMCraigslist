package models;

public class Forum {
	private String name;
	private String link;
	private int threadCount;
	
	public Forum(String name, String link, int threadCount) {
		this.name=name;
		this.link=link;
		this.threadCount=threadCount;
	}
	
	public String getName() {
		return name;
	}
	
	public String getLink() {
		return link;
	}
	
	public int getThreadCount() {
		return threadCount;
	}
	
	@Override
	public String toString() {
		return "Forum{name='" + name + "', link='" + link + "', threadCount=" + threadCount + '}';
	}

}
