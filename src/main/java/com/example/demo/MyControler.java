package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyControler {

    @Autowired
    PizzaRepos repository;

    @GetMapping("/")
    public String index(){
        return "index"; //index.html
    }
    @GetMapping("/add")
    public @ResponseBody String add(@RequestParam String name, @RequestParam Integer size){
        Pizza pizza = new Pizza(name, size);
        repository.save(pizza);
        return "Saved!";
    }
    @GetMapping("/all")
    public @ResponseBody Iterable<Pizza> getAll() {
        return repository.findAll();
    }
}
