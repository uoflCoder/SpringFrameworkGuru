package guru.springframework.configuration;

import guru.services.GreetingRepository;

import guru.services.GreetingService;
import guru.services.GreetingServiceFactory;
import org.springframework.context.annotation.*;

@Configuration
public class GreetingServiceConfiguration
{
    @Bean
    GreetingServiceFactory greetingServiceFactory(GreetingRepository greetingRepository)
    {
        return new GreetingServiceFactory(greetingRepository);
    }

    @Bean
    @Primary
    @Profile({"en", "default"})
    GreetingService primaryGreetingService(GreetingServiceFactory greetingServiceFactory)
    {
        return greetingServiceFactory.createGreetingService("en");
    }

    @Bean
    @Primary
    @Profile("es")
    GreetingService primarySpanishGreetingService(GreetingServiceFactory greetingServiceFactory)
    {
        return greetingServiceFactory.createGreetingService("es");
    }


    @Bean
    @Primary
    @Profile({"de"})
    GreetingService primaryGermanGreetingService(GreetingServiceFactory greetingServiceFactory)
    {
        return greetingServiceFactory.createGreetingService("de");
    }


}
