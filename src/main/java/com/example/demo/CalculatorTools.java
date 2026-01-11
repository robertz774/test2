package com.example.demo;


import io.modelcontextprotocol.spec.McpSchema;
import io.modelcontextprotocol.spec.McpSchema.ReadResourceResult;
import io.modelcontextprotocol.spec.McpSchema.TextResourceContents;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springaicommunity.mcp.annotation.McpResource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class CalculatorTools {
    private static final Logger LOGGER = LoggerFactory.getLogger("com.example.demo.CalculatorTools");

//    @McpTool(name = "add", description = "Add two numbers together")
//    public CallToolResult add(
//            @McpToolParam(description = "First number", required = true) int a,
//            @McpToolParam(description = "Second number", required = true) int b,
//            McpMeta mcpMeta) {
//        System.out.println("System.out.println add");
//        LOGGER.info("logger add");
//        Map<String, Object> meta = new HashMap<>(mcpMeta.meta());
//        meta.put("openai/outputTemplate", "ui://widget/chatgpt-app-todo.html");
//        meta.put("openai/toolInvocation/invoking", "Creating task...");
//        meta.put("openai/toolInvocation/invoked", "Task created");
//        return CallToolResult.builder()
//                .meta(meta)
//                .addTextContent("" + (a - b))
//                .build();
//    }
//
//    @McpTool(name = "search", description = "search description")
//    public Results search(
//            @McpToolParam(description = "search query", required = true) String query) {
//        System.out.println("System.out.println search");
//        LOGGER.info("logger search");
//        Results results = new Results();
//        results.setContent(List.of(new Content()));
//        return results;
//    }
//
//    @McpTool(name = "fetch", description = "fetch description")
//    public Results fetch(
//            @McpToolParam(description = "fetch id", required = true) String id) {
//        System.out.println("System.out.println fetch");
//        LOGGER.info("logger fetch");
//        Results results = new Results();
//        results.setContent(List.of(new Content()));
//        return results;
//    }
//
//    @McpTool(name = "divide", description = "Divide two numbers")
//    public double divide(
//            @McpToolParam(description = "Dividend", required = true) double dividend,
//            @McpToolParam(description = "Divisor", required = true) double divisor) {
//        if (divisor == 0) {
//            throw new IllegalArgumentException("Division by zero");
//        }
//        return dividend / divisor;
//    }

//    @McpTool(name = "calculate-expression",
//            description = "Calculate a complex mathematical expression")
//    public CallToolResult calculateExpression(
//            @McpToolParam(description = "expression", required = true) String expression,
//            CallToolRequest request,
//            McpSyncRequestContext context) {
//
//        Map<String, Object> args = request.arguments();
//        String expression2 = (String) args.get("expression");
//
//        // Use convenient logging method
//        context.info("Calculating: " + expression2);
//
//        try {
//            double result = evaluateExpression(expression2);
//            return CallToolResult.builder()
//                    .addTextContent("Result: " + result)
//                    .build();
//        } catch (Exception e) {
//            return CallToolResult.builder()
//                    .isError(true)
//                    .addTextContent("Error: " + e.getMessage())
//                    .build();
//        }
//    }

//    @McpTool(name = "analyze-document",
//            description = "Analyze document content")
//    public String analyzeDocument(
//            McpSyncRequestContext context,
//            @McpToolParam(description = "Document ID", required = true) String docId,
//            @McpToolParam(description = "Analysis type", required = false) String type) {
//
//        Document doc = new Document("doc1 content");
//        if (doc == null) {
//            return "Document not found";
//        }
//
//        // Access progress token from context
//        String progressToken = context.request().progressToken().toString();
//
//        if (progressToken != null) {
//            context.progress(p -> p.progress(0.0).total(1.0).message("Starting analysis"));
//        }
//
//        // Perform analysis
//        String analysisType = type != null ? type : "summary";
//        String result = "reult analysis";//"performAnalysis(doc, analysisType);"
//
//        if (progressToken != null) {
//            context.progress(p -> p.progress(1.0).total(1.0).message("Analysis complete"));
//        }
//
//        return result;
//    }

    private double evaluateExpression(String expression) {
        return Double.parseDouble(expression);
    }

//    @McpResource(uri = "config://{key}", name = "Configuration")
//    public String getConfig(String key) {
//        return "config-" + key;
//    }
//
//    @McpResource(
//            uri = "document://{id}",
//            name = "Document",
//            description = "Access stored documents")
//    public ReadResourceResult getDocument(String id, McpMeta meta) {
//        Document doc = new Document("doc1 content");
//
//        if (doc == null) {
//            return new ReadResourceResult(List.of(
//                    new TextResourceContents("document://" + id,
//                            "text/plain", "Document not found")
//            ));
//        }
//
//        // Check access permissions from metadata

    /// /        String accessLevel = (String) meta.get("accessLevel");
    /// /        if ("restricted".equals(doc.getClassification()) &&
    /// /                !"admin".equals(accessLevel)) {
    /// /            return new ReadResourceResult(List.of(
    /// /                    new TextResourceContents("document://" + id,
    /// /                            "text/plain", "Access denied")
    /// /            ));
    /// /        }
//
//        return new ReadResourceResult(List.of(
//                new TextResourceContents("document://" + id,
//                        "text/plain", doc.getFormattedContent())
//        ));
//    }
//    @McpResource(uri = "ui://widget/chatgpt-app-todo.html",
//            name = "chatgpt-app-todo-widget nme",
//            description = "chatgpt-app-todo-widget desc",
//            mimeType = "text/html+skybridge", title = "chatgpt-app-todo-widget titl")
//    public String todoApp(McpSchema.ReadResourceRequest value) {
//        return "<html>  <head>\n" +
//                "    <meta charset=\"UTF-8\">\n" +
//                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
//                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
//                "    <title>My Website</title>\n" +
//                "  </head>" +
//
//                "<body>" +
//                "   <div>\n" +
//                "      <h1>Task Tracker " + value.toString() + "</h1>\n" +
//                "      <h1>Task Tracker " + value + "</h1>\n" +
//                "      <p>Stay organized and productive</p>" +
//                "   </div>" +
//                "</body>" +
//                "</html>";
//
//    }
    @McpResource(
            uri = "ui://widget/product-carousel.html",
            mimeType = "text/html+skybridge",
            title = "product-carousel title123")
    public ReadResourceResult productCarousel(McpSchema.ReadResourceRequest request) {
        String text = "<script>" +

                "console.log(window.openai?.toolInput);" +
                "console.log(window.openai?.toolOutput);" +
                "console.log(window.openai);" +

                "</script>" +
                "<div>" +
                "   <h1>Task Tracker1</h1>" +
                "   <h1>" + request + "</h1>" +
                "   <p>Stay organized and productive4</p>" +
                "</div>" +
                "<div id='box1'>a</div>" +
                "<div id='box2'></div>" +
                "<div id='box3'></div>" +
                "<div id='box4'></div>" +
                "<div id='box5'></div>" +
                "<div id='box6'></div>" +
                "<div id='box7'>f</div>" +
                "<script>" +
                "console.log('a');" +
                "console.log('window.openai?.toolOutput',window.openai?.toolOutput);" +
                "console.log('JSON.stringify',JSON.stringify(window.openai?.toolOutput));" +
                "document.getElementById('box1').innerHTML = 'New Content';" +
                "document.getElementById('box2').innerHTML = window.openai?.locale;" +
                "document.getElementById('box3').innerHTML = window.openai?.toolOutput?.term1;" +
                "document.getElementById('box4').innerHTML = JSON.stringify(window.openai?.toolOutput);" +
                "document.getElementById('box5').innerHTML = window.openai;" +
                "document.getElementById('box6').innerHTML = 'last one';" +
                "console.log('e');" +
//                "window.openai?.sendFollowUpMessage({\"prompt\": \"Draft a tasting itinerary for the pizzerias I favorited.\"});" +
                "</script>";
        TextResourceContents textResourceContents=new TextResourceContents(
                "ui://widget/product-carousel.html",
                "text/html+skybridge",
                text,
                Map.of(
                        "openai/widgetPrefersBorder",true,
                        "openai/widgetDomain","https://chatgpt.com",
                        "openai/widgetCSP","{}"
                ));
        return new ReadResourceResult(List.of(textResourceContents));
    }

//    @McpResource(uri = "ui://widget/chatgpt-app-todo.html",
//            name = "chatgpt-app-todo-widget nme",
//            description = "chatgpt-app-todo-widget desc",
//            mimeType = "text/html+skybridge", title = "chatgpt-app-todo-widget titl")
//    public String todoApp(String key) {
//        return "<html>  <head>\n" +
//                "    <meta charset=\"UTF-8\">\n" +
//                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
//                "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n" +
//                "    <title>My Website</title>\n" +
//                "  </head>" +
//
//                "<body>" +
//                "   <div>\n" +
//                "      <h1>Task Tracker</h1>\n" +
//                "      <p>Stay organized and productive</p>" +
//                "   </div>" +
//                "</body>" +
//                "</html>";
//
//    }


//    @McpPrompt(
//            name = "document-summary",
//            description = "Generate document summary prompt")
//    public McpSchema.GetPromptResult documentSummaryPrompt(
//            @McpArg(name = "docId", required = true) String docId,
//            @McpArg(name = "length", required = false) String length) {
//
//        Document doc = new Document("doc1 content");
//        if (doc == null) {
//            return new McpSchema.GetPromptResult("Error",
//                    List.of(new PromptMessage(Role.ASSISTANT,
//                            new TextContent("Document not found"))));
//        }
//
//        String promptText = String.format(
//                "Please summarize the following document in %s:\n\n%s",
//                length != null ? length : "a few paragraphs",
//                doc.getText()
//        );
//
//        return new McpSchema.GetPromptResult("Document Summary",
//                List.of(new PromptMessage(Role.USER, new TextContent(promptText))));
//    }
//
//    @McpComplete(prompt = "document-summary")
//    public List<String> completeDocumentId(String prefix) {
//        return List.of("a", "b", prefix);
//    }
}