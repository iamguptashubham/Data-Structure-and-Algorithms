import java.util.*;

public class PageRank {

    public static void calculate(int[][] path, int noOfNodes) {

        double[] pageRank = new double[10];
        double[] tempPageRank = new double[10];

        double initialValue = 1.0 / noOfNodes;

        System.out.println("Print initial value of each page rank");
        for (int i = 0; i < noOfNodes; i++) {
            pageRank[i] = initialValue;
            System.out.println("Pagerank of Page " + i + "is :" + pageRank[i]);
        }

        int iterationCount = 0;
        while (iterationCount < 2) {
            int internalNode = 0;
            int externalNode = 0;

            for (int i = 0; i < noOfNodes; i++) {
                tempPageRank[i] = pageRank[i];
                pageRank[i] = 0;
            }

            for (internalNode = 0; internalNode < noOfNodes; internalNode++) {
                for (externalNode = 0; externalNode < noOfNodes; externalNode++) {
                    if (path[externalNode][internalNode] == 1) {
                        int outgoingLinks = 0;
                        for (int i = 0; i < noOfNodes; i++) {
                            if (path[externalNode][i] == 1) {
                                outgoingLinks++;
                            }
                        }

                        pageRank[internalNode] += tempPageRank[externalNode] * (1.0 / outgoingLinks);
                    }
                }
            }
            iterationCount++;
            System.out.println("After" + iterationCount + " iteration pagerank is:");
            for (int i = 0; i < noOfNodes; i++) {
                System.out.println("Pagerank of" + i + "is " + pageRank[i]);
            }
        }

        double dumpingFactor = 0.85;
        for (int i = 0; i < noOfNodes; i++) {
            pageRank[i] = (1 - dumpingFactor) + (dumpingFactor) * pageRank[i];
        }

        System.out.println("Final pagerank is");
        for (int i = 0; i < noOfNodes; i++) {
            System.out.println("Pagerank of" + i + "is " + pageRank[i]);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int noOfNodes;
        System.out.println("Enter total no of Pages");
        noOfNodes = sc.nextInt();
        System.out.println("Enter Adjacency matrix of nodes");
        int[][] path = new int[10][10];
        for (int i = 0; i < noOfNodes; i++) {
            for (int j = 0; j < noOfNodes; j++) {
                path[i][j] = sc.nextInt();
            }
        }

        calculate(path, noOfNodes);
    }
}