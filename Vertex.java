/**	@author Brendan Raimann
*	2/17/16
*	@version 1.0
* 	Stupid Vertex class for a Graph
*/
public class Vertex<E>
{
	/** A List of other vertices */
	private LinkedList<Vertex<E>> vertices;
	
	/** A List of edges with indexes that match the vertices List*/
	private LinkedList<Integer> edges;
	
	/** Stored value in the vertex */
	private E value;
	
	/** Contains true of the vertex has been visited */
	private boolean visited;
	
	/**
	*	Constructor with the stored value as a parameter
	*	@param obj The object to be stored in the vertex
	*/
	public Vertex(E obj)
	{
		vertices = new LinkedList<Vertex<E>>();
		edges = new LinkedList<Integer>();
		value = obj;
		visited = false;
	}
	
	/**
	*	Returns the stored value in the Vertex class
	*	@return Returns the stored value in the vertex
	*/
	public E getValue()
	{
		return value;
	}
	
	/**
	*	Updates the Vertex class so that ifVisited() method will return 'true'
	*/
	public void visit()
	{
		visited = true;
	}
	
	/**
	*	Returns whether the class has been visited
	*	@return Returns true if the class has been visited
	*/
	public boolean ifVisited()
	{
		return visited;
	}
	
	/**
	*	Adds another vertex and edge to the current Vertex class
	*	@param other Another Vertex class to be added to the vertices list
	*	@param cost The value of the edge that will be added to the edges list
	*/
	public void add(Vertex<E> other, int cost)
	{
		vertices.add(other);
		edges.add(cost);
	}
	
	/**
	*	Returns a String representation of the Vertex class
	*	@return Returns a String representation of the class
	*/
	public String toString()
	{
		return value + "\n" + visited + "\n";
	}
	
	/**
	*	Returns the Vertex that has the lowest corresponding cost and marks it as visited
	*	@return Returns the Vertex that has the lowest associated cost
	*/
	public Vertex<E> getBest()
	{
		if (edges.size() == 0)   //if there are no other vertices
			return null;
		if (edges.size() == 1)   //if there is only one vertex
			if (vertices.get(0).ifVisited() == false)
			{
				vertices.get(0).visit();
				return vertices.get(0);
			}
			else
				return null;
									//if there are more than one vertex
		int bestIndex = -1;				//finds the first non-visited vertex
		for (int x = 0; x < edges.size(); x++)
		{
			if (vertices.get(x).ifVisited() == false)
			{
				bestIndex = x;
				break;
			}
			
		}
		if (bestIndex == -1)
			return null;
		int temp = edges.get(bestIndex);
		for (int i = 1; i < edges.size(); i++)   //finds the BEST non-visited vertex
		{
			if (edges.get(i) < temp && vertices.get(i).ifVisited() == false)
			{
				temp = edges.get(i);
				bestIndex = i;
			}
		}
		vertices.get(bestIndex).visit();
		return vertices.get(bestIndex);
	}
	
}