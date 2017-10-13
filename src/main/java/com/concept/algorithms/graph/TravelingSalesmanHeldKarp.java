package com.concept.algorithms.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringJoiner;

/**
 * Help Karp method of finding tour of traveling salesman.
 *
 * Time complexity - O(2^n * n^2)
 * Space complexity - O(2^n)
 *
 * https://en.wikipedia.org/wiki/Held%E2%80%93Karp_algorithm
 * 
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/graph/TravelingSalesmanHeldKarp.java
 * 
 * https://www.youtube.com/watch?v=-JjA4BLQyqE
 * 
 * White Board https://drive.google.com/open?id=0B2GSydBQGID6cUNObkxkZ0dsXzQ
 */
public class TravelingSalesmanHeldKarp {
	
	private static int INFINITY = 100000000;
	
//      0   1   2   3
//    |---------------
//  0 | 0   1   15  6
//	1 | 2   0   7   3
//	2 | 9   6   0   12
//	3 | 10  4   8   0
//	
//	startVertex = 0
//	sets are {1}, {2}, {3}, {1,2}, {2,3}, {1,3}, {1,2,3}
//	
//	Index       -> cost  parent
//	[1,null]    -> 1      0
//	[2,null]    -> 15     0
//	[3,null]    -> 6      0
//	[2,{1}]     -> 8      1  //Parent 1.  Go to 2 via 1 = 7 +  go to 0 from 1 = 1.  So 7+1=8
//	[3,{1}]     -> 4      1  //Parent 1.  Go to 3 via 1 = 3 +  go to 0 from 1 = 1.  So 3+1=4
//	[1,{2}]     -> 21     2  //Parent 2.  Go to 1 via 2 = 6 +  go to 0 from 2 = 15. So 6+15=21
//	[3,{2}]     -> 27     2  //Parent 2.  Go to 3 via 2 = 12 + go to 0 from 2 = 15. So 12+15=27
//	[1,{3}]     -> 10     3  //Parent 3.  Go to 1 via 3 = 4 +  go to 0 from 3 = 6.  So 6+4=10
//	[2,{3}]     -> 14     3  //Parent 3.  Go to 2 via 3 = 8 +  go to 0 from 3 = 6.  So 8+4=14
//	[3,{1,2}]   -> 20     2  //Parent 2.  Min[Go to 3 via 1 + value from 1 to 0 via 2, Go to 3 via 2 + value from 2 to 0 via 1] = Min [3+21, 12+8] = 20 (parent 2)	
//	[1,{2,3}]   -> 20     2  //Parent 2.  Min[Go to 1 via 2 + value from 2 to 0 via 3, Go to 1 via 3 + value from 3 to 0 via 2] = Min [6+14, 4+27] = 20 (parent 2)	
//	[2,{1,3}]   -> 12     3  //Parent 2.  Min[Go to 2 via 1 + value from 1 to 0 via 3, Go to 2 via 3 + value from 3 to 0 via 1] = Min [7+10, 8+4] = 12 (parent 3)	
	
	
//	[0,{1,2,3}] -> 21     2  //Parent 2.  Min[Go to 0 via 1 + value from 1 to 0 via 2,3, Go to 0 via 2 + value from 2 to 0 via 1,3, Go to 0 via 3 + value from 3 to 0 via 1,2] 
													// = Min [2+20, 9+12, 10+20] = 21 (parent 2)
// 0<-2<-3<-1<-0 backtrack
//0->1->3->2->0  minimum path -> 1+3+8+9=21
	
//Steps
//	1. Read in matrix distance
//	2. Compute all possible combination sets e.g. {1}, {2}, {3}, {1,2}, {2,3}, {1,3}, {1,2,3}
//	3. Find the minimum cost of going from 0 to each element/combination from #2. e.g move from 0 to 2 is 15. Use this information 
//			to compute [1, {2}] which is distance to reach 2 from 1 + distance to reach 0 from 2 = 6+15=21
//	4. Once we do all combinations, backtrack from 0 through all steps back to 0 to compute distance
//	5. Print path
	
