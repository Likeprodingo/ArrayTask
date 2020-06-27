package by.shibaev.arraytask.service;

import by.shibaev.arraytask.entity.CustomArray;
import by.shibaev.arraytask.entity.SortFunction;
import by.shibaev.arraytask.enumeration.JaggedArraySortType;
import by.shibaev.arraytask.exception.CustomException;
import by.shibaev.arraytask.validator.ArrayValidator;
import by.shibaev.arraytask.validator.JaggedArrayValidator;

public class JaggedArrayService {
    public int[][] jaggedArraySort(int[][] array, JaggedArraySortType sortType) throws CustomException {
        JaggedArrayValidator arrayValidator = new JaggedArrayValidator();
        SortFunction sortFunction;
        if (!arrayValidator.jaggedValid(array)) {
            throw new CustomException();
        }
        switch (sortType) {
            case MAX:
                sortFunction =(a) -> {
                    int max = a[0];
                    for (int i : a) {
                        if(max < i){
                            max = i;
                        }
                    }
                    return max;
                };
                break;
            case MIN:
                sortFunction =(a) -> {
                    int min = a[0];
                    for (int i : a) {
                        if(min > i){
                            min = i;
                        }
                    }
                    return min;
                };
                break;
            case SUM:
                sortFunction =(a) -> {
                    int sum = 0;
                    for (int i : a) {
                        sum += i;
                    }
                    return sum;
                };
                break;
            default:
                throw new CustomException();
        }
        return sort(array, sortFunction);
    }


    private int[][] sort(int[][] array, SortFunction sort){
        int [] temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (sort.sortFunc(array[i]) > sort.sortFunc(array[i+1])) {
                    temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                }
            }
        }
        return array;
    }

}
