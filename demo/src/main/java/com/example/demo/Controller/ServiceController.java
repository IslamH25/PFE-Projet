package com.example.demo.Controller;

import com.example.demo.Model.Fabricant;
import com.example.demo.Model.Service;
import com.example.demo.Repository.ServiceRepository;
import com.example.demo.domaine.RessourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ServiceController {
  @Autowired
  private ServiceRepository serviceRepository;

  @GetMapping("/services")
  public List<Service> getAllServices(){
<<<<<<< HEAD
    System.out.println(serviceRepository.findAll());
=======
>>>>>>> 3f2a8eb534787e4fe7c0624be81fc66d6ea3fa76
    return serviceRepository.findAll();
  }
  @GetMapping("/services/{id}")
  public ResponseEntity<Service> getServiceById(@PathVariable(value = "id") Long ServiceId){
    Service service = serviceRepository.findById(ServiceId)
      .orElseThrow(() -> new RessourceNotFoundException("Service not found for this id :: " + ServiceId));
    return ResponseEntity.ok().body(service);
  }
  @PostMapping("/services")
  public Service CreateService(@Valid @RequestBody Service service) {
    return serviceRepository.save(service);
  }


  @DeleteMapping("/services/{id}")
  public Map<String, Boolean> DeleteService(@PathVariable(value = "id") Long ServiceId)
    throws RessourceNotFoundException {
    Service service =serviceRepository.findById(ServiceId)
      .orElseThrow(() -> new RessourceNotFoundException("Service not found  id :: " + ServiceId));

    serviceRepository.delete(service);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }


  @DeleteMapping("/services/delete")
  public ResponseEntity<String> deleteAllServices() {

    serviceRepository.deleteAll();

    return new ResponseEntity<>("All Services have been deleted!", HttpStatus.OK);
  }



  @PutMapping("/services/{id}")
  public ResponseEntity<Service> updateService(@PathVariable("id") long id, @RequestBody Service service) {


    Optional<Service> serviceInfo = serviceRepository.findById(id);

    if (serviceInfo.isPresent()) {
       Service service1= serviceInfo.get();
      service1.setDesignation_serv(service.getDesignation_serv());
      service1.setNom_serv(service.getNom_serv());


      return new ResponseEntity<>(serviceRepository.save(service1), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }}
