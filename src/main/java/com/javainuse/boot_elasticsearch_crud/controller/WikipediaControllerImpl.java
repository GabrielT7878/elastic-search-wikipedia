package com.javainuse.boot_elasticsearch_crud.controller;


import com.javainuse.boot_elasticsearch_crud.model.Wikipedia;
import com.javainuse.boot_elasticsearch_crud.service.WikipediaService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Tag(name = "Wikipedia", description = "Request Wikipedia Documents")
@RequestMapping("/wikipedia")
public class WikipediaControllerImpl  implements WikipediaController {
    private final WikipediaService wikipediaService;

    @GetMapping()
    public ResponseEntity<Page<Wikipedia>> findAll(@PageableDefault(size = 10, page = 0) Pageable pageable) {
        return ResponseEntity.ok(wikipediaService.findAll(pageable));
    }

    @PostMapping()
    public ResponseEntity<Wikipedia> save(@RequestBody Wikipedia wikipedia) {
        Wikipedia wikipediaSaved = wikipediaService.save(wikipedia);
        return ResponseEntity.ok(wikipediaSaved);
    }

    @DeleteMapping()
    public ResponseEntity<Void> delete(@RequestParam String id) {
        wikipediaService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/search/title")
    public ResponseEntity<Iterable<Wikipedia>> findByTitle(@RequestParam String value,
                                                           @PageableDefault(size = 10, page = 0) Pageable pageable) {
        Iterable<Wikipedia> wikipedia = wikipediaService.findByTitle(value, pageable);
        return ResponseEntity.ok(wikipedia);
    }

    @GetMapping("/search/content")
    public ResponseEntity<Iterable<Wikipedia>> findByContent(@RequestParam String value,
                                                             @PageableDefault(size = 10, page = 0) Pageable pageable) {
        Iterable<Wikipedia> wikipedia = wikipediaService.findByContent(value, pageable);
        return ResponseEntity.ok(wikipedia);
    }

}
