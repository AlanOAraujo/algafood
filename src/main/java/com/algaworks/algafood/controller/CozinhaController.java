package com.algaworks.algafood.controller;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.infrastructure.service.CozinhaServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = {"/cozinha"})
@Api(value = "Cozinha", tags = {"Cozinha"})
@ApiResponses(value = {
        @ApiResponse(code = 500, message = "Erro da aplicação"),
        @ApiResponse(code = 401, message = "Não autorizado"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "Recurso não encontrado!")
})
public class CozinhaController {

    @Autowired
    private CozinhaServiceImpl service;

    @ApiOperation(value = "Busca todas as cozinhas",
            notes = "Apresenta todos os tipos de cozinhas cadastradas.",
            response = Cozinha.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operação realizada com sucesso"),
            @ApiResponse(code = 201, message = "A requisição foi bem sucedida e um novo recurso foi criado como resultado"),
            @ApiResponse(code = 401, message = "Não autorizado para visualizar"),
            @ApiResponse(code = 403, message = "Acessar o recurso que você estava tentando acessar é proibido"),
            @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado")
    })
    @GetMapping(value = "todos")
    public ResponseEntity<List<Cozinha>> buscaTodos(){
        return ResponseEntity.ok(service.findAll());
    }

    @ApiOperation(value = "Busca todas as cozinhas",
            notes = "Apresenta todos os tipos de cozinhas cadastradas.",
            response = Cozinha.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operação realizada com sucesso"),
            @ApiResponse(code = 201, message = "A requisição foi bem sucedida e um novo recurso foi criado como resultado"),
            @ApiResponse(code = 401, message = "Não autorizado para visualizar"),
            @ApiResponse(code = 403, message = "Acessar o recurso que você estava tentando acessar é proibido"),
            @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado")
    })
    @PostMapping(value = "salva")
    public ResponseEntity<Cozinha> save(String nomeCozinha){
        return ResponseEntity.ok(service.save(nomeCozinha));
    }

    @ApiOperation(value = "Busca todas as cozinhas",
            notes = "Apresenta todos os tipos de cozinhas cadastradas.",
            response = Cozinha.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operação realizada com sucesso"),
            @ApiResponse(code = 201, message = "A requisição foi bem sucedida e um novo recurso foi criado como resultado"),
            @ApiResponse(code = 401, message = "Não autorizado para visualizar"),
            @ApiResponse(code = 403, message = "Acessar o recurso que você estava tentando acessar é proibido"),
            @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado")
    })
    @GetMapping(value = "findById")
    public ResponseEntity<Cozinha> findById(Long idCozinha){
        return ResponseEntity.ok(service.findById(idCozinha));
    }

    @DeleteMapping(value = "delete")
    public void delete(Long idCozinha){
        service.delete(idCozinha);
    }
}
