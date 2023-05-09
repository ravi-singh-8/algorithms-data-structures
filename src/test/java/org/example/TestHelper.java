package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.util.List;

public class TestHelper{

    public static List<String> getFileData(String filePath) throws IOException {
        try(InputStream in = TestHelper.class.getResourceAsStream("/"+filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(in))
        ) {
            return br.lines().toList();
        }
    }
}
