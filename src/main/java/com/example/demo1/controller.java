package com.example.demo1;

import com.example.demo1.stock;
import com.example.demo1.service.stockservice;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/stocks")
@AllArgsConstructor
public class controller {
    private final stockservice stockservice;
    @GetMapping("/getStockData")
    public List<stock> getStockData() throws Exception
    {
        return stockservice.getCompanyData();
    }
}