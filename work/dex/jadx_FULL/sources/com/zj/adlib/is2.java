package com.zj.adlib;

import androidx.annotation.Nullable;
import com.airbnb.lottie.model.animatable.a;
import com.airbnb.lottie.model.animatable.b;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.amap.api.col.p0003l.ef;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class is2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f42434a = JsonReader.a.a(ef.f25915a);
    public static final JsonReader.a b = JsonReader.a.a("nm", "v");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public a f17261a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f17262a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public b f17263b;
    public b c;
    public b d;

    public final void a(JsonReader jsonReader, k35 k35Var) throws IOException {
        jsonReader.h();
        String strV = "";
        while (jsonReader.l()) {
            int iF = jsonReader.F(b);
            if (iF != 0) {
                if (iF == 1) {
                    strV.hashCode();
                    switch (strV) {
                        case "Distance":
                            this.c = com.airbnb.lottie.parser.a.e(jsonReader, k35Var);
                            break;
                        case "Opacity":
                            this.f17262a = com.airbnb.lottie.parser.a.f(jsonReader, k35Var, false);
                            break;
                        case "Direction":
                            this.f17263b = com.airbnb.lottie.parser.a.f(jsonReader, k35Var, false);
                            break;
                        case "Shadow Color":
                            this.f17261a = com.airbnb.lottie.parser.a.c(jsonReader, k35Var);
                            break;
                        case "Softness":
                            this.d = com.airbnb.lottie.parser.a.e(jsonReader, k35Var);
                            break;
                        default:
                            jsonReader.J();
                            break;
                    }
                } else {
                    jsonReader.H();
                    jsonReader.J();
                }
            } else {
                strV = jsonReader.v();
            }
        }
        jsonReader.k();
    }

    @Nullable
    public hs2 b(JsonReader jsonReader, k35 k35Var) throws IOException {
        b bVar;
        b bVar2;
        b bVar3;
        b bVar4;
        while (jsonReader.l()) {
            if (jsonReader.F(f42434a) != 0) {
                jsonReader.H();
                jsonReader.J();
            } else {
                jsonReader.g();
                while (jsonReader.l()) {
                    a(jsonReader, k35Var);
                }
                jsonReader.j();
            }
        }
        a aVar = this.f17261a;
        if (aVar == null || (bVar = this.f17262a) == null || (bVar2 = this.f17263b) == null || (bVar3 = this.c) == null || (bVar4 = this.d) == null) {
            return null;
        }
        return new hs2(aVar, bVar, bVar2, bVar3, bVar4);
    }
}
