package com.alejitro.beerclient.reactive.services;

import com.alejitro.beerclient.reactive.common.model.CustomerDto;


import java.util.UUID;

public interface OrderService {

    CustomerDto createNewCustomer(CustomerDto customerDto);

    CustomerDto getCustomerById(UUID customerId);

    void updateCustomerById(UUID customerId, CustomerDto customerDto);

    void deleteCustomerById(UUID customerId);

}
