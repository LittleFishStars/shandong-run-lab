package com.airbnb.lottie.parser;

import android.graphics.PointF;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.zj.adlib.ap4;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class j implements ValueParser<PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j f23391a = new j();

    @Override // com.airbnb.lottie.parser.ValueParser
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public PointF a(JsonReader jsonReader, float f) throws IOException {
        JsonReader.Token tokenY = jsonReader.y();
        if (tokenY != JsonReader.Token.BEGIN_ARRAY && tokenY != JsonReader.Token.BEGIN_OBJECT) {
            if (tokenY == JsonReader.Token.NUMBER) {
                PointF pointF = new PointF(((float) jsonReader.q()) * f, ((float) jsonReader.q()) * f);
                while (jsonReader.l()) {
                    jsonReader.J();
                }
                return pointF;
            }
            throw new IllegalArgumentException("Cannot convert json to point. Next token is " + tokenY);
        }
        return ap4.e(jsonReader, f);
    }
}
