# <center>Lab Program 4</center>
# <center>BellmanFord</center>
<hr>
<div style="font-size:20px"><p>Write a program to find shortest path 't' vertices using bellmanford algorithm.</p>
</div>

### <b>BellmanFord.java </b>
```java
import java.util.Scanner;

public class BellmanFord 
{
    private int D[];
    private int num_ver;
    public static final int MAX_VALUE = 999;

    public BellmanFord(int num_ver) 
    {
        this.num_ver = num_ver;
        D = new int[num_ver + 1];
    }

    public void BellmanFordEvaluation(int source, int A[][]) 
    {
        for (int node = 1; node <= num_ver; node++) 
        {
            D[node] = MAX_VALUE;
        }
        D[source] = 0;

        for (int node = 1; node <= num_ver - 1; node++) 
        {
            for (int sn = 1; sn <= num_ver; sn++) 
            {
                for (int dn = 1; dn <= num_ver; dn++) 
                {
                    if (A[sn][dn] != MAX_VALUE) 
                    {
                        if (D[dn] > D[sn] + A[sn][dn])
                            D[dn] = D[sn] + A[sn][dn];
                    }
                }
            }
        }
        for (int sn = 1; sn <= num_ver; sn++) 
        {
            for (int dn = 1; dn <= num_ver; dn++) 
            {
                if (A[sn][dn] != MAX_VALUE) 
                {
                    if (D[dn] > D[sn] + A[sn][dn])
                        System.out.println("The Graph Contains negative edge Cycles.");
                }
            }
        }
        for (int vertex = 1; vertex <= num_ver; vertex++) 
        {
            System.out.println("Distance of source " + source + " to " + vertex + " is " + D[vertex]);
        }
    }

    public static void main(String[] args) throws Exception 
    {
        int num_ver = 0;
        int source;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices: ");
        num_ver = sc.nextInt();
        int A[][] = new int[num_ver + 1][num_ver + 1];
        System.out.println("Enter the adjacency matrix: ");
        for (int sn = 1; sn <= num_ver; sn++) {
            for (int dn = 1; dn <= num_ver; dn++) {
                A[sn][dn] = sc.nextInt();
                if (sn == dn) {
                    A[sn][dn] = 0;
                    continue;
                }
                if (A[sn][dn] == 0)
                    A[sn][dn] = MAX_VALUE;
            }
        }
        System.out.println("Enter the Source vertex: ");
        source = sc.nextInt();
        BellmanFord b = new BellmanFord(num_ver);
        b.BellmanFordEvaluation(source, A);
        sc.close();
    }
}

```

> OUTPUT : 
```shell
Enter the number of vertices: 
4
Enter the adjacency matrix: 
0 4 999 5
999 0 999 5  
999 -10 0 999
999 999 3 0
Enter the Source vertex: 
1
The Graph Contains negative edge Cycles.
Distance of source 1 to 1 is 0
Distance of source 1 to 2 is -2
Distance of source 1 to 3 is 6
Distance of source 1 to 4 is 3



Enter the number of vertices: 
7
Enter the adjacency matrix: 
0 6 5 5 999 999 999
999 0 999 999 -1 999 999
999 -2 0 999 1 999 999
999 999 -2 0 999 -1 999
999 999 999 999 0 999 3
999 999 999 999 999 0 3
999 999 999 999 999 999 0
Enter the Source vertex: 
1
Distance of source 1 to 1 is 0
Distance of source 1 to 2 is 1
Distance of source 1 to 3 is 3
Distance of source 1 to 4 is 5
Distance of source 1 to 5 is 0
Distance of source 1 to 6 is 4
Distance of source 1 to 7 is 3
```

>Note: You can read bit of theory from BFA.pdf File
