package rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRule {

    @Bean
    public IRule mySelfRule()
    {
//        return new RandomRule();//定义为随机
        return new RoundRobinRule();//定义为随机
    }

}
