package co.edu.uniandes.dse.parcialprueba.entities;
import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;



@Data
@Entity
public class ConsultaMedicaEntity extends BaseEntity
{

    private String causa;    
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;

    @ManyToOne
    private List<PacienteEntity> pacientes;

    @OneToMany
    private PacienteEntity paciente;
    
}