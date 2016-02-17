public class Runner
{
	public static void main(String[] args)
	{
		Vertex<String> start = new Vertex<String>("start"); 
		Vertex<String> n1 = new Vertex<String>("n1");
		Vertex<String> n2 = new Vertex<String>("n2");
		Vertex<String> n3 = new Vertex<String>("n3");
		Vertex<String> n4 = new Vertex<String>("n4");
		start.add(n1, 6);
		start.add(n2, 7);
		start.add(n3, 8);
		start.add(n4, 12);
		
		n1.add(start, 6);
		n1.add(n2, 2);
		n1.add(n3, 3);
		n1.add(n4, 9);
		
		n2.add(start, 7);
		n2.add(n1, 2);
		n2.add(n3, 5);
		n2.add(n4, 6);
		
		n3.add(start, 8);
		n3.add(n1, 3);
		n3.add(n2, 5);
		n3.add(n4, 7);
		
		n4.add(start, 12);
		n4.add(n1, 9);
		n4.add(n2, 6);
		n4.add(n3, 7);
		
		
		System.out.println(start);
		System.out.println(start.getBest());
		System.out.println(n1.getBest());
		System.out.println(n2.getBest());
		System.out.println(n3.getBest());
		System.out.println(n4.getBest());
		System.out.println(start.getBest());
		
		
		
		
	}
}