package com.tetraTech.projecaoService.endpoint.services;

import com.tetraTech.projecaoService.core.model.ProjecaoInfo;
import com.tetraTech.projecaoService.core.model.ProjecaoResult;
import com.tetraTech.projecaoService.repository.ProjecaoRepository;
import com.tetraTech.projecaoService.util.Util;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


@Service
@Slf4j
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ProjecaoServiceImpl extends Util {


    private final ProjecaoRepository projecaoRepository;


    private static final String URL_API_INFO_PROJECAO = "https://servicodados.ibge.gov.br/api/v1/projecoes/populacao";



    public List<Object> getListLogService() throws IOException {
        List<Object> listObj = new ArrayList<Object>();

        return projecaoRepository.getObject();
    }


    public String getEstimatePopulation(String futureDate) throws Exception {
        ProjecaoInfo projecaoInfo = getInfoApiProjecao();
        if (projecaoInfo == null) {
            return null;
        }
        return estimateProcess(projecaoInfo, futureDate);
    }

    private ProjecaoInfo getInfoApiProjecao() throws Exception {
       RestTemplate rest = new RestTemplate();
        try {
            ResponseEntity<ProjecaoInfo> projecaoInfo = rest.getForEntity(URL_API_INFO_PROJECAO, ProjecaoInfo.class);
            return projecaoInfo.getBody();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    private String estimateProcess(ProjecaoInfo projecaoInfo, String dataFutura) throws ParseException {
        try {
            Calendar futureDateFormat = stringToCalendar(dataFutura);
            Calendar currentDate = Calendar.getInstance();
            Long currentPopulation = projecaoInfo.getProjecao().getPopulacao();
            Integer projectionPeriodLessCurrent = futureDateFormat.get(Calendar.YEAR) - currentDate.get(Calendar.YEAR);

            Long result = currentPopulation + projecaoInfo.getProjecao().getPeriodoMedio().getIncrementoPopulacional() * projectionPeriodLessCurrent;

            ProjecaoResult projection = new ProjecaoResult(calendarToString(currentDate), currentPopulation.toString() ,dataFutura, result.toString());
            saveCallService(projection);
            return result.toString();
        } catch (IllegalArgumentException e) {
           throw  new IllegalArgumentException(e.getMessage());
        }

    }

    private void saveCallService(ProjecaoResult projecaoResult) {
        if (projecaoResult == null) {
           return;
        }

        projecaoRepository.saveObject(projecaoResult);

    }


}
