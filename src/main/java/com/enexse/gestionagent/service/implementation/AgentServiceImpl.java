package com.enexse.gestionagent.service.implementation;

import com.enexse.gestionagent.model.Agent;
import com.enexse.gestionagent.repository.AgentRepository;
import com.enexse.gestionagent.service.AgentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class AgentServiceImpl implements AgentService {
    @Autowired
    private AgentRepository agentRepository;

    @Override
    public Agent addAgent(Agent agent) {
        return agentRepository.save(agent);
    }

    @Override
    public List<Agent> findAll() {
        return agentRepository.findAll();
    }

    @Transactional
    @Override
    public void delete(Long id) {
        agentRepository.deleteAgentById(id);
    }

    @Override
    public Agent updateByName(Agent newAgent, String name) {
        return agentRepository.findAgentByName(name)
                .map(agent -> {
                    agent.setOs(newAgent.getOs());
                    agent.setDateAdd(newAgent.getDateAdd());
                    agent.setIp(newAgent.getIp());
                    agent.setName(newAgent.getName());
                    agent.setLastKeepAlive(newAgent.getLastKeepAlive());
                    agent.setStatus(newAgent.getStatus());
                    agent.setVersion(newAgent.getVersion());
                    return agentRepository.save(agent);
                })
                .orElseGet(() -> {
                    newAgent.setName(name);
                    return agentRepository.save(newAgent);
                });
    }

    @Override
    public List<Integer> countAgentsByStatus() {
        List<Integer> counts = new ArrayList<>();
        Integer active = agentRepository.countAgentsByStatus("active");
        Integer disconnected = agentRepository.countAgentsByStatus("disconnected");
        Integer pending = agentRepository.countAgentsByStatus("pending");
        Integer never_connected = agentRepository.countAgentsByStatus("never_connected");
        counts.add(active);
        counts.add(disconnected);
        counts.add(pending);
        counts.add(never_connected);
        return counts;
    }


}
