package pe.idat.Profesor.service;

import java.util.List;

import pe.idat.Profesor.dto.ProfesorDTO;

public interface ProfesorService {

	List<ProfesorDTO> listar();
	ProfesorDTO obtenerId(Integer id);
	void guardar (ProfesorDTO profesor);
	void eliminar(Integer id);
	void actualizar(ProfesorDTO profesor);
	
}
