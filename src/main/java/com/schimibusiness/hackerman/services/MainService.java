package com.schimibusiness.hackerman.services;

import com.schimibusiness.hackerman.models.Document;
import com.schimibusiness.hackerman.repositories.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MainService {

    private final DocumentRepository documentRepository;

    public void fileUploader(String path, String name) throws IOException {
        File file = new File(path);
        byte[] bytes = Files.readAllBytes(Paths.get(path));
        Document document = new Document();
        document.setContent(bytes);
        document.setName(name);
        documentRepository.save(document);
    }

    public String fileReturner(String name){
        Optional<Document> document = documentRepository.findByName(name);
        return Arrays.toString(document.get().getContent());
    }

    public byte[] getFileBytes(String name){
        Optional<Document> docOpt = documentRepository.findByName(name);
        return docOpt.map(Document::getContent).orElse(null);
    }

    // Theoretical
    public void fillDatabase() {
        // todo(if I decide to make that), use some kind of functionality for the database, definitely h2 database, would be cool if I knew how to use that, hehe
    }
}
