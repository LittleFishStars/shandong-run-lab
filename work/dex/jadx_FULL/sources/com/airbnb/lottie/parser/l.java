package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.zj.adlib.ap4;
import com.zj.adlib.g88;
import com.zj.adlib.py1;
import com.zj.adlib.up5;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class l implements ValueParser<g88> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f23393a = new l();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final JsonReader.a f585a = JsonReader.a.a("c", "v", "i", com.google.android.exoplayer2.source.rtsp.j.b);

    @Override // com.airbnb.lottie.parser.ValueParser
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public g88 a(JsonReader jsonReader, float f) throws IOException {
        if (jsonReader.y() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.g();
        }
        jsonReader.h();
        List<PointF> listF = null;
        List<PointF> listF2 = null;
        List<PointF> listF3 = null;
        boolean zP = false;
        while (jsonReader.l()) {
            int iF = jsonReader.F(f585a);
            if (iF == 0) {
                zP = jsonReader.p();
            } else if (iF == 1) {
                listF = ap4.f(jsonReader, f);
            } else if (iF == 2) {
                listF2 = ap4.f(jsonReader, f);
            } else if (iF != 3) {
                jsonReader.H();
                jsonReader.J();
            } else {
                listF3 = ap4.f(jsonReader, f);
            }
        }
        jsonReader.k();
        if (jsonReader.y() == JsonReader.Token.END_ARRAY) {
            jsonReader.j();
        }
        if (listF == null || listF2 == null || listF3 == null) {
            throw new IllegalArgumentException("Shape data was missing information.");
        }
        if (listF.isEmpty()) {
            return new g88(new PointF(), false, Collections.emptyList());
        }
        int size = listF.size();
        PointF pointF = listF.get(0);
        ArrayList arrayList = new ArrayList(size);
        for (int i = 1; i < size; i++) {
            PointF pointF2 = listF.get(i);
            int i2 = i - 1;
            arrayList.add(new py1(up5.a(listF.get(i2), listF3.get(i2)), up5.a(pointF2, listF2.get(i)), pointF2));
        }
        if (zP) {
            PointF pointF3 = listF.get(0);
            int i3 = size - 1;
            arrayList.add(new py1(up5.a(listF.get(i3), listF3.get(i3)), up5.a(pointF3, listF2.get(0)), pointF3));
        }
        return new g88(pointF, zP, arrayList);
    }
}
