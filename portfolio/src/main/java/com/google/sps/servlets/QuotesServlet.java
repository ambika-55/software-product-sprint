// Copyright 2019 Google LLC
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//     https://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.sps.servlets;

import com.google.sps.data.Quotes;
import com.google.sps.exchanges.GetQuotesResponse;
import com.google.gson.Gson;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/** Servlet that returns all quotes. TODO: modify this file to handle comments data */
@WebServlet("/random-quote")
public class QuotesServlet extends HttpServlet {

  private List<Quotes> quotes;

  @Override
  public void init() {

    List<String> allQuotes = new ArrayList<String>() {{
        add("All our dreams can come true, if we have the courage to pursue them. – Walt Disney");
        add("The secret of getting ahead is getting started. – Mark Twain");
        add("If people are doubting how far you can go, go so far that you can’t hear them anymore. – Michele Ruiz");
        add("Hold the vision, trust the process.");
        add("One day or day one. You decide.");
        add("Hustle in silence and let your success make the noise.");
        add("Some people want it to happen, some wish it would happen, others make it happen. – Michael Jordan");
        add("In the middle of every difficulty lies opportunity. – Albert Einstein");
    }};
    
    quotes.add(new Quotes("Quotations", allQuotes));
  }


  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
    GetQuotesResponse getQuotesResponse = new GetQuotesResponse(quotes);
    String responseString = new Gson().toJson(getQuotesResponse);

	response.setContentType("application/json");
    response.setCharacterEncoding("UTF-8");
    response.getWriter().print(responseString);
  }
}
