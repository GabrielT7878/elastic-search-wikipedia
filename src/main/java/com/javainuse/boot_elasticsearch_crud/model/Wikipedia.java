package com.javainuse.boot_elasticsearch_crud.model;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.*;

import java.time.LocalDate;

@Data
@Document(indexName = "wikipedia")
public class Wikipedia {
    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String title;

    @Field(type = FieldType.Text)
    private String url;

    @Field(type = FieldType.Text)
    private String content;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @JsonProperty("dt_creation")
    @Field(type = FieldType.Date, name = "dt_creation")
    private LocalDate dtCreation;

    @JsonProperty("reading_time")
    @Field(type = FieldType.Long, name = "reading_time")
    private Long readingTime;
}