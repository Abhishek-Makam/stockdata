package com.example.demo1.service;

import com.example.demo1.stock;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class stockservice {
    private static final String API_KEY = "2b1aecca44d398b032cff78b1a14e7a8"; // Replace with your API key

    public List<stock> getCompanyData() throws IOException {
        List<stock> stocks = new ArrayList<>();
        ObjectMapper mapper = new ObjectMapper();

        String[] symbols = {"AAPL", "GOOGL", "MSFT"}; // Symbols for Apple, Google, and Microsoft

        for (String symbol : symbols) {
            String apiUrl = "https://financialmodelingprep.com/api/v3/profile/" + symbol + "?apikey=" + API_KEY;
            URL url = new URL(apiUrl);

            JsonNode rootNode = mapper.readTree(url);
            JsonNode node = rootNode.get(0);

            stock stock = new stock();
            stock.setCompanyname(node.get("companyName").asText());
            stock.setSymbol(node.get("symbol").asText());
            // Set other fields based on the API response

            stocks.add(stock);
        }
        return stocks;
    }
}

