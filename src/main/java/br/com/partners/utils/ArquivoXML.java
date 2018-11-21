package br.com.partners.utils;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;


/**
 * Classe responsavel por gerar o arquivo XML baseado no PDF coletado.
 */
public class ArquivoXML {

    private TransformerHandler th;
    private AttributesImpl atts;

    /**
     * Metodo para executar a inicialização do XML no padrão UTF-8 com identação automática.
     * @param pdfTextStripperByArea - Atributo coletado do PDF contendo as informações necessárias.
     */
    public void criarXML(PDFTextStripperByArea pdfTextStripperByArea) {

        try {
            PDDocument.load(new File("C:/Users/Victor - Partners/Desktop/teste/sample.pdf"));

            StreamResult out = new StreamResult("C:/Users/Victor - Partners/Desktop/teste/data.xml");

            SAXTransformerFactory tf = (SAXTransformerFactory) SAXTransformerFactory.newInstance();
            th = tf.newTransformerHandler();

            Transformer serializer = th.getTransformer();
            serializer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            serializer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            serializer.setOutputProperty(OutputKeys.INDENT, "yes");

            th.setResult(out);
            th.startDocument();
            atts = new AttributesImpl();
            th.setResult(out);
            th.startDocument();
            th.startElement(null, null, "produtos", atts);

            criarTag(pdfTextStripperByArea);

            th.endElement(null, null, "produtos");
            th.endDocument();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo especifico para usar as informações dos retângulos para criação do dos valores.
     * @param pdfTextStripperByArea - Uso dos retângulos para a conversão em XML.
     * @throws SAXException - Não sei que faz...
     */
    private void criarTag(PDFTextStripperByArea pdfTextStripperByArea) throws SAXException {

        for(String regiao: pdfTextStripperByArea.getRegions()) {

            th.startElement(null, null, regiao, atts);
            String[] elements = pdfTextStripperByArea.getTextForRegion(regiao).trim().split("\n");
            th.characters(elements[0].toCharArray(), 0, elements[0].length());
            th.endElement(null, null, regiao);

        }

    }
}
