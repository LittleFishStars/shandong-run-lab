package com.googlecode.mp4parser.authoring.tracks.ttml;

import com.alibaba.android.arouter.utils.Consts;
import com.googlecode.mp4parser.authoring.Movie;
import com.googlecode.mp4parser.authoring.builder.DefaultMp4Builder;
import com.zj.adlib.c49;
import com.zj.adlib.nd9;
import com.zj.adlib.u15;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class TtmlHelpers {
    public static final String SMPTE_TT_NAMESPACE = "http://www.smpte-ra.org/schemas/2052-1/2010/smpte-tt";
    public static final String TTML_NAMESPACE = "http://www.w3.org/ns/ttml";
    static byte[] namespacesStyleSheet1 = "<xsl:stylesheet version=\"1.0\" xmlns:xsl=\"http://www.w3.org/1999/XSL/Transform\">\n    <xsl:output method=\"text\"/>\n    <xsl:key name=\"kElemByNSURI\"\n             match=\"*[namespace::*[not(. = ../../namespace::*)]]\"\n              use=\"namespace::*[not(. = ../../namespace::*)]\"/>\n    <xsl:template match=\"/\">\n        <xsl:for-each select=\n            \"//namespace::*[not(. = ../../namespace::*)]\n                           [count(..|key('kElemByNSURI',.)[1])=1]\">\n            <xsl:value-of select=\"concat(.,'&#xA;')\"/>\n        </xsl:for-each>\n    </xsl:template>\n</xsl:stylesheet>".getBytes();
    public static final NamespaceContext NAMESPACE_CONTEXT = new TextTrackNamespaceContext(null);

    public static class TextTrackNamespaceContext implements NamespaceContext {
        private TextTrackNamespaceContext() {
        }

        @Override // javax.xml.namespace.NamespaceContext
        public String getNamespaceURI(String str) {
            if (str.equals("ttml")) {
                return TtmlHelpers.TTML_NAMESPACE;
            }
            if (str.equals("smpte")) {
                return TtmlHelpers.SMPTE_TT_NAMESPACE;
            }
            return null;
        }

        @Override // javax.xml.namespace.NamespaceContext
        public String getPrefix(String str) {
            if (str.equals(TtmlHelpers.TTML_NAMESPACE)) {
                return "ttml";
            }
            if (str.equals(TtmlHelpers.SMPTE_TT_NAMESPACE)) {
                return "smpte";
            }
            return null;
        }

        @Override // javax.xml.namespace.NamespaceContext
        public Iterator getPrefixes(String str) {
            return Arrays.asList("ttml", "smpte").iterator();
        }

        public /* synthetic */ TextTrackNamespaceContext(TextTrackNamespaceContext textTrackNamespaceContext) {
            this();
        }
    }

    private static long copyLarge(InputStream inputStream, File file) throws IOException {
        byte[] bArr = new byte[16384];
        file.getParentFile().mkdirs();
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        long j = 0;
        while (true) {
            try {
                int i = inputStream.read(bArr);
                if (-1 == i) {
                    fileOutputStream.close();
                    return j;
                }
                fileOutputStream.write(bArr, 0, i);
                j += (long) i;
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        }
    }

    public static void deepCopyDocument(Document document, File file) throws IOException {
        try {
            NodeList nodeList = (NodeList) XPathFactory.newInstance().newXPath().compile("//*/@backgroundImage").evaluate(document, XPathConstants.NODESET);
            for (int i = 0; i < nodeList.getLength(); i++) {
                URI uriCreate = URI.create(nodeList.item(i).getNodeValue());
                if (!uriCreate.isAbsolute()) {
                    copyLarge(new URI(document.getDocumentURI()).resolve(uriCreate).toURL().openStream(), new File(file.toURI().resolve(uriCreate).toURL().getFile()));
                }
            }
            copyLarge(new URI(document.getDocumentURI()).toURL().openStream(), file);
        } catch (URISyntaxException e) {
            throw new IOException(e);
        } catch (XPathExpressionException e2) {
            throw new IOException(e2);
        }
    }

    public static String[] getAllNamespaces(Document document) {
        try {
            Transformer transformerNewTransformer = TransformerFactory.newInstance().newTransformer(new StreamSource(new ByteArrayInputStream(namespacesStyleSheet1)));
            StringWriter stringWriter = new StringWriter();
            transformerNewTransformer.transform(new DOMSource(document), new StreamResult(stringWriter));
            ArrayList arrayList = new ArrayList(new LinkedHashSet(Arrays.asList(stringWriter.getBuffer().toString().split("\n"))));
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        } catch (TransformerConfigurationException e) {
            throw new RuntimeException(e);
        } catch (TransformerException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static long getEndTime(Node node) {
        long time = 0;
        Node parentNode = node;
        while (true) {
            parentNode = parentNode.getParentNode();
            if (parentNode == null) {
                break;
            }
            if (parentNode.getAttributes() != null && parentNode.getAttributes().getNamedItem(nd9.f18397d) != null) {
                time += toTime(parentNode.getAttributes().getNamedItem(nd9.f18397d).getNodeValue());
            }
        }
        return (node.getAttributes() == null || node.getAttributes().getNamedItem("end") == null) ? time : time + toTime(node.getAttributes().getNamedItem("end").getNodeValue());
    }

    public static long getStartTime(Node node) {
        long time = 0;
        Node parentNode = node;
        while (true) {
            parentNode = parentNode.getParentNode();
            if (parentNode == null) {
                break;
            }
            if (parentNode.getAttributes() != null && parentNode.getAttributes().getNamedItem(nd9.f18397d) != null) {
                time += toTime(parentNode.getAttributes().getNamedItem(nd9.f18397d).getNodeValue());
            }
        }
        return (node.getAttributes() == null || node.getAttributes().getNamedItem(nd9.f18397d) == null) ? time : time + toTime(node.getAttributes().getNamedItem(nd9.f18397d).getNodeValue());
    }

    public static void main(String[] strArr) throws XPathExpressionException, TransformerException, ParserConfigurationException, URISyntaxException, SAXException, IOException {
        DocumentBuilderFactory documentBuilderFactoryNewInstance = DocumentBuilderFactory.newInstance();
        documentBuilderFactoryNewInstance.setNamespaceAware(true);
        TtmlTrackImpl ttmlTrackImpl = new TtmlTrackImpl("a.xml", TtmlSegmenter.split(documentBuilderFactoryNewInstance.newDocumentBuilder().parse("C:\\dev\\mp4parser\\a.xml"), 60));
        Movie movie = new Movie();
        movie.addTrack(ttmlTrackImpl);
        new DefaultMp4Builder().build(movie).writeContainer(new FileOutputStream("output.mp4").getChannel());
    }

    public static void pretty(Document document, OutputStream outputStream, int i) throws IOException {
        try {
            Transformer transformerNewTransformer = TransformerFactory.newInstance().newTransformer();
            transformerNewTransformer.setOutputProperty("encoding", "UTF-8");
            if (i > 0) {
                transformerNewTransformer.setOutputProperty("indent", "yes");
                transformerNewTransformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", Integer.toString(i));
            }
            try {
                transformerNewTransformer.transform(new DOMSource(document), new StreamResult(outputStream));
            } catch (TransformerException e) {
                throw new IOException(e);
            }
        } catch (TransformerConfigurationException e2) {
            throw new RuntimeException(e2);
        }
    }

    public static long toTime(String str) {
        long j;
        Matcher matcher = Pattern.compile("(-?)([0-9][0-9]):([0-9][0-9]):([0-9][0-9])([\\.:][0-9][0-9]?[0-9]?)?").matcher(str);
        if (!matcher.matches()) {
            throw new RuntimeException("Cannot match '" + str + "' to time expression");
        }
        String strGroup = matcher.group(1);
        String strGroup2 = matcher.group(2);
        String strGroup3 = matcher.group(3);
        String strGroup4 = matcher.group(4);
        String strGroup5 = matcher.group(5);
        if (strGroup5 == null) {
            strGroup5 = ".000";
        }
        String strReplace = strGroup5.replace(u15.f19942b, Consts.DOT);
        long j2 = (Long.parseLong(strGroup2) * 60 * 60 * 1000) + (Long.parseLong(strGroup3) * 60 * 1000) + (Long.parseLong(strGroup4) * 1000);
        if (strReplace.contains(u15.f19942b)) {
            j = (long) (j2 + (Double.parseDouble("0" + strReplace.replace(u15.f19942b, Consts.DOT)) * 40.0d * 1000.0d));
        } else {
            j = (long) (j2 + (Double.parseDouble("0" + strReplace) * 1000.0d));
        }
        return j * ((long) (c49.f40900a.equals(strGroup) ? -1 : 1));
    }

    public static String toTimeExpression(long j) {
        return toTimeExpression(j, -1);
    }

    public static String toTimeExpression(long j, int i) {
        String str = j >= 0 ? "" : c49.f40900a;
        long jAbs = Math.abs(j);
        long j2 = ((jAbs / 1000) / 60) / 60;
        long j3 = jAbs - (((j2 * 1000) * 60) * 60);
        long j4 = (j3 / 1000) / 60;
        long j5 = j3 - ((j4 * 1000) * 60);
        long j6 = j5 / 1000;
        return i >= 0 ? String.format("%s%02d:%02d:%02d:%d", str, Long.valueOf(j2), Long.valueOf(j4), Long.valueOf(j6), Integer.valueOf(i)) : String.format("%s%02d:%02d:%02d.%03d", str, Long.valueOf(j2), Long.valueOf(j4), Long.valueOf(j6), Long.valueOf(j5 - (1000 * j6)));
    }
}
