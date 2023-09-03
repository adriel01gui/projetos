package com.java.backVendas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.backVendas.repositories.ItensVendaRepository;
import com.java.backVendas.repositories.VendaRepository;

@Service
public class VendaService {

    @Autowired
    private VendaRepository repository;

    @Autowired
    private ItensVendaRepository itensVendaRepository;
}
