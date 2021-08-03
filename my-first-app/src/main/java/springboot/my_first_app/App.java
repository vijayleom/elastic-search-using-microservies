package springboot.my_first_app;

import org.slf4j.MDC;
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
    	MDC.put("user.id", "User ID:");
        System.out.println( "Hello World!" );        
        SpringApplication.run(App.class, args);
    }
}
