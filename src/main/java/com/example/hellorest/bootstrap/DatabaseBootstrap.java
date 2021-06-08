package com.example.hellorest.bootstrap;

import com.example.hellorest.model.Checkout;
import com.example.hellorest.model.Customer;
import com.example.hellorest.repository.CheckoutRepository;
import com.example.hellorest.repository.CustomerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class DatabaseBootstrap implements InitializingBean {
    @Autowired
    CustomerRepository repository;

    @Autowired
    CheckoutRepository checkoutRepository;

    private static Logger log = LoggerFactory.getLogger(DatabaseBootstrap.class);

    @Override
    public void afterPropertiesSet() throws Exception {
        if (repository.findByFirstnameAndLastname("Felix", "Muster") == null) {
            Customer customer = new Customer();
            customer.setFirstname("Felix");
            customer.setLastname("Muster");
            repository.save(customer);
            log.info(customer.getFirstname() + " " + customer.getLastname() +
                    " created");

            // customer = repository.findByFirstnameAndLastname("Felix", "Muster");
            // Checkout checkout = new Checkout();
            // checkout.setCustomer(customer);
            // checkoutRepository.save(checkout);
        }
        log.info("Bootstrap finished");
    }

}
