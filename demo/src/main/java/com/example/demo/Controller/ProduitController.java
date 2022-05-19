package com.example.demo.Controller;

import com.example.demo.Model.Produit;
import com.example.demo.Repository.ProduitRepository;
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
public class ProduitController {
  @Autowired
  private ProduitRepository produitRepository;

  @GetMapping("/produits")
  public List<Produit> getAllProduits(){
    return produitRepository.findAll();
  }
  @GetMapping("/produits/{id}")
  public ResponseEntity<Produit> getProduitById(@PathVariable(value = "id") Long ProduitId){
    Produit produit = produitRepository.findById(ProduitId)
      .orElseThrow(() -> new RessourceNotFoundException("Produit not found for this id :: " + ProduitId));
    return ResponseEntity.ok().body(produit);
  }
  @PostMapping("/produits")
  public Produit CreateProduit(@Valid @RequestBody Produit produit) {
    return produitRepository.save(produit);
  }


  @DeleteMapping("/produits/{id}")
  public Map<String, Boolean> DeleteProduit(@PathVariable(value = "id") Long ProduitId)
    throws RessourceNotFoundException {
    Produit produit = produitRepository.findById(ProduitId)
      .orElseThrow(() -> new RessourceNotFoundException("Produit not found  id :: " + ProduitId));
     produitRepository.delete(produit);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }


  @DeleteMapping("/produits/delete")
  public ResponseEntity<String> deleteAllProduits() {

    produitRepository.deleteAll();

    return new ResponseEntity<>("All Produits have been deleted!", HttpStatus.OK);
  }



  @PutMapping("/produits/{id}")
  public ResponseEntity<Produit> updateProduit(@PathVariable("id") Long id, @RequestBody Produit produit) {


    Optional<Produit> produitInfo = produitRepository.findById(id);

    if (produitInfo.isPresent()) {
      Produit produit1 =produitInfo.get();
      produit1.setConsomAnnee(produit.getConsomAnnee());
      produit1.setDesignation(produit.getDesignation());
      produit1.setPrix(produit.getPrix());
      produit1.setObservation(produit.getObservation());

      return new ResponseEntity<>(produitRepository.save(produit1), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }}
