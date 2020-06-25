package by.shibaev.arraytask.entity;

import by.shibaev.arraytask.exception.CustomException;
import by.shibaev.arraytask.validator.ArrayValidator;

import java.util.Arrays;

public class CustomArray {
    private int[] array;

    public CustomArray(){
        array = new int[]{};
    }

    public CustomArray(int[] array) {
        this.array = array;
    }

    public CustomArray(CustomArray existedArray) throws CustomException {
        if (existedArray == null) {
            throw new CustomException();
        }
        array = new int[existedArray.getLenght()];
        for (int i = 0; i < array.length; i++) {
            array[i] = existedArray.getElement(i);
        }
    }

    public CustomArray(int num) throws CustomException {
        ArrayValidator arrayValidator = new ArrayValidator();
        if (!arrayValidator.trueLength(num)) {
            throw new CustomException();
        }
        this.array = new int[num];
    }

    public void add(int element){
        int[] newArray = new int[array.length+1];
        for(int i = 0; i < array.length; i++){
            newArray[i] = array[i];
        }
        newArray[array.length] = element;
        array = newArray;
    }

    public void setElement(int index, int value) throws CustomException {
        ArrayValidator arrayValidator = new ArrayValidator();
        if (!arrayValidator.trueIndex(index, array.length)) {
            throw new CustomException();
        }
        this.array[index] = value;
    }

    public int getLenght() {
        return array.length;
    }

    public int getElement(int index) throws CustomException {
        ArrayValidator arrayValidator = new ArrayValidator();
        if (!arrayValidator.trueIndex(index, array.length)) {
            throw new CustomException();
        }
        return array[index];
    }

    public void reverse() {
        int temp;
        for (int i = 0; i < array.length / 2; i++) {
            temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CustomArray that = (CustomArray) o;
        if (this.array.length == that.array.length) {
            return true;
        }
        return Arrays.equals(array, that.array);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(array);
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CustomArray{");
        if (array == null) sb.append("null");
        else {
            sb.append('[');
            for (int i = 0; i < array.length; ++i)
                sb.append(i == 0 ? "" : ", ").append(array[i]);
            sb.append(']');
        }
        sb.append('}');
        return sb.toString();
    }
}
