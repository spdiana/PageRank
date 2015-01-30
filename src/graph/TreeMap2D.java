package graph;

import java.util.Map;
import java.util.TreeMap;
/**
 * 
 * @author dcc
 *
 */
public class TreeMap2D {

	private int row;
	private int column;
	private Map<Integer, Float> matrix;

	public TreeMap2D(int row, int collumn) {
		this.row = row;
		this.column = collumn;
		this.matrix = new TreeMap<>();
	}

	public void put(int i, int j, float value) {
		matrix.put((i) * column + j, value);
	}

	public float get(int i, int j) {
		return matrix.get((i) * column + j);
	}

	public void remove(int i, int j) {
		matrix.remove((i) * column + j);
	}

	public boolean containsKey(int i, int j) {
		return matrix.containsKey(i * column + j);
	}
	
	public int size() {
		return matrix.size();
	}
	
	public void clear() {
		matrix.clear();
	}
	
	public void createMatrix() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				int value = (int) Math.round(Math.random()*21);
				put(i, j, value);
			}
		}
	}

	public void printMatrix() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (this.containsKey(i, j)) {
					System.out.print(this.get(i, j) + " ");
				} else {
					System.out.print(0 + " ");
				}
			}
			System.out.println();
		}
	}

	public static void main(String args[]) {
		TreeMap2D M = new TreeMap2D(5,5);
		M.createMatrix();
		M.printMatrix();
	}
}
