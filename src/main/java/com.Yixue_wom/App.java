import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

@EnableAutoConfiguration
public class App {
    public static void main(String[] args){
        System.out.println("123");
        SpringApplication.run(App.class,args);
    }
}
