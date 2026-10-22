package com.zj.adlib;

import com.airbnb.lottie.parser.g;
import com.airbnb.lottie.parser.i;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class an6 {
    public static zm6 a(JsonReader jsonReader, k35 k35Var) throws IOException {
        return new zm6(k35Var, g.c(jsonReader, k35Var, vj9.e(), i.f23390a, jsonReader.y() == JsonReader.Token.BEGIN_OBJECT, false));
    }
}
