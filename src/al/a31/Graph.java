package al.a31;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private int v;
    private LinkedList<Integer> adj[];

    public Graph(int v){
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
   }

   public void addEdge(int s,int t){
        adj[s].add(t);
        adj[t].add(s);
   }

   public void bfs(int s,int t){
        if (s == t) return;
        boolean[] visited = new boolean[v];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        int[] pre = new int[v];
       for (int i = 0; i < pre.length; i++) {
           pre[i] = -1;
       }
        while(!queue.isEmpty()){
            int temp = queue.poll();
            LinkedList<Integer> list = adj[temp];
            for (int i : list){
                if (visited[i]){
                    continue;
                }
                pre[i] = temp;
                if (i == t){
                    print(pre,i,s);
                    return;
                }
                queue.offer(i);
                visited[temp] = true;
            }
        }
   }

   boolean find = false;
   public void dfs(int s,int t){
        if (s == t) return;
        boolean[] visited = new boolean[v];
        int[] pre = new int[v];
        for (int i = 0; i < pre.length; i++) {
            pre[i] = -1;
        }
        recurDfs(s,t,visited,pre);
        print(pre,t,s);
   }

   private void recurDfs(int s,int t,boolean[] visited,int[] prev){
        if (find) return;
       visited[s] = true;
       if (s == t) {
           find = true;
           return;
       }
       for (int i = 0; i < adj[s].size(); i++) {
           int temp = adj[s].get(i);
           if (visited[temp])
               continue;
           prev[temp] = s;
           recurDfs(temp,t,visited,prev);
       }
   }

   public void print(int[] pre, int i,int s){
        if (pre[i] != -1 && i != s){
            print(pre,pre[i],s);
        }
       System.out.print(i + " ");
   }

    public static void main(String[] args) {
        Graph graph = new Graph(10);

        graph.addEdge(0,1);
        graph.addEdge(0,3);
        graph.addEdge(1,2);
        graph.addEdge(1,4);
        graph.addEdge(2,5);
        graph.addEdge(3,4);
        graph.addEdge(4,5);
        graph.addEdge(4,6);
        graph.addEdge(5,7);
        graph.addEdge(6,7);

//        graph.bfs(0,6);
        graph.dfs(0,7);
    }
}
