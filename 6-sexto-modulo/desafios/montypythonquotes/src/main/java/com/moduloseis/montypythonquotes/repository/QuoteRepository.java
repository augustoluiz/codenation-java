package com.moduloseis.montypythonquotes.repository;

import com.moduloseis.montypythonquotes.entity.Quote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface QuoteRepository extends JpaRepository<Quote, Integer> {

    @Query(value = "SELECT * FROM SCRIPTS ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<Quote> getRandomQuote();

    @Query(value = "SELECT * FROM SCRIPTS WHERE ACTOR LIKE %:nomeActor% ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<Quote> getRandomQuoteByActor(@Param("nomeActor") String nomeActor);
}
