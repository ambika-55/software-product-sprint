package com.google.sps.Helpers;

import com.google.sps.Data.Quotes;
import java.util.List;

public class GetQuotesResponse {
    private List<Quotes> quotes;

    public GetQuotesResponse(List<Quotes> quotes) {
        this.quotes = quotes;
    }
}