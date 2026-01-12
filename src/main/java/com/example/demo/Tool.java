package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.modelcontextprotocol.json.jackson.JacksonMcpJsonMapper;
import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.spec.McpSchema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.Map;

@Configuration
public class Tool {
    @Bean
    public List<McpServerFeatures.SyncToolSpecification> productSearch() {

        Map<String, Object> meta = Map.of(
                "openai/outputTemplate", "ui://widget/product-carousel2.html",
                "openai/resultCanProduceWidget", true,
                "openai/widgetAccessible", true
        );

        var tool = new McpSchema.Tool.Builder()
                .name("product search")
                .description("Search products by term")
                .inputSchema(new JacksonMcpJsonMapper(new ObjectMapper()), ResourceLoaderUtil.loadAsString("product-search-input-schema.json"))
               // .outputSchema(new JacksonMcpJsonMapper(new ObjectMapper()), ResourceLoaderUtil.loadAsString("product-search-output-schema.json"))
                //.annotations(new ToolAnnotations("product search annotation title", true, false, false, false, false))
                .meta(meta)
                .build();
        var gameListSpec = new McpServerFeatures.SyncToolSpecification( // #3
                tool, (exchange, request) -> {
            return McpSchema.CallToolResult.builder()
                    .structuredContent(new JacksonMcpJsonMapper(new ObjectMapper()), ResourceLoaderUtil.loadAsString("product-search-result.json"))
//                    .addTextContent("txtCont")
                    .build();
        });
        return List.of(gameListSpec); // #4
    }
}
