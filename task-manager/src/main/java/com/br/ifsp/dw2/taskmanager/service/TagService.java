package com.br.ifsp.dw2.taskmanager.service;

import com.br.ifsp.dw2.taskmanager.controller.resource.TagResource;
import com.br.ifsp.dw2.taskmanager.entity.Tag;
import com.br.ifsp.dw2.taskmanager.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TagService {

    private final TagRepository tagRepository;

    @Autowired
    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public TagResource saveTag(TagResource tagResource) {

        if(tagRepository.existsByName(tagResource.getName())) {
            throw new HttpClientErrorException(HttpStatus.CONFLICT, "Tag already registered");
        }
        return buildTagResource(tagRepository.save(new Tag(tagResource)));
    }

    public TagResource findTagByName(String name) {
        return buildTagResource(tagRepository.findByName(name)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Tag not found for name:" + name)));
    }

    public Tag findById(Long id) {
        return tagRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Tag not found"));
    }

    public TagResource updateById(Long id, TagResource tagResource) {
        Tag tag = findById(id);

        if(tagRepository.existsByName(tagResource.getName())) {
            throw new HttpClientErrorException(HttpStatus.CONFLICT, "Tag already registered for name:" + tagResource.getName());
        }

        tag.setName(tagResource.getName());

        return buildTagResource(tagRepository.save(new Tag(tagResource)));
    }

    public TagResource findTagById(Long id) {
        return buildTagResource(tagRepository.findById(id)
                .orElseThrow(() -> new HttpClientErrorException(HttpStatus.NOT_FOUND, "Tag not found")));
    }

    public List<TagResource> findAll() {
        return tagRepository.findAll()
                .stream().map(this::buildTagResource).collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        findById(id);
        tagRepository.deleteById(id);
    }


    private TagResource buildTagResource(Tag tag) {
        return new TagResource(tag);
    }

}
