package com.example;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor


public class Books {


    private int bookid;

    private String bookname;

    private String author;

    private int price;

}