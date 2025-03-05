package co.edu.uniandes.dse.parcialprueba.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.parcialprueba.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialprueba.entities.PacienteEntity;
import co.edu.uniandes.dse.parcialprueba.repositories.PacienteRepository;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service

public class PacienteServices 
{

    @Autowired
    PacienteRepository pacienteRepository;


    @Transactional
    public PacienteEntity createPaciente(PacienteEntity paciente) throws IllegalOperationException 
    {
        log.info("Inicia proceso de creación de un paciente");
        log.info("termina proceso de creación de un paciente");
        return pacienteRepository.save(paciente);
    }

}
