package com.alejitro.beerclient.reactive.client;

import com.alejitro.beerclient.reactive.common.model.BeerDto;
import com.alejitro.beerclient.reactive.common.model.BeerPagedList;
import com.alejitro.beerclient.reactive.common.model.BeerStyleEnum;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface BeerClient {
    Mono<BeerDto> getBeerById(UUID beerId, Boolean showInventoryOnHand);

    Mono<BeerPagedList> listBeers(Integer pageNumber, Integer pageSize, String beerName,
                                  String beerStyle, Boolean showInventoryOnHand);

    Mono<ResponseEntity>  createBeer(BeerDto beerDto);

    Mono<ResponseEntity> updateBeer(BeerDto beerDto);

    Mono<ResponseEntity> deleteById(UUID beerId);

    Mono<BeerDto> getBeerByUpc(String upc);

}
