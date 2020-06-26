package by.shibaev.arraytask.creator;

import by.shibaev.arraytask.entity.CustomArray;
import by.shibaev.arraytask.exception.CustomException;
import by.shibaev.arraytask.validator.InputValidator;

import javax.imageio.IIOException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleArrayCreator {
    public CustomArray readArray(int length) throws CustomException {
        CustomArray array = new CustomArray();
        InputValidator validator = new InputValidator();
        String number;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            for (int i = 0; i < length; i++) {
                number = reader.readLine();
                if(validator.isStringInt(number)){
                    array.add(Integer.parseInt(number));
                    continue;
                }
                i--;
            }
        } catch (IOException e) {
            throw new CustomException();
        }
        return array;
    }

}
