package com.huawei.secure.android.common.xml;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class DocumentBuilderFactorySecurity {
    public static DocumentBuilderFactory getInstance() throws ParserConfigurationException, NullPointerException {
        DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
        documentBuilderFactoryNewInstance.setFeature("http://xml.org/sax/features/namespaces", true);
        documentBuilderFactoryNewInstance.setFeature("http://xml.org/sax/features/validation", false);
        documentBuilderFactoryNewInstance.setExpandEntityReferences(false);
        return documentBuilderFactoryNewInstance;
    }
}
