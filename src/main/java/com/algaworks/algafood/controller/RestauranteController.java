package com.algaworks.algafood.controller;

import com.algaworks.algafood.model.Cozinha;
import com.algaworks.algafood.model.Restaurante;
import com.algaworks.algafood.service.IRestauranteService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/restaurante")
@CrossOrigin
@Api(value = "Restaurante", tags = {"Restaurante"})
@ApiResponses(value = {
        @ApiResponse(code = 500, message = "Erro da aplicação"),
        @ApiResponse(code = 401, message = "Não autorizado"),
        @ApiResponse(code = 403, message = "Accessing the resource you were trying to reach is forbidden"),
        @ApiResponse(code = 404, message = "Recurso não encontrado!")
})
public class RestauranteController {

    @Autowired
    private IRestauranteService service;

    @ApiOperation(value = "Busca todas os Restaurantes",
            notes = "Apresenta todos os restaurantes cadastrados.",
            response = Cozinha.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Operação realizada com sucesso"),
            @ApiResponse(code = 201, message = "A requisição foi bem sucedida e um novo recurso foi criado como resultado"),
            @ApiResponse(code = 401, message = "Não autorizado para visualizar"),
            @ApiResponse(code = 403, message = "Acessar o recurso que você estava tentando acessar é proibido"),
            @ApiResponse(code = 404, message = "O recurso que você estava tentando acessar não foi encontrado")
    })
    @GetMapping(value = "todos")
    public ResponseEntity<List<Restaurante>> buscaTodos(){
        return ResponseEntity.ok(service.findAll());
    }

}
