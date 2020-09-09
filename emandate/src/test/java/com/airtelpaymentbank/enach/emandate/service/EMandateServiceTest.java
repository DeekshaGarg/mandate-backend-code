package com.airtelpaymentbank.enach.emandate.service;

import com.airtelpaymentbank.enach.emandate.model.*;
import com.airtelpaymentbank.enach.emandate.repository.EMandateRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

class EMandateServiceTest {

    @Mock
    private EMandateRepository mockEMandateRepository;

    @InjectMocks
    private EMandateService eMandateServiceUnderTest;

    @BeforeEach
    void setUp() {
        initMocks(this);
    }

    @Test
    void testGetMandateDetails() {
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

        // Run the test
        final MandateDetails result = eMandateServiceUnderTest.getMandateDetails(mndtAuthReq, "authMode");

        // Verify the results
    }

    @Test
    void testSave() {
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

        // Configure EMandateRepository.save(...).
        final MndtAuthReq mndtAuthReq1 = new MndtAuthReq();
        mndtAuthReq1.setIdForDb(0L);
        final com.airtelpaymentbank.enach.emandate.model.GrpHdr GrpHdr1 = new GrpHdr();
        GrpHdr1.setNPCI_RefMsgId("nPCI_RefMsgId");
        GrpHdr1.setCreDtTm(new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());
        final ReqInitPty reqInitPty1 = new ReqInitPty();
        reqInitPty1.setIdForDb(0L);
        final Info info1 = new Info();
        info1.setIdForDb(0L);
        info1.setId("id");
        info1.setCatCode("catCode");
        info1.setUtilCode(0);
        info1.setCatDesc("catDesc");
        info1.setName("name");
        info1.setSpn_Bnk_Nm("spn_Bnk_Nm");
        reqInitPty1.setInfo(info1);
        GrpHdr1.setReqInitPty(reqInitPty1);
        mndtAuthReq1.setGrpHdr(GrpHdr1);
        final com.airtelpaymentbank.enach.emandate.model.Mndt Mndt1 = new Mndt();
        Mndt1.setMndtReqId("mndtReqId");
        Mndt1.setMndtId("mndtId");
        Mndt1.setMndt_Type("mndt_Type");
        Mndt1.setSchm_Nm("schm_Nm");
        final Ocrncs ocrncs1 = new Ocrncs();
        ocrncs1.setIdForDb(0L);
        ocrncs1.setSeqTp("seqTp");
        ocrncs1.setFrqcy("frqcy");
        ocrncs1.setFrstColltnDt(new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());
        ocrncs1.setFnlColltnDt(new GregorianCalendar(2019, Calendar.JANUARY, 1).getTime());
        Mndt1.setOcrncs(ocrncs1);
        final ColltnAmt colltnAmt1 = new ColltnAmt();
        colltnAmt1.setId(0L);
        colltnAmt1.set_Ccy("_Ccy");
        colltnAmt1.set__text(new BigDecimal("0.00"));
        Mndt1.setColltnAmt(colltnAmt1);
        final MaxAmt maxAmt1 = new MaxAmt();
        maxAmt1.setIdForDb(0L);
        maxAmt1.set_Ccy("_Ccy");
        maxAmt1.set__text(new BigDecimal("0.00"));
        Mndt1.setMaxAmt(maxAmt1);
        final Dbtr dbtr1 = new Dbtr();
        dbtr1.setId(0L);
        dbtr1.setNm("nm");
        dbtr1.setAccNo("accNo");
        dbtr1.setAcct_Type("acct_Type");
        dbtr1.setCons_Ref_No("cons_Ref_No");
        dbtr1.setPhone("phone");
        dbtr1.setMobile("mobile");
        dbtr1.setEmail("email");
        dbtr1.setPan("pan");
        Mndt1.setDbtr(dbtr1);
        final CrAccDtl crAccDtl1 = new CrAccDtl();
        crAccDtl1.setId(0L);
        crAccDtl1.setNm("nm");
        crAccDtl1.setAccNo("accNo");
        crAccDtl1.setMmbId("mmbId");
        Mndt1.setCrAccDtl(crAccDtl1);
        mndtAuthReq1.setMndt(Mndt1);
        when(mockEMandateRepository.save(any(MndtAuthReq.class))).thenReturn(mndtAuthReq1);

        // Run the test
        eMandateServiceUnderTest.save(mndtAuthReq);

        // Verify the results
    }
}
