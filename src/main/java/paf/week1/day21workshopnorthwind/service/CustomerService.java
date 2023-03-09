package paf.week1.day21workshopnorthwind.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Service;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonArrayBuilder;
import paf.week1.day21workshopnorthwind.model.Customer;
import paf.week1.day21workshopnorthwind.repository.CustomerRepo;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepo custRepo;

    public List<Customer> getAllCustomerAsList(int limit, int offset){
        return custRepo.getAllCustomerAsList(limit, offset);        
    }
    
    public JsonArray getAllCustomerAsJson(int limit, int offset){

        final List<Customer> custList = custRepo.getAllCustomerAsList(limit, offset);

        JsonArrayBuilder jsonArrBuilder = Json.createArrayBuilder();
        for(Customer i:custList){
            jsonArrBuilder.add(i.toJson());            
        }
        JsonArray jsonArr = jsonArrBuilder.build();

        return jsonArr;  
    }

    public Optional<Customer> getCustomerById(int id){
        SqlRowSet rs = custRepo.getCustomerById(id);

        if(rs.first()){
            return Optional.of(Customer.populate(rs));
        }
        return Optional.empty();
    }
}