	public int minCost(int[][] distance) {
		
		// Index contains current node, and set of nodes it traversed starting from 0. e.g. [3, {1,2}] means we are at node 3 after starting from 0 going through 1 & 2 
		// value says what is the minimum distance to cover that distance
		// parent says which was the immediate parent before 3, which is 2 in this case. So 0->1->2->3 is the minimum path for reaching 3
		
		//stores intermediate values in map
		//e.g. Key(Index) [3, {1,2}] Value: 20 - minCostDP, cost of going from 0 to 3 via 1,2
		//	   Key(Index) [3, {1,2}] Parent: 2 - Parent, parent of going to 3 is 2, then 1 and 0
        Map<Index, Integer> minCostDP = new HashMap<>();
        Map<Index, Integer> parent = new HashMap<>();
        
        
        //{}, {1}, {2}, {3}, {1,2}, {2,3}, {1,3}, 
        List<Set<Integer>> allSets = generateCombination(distance.length - 1);
        
        for(Set<Integer> set : allSets) {
        	
        	//Find min distance from every vertex to each of this set exclusive of vertex in set
        	for(int currentVertex = 1; currentVertex < distance.length; currentVertex++) {
        		
        		//skip if the set contains vertex
        		if(set.contains(currentVertex)) {
                    continue;
                }
        		
        		Index index = Index.createIndex(currentVertex, set);
        		
        		//We need to find this for the set under consideration
        		int minCost = INFINITY;
                int minPrevVertex = 0;
                
                //to avoid ConcurrentModificationException copy set into another set while iterating
                Set<Integer> copySet = new HashSet<>(set);
                for(int prevVertex : set) {  //If set is {1,2}, try 1 as previous and then 2 as previous. pick the one which gives minimum 
                	//distance[1][3] +  cost of reaching 3 from 0 OR distance[3][1] + cost of reaching 1 from 0
                	int cost = distance[prevVertex][currentVertex] + getCost(copySet, prevVertex, minCostDP); 
                	//choose the parent and minimum cost
                    if(cost < minCost) {
                        minCost = cost;
                        minPrevVertex = prevVertex;
                    }
                }
                
                //this happens for empty subset
                if(set.size() == 0) {
                    minCost = distance[0][currentVertex];
                }
                
                minCostDP.put(index, minCost);
                parent.put(index, minPrevVertex);
        	}
        }
        
        Set<Integer> set = new HashSet<>();
        for(int i=1; i < distance.length; i++) {
            set.add(i);
        }
        
        int min = Integer.MAX_VALUE;
        int prevVertex = -1;
        
        //to avoid ConcurrentModificationException copy set into another set while iterating
        Set<Integer> copySet = new HashSet<>(set);
        for(int k : set) {
            int cost = distance[k][0] + getCost(copySet, k, minCostDP);
            if(cost < min) {
                min = cost;
                prevVertex = k;
            }
        }
        
        parent.put(Index.createIndex(0, set), prevVertex);
        printTour(parent, distance.length);
        return min;

	}
	
	private void printTour(Map<Index, Integer> parent, int totalVertices) {
		Set<Integer> set = new HashSet<>();
        for(int i=0; i < totalVertices; i++) {
            set.add(i);
        }
        Integer start = 0;
        Deque<Integer> stack = new LinkedList<>();
        while(true) {
            stack.push(start);
            set.remove(start);
            start = parent.get(Index.createIndex(start, set));
            if(start == null) {
                break;
            }
        }
        StringJoiner joiner = new StringJoiner("->");
        stack.forEach(v -> joiner.add(String.valueOf(v)));
        System.out.println("\nTSP tour");
        System.out.println(joiner.toString());
	}
	
	private int getCost(Set<Integer> copySet, int prevVertex, Map<Index, Integer> minCostDP) {
		copySet.remove(prevVertex);
        Index index = Index.createIndex(prevVertex, copySet);
        int cost = minCostDP.get(index);
        copySet.add(prevVertex);
        return cost;
	}

	private List<Set<Integer>> generateCombination(int n) {
		int input[] = new int[n];
        for(int i = 0; i < input.length; i++) {
            input[i] = i+1;
        }
        List<Set<Integer>> allSets = new ArrayList<>();
        int result[] = new int[input.length];
        generateCombination(input, 0, 0, allSets, result);
        Collections.sort(allSets, new SetSizeComparator());
        return allSets;

	}

	private void generateCombination(int[] input, int start, int pos, List<Set<Integer>> allSets, int[] result) {
		if(pos == input.length) {
            return;
        }
        Set<Integer> set = createSet(result, pos);
        allSets.add(set);
        for(int i=start; i < input.length; i++) {
            result[pos] = input[i];
            generateCombination(input, i+1, pos+1, allSets, result);
        }		
	}

	private Set<Integer> createSet(int[] input, int pos) {
		if(pos == 0) {
            return new HashSet<>();
        }
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < pos; i++) {
            set.add(input[i]);
        }
        return set;
	}

	private static class SetSizeComparator implements Comparator<Set<Integer>>{
        public int compare(Set<Integer> o1, Set<Integer> o2) {
            return o1.size() - o2.size();
        }
    }
	
	private static class Index {
        int currentVertex;
        Set<Integer> vertexSet;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Index index = (Index) o;

            if (currentVertex != index.currentVertex) return false;
            return !(vertexSet != null ? !vertexSet.equals(index.vertexSet) : index.vertexSet != null);
        }

        @Override
        public int hashCode() {
            int result = currentVertex;
            result = 31 * result + (vertexSet != null ? vertexSet.hashCode() : 0);
            return result;
        }

        private static Index createIndex(int vertex, Set<Integer> vertexSet) {
            Index i = new Index();
            i.currentVertex = vertex;
            i.vertexSet = vertexSet;
            return i;
        }
    }

}
