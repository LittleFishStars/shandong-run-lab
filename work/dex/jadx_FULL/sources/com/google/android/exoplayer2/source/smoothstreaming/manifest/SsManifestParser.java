package com.google.android.exoplayer2.source.smoothstreaming.manifest;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.coremedia.iso.boxes.sampleentry.AudioSampleEntry;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.AacUtil;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.googlecode.mp4parser.boxes.AC3SpecificBox;
import com.googlecode.mp4parser.boxes.EC3SpecificBox;
import com.zj.adlib.en1;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;
import com.zj.adlib.u6a;
import com.zj.adlib.z99;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class SsManifestParser implements ParsingLoadable.Parser<com.google.android.exoplayer2.source.smoothstreaming.manifest.a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final u6a f30992a;

    public static abstract class ElementParser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final ElementParser f30993a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f4481a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final List<Pair<String, Object>> f4482a = new LinkedList();
        public final String b;

        public ElementParser(@Nullable ElementParser elementParser, String str, String str2) {
            this.f30993a = elementParser;
            this.f4481a = str;
            this.b = str2;
        }

        public final ElementParser a(ElementParser elementParser, String str, String str2) {
            if (b.c.equals(str)) {
                return new b(elementParser, str2);
            }
            if (a.c.equals(str)) {
                return new a(elementParser, str2);
            }
            if (d.h.equals(str)) {
                return new d(elementParser, str2);
            }
            return null;
        }

        public void addChild(Object obj) {
        }

        public final Object b(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
            boolean z = false;
            int i = 0;
            while (true) {
                int eventType = xmlPullParser.getEventType();
                if (eventType == 1) {
                    return null;
                }
                if (eventType == 2) {
                    String name = xmlPullParser.getName();
                    if (this.b.equals(name)) {
                        parseStartTag(xmlPullParser);
                        z = true;
                    } else if (z) {
                        if (i > 0) {
                            i++;
                        } else if (handleChildInline(name)) {
                            parseStartTag(xmlPullParser);
                        } else {
                            ElementParser elementParserA = a(this, name, this.f4481a);
                            if (elementParserA == null) {
                                i = 1;
                            } else {
                                addChild(elementParserA.b(xmlPullParser));
                            }
                        }
                    }
                } else if (eventType != 3) {
                    if (eventType == 4 && z && i == 0) {
                        parseText(xmlPullParser);
                    }
                } else if (!z) {
                    continue;
                } else if (i > 0) {
                    i--;
                } else {
                    String name2 = xmlPullParser.getName();
                    parseEndTag(xmlPullParser);
                    if (!handleChildInline(name2)) {
                        return build();
                    }
                }
                xmlPullParser.next();
            }
        }

        public abstract Object build();

        @Nullable
        public final Object getNormalizedAttribute(String str) {
            for (int i = 0; i < this.f4482a.size(); i++) {
                Pair<String, Object> pair = this.f4482a.get(i);
                if (((String) pair.first).equals(str)) {
                    return pair.second;
                }
            }
            ElementParser elementParser = this.f30993a;
            if (elementParser == null) {
                return null;
            }
            return elementParser.getNormalizedAttribute(str);
        }

        public boolean handleChildInline(String str) {
            return false;
        }

        public final boolean parseBoolean(XmlPullParser xmlPullParser, String str, boolean z) {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            return attributeValue != null ? Boolean.parseBoolean(attributeValue) : z;
        }

        public void parseEndTag(XmlPullParser xmlPullParser) {
        }

        public final int parseInt(XmlPullParser xmlPullParser, String str, int i) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                return i;
            }
            try {
                return Integer.parseInt(attributeValue);
            } catch (NumberFormatException e) {
                throw ParserException.createForMalformedManifest(null, e);
            }
        }

        public final long parseLong(XmlPullParser xmlPullParser, String str, long j) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                return j;
            }
            try {
                return Long.parseLong(attributeValue);
            } catch (NumberFormatException e) {
                throw ParserException.createForMalformedManifest(null, e);
            }
        }

        public final int parseRequiredInt(XmlPullParser xmlPullParser, String str) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                throw new MissingFieldException(str);
            }
            try {
                return Integer.parseInt(attributeValue);
            } catch (NumberFormatException e) {
                throw ParserException.createForMalformedManifest(null, e);
            }
        }

        public final long parseRequiredLong(XmlPullParser xmlPullParser, String str) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue == null) {
                throw new MissingFieldException(str);
            }
            try {
                return Long.parseLong(attributeValue);
            } catch (NumberFormatException e) {
                throw ParserException.createForMalformedManifest(null, e);
            }
        }

        public final String parseRequiredString(XmlPullParser xmlPullParser, String str) throws MissingFieldException {
            String attributeValue = xmlPullParser.getAttributeValue(null, str);
            if (attributeValue != null) {
                return attributeValue;
            }
            throw new MissingFieldException(str);
        }

        public void parseStartTag(XmlPullParser xmlPullParser) throws ParserException {
        }

        public void parseText(XmlPullParser xmlPullParser) {
        }

        public final void putNormalizedAttribute(String str, @Nullable Object obj) {
            this.f4482a.add(Pair.create(str, obj));
        }
    }

    public static class MissingFieldException extends ParserException {
        public MissingFieldException(String str) {
            super("Missing required field: " + str, null, true, 4);
        }
    }

    public static class a extends ElementParser {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f30994a = 8;
        public static final String c = "Protection";
        public static final String d = "ProtectionHeader";
        public static final String e = "SystemID";

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public UUID f4483a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f4484a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public byte[] f4485a;

        public a(ElementParser elementParser, String str) {
            super(elementParser, str, c);
        }

        public static z99[] c(byte[] bArr) {
            return new z99[]{new z99(true, null, 8, d(bArr), 0, 0, null)};
        }

        public static byte[] d(byte[] bArr) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bArr.length; i += 2) {
                sb.append((char) bArr[i]);
            }
            String string = sb.toString();
            byte[] bArrDecode = Base64.decode(string.substring(string.indexOf("<KID>") + 5, string.indexOf("</KID>")), 0);
            f(bArrDecode, 0, 3);
            f(bArrDecode, 1, 2);
            f(bArrDecode, 4, 5);
            f(bArrDecode, 6, 7);
            return bArrDecode;
        }

        public static String e(String str) {
            return (str.charAt(0) == '{' && str.charAt(str.length() - 1) == '}') ? str.substring(1, str.length() - 1) : str;
        }

        public static void f(byte[] bArr, int i, int i2) {
            byte b = bArr[i];
            bArr[i] = bArr[i2];
            bArr[i2] = b;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public Object build() {
            UUID uuid = this.f4483a;
            return new com.google.android.exoplayer2.source.smoothstreaming.manifest.a.C0693a(uuid, com.google.android.exoplayer2.extractor.mp4.c.a(uuid, this.f4485a), c(this.f4485a));
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public boolean handleChildInline(String str) {
            return d.equals(str);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void parseEndTag(XmlPullParser xmlPullParser) {
            if (d.equals(xmlPullParser.getName())) {
                this.f4484a = false;
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void parseStartTag(XmlPullParser xmlPullParser) {
            if (d.equals(xmlPullParser.getName())) {
                this.f4484a = true;
                this.f4483a = UUID.fromString(e(xmlPullParser.getAttributeValue(null, e)));
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void parseText(XmlPullParser xmlPullParser) {
            if (this.f4484a) {
                this.f4485a = Base64.decode(xmlPullParser.getText(), 0);
            }
        }
    }

    public static class b extends ElementParser {
        public static final String c = "QualityLevel";
        public static final String d = "Index";
        public static final String e = "Bitrate";
        public static final String f = "CodecPrivateData";
        public static final String g = "SamplingRate";
        public static final String h = "Channels";
        public static final String i = "FourCC";
        public static final String j = "Type";
        public static final String k = "Subtype";
        public static final String l = "Language";
        public static final String m = "Name";
        public static final String n = "MaxWidth";
        public static final String o = "MaxHeight";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public com.google.android.exoplayer2.d f30995a;

        public b(ElementParser elementParser, String str) {
            super(elementParser, str, c);
        }

        public static List<byte[]> c(String str) {
            ArrayList arrayList = new ArrayList();
            if (!TextUtils.isEmpty(str)) {
                byte[] bArrR = gj9.R(str);
                byte[][] bArrJ = en1.j(bArrR);
                if (bArrJ == null) {
                    arrayList.add(bArrR);
                } else {
                    Collections.addAll(arrayList, bArrJ);
                }
            }
            return arrayList;
        }

        @Nullable
        public static String d(String str) {
            if (str.equalsIgnoreCase(com.google.android.exoplayer2.source.rtsp.b.h) || str.equalsIgnoreCase("X264") || str.equalsIgnoreCase("AVC1") || str.equalsIgnoreCase("DAVC")) {
                return "video/avc";
            }
            if (str.equalsIgnoreCase("AAC") || str.equalsIgnoreCase("AACL") || str.equalsIgnoreCase("AACH") || str.equalsIgnoreCase("AACP")) {
                return "audio/mp4a-latm";
            }
            if (str.equalsIgnoreCase("TTML") || str.equalsIgnoreCase("DFXP")) {
                return "application/ttml+xml";
            }
            if (str.equalsIgnoreCase(AudioSampleEntry.TYPE8) || str.equalsIgnoreCase(AC3SpecificBox.TYPE)) {
                return "audio/ac3";
            }
            if (str.equalsIgnoreCase(AudioSampleEntry.TYPE9) || str.equalsIgnoreCase(EC3SpecificBox.TYPE)) {
                return "audio/eac3";
            }
            if (str.equalsIgnoreCase("dtsc")) {
                return "audio/vnd.dts";
            }
            if (str.equalsIgnoreCase(AudioSampleEntry.TYPE12) || str.equalsIgnoreCase(AudioSampleEntry.TYPE11)) {
                return "audio/vnd.dts.hd";
            }
            if (str.equalsIgnoreCase(AudioSampleEntry.TYPE13)) {
                return "audio/vnd.dts.hd;profile=lbr";
            }
            if (str.equalsIgnoreCase("opus")) {
                return "audio/opus";
            }
            return null;
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public Object build() {
            return this.f30995a;
        }

        /* JADX WARN: Code duplicated, block: B:27:0x00b0  */
        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void parseStartTag(XmlPullParser xmlPullParser) throws ParserException {
            int i2;
            com.google.android.exoplayer2.d.b bVar = new com.google.android.exoplayer2.d.b();
            String strD = d(parseRequiredString(xmlPullParser, i));
            int iIntValue = ((Integer) getNormalizedAttribute("Type")).intValue();
            if (iIntValue == 2) {
                bVar.K("video/mp4").j0(parseRequiredInt(xmlPullParser, "MaxWidth")).Q(parseRequiredInt(xmlPullParser, "MaxHeight")).T(c(xmlPullParser.getAttributeValue(null, f)));
            } else if (iIntValue == 1) {
                if (strD == null) {
                    strD = "audio/mp4a-latm";
                }
                int requiredInt = parseRequiredInt(xmlPullParser, h);
                int requiredInt2 = parseRequiredInt(xmlPullParser, g);
                List<byte[]> listC = c(xmlPullParser.getAttributeValue(null, f));
                if (listC.isEmpty() && "audio/mp4a-latm".equals(strD)) {
                    listC = Collections.singletonList(AacUtil.a(requiredInt2, requiredInt));
                }
                bVar.K("audio/mp4").H(requiredInt).f0(requiredInt2).T(listC);
            } else if (iIntValue == 3) {
                String str = (String) getNormalizedAttribute("Subtype");
                if (str == null) {
                    i2 = 0;
                } else if (str.equals("CAPT")) {
                    i2 = 64;
                } else if (str.equals("DESC")) {
                    i2 = 1024;
                } else {
                    i2 = 0;
                }
                bVar.K("application/mp4").c0(i2);
            } else {
                bVar.K("application/mp4");
            }
            this.f30995a = bVar.S(xmlPullParser.getAttributeValue(null, d)).U((String) getNormalizedAttribute("Name")).e0(strD).G(parseRequiredInt(xmlPullParser, "Bitrate")).V((String) getNormalizedAttribute("Language")).E();
        }
    }

    public static class c extends ElementParser {
        public static final String c = "SmoothStreamingMedia";
        public static final String d = "MajorVersion";
        public static final String e = "MinorVersion";
        public static final String f = "TimeScale";
        public static final String g = "DVRWindowLength";
        public static final String h = "Duration";
        public static final String i = "LookaheadCount";
        public static final String j = "IsLive";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f30996a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f4486a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public com.google.android.exoplayer2.source.smoothstreaming.manifest.a.C0693a f4487a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f4488a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public long f4489b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final List<com.google.android.exoplayer2.source.smoothstreaming.manifest.a.b> f4490b;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public int f4491c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public long f4492c;

        public c(ElementParser elementParser, String str) {
            super(elementParser, str, c);
            this.f4491c = -1;
            this.f4487a = null;
            this.f4490b = new LinkedList();
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void addChild(Object obj) {
            if (obj instanceof com.google.android.exoplayer2.source.smoothstreaming.manifest.a.b) {
                this.f4490b.add((com.google.android.exoplayer2.source.smoothstreaming.manifest.a.b) obj);
            } else if (obj instanceof com.google.android.exoplayer2.source.smoothstreaming.manifest.a.C0693a) {
                sb0.i(this.f4487a == null);
                this.f4487a = (com.google.android.exoplayer2.source.smoothstreaming.manifest.a.C0693a) obj;
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public Object build() {
            int size = this.f4490b.size();
            com.google.android.exoplayer2.source.smoothstreaming.manifest.a.b[] bVarArr = new com.google.android.exoplayer2.source.smoothstreaming.manifest.a.b[size];
            this.f4490b.toArray(bVarArr);
            if (this.f4487a != null) {
                com.google.android.exoplayer2.source.smoothstreaming.manifest.a.C0693a c0693a = this.f4487a;
                DrmInitData drmInitData = new DrmInitData(new DrmInitData.SchemeData(c0693a.f30999a, "video/mp4", c0693a.f4505a));
                for (int i2 = 0; i2 < size; i2++) {
                    com.google.android.exoplayer2.source.smoothstreaming.manifest.a.b bVar = bVarArr[i2];
                    int i3 = bVar.f31000a;
                    if (i3 == 2 || i3 == 1) {
                        com.google.android.exoplayer2.d[] dVarArr = bVar.f4511a;
                        for (int i4 = 0; i4 < dVarArr.length; i4++) {
                            dVarArr[i4] = dVarArr[i4].b().M(drmInitData).E();
                        }
                    }
                }
            }
            return new com.google.android.exoplayer2.source.smoothstreaming.manifest.a(this.f30996a, this.b, this.f4486a, this.f4489b, this.f4492c, this.f4491c, this.f4488a, this.f4487a, bVarArr);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void parseStartTag(XmlPullParser xmlPullParser) throws ParserException {
            this.f30996a = parseRequiredInt(xmlPullParser, d);
            this.b = parseRequiredInt(xmlPullParser, e);
            this.f4486a = parseLong(xmlPullParser, "TimeScale", 10000000L);
            this.f4489b = parseRequiredLong(xmlPullParser, "Duration");
            this.f4492c = parseLong(xmlPullParser, g, 0L);
            this.f4491c = parseInt(xmlPullParser, i, -1);
            this.f4488a = parseBoolean(xmlPullParser, j, false);
            putNormalizedAttribute("TimeScale", Long.valueOf(this.f4486a));
        }
    }

    public static class d extends ElementParser {
        public static final String h = "StreamIndex";
        public static final String i = "c";
        public static final String j = "Type";
        public static final String k = "audio";
        public static final String l = "video";
        public static final String m = "text";
        public static final String n = "Subtype";
        public static final String o = "Name";
        public static final String p = "Url";
        public static final String q = "MaxWidth";
        public static final String r = "MaxHeight";
        public static final String s = "DisplayWidth";
        public static final String t = "DisplayHeight";
        public static final String u = "Language";
        public static final String v = "TimeScale";
        public static final String w = "d";
        public static final String x = "t";
        public static final String y = "r";

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f30997a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f4493a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public ArrayList<Long> f4494a;
        public int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public long f4495b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final List<com.google.android.exoplayer2.d> f4496b;
        public int c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public final String f4497c;
        public int d;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public String f4498d;
        public int e;

        /* JADX INFO: renamed from: e, reason: collision with other field name */
        public String f4499e;
        public String f;
        public String g;

        public d(ElementParser elementParser, String str) {
            super(elementParser, str, h);
            this.f4497c = str;
            this.f4496b = new LinkedList();
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void addChild(Object obj) {
            if (obj instanceof com.google.android.exoplayer2.d) {
                this.f4496b.add((com.google.android.exoplayer2.d) obj);
            }
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public Object build() {
            com.google.android.exoplayer2.d[] dVarArr = new com.google.android.exoplayer2.d[this.f4496b.size()];
            this.f4496b.toArray(dVarArr);
            return new com.google.android.exoplayer2.source.smoothstreaming.manifest.a.b(this.f4497c, this.f, this.f30997a, this.f4498d, this.f4493a, this.f4499e, this.b, this.c, this.d, this.e, this.g, dVarArr, this.f4494a, this.f4495b);
        }

        public final void c(XmlPullParser xmlPullParser) throws ParserException {
            int iE = e(xmlPullParser);
            this.f30997a = iE;
            putNormalizedAttribute("Type", Integer.valueOf(iE));
            if (this.f30997a == 3) {
                this.f4498d = parseRequiredString(xmlPullParser, "Subtype");
            } else {
                this.f4498d = xmlPullParser.getAttributeValue(null, "Subtype");
            }
            putNormalizedAttribute("Subtype", this.f4498d);
            String attributeValue = xmlPullParser.getAttributeValue(null, "Name");
            this.f4499e = attributeValue;
            putNormalizedAttribute("Name", attributeValue);
            this.f = parseRequiredString(xmlPullParser, p);
            this.b = parseInt(xmlPullParser, "MaxWidth", -1);
            this.c = parseInt(xmlPullParser, "MaxHeight", -1);
            this.d = parseInt(xmlPullParser, s, -1);
            this.e = parseInt(xmlPullParser, t, -1);
            String attributeValue2 = xmlPullParser.getAttributeValue(null, "Language");
            this.g = attributeValue2;
            putNormalizedAttribute("Language", attributeValue2);
            long j2 = parseInt(xmlPullParser, "TimeScale", -1);
            this.f4493a = j2;
            if (j2 == -1) {
                this.f4493a = ((Long) getNormalizedAttribute("TimeScale")).longValue();
            }
            this.f4494a = new ArrayList<>();
        }

        public final void d(XmlPullParser xmlPullParser) throws ParserException {
            int size = this.f4494a.size();
            long jLongValue = parseLong(xmlPullParser, "t", -9223372036854775807L);
            int i2 = 1;
            if (jLongValue == -9223372036854775807L) {
                if (size == 0) {
                    jLongValue = 0;
                } else {
                    if (this.f4495b == -1) {
                        throw ParserException.createForMalformedManifest("Unable to infer start time", null);
                    }
                    jLongValue = this.f4495b + this.f4494a.get(size - 1).longValue();
                }
            }
            this.f4494a.add(Long.valueOf(jLongValue));
            this.f4495b = parseLong(xmlPullParser, "d", -9223372036854775807L);
            long j2 = parseLong(xmlPullParser, "r", 1L);
            if (j2 > 1 && this.f4495b == -9223372036854775807L) {
                throw ParserException.createForMalformedManifest("Repeated chunk with unspecified duration", null);
            }
            while (true) {
                long j3 = i2;
                if (j3 >= j2) {
                    return;
                }
                this.f4494a.add(Long.valueOf((this.f4495b * j3) + jLongValue));
                i2++;
            }
        }

        public final int e(XmlPullParser xmlPullParser) throws ParserException {
            String attributeValue = xmlPullParser.getAttributeValue(null, "Type");
            if (attributeValue == null) {
                throw new MissingFieldException("Type");
            }
            if ("audio".equalsIgnoreCase(attributeValue)) {
                return 1;
            }
            if ("video".equalsIgnoreCase(attributeValue)) {
                return 2;
            }
            if ("text".equalsIgnoreCase(attributeValue)) {
                return 3;
            }
            throw ParserException.createForMalformedManifest("Invalid key value[" + attributeValue + "]", null);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public boolean handleChildInline(String str) {
            return "c".equals(str);
        }

        @Override // com.google.android.exoplayer2.source.smoothstreaming.manifest.SsManifestParser.ElementParser
        public void parseStartTag(XmlPullParser xmlPullParser) throws ParserException {
            if ("c".equals(xmlPullParser.getName())) {
                d(xmlPullParser);
            } else {
                c(xmlPullParser);
            }
        }
    }

    public SsManifestParser() {
        try {
            this.f30992a = u6a.d();
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public com.google.android.exoplayer2.source.smoothstreaming.manifest.a parse(Uri uri, InputStream inputStream) throws IOException {
        try {
            XmlPullParser xmlPullParserF = this.f30992a.f();
            xmlPullParserF.setInput(inputStream, null);
            return (com.google.android.exoplayer2.source.smoothstreaming.manifest.a) new c(null, uri.toString()).b(xmlPullParserF);
        } catch (XmlPullParserException e) {
            throw ParserException.createForMalformedManifest(null, e);
        }
    }
}
