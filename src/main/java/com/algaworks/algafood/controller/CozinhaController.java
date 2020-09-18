package com.algaworks.algafood.controller;

import com.algaworks.algafood.domain.model.Cozinha;
import com.algaworks.algafood.infrastructure.service.CozinhaServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = {CozinhaController.URL})
@Api(value = "Cozinha", tags = {"Cozinha"})
public class CozinhaController {

    private static final Logger logger = LoggerFactory.getLogger(CozinhaController.class);

    public static final String URL = "/cozinha";

    @Autowired
    private CozinhaServiceImpl service;

    @ApiOperation(value = "Busca todas as cozinhas", response = Cozinha.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operação realizada com sucesso"),
            @ApiResponse(code = 201, message = "A requisição foi bem sucedida e um novo recurso foi criado como resultado"),
            @ApiResponse(code = 401, message = "Não autorizado para visualizar"),
            @ApiResponse(code = 403, message = "Acessar o recurso que você estava tentando acessar é proibido"),
            @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado")
    })
    @GetMapping(value = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Cozinha>> buscaTodos(){
        logger.debug("Buscando todas as cozinha");
        return ResponseEntity.ok(service.findAll());
    }

    @ApiOperation(value = "Busca cozinha por id", response = Cozinha.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operação realizada com sucesso"),
            @ApiResponse(code = 201, message = "A requisição foi bem sucedida e um novo recurso foi criado como resultado"),
            @ApiResponse(code = 401, message = "Não autorizado para visualizar"),
            @ApiResponse(code = 403, message = "Acessar o recurso que você estava tentando acessar é proibido"),
            @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado")
    })
    @GetMapping(value = "/findById/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cozinha> findById(@PathVariable(value = "id") Long idCozinha){
        logger.debug("Buscando cozinha por ID");
        return ResponseEntity.ok(service.findById(idCozinha));
    }

    @ApiOperation(value = "Persiste Cozinha", response = Cozinha.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operação realizada com sucesso"),
            @ApiResponse(code = 201, message = "A requisição foi bem sucedida e um novo recurso foi criado como resultado"),
            @ApiResponse(code = 401, message = "Não autorizado para visualizar"),
            @ApiResponse(code = 403, message = "Acessar o recurso que você estava tentando acessar é proibido"),
            @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado")
    })
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cozinha> save(@RequestBody Cozinha cozinha){
        logger.debug("Salvando cozinha");
        return ResponseEntity.ok(service.save(cozinha));
    }

    @ApiOperation(value = "Deleta Cozinha", response = Cozinha.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operação realizada com sucesso"),
            @ApiResponse(code = 204, message = "Não há conteúdo para enviar para esta solicitação"),
            @ApiResponse(code = 401, message = "Não autorizado para visualizar"),
            @ApiResponse(code = 403, message = "Acessar o recurso que você estava tentando acessar é proibido"),
    })
    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Cozinha> delete(@PathVariable(value = "id") Long idCozinha){
        logger.debug("Deletando cozinha");
        service.delete(idCozinha);
        return ResponseEntity.noContent().build();
    }
}
