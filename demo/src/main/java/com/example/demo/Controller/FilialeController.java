package com.example.demo.Controller;

import com.example.demo.Model.Fabricant;
import com.example.demo.Model.Filiale;
import com.example.demo.Repository.FabricantRepository;
import com.example.demo.Repository.FilialeRepository;
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
public class FilialeController {
  @Autowired
  private FilialeRepository filialeRepository;

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
  public Filiale CreateFiliale(@Valid @RequestBody Filiale filiale) {
    return filialeRepository.save(filiale);
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
