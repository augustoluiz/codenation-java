package com.moduloseis.montypythonquotes.service;

import com.moduloseis.montypythonquotes.entity.Quote;

public interface QuoteService {

    Quote getQuote();

    Quote getQuoteByActor(String actor);

}
