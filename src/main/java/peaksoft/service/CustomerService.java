package peaksoft.service;

import peaksoft.model.Customer;

import java.util.List;

public interface CustomerService {
    void saveCustomer(Customer customer);
    Customer getCustomerById(Long id);
    List<Customer> getAllCustomers();
    void updateCustomer(Long id, Customer newCustomer);
    void deleteCustomerById(Long id);
    void  assignCustomerToAgency(Long customerId, List<Long> agencyIdes);
}
