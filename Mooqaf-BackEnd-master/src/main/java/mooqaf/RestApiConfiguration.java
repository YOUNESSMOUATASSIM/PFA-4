/*package mooqaf;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.web.HateoasPageableHandlerMethodArgumentResolver;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;


@Configuration
public class RestApiConfiguration implements RepositoryRestConfigurer {
	
    
	
	@Bean
	@Primary
    public HateoasPageableHandlerMethodArgumentResolver customResolver(
       final HateoasPageableHandlerMethodArgumentResolver pageableResolver) {
        pageableResolver.setOneIndexedParameters(true);
        pageableResolver.setFallbackPageable(Pageable.unpaged());
       
        return pageableResolver;
    }
	
	
}*/