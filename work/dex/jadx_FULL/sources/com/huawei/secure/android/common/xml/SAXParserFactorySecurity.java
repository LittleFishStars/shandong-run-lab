package com.huawei.secure.android.common.xml;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.SAXNotRecognizedException;
import org.xml.sax.SAXNotSupportedException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class SAXParserFactorySecurity {
    public static SAXParserFactory getInstance() throws SAXNotRecognizedException, SAXNotSupportedException, ParserConfigurationException, NullPointerException {
        SAXParserFactory sAXParserFactoryNewInstance = SAXParserFactory.newInstance();
        sAXParserFactoryNewInstance.setFeature("http://xml.org/sax/features/namespaces", true);
        sAXParserFactoryNewInstance.setFeature("http://xml.org/sax/features/namespace-prefixes", false);
        sAXParserFactoryNewInstance.setFeature("http://xml.org/sax/features/validation", false);
        sAXParserFactoryNewInstance.setFeature("http://xml.org/sax/features/external-general-entities", false);
        sAXParserFactoryNewInstance.setFeature("http://xml.org/sax/features/external-parameter-entities", false);
        sAXParserFactoryNewInstance.setFeature("http://xml.org/sax/features/string-interning", true);
        return sAXParserFactoryNewInstance;
    }
}
