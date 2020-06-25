package by.shibaev.arraytask.validator;

import by.shibaev.arraytask.entity.CustomArray;
import by.shibaev.arraytask.exception.CustomException;

public class ArrayValidator {
    public boolean trueIndex(int index, int length) {
        return index > 0 && index < length;
    }

    public boolean validateArray(CustomArray array) {
        return array != null && array.getLenght() != 0;
    }

    public boolean trueLength(int length) {
        return length > 0;
    }
}
