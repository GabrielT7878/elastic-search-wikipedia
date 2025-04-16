package com.javainuse.boot_elasticsearch_crud.repository;

import com.javainuse.boot_elasticsearch_crud.model.Wikipedia;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface WikipediaRepository extends ElasticsearchRepository<Wikipedia, String> {
    Page<Wikipedia> findAll(Pageable pageable);

    Page<Wikipedia> findByTitle(Pageable pageable,String title);

    Page<Wikipedia> findByContentContains(Pageable pageable, String content);
}
