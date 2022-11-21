package com.missionariodapaz.MissionarioDaPaz.controller;

import com.missionariodapaz.MissionarioDaPaz.model.domain.NovoMembro;
import com.missionariodapaz.MissionarioDaPaz.model.dto.NovoMembroDTO;
import com.missionariodapaz.MissionarioDaPaz.service.NovoMembroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping(path = "/novoMembro")
@Api(value = "Cadastro de Novos membros - Shalom.")
public class NovoMembroController implements Serializable {

    @Autowired
    private NovoMembroService novoMembroService;

    @Autowired
    private ModelMapper modelMapper;

    @PostMapping
    @ApiOperation(value = "Realiza a criação.")
    public NovoMembroDTO create(@RequestBody final NovoMembroDTO dto) {
        final NovoMembro novoMembro = modelMapper.map(dto, NovoMembro.class);
        final NovoMembro novoMembroSalvo = novoMembroService.create(novoMembro);
        return modelMapper.map(novoMembroSalvo, NovoMembroDTO.class);
    }

    @GetMapping
    @ApiOperation(value = "Realiza a listagem geral.")
    public List<NovoMembroDTO> findAllVoluntarios() {
        final List<NovoMembro> novoMembros = novoMembroService.findCenters();
        return novoMembros.stream().map(novoMembro -> modelMapper.map(novoMembro, NovoMembroDTO.class))
                .collect(Collectors.toList());
    }

    @PutMapping
    @ApiOperation(value = "Realiza a atualização(edição).")
    public NovoMembroDTO update(@RequestBody final NovoMembroDTO dto) {
        final NovoMembro novoMembro = modelMapper.map(dto, NovoMembro.class);
        final NovoMembro novoMembroAtualizado = novoMembroService.update(novoMembro);
        return modelMapper.map(novoMembroAtualizado, NovoMembroDTO.class);
    }

    @DeleteMapping(path = "/{id}")
    @ApiOperation(value = "Deleta o CEV.")
    public void delete(@PathVariable final Long id) {
        novoMembroService.delete(id);
    }
}
