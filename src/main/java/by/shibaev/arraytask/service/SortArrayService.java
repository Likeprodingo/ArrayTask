package by.shibaev.arraytask.service;

import by.shibaev.arraytask.entity.CustomArray;
import by.shibaev.arraytask.exception.CustomException;

public class SortArrayService {
    public CustomArray bubbleAscendingSort(CustomArray array) throws CustomException {
        int temp;
        CustomArray sortedArray = new CustomArray(array);
        for (int i = 0; i < sortedArray.getLenght() - 1; i++) {
            for (int j = 0; j < sortedArray.getLenght() - i - 1; j++) {
                if (sortedArray.getElement(i) > sortedArray.getElement(i + 1)) {
                    temp = sortedArray.getElement(i);
                    sortedArray.setElement(i, array.getElement(i + 1));
                    sortedArray.setElement(i + 1, temp);
                }
            }
        }
        return sortedArray;
    }

    public CustomArray bubbleDescendingSort(CustomArray array) throws CustomException {
        CustomArray sortedArray = bubbleAscendingSort(array);
        sortedArray.reverse();
        return sortedArray;
    }

    public CustomArray insertAscendingSort(CustomArray array) throws CustomException {
        CustomArray sortedArray = new CustomArray(array);
        int temp;
        for (int i = 0; i < sortedArray.getLenght() - 1; i++) {
            temp = sortedArray.getElement(i + 1);
            if (sortedArray.getElement(i) > temp) {
                sortedArray.setElement(i + 1, sortedArray.getElement(i));
                for (int j = i; j > 0; j--) {
                    if (sortedArray.getElement(j - 1) < temp) {
                        sortedArray.setElement(j, temp);
                    } else {
                        sortedArray.setElement(j, sortedArray.getElement(j - 1));
                    }
                }
            }
        }
        return sortedArray;
    }

    public CustomArray insertDescendingSort(CustomArray array) throws CustomException {
        CustomArray sortedArray = insertAscendingSort(array);
        sortedArray.reverse();
        return sortedArray;
    }

    private int partDivision(CustomArray array, int begin, int end) throws CustomException {
        int counter = begin;
        for (int i = begin; i < end; i++) {
            if (array.getElement(i) < array.getElement(end)) {
                int temp = array.getElement(counter);
                array.setElement(counter, array.getElement(i));
                array.setElement(i, temp);
                counter++;
            }
        }
        int temp = array.getElement(end);
        array.setElement(end, array.getElement(counter));
        array.setElement(counter, temp);

        return counter;
    }

    public void quickAscendingSort(CustomArray array, int begin, int end) throws CustomException {
        if (end <= begin) return;
        int center = partDivision(array, begin, end);
        quickAscendingSort(array, begin, center - 1);
        quickAscendingSort(array, center + 1, end);
    }

    public CustomArray quickDescendingSort(CustomArray array, int begin, int end) throws CustomException {
        CustomArray sortedArray = new CustomArray(array);
        quickAscendingSort(sortedArray, begin, end);
        sortedArray.reverse();
        return sortedArray;
    }


}
