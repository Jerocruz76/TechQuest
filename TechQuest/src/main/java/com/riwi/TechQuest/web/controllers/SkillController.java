package com.riwi.TechQuest.web.controllers;

import com.riwi.TechQuest.application.dto.request.SkillRequest;
import com.riwi.TechQuest.application.dto.response.SkillResponse;
import com.riwi.TechQuest.application.services.Impl.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/skills")
public class SkillController {

    @Autowired
    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping("/create")
    public ResponseEntity<SkillResponse> create(@RequestBody SkillRequest skillRequest){
        SkillResponse skill = skillService.create(skillRequest);
        return new ResponseEntity<>(skill, HttpStatus.CREATED);
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<SkillResponse> findByName(@PathVariable String name){
        SkillResponse skill = skillService.getByName(name);
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

    @PatchMapping("/update/{id}")
    public ResponseEntity<SkillRequest> update(@PathVariable Long id, @RequestBody SkillRequest skillRequest){
        SkillRequest skill = skillService.update(id, skillRequest);
        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable Long id){
        skillService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
