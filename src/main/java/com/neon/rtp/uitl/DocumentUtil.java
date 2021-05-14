package com.neon.rtp.uitl;




import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.StringReader;

/**
 * @author Neon
 * @date 2021/3/1 15:11
 */
public class DocumentUtil{

    private static final Logger LOG = LoggerFactory.getLogger(DocumentUtil.class);
    public static void main(String[] args) {

        }
    public static Document parse(String xml) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setValidating(false);
            DocumentBuilder documentBuilder = factory.newDocumentBuilder();
            documentBuilder.setEntityResolver(new IgnoreDTDEntityResolver());
            LOG.debug("document parse content : {}", xml);
            return documentBuilder.parse(new InputSource(new StringReader(xml)));
        } catch(ParserConfigurationException | SAXException | IOException e) {
            LOG.error("document parse error", e);
            throw new OperateException("XML文件解析失败");
        }
    }

    private static class IgnoreDTDEntityResolver implements EntityResolver{

        @Override public InputSource resolveEntity(String publicId, String systemId) throws SAXException,
                IOException {
            return new InputSource(new ByteArrayInputStream("<?xml version=\"1.0\" encoding=\"UTF-8\"?>".getBytes()));
        }
    }
}
