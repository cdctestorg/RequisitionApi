package com.cdc.requisitionapi.controller;

import com.cdc.requisitionapi.repository.RequisitionRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
public class RequisitionController {

    private final RequisitionRepository requisitionRepository;

    public RequisitionController(RequisitionRepository requisitionRepository) {
        this.requisitionRepository = requisitionRepository;
    }

    @GetMapping(value = "/requisition", produces = MediaType.APPLICATION_JSON_VALUE)
    public Iterable<com.cdc.requisitionapi.entity.Requisition> getRequisitions() {
        return requisitionRepository.findAll();
    }

    @GetMapping(value = "/requisition/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public com.cdc.requisitionapi.entity.Requisition getRequisition(@PathVariable long id) {
        return requisitionRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid requisition id %s", id)));
    }

    @PostMapping(value = "/requisition", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public com.cdc.requisitionapi.entity.Requisition createRequisition(@Valid @RequestBody com.cdc.requisitionapi.entity.Requisition requisition) {
        return requisitionRepository.save(requisition);

    }
}
