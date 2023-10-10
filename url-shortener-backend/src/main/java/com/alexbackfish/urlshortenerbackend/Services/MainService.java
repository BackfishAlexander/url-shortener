package com.alexbackfish.urlshortenerbackend.Services;

import com.alexbackfish.urlshortenerbackend.Entities.URLEntry;
import com.alexbackfish.urlshortenerbackend.Generators.StringIdGenerator;
import com.alexbackfish.urlshortenerbackend.Repositories.MainRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MainService {

    @Autowired
    MainRepository mainRepository;

    public String getURL(String id) {
        return mainRepository.findById(id).get().getUrl();
    }

    public String addURL(String url) {
        URLEntry urlEntry = new URLEntry(url);
        mainRepository.saveAndFlush(urlEntry);
        return urlEntry.getId();
    }
}
