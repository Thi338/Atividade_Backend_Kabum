package br.com.thiagocsilva.Atividade_Backend_Kabum.services;

import br.com.thiagocsilva.Atividade_Backend_Kabum.models.OpcoesFrete;
import br.com.thiagocsilva.Atividade_Backend_Kabum.repositories.OpcoesFreteRepository;
import br.com.thiagocsilva.Atividade_Backend_Kabum.serviceImpl.OpcoesFreteServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpcoesFreteService implements OpcoesFreteServiceImpl {

    @Autowired
    private OpcoesFreteRepository repository;
    @Override
    public List<OpcoesFrete> findAll() {
        return repository.findAll();
    }
}
