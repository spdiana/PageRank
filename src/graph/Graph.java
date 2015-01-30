package graph;
/**
 * Graph-theory graph object G(V,E) contains a set "nodeList" of vertices and a set "edgeList" of edges.
 * @author dcc
 *
 */
import graph.Edge;
import graph.Node;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import JamaSparseMatrix.SparseMatrixCompressedRS;


public class Graph {

	/**Set of Nodes*/
	private List<Node> nodeList = new ArrayList<>();
	/**Set of Edges*/
	private List<Edge> edgeList = new ArrayList<>();

	/**
	 * Add one node in the graph.
	 * @param node vertex
	 */
	public void addNode(Node node) {
		if (!nodeList.contains(node)) {
			nodeList.add(node);
		}
	}

	/**
	 * Add one node in the graph by id.
	 * @param id id vertex
	 */
	public void addNode(int id) {
		Node n = new Node(id);
		nodeList.add(n);
	}

	/**
	 * Add one node in the graph by id and label.
	 * @param id id vertex
	 * @param label description of node
	 */
	public void addNode(int id, String label) {
		Node n = new Node(id, label);
		boolean find = false;
		for (Node nn : nodeList) {
			if (nn.getLabel().equals(label)) {
				find = true;
			}
		}
		if (!find) {
			nodeList.add(n);
		}
	}

	/**
	 * Adds the specified source and target nodes to the graph.
	 * @param from source
	 * @param to target
	 */
	public void addEdge(Node from, Node to) {
		Edge edge = new Edge(from, to);
		edgeList.add(edge);
		edge.getFrom().getOutgoingEdges().add(edge);
		edge.getTo().getIncomingEdges().add(edge);        
	}

	/**
	 * Adds the specified source, target and weight to the graph.
	 * @param from source
	 * @param to target
	 * @param weight weight
	 */
	public void addEdge(Node from, Node to, float weight) {
		Edge edge = new Edge(from, to, weight);
		edgeList.add(edge);
		edge.getFrom().getOutgoingEdges().add(edge);
		edge.getTo().getIncomingEdges().add(edge);
	}

	/**
	 * Returns a set of outgoing edges incident to node in the graph.
	 * @param node node in the graph
	 * @return a set of the outgoing edges
	 */
	public List<Edge> getOutEdgesNode(Node node) {
		List<Edge> result = new ArrayList<>();
		for (int i = 0; i < nodeList.size(); i++) {
			Node n = nodeList.get(i);
			if (node.getId() == n.getId()) {
				result = n.getOutgoingEdges();
			}
		}
		return result;
	}

	/**
	 * Returns a set of incoming edges incident to node in the graph.
	 * @param node node in the graph
	 * @return a set of the incoming edges
	 */
	public List<Edge> getInEdgesNode(Node node) {
		List<Edge> result = new ArrayList<>();
		for (int i = 0; i < nodeList.size(); i++) {
			Node n = nodeList.get(i);
			if (node.getId() == n.getId()) {
				result = n.getIncomingEdges();
			}
		}
		return result;
	}

	/**
	 * Returns a set of incoming nodes incident to node in the graph.
	 * @param node node in the graph
	 * @return set of the incoming nodes
	 */
	public List<Node> getInDegreeNodes(Node node) {
		List<Node> result = new ArrayList<>();

		for (int i = 0; i < nodeList.size(); i++) {
			Node n = nodeList.get(i);

			if (node.getId() == n.getId()) {
				List<Edge> edges = n.getIncomingEdges();

				for (int j = 0; j < edges.size(); j++) {
					Node v = getOpposite(node, edges.get(j));
					result.add(v);
				}
			}
		}
		return result;
	}


	/**
	 * Returns opposite node to specific node in one edge
	 * @param node origin
	 * @param edge link
	 * @return opposite node
	 */
	public Node getOpposite(Node node, Edge edge) {
		Node result = null;

		if (edge.getFrom().getId() == node.getId()) {
			result = edge.getTo();  
		} else if (edge.getTo().getId() == node.getId() ){
			result = edge.getFrom();  
		}
		return result;
	}

	/**
	 * Returns a number of outgoing nodes incident to node in the graph.
	 * @param node one node in the graph
	 * @return number of the incoming nodes
	 */
	public int getNumOutDegreeNode(Node node) {
		int result = 0;
		for (int i = 0; i < nodeList.size(); i++) {
			Node n = nodeList.get(i);
			if (node.getId() == n.getId()) {
				result = n.getOutgoingEdges().size();
			}
		}
		return result;
	}

