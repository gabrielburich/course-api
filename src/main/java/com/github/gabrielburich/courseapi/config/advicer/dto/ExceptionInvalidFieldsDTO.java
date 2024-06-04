package com.github.gabrielburich.courseapi.config.advicer.dto;

import java.util.List;

public record ExceptionInvalidFieldsDTO(int status, List<ExceptionFieldDTO> fields){}
