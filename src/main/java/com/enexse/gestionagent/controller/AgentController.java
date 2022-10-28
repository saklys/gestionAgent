package com.enexse.gestionagent.controller;

import com.enexse.gestionagent.model.Agent;
import com.enexse.gestionagent.repository.AgentRepository;
import com.enexse.gestionagent.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping(value= "/api/v1")
public class AgentController {

    @Autowired
    private AgentService agentService;

    @PostMapping("/agent")
    public ResponseEntity<Agent> addAgent(@RequestBody Agent agent){
        return new ResponseEntity<>(agentService.addAgent(agent), HttpStatus.CREATED);
    }

    @GetMapping("/agents")
    public ResponseEntity<List<Agent>> getAllAgents(){
        return new ResponseEntity<>(agentService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/statuscount")
    public ResponseEntity<List<Integer>> countAgentsByStatus() {
        return new ResponseEntity<>(agentService.countAgentsByStatus(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAgent(@PathVariable(value = "id") Long id){
        agentService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{name}")
    public ResponseEntity updateAgent(@RequestBody Agent newAgent, @PathVariable String name) {
        return new ResponseEntity<>(agentService.updateByName(newAgent,name), HttpStatus.OK);

    }
}

