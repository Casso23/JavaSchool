package ru.sber.javaschool;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class FileHandlerTest {

    @Test
    public void setFileResult() {
        String testFileName = "test.txt";
        FileHandler fileHandler = new FileHandler();
        fileHandler.setFile(new File(testFileName));
        fileHandler.setFileResult();

        Assert.assertEquals(fileHandler.getFileResult().getAbsolutePath(),
                fileHandler.getFile().getAbsoluteFile().getParent()+"/result_"+testFileName);
    }

    @Test
    public void checkCharModify() {
        char testChar = '1';
        FileHandler fileHandler = new FileHandler();
        fileHandler.setReplacementChar(testChar);
        Assert.assertTrue(fileHandler.checkCharModify(testChar));
    }
}