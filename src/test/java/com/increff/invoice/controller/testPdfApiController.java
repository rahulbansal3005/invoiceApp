package com.increff.invoice.controller;

import com.increff.invoice.AbstractUnitTest;
import com.increff.invoice.model.PdfData;
import com.increff.invoice.model.PdfListData;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class testPdfApiController extends AbstractUnitTest {

    @Autowired
    private PdfApiController pdfApiController;

    @Test
    public void testInvoice() throws Exception {

        PdfData pdfData=new PdfData();
        DateTimeFormatter date = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = LocalDateTime.now().format(date);
        DateTimeFormatter time = DateTimeFormatter.ofPattern("HH:mm:ss");
        String formattedTime = LocalDateTime.now().format(time);
        pdfData.setInvoiceTime(formattedTime);
        pdfData.setInvoiceDate(formattedDate);
        pdfData.setTotal(101232.03);
        pdfData.setOrderId(1018);
        List<PdfListData> pdfListData = new ArrayList<>();
        for(int i=0;i<5;i++)
        {
            PdfListData pdfListData1 = new PdfListData();
            pdfListData1.setSno(1+i);
            pdfListData1.setBarcode("bar"+i);
            pdfListData1.setProduct("Name"+i);
            pdfListData1.setQuantity(265+i);
            pdfListData1.setUnitPrice(89.6+i);
            pdfListData1.setAmount(10.56+i);
            pdfListData.add(pdfListData1);
        }
        pdfData.setItemList(pdfListData);
        String res=pdfApiController.get(pdfData);
        System.out.println("----------"+res);

    }
}
