package co.edu.uniandes.dse.parcialprueba.services;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.parcialprueba.entities.ConsultaMedicaEntity;
import co.edu.uniandes.dse.parcialprueba.entities.PacienteEntity;
import co.edu.uniandes.dse.parcialprueba.exceptions.EntityNotFoundException;
import co.edu.uniandes.dse.parcialprueba.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialprueba.repositories.ConsultaMedicaRepository;
import co.edu.uniandes.dse.parcialprueba.repositories.PacienteRepository;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class PacienteConsultaServices 
{

    @Autowired

    ConsultaMedicaRepository consultaMedicaRepository;

    @Autowired

    PacienteRepository pacienteRepository;

    @Transactional
    public PacienteEntity addConsulta(Long idPaciente, Long idConsulta) throws IllegalOperationException, EntityNotFoundException 
    {
        log.info("Inicia proceso de adición de consulta");
        Optional<PacienteEntity> pacienteEntity = pacienteRepository.findById(idPaciente);
        Optional<ConsultaMedicaEntity> consultaEntity = consultaMedicaRepository.findById(idConsulta);

        if (pacienteEntity.isEmpty())
			throw new EntityNotFoundException("Paciente no encontrado");

		if (consultaEntity.isEmpty())
			throw new EntityNotFoundException("Consulta no encontrada");

        Date date = new Date();
        
        if(consultaEntity.get().getFecha().equals(date))
        {
            throw new IllegalOperationException("La consulta ya esta asignada para esa fecha");
        }

        pacienteEntity.get().getConsultas().add(consultaEntity.get());
        log.info("Termina proceso de adición de consulta");
        return pacienteEntity.get();
    }


    


    @Transactional
	public List<ConsultaMedicaEntity> getConsultasProgramadas() {
		log.info("Inicia proceso de consultar todos los libros");
		return consultaMedicaRepository.findAll();
	}



}
