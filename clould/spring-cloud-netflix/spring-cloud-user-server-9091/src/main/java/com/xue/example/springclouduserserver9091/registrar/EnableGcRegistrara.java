package com.xue.example.springclouduserserver9091.registrar;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(GcImportBeanDefinitionRegistrar.class)
public @interface EnableGcRegistrara {
}
