package com.company;

/*
Хныкин 3.2.

Алгоритм Краскала — алгоритм построения минимального остовного дерева
взвешенного связного неориентированного графа

Картинки графа в пакете res
*/

public class Main {

    public static void main(String[] args) {

        int vertices = 8; // Кол-во вершин
        int edges = 10; // Кол-во свзяей (путей)

        KruskalAlgorithm.Graph G = new KruskalAlgorithm.Graph(vertices, edges);

        G.edge[0].start = 0;
        G.edge[0].end = 1;
        G.edge[0].weight = 3;

        G.edge[1].start = 0;
        G.edge[1].end = 4;
        G.edge[1].weight = 3;

        G.edge[2].start = 0;
        G.edge[2].end = 7;
        G.edge[2].weight = 7;

        G.edge[3].start = 1;
        G.edge[3].end = 2;
        G.edge[3].weight = 1;

        G.edge[4].start = 1;
        G.edge[4].end = 6;
        G.edge[4].weight = 5;

        G.edge[5].start = 2;
        G.edge[5].end = 4;
        G.edge[5].weight = 4;

        G.edge[6].start = 4;
        G.edge[6].end = 3;
        G.edge[6].weight = 3;

        G.edge[7].start = 4;
        G.edge[7].end = 5;
        G.edge[7].weight = 2;

        G.edge[8].start = 6;
        G.edge[8].end = 5;
        G.edge[8].weight = 1;

        G.edge[9].start = 7;
        G.edge[9].end = 3;
        G.edge[9].weight = 11;

        G.KruskalAlgo();
    }
}
