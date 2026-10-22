package com.zj.adlib;

import com.airbnb.lottie.model.animatable.d;
import com.airbnb.lottie.model.animatable.g;
import com.airbnb.lottie.model.content.Mask;
import com.airbnb.lottie.parser.a;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class e85 {
    public static Mask a(JsonReader jsonReader, k35 k35Var) throws IOException {
        jsonReader.h();
        Mask.MaskMode maskMode = null;
        g gVarK = null;
        d dVarH = null;
        boolean zP = false;
        while (jsonReader.l()) {
            String strS = jsonReader.s();
            strS.hashCode();
            switch (strS) {
                case "o":
                    dVarH = a.h(jsonReader, k35Var);
                    break;
                case "pt":
                    gVarK = a.k(jsonReader, k35Var);
                    break;
                case "inv":
                    zP = jsonReader.p();
                    break;
                case "mode":
                    String strV = jsonReader.v();
                    strV.hashCode();
                    switch (strV) {
                        case "a":
                            maskMode = Mask.MaskMode.MASK_MODE_ADD;
                            break;
                        case "i":
                            k35Var.a("Animation contains intersect masks. They are not supported but will be treated like add masks.");
                            maskMode = Mask.MaskMode.MASK_MODE_INTERSECT;
                            break;
                        case "n":
                            maskMode = Mask.MaskMode.MASK_MODE_NONE;
                            break;
                        case "s":
                            maskMode = Mask.MaskMode.MASK_MODE_SUBTRACT;
                            break;
                        default:
                            g25.e("Unknown mask mode " + strS + ". Defaulting to Add.");
                            maskMode = Mask.MaskMode.MASK_MODE_ADD;
                            break;
                    }
                    break;
                default:
                    jsonReader.J();
                    break;
            }
        }
        jsonReader.k();
        return new Mask(maskMode, gVarK, dVarH, zP);
    }
}
