package com.enexse.gestionagent.service;

import com.enexse.gestionagent.model.Agent;

import java.util.List;

public interface AgentService {
    public Agent addAgent(Agent agent);

    public List<Agent> findAll();

    public void delete(Long id);

    public Agent updateByName(Agent newAgent, String name);

}
