package com.enexse.gestionagent.repository;

import com.enexse.gestionagent.model.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgentRepository extends JpaRepository<Agent,Long> {
    Optional<Agent> findAgentByName(String name);
    void deleteAgentById(Long id);

    int countAgentsByStatus(String status);
}
