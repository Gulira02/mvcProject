package peaksoft.repository;

import peaksoft.model.Agency;
import peaksoft.model.Customer;

import java.util.List;

public interface CustomerRepository {
    void saveCustomer(Customer customer);
    Customer getCustomerById(Long id);
    List<Customer> getAllCustomers();
    void updateCustomer(Long id, Customer newCustomer);
    void deleteCustomerById(Long id);
    void assignCustomerToAgency(Long customerId,List<Long> agencyIdes);
}
