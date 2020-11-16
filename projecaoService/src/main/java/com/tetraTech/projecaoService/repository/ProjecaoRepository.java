package com.tetraTech.projecaoService.repository;

import com.tetraTech.projecaoService.core.model.ProjecaoResult;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;

import java.util.*;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProjecaoRepository {


    public boolean saveObject(ProjecaoResult obj) {

        File arq = newFile();

        if (!arq.exists()) {
            try {
                arq.createNewFile();
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }

        try {
            FileOutputStream fileOutPut = new FileOutputStream(arq);
            ObjectOutputStream objOutPut = new ObjectOutputStream(fileOutPut);

            objOutPut.writeObject(obj);

            objOutPut.flush();
            fileOutPut.flush();

            objOutPut.close();
            fileOutPut.close();

            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }


    public List<Object> getObject() throws IOException {

        List<String> files = listFilesUsingFileWalk();
        List<Object> listObject = new ArrayList<>();
        files.forEach(f -> {
            listObject.add(transformFileToObject(f));
        });
        return listObject;
    }

    public List<String> listFilesUsingFileWalk() throws IOException {

        try (Stream<Path> stream = Files.walk(Paths.get("archives"), 1)) {
            return stream
                    .filter(file -> !Files.isDirectory(file)).limit(10)
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .sorted(Collections.reverseOrder())
                    .collect(Collectors.toList());
        }
    }

    private Object transformFileToObject(String fileName) {

        String path = pathDefinition().concat(fileName);
        File arq = new File(path);

        try {
            FileInputStream fileInput = new FileInputStream(arq);
            ObjectInputStream objInput = new ObjectInputStream(fileInput);
            Object result = objInput.readObject();

            objInput.close();
            fileInput.close();

            return result;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private File newFile() {
        String directory = pathDefinition();
        System.out.println(directory);
        Date date = new Date();
        String nameFile = "log.txt";
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        nameFile = directory.concat(formatter.format(date).replace(':', '-').trim()).concat(nameFile);
        File arq = new File(nameFile);
        return arq;
    }

    private String pathDefinition() {

        return "archives/";
    }
}
