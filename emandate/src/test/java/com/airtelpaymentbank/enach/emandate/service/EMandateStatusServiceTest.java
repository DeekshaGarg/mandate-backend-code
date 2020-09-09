package com.airtelpaymentbank.enach.emandate.service;

import com.airtelpaymentbank.enach.emandate.model.MandateStatus;
import com.airtelpaymentbank.enach.emandate.repository.EMandateStatusRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import sun.net.www.http.HttpClient;

import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class EMandateStatusServiceTest {

    @Mock
    private EMandateStatusRepository mockEMandateStatusRepository;
    @Mock
    private HttpClient mockHttpClient;

    @InjectMocks
    private EMandateStatusService eMandateStatusServiceUnderTest;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @Test
    void testSave() {
        // Setup
        final MandateStatus status = new MandateStatus();
        status.setMndtReqId("mndtReqId");
        status.setMandateStatus("mandateStatus");
        status.setCreatedTimestamp(new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());
        status.setCreatedBy("createdBy");

        // Configure EMandateStatusRepository.save(...).
        final MandateStatus mandateStatus = new MandateStatus();
        mandateStatus.setMndtReqId("mndtReqId");
        mandateStatus.setMandateStatus("mandateStatus");
        mandateStatus.setCreatedTimestamp(new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());
        mandateStatus.setCreatedBy("createdBy");
        when(mockEMandateStatusRepository.save(any(MandateStatus.class))).thenReturn(mandateStatus);

        // Run the test
        eMandateStatusServiceUnderTest.save(status);

        // Verify the results
    }

    @Test
    void testEnableUpi() throws Exception {
        // Setup



        // Run the test
        final MandateStatus result = eMandateStatusServiceUnderTest.enableUpi("mobile", "action");

        // Verify the results
    }

    @Test
    void testEnableUpi_ThrowsIOException() {
        // Setup

        // Run the test
        assertThrows(IOException.class, () -> {
            eMandateStatusServiceUnderTest.enableUpi("mobile", "action");
        });

        Assertions.assertThatThrownBy()
    }

    @Test
    void testGetUpiStatus() {
        // Setup

        HttpHeaders httpHeaders = Mockito.mock(HttpHeaders.class);
        when(httpHeaders.getFirst("channel")).thenReturn("APP");
        when(httpHeaders.getFirst("Content-Type")).thenReturn("application/json");

        String mobileNo="777777";
        String reqUrl=url+"status/" +mobileNo;

        ResponseDTO<Map<String,String>> responseDTO=Mockito.mock(ResponseDTO.class);
        Meta meta=Mockito.mock(Meta.class);
        when(meta.getCode()).thenReturn("002");
        when(responseDTO.getMeta()).thenReturn(meta);
        when(httpClient.invokeIssuer(reqUrl,null,ResponseDTO.class,httpHeaders, HttpMethod.POST))
                .thenReturn(responseDTO);


        // Run the test
    ResponseDTO<Map<String,String>> actual=accounStatusServiceImplUnderTest.getUpiStatus(mobileNo);
    assertEquals(Constants.SUCCESS_CODE,actual.getMeta().getCode());
        assertEquals(Constants.SUCCESS,actual.getMeta().getDescription());


        assertEquals(UpiActorStatus.ACTIVE.toString().toUpperCase(),actual.getData().get("status"));



    }
}
