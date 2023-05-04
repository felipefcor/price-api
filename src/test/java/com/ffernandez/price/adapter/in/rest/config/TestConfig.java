package com.ffernandez.price.adapter.in.rest.config;

import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;

@ComponentScan("com.ffernandez.price.adapter.in.rest.mapper")
@ActiveProfiles("test")
public class TestConfig {}
