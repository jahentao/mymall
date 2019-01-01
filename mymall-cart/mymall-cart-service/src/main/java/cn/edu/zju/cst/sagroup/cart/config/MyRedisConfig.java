package cn.edu.zju.cst.sagroup.cart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.SerializationException;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.lang.Nullable;

@Configuration
public class MyRedisConfig {

    /**
     * 通用的 RedisTemplate
     * @param lettuceConnectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<String, Object> redisTemplate(LettuceConnectionFactory lettuceConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(lettuceConnectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setValueSerializer(new RedisSerializer<Long>() {

            @Nullable
            @Override
            public byte[] serialize(@Nullable Long aLong) throws SerializationException {
                return aLong == null ? null : String.valueOf(aLong).getBytes();
            }

            @Nullable
            @Override
            public Long deserialize(@Nullable byte[] bytes) throws SerializationException {
                return bytes == null ? null : Long.valueOf(new String(bytes));
            }
        });
        return template;
    }
}
