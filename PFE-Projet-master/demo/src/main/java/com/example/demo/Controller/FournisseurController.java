package com.example.demo.Controller;

import com.example.demo.Model.Fabricant;
import com.example.demo.Model.Fournisseur;
import com.example.demo.Repository.FabricantRepository;
import com.example.demo.Repository.FournisseurRepository;
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
public class FournisseurController {
  @Autowired
  private FournisseurRepository fournisseurRepository;

  @GetMapping("/fournisseurs")
  public List<Fournisseur> getAllFournisseurs(){
    return fournisseurRepository.findAll();
  }
  @GetMapping("/fournisseurs/{id}")
  public ResponseEntity<Fournisseur> getFournisseurById(@PathVariable(value = "id") Long FournisseurId){
    Fournisseur fournisseur = fournisseurRepository.findById(FournisseurId)
      .orElseThrow(() -> new RessourceNotFoundException("Fournisseur not found for this id :: " + FournisseurId));
    return ResponseEntity.ok().body(fournisseur);
  }
  @PostMapping("/fournisseurs")
  public Fournisseur CreateFournisseur(@Valid @RequestBody Fournisseur fournisseur) {
    return fournisseurRepository.save(fournisseur);
  }


  @DeleteMapping("/fournisseurs/{id}")
  public Map<String, Boolean> DeleteFournisseur(@PathVariable(value = "id") Long FournisseurId)
    throws RessourceNotFoundException {
    Fournisseur fournisseur = fournisseurRepository.findById(FournisseurId)
      .orElseThrow(() -> new RessourceNotFoundException("Fournisseur not found  id :: " + FournisseurId));

    fournisseurRepository.delete(fournisseur);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }


  @DeleteMapping("/fournisseurs/delete")
  public ResponseEntity<String> deleteAllFournisseurs() {

    fournisseurRepository.deleteAll();

    return new ResponseEntity<>("All Fournisseurs have been deleted!", HttpStatus.OK);
  }



  @PutMapping("/fournisseurs/{id}")
  public ResponseEntity<Fournisseur> updateFournisseur(@PathVariable("id") long id, @RequestBody Fournisseur fournisseur) {


    Optional<Fournisseur> fournisseurInfo = fournisseurRepository.findById(id);

    if (fournisseurInfo.isPresent()) {
      Fournisseur fournisseur1 = fournisseurInfo.get();
      fournisseur1.setNom_four(fournisseur.getNom_four());

      return new ResponseEntity<>(fournisseurRepository.save(fournisseur1), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }}
