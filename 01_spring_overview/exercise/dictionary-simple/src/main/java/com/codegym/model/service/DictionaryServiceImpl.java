package com.codegym.model.service;

import com.codegym.model.repository.DictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DictionaryServiceImpl implements DictionaryService {

    @Autowired
    private DictionaryRepository repository;

    @Override
    public String find(String english) {
        return repository.find(english);
    }
}
