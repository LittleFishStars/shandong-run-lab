package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.zj.adlib.cv7;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class k implements ValueParser<cv7> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final k f23392a = new k();

    @Override // com.airbnb.lottie.parser.ValueParser
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public cv7 a(JsonReader jsonReader, float f) throws IOException {
        boolean z = jsonReader.y() == JsonReader.Token.BEGIN_ARRAY;
        if (z) {
            jsonReader.g();
        }
        float fQ = (float) jsonReader.q();
        float fQ2 = (float) jsonReader.q();
        while (jsonReader.l()) {
            jsonReader.J();
        }
        if (z) {
            jsonReader.j();
        }
        return new cv7((fQ / 100.0f) * f, (fQ2 / 100.0f) * f);
    }
}
