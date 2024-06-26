package com.mart.address.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mart.address.entity.Address;
import com.mart.address.service.AddressService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/addrs")
public class AddressController {
	@Autowired
	private AddressService addressService;
	
	@PostMapping("/add")
	public ResponseEntity<Object> add(@RequestHeader("Authorization") String jwt, @RequestBody Address address){
		try {
			
			return new ResponseEntity<Object>(addressService.add(jwt, address), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<Object> getAll(@RequestHeader("Authorization") String jwt){
		try {
			return new ResponseEntity<Object>(addressService.getAll(jwt), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Object> getById(@RequestHeader("Authorization") String jwt, @PathVariable Long id){
		try {
			return new ResponseEntity<Object>(addressService.getById(jwt,id), HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Object> deleteById(@RequestHeader("Authorization") String jwt, @PathVariable Long id){
		try {
			addressService.deleteById(id);
			return new ResponseEntity<Object>("address successfully deleted", HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
	
	@PutMapping("/update/{id}")
	public ResponseEntity<Object> updateById(@RequestHeader("Authorization") String jwt, @PathVariable Long id, @RequestBody Address address){
		try {
			addressService.updateById(id,address);
			return new ResponseEntity<Object>("address successfully updated", HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
