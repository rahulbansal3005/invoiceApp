package com.increff.invoice.util.Invoice;

//import org.apache.commons.codec.binary.Base64;
import java.util.Base64;
import com.increff.invoice.model.PdfData;
import org.apache.fop.apps.*;
import org.springframework.stereotype.Service;

import javax.xml.transform.*;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;

@Service
public class PDF_Generator {
    public String pdfGenerator(PdfData pdfData) throws Exception {
        try {
            File xmlfile = new File("src/main/resources/apache/name.xml");
            File xsltfile = new File("src/main/resources/apache/style.xsl");

            final FopFactory fopFactory = FopFactory.newInstance();
            FOUserAgent foUserAgent = fopFactory.newFOUserAgent();

            ByteArrayOutputStream out = new ByteArrayOutputStream();
            try {
                Fop fop;
                fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

                TransformerFactory factory = TransformerFactory.newInstance();
                Transformer transformer = factory.newTransformer(new StreamSource(xsltfile));

                Source src = new StreamSource(xmlfile);
                Result res = new SAXResult(fop.getDefaultHandler());

                transformer.transform(src, res);
            } catch (FOPException | TransformerException e) {
                e.printStackTrace();
            } finally {
                byte[] pdf = out.toByteArray();
                String base64 = Base64.getEncoder().encodeToString(pdf);
                return base64;
            }
        } catch (Exception exp) {
            exp.printStackTrace();
        }
        return "hello";
    }
}
