package me.about.intro.service;

import me.about.intro.repository.HomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HomeService {

    @Autowired
    HomeRepository homeRepository;

    public String serviceHome() {


        return "";

    }

    public String getMessage() {
        return "getMessage";

    }
}
