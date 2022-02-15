package com.part.one;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class LegoService {

    @Autowired
    LegoRepository repository;

    public Collection<Lego> getAllLego() {
        return repository.getAllLego();
    }


    public Collection<Lego> getSearchedLego(String searchedText) {

        return repository.getAllLego()
                    .stream()
                    .filter(x -> x.getName().toLowerCase().matches(".*" + searchedText.toLowerCase() + ".*") ||
                    searchedText.equals(Integer.toString(x.getId())) ||
                    searchedText.equals(Integer.toString(x.getParentId())))
                    .collect(Collectors.toList());
    }
}

