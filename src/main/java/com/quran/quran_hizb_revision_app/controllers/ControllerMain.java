package com.quran.quran_hizb_revision_app.controllers;


import com.quran.quran_hizb_revision_app.Entities.MasteryEnum;
import com.quran.quran_hizb_revision_app.Entities.Revision;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Date;

@RestController
@RequestMapping("/api/v1")
public class ControllerMain {

    @GetMapping("/all-quarters")
    public ResponseEntity<Revision> getAllTheQuarters(){

        Revision revision1 = new Revision(3, 45.2, MasteryEnum.Average, new Date(25), false);


        return new ResponseEntity<>(revision1, HttpStatus.OK);
    }


}
