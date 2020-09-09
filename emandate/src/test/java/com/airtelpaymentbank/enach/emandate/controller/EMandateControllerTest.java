package com.airtelpaymentbank.enach.emandate.controller;

import com.airtelpaymentbank.enach.emandate.model.*;
import com.airtelpaymentbank.enach.emandate.service.EMandateService;
import com.airtelpaymentbank.enach.emandate.service.EMandateStatusService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class EMandateControllerTest {

    @Mock
    private EMandateService mockEMandateService;
    @Mock
    private EMandateStatusService mockEMandateStatusService;

    @InjectMocks
    private EMandateController eMandateControllerUnderTest;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @Test
    void testMndtAuthReqToBank() throws Exception{
        // Setup
        final MndtAuthReq mndtAuthReq = new MndtAuthReq();
        mndtAuthReq.setIdForDb(0L);
        final GrpHdr GrpHdr = new GrpHdr();
        GrpHdr.setNPCI_RefMsgId("nPCI_RefMsgId");
        GrpHdr.setCreDtTm(new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());
        final ReqInitPty reqInitPty = new ReqInitPty();
        reqInitPty.setIdForDb(0L);
        final Info info = new Info();
        info.setIdForDb(0L);
        info.setId("id");
        info.setCatCode("catCode");
        info.setUtilCode(0);
        info.setCatDesc("catDesc");
        info.setName("name");
        info.setSpn_Bnk_Nm("spn_Bnk_Nm");
        reqInitPty.setInfo(info);
        GrpHdr.setReqInitPty(reqInitPty);
        mndtAuthReq.setGrpHdr(GrpHdr);
        final Mndt Mndt = new Mndt();
        Mndt.setMndtReqId("mndtReqId");
        Mndt.setMndtId("mndtId");
        Mndt.setMndt_Type("mndt_Type");
        Mndt.setSchm_Nm("schm_Nm");
        final Ocrncs ocrncs = new Ocrncs();
        ocrncs.setIdForDb(0L);
        ocrncs.setSeqTp("seqTp");
        ocrncs.setFrqcy("frqcy");
        ocrncs.setFrstColltnDt(new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());
        ocrncs.setFnlColltnDt(new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());
        Mndt.setOcrncs(ocrncs);
        final ColltnAmt colltnAmt = new ColltnAmt();
        colltnAmt.setId(0L);
        colltnAmt.set_Ccy("_Ccy");
        colltnAmt.set__text(new BigDecimal("0.00"));
        Mndt.setColltnAmt(colltnAmt);
        final MaxAmt maxAmt = new MaxAmt();
        maxAmt.setIdForDb(0L);
        maxAmt.set_Ccy("_Ccy");
        maxAmt.set__text(new BigDecimal("0.00"));
        Mndt.setMaxAmt(maxAmt);
        final Dbtr dbtr = new Dbtr();
        dbtr.setId(0L);
        dbtr.setNm("nm");
        dbtr.setAccNo("accNo");
        dbtr.setAcct_Type("acct_Type");
        dbtr.setCons_Ref_No("cons_Ref_No");
        dbtr.setPhone("phone");
        dbtr.setMobile("mobile");
        dbtr.setEmail("email");
        dbtr.setPan("pan");
        Mndt.setDbtr(dbtr);
        final CrAccDtl crAccDtl = new CrAccDtl();
        crAccDtl.setId(0L);
        crAccDtl.setNm("nm");
        crAccDtl.setAccNo("accNo");
        crAccDtl.setMmbId("mmbId");
        Mndt.setCrAccDtl(crAccDtl);
        mndtAuthReq.setMndt(Mndt);

        // Configure EMandateService.getMandateDetails(...).
        final MandateDetails mandateDetails = new MandateDetails("mndtReqId", "accountNumber", "mandateIssuedTo", "frequency", new BigDecimal("0.00"), "amountInWords", "startDate", "endDate", "purposeOfMandate", "authMode");
        when(mockEMandateService.getMandateDetails(any(MndtAuthReq.class), eq("authMode"))).thenReturn(mandateDetails);

        // Run the test
        final MandateDetails result = eMandateControllerUnderTest.mndtAuthReqToBank(mndtAuthReq, "authMode");

        // Verify the results
        verify(mockEMandateService).save(any(MndtAuthReq.class));
    }

    @Test
    void testSaveStatus() {
        // Setup
        final MandateStatus status = new MandateStatus();
        status.setMndtReqId("mndtReqId");
        status.setMandateStatus("mandateStatus");
        status.setCreatedTimestamp(new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());
        status.setCreatedBy("createdBy");

        // Run the test
        //final MandateStatus result = eMandateControllerUnderTest.saveStatus(status);

        // Verify the results
        verify(mockEMandateStatusService).save(any(MandateStatus.class));
    }
}
