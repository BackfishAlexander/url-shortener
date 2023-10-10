package com.alexbackfish.urlshortenerbackend.Controllers;

import com.alexbackfish.urlshortenerbackend.Entities.URLDto;
import com.alexbackfish.urlshortenerbackend.Entities.URLEntry;
import com.alexbackfish.urlshortenerbackend.Services.MainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


@RestController
public class MainController {


    @Autowired
    private MainService mainService;

    @GetMapping(path = "/url/{var}")
    public ResponseEntity<Void> getURL(@PathVariable("var") String id) {
        String targetUrl = mainService.getURL(id);
        if (targetUrl != null && !targetUrl.isEmpty()) {
            // Check if targetUrl starts with http:// or https://, if not prepend it
            if (!targetUrl.startsWith("http://") && !targetUrl.startsWith("https://")) {
                targetUrl = "http://" + targetUrl;
            }
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(URI.create(targetUrl));
            return new ResponseEntity<>(headers, HttpStatus.FOUND); // 302 status code
        } else {
            // Handle the case where the URL doesn't exist in your database
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @PostMapping(value = "/add/url", produces = "application/json")
    public ResponseEntity<URLDto> addNewURL(@RequestBody String url) {
        if (isValidURL(url)) {
            return ResponseEntity.ok(new URLDto(mainService.addURL(url)));
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    private boolean isValidURL(String url) {
        final String URL_REGEX = "^(https?:\\/\\/)?" + // protocol
                "((([a-z\\d]([a-z\\d-]*[a-z\\d])*)\\.)+[a-z]{2,}|" + // domain name
                "((\\d{1,3}\\.){3}\\d{1,3}))" + // OR ip (v4) address
                "(\\:\\d+)?(\\/[-a-z\\d%_.~+]*)*" + // port and path
                "(\\?[;&a-z\\d%_.~+=-]*)?" + // query string
                "(\\#[-a-z\\d_]*)?$";

            final Pattern URL_PATTERN = Pattern.compile(URL_REGEX, Pattern.CASE_INSENSITIVE);
                if (url == null || url.trim().isEmpty()) {
                    return false;
                }
                Matcher matcher = URL_PATTERN.matcher(url);
                return matcher.matches();
        }
}