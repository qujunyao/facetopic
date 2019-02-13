package com.company.test2018_001.answers;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

class Edge {
    int from;
    int to;
    int weight;
    Edge(int from, int to, int weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }
}

public class Answer_012 {
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        int end = Integer.parseInt(strs[0]);
        int n = Integer.parseInt(strs[1]);
 
        Edge[] edges = new Edge[n];
        //dist[i]: 从起点到顶点i的最短距离
        Map<Integer, Integer> dist = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] route = br.readLine().split(" ");
            int s = Integer.parseInt(route[0]);
            int e = Integer.parseInt(route[1]);
            int w = Integer.parseInt(route[2]);
            edges[i] = new Edge(s, e, w);
            dist.put(s, Integer.MAX_VALUE);
            dist.put(e, Integer.MAX_VALUE);
        }
 
        dist.put(0, 0); //从起点到起点的最短距离为0
        while (true) {
            boolean update = false;
            for (Edge e : edges) {
                if (dist.get(e.from) != Integer.MAX_VALUE && dist.get(e.to) > dist.get(e.from) + e.weight) {
                    dist.put(e.to, dist.get(e.from) + e.weight);
                    update = true;
                }
            }
            if (!update) break;
        }
 
        if (dist.get(end) == Integer.MAX_VALUE) System.out.println(-1);
        else System.out.println(dist.get(end));
    }
}
