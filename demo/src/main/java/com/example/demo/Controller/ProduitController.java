package com.example.demo.Controller;

<<<<<<< HEAD
import com.example.demo.Model.*;
import com.example.demo.Repository.*;
=======
import com.example.demo.Model.Produit;
import com.example.demo.Repository.ProduitRepository;
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
public class ProduitController {
  @Autowired
  private ProduitRepository produitRepository;
<<<<<<< HEAD
  @Autowired
  private FabricantRepository fabricantRepository;
  @Autowired
  private FournisseurRepository fournisseurRepository;

  @Autowired
  private FamilleRepository familleRepository;

  @Autowired
  private FilialeRepository filialeRepository;


  @GetMapping("/produits")
  public List<produitT> getAllProduits(){
    List<Produit> produits=produitRepository.findAll();
    System.out.println(produits);
    List<produitT> produitTS= new ArrayList<>();
    for(int i = 0; i < produits.size(); i++){
      Famille famille= produits.get(i).getFamille();
      Filiale filiale=  produits.get(i).getFiliale();
      produitT produitT=new produitT();
      produitT.setRef(produits.get(i).getRef_piece());
      produitT.setPrix(produits.get(i).getPrix());
      produitT.setDesignation(produits.get(i).getDesignation());
      produitT.setConsomAnnee(produits.get(i).getConsomAnnee());
      produitT.setNom_fil(filiale.getNom_fil());
      produitT.setNom_fam(famille.getNom_famille());
      produitT.setFournisseurs(produits.get(i).getFournisseurs());
      produitT.setFabricants(produits.get(i).getFabricants());
      produitT.setObservation(produits.get(i).getObservation());
      produitTS.add(i,produitT);
    }
    System.out.println(produitTS);
    return produitTS;

=======

  @GetMapping("/produits")
  public List<Produit> getAllProduits(){
    System.out.println(produitRepository.findAll());
    return produitRepository.findAll();
>>>>>>> 3f2a8eb534787e4fe7c0624be81fc66d6ea3fa76
  }
  @GetMapping("/produits/{id}")
  public ResponseEntity<Produit> getProduitById(@PathVariable(value = "id") Long ProduitId){
    Produit produit = produitRepository.findById(ProduitId)
      .orElseThrow(() -> new RessourceNotFoundException("Produit not found for this id :: " + ProduitId));
    return ResponseEntity.ok().body(produit);
  }
  @PostMapping("/produits")
<<<<<<< HEAD
  public void CreateProduit(@Valid @RequestBody Map<String,String> object) {
  Produit produit= new Produit();
  produit.setRef_piece(Long.parseLong(object.get("ref_piece")));
  produit.setPrix(object.get("prix"));
  produit.setObservation(object.get("observation"));
  produit.setConsomAnnee(object.get("consomAnnee"));
  produit.setDesignation(object.get("designation"));
  Famille famille= familleRepository.findByNom(object.get("familles"));
  Filiale filiale=filialeRepository.findByNom(object.get("filiales"));
  produit.setFamille(famille);
  produit.setFiliale(filiale);
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

=======
  public Produit CreateProduit(@Valid @RequestBody Produit produit) {
    return produitRepository.save(produit);
>>>>>>> 3f2a8eb534787e4fe7c0624be81fc66d6ea3fa76
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
<<<<<<< HEAD
  public ResponseEntity<Produit> updateProduit(@PathVariable Long id, @RequestBody Map<String,String>object) {
    Produit produit= produitRepository.findById(id).orElseThrow(() -> new RessourceNotFoundException("Produit not exist with id :" +id));
    produit.setRef_piece(Long.parseLong(object.get("ref_piece")));
    produit.setPrix(object.get("prix"));
    produit.setObservation(object.get("observation"));
    produit.setConsomAnnee(object.get("consomAnnee"));
    produit.setDesignation(object.get("designation"));
    Famille famille= familleRepository.findByNom(object.get("familles"));
    Filiale filiale=filialeRepository.findByNom(object.get("filiales"));
    produit.setFamille(famille);
    produit.setFiliale(filiale);
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
  }
}
=======
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
>>>>>>> 3f2a8eb534787e4fe7c0624be81fc66d6ea3fa76
