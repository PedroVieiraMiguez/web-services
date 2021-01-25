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

    @RequestMapping(value = "/freguesias/{nome}/terrenos/{numid}/proprietarios",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> getProprietarios(@PathVariable("nome") String name,
                                                   @PathVariable("numid") int numID) {
        try {
            ListaPessoaDTO listaProprietarios = TerrenosService.getProprietarios(name, numID);
            if (listaProprietarios.getPessoas().size() > 0) {
                return new ResponseEntity<>(listaProprietarios, HttpStatus.OK);
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

    @RequestMapping(value = "/freguesias/{nome}/terrenos/{numid}/proprietarios",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addProprietario(@RequestBody ListaNIFsDTO listaNIFsDTO,
                                                  @PathVariable("nome") String nome,
                                                  @PathVariable("numid") int numID) {
        try {
            ListaPessoaDTO listaProprietarios = TerrenosService.addProprietario(nome, numID, listaNIFsDTO);
            return new ResponseEntity<>(listaProprietarios, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/freguesias/{nome}/terrenos/rectangular",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addTerrenoRectangular(@RequestBody TerrenoRectangularDTO terrenoRectangularDTO,
                                            @PathVariable("nome") String nome) {
        try {
            TerrenosService.addTerrenoRectangular(nome, terrenoRectangularDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/freguesias/{nome}/terrenos/circular",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addTerrenoCircular(@RequestBody TerrenoCircularDTO terrenoCircularDTO,
                                                        @PathVariable("nome") String nome) {
        try {
            TerrenosService.addTerrenoCircular(nome, terrenoCircularDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/freguesias/{nome}/terrenos/triangular",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> addTerrenoTriangular(@RequestBody TerrenoTriangularDTO terrenoTriangularDTO,
                                                     @PathVariable("nome") String nome) {
        try {
            TerrenosService.addTerrenoTriangular(nome, terrenoTriangularDTO);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/freguesias/{nome}/terrenos/rectangular/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> updateTerrenoRectangular(@PathVariable("nome") String nome, @PathVariable("id") int numID,
                                                  @RequestBody TerrenoRectangularDTO terrenoRectangularDTO
    ) {
        try {
            TerrenosService.updateTerrenoRectangular(nome, numID, terrenoRectangularDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/freguesias/{nome}/terrenos/circular/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> updateTerrenoCircular(@PathVariable("nome") String nome, @PathVariable("id") int numID,
                                                  @RequestBody TerrenoCircularDTO terrenoCircularDTO
    ) {
        try {
            TerrenosService.updateTerrenoCircular(nome, numID, terrenoCircularDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

    @RequestMapping(value = "/freguesias/{nome}/terrenos/triangulo/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_XML_VALUE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> updateTerrenoTriangular(@PathVariable("nome") String nome, @PathVariable("id") int numID,
                                                        @RequestBody TerrenoTriangularDTO terrenoTriangularDTO
    ) {
        try {
            TerrenosService.updateTerrenoTriangular(nome, numID, terrenoTriangularDTO);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }
    
    @RequestMapping(value = "/freguesias/{nome}/terrenos/{id}",
            method = RequestMethod.DELETE,
            produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Object> removeFreguesia(@PathVariable("nome") String nome, @PathVariable("id") int numID) {
        try {
            TerrenosService.removeTerreno(nome, numID);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ErroDTO(e), HttpStatus.CONFLICT);
        }
    }

}
