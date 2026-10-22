package com.zj.adlib;

import android.graphics.PointF;
import com.airbnb.lottie.model.animatable.AnimatableValue;
import com.airbnb.lottie.model.animatable.b;
import com.airbnb.lottie.parser.a;
import com.airbnb.lottie.parser.h;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class i60 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f42288a = JsonReader.a.a("k", "x", "y");

    public static h60 a(JsonReader jsonReader, k35 k35Var) throws IOException {
        ArrayList arrayList = new ArrayList();
        if (jsonReader.y() == JsonReader.Token.BEGIN_ARRAY) {
            jsonReader.g();
            while (jsonReader.l()) {
                arrayList.add(an6.a(jsonReader, k35Var));
            }
            jsonReader.j();
            h.b(arrayList);
        } else {
            arrayList.add(new ps4(ap4.e(jsonReader, vj9.e())));
        }
        return new h60(arrayList);
    }

    public static AnimatableValue<PointF, PointF> b(JsonReader jsonReader, k35 k35Var) throws IOException {
        jsonReader.h();
        h60 h60VarA = null;
        b bVarE = null;
        boolean z = false;
        b bVarE2 = null;
        while (jsonReader.y() != JsonReader.Token.END_OBJECT) {
            int iF = jsonReader.F(f42288a);
            if (iF == 0) {
                h60VarA = a(jsonReader, k35Var);
            } else if (iF != 1) {
                if (iF != 2) {
                    jsonReader.H();
                    jsonReader.J();
                } else if (jsonReader.y() == JsonReader.Token.STRING) {
                    jsonReader.J();
                    z = true;
                } else {
                    bVarE = a.e(jsonReader, k35Var);
                }
            } else if (jsonReader.y() == JsonReader.Token.STRING) {
                jsonReader.J();
                z = true;
            } else {
                bVarE2 = a.e(jsonReader, k35Var);
            }
        }
        jsonReader.k();
        if (z) {
            k35Var.a("Lottie doesn't support expressions.");
        }
        return h60VarA != null ? h60VarA : new j60(bVarE2, bVarE);
    }
}
