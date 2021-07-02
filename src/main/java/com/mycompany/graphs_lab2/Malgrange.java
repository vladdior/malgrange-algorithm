package com.mycompany.graphs_lab2;

public class Malgrange {
    public static void main(String[] args) {
//        int[][] adjMatrix = {{0, 1, 1, 1},
//                             {1, 0, 0, 1},
//                             {1, 0, 0, 0},
//                             {1, 1, 0, 0}};

//        int[][] adjMatrix = {{0, 0, 0, 0},
//                             {0, 0, 0, 0},
//                             {0, 0, 0, 0},
//                             {0, 0, 0, 0}};

//        int[][] adjMatrix = {{0, 1, 1, 0, 1, 0},
//                             {1, 0, 0, 1, 1, 0},
//                             {1, 0, 0, 1, 1, 1}, 
//                             {0, 1, 1, 0, 1, 0},
//                             {1, 1, 1, 1, 0, 1},
//                             {0, 0, 1, 0, 1, 0}};

        int[][] adjMatrix = {{0, 1, 0, 0, 0, 0, 0, 1, 0},   //Инициализация матрицы смежности
                             {1, 0, 0, 0, 0, 0, 0, 1, 0},
                             {0, 0, 0, 0, 0, 0, 0, 1, 0},
                             {0, 0, 0, 0, 1, 0, 0, 1, 0},
                             {0, 0, 0, 1, 0, 1, 0, 0, 0},
                             {0, 0, 0, 0, 1, 0, 1, 0, 0},
                             {0, 0, 0, 0, 0, 1, 0, 1, 0},
                             {1, 1, 1, 1, 0, 0, 1, 0, 1},
                             {0, 0, 0, 0, 0, 0, 0, 1, 0}};

//        int[][] adjMatrix = {{0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0},   //Инициализация матрицы смежности
//                {1, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0},
//                {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
//                {0, 1, 0, 0, 1, 0, 0, 1, 0, 0, 0},
//                {0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 0},
//                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
//                {0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 1},
//                {0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1},
//                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0},
//                {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1},
//                {0, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0}};

//        int[][] adjMatrix = {{0, 1, 1, 0, 0, 0},
//                             {1, 0, 1, 0, 0, 0},
//                             {1, 1, 0, 0, 1, 1},
//                             {0, 0, 0, 0, 0, 0},
//                             {0, 0, 1, 0, 0, 0},
//                             {0, 0, 1, 0, 0, 0}};

//        int[][] adjMatrix = {{0, 1, 1, 0, 1},
//                             {1, 0, 1, 0, 1},
//                             {1, 1, 0, 1, 1},
//                             {0, 0, 1, 0, 1},
//                             {1, 1, 1, 1, 0}};


        MatrixCover a = new MatrixCover(); // создание нового объекта
        // создание первого покрытия матрицы смежности дополнительного графа
        a.createFirstCover(ArrayOperations.findAdjComMatrix(adjMatrix));
        // вызов алгоритма
        a.doMalgrangeAlgorithm();
        // вывод результатов
        a.printMaxAndGreatestIndependentSets();
    }
}





