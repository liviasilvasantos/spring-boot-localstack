package br.com.liviasilvasantos.secretsmanager.controller;

import br.com.liviasilvasantos.secretsmanager.configuration.SecretsManagerConfiguration;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class SecretsManagerController {

    private final SecretsManagerConfiguration secretsManagerConfiguration;

    @GetMapping("/secretsManagerConfiguration")
    public String configuration(){
        return "%s - %s - %s".formatted(secretsManagerConfiguration.getValor1(),
                secretsManagerConfiguration.getValor2(), secretsManagerConfiguration.getValor3());
    }
}
