package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Produit;

@RestController
@RequestMapping("/api/produit")
public class ProduitController extends CrudController<Produit, Long> {
	
}
