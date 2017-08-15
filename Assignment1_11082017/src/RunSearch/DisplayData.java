package RunSearch;
import java.io.IOException;

import Algorithms.UniformCost;

public class DisplayData {

	public static void main(String[] args) {
		String file_name = "H:/AI/example1/exEnv1.txt";
		int StartNode = 1;
		int GoalNode = 6;
		
		try{
			EnvironmentMap.EnvMap envMap = new EnvironmentMap.EnvMap();
			envMap.LoadEnvMap(file_name);
			System.out.println(envMap.n + "x" + envMap.n + " Environment Map:");
			for (int i = 0; i < envMap.n; i++) {
				for (int j = 0; j < envMap.n; j++) {
					System.out.print(envMap.costArray[i][j] + " ");
				}
				System.out.println("");
			}

			Node root = new Node(0,0);
			Node goal = new Node(7,Integer.MAX_VALUE);
			UniformCost uc = new UniformCost();
			Node result = uc.search(envMap.n, envMap.costArray, root, goal);
			printResult(result);
		}
		catch (IOException e){
			System.out.println(e.getMessage());;
		}
		
			

	}

	
	private static void printResult(Node node) {
		System.out.println("RESULTS - found node:" + node.getName());
		System.out.println("Cost: " + node.getCost());
		while (node.getPre()!= null) {
			node = node.getPre();
			System.out.println("Prev Node: " + node.getName());
		}
	}
}
