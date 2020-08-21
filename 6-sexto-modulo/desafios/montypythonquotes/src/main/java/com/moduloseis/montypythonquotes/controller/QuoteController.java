package com.moduloseis.montypythonquotes.controller;

import com.moduloseis.montypythonquotes.entity.Quote;
import com.moduloseis.montypythonquotes.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/quote")
public class QuoteController {

    @Autowired
    private QuoteService service;

    @GetMapping
    public Quote getQuote() {
        return service.getQuote();
    }

    @GetMapping("/{actor}")
    public Quote getQuoteByActor(@PathVariable("actor") String actor) {
        return service.getQuoteByActor(actor);
    }

}
