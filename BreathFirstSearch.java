package bfs;
import java.util.Scanner;

class BFS {
   
    int[][] graph = {
        {0, 0, 1, 0, 0, 1},
        {0, 0, 0, 1, 1, 0},
        {1, 0, 0, 1, 1, 0},
        {0, 1, 1, 0, 0, 1},
        {0, 1, 1, 0, 0, 1},
        {1, 0, 0, 1, 1, 0}
    };
    int[] q = new int[6];
    int[] visited = new int[6];
    int f = 0, r = 0, s, find;
    int[] val = {7, 6, 13, 10, 14, 15};
    char[] node = {'A','B','C','D','E','F'};
    
    int turmined() { 
        return 0;
    }
    void enqueue(int a) { 
        q[r++] = a;
        if (find == val[a]) {
            System.out.println("Found "+find + " in node " + node[a]);
            turmined();
        }
    }
    int dequeue() { 
        return q[f++];
    }

    void BFS(int s) { 
        int u, v;
        for (u = 0; u < 6; u++) {
            visited[u] = 0; 
        }
        visited[s] = 1; 
        enqueue(s); 
        while (f != r) { 
            u = dequeue();
            for (v = 0; v < 6; v++) { 
                if (graph[u][v] == 1) { 
                    if (visited[v] == 0) { 
                        visited[v] = 1;
                        enqueue(v); 
                    }
                }
            }
        }
    }
}

public class BreathFirstSearch {
    
    public static void main(String[] args) { 
        Scanner input = new Scanner(System.in);
        BFS ob = new BFS();
        
        System.out.println("Sample Input:");
        char ch = input.next().charAt(0); 
        ob.find = input.nextInt(); 
        
        System.out.println("\nSample Output:");
        for (int row = 0; row < 6; row++) {
            System.out.print(ob.node[row]+"("+ob.val[row]+"),adj = ");
            if(ob.node[row] == ch){
               ob.s = row;
            }
            for (int col = 0; col < 6; col++) {
                if(ob.graph[row][col] == 1){
                    if(row != col){
                        System.out.print(ob.node[col]+" ");
                    }   
                }
            }
            System.out.println();
        }
        ob.BFS(ob.s); 
    }
}
