package co.edu.uniandes.dse.parcialprueba.services;


import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.uniandes.dse.parcialprueba.exceptions.IllegalOperationException;
import co.edu.uniandes.dse.parcialprueba.entities.ConsultaMedicaEntity;
import co.edu.uniandes.dse.parcialprueba.repositories.ConsultaMedicaRepository;
import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service

public class ConsultaMedicaServices 
{

    @Autowired
    ConsultaMedicaRepository consultaMedicaRepository;


    @Transactional
    public ConsultaMedicaEntity createMedico(ConsultaMedicaEntity consulta) throws IllegalOperationException 
    {
        log.info("Inicia proceso de creación de una consulta medica");
        Calendar calendar = Calendar.getInstance();
		if(consulta.getFecha().compareTo(calendar.getTime()) < 0) {
			throw new IllegalOperationException("La fecha seleccionada es anterior a la fecha actual");
	    }
        return consultaMedicaRepository.save(consulta);
    }

}
