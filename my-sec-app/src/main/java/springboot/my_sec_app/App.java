package springboot.my_sec_app;

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
		MDC.put("entry.id", "Entry ID:");
        System.out.println( "Hello World - My Second app!" );
        SpringApplication.run(App.class, args);
    }
}
