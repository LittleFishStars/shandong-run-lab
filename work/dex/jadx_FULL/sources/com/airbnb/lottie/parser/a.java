package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.zj.adlib.cv7;
import com.zj.adlib.k35;
import com.zj.adlib.ps4;
import com.zj.adlib.vj9;
import java.io.IOException;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {
    public static <T> List<ps4<T>> a(JsonReader jsonReader, float f, k35 k35Var, ValueParser<T> valueParser) throws IOException {
        return h.a(jsonReader, k35Var, f, valueParser, false);
    }

    public static <T> List<ps4<T>> b(JsonReader jsonReader, k35 k35Var, ValueParser<T> valueParser) throws IOException {
        return h.a(jsonReader, k35Var, 1.0f, valueParser, false);
    }

    public static com.airbnb.lottie.model.animatable.a c(JsonReader jsonReader, k35 k35Var) throws IOException {
        return new com.airbnb.lottie.model.animatable.a(b(jsonReader, k35Var, b.f23383a));
    }

    public static com.airbnb.lottie.model.animatable.h d(JsonReader jsonReader, k35 k35Var) throws IOException {
        return new com.airbnb.lottie.model.animatable.h(b(jsonReader, k35Var, c.f23384a));
    }

    public static com.airbnb.lottie.model.animatable.b e(JsonReader jsonReader, k35 k35Var) throws IOException {
        return f(jsonReader, k35Var, true);
    }

    public static com.airbnb.lottie.model.animatable.b f(JsonReader jsonReader, k35 k35Var, boolean z) throws IOException {
        return new com.airbnb.lottie.model.animatable.b(a(jsonReader, z ? vj9.e() : 1.0f, k35Var, d.f23385a));
    }

    public static com.airbnb.lottie.model.animatable.c g(JsonReader jsonReader, k35 k35Var, int i) throws IOException {
        return new com.airbnb.lottie.model.animatable.c(b(jsonReader, k35Var, new e(i)));
    }

    public static com.airbnb.lottie.model.animatable.d h(JsonReader jsonReader, k35 k35Var) throws IOException {
        return new com.airbnb.lottie.model.animatable.d(b(jsonReader, k35Var, f.f23387a));
    }

    public static com.airbnb.lottie.model.animatable.e i(JsonReader jsonReader, k35 k35Var) throws IOException {
        return new com.airbnb.lottie.model.animatable.e(h.a(jsonReader, k35Var, vj9.e(), j.f23391a, true));
    }

    public static com.airbnb.lottie.model.animatable.f j(JsonReader jsonReader, k35 k35Var) throws IOException {
        return new com.airbnb.lottie.model.animatable.f((List<ps4<cv7>>) b(jsonReader, k35Var, k.f23392a));
    }

    public static com.airbnb.lottie.model.animatable.g k(JsonReader jsonReader, k35 k35Var) throws IOException {
        return new com.airbnb.lottie.model.animatable.g(a(jsonReader, vj9.e(), k35Var, l.f23393a));
    }
}
