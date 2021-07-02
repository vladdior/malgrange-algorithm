package com.mycompany.graphs_lab2;

import java.util.ArrayList;
import java.util.Arrays;

public class MatrixCover {
    private ArrayList<Subset> cover;

    public void createFirstCover(int[][] array) {   // в качестве аргумента передаем нашу матрицу
        // создаем новый объект класса MatrixCover
        cover = new ArrayList<>();

        // проходим матрицу по строкам
        for (int i = 0; i < array.length; i++) {
            // вызываем метод createSubset, в который передаем массив
            // и индекс строки
            cover.add(Subset.createSubset(array, i));
        }
    }

    public void printMaxAndGreatestIndependentSets() {
        ArrayList<int[]> array = new ArrayList<>();

        System.out.println("Максимальные внутренне-устойчивые множества:");
        for (Subset subset : cover) {
            if (subset.isVertex()) {
                System.out.println(Arrays.toString(subset.makeVertexes()));
                array.add(subset.makeVertexes());
            }
        }

        int size = 0;
        System.out.println("\nИз них наибольшие:");

        for (int[] i : array) {
            if (i.length > size) {
                size = i.length;
            }
        }

        for (int[] i : array) {
            if (i.length == size) {
                System.out.println(Arrays.toString(i));
            }
        }
    }

    private boolean areEqual(ArrayList<Subset> cover1, ArrayList<Subset> cover2) {
        if (cover1.size() != cover2.size()) {
            return false;
        } else {
            for (int i = 0; i < cover1.size(); i++) {
                if (!cover1.get(i).isContainedIn(cover2.get(i))) {
                    return false;
                }
            }
        }

        return true;
    }

    public void doMalgrangeAlgorithm() {
        // переписываем все подмножества из изначального в новое,
        // реализуя шаг 3.1
        // создаем новое покрытие
        ArrayList<Subset> cover1 = new ArrayList<>(cover);

        // реализация шага 3.2, создаем все возможные объединения и пересечения подмножеств
        for (int i = 0; i < cover.size(); i++) {
            for (int j = i + 1; j < cover.size(); j++) {
                cover1.add(cover.get(i).unionSubsets(cover.get(j)));
//                cover1.add(cover.get(i).intersectSubsets(cover.get(j)));
            }
        }

        // реализация шага 4 (удаление пустых подмножеств)
        for (int i = 0; i < cover1.size(); i++) {
            if (cover1.get(i).isEmpty()) {
                cover1.remove(i);
                i--;
            }
        }

        // реализация шага 4 (удаление подмножеств, которые содержатся в других)
        for (int i = 0; i < cover1.size(); i++) {
            for (int j = i + 1; j < cover1.size(); j++) {
                if (cover1.get(i).isContainedIn(cover1.get(j))) {
                    cover1.remove(i);
                    i--;
                    break;
                }
            }
        }

        // если покрытия не равны, рекурсивно вызываем метод, в ином случае - 
        // переходим к шагу 6
        if (!areEqual(cover, cover1)) {
            cover = cover1;
            doMalgrangeAlgorithm();
        }
    }
}
