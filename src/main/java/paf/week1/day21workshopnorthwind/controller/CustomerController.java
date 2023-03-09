package paf.week1.day21workshopnorthwind.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import paf.week1.day21workshopnorthwind.model.Customer;
import paf.week1.day21workshopnorthwind.service.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
    @Autowired
    private CustomerService customerSvc;

    @GetMapping(path="/customers", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getAllCustomers(@RequestParam(name="limit", defaultValue = "5") int limit, @RequestParam(name="offset", defaultValue = "0") int offset){

        JsonArray jsonArray = customerSvc.getAllCustomerAsJson(limit, offset);        

        if(jsonArray.isEmpty()){
            return ResponseEntity.status(404).body("Error 404, customer not found");
        } else{
            return ResponseEntity.ok().body(jsonArray.toString());
        }
    }

    @GetMapping(path="/customer/{customerID}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getCustomerByID(@PathVariable(name="customerID") int id){        
        Optional<Customer> opt = customerSvc.getCustomerById(id);

        if(opt.isEmpty()){
            return ResponseEntity.status(404).body(Json.createObjectBuilder().add("message", "Cannot find "+id).build().toString());
        }

        return ResponseEntity.status(201).body(opt.get().toJson().toString());
    }

    @GetMapping(path="/customer/{customerID}/orders", produces=MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> getOrderByCustomer(@PathVariable(name="customerID") int id){
        
        Optional<Customer> opt = customerSvc.getCustomerById(id);

        if(opt.isEmpty()){
            return ResponseEntity.status(404).body(Json.createObjectBuilder().add("message", "Cannot find "+id).build().toString());
        }

        
        return null;
    }
}
