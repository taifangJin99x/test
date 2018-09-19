package com.example.demo.com.by.repository;

import com.example.demo.com.by.domain.EsTest;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface EsRepository extends ElasticsearchRepository<EsTest,String> {
}
