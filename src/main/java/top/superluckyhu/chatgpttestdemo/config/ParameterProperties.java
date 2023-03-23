package top.superluckyhu.chatgpttestdemo.config;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName ParameterProperties
 * @Description TODO
 * @Author Superluckyhu
 * @Date 2023/3/5 17:39
 * @Version 1.0
 **/
@Component
@ConfigurationProperties(prefix = "chat")
@Setter
@Getter
@ToString
public class ParameterProperties {
    private String api_key;
    private String model_engine;
    private int max_tokens;
    private double temperature;
}
