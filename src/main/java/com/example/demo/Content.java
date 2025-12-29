package com.example.demo;

public class Content {
    private String type;
    private String text;

    public String getType() {
        return "text";
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getText() {
        return "{\"results\":[{\"id\":\"doc-1\",\"title\":\"...\",\"url\":\"...\"}]}";
    }
    //"{\"id\":\"doc-1\",\"title\":\"...\",\"text\":\"full text...\",\"url\":\"https://example.com/doc\",\"metadata\":{\"source\":\"vector_store\"}}"

    public void setText(String text) {
        this.text = text;
    }
}
