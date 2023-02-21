package com.increff.invoice.util.Invoice;

import org.apache.commons.codec.binary.Base64;
import com.increff.invoice.model.PdfData;
import org.apache.fop.apps.*;
import org.springframework.stereotype.Service;

import javax.xml.transform.*;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

@Service
public class PDF_Generator {
    public String pdf_generator(PdfData pdfData) throws Exception {
            JavaToXML javaToXml = new JavaToXML();
            javaToXml.xmlGenerator(pdfData);
            String xmlfile = new File("src/main/resources/apache\\name.xml").toURI().getPath();
            String xsltfile = new File("src/main/resources/apache\\style.xsl").toURI().getPath();
            FopFactory fopFactory = FopFactory.newInstance();
            FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
            ByteArrayOutputStream outStream = new ByteArrayOutputStream();
            try {
                Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, outStream);
                System.out.println("line 1");
                TransformerFactory factory = TransformerFactory.newInstance();
                System.out.println("line 2");
                Transformer transformer = factory.newTransformer(new StreamSource(xsltfile));
                System.out.println("line 3");
                Source src = new StreamSource(xmlfile);
                Result res = new SAXResult(fop.getDefaultHandler());
                System.out.println("line 4");
                transformer.transform(src, res);
                System.out.println("line 5");
            } catch (TransformerConfigurationException e) {
                throw new RuntimeException(e);
            } catch (TransformerException e) {
                throw new RuntimeException(e);
            } catch (FOPException e) {
                throw new RuntimeException(e);
            } finally {
                outStream.close();
            }
        System.out.println("line 10");
            return Base64.encodeBase64String(outStream.toByteArray());
        }
}
