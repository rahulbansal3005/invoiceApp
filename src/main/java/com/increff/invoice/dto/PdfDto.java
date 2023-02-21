package com.increff.invoice.dto;
import com.increff.invoice.model.PdfData;
import com.increff.invoice.util.Invoice.PDF_Generator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class PdfDto {
    @Autowired
    private PDF_Generator pdf_generator;
    public String get(PdfData pdfData) throws Exception {
        return pdf_generator.pdf_generator(pdfData);
    }
}
