package com.schimibusiness.hackerman.services;

import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class MainService {

    public ArrayList<String> getAllEndpoints() throws IOException {
    ArrayList<String> urls = readFileLines("C:\\Users\\schim\\OneDrive\\Plocha\\hackerman\\src\\main\\java\\com\\schimibusiness\\hackerman\\services\\urls.txt");

    return urls;
    }

    public static ArrayList<String> readFileLines(String filePath) throws IOException {
        ArrayList<String> lines = new ArrayList<>();
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }
        return lines;
    }

    public void setUser(String name, String adr){
        System.setProperty("NAME", name);
        System.setProperty("ADR", adr);
    }

    //theoretical
    public void fillDatabase(){

    }
    //todo(if I decide to make that), use some kind of functionality for the database, definitelly h2 database, would be cool if I knew how to use that, hehe



}
