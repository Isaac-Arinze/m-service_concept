package com.zikan.employee_service.service;

import com.zikan.employee_service.model.Employee;
import com.zikan.employee_service.repository.EmployeeRepository;
import com.zikan.employee_service.response.AddressResponse;
import com.zikan.employee_service.response.EmployeeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private WebClient webClient;

   // @Autowired
//    private RestTemplate restTemplate;
//    @Value("${addressservice.base.url}")
//    private String addressBaseUrl;

    //a differnt way of using restTemplate to build and object and injecting it
//    public EmployeeService(@Value("${addressservice.base.url}") String addressBaseUrl, RestTemplateBuilder builder){
//
////        System.out.println("url " + addressBaseUrl);
//        this.restTemplate=builder
//                .rootUri(addressBaseUrl)
//                .build();
//    }



    public EmployeeResponse getEmployeeById(int id) {

        Employee employee = employeeRepository.findById(id).get();

        EmployeeResponse employeeResponse = modelMapper.map(employee, EmployeeResponse.class);
//       AddressResponse addressResponse = restTemplate.getForObject("/address/{id}", AddressResponse.class, id);
                       AddressResponse addressResponse = webClient
                                                        .get()
                                                        .uri("/address/"+id)
                                                        .retrieve()
                                                        .bodyToMono(AddressResponse.class)
                                                        .block();


        employeeResponse.setAddressResponse(addressResponse);

        return employeeResponse;


    }

//    private AddressResponse callingAddressServiceUsingRestTemplate(int id) {
//        return restTemplate.getForObject("/address/{id}", AddressResponse.class, id);
//    }
}
