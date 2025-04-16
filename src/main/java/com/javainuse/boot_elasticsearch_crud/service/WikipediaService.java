package com.javainuse.boot_elasticsearch_crud.service;

import com.javainuse.boot_elasticsearch_crud.model.Wikipedia;
import com.javainuse.boot_elasticsearch_crud.repository.WikipediaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WikipediaService {
    private final WikipediaRepository wikipediaRepository;


    public Page<Wikipedia> findAll(Pageable pageable) {
        return wikipediaRepository.findAll(pageable);
    }

    public Wikipedia save(Wikipedia wikipedia) {
        return wikipediaRepository.save(wikipedia);
    }

    public Iterable<Wikipedia> findByTitle(String title, Pageable pageable) {
        return wikipediaRepository.findByTitle(pageable, title);
    }

    public Iterable<Wikipedia> findByContent(String content, Pageable pageable) {
        return wikipediaRepository.findByContentContains(pageable, content);
    }

}
