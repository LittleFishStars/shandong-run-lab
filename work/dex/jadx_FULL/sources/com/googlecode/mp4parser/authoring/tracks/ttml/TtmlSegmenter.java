package com.googlecode.mp4parser.authoring.tracks.ttml;

import com.alibaba.android.arouter.utils.Consts;
import com.zj.adlib.nd9;
import java.util.ArrayList;
import java.util.List;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class TtmlSegmenter {
    public static void changeTime(Node node, String str, long j) {
        if (node.getAttributes() == null || node.getAttributes().getNamedItem(str) == null) {
            return;
        }
        String nodeValue = node.getAttributes().getNamedItem(str).getNodeValue();
        long time = TtmlHelpers.toTime(nodeValue) + j;
        node.getAttributes().getNamedItem(str).setNodeValue(TtmlHelpers.toTimeExpression(time, nodeValue.contains(Consts.DOT) ? -1 : ((int) (time - ((time / 1000) * 1000))) / 44));
    }

    public static Document normalizeTimes(Document document) throws XPathExpressionException {
        XPath xPathNewXPath = XPathFactory.newInstance().newXPath();
        xPathNewXPath.setNamespaceContext(TtmlHelpers.NAMESPACE_CONTEXT);
        NodeList nodeList = (NodeList) xPathNewXPath.compile("//*[name()='p']").evaluate(document, XPathConstants.NODESET);
        for (int i = 0; i < nodeList.getLength(); i++) {
            pushDown(nodeList.item(i));
        }
        for (int i2 = 0; i2 < nodeList.getLength(); i2++) {
            Node nodeItem = nodeList.item(i2);
            removeAfterPushDown(nodeItem, nd9.f18397d);
            removeAfterPushDown(nodeItem, "end");
        }
        return document;
    }

    private static void pushDown(Node node) {
        long time = 0;
        Node parentNode = node;
        while (true) {
            parentNode = parentNode.getParentNode();
            if (parentNode == null) {
                break;
            } else if (parentNode.getAttributes() != null && parentNode.getAttributes().getNamedItem(nd9.f18397d) != null) {
                time += TtmlHelpers.toTime(parentNode.getAttributes().getNamedItem(nd9.f18397d).getNodeValue());
            }
        }
        if (node.getAttributes() != null && node.getAttributes().getNamedItem(nd9.f18397d) != null) {
            node.getAttributes().getNamedItem(nd9.f18397d).setNodeValue(TtmlHelpers.toTimeExpression(TtmlHelpers.toTime(node.getAttributes().getNamedItem(nd9.f18397d).getNodeValue()) + time));
        }
        if (node.getAttributes() == null || node.getAttributes().getNamedItem("end") == null) {
            return;
        }
        node.getAttributes().getNamedItem("end").setNodeValue(TtmlHelpers.toTimeExpression(time + TtmlHelpers.toTime(node.getAttributes().getNamedItem("end").getNodeValue())));
    }

    private static void removeAfterPushDown(Node node, String str) {
        while (true) {
            node = node.getParentNode();
            if (node == null) {
                return;
            }
            if (node.getAttributes() != null && node.getAttributes().getNamedItem(str) != null) {
                node.getAttributes().removeNamedItem(str);
            }
        }
    }

    public static List<Document> split(Document document, int i) throws XPathExpressionException {
        int i2 = i * 1000;
        XPath xPathNewXPath = XPathFactory.newInstance().newXPath();
        XPathExpression xPathExpressionCompile = xPathNewXPath.compile("//*[name()='p']");
        ArrayList arrayList = new ArrayList();
        while (true) {
            long size = arrayList.size() * i2;
            long size2 = (arrayList.size() + 1) * i2;
            Document document2 = (Document) document.cloneNode(true);
            NodeList nodeList = (NodeList) xPathExpressionCompile.evaluate(document2, XPathConstants.NODESET);
            int i3 = 0;
            boolean z = false;
            while (i3 < nodeList.getLength()) {
                int i4 = i2;
                Node nodeItem = nodeList.item(i3);
                long startTime = TtmlHelpers.getStartTime(nodeItem);
                long endTime = TtmlHelpers.getEndTime(nodeItem);
                if (startTime < size && endTime > size) {
                    changeTime(nodeItem, nd9.f18397d, size - startTime);
                    startTime = size;
                }
                if (startTime >= size && startTime < size2 && endTime > size2) {
                    changeTime(nodeItem, "end", size2 - endTime);
                    startTime = size;
                    endTime = size2;
                }
                if (startTime > size2) {
                    z = true;
                }
                if (startTime < size || endTime > size2) {
                    nodeItem.getParentNode().removeChild(nodeItem);
                } else {
                    long j = -size;
                    changeTime(nodeItem, nd9.f18397d, j);
                    changeTime(nodeItem, "end", j);
                }
                i3++;
                xPathNewXPath = xPathNewXPath;
                i2 = i4;
                xPathExpressionCompile = xPathExpressionCompile;
            }
            trimWhitespace(document2);
            Element element = (Element) xPathNewXPath.compile("/*[name()='tt']/*[name()='body'][1]").evaluate(document2, XPathConstants.NODE);
            String attribute = element.getAttribute(nd9.f18397d);
            String attribute2 = element.getAttribute("end");
            int i5 = i2;
            if (attribute == null || "".equals(attribute)) {
                element.setAttribute(nd9.f18397d, TtmlHelpers.toTimeExpression(size));
            } else {
                changeTime(element, nd9.f18397d, size);
            }
            if (attribute2 == null || "".equals(attribute2)) {
                element.setAttribute("end", TtmlHelpers.toTimeExpression(size2));
            } else {
                changeTime(element, "end", size2);
            }
            arrayList.add(document2);
            if (!z) {
                return arrayList;
            }
            i2 = i5;
        }
    }

    public static void trimWhitespace(Node node) {
        NodeList childNodes = node.getChildNodes();
        for (int i = 0; i < childNodes.getLength(); i++) {
            Node nodeItem = childNodes.item(i);
            if (nodeItem.getNodeType() == 3) {
                nodeItem.setTextContent(nodeItem.getTextContent().trim());
            }
            trimWhitespace(nodeItem);
        }
    }
}
