package edu.pe.idat.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import edu.pe.idat.entity.Curso;
/*
 * Las clases con la anotación Repository son detectadas automáticamente 
 * por Spring Framework a través del escaneo de classpath.*/
@Repository
public interface CursoRepository extends CrudRepository<Curso, String> {
	/*
	 * El patrón repositorio consiste en separar la lógica 
	 * que recupera los datos y los asigna a un modelo de entidad 
	 * de la lógica de negocios que actúa sobre el modelo, 
	 * esto permite que la lógica de negocios sea independiente del tipo de 
	 * dato que comprende la capa de origen de datos*/
	
	@Query(value = "{call dbo.sp_ListarCursos()}", nativeQuery = true)
	public List<Curso> listarCursos();
	
	
	@Query(value = "{call dbo.sp_ObtenerCursoxId(:idcurso)}", nativeQuery = true)
	public Curso obtenerCursoxId(
			@Param("idcurso")String idCurso
			);
	/*
	 * @Transactional= Permite controlar un conjunto de instrucciones que se puedan 
	 * ejecutar en la base de datos.
	 * @Modifying=La anotación @Modifying se utiliza para mejorar la anotación 
	 * @Query para ejecutar no solo las consultas SELECT, sino también las consultas INSERT, UPDATE, DELETE e incluso DDL
	 * */
	
	@Transactional
	@Modifying
    @Query(value = "{call dbo.sp_RegistrarCurso(:nomcurso, :credito)}", nativeQuery = true)
    void registrarCurso(
            @Param("nomcurso")String nomCurso,
            @Param("credito")Integer credito
            );
		
	@Transactional
	@Modifying
	@Query(value = "{call dbo.sp_ActualizarCurso(:idcurso, :nomcurso, :credito)}", nativeQuery = true)
	public void actualizarCurso(
			@Param("idcurso")String idCurso,
			@Param("nomcurso")String nomCurso,
            @Param("credito")Integer credito
			);
	

}
