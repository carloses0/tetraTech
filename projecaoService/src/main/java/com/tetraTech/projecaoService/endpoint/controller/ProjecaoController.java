package com.tetraTech.projecaoService.endpoint.controller;

import com.tetraTech.projecaoService.endpoint.services.ProjecaoServiceImpl;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import java.util.List;

@RestController
@RequestMapping("/projecao")
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProjecaoController {
    private final ProjecaoServiceImpl projecaoServiceImpl;

    @GetMapping(path = "/{dataFutura}")
    public ResponseEntity<String> projecaoInfoResponseEntity(@NonNull @PathVariable("dataFutura") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) String dataFutura) throws Exception {

        try {
            return new ResponseEntity<>(projecaoServiceImpl.getEstimatePopulation(dataFutura), HttpStatus.OK);
        } catch (HttpServerErrorException.InternalServerError e) {
            throw new RuntimeException("Fatal Iternal Error:" + e.getMessage());
        }

    }

    @GetMapping(path = "/log")
    public ResponseEntity<List<Object>> projecaoLogResponseEntity() throws Exception {

        try {
            return new ResponseEntity<>(projecaoServiceImpl.getListLogService(), HttpStatus.OK);
        } catch (HttpServerErrorException.InternalServerError e) {
            throw new RuntimeException("Fatal Iternal Error:" + e.getMessage());
        }

    }
}
