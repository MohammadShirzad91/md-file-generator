package com.example.mdfilegenerator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;

public class Generator {
    public static void generateMdForMethodExceptions(Class c) throws IOException {
        Method[] declaredMethods = c.getDeclaredMethods();
        for (Method declaredMethod : declaredMethods) {
            String mdFileName = declaredMethod.getName().substring(0, 1).toUpperCase() + declaredMethod.getName().substring(1) + ".md";
            createMdFileForMethod(declaredMethod, mdFileName);
        }
    }

    private static void createMdFileForMethod(Method declaredMethod, String mdFileName) throws IOException, IOException {
        File enFilePath = new File("D:\\md\\en\\" + mdFileName);
        FileOutputStream fileOutputStream = new FileOutputStream(enFilePath);
        fileOutputStream.write("<div style='text-align: justify;'>\n".getBytes());
        fileOutputStream.write("\n".getBytes());
        for (Class<?> exceptionType : declaredMethod.getExceptionTypes()) {
            String s = "> * " + exceptionType.getSimpleName() + ": " + exceptionType.getSimpleName() + "\n";
            fileOutputStream.write(s.getBytes());
        }
        fileOutputStream.write("\n".getBytes());
        fileOutputStream.write("</div>".getBytes());
        fileOutputStream.close();
    }
}
