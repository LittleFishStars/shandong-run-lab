package com.airbnb.lottie.parser;

import com.airbnb.lottie.parser.moshi.JsonReader;
import com.zj.adlib.k35;
import com.zj.adlib.ps4;
import com.zj.adlib.zm6;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static JsonReader.a f23389a = JsonReader.a.a("k");

    public static <T> List<ps4<T>> a(JsonReader jsonReader, k35 k35Var, float f, ValueParser<T> valueParser, boolean z) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.y() == JsonReader.Token.STRING) {
            k35Var.a("Lottie doesn't support expressions.");
            return arrayList;
        }
        jsonReader.h();
        while (jsonReader.l()) {
            if (jsonReader.F(f23389a) != 0) {
                jsonReader.J();
            } else if (jsonReader.y() == JsonReader.Token.BEGIN_ARRAY) {
                jsonReader.g();
                if (jsonReader.y() == JsonReader.Token.NUMBER) {
                    arrayList.add(g.c(jsonReader, k35Var, f, valueParser, false, z));
                } else {
                    while (jsonReader.l()) {
                        arrayList.add(g.c(jsonReader, k35Var, f, valueParser, true, z));
                    }
                }
                jsonReader.j();
            } else {
                arrayList.add(g.c(jsonReader, k35Var, f, valueParser, false, z));
            }
        }
        jsonReader.k();
        b(arrayList);
        return arrayList;
    }

    public static <T> void b(List<? extends ps4<T>> list) {
        int i;
        T t;
        int size = list.size();
        int i2 = 0;
        while (true) {
            i = size - 1;
            if (i2 >= i) {
                break;
            }
            ps4<T> ps4Var = list.get(i2);
            i2++;
            ps4<T> ps4Var2 = list.get(i2);
            ps4Var.f18927a = Float.valueOf(ps4Var2.f44051a);
            if (ps4Var.f18932b == null && (t = ps4Var2.f18928a) != null) {
                ps4Var.f18932b = t;
                if (ps4Var instanceof zm6) {
                    ((zm6) ps4Var).i();
                }
            }
        }
        ps4<T> ps4Var3 = list.get(i);
        if ((ps4Var3.f18928a == null || ps4Var3.f18932b == null) && list.size() > 1) {
            list.remove(ps4Var3);
        }
    }
}
