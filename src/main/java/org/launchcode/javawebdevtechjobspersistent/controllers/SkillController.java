package org.launchcode.javawebdevtechjobspersistent.controllers;

import org.launchcode.javawebdevtechjobspersistent.models.Employer;
import org.launchcode.javawebdevtechjobspersistent.models.data.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.Optional;

public class SkillController {

    @Autowired
    private SkillRepository skillRepository;

    @GetMapping("add")
    public String displayAddEmployerForm(Model model) {
        model.addAttribute("skill", "Skill");
        model.addAttribute(new Employer());
        model.addAttribute("skill", skillRepository.findAll());
        return "employers/add";
    }

    @PostMapping("add")
    public String processAddSkillForm(@ModelAttribute @Valid Employer newEmployer,
                                         Errors errors, Model model) {

        if (errors.hasErrors()) {
            model.addAttribute("skill", skillRepository.findAll());
            return "add";
        } else {
            return "redirect:";
        }
    }


    @GetMapping("view/{employerId}")
    public String displayViewSkill(Model model, @PathVariable int employerId) {

        Optional optEmployer = null;
        if (optEmployer.isPresent()) {
            Employer employer = (Employer) optEmployer.get();
            model.addAttribute("employer", employer);
            return "employers/view";
        } else {
            return "redirect:../";
        }
    }

    @GetMapping
    public String displayAllSkills(Model model) {
        model.addAttribute("title", "All Skills");
        model.addAttribute("employers", skillRepository.findAll());
        return "skills";
    }

}

