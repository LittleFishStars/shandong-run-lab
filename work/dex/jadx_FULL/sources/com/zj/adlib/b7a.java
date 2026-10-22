package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.util.Log;
import com.google.common.collect.ImmutableList;
import java.io.IOException;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class b7a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f40692a = "MotionPhotoXmpParser";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String[] f15459a = {"Camera:MotionPhoto", "GCamera:MotionPhoto", "Camera:MicroVideo", "GCamera:MicroVideo"};
    public static final String[] b = {"Camera:MotionPhotoPresentationTimestampUs", "GCamera:MotionPhotoPresentationTimestampUs", "Camera:MicroVideoPresentationTimestampUs", "GCamera:MicroVideoPresentationTimestampUs"};
    public static final String[] c = {"Camera:MicroVideoOffset", "GCamera:MicroVideoOffset"};

    @Nullable
    public static vr5 a(String str) throws IOException {
        try {
            return b(str);
        } catch (ParserException | NumberFormatException | XmlPullParserException unused) {
            Log.n(f40692a, "Ignoring unexpected XMP metadata");
            return null;
        }
    }

    @Nullable
    public static vr5 b(String str) throws XmlPullParserException, IOException {
        XmlPullParser xmlPullParserF = u6a.d().f();
        xmlPullParserF.setInput(new StringReader(str));
        xmlPullParserF.next();
        if (!x6a.f(xmlPullParserF, "x:xmpmeta")) {
            throw ParserException.createForMalformedContainer("Couldn't find xmp metadata", null);
        }
        ImmutableList<vr5.a> immutableListOf = ImmutableList.of();
        long jE = -9223372036854775807L;
        do {
            xmlPullParserF.next();
            if (x6a.f(xmlPullParserF, "rdf:Description")) {
                if (!d(xmlPullParserF)) {
                    return null;
                }
                jE = e(xmlPullParserF);
                immutableListOf = c(xmlPullParserF);
            } else if (x6a.f(xmlPullParserF, "Container:Directory")) {
                immutableListOf = f(xmlPullParserF, "Container", "Item");
            } else if (x6a.f(xmlPullParserF, "GContainer:Directory")) {
                immutableListOf = f(xmlPullParserF, "GContainer", "GContainerItem");
            }
        } while (!x6a.d(xmlPullParserF, "x:xmpmeta"));
        if (immutableListOf.isEmpty()) {
            return null;
        }
        return new vr5(jE, immutableListOf);
    }

    public static ImmutableList<vr5.a> c(XmlPullParser xmlPullParser) {
        for (String str : c) {
            String strA = x6a.a(xmlPullParser, str);
            if (strA != null) {
                return ImmutableList.of(new vr5.a("image/jpeg", "Primary", 0L, 0L), new vr5.a("video/mp4", "MotionPhoto", Long.parseLong(strA), 0L));
            }
        }
        return ImmutableList.of();
    }

    public static boolean d(XmlPullParser xmlPullParser) {
        for (String str : f15459a) {
            String strA = x6a.a(xmlPullParser, str);
            if (strA != null) {
                return Integer.parseInt(strA) == 1;
            }
        }
        return false;
    }

    public static long e(XmlPullParser xmlPullParser) {
        for (String str : b) {
            String strA = x6a.a(xmlPullParser, str);
            if (strA != null) {
                long j = Long.parseLong(strA);
                if (j == -1) {
                    return -9223372036854775807L;
                }
                return j;
            }
        }
        return -9223372036854775807L;
    }

    public static ImmutableList<vr5.a> f(XmlPullParser xmlPullParser, String str, String str2) throws XmlPullParserException, IOException {
        ImmutableList.a aVarBuilder = ImmutableList.builder();
        String str3 = str + ":Item";
        String str4 = str + ":Directory";
        do {
            xmlPullParser.next();
            if (x6a.f(xmlPullParser, str3)) {
                String strA = x6a.a(xmlPullParser, str2 + ":Mime");
                String strA2 = x6a.a(xmlPullParser, str2 + ":Semantic");
                String strA3 = x6a.a(xmlPullParser, str2 + ":Length");
                String strA4 = x6a.a(xmlPullParser, str2 + ":Padding");
                if (strA == null || strA2 == null) {
                    return ImmutableList.of();
                }
                aVarBuilder.a(new vr5.a(strA, strA2, strA3 != null ? Long.parseLong(strA3) : 0L, strA4 != null ? Long.parseLong(strA4) : 0L));
            }
        } while (!x6a.d(xmlPullParser, str4));
        return aVarBuilder.e();
    }
}