	/**
	 * Returns a number of incoming nodes incident to node in the graph.
	 * @param node one node in the graph
	 * @return number of the incoming nodes
	 */
	public int getNumInDegreeNode(Node node) {
		int result = 0;
		for (int i = 0; i < nodeList.size(); i++) {
			Node n = nodeList.get(i);
			if (node.getId() == n.getId()) {
				result = n.getIncomingEdges().size();
			}
		}
		return result;
	}

	public List<Node> getNodes() {
		return nodeList;
	}

	public List<Edge> getListEdges() {
		return edgeList;
	}

	public int getNumNodes() {
		return nodeList.size();
	}

	public int getNumEdges() {
		return edgeList.size() ;
	}

	public boolean containsVertex(Node node) {
		return nodeList.contains(node);
	}

	public boolean containsEdge(Edge edge) {
		return edgeList.contains(edge);
	}


	/**
	 * Returns a set of neighbors nodes to one node in the graph.
	 * @param node node in the graph
	 * @return set of neighbors nodes
	 */
	public List<Node> getNeighbors(Node node) {
		List<Node> neighbors = new ArrayList<Node>();
		for(int i = 0; i < edgeList.size(); i++) {
			Edge edge = edgeList.get(i);

			if(edge.getFrom() == node) {
				neighbors.add(edge.getTo());
			}
		}
		return neighbors;
	}


	/**
	 * Adj[i][j] = 1 Indicates that there is an edge from vertex i to vertex j
	 * @return  a matrix.
	 */
	public SparseMatrixCompressedRS getAdjacencyMatrix() {
		SparseMatrixCompressedRS adjMatrix = new SparseMatrixCompressedRS(getNumNodes(), getNumNodes());

		for(int i = 0; i < nodeList.size(); i++) {
			Node node = nodeList.get(i);

			for(int j = 0; j < edgeList.size(); j++) {
				Edge edge = edgeList.get(j);

				if(edge.getFrom() == node) {
					int indexOfNeighbor = nodeList.indexOf(edge.getTo());
					adjMatrix.set(i, indexOfNeighbor,  1);
				}
			}
		}
		return adjMatrix;
	}


	/**
	 * Transpose matrix is a new matrix whose rows are the columns of the original.
	 * @param mat original matrix
	 * @return new matrix whose rows are the columns of the original
	 */
	public SparseMatrixCompressedRS getTransposeMatrix(SparseMatrixCompressedRS mat)  {  
		SparseMatrixCompressedRS trans = new SparseMatrixCompressedRS(getNumNodes(), getNumNodes());

		for (int i = 0; i < mat.getRowDimension(); i++) {
			for (int j = 0; j < mat.getColumnDimension(); i++) {
				if (mat.exists(i, j)) {
					trans.set(j, i, mat.get(i, j));
					mat.delete(i, j);
				}
			}
		}
		return trans;  
	} 

	/**BFS traversal of a tree is performed by the bfs() function
	 * http://sourceblogger.googlecode.com/svn/trunk/Algorithm/src/com/bfsdfs/Graph.java
	 * @param rootNode source node 
	 * @return set of nodes not visited
	 */
	public List<Node> breadthFirstSearch(Node rootNode) 	{
		List<Node> list = new ArrayList<Node>();
		int visited = 0;
		int notVisited = 0;

		SparseMatrixCompressedRS adjMatrix =  getAdjacencyMatrix();
		//BFS uses Queue data structure
		Queue<Node> q = new LinkedList<Node>();
		q.add(rootNode);

		rootNode.visited = true;
		while(!q.isEmpty()) {
			Node n = q.remove();
			Node child = null;
			while((child = getUnvisitedChildNode(n, adjMatrix)) != null) 	{
				child.visited = true;
				q.add(child);
			}
		}
		System.out.println();
		for (int i = 0; i < getNumNodes(); i++) {
			Node n = nodeList.get(i);
			if(!n.visited) {
				list.add(n);
				notVisited++;
			} else {
				visited++;
			}
		}
		System.out.println("Visited: "+ visited + " "+ "Not Visited: "+ notVisited);
		clearNodes();
		return list;
	}

	private Node getUnvisitedChildNode(Node n, SparseMatrixCompressedRS adjMatrix) {
		int index = nodeList.indexOf(n);
		int j = 0;
		while(j < getNumNodes()) {
			if (adjMatrix.exists(index, j)) {
				if(adjMatrix.get(index, j) == 1 && (nodeList.get(j)).visited==false) {
					return nodeList.get(j);
				}
			}
			j++;
		}
		return null;
	}

	private void clearNodes() {
		int i=0;
		while(i < getNumNodes()) {
			Node n = nodeList.get(i);
			n.visited=false;
			i++;
		}
	}
}
