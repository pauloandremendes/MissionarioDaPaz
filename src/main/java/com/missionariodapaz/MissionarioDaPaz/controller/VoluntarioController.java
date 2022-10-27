package com.missionariodapaz.MissionarioDaPaz.controller;

import com.missionariodapaz.MissionarioDaPaz.model.domain.CentroEvangelizacao;
import com.missionariodapaz.MissionarioDaPaz.model.domain.Voluntario;
import com.missionariodapaz.MissionarioDaPaz.model.dto.VoluntarioDTO;
import com.missionariodapaz.MissionarioDaPaz.service.VoluntarioService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(path = "/voluntario")
@Api(value = "Gerenciamento de voluntários - Shalom.")
public class VoluntarioController {

    @Autowired
    private VoluntarioService voluntarioService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ApiOperation(value = "Realiza a criação do CEV.")
    public VoluntarioDTO create(@RequestBody final VoluntarioDTO dto) {
        final Voluntario voluntario = modelMapper.map(dto, Voluntario.class);
        final Voluntario voluntarioSalvo = voluntarioService.create(voluntario);
        return modelMapper.map(voluntarioSalvo, VoluntarioDTO.class);
    }

    @GetMapping
    @ApiOperation(value = "Realiza a listagem geral do CEV.")
    public List<VoluntarioDTO> findAllVoluntarios() {
        final List<Voluntario> voluntarioList = voluntarioService.findCenters();
        return voluntarioList.stream().map(voluntario -> modelMapper.map(voluntario, VoluntarioDTO.class))
                .collect(Collectors.toList());
    }

    @PutMapping
    @ApiOperation(value = "Realiza a atualização(edição) do CEV.")
    public VoluntarioDTO update(@RequestBody final VoluntarioDTO dto) {
        final Voluntario voluntario = modelMapper.map(dto, Voluntario.class);
        final Voluntario voluntarioAtualizado = voluntarioService.update(voluntario);
        return modelMapper.map(voluntarioAtualizado, VoluntarioDTO.class);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Deleta o CEV.")
    public void delete(@PathVariable final Long id) {
        voluntarioService.delete(id);
    }
}
