package com.moduloseis.montypythonquotes.service;

import com.moduloseis.montypythonquotes.entity.Quote;
import com.moduloseis.montypythonquotes.repository.QuoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteServiceImpl implements QuoteService {

    @Autowired
    private QuoteRepository repository;

    @Override
    public Quote getQuote() {
        return repository.getRandomQuote().get();
    }

    @Override
    public Quote getQuoteByActor(String actor) {
        return repository.getRandomQuoteByActor(actor).get();
    }

}
