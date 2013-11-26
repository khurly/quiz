package com.khurley.quiz.module;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.khurley.quiz.EntityContext;

@Configuration
@Import({ EntityContext.class, ServicesContext.class })
public class ServicesApplicationContext {

}
