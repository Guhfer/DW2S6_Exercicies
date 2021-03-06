package com.br.ifsp.dw2.taskmanager.controller;

import com.br.ifsp.dw2.taskmanager.controller.resource.TagResource;
import com.br.ifsp.dw2.taskmanager.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/tags")
public class TagController {

    private final TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping
    public ResponseEntity<TagResource> create(@Valid @RequestBody TagResource tagResource) {
        try {
            return new ResponseEntity<>(tagService.saveTag(tagResource), HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>(e.getStatusCode());
        }
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_ETIQUETA') and #oauth2.hasScope('read')")
    public ResponseEntity<TagResource> getTagById(@PathVariable Long id) {
        try {
            return new ResponseEntity<>(tagService.findTagById(id), HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>(e.getStatusCode());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<TagResource> updateTagById(@PathVariable Long id,
                                                     @Valid @RequestBody TagResource tagResource) {
        try {
            return new ResponseEntity<>(tagService.updateById(id, tagResource), HttpStatus.NO_CONTENT);
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>(e.getStatusCode());
        }
    }

    @GetMapping("/find-by-name/{name}")
    public ResponseEntity<TagResource> getTagByName(@PathVariable String name) {
        try {
            return new ResponseEntity<>(tagService.findTagByName(name), HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>(e.getStatusCode());
        }
    }

    @GetMapping
    public ResponseEntity<List<TagResource>> getAll() {
        return new ResponseEntity<>(tagService.findAll(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable Long id) {

        try {
            tagService.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            return new ResponseEntity<>(e.getStatusCode());
        }
    }

}
