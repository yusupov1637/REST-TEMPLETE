package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@RestController
public class Controllerr {
    @Autowired
    private RestService restService;

    @PostMapping("/post")
    public String addBook(@RequestBody Books books,@RequestHeader HttpHeaders headers){
        String url="http://localhost:8080/books";

        HttpEntity<?> entity=new HttpEntity<>(books,headers);

        RestTemplate template=new RestTemplate();
        ResponseEntity<Books> exchange = template.exchange(url, HttpMethod.POST, entity, Books.class);
        return exchange.toString();
    }

    @GetMapping("/getAll")
    public List<Books> getAll(@RequestHeader HttpHeaders headers){
//        String token = restService.getToken(headerss.get("authorization"));

//        HttpHeaders headers=new HttpHeaders();
//        headers.setBearerAuth(token);
//        headers.setContentType(MediaType.APPLICATION_JSON);

        String url="http://localhost:8080/book";

        HttpEntity<?> entity=new HttpEntity<>(headers);

        RestTemplate template=new RestTemplate();

        ResponseEntity<Books[]> exchange = template.exchange(url, HttpMethod.GET, entity, Books[].class);

        return Arrays.asList(Objects.requireNonNull(exchange.getBody()));
    }
    @DeleteMapping("/book/{id}")
    public void delete(@PathVariable int id,@RequestHeader HttpHeaders headers){
//        String token = restService.getToken(headerss.get("authorization"));
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setBearerAuth(token);

        String url = "http://localhost:8080/book/"+id;
        HttpEntity<?> httpEntity = new HttpEntity<>(headers);

        RestTemplate template=new RestTemplate();

        ResponseEntity<Books> exchange = template.exchange(url, HttpMethod.DELETE, httpEntity, Books.class);

    }
    @PutMapping("/book")
    public void update(@RequestBody Books book,@RequestHeader HttpHeaders headers){

//        String token = restService.getToken(headerss.get("authorization"));
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setBearerAuth(token);

        String url = "http://localhost:8080/books";
        HttpEntity<?> httpEntity = new HttpEntity<>(book,headers);

        RestTemplate template=new RestTemplate();

        ResponseEntity<Books> exchange = template.exchange(url, HttpMethod.PUT, httpEntity, Books.class);

    }

}
