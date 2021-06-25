package ar.com.ada.api.empleadas.servicies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.ada.api.empleadas.entities.Categoria;
import ar.com.ada.api.empleadas.repos.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    CategoriaRepository repo;

    public void crearCategoria(Categoria categoria){
        repo.save(categoria);
    }
    public List<Categoria> traerCategorias(){
        return repo.findAll();
    }

    public Categoria busCategoriaId(Integer categoriaId){

        Optional <Categoria> resultado = repo.findById(categoriaId);
        Categoria categoria =null;
        if(resultado.isPresent())
            categoria = resultado.get();

        return categoria;
    }

}
