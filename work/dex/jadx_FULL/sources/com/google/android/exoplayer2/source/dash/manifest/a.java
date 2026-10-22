package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import android.util.Xml;
import androidx.annotation.Nullable;
import com.aliyun.auth.core.AliyunVodKey;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.mp4.c;
import com.google.android.exoplayer2.metadata.emsg.EventMessage;
import com.google.android.exoplayer2.source.rtsp.i;
import com.google.android.exoplayer2.upstream.ParsingLoadable;
import com.google.android.exoplayer2.util.Log;
import com.google.common.base.b;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.huachenjie.run.page.activities_run.dialog.MoreDistanceDialog;
import com.zj.adlib.bp5;
import com.zj.adlib.c49;
import com.zj.adlib.c62;
import com.zj.adlib.c68;
import com.zj.adlib.dv9;
import com.zj.adlib.eo6;
import com.zj.adlib.f17;
import com.zj.adlib.gj9;
import com.zj.adlib.ka7;
import com.zj.adlib.rh9;
import com.zj.adlib.rk2;
import com.zj.adlib.s53;
import com.zj.adlib.sb0;
import com.zj.adlib.u6a;
import com.zj.adlib.vr0;
import com.zj.adlib.vz;
import com.zj.adlib.x6a;
import com.zj.adlib.yi9;
import com.zj.adlib.zh9;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlSerializer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class a extends DefaultHandler implements ParsingLoadable.Parser<c62> {
    public static final String f = "MpdParser";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final u6a f3993a;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Pattern f30899a = Pattern.compile("(\\d+)(?:/(\\d+))?");
    public static final Pattern b = Pattern.compile("CC([1-4])=.*");
    public static final Pattern c = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[] f3992a = {-1, 1, 2, 3, 4, 5, 6, 8, 2, 3, 4, 7, 8, 24, 8, 12, 10, 12, 14, 12, 14};

    /* JADX INFO: renamed from: com.google.android.exoplayer2.source.dash.manifest.a$a, reason: collision with other inner class name */
    public static final class C0689a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f30900a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final d f3994a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final SegmentBase f3995a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ImmutableList<vr0> f3996a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final String f3997a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ArrayList<DrmInitData.SchemeData> f3998a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final List<rk2> f3999a;
        public final ArrayList<rk2> b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final List<rk2> f4000b;

        public C0689a(d dVar, List<vr0> list, SegmentBase segmentBase, @Nullable String str, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<rk2> arrayList2, List<rk2> list2, List<rk2> list3, long j) {
            this.f3994a = dVar;
            this.f3996a = ImmutableList.copyOf((Collection) list);
            this.f3995a = segmentBase;
            this.f3997a = str;
            this.f3998a = arrayList;
            this.b = arrayList2;
            this.f3999a = list2;
            this.f4000b = list3;
            this.f30900a = j;
        }
    }

    public a() {
        try {
            this.f3993a = u6a.d();
        } catch (XmlPullParserException e) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e);
        }
    }

    public static int b(int i, int i2) {
        if (i == -1) {
            return i2;
        }
        if (i2 == -1) {
            return i;
        }
        sb0.i(i == i2);
        return i;
    }

    @Nullable
    public static String c(@Nullable String str, @Nullable String str2) {
        if (str == null) {
            return str2;
        }
        if (str2 == null) {
            return str;
        }
        sb0.i(str.equals(str2));
        return str;
    }

    public static void e(ArrayList<DrmInitData.SchemeData> arrayList) {
        String str;
        int i = 0;
        while (true) {
            if (i >= arrayList.size()) {
                str = null;
                break;
            }
            DrmInitData.SchemeData schemeData = arrayList.get(i);
            if (C.f2002c.equals(schemeData.uuid) && (str = schemeData.licenseServerUrl) != null) {
                arrayList.remove(i);
                break;
            }
            i++;
        }
        if (str == null) {
            return;
        }
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            DrmInitData.SchemeData schemeData2 = arrayList.get(i2);
            if (C.f1999b.equals(schemeData2.uuid) && schemeData2.licenseServerUrl == null) {
                arrayList.set(i2, new DrmInitData.SchemeData(C.f2002c, str, schemeData2.mimeType, schemeData2.data));
            }
        }
    }

    public static void f(ArrayList<DrmInitData.SchemeData> arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            DrmInitData.SchemeData schemeData = arrayList.get(size);
            if (!schemeData.hasData()) {
                for (int i = 0; i < arrayList.size(); i++) {
                    if (arrayList.get(i).canReplace(schemeData)) {
                        arrayList.remove(size);
                        break;
                    }
                }
            }
        }
    }

    public static long g(long j, long j2) {
        if (j2 != -9223372036854775807L) {
            j = j2;
        }
        if (j == Long.MAX_VALUE) {
            return -9223372036854775807L;
        }
        return j;
    }

    @Nullable
    public static String h(@Nullable String str, @Nullable String str2) {
        if (bp5.p(str)) {
            return bp5.c(str2);
        }
        if (bp5.t(str)) {
            return bp5.o(str2);
        }
        if (bp5.s(str) || bp5.q(str)) {
            return str;
        }
        if (!"application/mp4".equals(str)) {
            return null;
        }
        String strG = bp5.g(str2);
        return "text/vtt".equals(strG) ? "application/x-mp4-vtt" : strG;
    }

    public static void j(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        if (x6a.e(xmlPullParser)) {
            int i = 1;
            while (i != 0) {
                xmlPullParser.next();
                if (x6a.e(xmlPullParser)) {
                    i++;
                } else if (x6a.c(xmlPullParser)) {
                    i--;
                }
            }
        }
    }

    public static int parseCea608AccessibilityChannel(List<rk2> list) {
        String str;
        for (int i = 0; i < list.size(); i++) {
            rk2 rk2Var = list.get(i);
            if ("urn:scte:dash:cc:cea-608:2015".equals(rk2Var.f44473a) && (str = rk2Var.b) != null) {
                Matcher matcher = b.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                Log.n(f, "Unable to parse CEA-608 channel number from: " + rk2Var.b);
            }
        }
        return -1;
    }

    public static int parseCea708AccessibilityChannel(List<rk2> list) {
        String str;
        for (int i = 0; i < list.size(); i++) {
            rk2 rk2Var = list.get(i);
            if ("urn:scte:dash:cc:cea-708:2015".equals(rk2Var.f44473a) && (str = rk2Var.b) != null) {
                Matcher matcher = c.matcher(str);
                if (matcher.matches()) {
                    return Integer.parseInt(matcher.group(1));
                }
                Log.n(f, "Unable to parse CEA-708 service block number from: " + rk2Var.b);
            }
        }
        return -1;
    }

    public static long parseDateTime(XmlPullParser xmlPullParser, String str, long j) throws ParserException {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j : gj9.h1(attributeValue);
    }

    public static rk2 parseDescriptor(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String string = parseString(xmlPullParser, "schemeIdUri", "");
        String string2 = parseString(xmlPullParser, "value", null);
        String string3 = parseString(xmlPullParser, "id", null);
        do {
            xmlPullParser.next();
        } while (!x6a.d(xmlPullParser, str));
        return new rk2(string, string2, string3);
    }

    public static int parseDolbyChannelConfiguration(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "value");
        if (attributeValue == null) {
            return -1;
        }
        String strG = com.google.common.base.a.g(attributeValue);
        strG.hashCode();
        switch (strG) {
            case "4000":
                return 1;
            case "a000":
                return 2;
            case "f801":
                return 6;
            case "fa01":
                return 8;
            default:
                return -1;
        }
    }

    public static int parseDtsChannelConfiguration(XmlPullParser xmlPullParser) {
        int i = parseInt(xmlPullParser, "value", -1);
        if (i <= 0 || i >= 33) {
            return -1;
        }
        return i;
    }

    public static int parseDtsxChannelConfiguration(XmlPullParser xmlPullParser) {
        int iBitCount;
        String attributeValue = xmlPullParser.getAttributeValue(null, "value");
        if (attributeValue == null || (iBitCount = Integer.bitCount(Integer.parseInt(attributeValue, 16))) == 0) {
            return -1;
        }
        return iBitCount;
    }

    public static long parseDuration(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j : gj9.i1(attributeValue);
    }

    public static String parseEac3SupplementalProperties(List<rk2> list) {
        for (int i = 0; i < list.size(); i++) {
            rk2 rk2Var = list.get(i);
            String str = rk2Var.f44473a;
            if ("tag:dolby.com,2018:dash:EC3_ExtensionType:2018".equals(str) && "JOC".equals(rk2Var.b)) {
                return "audio/eac3-joc";
            }
            if ("tag:dolby.com,2014:dash:DolbyDigitalPlusExtensionType:2014".equals(str) && "ec+3".equals(rk2Var.b)) {
                return "audio/eac3-joc";
            }
        }
        return "audio/eac3";
    }

    public static float parseFloat(XmlPullParser xmlPullParser, String str, float f2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? f2 : Float.parseFloat(attributeValue);
    }

    public static float parseFrameRate(XmlPullParser xmlPullParser, float f2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "frameRate");
        if (attributeValue == null) {
            return f2;
        }
        Matcher matcher = f30899a.matcher(attributeValue);
        if (!matcher.matches()) {
            return f2;
        }
        int i = Integer.parseInt(matcher.group(1));
        String strGroup = matcher.group(2);
        return !TextUtils.isEmpty(strGroup) ? i / Integer.parseInt(strGroup) : i;
    }

    public static int parseInt(XmlPullParser xmlPullParser, String str, int i) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? i : Integer.parseInt(attributeValue);
    }

    public static long parseLastSegmentNumberSupplementalProperty(List<rk2> list) {
        for (int i = 0; i < list.size(); i++) {
            rk2 rk2Var = list.get(i);
            if (com.google.common.base.a.a("http://dashif.org/guidelines/last-segment-number", rk2Var.f44473a)) {
                return Long.parseLong(rk2Var.b);
            }
        }
        return -1L;
    }

    public static long parseLong(XmlPullParser xmlPullParser, String str, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? j : Long.parseLong(attributeValue);
    }

    public static int parseMpegChannelConfiguration(XmlPullParser xmlPullParser) {
        int i = parseInt(xmlPullParser, "value", -1);
        if (i < 0) {
            return -1;
        }
        int[] iArr = f3992a;
        if (i < iArr.length) {
            return iArr[i];
        }
        return -1;
    }

    public static String parseString(XmlPullParser xmlPullParser, String str, String str2) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? str2 : attributeValue;
    }

    public static String parseText(XmlPullParser xmlPullParser, String str) throws XmlPullParserException, IOException {
        String text = "";
        do {
            xmlPullParser.next();
            if (xmlPullParser.getEventType() == 4) {
                text = xmlPullParser.getText();
            } else {
                j(xmlPullParser);
            }
        } while (!x6a.d(xmlPullParser, str));
        return text;
    }

    public final long a(List<SegmentBase.c> list, long j, long j2, int i, long j3) {
        int iN = i >= 0 ? i + 1 : (int) gj9.n(j3 - j, j2);
        for (int i2 = 0; i2 < iN; i2++) {
            list.add(buildSegmentTimelineElement(j, j2));
            j += j2;
        }
        return j;
    }

    public vz buildAdaptationSet(int i, int i2, List<Representation> list, List<rk2> list2, List<rk2> list3, List<rk2> list4) {
        return new vz(i, i2, list, list2, list3, list4);
    }

    public EventMessage buildEvent(String str, String str2, long j, long j2, byte[] bArr) {
        return new EventMessage(str, str2, j2, j, bArr);
    }

    public s53 buildEventStream(String str, String str2, long j, long[] jArr, EventMessage[] eventMessageArr) {
        return new s53(str, str2, j, jArr, eventMessageArr);
    }

    public d buildFormat(@Nullable String str, @Nullable String str2, int i, int i2, float f2, int i3, int i4, int i5, @Nullable String str3, List<rk2> list, List<rk2> list2, @Nullable String str4, List<rk2> list3, List<rk2> list4) {
        int cea708AccessibilityChannel;
        String str5 = str4;
        String strH = h(str2, str5);
        if ("audio/eac3".equals(strH)) {
            strH = parseEac3SupplementalProperties(list4);
            if ("audio/eac3-joc".equals(strH)) {
                str5 = "ec+3";
            }
        }
        d.b bVarV = new d.b().S(str).K(str2).e0(strH).I(str5).Z(i5).g0(parseSelectionFlagsFromRoleDescriptors(list)).c0(parseRoleFlagsFromRoleDescriptors(list) | parseRoleFlagsFromAccessibilityDescriptors(list2) | parseRoleFlagsFromProperties(list3) | parseRoleFlagsFromProperties(list4)).V(str3);
        if (bp5.t(strH)) {
            bVarV.j0(i).Q(i2).P(f2);
        } else if (bp5.p(strH)) {
            bVarV.H(i3).f0(i4);
        } else if (bp5.s(strH)) {
            if ("application/cea-608".equals(strH)) {
                cea708AccessibilityChannel = parseCea608AccessibilityChannel(list2);
            } else {
                cea708AccessibilityChannel = "application/cea-708".equals(strH) ? parseCea708AccessibilityChannel(list2) : -1;
            }
            bVarV.F(cea708AccessibilityChannel);
        } else if (bp5.q(strH)) {
            bVarV.j0(i).Q(i2);
        }
        return bVarV.E();
    }

    public c62 buildMediaPresentationDescription(long j, long j2, long j3, boolean z, long j4, long j5, long j6, long j7, @Nullable f17 f17Var, @Nullable yi9 yi9Var, @Nullable c68 c68Var, @Nullable Uri uri, List<eo6> list) {
        return new c62(j, j2, j3, z, j4, j5, j6, j7, f17Var, yi9Var, c68Var, uri, list);
    }

    public eo6 buildPeriod(@Nullable String str, long j, List<vz> list, List<s53> list2, @Nullable rk2 rk2Var) {
        return new eo6(str, j, list, list2, rk2Var);
    }

    public ka7 buildRangedUri(String str, long j, long j2) {
        return new ka7(str, j, j2);
    }

    public Representation buildRepresentation(C0689a c0689a, @Nullable String str, @Nullable String str2, ArrayList<DrmInitData.SchemeData> arrayList, ArrayList<rk2> arrayList2) {
        d.b bVarB = c0689a.f3994a.b();
        if (str != null) {
            bVarB.U(str);
        }
        String str3 = c0689a.f3997a;
        if (str3 != null) {
            str2 = str3;
        }
        ArrayList<DrmInitData.SchemeData> arrayList3 = c0689a.f3998a;
        arrayList3.addAll(arrayList);
        if (!arrayList3.isEmpty()) {
            e(arrayList3);
            f(arrayList3);
            bVarB.M(new DrmInitData(str2, arrayList3));
        }
        ArrayList<rk2> arrayList4 = c0689a.b;
        arrayList4.addAll(arrayList2);
        return Representation.o(c0689a.f30900a, bVarB.E(), c0689a.f3996a, c0689a.f3995a, arrayList4, c0689a.f3999a, c0689a.f4000b, null);
    }

    public SegmentBase.a buildSegmentList(ka7 ka7Var, long j, long j2, long j3, long j4, @Nullable List<SegmentBase.c> list, long j5, @Nullable List<ka7> list2, long j6, long j7) {
        return new SegmentBase.a(ka7Var, j, j2, j3, j4, list, j5, list2, gj9.Z0(j6), gj9.Z0(j7));
    }

    public SegmentBase.b buildSegmentTemplate(ka7 ka7Var, long j, long j2, long j3, long j4, long j5, List<SegmentBase.c> list, long j6, @Nullable zh9 zh9Var, @Nullable zh9 zh9Var2, long j7, long j8) {
        return new SegmentBase.b(ka7Var, j, j2, j3, j4, j5, list, j6, zh9Var, zh9Var2, gj9.Z0(j7), gj9.Z0(j8));
    }

    public SegmentBase.c buildSegmentTimelineElement(long j, long j2) {
        return new SegmentBase.c(j, j2);
    }

    public SegmentBase.d buildSingleSegmentBase(ka7 ka7Var, long j, long j2, long j3, long j4) {
        return new SegmentBase.d(ka7Var, j, j2, j3, j4);
    }

    public yi9 buildUtcTimingElement(String str, String str2) {
        return new yi9(str, str2);
    }

    public final boolean i(String[] strArr) {
        for (String str : strArr) {
            if (str.startsWith("urn:dvb:dash:profile:dvb-dash:")) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.upstream.ParsingLoadable.Parser
    /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
    public c62 parse(Uri uri, InputStream inputStream) throws IOException {
        try {
            XmlPullParser xmlPullParserF = this.f3993a.f();
            xmlPullParserF.setInput(inputStream, null);
            if (xmlPullParserF.next() == 2 && "MPD".equals(xmlPullParserF.getName())) {
                return parseMediaPresentationDescription(xmlPullParserF, uri);
            }
            throw ParserException.createForMalformedManifest("inputStream does not contain a valid media presentation description", null);
        } catch (XmlPullParserException e) {
            throw ParserException.createForMalformedManifest(null, e);
        }
    }

    /* JADX WARN: Code duplicated, block: B:71:0x030e A[LOOP:0: B:3:0x007c->B:71:0x030e, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:72:0x02ce A[EDGE_INSN: B:72:0x02ce->B:65:0x02ce BREAK  A[LOOP:0: B:3:0x007c->B:71:0x030e], SYNTHETIC] */
    public vz parseAdaptationSet(XmlPullParser xmlPullParser, List<vr0> list, @Nullable SegmentBase segmentBase, long j, long j2, long j3, long j4, long j5, boolean z) throws XmlPullParserException, IOException {
        long j6;
        ArrayList<rk2> arrayList;
        Object obj;
        long j7;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        String strC;
        ArrayList arrayList6;
        int iB;
        ArrayList<rk2> arrayList7;
        long availabilityTimeOffsetUs;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        int i = parseInt(xmlPullParser2, "id", -1);
        int contentType = parseContentType(xmlPullParser);
        String attributeValue = xmlPullParser2.getAttributeValue(null, "mimeType");
        String attributeValue2 = xmlPullParser2.getAttributeValue(null, "codecs");
        int i2 = parseInt(xmlPullParser2, "width", -1);
        int i3 = parseInt(xmlPullParser2, "height", -1);
        float frameRate = parseFrameRate(xmlPullParser2, -1.0f);
        int i4 = parseInt(xmlPullParser2, "audioSamplingRate", -1);
        String str = dv9.h;
        String attributeValue3 = xmlPullParser2.getAttributeValue(null, dv9.h);
        String attributeValue4 = xmlPullParser2.getAttributeValue(null, "label");
        ArrayList<DrmInitData.SchemeData> arrayList8 = new ArrayList<>();
        ArrayList<rk2> arrayList9 = new ArrayList<>();
        ArrayList arrayList10 = new ArrayList();
        ArrayList arrayList11 = new ArrayList();
        ArrayList arrayList12 = new ArrayList();
        ArrayList arrayList13 = new ArrayList();
        ArrayList arrayList14 = new ArrayList();
        ArrayList arrayList15 = new ArrayList();
        SegmentBase segmentTemplate = segmentBase;
        int i5 = contentType;
        int audioChannelConfiguration = -1;
        String str2 = attributeValue3;
        String label = attributeValue4;
        String str3 = null;
        boolean z2 = false;
        long availabilityTimeOffsetUs2 = j2;
        long j8 = j3;
        while (true) {
            xmlPullParser.next();
            if (x6a.f(xmlPullParser2, "BaseURL")) {
                if (!z2) {
                    availabilityTimeOffsetUs2 = parseAvailabilityTimeOffsetUs(xmlPullParser2, availabilityTimeOffsetUs2);
                    z2 = true;
                }
                j6 = j8;
                arrayList = arrayList9;
                arrayList15.addAll(parseBaseUrl(xmlPullParser2, list, z));
            } else {
                j6 = j8;
                arrayList = arrayList9;
                if (x6a.f(xmlPullParser2, "ContentProtection")) {
                    Pair<String, DrmInitData.SchemeData> contentProtection = parseContentProtection(xmlPullParser);
                    Object obj2 = contentProtection.first;
                    if (obj2 != null) {
                        str3 = (String) obj2;
                    }
                    Object obj3 = contentProtection.second;
                    if (obj3 != null) {
                        arrayList8.add((DrmInitData.SchemeData) obj3);
                    }
                } else {
                    if (x6a.f(xmlPullParser2, "ContentComponent")) {
                        strC = c(str2, xmlPullParser2.getAttributeValue(null, str));
                        obj = null;
                        j7 = availabilityTimeOffsetUs2;
                        arrayList6 = arrayList14;
                        arrayList2 = arrayList13;
                        arrayList3 = arrayList12;
                        arrayList4 = arrayList11;
                        arrayList5 = arrayList10;
                        iB = b(i5, parseContentType(xmlPullParser));
                        arrayList7 = arrayList;
                    } else {
                        int i6 = i5;
                        String str4 = str2;
                        if (x6a.f(xmlPullParser2, "Role")) {
                            arrayList11.add(parseDescriptor(xmlPullParser2, "Role"));
                        } else if (x6a.f(xmlPullParser2, "AudioChannelConfiguration")) {
                            audioChannelConfiguration = parseAudioChannelConfiguration(xmlPullParser);
                        } else if (x6a.f(xmlPullParser2, "Accessibility")) {
                            arrayList10.add(parseDescriptor(xmlPullParser2, "Accessibility"));
                        } else if (x6a.f(xmlPullParser2, "EssentialProperty")) {
                            arrayList12.add(parseDescriptor(xmlPullParser2, "EssentialProperty"));
                        } else if (x6a.f(xmlPullParser2, "SupplementalProperty")) {
                            arrayList13.add(parseDescriptor(xmlPullParser2, "SupplementalProperty"));
                        } else if (x6a.f(xmlPullParser2, "Representation")) {
                            j7 = availabilityTimeOffsetUs2;
                            arrayList2 = arrayList13;
                            arrayList3 = arrayList12;
                            arrayList4 = arrayList11;
                            arrayList5 = arrayList10;
                            obj = null;
                            strC = str4;
                            C0689a representation = parseRepresentation(xmlPullParser, !arrayList15.isEmpty() ? arrayList15 : list, attributeValue, attributeValue2, i2, i3, frameRate, audioChannelConfiguration, i4, str4, arrayList4, arrayList5, arrayList3, arrayList2, segmentTemplate, j4, j, j7, j6, j5, z);
                            int iB2 = b(i6, bp5.l(representation.f3994a.k));
                            arrayList6 = arrayList14;
                            arrayList6.add(representation);
                            xmlPullParser2 = xmlPullParser;
                            iB = iB2;
                            arrayList7 = arrayList;
                        } else {
                            obj = null;
                            j7 = availabilityTimeOffsetUs2;
                            arrayList15 = arrayList15;
                            arrayList2 = arrayList13;
                            arrayList3 = arrayList12;
                            arrayList4 = arrayList11;
                            arrayList5 = arrayList10;
                            arrayList8 = arrayList8;
                            str = str;
                            strC = str4;
                            arrayList6 = arrayList14;
                            xmlPullParser2 = xmlPullParser;
                            if (x6a.f(xmlPullParser2, "SegmentBase")) {
                                segmentTemplate = parseSegmentBase(xmlPullParser2, (SegmentBase.d) segmentTemplate);
                                iB = i6;
                                arrayList7 = arrayList;
                                j8 = j6;
                                xmlPullParser2 = xmlPullParser2;
                            } else {
                                if (x6a.f(xmlPullParser2, "SegmentList")) {
                                    availabilityTimeOffsetUs = parseAvailabilityTimeOffsetUs(xmlPullParser2, j6);
                                    iB = i6;
                                    segmentTemplate = parseSegmentList(xmlPullParser, (SegmentBase.a) segmentTemplate, j4, j, j7, availabilityTimeOffsetUs, j5);
                                } else {
                                    j8 = j6;
                                    iB = i6;
                                    if (x6a.f(xmlPullParser2, "SegmentTemplate")) {
                                        availabilityTimeOffsetUs = parseAvailabilityTimeOffsetUs(xmlPullParser2, j8);
                                        segmentTemplate = parseSegmentTemplate(xmlPullParser, (SegmentBase.b) segmentTemplate, arrayList2, j4, j, j7, availabilityTimeOffsetUs, j5);
                                    } else {
                                        xmlPullParser2 = xmlPullParser2;
                                        if (x6a.f(xmlPullParser2, "InbandEventStream")) {
                                            arrayList7 = arrayList;
                                            arrayList7.add(parseDescriptor(xmlPullParser2, "InbandEventStream"));
                                        } else {
                                            arrayList7 = arrayList;
                                            if (x6a.f(xmlPullParser2, "Label")) {
                                                label = parseLabel(xmlPullParser);
                                            } else if (x6a.e(xmlPullParser)) {
                                                parseAdaptationSetChild(xmlPullParser);
                                            }
                                        }
                                    }
                                }
                                j8 = availabilityTimeOffsetUs;
                                arrayList7 = arrayList;
                            }
                        }
                        obj = null;
                        j7 = availabilityTimeOffsetUs2;
                        arrayList15 = arrayList15;
                        arrayList2 = arrayList13;
                        arrayList3 = arrayList12;
                        arrayList4 = arrayList11;
                        arrayList5 = arrayList10;
                        arrayList8 = arrayList8;
                        str = str;
                        iB = i6;
                        strC = str4;
                        arrayList7 = arrayList;
                        j8 = j6;
                        arrayList6 = arrayList14;
                    }
                    j8 = j6;
                }
                if (x6a.d(xmlPullParser2, "AdaptationSet")) {
                    break;
                }
                arrayList9 = arrayList7;
                arrayList14 = arrayList6;
                arrayList15 = arrayList15;
                arrayList13 = arrayList2;
                availabilityTimeOffsetUs2 = j7;
                arrayList12 = arrayList3;
                arrayList11 = arrayList4;
                arrayList10 = arrayList5;
                arrayList8 = arrayList8;
                str = str;
                i5 = iB;
                str2 = strC;
            }
            j8 = j6;
            j7 = availabilityTimeOffsetUs2;
            arrayList6 = arrayList14;
            arrayList3 = arrayList12;
            arrayList4 = arrayList11;
            arrayList5 = arrayList10;
            arrayList8 = arrayList8;
            str = str;
            arrayList7 = arrayList;
            iB = i5;
            strC = str2;
            obj = null;
            arrayList15 = arrayList15;
            arrayList2 = arrayList13;
            if (x6a.d(xmlPullParser2, "AdaptationSet")) {
                break;
                break;
            }
            arrayList9 = arrayList7;
            arrayList14 = arrayList6;
            arrayList15 = arrayList15;
            arrayList13 = arrayList2;
            availabilityTimeOffsetUs2 = j7;
            arrayList12 = arrayList3;
            arrayList11 = arrayList4;
            arrayList10 = arrayList5;
            arrayList8 = arrayList8;
            str = str;
            i5 = iB;
            str2 = strC;
        }
        List<Representation> arrayList16 = new ArrayList<>(arrayList6.size());
        for (int i7 = 0; i7 < arrayList6.size(); i7++) {
            arrayList16.add(buildRepresentation((C0689a) arrayList6.get(i7), label, str3, arrayList8, arrayList7));
        }
        return buildAdaptationSet(i, iB, arrayList16, arrayList5, arrayList3, arrayList2);
    }

    public void parseAdaptationSetChild(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        j(xmlPullParser);
    }

    public int parseAudioChannelConfiguration(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String string = parseString(xmlPullParser, "schemeIdUri", null);
        string.hashCode();
        int dtsChannelConfiguration = -1;
        switch (string) {
            case "urn:dts:dash:audio_channel_configuration:2012":
            case "tag:dts.com,2014:dash:audio_channel_configuration:2012":
                dtsChannelConfiguration = parseDtsChannelConfiguration(xmlPullParser);
                break;
            case "urn:mpeg:dash:23003:3:audio_channel_configuration:2011":
                dtsChannelConfiguration = parseInt(xmlPullParser, "value", -1);
                break;
            case "tag:dolby.com,2014:dash:audio_channel_configuration:2011":
            case "urn:dolby:dash:audio_channel_configuration:2011":
                dtsChannelConfiguration = parseDolbyChannelConfiguration(xmlPullParser);
                break;
            case "urn:mpeg:mpegB:cicp:ChannelConfiguration":
                dtsChannelConfiguration = parseMpegChannelConfiguration(xmlPullParser);
                break;
            case "tag:dts.com,2018:uhd:audio_channel_configuration":
                dtsChannelConfiguration = parseDtsxChannelConfiguration(xmlPullParser);
                break;
        }
        do {
            xmlPullParser.next();
        } while (!x6a.d(xmlPullParser, "AudioChannelConfiguration"));
        return dtsChannelConfiguration;
    }

    public long parseAvailabilityTimeOffsetUs(XmlPullParser xmlPullParser, long j) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "availabilityTimeOffset");
        if (attributeValue == null) {
            return j;
        }
        if ("INF".equals(attributeValue)) {
            return Long.MAX_VALUE;
        }
        return (long) (Float.parseFloat(attributeValue) * 1000000.0f);
    }

    public List<vr0> parseBaseUrl(XmlPullParser xmlPullParser, List<vr0> list, boolean z) throws XmlPullParserException, IOException {
        String attributeValue = xmlPullParser.getAttributeValue(null, "dvb:priority");
        int i = attributeValue != null ? Integer.parseInt(attributeValue) : z ? 1 : Integer.MIN_VALUE;
        String attributeValue2 = xmlPullParser.getAttributeValue(null, "dvb:weight");
        int i2 = attributeValue2 != null ? Integer.parseInt(attributeValue2) : 1;
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "serviceLocation");
        String text = parseText(xmlPullParser, "BaseURL");
        if (rh9.b(text)) {
            if (attributeValue3 == null) {
                attributeValue3 = text;
            }
            return Lists.t(new vr0(text, attributeValue3, i, i2));
        }
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < list.size(); i3++) {
            vr0 vr0Var = list.get(i3);
            String strE = rh9.e(vr0Var.f20281a, text);
            String str = attributeValue3 == null ? strE : attributeValue3;
            if (z) {
                i = vr0Var.f45424a;
                i2 = vr0Var.b;
                str = vr0Var.f20282b;
            }
            arrayList.add(new vr0(strE, str, i, i2));
        }
        return arrayList;
    }

    /* JADX WARN: Code duplicated, block: B:39:0x0090  */
    /* JADX WARN: Code duplicated, block: B:67:0x010c  */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [byte[]] */
    /* JADX WARN: Type inference failed for: r4v2 */
    /* JADX WARN: Type inference failed for: r4v25 */
    /* JADX WARN: Type inference failed for: r4v26 */
    /* JADX WARN: Type inference failed for: r4v27 */
    /* JADX WARN: Type inference failed for: r4v28 */
    /* JADX WARN: Type inference failed for: r4v29 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v30 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    /* JADX WARN: Type inference failed for: r5v0 */
    /* JADX WARN: Type inference failed for: r5v1 */
    /* JADX WARN: Type inference failed for: r5v11 */
    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13 */
    /* JADX WARN: Type inference failed for: r5v14 */
    /* JADX WARN: Type inference failed for: r5v15 */
    /* JADX WARN: Type inference failed for: r5v16 */
    /* JADX WARN: Type inference failed for: r5v2 */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.String] */
    /* JADX WARN: Type inference failed for: r5v9 */
    public Pair<String, DrmInitData.SchemeData> parseContentProtection(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String attributeValue;
        UUID uuid;
        UUID uuid2;
        ?? attributeValue2;
        ?? B;
        String attributeValue3 = xmlPullParser.getAttributeValue(null, "schemeIdUri");
        if (attributeValue3 != null) {
            String strG = com.google.common.base.a.g(attributeValue3);
            strG.hashCode();
            switch (strG) {
                case "urn:uuid:e2719d58-a985-b3c9-781a-b030af78d30e":
                    uuid = C.f2002c;
                    attributeValue = null;
                    uuid2 = null;
                    attributeValue2 = uuid2;
                    B = uuid2;
                    break;
                case "urn:uuid:9a04f079-9840-4286-ab92-e65be0885f95":
                    uuid = C.f2008e;
                    attributeValue = null;
                    uuid2 = null;
                    attributeValue2 = uuid2;
                    B = uuid2;
                    break;
                case "urn:uuid:edef8ba9-79d6-4ace-a3c8-27dcd51d21ed":
                    uuid = C.f2005d;
                    attributeValue = null;
                    uuid2 = null;
                    attributeValue2 = uuid2;
                    B = uuid2;
                    break;
                case "urn:mpeg:dash:mp4protection:2011":
                    attributeValue = xmlPullParser.getAttributeValue(null, "value");
                    String strB = x6a.b(xmlPullParser, "default_KID");
                    if (!TextUtils.isEmpty(strB) && !"00000000-0000-0000-0000-000000000000".equals(strB)) {
                        String[] strArrSplit = strB.split("\\s+");
                        UUID[] uuidArr = new UUID[strArrSplit.length];
                        for (int i = 0; i < strArrSplit.length; i++) {
                            uuidArr[i] = UUID.fromString(strArrSplit[i]);
                        }
                        uuid = C.f1999b;
                        attributeValue2 = 0;
                        B = c.b(uuid, uuidArr, null);
                        break;
                    } else {
                        uuid = null;
                        uuid2 = uuid;
                        attributeValue2 = uuid2;
                        B = uuid2;
                        break;
                    }
                    break;
                default:
                    attributeValue = null;
                    uuid = null;
                    uuid2 = uuid;
                    attributeValue2 = uuid2;
                    B = uuid2;
                    break;
            }
        } else {
            attributeValue = null;
            uuid = null;
            uuid2 = uuid;
            attributeValue2 = uuid2;
            B = uuid2;
        }
        do {
            xmlPullParser.next();
            if (x6a.f(xmlPullParser, "clearkey:Laurl") && xmlPullParser.next() == 4) {
                B = B;
                attributeValue2 = xmlPullParser.getText();
            } else if (x6a.f(xmlPullParser, "ms:laurl")) {
                B = B;
                attributeValue2 = xmlPullParser.getAttributeValue(null, "licenseUrl");
            } else if (B == 0 && x6a.g(xmlPullParser, "pssh") && xmlPullParser.next() == 4) {
                byte[] bArrDecode = Base64.decode(xmlPullParser.getText(), 0);
                UUID uuidF = c.f(bArrDecode);
                if (uuidF == null) {
                    Log.n(f, "Skipping malformed cenc:pssh data");
                    uuid = uuidF;
                    B = 0;
                    attributeValue2 = attributeValue2;
                } else {
                    B = bArrDecode;
                    uuid = uuidF;
                    attributeValue2 = attributeValue2;
                }
            } else if (B == 0) {
                UUID uuid3 = C.f2008e;
                if (uuid3.equals(uuid) && x6a.f(xmlPullParser, "mspr:pro") && xmlPullParser.next() == 4) {
                    B = c.a(uuid3, Base64.decode(xmlPullParser.getText(), 0));
                    attributeValue2 = attributeValue2;
                } else {
                    j(xmlPullParser);
                    B = B;
                    attributeValue2 = attributeValue2;
                }
            } else {
                j(xmlPullParser);
                B = B;
                attributeValue2 = attributeValue2;
            }
        } while (!x6a.d(xmlPullParser, "ContentProtection"));
        return Pair.create(attributeValue, uuid != null ? new DrmInitData.SchemeData(uuid, attributeValue2, "video/mp4", B) : null);
    }

    public int parseContentType(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue(null, "contentType");
        if (TextUtils.isEmpty(attributeValue)) {
            return -1;
        }
        if ("audio".equals(attributeValue)) {
            return 1;
        }
        if ("video".equals(attributeValue)) {
            return 2;
        }
        return "text".equals(attributeValue) ? 3 : -1;
    }

    public Pair<Long, EventMessage> parseEvent(XmlPullParser xmlPullParser, String str, String str2, long j, ByteArrayOutputStream byteArrayOutputStream) throws XmlPullParserException, IOException {
        long j2 = parseLong(xmlPullParser, "id", 0L);
        long j3 = parseLong(xmlPullParser, "duration", -9223372036854775807L);
        long j4 = parseLong(xmlPullParser, "presentationTime", 0L);
        long jO1 = gj9.o1(j3, 1000L, j);
        long jO2 = gj9.o1(j4, 1000000L, j);
        String string = parseString(xmlPullParser, "messageData", null);
        byte[] eventObject = parseEventObject(xmlPullParser, byteArrayOutputStream);
        Long lValueOf = Long.valueOf(jO2);
        if (string != null) {
            eventObject = gj9.z0(string);
        }
        return Pair.create(lValueOf, buildEvent(str, str2, j2, jO1, eventObject));
    }

    public byte[] parseEventObject(XmlPullParser xmlPullParser, ByteArrayOutputStream byteArrayOutputStream) throws XmlPullParserException, IOException {
        byteArrayOutputStream.reset();
        XmlSerializer xmlSerializerNewSerializer = Xml.newSerializer();
        xmlSerializerNewSerializer.setOutput(byteArrayOutputStream, b.c.name());
        xmlPullParser.nextToken();
        while (!x6a.d(xmlPullParser, "Event")) {
            switch (xmlPullParser.getEventType()) {
                case 0:
                    xmlSerializerNewSerializer.startDocument(null, Boolean.FALSE);
                    break;
                case 1:
                    xmlSerializerNewSerializer.endDocument();
                    break;
                case 2:
                    xmlSerializerNewSerializer.startTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    for (int i = 0; i < xmlPullParser.getAttributeCount(); i++) {
                        xmlSerializerNewSerializer.attribute(xmlPullParser.getAttributeNamespace(i), xmlPullParser.getAttributeName(i), xmlPullParser.getAttributeValue(i));
                    }
                    break;
                case 3:
                    xmlSerializerNewSerializer.endTag(xmlPullParser.getNamespace(), xmlPullParser.getName());
                    break;
                case 4:
                    xmlSerializerNewSerializer.text(xmlPullParser.getText());
                    break;
                case 5:
                    xmlSerializerNewSerializer.cdsect(xmlPullParser.getText());
                    break;
                case 6:
                    xmlSerializerNewSerializer.entityRef(xmlPullParser.getText());
                    break;
                case 7:
                    xmlSerializerNewSerializer.ignorableWhitespace(xmlPullParser.getText());
                    break;
                case 8:
                    xmlSerializerNewSerializer.processingInstruction(xmlPullParser.getText());
                    break;
                case 9:
                    xmlSerializerNewSerializer.comment(xmlPullParser.getText());
                    break;
                case 10:
                    xmlSerializerNewSerializer.docdecl(xmlPullParser.getText());
                    break;
            }
            xmlPullParser.nextToken();
        }
        xmlSerializerNewSerializer.flush();
        return byteArrayOutputStream.toByteArray();
    }

    public s53 parseEventStream(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String string = parseString(xmlPullParser, "schemeIdUri", "");
        String string2 = parseString(xmlPullParser, "value", "");
        long j = parseLong(xmlPullParser, "timescale", 1L);
        ArrayList arrayList = new ArrayList();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        do {
            xmlPullParser.next();
            if (x6a.f(xmlPullParser, "Event")) {
                arrayList.add(parseEvent(xmlPullParser, string, string2, j, byteArrayOutputStream));
            } else {
                j(xmlPullParser);
            }
        } while (!x6a.d(xmlPullParser, "EventStream"));
        long[] jArr = new long[arrayList.size()];
        EventMessage[] eventMessageArr = new EventMessage[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            Pair pair = (Pair) arrayList.get(i);
            jArr[i] = ((Long) pair.first).longValue();
            eventMessageArr[i] = (EventMessage) pair.second;
        }
        return buildEventStream(string, string2, j, jArr, eventMessageArr);
    }

    public ka7 parseInitialization(XmlPullParser xmlPullParser) {
        return parseRangedUrl(xmlPullParser, "sourceURL", i.m);
    }

    public String parseLabel(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        return parseText(xmlPullParser, "Label");
    }

    /* JADX WARN: Code duplicated, block: B:68:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:70:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:71:0x01ae A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:73:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:75:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:78:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:80:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:82:0x01e7 A[LOOP:0: B:25:0x00a4->B:82:0x01e7, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:83:0x01a3 A[SYNTHETIC] */
    public c62 parseMediaPresentationDescription(XmlPullParser xmlPullParser, Uri uri) throws XmlPullParserException, IOException {
        long j;
        boolean z;
        long j2;
        Throwable th;
        ArrayList arrayList;
        boolean z2;
        long j3;
        a aVar = this;
        boolean zI = aVar.i(aVar.parseProfiles(xmlPullParser, "profiles", new String[0]));
        long j4 = -9223372036854775807L;
        long dateTime = parseDateTime(xmlPullParser, "availabilityStartTime", -9223372036854775807L);
        long duration = parseDuration(xmlPullParser, "mediaPresentationDuration", -9223372036854775807L);
        long duration2 = parseDuration(xmlPullParser, "minBufferTime", -9223372036854775807L);
        Throwable th2 = null;
        boolean zEquals = "dynamic".equals(xmlPullParser.getAttributeValue(null, "type"));
        long duration3 = zEquals ? parseDuration(xmlPullParser, "minimumUpdatePeriod", -9223372036854775807L) : -9223372036854775807L;
        long duration4 = zEquals ? parseDuration(xmlPullParser, "timeShiftBufferDepth", -9223372036854775807L) : -9223372036854775807L;
        long duration5 = zEquals ? parseDuration(xmlPullParser, "suggestedPresentationDelay", -9223372036854775807L) : -9223372036854775807L;
        long dateTime2 = parseDateTime(xmlPullParser, "publishTime", -9223372036854775807L);
        long availabilityTimeOffsetUs = zEquals ? 0L : -9223372036854775807L;
        boolean z3 = true;
        ArrayList arrayListT = Lists.t(new vr0(uri.toString(), uri.toString(), zI ? 1 : Integer.MIN_VALUE, 1));
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        boolean z4 = false;
        boolean z5 = false;
        long j5 = zEquals ? -9223372036854775807L : 0L;
        f17 programInformation = null;
        yi9 utcTiming = null;
        Uri uriF = null;
        c68 serviceDescription = null;
        while (true) {
            xmlPullParser.next();
            if (x6a.f(xmlPullParser, "BaseURL")) {
                if (!z4) {
                    availabilityTimeOffsetUs = aVar.parseAvailabilityTimeOffsetUs(xmlPullParser, availabilityTimeOffsetUs);
                    z4 = z3;
                }
                arrayList3.addAll(aVar.parseBaseUrl(xmlPullParser, arrayListT, zI));
            } else if (x6a.f(xmlPullParser, "ProgramInformation")) {
                programInformation = parseProgramInformation(xmlPullParser);
            } else if (x6a.f(xmlPullParser, "UTCTiming")) {
                utcTiming = parseUtcTiming(xmlPullParser);
            } else if (x6a.f(xmlPullParser, "Location")) {
                uriF = rh9.f(uri.toString(), xmlPullParser.nextText());
            } else {
                if (x6a.f(xmlPullParser, "ServiceDescription")) {
                    serviceDescription = parseServiceDescription(xmlPullParser);
                } else {
                    if (!x6a.f(xmlPullParser, "Period") || z5) {
                        j = availabilityTimeOffsetUs;
                        z = z3;
                        j2 = j4;
                        th = th2;
                        arrayList = arrayList2;
                        j(xmlPullParser);
                    } else {
                        j = availabilityTimeOffsetUs;
                        arrayList = arrayList2;
                        z = z3;
                        j2 = j4;
                        th = th2;
                        Pair<eo6, Long> period = parsePeriod(xmlPullParser, !arrayList3.isEmpty() ? arrayList3 : arrayListT, j5, j, dateTime, duration4, zI);
                        eo6 eo6Var = (eo6) period.first;
                        if (eo6Var.f41481a != j2) {
                            long jLongValue = ((Long) period.second).longValue();
                            long j6 = jLongValue == j2 ? j2 : eo6Var.f41481a + jLongValue;
                            arrayList.add(eo6Var);
                            j5 = j6;
                            z2 = z5;
                        } else {
                            if (!zEquals) {
                                throw ParserException.createForMalformedManifest("Unable to determine start of period " + arrayList.size(), th);
                            }
                            arrayList = arrayList;
                            z2 = z;
                        }
                        z5 = z2;
                    }
                    availabilityTimeOffsetUs = j;
                }
                if (x6a.d(xmlPullParser, "MPD")) {
                    if (duration != j2) {
                        j3 = duration;
                    } else if (j5 != j2) {
                        j3 = j5;
                    } else {
                        if (!zEquals) {
                            throw ParserException.createForMalformedManifest("Unable to determine duration of static manifest.", th);
                        }
                        j3 = duration;
                    }
                    if (arrayList.isEmpty()) {
                        throw ParserException.createForMalformedManifest("No periods found.", th);
                    }
                    return buildMediaPresentationDescription(dateTime, j3, duration2, zEquals, duration3, duration4, duration5, dateTime2, programInformation, utcTiming, serviceDescription, uriF, arrayList);
                }
                arrayList2 = arrayList;
                th2 = th;
                arrayList3 = arrayList3;
                z3 = z;
                arrayListT = arrayListT;
                j4 = j2;
                aVar = this;
            }
            arrayList3 = arrayList3;
            arrayListT = arrayListT;
            z = z3;
            j2 = j4;
            th = th2;
            arrayList = arrayList2;
            if (x6a.d(xmlPullParser, "MPD")) {
                if (duration != j2) {
                    j3 = duration;
                } else if (j5 != j2) {
                    j3 = j5;
                } else {
                    if (!zEquals) {
                        throw ParserException.createForMalformedManifest("Unable to determine duration of static manifest.", th);
                    }
                    j3 = duration;
                }
                if (arrayList.isEmpty()) {
                    return buildMediaPresentationDescription(dateTime, j3, duration2, zEquals, duration3, duration4, duration5, dateTime2, programInformation, utcTiming, serviceDescription, uriF, arrayList);
                }
                throw ParserException.createForMalformedManifest("No periods found.", th);
            }
            arrayList2 = arrayList;
            th2 = th;
            arrayList3 = arrayList3;
            z3 = z;
            arrayListT = arrayListT;
            j4 = j2;
            aVar = this;
        }
    }

    public Pair<eo6, Long> parsePeriod(XmlPullParser xmlPullParser, List<vr0> list, long j, long j2, long j3, long j4, boolean z) throws XmlPullParserException, IOException {
        ArrayList arrayList;
        List<vz> list2;
        List<s53> list3;
        Object obj;
        long j5;
        SegmentBase segmentTemplate;
        XmlPullParser xmlPullParser2 = xmlPullParser;
        Object obj2 = null;
        String attributeValue = xmlPullParser2.getAttributeValue(null, "id");
        long duration = parseDuration(xmlPullParser2, "start", j);
        long j6 = -9223372036854775807L;
        long j7 = j3 != -9223372036854775807L ? j3 + duration : -9223372036854775807L;
        long duration2 = parseDuration(xmlPullParser2, "duration", -9223372036854775807L);
        List<vz> arrayList2 = new ArrayList<>();
        List<s53> arrayList3 = new ArrayList<>();
        ArrayList arrayList4 = new ArrayList();
        long availabilityTimeOffsetUs = j2;
        boolean z2 = false;
        long j8 = -9223372036854775807L;
        SegmentBase segmentBase = null;
        rk2 descriptor = null;
        while (true) {
            xmlPullParser.next();
            if (x6a.f(xmlPullParser2, "BaseURL")) {
                if (!z2) {
                    availabilityTimeOffsetUs = parseAvailabilityTimeOffsetUs(xmlPullParser2, availabilityTimeOffsetUs);
                    z2 = true;
                }
                arrayList4.addAll(parseBaseUrl(xmlPullParser2, list, z));
                list3 = arrayList3;
                arrayList = arrayList4;
                j5 = j6;
                obj = obj2;
                list2 = arrayList2;
            } else {
                if (x6a.f(xmlPullParser2, "AdaptationSet")) {
                    availabilityTimeOffsetUs = availabilityTimeOffsetUs;
                    arrayList = arrayList4;
                    list2 = arrayList2;
                    list2.add(parseAdaptationSet(xmlPullParser, !arrayList4.isEmpty() ? arrayList4 : list, segmentBase, duration2, availabilityTimeOffsetUs, j8, j7, j4, z));
                    xmlPullParser2 = xmlPullParser;
                    list3 = arrayList3;
                } else {
                    availabilityTimeOffsetUs = availabilityTimeOffsetUs;
                    List<s53> list4 = arrayList3;
                    arrayList = arrayList4;
                    list2 = arrayList2;
                    xmlPullParser2 = xmlPullParser;
                    if (x6a.f(xmlPullParser2, "EventStream")) {
                        list4.add(parseEventStream(xmlPullParser));
                        list3 = list4;
                    } else if (x6a.f(xmlPullParser2, "SegmentBase")) {
                        list3 = list4;
                        segmentBase = parseSegmentBase(xmlPullParser2, null);
                        obj = null;
                        availabilityTimeOffsetUs = availabilityTimeOffsetUs;
                        j5 = -9223372036854775807L;
                    } else {
                        list3 = list4;
                        if (x6a.f(xmlPullParser2, "SegmentList")) {
                            long availabilityTimeOffsetUs2 = parseAvailabilityTimeOffsetUs(xmlPullParser2, -9223372036854775807L);
                            obj = null;
                            segmentTemplate = parseSegmentList(xmlPullParser, null, j7, duration2, availabilityTimeOffsetUs, availabilityTimeOffsetUs2, j4);
                            j8 = availabilityTimeOffsetUs2;
                            j5 = -9223372036854775807L;
                        } else {
                            obj = null;
                            if (x6a.f(xmlPullParser2, "SegmentTemplate")) {
                                long availabilityTimeOffsetUs3 = parseAvailabilityTimeOffsetUs(xmlPullParser2, -9223372036854775807L);
                                j5 = -9223372036854775807L;
                                segmentTemplate = parseSegmentTemplate(xmlPullParser, null, ImmutableList.of(), j7, duration2, availabilityTimeOffsetUs, availabilityTimeOffsetUs3, j4);
                                j8 = availabilityTimeOffsetUs3;
                            } else {
                                j5 = -9223372036854775807L;
                                if (x6a.f(xmlPullParser2, "AssetIdentifier")) {
                                    descriptor = parseDescriptor(xmlPullParser2, "AssetIdentifier");
                                } else {
                                    j(xmlPullParser);
                                }
                                availabilityTimeOffsetUs = availabilityTimeOffsetUs;
                            }
                        }
                        segmentBase = segmentTemplate;
                    }
                }
                obj = null;
                j5 = -9223372036854775807L;
                availabilityTimeOffsetUs = availabilityTimeOffsetUs;
            }
            if (x6a.d(xmlPullParser2, "Period")) {
                return Pair.create(buildPeriod(attributeValue, duration, list2, list3, descriptor), Long.valueOf(duration2));
            }
            arrayList2 = list2;
            arrayList4 = arrayList;
            obj2 = obj;
            arrayList3 = list3;
            j6 = j5;
        }
    }

    public String[] parseProfiles(XmlPullParser xmlPullParser, String str, String[] strArr) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue == null ? strArr : attributeValue.split(",");
    }

    public f17 parseProgramInformation(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        String strNextText = null;
        String string = parseString(xmlPullParser, "moreInformationURL", null);
        String string2 = parseString(xmlPullParser, dv9.h, null);
        String strNextText2 = null;
        String strNextText3 = null;
        while (true) {
            xmlPullParser.next();
            if (x6a.f(xmlPullParser, AliyunVodKey.KEY_VOD_TITLE)) {
                strNextText = xmlPullParser.nextText();
            } else if (x6a.f(xmlPullParser, "Source")) {
                strNextText2 = xmlPullParser.nextText();
            } else if (x6a.f(xmlPullParser, "Copyright")) {
                strNextText3 = xmlPullParser.nextText();
            } else {
                j(xmlPullParser);
            }
            String str = strNextText3;
            if (x6a.d(xmlPullParser, "ProgramInformation")) {
                return new f17(strNextText, strNextText2, str, string, string2);
            }
            strNextText3 = str;
        }
    }

    public ka7 parseRangedUrl(XmlPullParser xmlPullParser, String str, String str2) {
        long j;
        long j2;
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        String attributeValue2 = xmlPullParser.getAttributeValue(null, str2);
        if (attributeValue2 != null) {
            String[] strArrSplit = attributeValue2.split(c49.f40900a);
            j = Long.parseLong(strArrSplit[0]);
            if (strArrSplit.length == 2) {
                j2 = (Long.parseLong(strArrSplit[1]) - j) + 1;
            }
            return buildRangedUri(attributeValue, j, j2);
        }
        j = 0;
        j2 = -1;
        return buildRangedUri(attributeValue, j, j2);
    }

    /* JADX WARN: Code duplicated, block: B:57:0x01ee A[LOOP:0: B:3:0x006a->B:57:0x01ee, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:58:0x0198 A[EDGE_INSN: B:58:0x0198->B:47:0x0198 BREAK  A[LOOP:0: B:3:0x006a->B:57:0x01ee], SYNTHETIC] */
    public C0689a parseRepresentation(XmlPullParser xmlPullParser, List<vr0> list, @Nullable String str, @Nullable String str2, int i, int i2, float f2, int i3, int i4, @Nullable String str3, List<rk2> list2, List<rk2> list3, List<rk2> list4, List<rk2> list5, @Nullable SegmentBase segmentBase, long j, long j2, long j3, long j4, long j5, boolean z) throws XmlPullParserException, IOException {
        long j6;
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        ArrayList arrayList4;
        ArrayList arrayList5;
        long availabilityTimeOffsetUs;
        ArrayList arrayList6;
        SegmentBase dVar;
        ArrayList arrayList7;
        ArrayList arrayList8;
        ArrayList arrayList9;
        String attributeValue = xmlPullParser.getAttributeValue(null, "id");
        int i5 = parseInt(xmlPullParser, "bandwidth", -1);
        String string = parseString(xmlPullParser, "mimeType", str);
        String string2 = parseString(xmlPullParser, "codecs", str2);
        int i6 = parseInt(xmlPullParser, "width", i);
        int i7 = parseInt(xmlPullParser, "height", i2);
        float frameRate = parseFrameRate(xmlPullParser, f2);
        int i8 = parseInt(xmlPullParser, "audioSamplingRate", i4);
        ArrayList arrayList10 = new ArrayList();
        ArrayList arrayList11 = new ArrayList();
        ArrayList arrayList12 = new ArrayList(list4);
        ArrayList arrayList13 = new ArrayList(list5);
        int audioChannelConfiguration = i3;
        long availabilityTimeOffsetUs2 = j3;
        boolean z2 = false;
        String str4 = null;
        SegmentBase segmentTemplate = segmentBase;
        long j7 = j4;
        ArrayList arrayList14 = new ArrayList();
        while (true) {
            xmlPullParser.next();
            if (x6a.f(xmlPullParser, "BaseURL")) {
                if (!z2) {
                    availabilityTimeOffsetUs2 = parseAvailabilityTimeOffsetUs(xmlPullParser, availabilityTimeOffsetUs2);
                    z2 = true;
                }
                arrayList14.addAll(parseBaseUrl(xmlPullParser, list, z));
            } else {
                if (x6a.f(xmlPullParser, "AudioChannelConfiguration")) {
                    dVar = segmentTemplate;
                    audioChannelConfiguration = parseAudioChannelConfiguration(xmlPullParser);
                    arrayList4 = arrayList11;
                    arrayList5 = arrayList13;
                    arrayList9 = arrayList14;
                } else if (x6a.f(xmlPullParser, "SegmentBase")) {
                    segmentTemplate = parseSegmentBase(xmlPullParser, (SegmentBase.d) segmentTemplate);
                } else {
                    if (x6a.f(xmlPullParser, "SegmentList")) {
                        availabilityTimeOffsetUs = parseAvailabilityTimeOffsetUs(xmlPullParser, j7);
                        j6 = availabilityTimeOffsetUs2;
                        arrayList8 = arrayList14;
                        arrayList = arrayList13;
                        arrayList2 = arrayList11;
                        arrayList3 = arrayList12;
                        segmentTemplate = parseSegmentList(xmlPullParser, (SegmentBase.a) segmentTemplate, j, j2, j6, availabilityTimeOffsetUs, j5);
                    } else {
                        j6 = availabilityTimeOffsetUs2;
                        ArrayList arrayList15 = arrayList14;
                        arrayList = arrayList13;
                        arrayList2 = arrayList11;
                        arrayList3 = arrayList12;
                        if (x6a.f(xmlPullParser, "SegmentTemplate")) {
                            availabilityTimeOffsetUs = parseAvailabilityTimeOffsetUs(xmlPullParser, j7);
                            segmentTemplate = parseSegmentTemplate(xmlPullParser, (SegmentBase.b) segmentTemplate, list5, j, j2, j6, availabilityTimeOffsetUs, j5);
                            arrayList8 = arrayList15;
                        } else {
                            arrayList10 = arrayList10;
                            if (x6a.f(xmlPullParser, "ContentProtection")) {
                                Pair<String, DrmInitData.SchemeData> contentProtection = parseContentProtection(xmlPullParser);
                                Object obj = contentProtection.first;
                                if (obj != null) {
                                    str4 = (String) obj;
                                }
                                Object obj2 = contentProtection.second;
                                if (obj2 != null) {
                                    arrayList10.add((DrmInitData.SchemeData) obj2);
                                }
                                arrayList7 = arrayList15;
                                availabilityTimeOffsetUs2 = j6;
                                arrayList5 = arrayList;
                                arrayList4 = arrayList2;
                                arrayList12 = arrayList3;
                                arrayList6 = arrayList7;
                            } else {
                                if (x6a.f(xmlPullParser, "InbandEventStream")) {
                                    arrayList4 = arrayList2;
                                    arrayList4.add(parseDescriptor(xmlPullParser, "InbandEventStream"));
                                    arrayList5 = arrayList;
                                    arrayList12 = arrayList3;
                                } else {
                                    arrayList4 = arrayList2;
                                    if (x6a.f(xmlPullParser, "EssentialProperty")) {
                                        arrayList12 = arrayList3;
                                        arrayList12.add(parseDescriptor(xmlPullParser, "EssentialProperty"));
                                        arrayList5 = arrayList;
                                    } else {
                                        arrayList12 = arrayList3;
                                        if (x6a.f(xmlPullParser, "SupplementalProperty")) {
                                            arrayList5 = arrayList;
                                            arrayList5.add(parseDescriptor(xmlPullParser, "SupplementalProperty"));
                                        } else {
                                            arrayList5 = arrayList;
                                            j(xmlPullParser);
                                        }
                                    }
                                }
                                audioChannelConfiguration = audioChannelConfiguration;
                                availabilityTimeOffsetUs2 = j6;
                                arrayList6 = arrayList15;
                            }
                        }
                        dVar = segmentTemplate;
                        arrayList9 = arrayList6;
                    }
                    j7 = availabilityTimeOffsetUs;
                    arrayList7 = arrayList8;
                    availabilityTimeOffsetUs2 = j6;
                    arrayList5 = arrayList;
                    arrayList4 = arrayList2;
                    arrayList12 = arrayList3;
                    arrayList6 = arrayList7;
                    dVar = segmentTemplate;
                    arrayList9 = arrayList6;
                }
                if (x6a.d(xmlPullParser, "Representation")) {
                    break;
                }
                arrayList13 = arrayList5;
                arrayList11 = arrayList4;
                arrayList10 = arrayList10;
                segmentTemplate = dVar;
                audioChannelConfiguration = audioChannelConfiguration;
                arrayList14 = arrayList9;
            }
            audioChannelConfiguration = audioChannelConfiguration;
            dVar = segmentTemplate;
            arrayList4 = arrayList11;
            arrayList5 = arrayList13;
            arrayList9 = arrayList14;
            if (x6a.d(xmlPullParser, "Representation")) {
                break;
                break;
            }
            arrayList13 = arrayList5;
            arrayList11 = arrayList4;
            arrayList10 = arrayList10;
            segmentTemplate = dVar;
            audioChannelConfiguration = audioChannelConfiguration;
            arrayList14 = arrayList9;
        }
        List<rk2> list6 = arrayList5;
        List<rk2> list7 = arrayList12;
        ArrayList arrayList16 = arrayList4;
        d dVarBuildFormat = buildFormat(attributeValue, string, i6, i7, frameRate, audioChannelConfiguration, i8, i5, str3, list2, list3, string2, list7, list6);
        if (dVar == null) {
            dVar = new SegmentBase.d();
        }
        boolean zIsEmpty = arrayList9.isEmpty();
        List list8 = arrayList9;
        if (zIsEmpty) {
            list8 = list;
        }
        return new C0689a(dVarBuildFormat, list8, dVar, str4, arrayList10, arrayList16, list7, list6, -1L);
    }

    public int parseRoleFlagsFromAccessibilityDescriptors(List<rk2> list) {
        int tvaAudioPurposeCsValue;
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            rk2 rk2Var = list.get(i2);
            if (com.google.common.base.a.a("urn:mpeg:dash:role:2011", rk2Var.f44473a)) {
                tvaAudioPurposeCsValue = parseRoleFlagsFromDashRoleScheme(rk2Var.b);
            } else {
                if (com.google.common.base.a.a("urn:tva:metadata:cs:AudioPurposeCS:2007", rk2Var.f44473a)) {
                    tvaAudioPurposeCsValue = parseTvaAudioPurposeCsValue(rk2Var.b);
                }
            }
            i |= tvaAudioPurposeCsValue;
        }
        return i;
    }

    public int parseRoleFlagsFromDashRoleScheme(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        switch (str) {
            case "subtitle":
            case "forced_subtitle":
            case "forced-subtitle":
                return 128;
            case "description":
                return 512;
            case "enhanced-audio-intelligibility":
                return 2048;
            case "alternate":
                return 2;
            case "dub":
                return 16;
            case "main":
                return 1;
            case "sign":
                return 256;
            case "caption":
                return 64;
            case "commentary":
                return 8;
            case "emergency":
                return 32;
            case "supplementary":
                return 4;
            default:
                return 0;
        }
    }

    public int parseRoleFlagsFromProperties(List<rk2> list) {
        int i = 0;
        for (int i2 = 0; i2 < list.size(); i2++) {
            if (com.google.common.base.a.a("http://dashif.org/guidelines/trickmode", list.get(i2).f44473a)) {
                i |= 16384;
            }
        }
        return i;
    }

    public int parseRoleFlagsFromRoleDescriptors(List<rk2> list) {
        int roleFlagsFromDashRoleScheme = 0;
        for (int i = 0; i < list.size(); i++) {
            rk2 rk2Var = list.get(i);
            if (com.google.common.base.a.a("urn:mpeg:dash:role:2011", rk2Var.f44473a)) {
                roleFlagsFromDashRoleScheme |= parseRoleFlagsFromDashRoleScheme(rk2Var.b);
            }
        }
        return roleFlagsFromDashRoleScheme;
    }

    public SegmentBase.d parseSegmentBase(XmlPullParser xmlPullParser, @Nullable SegmentBase.d dVar) throws XmlPullParserException, IOException {
        long j;
        long j2;
        long j3 = parseLong(xmlPullParser, "timescale", dVar != null ? ((SegmentBase) dVar).f30895a : 1L);
        long j4 = parseLong(xmlPullParser, "presentationTimeOffset", dVar != null ? dVar.b : 0L);
        long j5 = dVar != null ? dVar.c : 0L;
        long j6 = dVar != null ? dVar.d : 0L;
        String attributeValue = xmlPullParser.getAttributeValue(null, "indexRange");
        if (attributeValue != null) {
            String[] strArrSplit = attributeValue.split(c49.f40900a);
            j2 = Long.parseLong(strArrSplit[0]);
            j = (Long.parseLong(strArrSplit[1]) - j2) + 1;
        } else {
            j = j6;
            j2 = j5;
        }
        ka7 initialization = dVar != null ? ((SegmentBase) dVar).f3991a : null;
        do {
            xmlPullParser.next();
            if (x6a.f(xmlPullParser, "Initialization")) {
                initialization = parseInitialization(xmlPullParser);
            } else {
                j(xmlPullParser);
            }
        } while (!x6a.d(xmlPullParser, "SegmentBase"));
        return buildSingleSegmentBase(initialization, j3, j4, j2, j);
    }

    public SegmentBase.a parseSegmentList(XmlPullParser xmlPullParser, @Nullable SegmentBase.a aVar, long j, long j2, long j3, long j4, long j5) throws XmlPullParserException, IOException {
        long j6 = parseLong(xmlPullParser, "timescale", aVar != null ? ((SegmentBase) aVar).f30895a : 1L);
        long j7 = parseLong(xmlPullParser, "presentationTimeOffset", aVar != null ? ((SegmentBase) aVar).b : 0L);
        long j8 = parseLong(xmlPullParser, "duration", aVar != null ? aVar.d : -9223372036854775807L);
        long j9 = parseLong(xmlPullParser, "startNumber", aVar != null ? aVar.c : 1L);
        long jG = g(j3, j4);
        List<SegmentBase.c> segmentTimeline = null;
        List<ka7> arrayList = null;
        ka7 initialization = null;
        do {
            xmlPullParser.next();
            if (x6a.f(xmlPullParser, "Initialization")) {
                initialization = parseInitialization(xmlPullParser);
            } else if (x6a.f(xmlPullParser, "SegmentTimeline")) {
                segmentTimeline = parseSegmentTimeline(xmlPullParser, j6, j2);
            } else if (x6a.f(xmlPullParser, "SegmentURL")) {
                if (arrayList == null) {
                    arrayList = new ArrayList<>();
                }
                arrayList.add(parseSegmentUrl(xmlPullParser));
            } else {
                j(xmlPullParser);
            }
        } while (!x6a.d(xmlPullParser, "SegmentList"));
        if (aVar != null) {
            if (initialization == null) {
                initialization = ((SegmentBase) aVar).f3991a;
            }
            if (segmentTimeline == null) {
                segmentTimeline = ((SegmentBase.MultiSegmentBase) aVar).f30896a;
            }
            if (arrayList == null) {
                arrayList = aVar.b;
            }
        }
        return buildSegmentList(initialization, j6, j7, j9, j8, segmentTimeline, jG, arrayList, j5, j);
    }

    public SegmentBase.b parseSegmentTemplate(XmlPullParser xmlPullParser, @Nullable SegmentBase.b bVar, List<rk2> list, long j, long j2, long j3, long j4, long j5) throws XmlPullParserException, IOException {
        long j6 = parseLong(xmlPullParser, "timescale", bVar != null ? ((SegmentBase) bVar).f30895a : 1L);
        long j7 = parseLong(xmlPullParser, "presentationTimeOffset", bVar != null ? ((SegmentBase) bVar).b : 0L);
        long j8 = parseLong(xmlPullParser, "duration", bVar != null ? bVar.d : -9223372036854775807L);
        long j9 = parseLong(xmlPullParser, "startNumber", bVar != null ? bVar.c : 1L);
        long lastSegmentNumberSupplementalProperty = parseLastSegmentNumberSupplementalProperty(list);
        long jG = g(j3, j4);
        List<SegmentBase.c> segmentTimeline = null;
        zh9 urlTemplate = parseUrlTemplate(xmlPullParser, "media", bVar != null ? bVar.b : null);
        zh9 urlTemplate2 = parseUrlTemplate(xmlPullParser, "initialization", bVar != null ? bVar.f30897a : null);
        ka7 initialization = null;
        do {
            xmlPullParser.next();
            if (x6a.f(xmlPullParser, "Initialization")) {
                initialization = parseInitialization(xmlPullParser);
            } else if (x6a.f(xmlPullParser, "SegmentTimeline")) {
                segmentTimeline = parseSegmentTimeline(xmlPullParser, j6, j2);
            } else {
                j(xmlPullParser);
            }
        } while (!x6a.d(xmlPullParser, "SegmentTemplate"));
        if (bVar != null) {
            if (initialization == null) {
                initialization = ((SegmentBase) bVar).f3991a;
            }
            if (segmentTimeline == null) {
                segmentTimeline = ((SegmentBase.MultiSegmentBase) bVar).f30896a;
            }
        }
        return buildSegmentTemplate(initialization, j6, j7, j9, lastSegmentNumberSupplementalProperty, j8, segmentTimeline, jG, urlTemplate2, urlTemplate, j5, j);
    }

    public List<SegmentBase.c> parseSegmentTimeline(XmlPullParser xmlPullParser, long j, long j2) throws XmlPullParserException, IOException {
        ArrayList arrayList = new ArrayList();
        long jA = 0;
        long j3 = -9223372036854775807L;
        boolean z = false;
        int i = 0;
        do {
            xmlPullParser.next();
            if (x6a.f(xmlPullParser, "S")) {
                long j4 = parseLong(xmlPullParser, "t", -9223372036854775807L);
                if (z) {
                    jA = a(arrayList, jA, j3, i, j4);
                }
                if (j4 == -9223372036854775807L) {
                    j4 = jA;
                }
                j3 = parseLong(xmlPullParser, "d", -9223372036854775807L);
                i = parseInt(xmlPullParser, "r", 0);
                z = true;
                jA = j4;
            } else {
                j(xmlPullParser);
            }
        } while (!x6a.d(xmlPullParser, "SegmentTimeline"));
        if (z) {
            a(arrayList, jA, j3, i, gj9.o1(j2, j, 1000L));
        }
        return arrayList;
    }

    public ka7 parseSegmentUrl(XmlPullParser xmlPullParser) {
        return parseRangedUrl(xmlPullParser, "media", "mediaRange");
    }

    public int parseSelectionFlagsFromDashRoleScheme(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        return (str.equals("forced_subtitle") || str.equals("forced-subtitle")) ? 2 : 0;
    }

    public int parseSelectionFlagsFromRoleDescriptors(List<rk2> list) {
        int selectionFlagsFromDashRoleScheme = 0;
        for (int i = 0; i < list.size(); i++) {
            rk2 rk2Var = list.get(i);
            if (com.google.common.base.a.a("urn:mpeg:dash:role:2011", rk2Var.f44473a)) {
                selectionFlagsFromDashRoleScheme |= parseSelectionFlagsFromDashRoleScheme(rk2Var.b);
            }
        }
        return selectionFlagsFromDashRoleScheme;
    }

    public c68 parseServiceDescription(XmlPullParser xmlPullParser) throws XmlPullParserException, IOException {
        long j = -9223372036854775807L;
        long j2 = -9223372036854775807L;
        long j3 = -9223372036854775807L;
        float f2 = -3.4028235E38f;
        float f3 = -3.4028235E38f;
        while (true) {
            xmlPullParser.next();
            if (x6a.f(xmlPullParser, "Latency")) {
                j = parseLong(xmlPullParser, "target", -9223372036854775807L);
                j2 = parseLong(xmlPullParser, MoreDistanceDialog.VALUE_MIN, -9223372036854775807L);
                j3 = parseLong(xmlPullParser, "max", -9223372036854775807L);
            } else if (x6a.f(xmlPullParser, "PlaybackRate")) {
                f2 = parseFloat(xmlPullParser, MoreDistanceDialog.VALUE_MIN, -3.4028235E38f);
                f3 = parseFloat(xmlPullParser, "max", -3.4028235E38f);
            }
            long j4 = j;
            long j5 = j2;
            long j6 = j3;
            float f4 = f2;
            float f5 = f3;
            if (x6a.d(xmlPullParser, "ServiceDescription")) {
                return new c68(j4, j5, j6, f4, f5);
            }
            j = j4;
            j2 = j5;
            j3 = j6;
            f2 = f4;
            f3 = f5;
        }
    }

    public int parseTvaAudioPurposeCsValue(@Nullable String str) {
        if (str == null) {
            return 0;
        }
        byte b2 = -1;
        switch (str.hashCode()) {
            case 49:
                if (str.equals("1")) {
                    b2 = 0;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    b2 = 1;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    b2 = 2;
                }
                break;
            case 52:
                if (str.equals("4")) {
                    b2 = 3;
                }
                break;
            case 54:
                if (str.equals("6")) {
                    b2 = 4;
                }
                break;
        }
        switch (b2) {
            case 0:
                return 512;
            case 1:
                return 2048;
            case 2:
                return 4;
            case 3:
                return 8;
            case 4:
                return 1;
            default:
                return 0;
        }
    }

    @Nullable
    public zh9 parseUrlTemplate(XmlPullParser xmlPullParser, String str, @Nullable zh9 zh9Var) {
        String attributeValue = xmlPullParser.getAttributeValue(null, str);
        return attributeValue != null ? zh9.b(attributeValue) : zh9Var;
    }

    public yi9 parseUtcTiming(XmlPullParser xmlPullParser) {
        return buildUtcTimingElement(xmlPullParser.getAttributeValue(null, "schemeIdUri"), xmlPullParser.getAttributeValue(null, "value"));
    }
}
