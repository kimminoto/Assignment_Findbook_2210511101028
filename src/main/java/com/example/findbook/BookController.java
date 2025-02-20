package com.example.findbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {
    @Autowired
    private BookRepository repo;

    @GetMapping("/findbook")
    String searchIsbn(Model model){
        return "findbook"; //เชื่อมกับ Template
    }//http://localhost:8080/findbook


    @PostMapping("/findbook")
    String searchedIsbn(Model model, @RequestParam String isbn){
        List<Book> books = repo.findByIsbn(isbn);
        model.addAttribute("all_books",books);
        return "result";
    }

}
