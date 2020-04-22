package Djikstra;

import java.util.*;
import java.util.stream.Collectors;

public class Dijkstra {

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                new int[]{0, 1, 12, -1, -1, -1},
                new int[]{-1, 0, 9, 3, -1, -1},
                new int[]{-1, -1, 0, -1, 5, -1},
                new int[]{-1, -1, 4, 0, 13, 15},
                new int[]{-1, -1, -1, -1, 0, 4},
                new int[]{-1, -1, -1, -1, -1, 0}
        };

        int[] dis = graph[0];

        Map<Integer, List<Integer>> paths = new HashMap<>();
        paths.put(0, Collections.singletonList(0));

        int start = 0;
        List<Integer> path = new ArrayList<>();
        path.add(start);
        for (int i = 1; i < graph.length; i++) {
            int end = 0;
            int len = -1;

            for (int j = 0; j < dis.length; j++) {
                if (!paths.containsKey(j)) {
                    if (len == -1 || (graph[start][j] != -1 && graph[start][j] < len)) {
                        len = graph[start][j];
                        end = j;
                    }
                }
            }
            path.add(end);

            dis[end] = graph[start][end];
            paths.put(end, new ArrayList<>(path));

            start = end;
        }

        System.out.println("from\tto\t\tpath");
        paths.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(entry -> {
            String str = "1\t\t" + (entry.getKey() + 1) + "\t\t";
            str += entry.getValue().stream().map(i -> i + 1 + "").collect(Collectors.joining(", "));
            System.out.println(str);
        });
    }
}
