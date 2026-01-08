package com.example.demo;

import org.springframework.core.io.ClassPathResource;
import org.springframework.util.StreamUtils;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public final class ResourceLoaderUtil {

    private ResourceLoaderUtil() {
    }

    public static String loadAsString(String classpathLocation) {
        try (InputStream in = new ClassPathResource(classpathLocation).getInputStream()) {
            return StreamUtils.copyToString(in, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new IllegalStateException("Failed to load resource: " + classpathLocation, e);
        }
    }
}