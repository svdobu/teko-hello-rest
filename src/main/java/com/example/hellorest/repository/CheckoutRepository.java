package com.example.hellorest.repository;

import com.example.hellorest.model.Checkout;
import org.springframework.data.repository.CrudRepository;

/**
 * Repository class for Checkout
 */

public interface CheckoutRepository extends CrudRepository<Checkout, Long> {
}
