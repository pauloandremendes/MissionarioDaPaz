package com.missionariodapaz.MissionarioDaPaz.controller;

import com.missionariodapaz.MissionarioDaPaz.service.UserService;
import io.swagger.annotations.Api;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/voluntario")
@Api(value = "Gerenciamento de voluntários - Shalom.")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private ModelMapper modelMapper;


}
