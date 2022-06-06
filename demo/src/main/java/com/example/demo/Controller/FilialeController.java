package com.example.demo.Controller;

import com.example.demo.Model.Fabricant;
import com.example.demo.Model.Filiale;
<<<<<<< HEAD
import com.example.demo.Model.Service;
import com.example.demo.Repository.FabricantRepository;
import com.example.demo.Repository.FilialeRepository;
import com.example.demo.Repository.ServiceRepository;
=======
import com.example.demo.Repository.FabricantRepository;
import com.example.demo.Repository.FilialeRepository;
>>>>>>> 3f2a8eb534787e4fe7c0624be81fc66d6ea3fa76
import com.example.demo.domaine.RessourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
<<<<<<< HEAD
import java.util.*;
=======
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
>>>>>>> 3f2a8eb534787e4fe7c0624be81fc66d6ea3fa76

@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class FilialeController {
  @Autowired
  private FilialeRepository filialeRepository;
<<<<<<< HEAD
  @Autowired
  private ServiceRepository serviceRepository;
=======
>>>>>>> 3f2a8eb534787e4fe7c0624be81fc66d6ea3fa76

  @GetMapping("/filiales")
  public List<Filiale> getAllFiliales() {
    System.out.println(filialeRepository.findAll());
    return filialeRepository.findAll();
  }

  @GetMapping("/filiales/{id}")
  public ResponseEntity<Filiale> getFilialebyId(@PathVariable(value = "id") Long FilialeId) {
    Filiale filiale = filialeRepository.findById(FilialeId)
      .orElseThrow(() -> new RessourceNotFoundException("FilialeId not found for this id :: " + FilialeId));
    return ResponseEntity.ok().body(filiale);
  }

  @PostMapping("/filiales")
<<<<<<< HEAD
  public void CreateFiliale(@Valid @RequestBody Map<String,String> object) {
    Filiale filiale=new Filiale();
    filiale.setId(8L);
    filiale.setNom_fil(object.get("nom_fil"));
    filiale.setDesc_fil(object.get("desc_fil"));
    filiale.setSect_fil(object.get("sect_fil"));
    Set<Service> services=new HashSet<Service>();
    Service service=new Service();
    service =serviceRepository.findByNom(object.get("services"));
    services.add(service);
    filiale.setService(services);
    filialeRepository.save(filiale);

=======
  public Filiale CreateFiliale(@Valid @RequestBody Filiale filiale) {
    return filialeRepository.save(filiale);
>>>>>>> 3f2a8eb534787e4fe7c0624be81fc66d6ea3fa76
  }


  @DeleteMapping("/filiales/{id}")
  public Map<String, Boolean> DeleteFiliale(@PathVariable(value = "id") Long FilialeId)
    throws RessourceNotFoundException {
    Filiale filiale = filialeRepository.findById(FilialeId)
      .orElseThrow(() -> new RessourceNotFoundException("Filiale not found  id :: " + FilialeId));

    filialeRepository.delete(filiale);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }


  @DeleteMapping("/filiales/delete")
  public ResponseEntity<String> deleteAllFiliales() {

    filialeRepository.deleteAll();

    return new ResponseEntity<>("All Filiales have been deleted!", HttpStatus.OK);
  }


  @PutMapping("/filiales/{id}")
  public ResponseEntity<Filiale> updateAgent(@PathVariable("id") long id, @RequestBody Filiale filiale) {


    Optional<Filiale> filialeInfo = filialeRepository.findById(id);

    if (filialeInfo.isPresent()) {
      Filiale filiale1 = filialeInfo.get();
      filiale1.setDesc_fil(filiale.getDesc_fil());
      filiale1.setNom_fil(filiale.getNom_fil());
      return new ResponseEntity<>(filialeRepository.save(filiale1), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }
}
