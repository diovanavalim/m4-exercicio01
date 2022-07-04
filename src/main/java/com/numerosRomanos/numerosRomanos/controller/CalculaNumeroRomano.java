package com.numerosRomanos.numerosRomanos.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculaNumeroRomano")
public class CalculaNumeroRomano {

    @GetMapping("/{numero}")
    public ResponseEntity<String> calculaNumeroRomano(@PathVariable int numero) {
        if (numero == 0) {
            return new ResponseEntity("Zero não pode ser convertido!", HttpStatus.BAD_REQUEST);
        }

        int[] vNumeros = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] vRomanos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        String resposta = "";
        int i = 0;

        while (numero > 0) {
            if (numero >= vNumeros[i]) {
                resposta += vRomanos[i];
                numero -= vNumeros[i];
            } else {
                i++;
            }
        }

        return new ResponseEntity(String.format("Número Convertido: %s", resposta), HttpStatus.OK);
    }
}
