package neu.info6205.edu;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int connectedSquareSum(int graph_nodes, List<Integer> graph_from, List<Integer> graph_to){
        int res = 0;
        List<List<Integer>> ls = new ArrayList<>();
        UF uf = new UF(graph_nodes);
        for (int i = 0; i < graph_from.size(); i++) {
            uf.unionElements(graph_from.get(i),graph_to.get(i));
        }
        boolean[] index = new boolean[graph_nodes];

        for (int i = 0; i < graph_nodes; i++) {
            if(!index[i]){
                List<Integer> cur = new ArrayList<>();
                for (int j = 0; j < graph_nodes; j++) {
                    if(uf.isConnected(i,j)||i==j){
                      cur.add(j);
                      index[j] = true;
                    }
                }
                ls.add(new ArrayList<>(cur));
            }
        }

        for(List<Integer> single : ls){
            res+=single.size()*single.size();
        }
        int count = 0;
        for (int i = 0; i < index.length; i++) {
            if(index[i]==false){
                count++;
            }
        }
        res+=count;
        return res;
    }

}



