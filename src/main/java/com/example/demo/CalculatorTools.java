package com.example.demo;


import org.springaicommunity.mcp.annotation.McpResource;
import org.springaicommunity.mcp.annotation.McpTool;
import org.springaicommunity.mcp.annotation.McpToolParam;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CalculatorTools {

    @McpTool(name = "add", description = "Add two numbers together")
    public int add(
            @McpToolParam(description = "First number", required = true) int a,
            @McpToolParam(description = "Second number", required = true) int b) {
        return a + b;
    }

    @McpTool(name = "search", description = "search description" )
    public Results search(
            @McpToolParam(description = "search query", required = true) String  query) {
        Results results = new Results();
        results.setContent(List.of(new Content()));
        return results;
    }

    @McpTool(name = "fetch", description = "fetch description")
    public Results fetch(
            @McpToolParam(description = "fetch id", required = true) String  id) {
        Results results = new Results();
        results.setContent(List.of(new Content()));
        return results;
    }
//
//    @McpResource(uri = "config://{key}", name = "Configuration")
//    public String getConfig(String key) {
//        return "config-" + key;
//    }
}