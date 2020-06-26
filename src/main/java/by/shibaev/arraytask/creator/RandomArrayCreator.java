package by.shibaev.arraytask.creator;

import by.shibaev.arraytask.entity.CustomArray;

import java.rmi.MarshalException;
import java.util.Random;

public class RandomArrayCreator {
    private static final int UPPER_LIMIT = 1000;

    public CustomArray creatRandomArray(int length) {
        CustomArray array = new CustomArray();
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            array.add(random.nextInt(UPPER_LIMIT));
        }
        return array;
    }
}
