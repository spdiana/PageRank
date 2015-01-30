package graph;
/**
 * A node represents one vertex in a graph.
 * @author dcc
 *
 */
import java.util.ArrayList;
import java.util.List;

public class Node {

	private int id;
	private String label;
	public boolean visited;

	/** out - outgoing edges of the node. */
	private List<Edge> outgoingEdges;
	
	/** in - incoming edges of the node.	 */
	private List<Edge> incomingEdges;

	/**
	 * Constructor with id and label.
	 * @param id id node
	 * @param label label node
	 */
	public Node(int id, String label) {
		outgoingEdges = new ArrayList<Edge>();
		incomingEdges = new ArrayList<Edge>();
		this.label = label;
		this.id = id;
	}

	/**
	 *  Constructor with id.
	 * @param id id node
	 */
	public Node(int id) {
		outgoingEdges = new ArrayList<Edge>();
		incomingEdges = new ArrayList<Edge>();
		this.setId(id);
	}


	public List<Edge> getIncomingEdges() {
		return incomingEdges;
	}


	public void setIncomingEdges(List<Edge> incomingEdges) {
		this.incomingEdges = incomingEdges;
	}


	public List<Edge> getOutgoingEdges() {
		return outgoingEdges;
	}
	
	public void setOutgoingEdges(List<Edge> outgoingEdges) {
		this.outgoingEdges = outgoingEdges;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

}
