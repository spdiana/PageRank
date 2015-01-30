package graph;
/**
 * An Edge links two nodes.  
 * @author dcc
 *
 */
public class Edge {

	private Node from, to;
	private float weight;

	/**
	 * Constructor with two Nodes with default weight.
	 * @param from vertex origin
	 * @param to vertex destination
	 */
	public Edge(Node from, Node to) {
		this.from = from;
		this.to = to;
	}

	/**
	 * Constructor with two Nodes and a weight.
	 * @param from vertex origin
	 * @param to vertex destination
	 * @param weight the weight of the edge
	 */
	public Edge(Node from, Node to, float weight) {
		this.from = from;
		this.to = to;
		this.weight = weight;
	}

	public float getWeight() {
		return weight;
	}

	
	/**
	 * Returns a string representation of the edge.
	 */
	public String toString() {
		return from + " ==> " + to;
	}

	public Node getFrom() {
		return from;
	}

	public void setFrom(Node from) {
		this.from = from;
	}

	public Node getTo() {
		return to;
	}

	public void setTo(Node to) {
		this.to = to;
	}
}
