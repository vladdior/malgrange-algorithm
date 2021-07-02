package com.mycompany.graphs_lab2;

public interface ArrayOperations {

    static int[][] findAdjComMatrix(int[][] array) {
        int size = array.length;
        int[][] adjComMatrix = new int[size][size];
        // проходим всю матрицу
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // заменяем все единицы на нули
                adjComMatrix[i][j] = (array[i][j] == 0) ? 1 : 0;
            }
        }

        return adjComMatrix;
    }
}
