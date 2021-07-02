package com.mycompany.graphs_lab2;

import java.util.ArrayList;

public class Subset {
    private final ArrayList<Integer> rows = new ArrayList<>();    // массив индексов строк
    private final ArrayList<Integer> cols = new ArrayList<>();    // массив индексов столбцов

    public static Subset createSubset(int[][] array, int index) { // index - значение текущей строки
        // Создаем новый объект класса Subset
        Subset a = new Subset();
        // Добавляем в поле rows значение переменной index
        a.rows.add(index);

        // проходим текущую строку матрицы
        for (int j = 0; j < array.length; j++) {
            // если значение в строке = 1, добавляем индекс столбца в поле cols
            if (array[index][j] == 1) {
                a.cols.add(j);
            }
        }
        // возвращаем новое подмножество
        return a;
    }

    public Subset unionSubsets(Subset a) { // передаем в качестве аргумента подмножество
        // создаем новое подмножество
        Subset c = new Subset();
        // добавляем в поле rows нового подмножества все значения соответствующего 
        // поля из подмножества a
        c.rows.addAll(rows);
        // пройдем все элементы rows подмножества a
        for (int i = 0; i < a.rows.size(); i++) {
            // если поле rows исходного подмножества не содержит какое-либо 
            // значение в соответствующем поле из a, добавляем его в новое подмножество
            if (!rows.contains(a.rows.get(i))) {
                c.rows.add(a.rows.get(i));
            }
        }

        // пройдем все элементы поля cols подмножества a
        for (int i = 0; i < a.cols.size(); i++) {
            // если поле cols исходного подмножества содержит идентичное значение
            // в a, добавляем его в новое подмножество
            if (cols.contains(a.cols.get(i))) {
                c.cols.add(a.cols.get(i));
            }
        }
        // возвращаем новое подмножество
        return c;
    }

    public boolean isEmpty() {
        return cols.isEmpty() || rows.isEmpty();
    }

    public boolean isContainedIn(Subset a) {    // передаем в качестве аргумента подмножество

        // если хотя бы одно значение из поля rows или cols исходного подмножества
        // не содержится в a, возвращаем false и прекращаем проверку
        for (int i = 0; i < cols.size(); i++) {
            if (!a.cols.contains(cols.get(i))) {
                return false;
            }
        }

        for (int i = 0; i < rows.size(); i++) {
            if (!a.rows.contains(rows.get(i))) {
                return false;
            }
        }
        // если все проверки пройдены, возвращаем true
        return true;
    }

    public boolean isVertex() {
        if (rows.size() != cols.size()) {
            return false;
        } else
            for (Integer row : rows) {
                if (!cols.contains(row)) {
                    return false;
                }
            }

        return true;
    }

    public int[] makeVertexes() {
        int[] array = new int[rows.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = rows.get(i);
        }

        return array;
    }
}
