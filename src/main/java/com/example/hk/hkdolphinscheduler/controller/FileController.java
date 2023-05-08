package com.example.hk.hkdolphinscheduler.controller;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hk.hkdolphinscheduler.estate.EState;
import com.example.hk.hkdolphinscheduler.estate.StateManager;
import com.example.hk.hkdolphinscheduler.repository.FileRepository;

@RestController
@RequestMapping("/api/v1/")
public class FileController {

    @Autowired
    public FileRepository file;
    
    @Autowired
    public StateManager state;

    @PersistenceContext
    private EntityManager entityManager;
    
    @GetMapping("/state")
    public ResponseEntity<?> state(@RequestParam String key) {
    	if(key.equals("idle")) {
    		state.idle();
    		return ResponseEntity.ok().body("STATE CHANGE TO" + state.toString());
    	}
    	if(key.equals("read")) {
    		state.read();
    		return ResponseEntity.ok().body("STATE CHANGE TO" + state.toString());
    	} else {
    		return ResponseEntity.badRequest().body("CANNOT CHANGE THE PROCESS");
    	}
    }
    
    @GetMapping("/find/name")
    public String name(@RequestParam String key) {
    	if(state.getState().equals(EState.HK_STATE_IDLE)){
    		return "The state is currently: " + state.toString() + ", unable to process.";
    	} 
    	if(state.getState().equals(EState.HK_STATE_READ)) {
    		return file.findByName(key).toString();
    	}
    	else {
    		return "ERROR, CANNOT PROCESS";
    	}
    }

    @GetMapping("/find/status")
    public String status(@RequestParam String key) {
        return file.findByStatus(key).toString();
    }
    
    @GetMapping("/find/test")
    public ResponseEntity<?> t1(@RequestParam String key) {
    	return ResponseEntity.ok().body(file.findByStatus(key));
    }
    
    /*   @GetMapping("/find/id")
    public String id(@RequestParam long key) {
        return file.findById(key).toString();
    } 

    @Transactional
    @GetMapping("/find/name")
    public String name(@RequestParam String key) {
        entityManager.createNativeQuery("UPDATE hkfile SET status='read' WHERE name=?;")
                .setParameter(1, key)
                .executeUpdate();
        return file.findByName(key).toString();
    } */    
}
