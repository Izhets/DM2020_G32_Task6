package com.company;

import java.util.Arrays;

public class KruskalAlgorithm {
    int countAll;
    static class Graph {

        private int countAll;

        class Edge implements Comparable<Edge> {

            int start;
            int end;
            int weight;

            public int compareTo(Edge compareEdge) {
                return this.weight - compareEdge.weight;
            }
        }

        // Объединение
        class subset {
            int parent, rank;
        }

        int vertices, edges;
        Edge edge[];

        // Создание графа
        Graph(int v, int e) {
            vertices = v;
            edges = e;
            edge = new Edge[edges];
            for (int i = 0; i < e; ++i)
                edge[i] = new Edge();
        }

        int find(subset subsets[], int i) {
            if (subsets[i].parent != i)
                subsets[i].parent = find(subsets, subsets[i].parent);
            return subsets[i].parent;
        }

        void Union(subset subsets[], int x, int y) {
            int xroot = find(subsets, x);
            int yroot = find(subsets, y);

            if (subsets[xroot].rank < subsets[yroot].rank)
                subsets[xroot].parent = yroot;
            else if (subsets[xroot].rank > subsets[yroot].rank)
                subsets[yroot].parent = xroot;
            else {
                subsets[yroot].parent = xroot;
                subsets[xroot].rank++;
            }
        }

        // Алгоритм Крускала
        void KruskalAlgo() {
            Edge result[] = new Edge[vertices];
            int e = 0;
            int i = 0;
            for (i = 0; i < vertices; ++i)
                result[i] = new Edge();

            // Сортировка ребер
            Arrays.sort(edge);
            subset subsets[] = new subset[vertices];
            for (i = 0; i < vertices; ++i)
                subsets[i] = new subset();

            for (int v = 0; v < vertices; ++v) {
                subsets[v].parent = v;
                subsets[v].rank = 0;
            }
            i = 0;
            while (e < vertices - 1) {
                Edge nextEdge;
                nextEdge = edge[i++];
                int x = find(subsets, nextEdge.start);
                int y = find(subsets, nextEdge.end);
                if (x != y) {
                    result[e++] = nextEdge;
                    Union(subsets, x, y);
                }
            }
            for (i = 0; i < e; ++i) {
                System.out.println(result[i].start + " - " + result[i].end + ": " + result[i].weight);
                countAll += result[i].weight;
            }
            System.out.println();
            System.out.println("Длина минимального остовного дерева равна: " + countAll);
        }
    }
}