package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.modelcontextprotocol.json.jackson.JacksonMcpJsonMapper;
import io.modelcontextprotocol.server.McpServerFeatures;
import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpSchema.Tool;
import io.modelcontextprotocol.spec.McpSchema.ToolAnnotations;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.web.exchanges.HttpExchangeRepository;
import org.springframework.boot.actuate.web.exchanges.InMemoryHttpExchangeRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Map;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public HttpExchangeRepository httpTraceRepository() {
        return new InMemoryHttpExchangeRepository();
    }

//    @Bean
//    public List<McpServerFeatures.SyncToolSpecification> gameTool() {
//
//        Map<String, Object> meta = new HashMap<>();
//        meta.put("openai/outputTemplate", "ui://widget/chatgpt-app-todo.html");

    /// /        meta.put("openai/toolInvocation/invoking", "Creating task...");
    /// /        meta.put("openai/toolInvocation/invoked", "Task created");
//
//        JacksonMcpJsonMapper jacksonMcpJsonMapper = new JacksonMcpJsonMapper(new ObjectMapper());
//
//        var gameListResource = new Tool.Builder()
//                .name("game list name")
//                .inputSchema(jacksonMcpJsonMapper, "{\n" +
//                        "        \"type\": \"object\",\n" +
//                        "        \"properties\": {\n" +
//                        "          \"a\": {\n" +
//                        "            \"type\": \"integer\",\n" +
//                        "            \"format\": \"int32\",\n" +
//                        "            \"description\": \"First number\"\n" +
//                        "          },\n" +
//                        "          \"b\": {\n" +
//                        "            \"type\": \"integer\",\n" +
//                        "            \"format\": \"int32\",\n" +
//                        "            \"description\": \"Second number\"\n" +
//                        "          }\n" +
//                        "        },\n" +
//                        "        \"required\": [\n" +
//                        "          \"a\",\n" +
//                        "          \"b\"\n" +
//                        "        ]\n" +
//                        "      }")
//                .annotations(new ToolAnnotations("", false, true, false, true, true))
//                .meta(meta)
//                .build();
//        var gameListSpec = new McpServerFeatures.SyncToolSpecification( // #3
//                gameListResource, (exchange, request) -> {
//            return McpSchema.CallToolResult.builder()
//                    .addTextContent("123")
//                    .build();
//        });
//        return List.of(gameListSpec); // #4
//    }
    @Bean
    public List<McpServerFeatures.SyncToolSpecification> productSearch() {

        Map<String, Object> meta = Map.of(
                "openai/outputTemplate", "ui://widget/product-carousel2.html",
                "openai/resultCanProduceWidget", true,
                "openai/widgetAccessible", true
        );

        var tool = new Tool.Builder()
                .name("product search")
                .description("Search products by term")
                .inputSchema(new JacksonMcpJsonMapper(new ObjectMapper()), ResourceLoaderUtil.loadAsString("product-search-schema.json"))
                .outputSchema(new JacksonMcpJsonMapper(new ObjectMapper()), ResourceLoaderUtil.loadAsString("product-search-output-schema.json"))
                //.annotations(new ToolAnnotations("product search annotation title", true, false, false, false, false))
                .meta(meta)
                .build();
        var gameListSpec = new McpServerFeatures.SyncToolSpecification( // #3
                tool, (exchange, request) -> {
            System.out.println("sout pole:1234 sout");
            System.out.println("sout pole:1234 sout");
            return McpSchema.CallToolResult.builder()
                    .structuredContent(new JacksonMcpJsonMapper(new ObjectMapper()), "{\"term1\":\"gitara1\"}")
//                    .addTextContent("txtCont")
                    .build();
        });
        return List.of(gameListSpec); // #4
    }

//    @Bean
//    public List<McpServerFeatures.SyncResourceSpecification>
//    gameResources() {
//        List<McpSchema.Role> audience = List.of(McpSchema.Role.USER);
//        McpSchema.Annotations annotations =
//                new McpSchema.Annotations(audience, 1.0);
//        var gameListResource = new McpSchema.Resource( // #1
//                "games://game-list",
//                "Game List",
//                "A list of games available in the repository",
//                "text/plain",
//                annotations
//        );
//        var gameTitles = List.of("game1", "game2");
//        var gameListText = new StringBuilder();
//        for (String title : gameTitles) {
//            gameListText.append("- ").append(title).append("\n");
//        }
//        var gameListResourceSpec = new
//                McpServerFeatures.SyncResourceSpecification( // #3
//                gameListResource, (exchange, request) -> {
//            return new McpSchema.ReadResourceResult(
//                    List.of(new McpSchema.TextResourceContents(
//                            request.uri(),
//                            "text/plain",
//                            gameListText.toString())));
//        });
//        return List.of(gameListResourceSpec); // #4
//    }


//    @Bean
//    public ToolsListResultDecorator toolsListResultDecorator() {
//        return result -> {
//            Map<String, Object> meta = new HashMap<>(result.meta());
//            meta.put("openai/outputTemplate", "ui://widget/chatgpt-app-todo.html");
//            meta.put("server/name", "demo-mcp");
//            return new McpSchema.ListToolsResult(result.tools(), result.nextCursor(), meta);
////                    .tools(result.tools())
////                    .meta(meta) // sets top-level "_meta" in tools/list response
////                    .build();
//        };
//    }
//
//    @FunctionalInterface
//    public interface ToolsListResultDecorator {
//        McpSchema.ListToolsResult decorate(McpSchema.ListToolsResult result);
//    }
}
