package pe.com.citasmedicas.dao;

import java.util.ArrayList;
import java.util.List;
import pe.com.citasmedicas.model.CargaData;
import pe.com.citasmedicas.model.Especialidad;
import pe.com.citasmedicas.model.Medico;

/**
 *
 * @author dew - Grupo 04
 */
public class MedicoDao {

    /**
     * Obtiene un médico por su id
     * @param Integer medicoId
     * @return Medico
     */
    public Medico getMedicoPorId(Integer medicoId) {
        if (medicoId == null) {
            return null;
        }
        Medico medico = null;
        for (Medico medicoAux : CargaData.MEDICOS) {
            if (medicoAux.getPersonaId().intValue() == medicoId.intValue()) {
                medico = medicoAux;
                break;
            }
        }
        return medico;
    }

    /**
     * Obtiene todas los médicos de una especialidad específica
     * @param Especialidad especialidad
     * @return List<Medico>
     */
    public List<Medico> getMedicosPorEspecialidad(Especialidad especialidad) {
        if(especialidad == null){
            return new ArrayList<Medico>();
        }
        List<Medico> medicos = new ArrayList<Medico>();
        for(Medico medicoAux : CargaData.MEDICOS){
            for(Especialidad especialidadAux : medicoAux.getEspecialidades()){
                if(especialidadAux.equals(especialidad)){
                    medicos.add(medicoAux);
                    break;
                }
            }
        }
        return medicos;
    }
}
