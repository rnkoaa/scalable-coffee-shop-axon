module org.richard.coffeeshop.barista {
    exports org.richard.coffeeshop.barista;
    opens org.richard.coffeeshop.barista;

    requires static lombok;

    // requires cache.api;

    requires java.activation;
    requires java.instrument;
    // requires java.persistence;
    requires java.sql;
    // requires java.transaction;
    requires java.validation;
    requires java.xml.bind;

    requires org.axonframework.modelling;
    requires org.axonframework.eventsourcing;
    requires org.axonframework.messaging;
    requires org.axonframework.spring;
    requires org.axonframework.springboot;
//requires org.axonframework.commandhandling;
//requires org.axonframework.disruptor;
    // requires org.hibernate.validator;

    requires spring.beans;
    requires spring.core;
    requires spring.context;
    // requires spring.tx;
    requires spring.web;
    requires spring.webmvc;
    // requires spring.data.commons;
    // requires spring.data.jpa;
    requires spring.boot;
    requires spring.boot.autoconfigure;
}