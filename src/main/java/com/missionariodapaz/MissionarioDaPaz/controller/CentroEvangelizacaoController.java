package com.missionariodapaz.MissionarioDaPaz.controller;

import com.missionariodapaz.MissionarioDaPaz.model.domain.CentroEvangelizacao;
import com.missionariodapaz.MissionarioDaPaz.model.dto.CentroEvangelizacaoDTO;
import com.missionariodapaz.MissionarioDaPaz.service.CentroEvangelizacaoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/centroEvangelizacao")
@Api(value = "Cadastro de Centros de Evangelização - Shalom.")
public class CentroEvangelizacaoController {

    @Autowired
    private CentroEvangelizacaoService centroEvangelizacaoService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ApiOperation(value = "Realiza a criação do CEV.")
    public CentroEvangelizacaoDTO create(@RequestBody final CentroEvangelizacaoDTO dto) {
        final CentroEvangelizacao cev = modelMapper.map(dto, CentroEvangelizacao.class);
        final CentroEvangelizacao cevSalvo = centroEvangelizacaoService.create(cev);
        return modelMapper.map(cevSalvo, CentroEvangelizacaoDTO.class);
    }

    @GetMapping
    @ApiOperation(value = "Realiza a listagem geral do CEV.")
    public List<CentroEvangelizacaoDTO> findAllCenter() {
        final List<CentroEvangelizacao> centers = centroEvangelizacaoService.findCenters();
        return centers.stream().map(center -> modelMapper.map(center, CentroEvangelizacaoDTO.class))
                .collect(Collectors.toList());
    }

    @PutMapping
    @ApiOperation(value = "Realiza a atualização(edição) do CEV.")
    public CentroEvangelizacaoDTO update(@RequestBody final CentroEvangelizacaoDTO dto) {
        final CentroEvangelizacao center = modelMapper.map(dto, CentroEvangelizacao.class);
        final CentroEvangelizacao centerUpdate = centroEvangelizacaoService.update(center);
        return modelMapper.map(centerUpdate, CentroEvangelizacaoDTO.class);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Deleta o CEV.")
    public void delete(@PathVariable final Long id) {
        centroEvangelizacaoService.delete(id);
    }
}
