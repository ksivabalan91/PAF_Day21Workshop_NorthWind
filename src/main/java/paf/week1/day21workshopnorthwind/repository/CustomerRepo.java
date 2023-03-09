package paf.week1.day21workshopnorthwind.repository;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import paf.week1.day21workshopnorthwind.model.Customer;
import paf.week1.day21workshopnorthwind.model.Order;

@Repository
public class CustomerRepo {

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    
    //! SQL query
    final String allCustSQL = "select * from customers limit ? offset ?;";
    
    public List<Customer> getAllCustomerAsList(int limit, int offset){        
        final List<Customer> custList = new LinkedList<>();        
        final SqlRowSet rs = jdbcTemplate.queryForRowSet(allCustSQL,limit,offset);
        while (rs.next()){
            Customer cust = Customer.populate(rs);       
            custList.add(cust);
        }        
        return Collections.unmodifiableList(custList);
    }

    //! SQL query
    final String custByIDSQL = "select * from customers where id=?";
    
    public SqlRowSet getCustomerById(int id){
        return jdbcTemplate.queryForRowSet(custByIDSQL,id);
    }
    
    //! SQL query
    final String ordersByCust = "select * from orders where customer_id=?";

    public List<Order> getOrdersByCustomer(int id){
        final List<Order> orderList = new LinkedList<>();  
        final SqlRowSet rs = jdbcTemplate.queryForRowSet(ordersByCust,id);
        while(rs.next()){
            Order order = Order.populate(rs);
            orderList.add(order);            
        }
        return orderList;
    }


}
