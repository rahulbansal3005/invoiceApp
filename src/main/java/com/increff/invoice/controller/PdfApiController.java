package com.increff.invoice.controller;

//import com.increff.invoice.dto.PdfDto;
import com.increff.invoice.dto.PdfDto;
import com.increff.invoice.model.PdfData;
import com.increff.invoice.service.ApiException;
import com.increff.invoice.util.Invoice.PDF_Generator;
//import com.increff.pos.service.ApiException;
//import com.increff.pos.util.Invoice.PDF_Generator;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Api
@RestController
public class PdfApiController {

    @Autowired
    private PdfDto pdfDto;

    @ApiOperation(value = "Generates PDF")
    @RequestMapping(path = "/api/pdf", method = RequestMethod.POST)
    public String get(@RequestBody PdfData pdfData) throws Exception {
        return pdfDto.get(pdfData);
    }

}
