package com.google.sps.Data;

import java.util.List;

/** Class containing quotes 
* which consists of a name/title and it's corresponding list 
* of quotes.
*/
public class Quotes {

    private String name;
    private List<String> quotes;

    public Quotes(String title, List<String> quoteList) {
        this.name = title;
        this.quotes = quoteList;
    }
}