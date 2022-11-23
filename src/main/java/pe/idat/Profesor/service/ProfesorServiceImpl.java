package pe.idat.Profesor.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.idat.Profesor.dto.ProfesorDTO;
import pe.idat.Profesor.model.Profesor;
import pe.idat.Profesor.repository.ProfesorRepository;

@Service
public class ProfesorServiceImpl implements ProfesorService {

	@Autowired
	private ProfesorRepository repository;

	@Override
	public List<ProfesorDTO> listar() {
		List<ProfesorDTO> listadto = new ArrayList<>();
		ProfesorDTO dto = null;

		for (Profesor profesor : repository.findAll()) {
			dto = new ProfesorDTO();
			dto.setApe(profesor.getApellido());
			dto.setNom(profesor.getNombre());
			dto.setDir(profesor.getDireccion());
			dto.setTel(profesor.getTelefono());
			dto.setCod(profesor.getIdProfesor());
			listadto.add(dto);
		}
		return listadto;
	}

	@Override
	public ProfesorDTO obtenerId(Integer id) {
		Profesor profesor = repository.findById(id).orElse(null);

		ProfesorDTO dto = new ProfesorDTO();
		dto.setApe(profesor.getApellido());
		dto.setNom(profesor.getNombre());
		dto.setDir(profesor.getDireccion());
		dto.setTel(profesor.getTelefono());
		dto.setCod(profesor.getIdProfesor());
		return dto;
	}

	@Override
	public void guardar(ProfesorDTO profesor) {
		Profesor pro = new Profesor();

		pro.setApellido(profesor.getApe());
		pro.setNombre(profesor.getNom());
		pro.setDireccion(profesor.getDir());
		pro.setTelefono(profesor.getTel());
		pro.setIdProfesor(profesor.getCod());

		repository.save(pro);

	}

	@Override
	public void eliminar(Integer id) {
		repository.deleteById(id);

	}

	@Override
	public void actualizar(ProfesorDTO profesor) {

		Profesor pro = new Profesor();

		pro.setApellido(profesor.getApe());
		pro.setNombre(profesor.getNom());
		pro.setDireccion(profesor.getDir());
		pro.setTelefono(profesor.getTel());
		pro.setIdProfesor(profesor.getCod());
		
		repository.saveAndFlush(pro);

	}

}
