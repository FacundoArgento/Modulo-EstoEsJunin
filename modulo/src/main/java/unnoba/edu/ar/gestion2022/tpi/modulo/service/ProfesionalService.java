package unnoba.edu.ar.gestion2022.tpi.modulo.service;

import org.springframework.stereotype.Service;

import unnoba.edu.ar.gestion2022.tpi.modulo.model.Profesional;
import unnoba.edu.ar.gestion2022.tpi.modulo.repository.ProfesionalRepository;

@Service
public class ProfesionalService implements ProfesionalServiceImp {
    
    private ProfesionalRepository profesionalRepository;

    @Override
	public Profesional findProfesionalById(long id) {
		return profesionalRepository.findProfesionalById(id);
	}

	
}
