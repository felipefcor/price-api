package com.ffernandez.price.adapter.out.persistence.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

@ComponentScan("com.ffernandez.price.adapter.out.persistence")
@ActiveProfiles("test")
public class TestConfig {}
