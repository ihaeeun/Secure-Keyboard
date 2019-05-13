package com.hackday.securekeyboard.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hackday.securekeyboard.dto.ReqApprovalToCompDto;
import com.hackday.securekeyboard.dto.ReqRegisterToCompDto;
import com.hackday.securekeyboard.dto.ResApprovalResultDto;
import com.hackday.securekeyboard.dto.ResRegisterResultDto;
import com.hackday.securekeyboard.vo.CardCompanyInfo;
import lombok.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class MediationServiceImpl implements MediationService{
    private final RestTemplate restTemplate;

    public MediationServiceImpl(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override
    public ResRegisterResultDto registerCard(CardCompanyInfo cardCompanyInfo, ReqRegisterToCompDto reqRegisterToCompDto) {

        String companyUrl = cardCompanyInfo.getUrl();

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        httpHeaders.set(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);

//        @TODO: Exception 처리
        ObjectMapper objectMapper = new ObjectMapper();
        String dtoJson = null;
        try {
            dtoJson = objectMapper.writeValueAsString(reqRegisterToCompDto);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        HttpEntity<?> httpEntity = new HttpEntity<>(dtoJson, httpHeaders);

        return restTemplate.postForObject(companyUrl, httpEntity, ResRegisterResultDto.class);
    }

    @Override
    public ResApprovalResultDto approvalPayment(ReqApprovalToCompDto reqApprovalToCompDto) {
        return null;
    }
}
