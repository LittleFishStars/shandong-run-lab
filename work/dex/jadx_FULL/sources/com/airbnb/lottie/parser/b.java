package com.airbnb.lottie.parser;

import android.graphics.Color;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b implements ValueParser<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f23383a = new b();

    @Override // com.airbnb.lottie.parser.ValueParser
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public Integer a(JsonReader jsonReader, float f) throws IOException {
        boolean z = jsonReader.y() == JsonReader.Token.BEGIN_ARRAY;
        if (z) {
            jsonReader.g();
        }
        double dQ = jsonReader.q();
        double dQ2 = jsonReader.q();
        double dQ3 = jsonReader.q();
        double dQ4 = jsonReader.y() == JsonReader.Token.NUMBER ? jsonReader.q() : 1.0d;
        if (z) {
            jsonReader.j();
        }
        if (dQ <= 1.0d && dQ2 <= 1.0d && dQ3 <= 1.0d) {
            dQ *= 255.0d;
            dQ2 *= 255.0d;
            dQ3 *= 255.0d;
            if (dQ4 <= 1.0d) {
                dQ4 *= 255.0d;
            }
        }
        return Integer.valueOf(Color.argb((int) dQ4, (int) dQ, (int) dQ2, (int) dQ3));
    }
}
