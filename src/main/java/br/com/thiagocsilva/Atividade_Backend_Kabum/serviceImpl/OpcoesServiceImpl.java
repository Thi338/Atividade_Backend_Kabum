package br.com.thiagocsilva.Atividade_Backend_Kabum.serviceImpl;

import br.com.thiagocsilva.Atividade_Backend_Kabum.models.OpcoesFrete;
import br.com.thiagocsilva.Atividade_Backend_Kabum.repositories.OpcoesFreteRepository;
import br.com.thiagocsilva.Atividade_Backend_Kabum.services.OpcoesFreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpcoesServiceImpl implements OpcoesFreteService {

    @Autowired
    private OpcoesFreteRepository repository;

    public OpcoesServiceImpl(OpcoesFreteRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<OpcoesFrete> findAll() {
        return this.repository.findAll();
    }
}
