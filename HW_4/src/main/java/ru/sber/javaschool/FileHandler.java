package ru.sber.javaschool;

import lombok.Data;
import lombok.experimental.Accessors;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Data
@Accessors(chain = true)
public class FileHandler {

    private char replacementChar;
    private File file;
    private File fileResult;
    private long fileLength;

    public void startOfProcessing(String filePath, char replacementChar) throws IOException {
        this.replacementChar = replacementChar;
        this.file = new File(filePath);
        setFileResult();
        process();
    }

    public void setFileResult(){
        this.fileResult = new File(file.getAbsolutePath().replace(file.getName(),"result_"+file.getName()));
    }

    private void process() throws IOException {
        if(fileResult.exists()){
            if(!fileResult.delete()){
                throw new IOException("Ошибка удаления файла result_***");
            }
        }

        InputStream inputStream = new FileInputStream(file);
        Reader inputStreamReader = new InputStreamReader(inputStream);
        OutputStream outputStream = new FileOutputStream(fileResult);
        Writer outputStreamWriter = new OutputStreamWriter(outputStream);

        try {
            char[]buffer = new char[2048];
            int data = inputStreamReader.read(buffer);

            while (data != -1) {
                for (int i=0; i<buffer.length;i++) {
                    if (checkCharModify(buffer[i])) {
                        buffer[i]=' ';
                    }
                }
                outputStreamWriter.write(buffer);

                data = inputStreamReader.read(buffer);
            }
        }finally {
            inputStreamReader.close();
            outputStreamWriter.flush();
            outputStreamWriter.close();
        }
    }

    public boolean checkCharModify(char c){
        return (c==replacementChar);
    }
}
