import java.util.HashSet;
import java.util.Stack;


public class GraphRunner {
	
	public static void toplogicalSort(Graph inputGraph){
		
		Stack<Vertex<Integer>> order = new Stack<Vertex<Integer>>();
		HashSet<Vertex<Integer>> vistedSet = new HashSet<Vertex<Integer>>();
		
		for(Object vertex : inputGraph.getAllVertex()){
			if(vistedSet.contains((Vertex<Integer>)vertex)){
				continue;
			}
			topSortUtil((Vertex<Integer>)vertex, order, vistedSet);
		}
		System.out.println("--Gary0--");
		System.out.println(order.toString());
		while(!order.isEmpty()){
			System.out.println(order.pop().id);
		}
		 
	}
	
	public static void topSortUtil(Vertex v, Stack order, HashSet<Vertex<Integer>> vistedSet){
		vistedSet.add(v);
		for(Object u : v.getAdjacentVertexes()){
			if(vistedSet.contains((Vertex<Integer>)u)){
				continue;
			}
			topSortUtil((Vertex<Integer>) u,order,vistedSet);
		}
		order.add(v);
	}
	
	public static void main(String[] args){
        Graph<Integer> graph = new Graph<>(true);
	      graph.addEdge(1, 3);
	        graph.addEdge(1, 2);
	        graph.addEdge(3, 4);
	        graph.addEdge(5, 6);
	        graph.addEdge(6, 3);
	        graph.addEdge(3, 8);
	        graph.addEdge(8, 11);
	        toplogicalSort(graph);
	}

}
