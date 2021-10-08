package may2021;

import java.util.HashSet;
import java.util.Set;

public class ConnectedComponents {
    public int countComponents(int n, int[][] edges) {
        int []ids=new int[n];
        for(int i=0;i<ids.length;i++) ids[i]=i;
        for(int i=0;i<edges.length;i++){
            union(edges[i][0],edges[i][1],ids);
        }
        Set<Integer> numset=new HashSet();
        for(int i=0;i<ids.length;i++){
            numset.add(find(i,ids));
        }
        return numset.size();

    }
    public void union(int edge1,int edge2,int[]ids){
        int parent1=find(edge1,ids);
        int parent2=find(edge2,ids);
        ids[parent1]=parent2;
    }

    public int find(int edge,int[]ids){
        if(ids[edge]!=edge) ids[edge]=find(ids[edge],ids);
        return ids[edge];
    }

    public static void main(String[] args) {
        ConnectedComponents connectedComponents=new ConnectedComponents();
        int edges[][]=new int[][]{{0,1},{1,2},{3,4}};
        System.out.println(connectedComponents.countComponents(5,edges));
    }
}
