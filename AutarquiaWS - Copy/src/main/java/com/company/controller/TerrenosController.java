package com.company.controller;

import com.company.dto.*;
import com.company.service.FreguesiasService;
import com.company.service.TerrenosService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api")
public class TerrenosController {
    
    @RequestMapping(value = "/terrenos",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getAllTerrenos() {
        try {
            ListaTerrenoDTO listaTerrenoDTO = TerrenosService.getAllTerrenos();
            if (listaTerrenoDTO.getTerrenos().size() > 0) {
                return new ResponseEntity<>(listaTerrenoDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "freguesias/{nome}/terrenos",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getTerrenosFreguesiaByName(@PathVariable("nome") String name) {
        try {
            ListaTerrenoDTO listaTerrenoDTO = TerrenosService.getTerrenosByFreguesiaNome(name);
            if (listaTerrenoDTO.getTerrenos().size() > 0) {
                return new ResponseEntity<>(listaTerrenoDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "freguesias/{nome}/terrenos/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getTerreno(@PathVariable("nome") String name, @PathVariable("id") int numID) {
        try {
            Object terrenoDTO = TerrenosService.getTerreno(name, numID);
            if (terrenoDTO != null) {
                return new ResponseEntity<>(terrenoDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

   /* @RequestMapping(value = "freguesias/{nome}/terrenos/triangular/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getTerrenoRectangular(@PathVariable("name") String name, @PathVariable("id") int numID) {
        try {
            TerrenoRectangularDTO terrenoRectangularDTO = TerrenosService.getTerrenoRectangular(name, numID);
            if (terrenoRectangularDTO != null) {
                return new ResponseEntity<>(terrenoRectangularDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "freguesias/{nome}/terrenos/circular/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getTerrenoCircular(@PathVariable("name") String name, @PathVariable("id") int numID) {
        try {
            TerrenoCircularDTO terrenoCircularDTO = TerrenosService.getTerrenoCircular(name, numID);
            if (terrenoCircularDTO != null) {
                return new ResponseEntity<>(terrenoCircularDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "freguesias/{nome}/terrenos/triangular/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getTerrenoTriangular(@PathVariable("name") String name, @PathVariable("id") int numID) {
        try {
            TerrenoTriangularDTO terrenoTriangularDTO = TerrenosService.getTerrenoTriangular(name, numID);
            if (terrenoTriangularDTO != null) {
                return new ResponseEntity<>(terrenoTriangularDTO, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }*/

    @RequestMapping(value = "/freguesias/{nome}/terrenos/rectangular",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addPessoa(@RequestBody TerrenoRectangularDTO terrenoRectangularDTO,
                                            @PathVariable("nome") String nome) {
        try {
            TerrenosService.addTerrenoRectangular(nome, terrenoRectangularDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    /*
    @RequestMapping(value = "/freguesias/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> updateFreguesia(@PathVariable("id") String nome, @RequestBody FreguesiaDTO freguesiaDTO
    ) {
        try {
            FreguesiasService.updateFreguesia(nome,freguesiaDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
    
    @RequestMapping(value = "/freguesias/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> removeFreguesia(@PathVariable("id") String nome) {
        try {
            FreguesiasService.removeFreguesia(nome);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }*/

}
