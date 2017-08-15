package Algorithms;
import RunSearch.*;
import EnvironmentMap.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;



public class UniformCost {
	Node root;
	Node goal;
	protected boolean goalFound = false;
	ArrayList<Node> ExpandedNodes;
	
	public UniformCost() {
		
		ExpandedNodes = new ArrayList<Node>();
		
	}

    
    public Node search(int n, int[][] costArray, Node root, Node goal) {
    	boolean goalFound = false;
    	if(root.equals(goal)){
    		goalFound = true;
    	}
    	else{
    		goalFound = false;
    	}
    	
    	PriorityQueue<Node> PQ = new PriorityQueue<Node>(n , new NodeComparator());
    	PQ.add(root);
    	
    	
    	
    	while(!PQ.isEmpty()){
    		Node ExpandedNode = PQ.poll();
    		System.out.println(ExpandedNode.getName());
    		if(ExpandedNode.equals(goal)){
    			return ExpandedNode;
    		}
    		ExpandedNodes.add(ExpandedNode);
    		for(int j = 0; j < n; j++){
    			if (costArray[ExpandedNode.getName()][j] != 0){
    				Node currentNode = new  Node(j, costArray[ExpandedNode.getName()][j],ExpandedNode);
    				//Node preNode = currentNode.getPre();
    				currentNode.setCost(currentNode.getCost() + ExpandedNode.getCost());
    				if (currentNode.getCost() > 150) {
    					break;
    				}
    				boolean found = false; 
    				for(Node i: ExpandedNodes){
    					if(currentNode == i){
    						found = true;
    					}
    				}
    				for(Node i: PQ){
    					if(currentNode == i){
    						if( i.getCost() <currentNode.getCost()){
    							i.setCost(currentNode.getCost());
    						}
    						found = true;
    					}
    				}
    				
    				if(!found){
    					PQ.add(currentNode);
    				}
    				
    			}
    		}
    	}
    	return null;

    }



}
