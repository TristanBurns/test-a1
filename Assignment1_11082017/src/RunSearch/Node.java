package RunSearch;

public class Node {

	private Node predecessor;
	private int name;
	private int cost; //car
	
	public Node(int name, int cost) {
		this.name = name;
		this.cost = cost;
		
	}
	
	public Node(int name, int cost, Node pre) {
		this.name = name;
		this.cost = cost;
		this.predecessor = pre;
	}
	
	public void setPre(Node pre){
		this.predecessor = pre;
	}
	
	public Node getPre() {
		return this.predecessor;
	}
	
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public int getCost() {
		return this.cost;	
	}
	
	public void setName(int name) {
		this.name = name;
	}
	
	public int getName() {
		return this.name;
	}
	
	public boolean equals(Node x) {
		if (this.name == x.getName()) {
			return true;
		} else {
			return false;
		}
	}
	
}
