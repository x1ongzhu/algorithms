package Floyd;

public class Floyd {
    public void Floyd(int[][] graph) {
        int[][] D = new int[graph.length][graph.length];
        int[][] P = new int[graph.length][graph.length];
        for (int i = 0; i < P.length; i++) {
            for (int j = 0; j < P.length; j++) {
                D[i][j] = graph[i][j];
                P[i][j] = j;
            }
        }

        for (int k = 0; k < graph.length; k++) {
            for (int v = 0; v < graph.length; v++) {
                for (int w = 0; w < graph.length; w++) {
                    if (D[v][w] > D[v][k] + D[k][w]) {
                        /* 将当前两点间权值设为更小的一个 */
                        D[v][w] = D[v][k] + D[k][w];
                        P[v][w] = P[v][k];/* 路径设置为经过下标为k的顶点 */
                    }
                }
            }
        }

        System.out.print("\t");
        for (int i = 0; i < P.length; i++) {
            System.out.print("v" + (i) + "\t");
        }
        System.out.println();
        for (int i = 0; i < P.length; i++) {
            System.out.print("v" + (i) + "\t");
            for (int j = 0; j < P.length; j++)
                System.out.print(P[i][j] + "\t");
            System.out.println();
        }


        for (int v = 0; v < graph.length; v++) {
            for (int w = v + 1; w < graph.length; w++) {
                System.out.print("v" + v + "--" + "v" + w + "  weight:  " + D[v][w]
                        + "  Path:  " + v + "   ");
                int k = P[v][w];
                while (k != w) {
                    System.out.print("->  " + k + "  ");
                    k = P[k][w];
                }
                System.out.println("->  " + w);
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                new int[]{0, 2, 1},
                new int[]{2, 0, 5},
                new int[]{1, 5, 0}
        };
        new Floyd().Floyd(graph);
    }
}
