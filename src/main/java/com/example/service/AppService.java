package com.example.service;

import com.example.dao.AppRepository;
import com.example.model.App;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AppService {

    @Autowired
    private AppRepository appRepository;

    public void save(App app) {
        App savedApp = appRepository.save(app);
        System.out.println(savedApp.getId());
    }

    public List<App> getAll() {
        return StreamSupport
                .stream(
                        Spliterators.spliteratorUnknownSize(appRepository.findAll().iterator(), Spliterator.NONNULL),
                        false)
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());
    }

    public void delete(Integer appId) {
        appRepository.delete(appId);
    }
}
