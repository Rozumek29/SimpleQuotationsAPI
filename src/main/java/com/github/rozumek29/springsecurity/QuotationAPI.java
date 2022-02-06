package com.github.rozumek29.springsecurity;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class QuotationAPI {

    private List<Quotation> quotationList;

    public QuotationAPI() {
        this.quotationList = new ArrayList<>();
        this.quotationList.add(new Quotation("To, że milczę, nie znaczy, że nie mam nic do powiedzenia.", "Jonathan Carroll"));
        this.quotationList.add(new Quotation("Lepiej zaliczać się do niektórych, niż do wszystkich.", "Andrzej Sapkowski"));
    }

    @GetMapping("/api/getQuotations")
    public List<Quotation> getQuotationList(String[] args) {
        return this.quotationList;
    }

    @PostMapping("/api/addQuotation")
    public Boolean addQuotation(@RequestBody Quotation quotation){
       return this.quotationList.add(quotation);
    }

    @DeleteMapping("/api/removeQuotation")
    public void removeQuotation(@RequestParam int index){
        this.quotationList.remove(index);
    }

}
