package com.example.demo.Controller;

import com.example.demo.Model.Fabricant;
import com.example.demo.Repository.FabricantRepository;
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
public class FabricantController {
  @Autowired
  private FabricantRepository fabricantRepository;

  @GetMapping("/fabricants")
  public List<Fabricant> getAllFabricant(){
    System.out.println(fabricantRepository.findAll());
    return fabricantRepository.findAll();
  }
  @GetMapping("/fabricants/{id}")
  public ResponseEntity<Fabricant> getFabricantById(@PathVariable(value = "id") Long FabricantId){
    Fabricant fabricant = fabricantRepository.findById(FabricantId)
      .orElseThrow(() -> new RessourceNotFoundException("Fabricant not found for this id :: " + FabricantId));
    return ResponseEntity.ok().body(fabricant);
  }
  @PostMapping("/fabricants")
  public Fabricant CreateFabricant(@Valid @RequestBody Fabricant fabricant) {
    System.out.println(fabricant);
    return fabricantRepository.save(fabricant);
  }


  @DeleteMapping("/fabricants/{id}")
  public Map<String, Boolean> DeleteFabricant(@PathVariable(value = "id") Long FabricantId)
    throws RessourceNotFoundException {
    Fabricant fabricant = fabricantRepository.findById(FabricantId)
      .orElseThrow(() -> new RessourceNotFoundException("Fabricant not found  id :: " + FabricantId));

    fabricantRepository.delete(fabricant);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }


  @DeleteMapping("/fabricants/delete")
  public ResponseEntity<String> deleteAllFabricants() {

    fabricantRepository.deleteAll();

    return new ResponseEntity<>("All Fabricants have been deleted!", HttpStatus.OK);
  }



  @PutMapping("/fabricants/{id}")
  public ResponseEntity<Fabricant> updateFabricant(@PathVariable("id") long id, @RequestBody Fabricant fabricant) {


    Optional<Fabricant> fabricantInfo = fabricantRepository.findById(id);

    if (fabricantInfo.isPresent()) {
      Fabricant fabricant1 = fabricantInfo.get();
      fabricant1.setNom_fab(fabricant.getNom_fab());
      fabricant1.setType_fab(fabricant.getType_fab());

      return new ResponseEntity<>(fabricantRepository.save(fabricant1), HttpStatus.OK);
    } else {
      return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
  }

}
