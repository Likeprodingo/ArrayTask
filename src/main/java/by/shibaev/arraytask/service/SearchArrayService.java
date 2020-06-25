package by.shibaev.arraytask.service;

import by.shibaev.arraytask.entity.CustomArray;
import by.shibaev.arraytask.exception.CustomException;
import by.shibaev.arraytask.validator.ArrayValidator;

public class SearchArrayService {
    public int binarySearch(CustomArray array, int element, int begin, int end) throws CustomException {
        ArrayValidator arrayValidator = new ArrayValidator();
        int index = -1;
        int mid;
        if (!arrayValidator.validateArray(array) || !arrayValidator.trueIndex(end, array.getLenght()) || !arrayValidator.trueIndex(begin, array.getLenght())) {
            throw new CustomException();
        }
        while (begin <= end) {
            mid = (begin + end) / 2;
            if (array.getElement(mid) < element) {
                begin = mid + 1;
            } else if (array.getElement(mid) > element) {
                end = mid - 1;
            } else if (array.getElement(mid) == element) {
                index = mid;
                break;
            }
        }
        return index;
    }

    public int maxValueIndex(CustomArray array) throws CustomException {
        ArrayValidator arrayValidator = new ArrayValidator();
        if (!arrayValidator.validateArray(array)) {
            throw new CustomException();
        }
        int max = 0;
        for (int i = 0; i < array.getLenght(); i++) {
            if (array.getElement(i) > array.getElement(max)) {
                max = i;
            }
        }
        return max;
    }

    public int minValueIndex(CustomArray array) throws CustomException {
        ArrayValidator arrayValidator = new ArrayValidator();
        if (!arrayValidator.validateArray(array)) {
            throw new CustomException();
        }
        int min = 0;
        for (int i = 0; i < array.getLenght(); i++) {
            if (array.getElement(i) < array.getElement(min)) {
                min = i;
            }
        }
        return min;
    }

    public CustomArray specialNumbers(CustomArray array) throws CustomException {
        int i;
        int j;
        int k;
        String number;
        ArrayValidator arrayValidator = new ArrayValidator();
        if (!arrayValidator.validateArray(array)) {
            throw new CustomException();
        }
        CustomArray specialNumbers = new CustomArray();
        for (i = 0; i < array.getLenght(); i++) {
            number = Integer.toString(array.getElement(i));
            if (number.length()!=3){
                continue;
            }
            compareCycle:
            for (j = 0; j < number.length() - 1; j++) {
                for (k = j + 1; k < number.length(); k++) {
                    if (number.charAt(j) == number.charAt(k)) {
                        break compareCycle;
                    }
                }
            }
            if (j == number.length() - 2) {
                specialNumbers.add(array.getElement(i));
            }
        }
        return specialNumbers;
    }

    public CustomArray primeNumbers(CustomArray array) throws CustomException {
        int i;
        int j;
        int element;
        ArrayValidator arrayValidator = new ArrayValidator();
        CustomArray primeNumbers = new CustomArray();
        if (!arrayValidator.validateArray(array)) {
            throw new CustomException();
        }
        for (i = 0; i < array.getLenght(); i++) {
            element = array.getElement(i);
            for (j = 2; j < element; j++) {
                if (element % j == 0) {
                    break;
                }
            }
            if (j == element - 1) {
                primeNumbers.add(element);
            }
        }
        return primeNumbers;
    }


}
