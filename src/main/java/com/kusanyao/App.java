package com.kusanyao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 *
 */
@SpringBootApplication
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "PHP 是世界上最好的语言，没有之一！" );
	    SpringApplication.run(App.class, args); // 启动Spring Boot
    }
}
