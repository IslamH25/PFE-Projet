package com.example.demo.Controller;

import com.example.demo.Model.Fabricant;
import com.example.demo.Model.Famille;
import com.example.demo.Repository.FabricantRepository;
import com.example.demo.Repository.FamilleRepository;
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
public class FamilleController {
  @Autowired
  private FamilleRepository familleRepository;

  @GetMapping("/familles")
  public List<Famille> getAllFamille(){
    return familleRepository.findAll();
  }
  @GetMapping("/familles/{id}")
  public ResponseEntity<Famille> getFamilleById(@PathVariable(value = "id") Long FamilleId){
    Famille famille= familleRepository.findById(FamilleId)
      .orElseThrow(() -> new RessourceNotFoundException("Famille not found for this id :: " + FamilleId));
    return ResponseEntity.ok().body(famille);
  }
  @PostMapping("/familles")
  public Famille CreateFamille(@Valid @RequestBody Famille famille) {
    return familleRepository.save(famille);
  }


  @DeleteMapping("/familles/{id}")
  public Map<String, Boolean> DeleteFamille(@PathVariable(value = "id") Long FamilleId)
    throws RessourceNotFoundException {
    Famille famille = familleRepository.findById(FamilleId)
      .orElseThrow(() -> new RessourceNotFoundException("Famille not found  id :: " + FamilleId));

    familleRepository.delete(famille);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }


  @DeleteMapping("/familles/delete")
  public ResponseEntity<String> deleteAllFamilles() {

    familleRepository.deleteAll();

    return new ResponseEntity<>("All Familles have been deleted!", HttpStatus.OK);
  }



  @PutMapping("/familles/{id}")
  public ResponseEntity<Famille> updateAgent(@PathVariable("id") long id, @RequestBody Famille famille) {


    Optional<Famille> familleInfo = familleRepository.findById(id);

    if (familleInfo.isPresent()) {
      Famille famille1 = familleInfo.get();
      famille1.setDesc_famille(famille.getDesc_famille());
      famille1.setNom_famille(famille.getNom_famille());
      famille1.setProduits(famille.getProduits());

      return new ResponseEntity<>(familleRepository.save(famille1), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }}
