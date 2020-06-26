package by.shibaev.arraytask.validator;

public class InputValidator {
    public boolean isStringInt(String string) {
        boolean result = true;
        int num;
        try {
            num = Integer.parseInt(string);
        } catch (NumberFormatException e) {
            result = false;
        }
        return result;
    }
}
