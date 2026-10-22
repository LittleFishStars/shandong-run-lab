package com.googlecode.mp4parser.authoring.tracks.ttml;

import com.alibaba.android.arouter.utils.Consts;
import com.aliyun.auth.common.AliyunVodHttpCommon;
import com.coremedia.iso.boxes.SampleDescriptionBox;
import com.coremedia.iso.boxes.SubSampleInformationBox;
import com.googlecode.mp4parser.authoring.AbstractTrack;
import com.googlecode.mp4parser.authoring.Sample;
import com.googlecode.mp4parser.authoring.TrackMetaData;
import com.mp4parser.iso14496.part30.XMLSubtitleSampleEntry;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class TtmlTrackImpl extends AbstractTrack {
    SampleDescriptionBox sampleDescriptionBox;
    private long[] sampleDurations;
    List<Sample> samples;
    SubSampleInformationBox subSampleInformationBox;
    TrackMetaData trackMetaData;
    XMLSubtitleSampleEntry xmlSubtitleSampleEntry;

    public TtmlTrackImpl(String str, List<Document> list) throws XPathExpressionException, ParserConfigurationException, URISyntaxException, SAXException, IOException {
        super(str);
        this.trackMetaData = new TrackMetaData();
        this.sampleDescriptionBox = new SampleDescriptionBox();
        this.xmlSubtitleSampleEntry = new XMLSubtitleSampleEntry();
        this.samples = new ArrayList();
        this.subSampleInformationBox = new SubSampleInformationBox();
        extractLanguage(list);
        HashSet hashSet = new HashSet();
        this.sampleDurations = new long[list.size()];
        XPathFactory.newInstance().newXPath().setNamespaceContext(TtmlHelpers.NAMESPACE_CONTEXT);
        for (int i = 0; i < list.size(); i++) {
            Document document = list.get(i);
            SubSampleInformationBox.SubSampleEntry subSampleEntry = new SubSampleInformationBox.SubSampleEntry();
            this.subSampleInformationBox.getEntries().add(subSampleEntry);
            subSampleEntry.setSampleDelta(1L);
            this.sampleDurations[i] = extractDuration(document);
            List<byte[]> listExtractImages = extractImages(document);
            hashSet.addAll(extractMimeTypes(document));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            TtmlHelpers.pretty(document, byteArrayOutputStream, 4);
            SubSampleInformationBox.SubSampleEntry.SubsampleEntry subsampleEntry = new SubSampleInformationBox.SubSampleEntry.SubsampleEntry();
            subsampleEntry.setSubsampleSize(byteArrayOutputStream.size());
            subSampleEntry.getSubsampleEntries().add(subsampleEntry);
            for (byte[] bArr : listExtractImages) {
                byteArrayOutputStream.write(bArr);
                SubSampleInformationBox.SubSampleEntry.SubsampleEntry subsampleEntry2 = new SubSampleInformationBox.SubSampleEntry.SubsampleEntry();
                subsampleEntry2.setSubsampleSize(bArr.length);
                subSampleEntry.getSubsampleEntries().add(subsampleEntry2);
            }
            final byte[] byteArray = byteArrayOutputStream.toByteArray();
            this.samples.add(new Sample() { // from class: com.googlecode.mp4parser.authoring.tracks.ttml.TtmlTrackImpl.1
                @Override // com.googlecode.mp4parser.authoring.Sample
                public ByteBuffer asByteBuffer() {
                    return ByteBuffer.wrap(byteArray);
                }

                @Override // com.googlecode.mp4parser.authoring.Sample
                public long getSize() {
                    return byteArray.length;
                }

                @Override // com.googlecode.mp4parser.authoring.Sample
                public void writeTo(WritableByteChannel writableByteChannel) throws IOException {
                    writableByteChannel.write(ByteBuffer.wrap(byteArray));
                }
            });
        }
        this.xmlSubtitleSampleEntry.setNamespace(join(",", TtmlHelpers.getAllNamespaces(list.get(0))));
        this.xmlSubtitleSampleEntry.setSchemaLocation("");
        this.xmlSubtitleSampleEntry.setAuxiliaryMimeTypes(join(",", (String[]) new ArrayList(hashSet).toArray(new String[hashSet.size()])));
        this.sampleDescriptionBox.addBox(this.xmlSubtitleSampleEntry);
        this.trackMetaData.setTimescale(30000L);
        this.trackMetaData.setLayer(65535);
    }

    public static List<byte[]> extractImages(Document document) throws XPathExpressionException, URISyntaxException, IOException {
        NodeList nodeList = (NodeList) XPathFactory.newInstance().newXPath().compile("//*/@backgroundImage").evaluate(document, XPathConstants.NODESET);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i = 1;
        for (int i2 = 0; i2 < nodeList.getLength(); i2++) {
            Node nodeItem = nodeList.item(i2);
            String nodeValue = nodeItem.getNodeValue();
            String strSubstring = nodeValue.substring(nodeValue.lastIndexOf(Consts.DOT));
            String str = (String) linkedHashMap.get(nodeValue);
            if (str == null) {
                str = "urn:mp4parser:" + i + strSubstring;
                linkedHashMap.put(str, nodeValue);
                i++;
            }
            nodeItem.setNodeValue(str);
        }
        ArrayList arrayList = new ArrayList();
        if (!linkedHashMap.isEmpty()) {
            Iterator it = linkedHashMap.entrySet().iterator();
            while (it.hasNext()) {
                arrayList.add(streamToByteArray(new URI(document.getDocumentURI()).resolve((String) ((Map.Entry) it.next()).getValue()).toURL().openStream()));
            }
        }
        return arrayList;
    }

    public static String getLanguage(Document document) {
        return document.getDocumentElement().getAttribute("xml:lang");
    }

    private static String join(String str, String[] strArr) {
        StringBuilder sb = new StringBuilder();
        for (String str2 : strArr) {
            sb.append(str2);
            sb.append(str);
        }
        sb.setLength(sb.length() > 0 ? sb.length() - 1 : 0);
        return sb.toString();
    }

    private static long latestTimestamp(Document document) {
        XPath xPathNewXPath = XPathFactory.newInstance().newXPath();
        xPathNewXPath.setNamespaceContext(TtmlHelpers.NAMESPACE_CONTEXT);
        try {
            NodeList nodeList = (NodeList) xPathNewXPath.compile("//*[name()='p']").evaluate(document, XPathConstants.NODESET);
            long jMax = 0;
            for (int i = 0; i < nodeList.getLength(); i++) {
                jMax = Math.max(TtmlHelpers.getEndTime(nodeList.item(i)), jMax);
            }
            return jMax;
        } catch (XPathExpressionException e) {
            throw new RuntimeException(e);
        }
    }

    private static byte[] streamToByteArray(InputStream inputStream) throws IOException {
        byte[] bArr = new byte[8096];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            int i = inputStream.read(bArr);
            if (-1 == i) {
                return byteArrayOutputStream.toByteArray();
            }
            byteArrayOutputStream.write(bArr, 0, i);
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
    }

    public long extractDuration(Document document) {
        return lastTimestamp(document) - firstTimestamp(document);
    }

    public void extractLanguage(List<Document> list) {
        Iterator<Document> it = list.iterator();
        String str = null;
        while (it.hasNext()) {
            String language = getLanguage(it.next());
            if (str == null) {
                this.trackMetaData.setLanguage(Locale.forLanguageTag(language).getISO3Language());
                str = language;
            } else if (!str.equals(language)) {
                throw new RuntimeException("Within one Track all sample documents need to have the same language");
            }
        }
    }

    public List<String> extractMimeTypes(Document document) throws XPathExpressionException {
        NodeList nodeList = (NodeList) XPathFactory.newInstance().newXPath().compile("//*/@smpte:backgroundImage").evaluate(document, XPathConstants.NODESET);
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        for (int i = 0; i < nodeList.getLength(); i++) {
            String nodeValue = nodeList.item(i).getNodeValue();
            String strSubstring = nodeValue.substring(nodeValue.lastIndexOf(Consts.DOT));
            if (strSubstring.contains("jpg") || strSubstring.contains(AliyunVodHttpCommon.ImageExt.IMAGEEXT_JPEG)) {
                linkedHashSet.add("image/jpeg");
            } else if (strSubstring.contains("png")) {
                linkedHashSet.add("image/png");
            }
        }
        return new ArrayList(linkedHashSet);
    }

    public long firstTimestamp(Document document) {
        XPath xPathNewXPath = XPathFactory.newInstance().newXPath();
        xPathNewXPath.setNamespaceContext(TtmlHelpers.NAMESPACE_CONTEXT);
        try {
            NodeList nodeList = (NodeList) xPathNewXPath.compile("//*[@begin]").evaluate(document, XPathConstants.NODESET);
            long jMin = Long.MAX_VALUE;
            for (int i = 0; i < nodeList.getLength(); i++) {
                jMin = Math.min(TtmlHelpers.getStartTime(nodeList.item(i)), jMin);
            }
            return jMin;
        } catch (XPathExpressionException e) {
            throw new RuntimeException(e);
        }
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public String getHandler() {
        return "subt";
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public SampleDescriptionBox getSampleDescriptionBox() {
        return this.sampleDescriptionBox;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public long[] getSampleDurations() {
        int length = this.sampleDurations.length;
        long[] jArr = new long[length];
        for (int i = 0; i < length; i++) {
            jArr[i] = (this.sampleDurations[i] * this.trackMetaData.getTimescale()) / 1000;
        }
        return jArr;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public List<Sample> getSamples() {
        return this.samples;
    }

    @Override // com.googlecode.mp4parser.authoring.AbstractTrack, com.googlecode.mp4parser.authoring.Track
    public SubSampleInformationBox getSubsampleInformationBox() {
        return this.subSampleInformationBox;
    }

    @Override // com.googlecode.mp4parser.authoring.Track
    public TrackMetaData getTrackMetaData() {
        return this.trackMetaData;
    }

    public long lastTimestamp(Document document) {
        XPath xPathNewXPath = XPathFactory.newInstance().newXPath();
        xPathNewXPath.setNamespaceContext(TtmlHelpers.NAMESPACE_CONTEXT);
        try {
            NodeList nodeList = (NodeList) xPathNewXPath.compile("//*[@end]").evaluate(document, XPathConstants.NODESET);
            long jMax = 0;
            for (int i = 0; i < nodeList.getLength(); i++) {
                jMax = Math.max(TtmlHelpers.getEndTime(nodeList.item(i)), jMax);
            }
            return jMax;
        } catch (XPathExpressionException e) {
            throw new RuntimeException(e);
        }
    }
}
