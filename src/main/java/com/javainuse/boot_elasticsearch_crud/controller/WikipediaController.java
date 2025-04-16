package com.javainuse.boot_elasticsearch_crud.controller;

import com.javainuse.boot_elasticsearch_crud.model.Wikipedia;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

public interface WikipediaController {

    @Operation(summary = "Get All Documents", description = "Get All Wikipedia Documents With Pagination")
    @GetMapping()
    ResponseEntity<Page<Wikipedia>> findAll(@PageableDefault(size = 10, page = 0) Pageable pageable);

    @Operation(summary = "Save a Document", description = "Save the document to Database",
            security = @SecurityRequirement(name = "bearerAuth"))
    @PostMapping()
    ResponseEntity<Wikipedia> save(@RequestBody Wikipedia wikipedia);

    @Operation(summary = "Delete a Document", description = "Delete the document from Database",
            security = @SecurityRequirement(name = "bearerAuth"))
    @DeleteMapping()
    ResponseEntity<Void> delete(@RequestParam String id);

    @Operation(summary = "Search for a Document by Title", description = "Search for a Document by Title")
    @ApiResponse(responseCode = "200", description = "return documents with searched title",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Page.class))))
    @GetMapping("/search/title")
    ResponseEntity<Iterable<Wikipedia>> findByTitle(@RequestParam String value,
                                                           @PageableDefault(size = 10, page = 0) Pageable pageable);
    @Operation(summary = "Search for a Document by Content", description = "Search for a Document by Content")
    @ApiResponse(responseCode = "200", description = "return documents with searched content",
            content = @Content(array = @ArraySchema(schema = @Schema(implementation = Page.class))))
    @GetMapping("/search/content")
    ResponseEntity<Iterable<Wikipedia>> findByContent(@RequestParam String value,
                                                             @PageableDefault(size = 10, page = 0) Pageable pageable);

}
