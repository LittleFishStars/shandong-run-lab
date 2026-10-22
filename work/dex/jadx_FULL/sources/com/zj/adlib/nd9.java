package com.zj.adlib;

import android.text.Layout;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.alibaba.android.arouter.utils.Consts;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.text.ttml.TextEmphasis;
import com.google.android.exoplayer2.text.ttml.TtmlStyle;
import com.google.android.exoplayer2.util.Log;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class nd9 extends SimpleSubtitleDecoder {
    public static final String b = "TtmlDecoder";
    public static final String c = "http://www.w3.org/ns/ttml#parameter";
    public static final int d = 30;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final String f18397d = "begin";
    public static final String e = "dur";
    public static final String f = "end";
    public static final String g = "style";
    public static final String h = "region";
    public static final String i = "backgroundImage";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final u6a f18402a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Pattern f18394a = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final Pattern f18395b = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final Pattern f18396c = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final Pattern f18398d = Pattern.compile("^([-+]?\\d+\\.?\\d*?)%$");

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static final Pattern f18399e = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static final Pattern f18400f = Pattern.compile("^(\\d+\\.?\\d*?)px (\\d+\\.?\\d*?)px$");

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public static final Pattern f18401g = Pattern.compile("^(\\d+) (\\d+)$");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final b f18393a = new b(30.0f, 1, 1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f43501a = new a(32, 15);

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f43502a;
        public final int b;

        public a(int i, int i2) {
            this.f43502a = i;
            this.b = i2;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f43503a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final int f18403a;
        public final int b;

        public b(float f, int i, int i2) {
            this.f43503a = f;
            this.f18403a = i;
            this.b = i2;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f43504a;
        public final int b;

        public c(int i, int i2) {
            this.f43504a = i;
            this.b = i2;
        }
    }

    public nd9() {
        super(b);
        try {
            u6a u6aVarD = u6a.d();
            this.f18402a = u6aVarD;
            u6aVarD.i(true);
        } catch (XmlPullParserException e2) {
            throw new RuntimeException("Couldn't create XmlPullParserFactory instance", e2);
        }
    }

    @Nullable
    public static c A(XmlPullParser xmlPullParser) {
        String strA = x6a.a(xmlPullParser, "extent");
        if (strA == null) {
            return null;
        }
        Matcher matcher = f18400f.matcher(strA);
        if (!matcher.matches()) {
            Log.n(b, "Ignoring non-pixel tts extent: " + strA);
            return null;
        }
        try {
            return new c(Integer.parseInt((String) sb0.g(matcher.group(1))), Integer.parseInt((String) sb0.g(matcher.group(2))));
        } catch (NumberFormatException unused) {
            Log.n(b, "Ignoring malformed tts extent: " + strA);
            return null;
        }
    }

    public static TtmlStyle m(@Nullable TtmlStyle ttmlStyle) {
        return ttmlStyle == null ? new TtmlStyle() : ttmlStyle;
    }

    public static boolean n(String str) {
        return str.equals("tt") || str.equals("head") || str.equals("body") || str.equals("div") || str.equals("p") || str.equals("span") || str.equals("br") || str.equals("style") || str.equals("styling") || str.equals("layout") || str.equals("region") || str.equals("metadata") || str.equals("image") || str.equals("data") || str.equals("information");
    }

    @Nullable
    public static Layout.Alignment o(String str) {
        String strG = com.google.common.base.a.g(str);
        strG.hashCode();
        switch (strG) {
            case "center":
                return Layout.Alignment.ALIGN_CENTER;
            case "end":
            case "right":
                return Layout.Alignment.ALIGN_OPPOSITE;
            case "left":
            case "start":
                return Layout.Alignment.ALIGN_NORMAL;
            default:
                return null;
        }
    }

    public static a p(XmlPullParser xmlPullParser, a aVar) throws SubtitleDecoderException {
        String attributeValue = xmlPullParser.getAttributeValue(c, "cellResolution");
        if (attributeValue == null) {
            return aVar;
        }
        Matcher matcher = f18401g.matcher(attributeValue);
        if (!matcher.matches()) {
            Log.n(b, "Ignoring malformed cell resolution: " + attributeValue);
            return aVar;
        }
        try {
            int i2 = Integer.parseInt((String) sb0.g(matcher.group(1)));
            int i3 = Integer.parseInt((String) sb0.g(matcher.group(2)));
            if (i2 != 0 && i3 != 0) {
                return new a(i2, i3);
            }
            throw new SubtitleDecoderException("Invalid cell resolution " + i2 + " " + i3);
        } catch (NumberFormatException unused) {
            Log.n(b, "Ignoring malformed cell resolution: " + attributeValue);
            return aVar;
        }
    }

    public static void q(String str, TtmlStyle ttmlStyle) throws SubtitleDecoderException {
        Matcher matcher;
        String[] strArrU1 = gj9.u1(str, "\\s+");
        if (strArrU1.length == 1) {
            matcher = f18396c.matcher(str);
        } else {
            if (strArrU1.length != 2) {
                throw new SubtitleDecoderException("Invalid number of entries for fontSize: " + strArrU1.length + Consts.DOT);
            }
            matcher = f18396c.matcher(strArrU1[1]);
            Log.n(b, "Multiple values in fontSize attribute. Picking the second value for vertical font size and ignoring the first.");
        }
        if (!matcher.matches()) {
            throw new SubtitleDecoderException("Invalid expression for fontSize: '" + str + "'.");
        }
        String str2 = (String) sb0.g(matcher.group(3));
        str2.hashCode();
        switch (str2) {
            case "%":
                ttmlStyle.A(3);
                break;
            case "em":
                ttmlStyle.A(2);
                break;
            case "px":
                ttmlStyle.A(1);
                break;
            default:
                throw new SubtitleDecoderException("Invalid unit for fontSize: '" + str2 + "'.");
        }
        ttmlStyle.z(Float.parseFloat((String) sb0.g(matcher.group(1))));
    }

    public static b r(XmlPullParser xmlPullParser) throws SubtitleDecoderException {
        float f2;
        String attributeValue = xmlPullParser.getAttributeValue(c, "frameRate");
        int i2 = attributeValue != null ? Integer.parseInt(attributeValue) : 30;
        String attributeValue2 = xmlPullParser.getAttributeValue(c, "frameRateMultiplier");
        if (attributeValue2 != null) {
            String[] strArrU1 = gj9.u1(attributeValue2, " ");
            if (strArrU1.length != 2) {
                throw new SubtitleDecoderException("frameRateMultiplier doesn't have 2 parts");
            }
            f2 = Integer.parseInt(strArrU1[0]) / Integer.parseInt(strArrU1[1]);
        } else {
            f2 = 1.0f;
        }
        b bVar = f18393a;
        int i3 = bVar.f18403a;
        String attributeValue3 = xmlPullParser.getAttributeValue(c, "subFrameRate");
        if (attributeValue3 != null) {
            i3 = Integer.parseInt(attributeValue3);
        }
        int i4 = bVar.b;
        String attributeValue4 = xmlPullParser.getAttributeValue(c, "tickRate");
        if (attributeValue4 != null) {
            i4 = Integer.parseInt(attributeValue4);
        }
        return new b(i2 * f2, i3, i4);
    }

    public static Map<String, TtmlStyle> s(XmlPullParser xmlPullParser, Map<String, TtmlStyle> map, a aVar, @Nullable c cVar, Map<String, pd9> map2, Map<String, String> map3) throws XmlPullParserException, IOException {
        do {
            xmlPullParser.next();
            if (x6a.f(xmlPullParser, "style")) {
                String strA = x6a.a(xmlPullParser, "style");
                TtmlStyle ttmlStyleX = x(xmlPullParser, new TtmlStyle());
                if (strA != null) {
                    for (String str : y(strA)) {
                        ttmlStyleX.a(map.get(str));
                    }
                }
                String strG = ttmlStyleX.g();
                if (strG != null) {
                    map.put(strG, ttmlStyleX);
                }
            } else if (x6a.f(xmlPullParser, "region")) {
                pd9 pd9VarV = v(xmlPullParser, aVar, cVar);
                if (pd9VarV != null) {
                    map2.put(pd9VarV.f18821a, pd9VarV);
                }
            } else if (x6a.f(xmlPullParser, "metadata")) {
                t(xmlPullParser, map3);
            }
        } while (!x6a.d(xmlPullParser, "head"));
        return map;
    }

    public static void t(XmlPullParser xmlPullParser, Map<String, String> map) throws XmlPullParserException, IOException {
        String strA;
        do {
            xmlPullParser.next();
            if (x6a.f(xmlPullParser, "image") && (strA = x6a.a(xmlPullParser, "id")) != null) {
                map.put(strA, xmlPullParser.nextText());
            }
        } while (!x6a.d(xmlPullParser, "metadata"));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:66:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:6:0x0039  */
    public static od9 u(XmlPullParser xmlPullParser, @Nullable od9 od9Var, Map<String, pd9> map, b bVar) throws SubtitleDecoderException {
        long j;
        long j2;
        int attributeCount = xmlPullParser.getAttributeCount();
        TtmlStyle ttmlStyleX = x(xmlPullParser, null);
        String[] strArr = null;
        String strSubstring = null;
        String str = "";
        long jZ = -9223372036854775807L;
        long jZ2 = -9223372036854775807L;
        long jZ3 = -9223372036854775807L;
        for (int i2 = 0; i2 < attributeCount; i2++) {
            String attributeName = xmlPullParser.getAttributeName(i2);
            String attributeValue = xmlPullParser.getAttributeValue(i2);
            attributeName.hashCode();
            switch (attributeName) {
                case "region":
                    if (map.containsKey(attributeValue)) {
                        str = attributeValue;
                        continue;
                    }
                    break;
                case "dur":
                    jZ3 = z(attributeValue, bVar);
                    break;
                case "end":
                    jZ2 = z(attributeValue, bVar);
                    break;
                case "begin":
                    jZ = z(attributeValue, bVar);
                    break;
                case "style":
                    String[] strArrY = y(attributeValue);
                    if (strArrY.length > 0) {
                        strArr = strArrY;
                        break;
                    }
                    break;
                case "backgroundImage":
                    if (attributeValue.startsWith("#")) {
                        strSubstring = attributeValue.substring(1);
                        break;
                    }
                    break;
            }
        }
        if (od9Var != null) {
            long j3 = od9Var.f43726a;
            j = -9223372036854775807L;
            if (j3 != -9223372036854775807L) {
                if (jZ != -9223372036854775807L) {
                    jZ += j3;
                }
                if (jZ2 != -9223372036854775807L) {
                    jZ2 += j3;
                }
            }
        } else {
            j = -9223372036854775807L;
        }
        long j4 = jZ;
        if (jZ2 != j) {
            j2 = jZ2;
        } else if (jZ3 != j) {
            j2 = j4 + jZ3;
        } else if (od9Var != null) {
            long j5 = od9Var.b;
            if (j5 != j) {
                j2 = j5;
            } else {
                j2 = jZ2;
            }
        } else {
            j2 = jZ2;
        }
        return od9.c(xmlPullParser.getName(), j4, j2, ttmlStyleX, strArr, str, strSubstring, od9Var);
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0169  */
    /* JADX WARN: Code duplicated, block: B:65:0x01b4  */
    @Nullable
    public static pd9 v(XmlPullParser xmlPullParser, a aVar, @Nullable c cVar) {
        float f2;
        float f3;
        float f4;
        float f5;
        int i2;
        float f6;
        int i3;
        String strA = x6a.a(xmlPullParser, "id");
        if (strA == null) {
            return null;
        }
        String strA2 = x6a.a(xmlPullParser, "origin");
        if (strA2 == null) {
            Log.n(b, "Ignoring region without an origin");
            return null;
        }
        Pattern pattern = f18399e;
        Matcher matcher = pattern.matcher(strA2);
        Pattern pattern2 = f18400f;
        Matcher matcher2 = pattern2.matcher(strA2);
        if (matcher.matches()) {
            try {
                float f7 = Float.parseFloat((String) sb0.g(matcher.group(1))) / 100.0f;
                f2 = Float.parseFloat((String) sb0.g(matcher.group(2))) / 100.0f;
                f3 = f7;
            } catch (NumberFormatException unused) {
                Log.n(b, "Ignoring region with malformed origin: " + strA2);
                return null;
            }
        } else {
            if (!matcher2.matches()) {
                Log.n(b, "Ignoring region with unsupported origin: " + strA2);
                return null;
            }
            if (cVar == null) {
                Log.n(b, "Ignoring region with missing tts:extent: " + strA2);
                return null;
            }
            try {
                int i4 = Integer.parseInt((String) sb0.g(matcher2.group(1)));
                int i5 = Integer.parseInt((String) sb0.g(matcher2.group(2)));
                f3 = i4 / cVar.f43504a;
                f2 = i5 / cVar.b;
            } catch (NumberFormatException unused2) {
                Log.n(b, "Ignoring region with malformed origin: " + strA2);
                return null;
            }
        }
        String strA3 = x6a.a(xmlPullParser, "extent");
        if (strA3 == null) {
            Log.n(b, "Ignoring region without an extent");
            return null;
        }
        Matcher matcher3 = pattern.matcher(strA3);
        Matcher matcher4 = pattern2.matcher(strA3);
        if (matcher3.matches()) {
            try {
                f4 = Float.parseFloat((String) sb0.g(matcher3.group(1))) / 100.0f;
                f5 = Float.parseFloat((String) sb0.g(matcher3.group(2))) / 100.0f;
            } catch (NumberFormatException unused3) {
                Log.n(b, "Ignoring region with malformed extent: " + strA2);
                return null;
            }
        } else {
            if (!matcher4.matches()) {
                Log.n(b, "Ignoring region with unsupported extent: " + strA2);
                return null;
            }
            if (cVar == null) {
                Log.n(b, "Ignoring region with missing tts:extent: " + strA2);
                return null;
            }
            try {
                int i6 = Integer.parseInt((String) sb0.g(matcher4.group(1)));
                int i7 = Integer.parseInt((String) sb0.g(matcher4.group(2)));
                f4 = i6 / cVar.f43504a;
                f5 = i7 / cVar.b;
            } catch (NumberFormatException unused4) {
                Log.n(b, "Ignoring region with malformed extent: " + strA2);
                return null;
            }
        }
        String strA4 = x6a.a(xmlPullParser, "displayAlign");
        if (strA4 != null) {
            String strG = com.google.common.base.a.g(strA4);
            strG.hashCode();
            if (strG.equals("center")) {
                f6 = f2 + (f5 / 2.0f);
                i2 = 1;
            } else if (strG.equals("after")) {
                f6 = f2 + f5;
                i2 = 2;
            } else {
                i2 = 0;
                f6 = f2;
            }
        } else {
            i2 = 0;
            f6 = f2;
        }
        float f8 = 1.0f / aVar.b;
        String strA5 = x6a.a(xmlPullParser, "writingMode");
        if (strA5 != null) {
            String strG2 = com.google.common.base.a.g(strA5);
            strG2.hashCode();
            switch (strG2) {
                case "tb":
                case "tblr":
                    i3 = 2;
                    break;
                case "tbrl":
                    i3 = 1;
                    break;
                default:
                    i3 = Integer.MIN_VALUE;
                    break;
            }
        } else {
            i3 = Integer.MIN_VALUE;
        }
        return new pd9(strA, f3, f6, 0, i2, f4, f5, 1, f8, i3);
    }

    public static float w(String str) {
        Matcher matcher = f18398d.matcher(str);
        if (!matcher.matches()) {
            Log.n(b, "Invalid value for shear: " + str);
            return Float.MAX_VALUE;
        }
        try {
            return Math.min(100.0f, Math.max(-100.0f, Float.parseFloat((String) sb0.g(matcher.group(1)))));
        } catch (NumberFormatException e2) {
            Log.o(b, "Failed to parse shear: " + str, e2);
            return Float.MAX_VALUE;
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static TtmlStyle x(XmlPullParser xmlPullParser, TtmlStyle ttmlStyle) {
        byte b2;
        int attributeCount = xmlPullParser.getAttributeCount();
        for (int i2 = 0; i2 < attributeCount; i2++) {
            String attributeValue = xmlPullParser.getAttributeValue(i2);
            String attributeName = xmlPullParser.getAttributeName(i2);
            attributeName.hashCode();
            switch (attributeName.hashCode()) {
                case -1550943582:
                    b2 = attributeName.equals("fontStyle") ? (byte) 0 : (byte) -1;
                    break;
                case -1224696685:
                    b2 = attributeName.equals("fontFamily") ? (byte) 1 : (byte) -1;
                    break;
                case -1065511464:
                    b2 = attributeName.equals("textAlign") ? (byte) 2 : (byte) -1;
                    break;
                case -879295043:
                    b2 = attributeName.equals("textDecoration") ? (byte) 3 : (byte) -1;
                    break;
                case -734428249:
                    b2 = attributeName.equals("fontWeight") ? (byte) 4 : (byte) -1;
                    break;
                case 3355:
                    b2 = attributeName.equals("id") ? (byte) 5 : (byte) -1;
                    break;
                case 3511770:
                    b2 = attributeName.equals("ruby") ? (byte) 6 : (byte) -1;
                    break;
                case 94842723:
                    b2 = attributeName.equals("color") ? (byte) 7 : (byte) -1;
                    break;
                case 109403361:
                    b2 = attributeName.equals("shear") ? (byte) 8 : (byte) -1;
                    break;
                case 110138194:
                    b2 = attributeName.equals("textCombine") ? (byte) 9 : (byte) -1;
                    break;
                case 365601008:
                    b2 = attributeName.equals("fontSize") ? (byte) 10 : (byte) -1;
                    break;
                case 921125321:
                    b2 = attributeName.equals("textEmphasis") ? (byte) 11 : (byte) -1;
                    break;
                case 1115953443:
                    b2 = attributeName.equals("rubyPosition") ? (byte) 12 : (byte) -1;
                    break;
                case 1287124693:
                    b2 = attributeName.equals("backgroundColor") ? (byte) 13 : (byte) -1;
                    break;
                case 1754920356:
                    b2 = attributeName.equals("multiRowAlign") ? com.google.common.base.a.p : (byte) -1;
                    break;
                default:
                    b2 = -1;
                    break;
            }
            switch (b2) {
                case 0:
                    ttmlStyle = m(ttmlStyle).C("italic".equalsIgnoreCase(attributeValue));
                    break;
                case 1:
                    ttmlStyle = m(ttmlStyle).y(attributeValue);
                    break;
                case 2:
                    ttmlStyle = m(ttmlStyle).I(o(attributeValue));
                    break;
                case 3:
                    String strG = com.google.common.base.a.g(attributeValue);
                    strG.hashCode();
                    switch (strG) {
                        case "nounderline":
                            ttmlStyle = m(ttmlStyle).L(false);
                            break;
                        case "underline":
                            ttmlStyle = m(ttmlStyle).L(true);
                            break;
                        case "nolinethrough":
                            ttmlStyle = m(ttmlStyle).D(false);
                            break;
                        case "linethrough":
                            ttmlStyle = m(ttmlStyle).D(true);
                            break;
                    }
                    break;
                case 4:
                    ttmlStyle = m(ttmlStyle).w("bold".equalsIgnoreCase(attributeValue));
                    break;
                case 5:
                    if ("style".equals(xmlPullParser.getName())) {
                        ttmlStyle = m(ttmlStyle).B(attributeValue);
                    }
                    break;
                case 6:
                    String strG2 = com.google.common.base.a.g(attributeValue);
                    strG2.hashCode();
                    switch (strG2) {
                        case "baseContainer":
                        case "base":
                            ttmlStyle = m(ttmlStyle).G(2);
                            break;
                        case "container":
                            ttmlStyle = m(ttmlStyle).G(1);
                            break;
                        case "delimiter":
                            ttmlStyle = m(ttmlStyle).G(4);
                            break;
                        case "textContainer":
                        case "text":
                            ttmlStyle = m(ttmlStyle).G(3);
                            break;
                    }
                    break;
                case 7:
                    ttmlStyle = m(ttmlStyle);
                    try {
                        ttmlStyle.x(un1.c(attributeValue));
                    } catch (IllegalArgumentException unused) {
                        Log.n(b, "Failed parsing color value: " + attributeValue);
                    }
                    break;
                case 8:
                    ttmlStyle = m(ttmlStyle).H(w(attributeValue));
                    break;
                case 9:
                    String strG3 = com.google.common.base.a.g(attributeValue);
                    strG3.hashCode();
                    if (strG3.equals("all")) {
                        ttmlStyle = m(ttmlStyle).J(true);
                    } else if (strG3.equals("none")) {
                        ttmlStyle = m(ttmlStyle).J(false);
                    }
                    break;
                case 10:
                    try {
                        ttmlStyle = m(ttmlStyle);
                        q(attributeValue, ttmlStyle);
                    } catch (SubtitleDecoderException unused2) {
                        Log.n(b, "Failed parsing fontSize value: " + attributeValue);
                    }
                    break;
                case 11:
                    ttmlStyle = m(ttmlStyle).K(TextEmphasis.a(attributeValue));
                    break;
                case 12:
                    String strG4 = com.google.common.base.a.g(attributeValue);
                    strG4.hashCode();
                    if (strG4.equals("before")) {
                        ttmlStyle = m(ttmlStyle).F(1);
                    } else if (strG4.equals("after")) {
                        ttmlStyle = m(ttmlStyle).F(2);
                    }
                    break;
                case 13:
                    ttmlStyle = m(ttmlStyle);
                    try {
                        ttmlStyle.v(un1.c(attributeValue));
                    } catch (IllegalArgumentException unused3) {
                        Log.n(b, "Failed parsing background value: " + attributeValue);
                    }
                    break;
                case 14:
                    ttmlStyle = m(ttmlStyle).E(o(attributeValue));
                    break;
            }
        }
        return ttmlStyle;
    }

    public static String[] y(String str) {
        String strTrim = str.trim();
        return strTrim.isEmpty() ? new String[0] : gj9.u1(strTrim, "\\s+");
    }

    public static long z(String str, b bVar) throws SubtitleDecoderException {
        double d2;
        double d3;
        Matcher matcher = f18394a.matcher(str);
        if (matcher.matches()) {
            double d4 = (Long.parseLong((String) sb0.g(matcher.group(1))) * 3600) + (Long.parseLong((String) sb0.g(matcher.group(2))) * 60) + Long.parseLong((String) sb0.g(matcher.group(3)));
            String strGroup = matcher.group(4);
            double d5 = AudioStats.AUDIO_AMPLITUDE_NONE;
            double d6 = d4 + (strGroup != null ? Double.parseDouble(strGroup) : 0.0d);
            String strGroup2 = matcher.group(5);
            double d7 = d6 + (strGroup2 != null ? Long.parseLong(strGroup2) / bVar.f43503a : 0.0d);
            String strGroup3 = matcher.group(6);
            if (strGroup3 != null) {
                d5 = (Long.parseLong(strGroup3) / ((double) bVar.f18403a)) / ((double) bVar.f43503a);
            }
            return (long) ((d7 + d5) * 1000000.0d);
        }
        Matcher matcher2 = f18395b.matcher(str);
        if (!matcher2.matches()) {
            throw new SubtitleDecoderException("Malformed time expression: " + str);
        }
        double d8 = Double.parseDouble((String) sb0.g(matcher2.group(1)));
        String str2 = (String) sb0.g(matcher2.group(2));
        str2.hashCode();
        switch (str2) {
            case "f":
                d2 = bVar.f43503a;
                d8 /= d2;
                return (long) (d8 * 1000000.0d);
            case "h":
                d3 = 3600.0d;
                break;
            case "m":
                d3 = 60.0d;
                break;
            case "t":
                d2 = bVar.b;
                d8 /= d2;
                return (long) (d8 * 1000000.0d);
            case "ms":
                d2 = 1000.0d;
                d8 /= d2;
                return (long) (d8 * 1000000.0d);
            default:
                return (long) (d8 * 1000000.0d);
        }
        d8 *= d3;
        return (long) (d8 * 1000000.0d);
    }

    @Override // com.google.android.exoplayer2.text.SimpleSubtitleDecoder
    public Subtitle decode(byte[] bArr, int i2, boolean z) throws SubtitleDecoderException {
        b bVar;
        try {
            XmlPullParser xmlPullParserF = this.f18402a.f();
            HashMap map = new HashMap();
            HashMap map2 = new HashMap();
            HashMap map3 = new HashMap();
            map2.put("", new pd9(""));
            c cVarA = null;
            xmlPullParserF.setInput(new ByteArrayInputStream(bArr, 0, i2), null);
            ArrayDeque arrayDeque = new ArrayDeque();
            b bVarR = f18393a;
            a aVarP = f43501a;
            int i3 = 0;
            rd9 rd9Var = null;
            for (int eventType = xmlPullParserF.getEventType(); eventType != 1; eventType = xmlPullParserF.getEventType()) {
                od9 od9Var = (od9) arrayDeque.peek();
                if (i3 == 0) {
                    String name = xmlPullParserF.getName();
                    if (eventType == 2) {
                        if ("tt".equals(name)) {
                            bVarR = r(xmlPullParserF);
                            aVarP = p(xmlPullParserF, f43501a);
                            cVarA = A(xmlPullParserF);
                        }
                        c cVar = cVarA;
                        b bVar2 = bVarR;
                        a aVar = aVarP;
                        if (n(name)) {
                            if ("head".equals(name)) {
                                bVar = bVar2;
                                s(xmlPullParserF, map, aVar, cVar, map2, map3);
                            } else {
                                bVar = bVar2;
                                try {
                                    od9 od9VarU = u(xmlPullParserF, od9Var, map2, bVar);
                                    arrayDeque.push(od9VarU);
                                    if (od9Var != null) {
                                        od9Var.a(od9VarU);
                                    }
                                } catch (SubtitleDecoderException e2) {
                                    Log.o(b, "Suppressing parser error", e2);
                                    i3++;
                                }
                            }
                            bVarR = bVar;
                        } else {
                            Log.h(b, "Ignoring unsupported tag: " + xmlPullParserF.getName());
                            i3++;
                            bVarR = bVar2;
                        }
                        cVarA = cVar;
                        aVarP = aVar;
                    } else if (eventType == 4) {
                        ((od9) sb0.g(od9Var)).a(od9.d(xmlPullParserF.getText()));
                    } else if (eventType == 3) {
                        if (xmlPullParserF.getName().equals("tt")) {
                            rd9Var = new rd9((od9) sb0.g((od9) arrayDeque.peek()), map, map2, map3);
                        }
                        arrayDeque.pop();
                    }
                } else if (eventType == 2) {
                    i3++;
                } else if (eventType == 3) {
                    i3--;
                }
                xmlPullParserF.next();
            }
            if (rd9Var != null) {
                return rd9Var;
            }
            throw new SubtitleDecoderException("No TTML subtitles found");
        } catch (IOException e3) {
            throw new IllegalStateException("Unexpected error when reading input.", e3);
        } catch (XmlPullParserException e4) {
            throw new SubtitleDecoderException("Unable to decode source", e4);
        }
    }
}
