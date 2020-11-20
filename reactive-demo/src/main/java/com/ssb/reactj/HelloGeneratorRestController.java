package com.ssb.reactj;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloGeneratorRestController {
    @GetMapping("/hellos/{n}")
    public ResponseEntity sendThemAHello(@PathVariable Integer n) {
        var stringBuilder = new StringBuilder();
        while (n < 6 && --n >= 0) stringBuilder.append(n == 0 ? "Hello" : "Hello-");
        return !stringBuilder.toString().equals("") ? ResponseEntity.ok(stringBuilder.toString()) : ResponseEntity.badRequest().body(n + " is invalid value");
    }
}