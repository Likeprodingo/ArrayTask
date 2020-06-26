package by.shibaev.arraytask.creator;

import by.shibaev.arraytask.entity.CustomArray;
import by.shibaev.arraytask.exception.CustomException;
import by.shibaev.arraytask.validator.InputValidator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FIleArrayCreator {
    private static final String FILE_PATH = "src/main/resources/dataArray";

    public CustomArray readArray() throws CustomException {
        String values;
        values = readLine(FILE_PATH);
        return parseArray(values);
    }

    private CustomArray parseArray(String values) {
        CustomArray result = new CustomArray();
        InputValidator validator = new InputValidator();
        StringBuilder num = new StringBuilder("");
        char symbol;
        for (int i = 0; i < values.length(); i++) {
            symbol = values.charAt(i);
            if (symbol == ' ' && validator.isStringInt(num.toString())) {
                result.add(Integer.parseInt(num.toString()));
                num = new StringBuilder("");
                continue;
            }
            num.append(symbol);
        }
        return result;
    }

    private String readLine(String pathToFile) throws CustomException {
        String result;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(pathToFile))) {
            try {
                result = bufferedReader.readLine();
            } catch (IOException e) {
                throw new CustomException();
            }
        } catch (IOException e) {
            throw new CustomException();
        }
        return result;
    }
}
