package com.example.demo.Controller;

import com.example.demo.Model.Fabricant;
import com.example.demo.Model.Filiale;
import com.example.demo.Model.Fournisseur;
import com.example.demo.Model.Produit;
import com.example.demo.Repository.FabricantRepository;
import com.example.demo.Repository.FournisseurRepository;
import com.example.demo.Repository.ProduitRepository;
import com.example.demo.domaine.RessourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;


@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ProduitController {
  @Autowired
  private ProduitRepository produitRepository;
  @Autowired
  private FabricantRepository fabricantRepository;
  @Autowired
  private FournisseurRepository fournisseurRepository;

  @GetMapping("/produits")
  public ResponseEntity<?> getAllProduits(){
    return ResponseEntity.ok(produitRepository.findAll());
  }
  @GetMapping("/produits/{id}")
  public ResponseEntity<Produit> getProduitById(@PathVariable(value = "id") Long ProduitId){
    Produit produit = produitRepository.findById(ProduitId)
      .orElseThrow(() -> new RessourceNotFoundException("Produit not found for this id :: " + ProduitId));
    return ResponseEntity.ok().body(produit);
  }
  @PostMapping("/produits")
  public void CreateProduit(@Valid @RequestBody Map<String,String> object) {
  Produit produit= new Produit();
  produit.setRef_piece(Long.parseLong(object.get("ref_piece")));
  produit.setPrix(object.get("prix"));
  produit.setObservation(object.get("observation"));
  produit.setConsomAnnee(object.get("consomAnnee"));
  produit.setDesignation(object.get("designation"));
  Set<Fabricant> fabricants= new HashSet<Fabricant>();
  Fabricant fabricant=new Fabricant();
  fabricant= fabricantRepository.findByNom(object.get("fabricants"));
  fabricants.add(fabricant);
  produit.setFabricants(fabricants);
  Set<Fournisseur> fournisseurs = new HashSet<Fournisseur>();
  Fournisseur fournisseur=new Fournisseur();
  fournisseur= fournisseurRepository.findByNom(object.get("fournisseurs"));
  fournisseurs.add(fournisseur);
  produit.setFournisseurs(fournisseurs);
  produitRepository.save(produit);

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
  public ResponseEntity<Produit> updateProduit(@PathVariable Long id, @RequestBody Map<String,String>object) {


   Produit produit= produitRepository.findById(id).orElseThrow(() -> new RessourceNotFoundException("Produit not exist with id :" +id));
    produit.setRef_piece(Long.parseLong(object.get("ref_piece")));
    produit.setPrix(object.get("prix"));
    produit.setObservation(object.get("observation"));
    produit.setConsomAnnee(object.get("consomAnnee"));
    produit.setDesignation(object.get("designation"));
    Set<Fabricant> fabricants= new HashSet<Fabricant>();
    Fabricant fabricant=new Fabricant();
    fabricant= fabricantRepository.findByNom(object.get("fabricants"));
    fabricants.add(fabricant);
    produit.setFabricants(fabricants);
    Set<Fournisseur> fournisseurs = new HashSet<Fournisseur>();
    Fournisseur fournisseur=new Fournisseur();
    fournisseur= fournisseurRepository.findByNom(object.get("fournisseurs"));
    fournisseurs.add(fournisseur);
    produit.setFournisseurs(fournisseurs);
    Produit updatedProduit =produitRepository.save(produit);
    return ResponseEntity.ok(updatedProduit);

  }}
