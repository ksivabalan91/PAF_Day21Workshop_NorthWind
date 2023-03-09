package paf.week1.day21workshopnorthwind.model;

import org.springframework.jdbc.support.rowset.SqlRowSet;

import jakarta.json.Json;
import jakarta.json.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private int id;
    private String company;
    private String lastName;
    private String firstName;
    private String jobTitle;
    private String businessPhone;
    private String faxNumber;
    private String address;
    private String city;
    private String stateProvince;
    private int zipPostalCode;
    private String countryRegion;
    
    public JsonObject toJson(){
        JsonObject json = Json.createObjectBuilder()
        .add("id", id)
        .add("company", company)
        .add("last_name", lastName)
        .add("first_name", firstName)
        .add("job_title", jobTitle)
        .add("business_phone", businessPhone)
        .add("fax_number", faxNumber)
        .add("address", address)
        .add("city", city)
        .add("state_province", stateProvince)
        .add("zip_postal_code", zipPostalCode)
        .add("country_region", countryRegion)
        .build();

        return json;

    }

    @Override
    public String toString() {
        JsonObject json = Json.createObjectBuilder()
            .add("id", id)
            .add("company", company)
            .add("last_name", lastName)
            .add("first_name", firstName)
            .add("job_title", jobTitle)
            .add("business_phone", businessPhone)
            .add("fax_number", faxNumber)
            .add("address", address)
            .add("city", city)
            .add("state_province", stateProvince)
            .add("zip_postal_code", zipPostalCode)
            .add("country_region", countryRegion)
            .build();

        return json.toString();
    }

    public static Customer populate(SqlRowSet rs) {
        Customer cust = new Customer();
        cust.setId(rs.getInt("id"));
        cust.setCompany(rs.getString("company"));
        cust.setLastName(rs.getString("last_name"));
        cust.setFirstName(rs.getString("first_name"));
        cust.setJobTitle(rs.getString("job_title"));
        cust.setBusinessPhone(rs.getString("business_phone"));
        cust.setFaxNumber(rs.getString("fax_number"));
        cust.setAddress(rs.getString("address"));
        cust.setCity(rs.getString("city"));
        cust.setStateProvince(rs.getString("state_province"));
        cust.setZipPostalCode(rs.getInt("zip_postal_code"));
        cust.setCountryRegion(rs.getString("country_region"));
        return cust;
    }

    

     
}
