package com.alejitro.beerclient.reactive.client;

import com.alejitro.beerclient.reactive.common.model.BeerDto;
import com.alejitro.beerclient.reactive.common.model.BeerPagedList;
import com.alejitro.beerclient.reactive.common.model.BeerStyleEnum;
import com.alejitro.beerclient.reactive.config.WebClientConfig;
import com.alejitro.beerclient.reactive.repositories.BeerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

class BeerClientImplTest {

    BeerClientImpl beerClient;


    @BeforeEach
    void setUp() {
        beerClient = new BeerClientImpl(new WebClientConfig().webClient());

        BeerDto beerDto = BeerDto
                .builder()
                .beerName("Poker")
                .beerStyle(BeerStyleEnum.ALE)
                .upc("324233543")
                .price(new BigDecimal("2.500"))
                .build();

        beerClient.createBeer(beerDto);

    }

    @Test
    void getBeerById() {
    }

    @Test
    void listBeers() {
        Mono<BeerPagedList> beerListMono = beerClient.listBeers(null, null, null, null, null);

        BeerPagedList beerPagedList = beerListMono.block();

        assertThat(beerPagedList).isNotNull();
        assertThat(beerPagedList.getContent().size()).isGreaterThan(0);
        System.out.println(beerPagedList.toList());
    }

    @Test
    void createBeer() {
        BeerDto beerDto = BeerDto
                .builder()
                .beerName("Poker")
                .beerStyle(BeerStyleEnum.ALE)
                .upc("324233543")
                .price(new BigDecimal("2.500"))
                .build();

        Mono<ResponseEntity<Void>> responseEntityMono = beerClient.createBeer(beerDto);

        ResponseEntity responseEntity = responseEntityMono.block();

        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);

    }

    @Test
    void updateBeer() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void getBeerByUpc() {
    }
}