package Codeforces;

import java.util.*;
import java.io.PrintWriter;

public class ALinovaAndKingdom {
    public void solve(int testNumber, Scanner in, PrintWriter out) {
        int n= in.nextInt();
        int k = in.nextInt();
        HashMap<Integer, ArrayList<Integer>> hashMap =  new HashMap<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((Integer first, Integer second)-> second - first);

        boolean visited [] = new boolean[n+1];
        for(int i=1; i<=n;i++){
            hashMap.put(i,new ArrayList<>());
        }

        for (int i = 0; i <n-1 ; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            hashMap.get(u).add(v);
            hashMap.get(v).add(u);
        }
        int ans =0;
        dfs(hashMap,1,0,visited,priorityQueue);
        // top k element of the priority queue is the answer
//        System.out.println(priorityQueue.size());
        while(k>0){
            ans += priorityQueue.poll();
            k--;
        }
        out.println(ans);

    }

    private void dfs(HashMap<Integer, ArrayList<Integer>> hashMap, int currentNode, int currentDepth, boolean[] visited, PriorityQueue<Integer> priorityQueue) {
        if(!visited[currentNode]){
            visited[currentNode]=true;
            priorityQueue.add(currentDepth);
            ArrayList<Integer> arrayList = hashMap.get(currentNode);
            int size = arrayList.size();
            boolean ifAtleastOneNonVisited =false;
            if(size>0){

                for (int i = 0; i <size ; i++) {
                    int nextNode=arrayList.get(i);
                    if(!visited[nextNode]){
                        ifAtleastOneNonVisited=true;
                    }
                    dfs(hashMap,nextNode ,currentDepth+1,visited,priorityQueue);
                }
            }
            if(ifAtleastOneNonVisited){

            }
        }
    }


    static class SortInDecreasingOrder implements Comparator<Integer> {
        @Override
        public int compare(Integer first, Integer second) {
            return second-first;
        }
    }

}
