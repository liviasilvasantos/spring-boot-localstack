package br.com.liviasilvasantos.ssm.controller;

import br.com.liviasilvasantos.ssm.configuration.ParameterStoreConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class ParameterStoreController {

    private final ParameterStoreConfiguration parameterStoreConfiguration;

    @GetMapping("/parameterStoreConfiguration")
    public String configuration(){
        return parameterStoreConfiguration.getHelloWorld();
    }
}
