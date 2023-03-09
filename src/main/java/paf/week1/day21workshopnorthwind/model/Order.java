package paf.week1.day21workshopnorthwind.model;

import java.time.LocalDateTime;

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
    private String shipZipPostalCode;
    private String shipCountryRegion;
    private float shippingFee;
    private float taxes;
    private String paymentType;
    private LocalDateTime paidDate;
    private int taxRate;
    private int statusId;

    
}
