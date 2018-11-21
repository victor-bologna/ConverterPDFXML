package br.com.partners.main;

import br.com.partners.utils.ArquivoXML;
import br.com.partners.utils.RetanguloPDF;
import org.apache.pdfbox.text.PDFTextStripperByArea;

/**
 *  Classe principal para executar o retangulo do PDF quanto o arquivo XML.
 */
public class ProcessarPdfXml {

    public static void main(String[] args) {

        RetanguloPDF retanguloPDF = new RetanguloPDF();
        ArquivoXML arquivoXML = new ArquivoXML();

        PDFTextStripperByArea pdfTextStripperByArea = retanguloPDF.parse("C:/Users/Victor - Partners/Desktop/teste/sample.pdf");
        arquivoXML.criarXML(pdfTextStripperByArea);

    }
}