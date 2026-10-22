package com.zj.adlib;

import android.graphics.Color;
import android.graphics.PointF;
import androidx.annotation.ColorInt;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ap4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f40575a = JsonReader.a.a("x", "y");

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f40576a;

        static {
            int[] iArr = new int[JsonReader.Token.values().length];
            f40576a = iArr;
            try {
                iArr[JsonReader.Token.NUMBER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f40576a[JsonReader.Token.BEGIN_ARRAY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f40576a[JsonReader.Token.BEGIN_OBJECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public static PointF a(JsonReader jsonReader, float f) throws IOException {
        jsonReader.g();
        float fQ = (float) jsonReader.q();
        float fQ2 = (float) jsonReader.q();
        while (jsonReader.y() != JsonReader.Token.END_ARRAY) {
            jsonReader.J();
        }
        jsonReader.j();
        return new PointF(fQ * f, fQ2 * f);
    }

    public static PointF b(JsonReader jsonReader, float f) throws IOException {
        float fQ = (float) jsonReader.q();
        float fQ2 = (float) jsonReader.q();
        while (jsonReader.l()) {
            jsonReader.J();
        }
        return new PointF(fQ * f, fQ2 * f);
    }

    public static PointF c(JsonReader jsonReader, float f) throws IOException {
        jsonReader.h();
        float fG = 0.0f;
        float fG2 = 0.0f;
        while (jsonReader.l()) {
            int iF = jsonReader.F(f40575a);
            if (iF == 0) {
                fG = g(jsonReader);
            } else if (iF != 1) {
                jsonReader.H();
                jsonReader.J();
            } else {
                fG2 = g(jsonReader);
            }
        }
        jsonReader.k();
        return new PointF(fG * f, fG2 * f);
    }

    @ColorInt
    public static int d(JsonReader jsonReader) throws IOException {
        jsonReader.g();
        int iQ = (int) (jsonReader.q() * 255.0d);
        int iQ2 = (int) (jsonReader.q() * 255.0d);
        int iQ3 = (int) (jsonReader.q() * 255.0d);
        while (jsonReader.l()) {
            jsonReader.J();
        }
        jsonReader.j();
        return Color.argb(255, iQ, iQ2, iQ3);
    }

    public static PointF e(JsonReader jsonReader, float f) throws IOException {
        int i = a.f40576a[jsonReader.y().ordinal()];
        if (i == 1) {
            return b(jsonReader, f);
        }
        if (i == 2) {
            return a(jsonReader, f);
        }
        if (i == 3) {
            return c(jsonReader, f);
        }
        throw new IllegalArgumentException("Unknown point starts with " + jsonReader.y());
    }

    public static List<PointF> f(JsonReader jsonReader, float f) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.g();
        while (jsonReader.y() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.g();
            arrayList.add(e(jsonReader, f));
            jsonReader.j();
        }
        jsonReader.j();
        return arrayList;
    }

    public static float g(JsonReader jsonReader) throws IOException {
        JsonReader.Token tokenY = jsonReader.y();
        int i = a.f40576a[tokenY.ordinal()];
        if (i == 1) {
            return (float) jsonReader.q();
        }
        if (i != 2) {
            throw new IllegalArgumentException("Unknown value for token of type " + tokenY);
        }
        jsonReader.g();
        float fQ = (float) jsonReader.q();
        while (jsonReader.l()) {
            jsonReader.J();
        }
        jsonReader.j();
        return fQ;
    }
}
