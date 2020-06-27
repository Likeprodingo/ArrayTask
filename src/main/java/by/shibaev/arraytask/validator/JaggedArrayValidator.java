package by.shibaev.arraytask.validator;

public class JaggedArrayValidator {
    public boolean jaggedValid(int[][] array) {
        boolean result = true;
        if (array == null || array.length == 0) {
            result = false;
        } else {
            for (int[] ints : array) {
                if (ints.length == 0) {
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

}
