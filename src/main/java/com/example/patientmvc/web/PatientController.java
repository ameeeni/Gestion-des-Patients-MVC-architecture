package com.example.patientmvc.web;

import com.example.patientmvc.entities.Patient;
import com.example.patientmvc.repositories.PatientRepository;
import lombok.AllArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class PatientController {
    private PatientRepository patientRepository;

    @GetMapping(path="/index")
public String patients(Model model ,
                       @RequestParam( name ="page" , defaultValue = "0") int page ,
                       @RequestParam( name ="size" , defaultValue = "5") int size ,
                       @RequestParam(name="keyword" , defaultValue = "") String keyword)
    {
        Page<Patient> pagePatients = patientRepository.findByNomContains(keyword,PageRequest.of(page,size)); //ici je vais recupérer une page des patients
        //je vais aller à la base de données pour chercher la liste des patients
        model.addAttribute("listPatients",pagePatients.getContent());
        ///le model ici contient la liste des patients qu'on afficher dans le View
        model.addAttribute("pages" , new int[pagePatients.getTotalPages()]);
        //Ici on trouve dans le tableau le nombre totale des des pages.
        model.addAttribute("currentPage", page);
        model.addAttribute("keyword", keyword);
        //je garde le lien sur le keyword Actuel
        return "patients";
    }
    @GetMapping("/delete")
    public String delete(Long id , String keyword , int page){
        patientRepository.deleteById(id);
        return "redirect:/index?page" + page + "&keyword" +keyword; /*il va faire une redirection vers l'index avec la page courante et le keyword */
}
}