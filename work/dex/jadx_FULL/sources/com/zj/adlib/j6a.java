package com.zj.adlib;

import android.util.Xml;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class j6a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Element f42521a;

    public j6a(Element element) {
        this.f42521a = element;
    }

    public static j6a f(Node node, String str, String str2, String str3) {
        if (node.getNodeType() != 1) {
            return null;
        }
        Element element = (Element) node;
        if (str != null && !str.equals(element.getTagName())) {
            return null;
        }
        if (str2 != null && !element.hasAttribute(str2)) {
            return null;
        }
        if (str3 == null || str3.equals(element.getAttribute(str2))) {
            return new j6a(element);
        }
        return null;
    }

    public static List<j6a> g(NodeList nodeList, String str, String str2, String str3) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < nodeList.getLength(); i++) {
            j6a j6aVarF = f(nodeList.item(i), str, str2, str3);
            if (j6aVarF != null) {
                arrayList.add(j6aVarF);
            }
        }
        return arrayList;
    }

    public String a(String str) {
        return this.f42521a.getAttribute(str);
    }

    public j6a b(String str) {
        return c(str, null, null);
    }

    public j6a c(String str, String str2, String str3) {
        List<j6a> listE = e(str, str2, str3);
        if (listE.size() == 0) {
            return null;
        }
        return listE.get(0);
    }

    public List<j6a> d(String str) {
        return e(str, null, null);
    }

    public List<j6a> e(String str, String str2, String str3) {
        return g(this.f42521a.getChildNodes(), str, str2, str3);
    }

    public Element h() {
        return this.f42521a;
    }

    public final String i(Element element, int i) {
        String str;
        try {
            XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
            StringWriter stringWriter = new StringWriter();
            xmlSerializerNewSerializer.setOutput(stringWriter);
            xmlSerializerNewSerializer.startDocument("utf-8", null);
            if (i > 0) {
                char[] cArr = new char[i];
                Arrays.fill(cArr, ' ');
                str = new String(cArr);
            } else {
                str = null;
            }
            j(this.f42521a, xmlSerializerNewSerializer, 0, str);
            xmlSerializerNewSerializer.endDocument();
            return stringWriter.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public final void j(Element element, XmlSerializer xmlSerializer, int i, String str) throws Exception {
        String tagName = element.getTagName();
        s(xmlSerializer, i, str);
        xmlSerializer.startTag("", tagName);
        if (element.hasAttributes()) {
            NamedNodeMap attributes = element.getAttributes();
            for (int i2 = 0; i2 < attributes.getLength(); i2++) {
                Attr attr = (Attr) attributes.item(i2);
                xmlSerializer.attribute("", attr.getName(), attr.getValue());
            }
        }
        if (element.hasChildNodes()) {
            NodeList childNodes = element.getChildNodes();
            int i3 = 0;
            for (int i4 = 0; i4 < childNodes.getLength(); i4++) {
                Node nodeItem = childNodes.item(i4);
                short nodeType = nodeItem.getNodeType();
                if (nodeType == 1) {
                    j((Element) nodeItem, xmlSerializer, i + 1, str);
                    i3++;
                } else if (nodeType == 3) {
                    xmlSerializer.text(q(nodeItem));
                } else if (nodeType == 4) {
                    xmlSerializer.cdsect(q(nodeItem));
                }
            }
            if (i3 > 0) {
                s(xmlSerializer, i, str);
            }
        }
        xmlSerializer.endTag("", tagName);
    }

    public j6a k(String str) {
        NodeList elementsByTagName = this.f42521a.getElementsByTagName(str);
        if (elementsByTagName == null || elementsByTagName.getLength() <= 0) {
            return null;
        }
        return new j6a((Element) elementsByTagName.item(0));
    }

    public j6a l(String str, String str2, String str3) {
        List<j6a> listN = n(str, str2, str3);
        if (listN.size() == 0) {
            return null;
        }
        return listN.get(0);
    }

    public List<j6a> m(String str) {
        return n(str, null, null);
    }

    public List<j6a> n(String str, String str2, String str3) {
        return g(this.f42521a.getElementsByTagName(str), null, str2, str3);
    }

    public String o() {
        NodeList childNodes = this.f42521a.getChildNodes();
        if (childNodes.getLength() == 1) {
            return childNodes.item(0).getNodeValue();
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < childNodes.getLength(); i++) {
            sb.append(q(childNodes.item(i)));
        }
        return sb.toString();
    }

    public String p(String str) {
        j6a j6aVarB = b(str);
        if (j6aVarB == null) {
            return null;
        }
        return j6aVarB.o();
    }

    public final String q(Node node) {
        String nodeValue;
        short nodeType = node.getNodeType();
        if (nodeType != 3) {
            nodeValue = nodeType != 4 ? null : node.getNodeValue();
        } else {
            nodeValue = node.getNodeValue();
            if (nodeValue != null) {
                nodeValue = nodeValue.trim();
            }
        }
        return nodeValue == null ? "" : nodeValue;
    }

    public String r(int i) {
        return i(this.f42521a, i);
    }

    public final void s(XmlSerializer xmlSerializer, int i, String str) throws Exception {
        if (str != null) {
            xmlSerializer.text("\n");
            for (int i2 = 0; i2 < i; i2++) {
                xmlSerializer.text(str);
            }
        }
    }

    public String toString() {
        return r(0);
    }

    public j6a(String str) throws SAXException {
        this(str.getBytes());
    }

    public j6a(byte[] bArr) throws SAXException {
        this(new ByteArrayInputStream(bArr));
    }

    public j6a(InputStream inputStream) throws SAXException {
        try {
            this.f42521a = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(inputStream).getDocumentElement();
        } catch (IOException e) {
            throw new SAXException(e);
        } catch (ParserConfigurationException unused) {
        }
    }
}
