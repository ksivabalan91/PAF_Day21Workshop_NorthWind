package paf.week1.day21workshopnorthwind.model;

import java.time.LocalDateTime;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import jakarta.json.JsonObjectBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private int id;
    private int employeeId;
    private int customerId;
    private LocalDateTime orderDate;
    private LocalDateTime shippedDate;
    private int shipperId;
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipStateProvince;
    private int shipZipPostalCode;
    private String shipCountryRegion;
    private float shippingFee;
    private float taxes;
    private String paymentType;
    private LocalDateTime paidDate;
    private double taxRate;
    private int statusId;
    @Override
    public String toString() {
        JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();

        jsonBuilder
            .add("id", id)
            .add("employee_id", employeeId)
            .add("customer_id", customerId)
            .add("ship_name", shipName)
            .add("shipper_id", shipperId)
            .add("ship_address", shipAddress)
            .add("ship_city", shipCity)
            .add("ship_state_province", shipStateProvince)
            .add("ship_zip_postal_code", shipZipPostalCode)
            .add("ship_country_region", shipCountryRegion)
            .add("shipping_fee", shippingFee)
            .add("taxes", taxes)
            .add("tax_rate", taxRate)
            .add("status_id", statusId);

        if(orderDate!=null){jsonBuilder.add("order_date", orderDate.toString());}
        if(shippedDate!=null){jsonBuilder.add("shipped_date", shippedDate.toString());}
        if(paymentType!=null){jsonBuilder.add("payment_type", paymentType);}
        if(paidDate!=null){jsonBuilder.add("paid_date", paidDate.toString());}           
        JsonObject json = jsonBuilder.build();

        return json.toString();
    }

    public static Order populate (SqlRowSet rs){
        Order order = new Order();
        order.setId(rs.getInt("id"));
        order.setCustomerId(rs.getInt("customer_id"));
        order.setEmployeeId(rs.getInt("employee_id"));
        order.setOrderDate((LocalDateTime)rs.getObject("order_date"));
        order.setShippedDate((LocalDateTime)rs.getObject("shipped_date"));
        order.setShipperId(rs.getInt("shipper_id"));
        order.setShipName(rs.getString("ship_name"));
        order.setShipAddress(rs.getString("ship_address"));
        order.setShipCity(rs.getString("ship_city"));
        order.setShipStateProvince(rs.getString("ship_state_province"));
        order.setShipZipPostalCode(rs.getInt("ship_zip_postal_code"));
        order.setShipCountryRegion(rs.getString("ship_country_region"));
        order.setShippingFee(rs.getFloat("shipping_fee"));
        order.setTaxes(rs.getFloat("taxes"));
        order.setPaymentType(rs.getString("payment_type"));
        order.setPaidDate((LocalDateTime)rs.getObject("paid_date"));
        order.setTaxRate(rs.getDouble("tax_rate"));
        order.setStatusId(rs.getInt("status_id"));

        return order;
    }

    public JsonObject toJson() {
        JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();

        jsonBuilder
            .add("id", id)
            .add("employee_id", employeeId)
            .add("customer_id", customerId)
            .add("ship_name", shipName)
            .add("shipper_id", shipperId)
            .add("ship_address", shipAddress)
            .add("ship_city", shipCity)
            .add("ship_state_province", shipStateProvince)
            .add("ship_zip_postal_code", shipZipPostalCode)
            .add("ship_country_region", shipCountryRegion)
            .add("shipping_fee", shippingFee)
            .add("taxes", taxes)
            .add("tax_rate", taxRate)
            .add("status_id", statusId);

        if(orderDate!=null){jsonBuilder.add("order_date", orderDate.toString());}
        if(shippedDate!=null){jsonBuilder.add("shipped_date", shippedDate.toString());}
        if(paymentType!=null){jsonBuilder.add("payment_type", paymentType);}
        if(paidDate!=null){jsonBuilder.add("paid_date", paidDate.toString());}           
        
        JsonObject json = jsonBuilder.build();
        
        return json;
    }

}
