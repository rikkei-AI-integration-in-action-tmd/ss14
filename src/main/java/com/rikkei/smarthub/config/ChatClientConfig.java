package com.rikkei.smarthub.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChatClientConfig {

    @Bean
    public ChatClient chatClient(ChatClient.Builder chatClientBuilder, AiProperties aiProperties) {
        return chatClientBuilder
                .defaultSystem(aiProperties.getDefaultSystemPrompt())
                .defaultAdvisors(new SimpleLoggerAdvisor())
                .build();
    }
}
