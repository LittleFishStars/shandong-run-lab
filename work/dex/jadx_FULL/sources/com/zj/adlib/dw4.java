package com.zj.adlib;

import android.graphics.Color;
import android.graphics.Rect;
import cn.hzjizhun.admin.util.ShellUtils;
import com.airbnb.lottie.model.animatable.b;
import com.airbnb.lottie.model.animatable.h;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.kernel.RVParams;
import com.aliyun.vod.log.struct.AliyunLogKey;
import com.amap.api.col.p0003l.ef;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class dw4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f41293a = JsonReader.a.a("nm", "ind", "refId", com.alipay.sdk.m.w.a.u, "parent", "sw", ShellUtils.COMMAND_SH, "sc", MediationConstant.ADN_KS, "tt", "masksProperties", "shapes", "t", ef.f25915a, RVParams.SHOW_REPORT_BTN, "st", "w", y6b.g, LoginConstants.IP, AliyunLogKey.KEY_OUTPUT_PATH, RVParams.TOOLBAR_MENU, "cl", LiveConfigKey.HIGH);
    public static final JsonReader.a b = JsonReader.a.a("d", "a");
    public static final JsonReader.a c = JsonReader.a.a(com.alipay.sdk.m.w.a.u, "nm");

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f41294a;

        static {
            int[] iArr = new int[Layer.MatteType.values().length];
            f41294a = iArr;
            try {
                iArr[Layer.MatteType.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f41294a[Layer.MatteType.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static Layer a(JsonReader jsonReader, k35 k35Var) throws IOException {
        ArrayList arrayList;
        float f;
        Layer.MatteType matteType = Layer.MatteType.NONE;
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        jsonReader.h();
        Float fValueOf = Float.valueOf(1.0f);
        Float fValueOf2 = Float.valueOf(0.0f);
        Layer.MatteType matteType2 = matteType;
        Layer.LayerType layerType = null;
        String strV = null;
        m60 m60VarG = null;
        h hVarD = null;
        k60 k60VarA = null;
        b bVarF = null;
        sy0 sy0VarB = null;
        hs2 hs2VarB = null;
        long jR = 0;
        int iR = 0;
        int iR2 = 0;
        int color = 0;
        int iR3 = 0;
        int iR4 = 0;
        boolean zP = false;
        float fQ = 1.0f;
        long jR2 = -1;
        float fQ2 = 0.0f;
        float fQ3 = 0.0f;
        float f2 = 0.0f;
        String strV2 = "UNSET";
        String strV3 = null;
        while (jsonReader.l()) {
            switch (jsonReader.F(f41293a)) {
                case 0:
                    strV2 = jsonReader.v();
                    break;
                case 1:
                    jR = jsonReader.r();
                    break;
                case 2:
                    strV = jsonReader.v();
                    break;
                case 3:
                    int iR5 = jsonReader.r();
                    layerType = Layer.LayerType.UNKNOWN;
                    if (iR5 < layerType.ordinal()) {
                        layerType = Layer.LayerType.values()[iR5];
                    }
                    break;
                case 4:
                    jR2 = jsonReader.r();
                    break;
                case 5:
                    iR = (int) (jsonReader.r() * vj9.e());
                    break;
                case 6:
                    iR2 = (int) (jsonReader.r() * vj9.e());
                    break;
                case 7:
                    color = Color.parseColor(jsonReader.v());
                    break;
                case 8:
                    m60VarG = n60.g(jsonReader, k35Var);
                    break;
                case 9:
                    int iR6 = jsonReader.r();
                    if (iR6 < Layer.MatteType.values().length) {
                        matteType2 = Layer.MatteType.values()[iR6];
                        int i = a.f41294a[matteType2.ordinal()];
                        if (i == 1) {
                            k35Var.a("Unsupported matte type: Luma");
                        } else if (i == 2) {
                            k35Var.a("Unsupported matte type: Luma Inverted");
                        }
                        k35Var.v(1);
                    } else {
                        k35Var.a("Unsupported matte type: " + iR6);
                    }
                    break;
                case 10:
                    jsonReader.g();
                    while (jsonReader.l()) {
                        arrayList2.add(e85.a(jsonReader, k35Var));
                    }
                    k35Var.v(arrayList2.size());
                    jsonReader.j();
                    break;
                case 11:
                    jsonReader.g();
                    while (jsonReader.l()) {
                        ContentModel contentModelA = xu1.a(jsonReader, k35Var);
                        if (contentModelA != null) {
                            arrayList3.add(contentModelA);
                        }
                    }
                    jsonReader.j();
                    break;
                case 12:
                    jsonReader.h();
                    while (jsonReader.l()) {
                        int iF = jsonReader.F(b);
                        if (iF == 0) {
                            hVarD = com.airbnb.lottie.parser.a.d(jsonReader, k35Var);
                        } else if (iF != 1) {
                            jsonReader.H();
                            jsonReader.J();
                        } else {
                            jsonReader.g();
                            if (jsonReader.l()) {
                                k60VarA = l60.a(jsonReader, k35Var);
                            }
                            while (jsonReader.l()) {
                                jsonReader.J();
                            }
                            jsonReader.j();
                        }
                    }
                    jsonReader.k();
                    break;
                case 13:
                    jsonReader.g();
                    ArrayList arrayList4 = new ArrayList();
                    while (jsonReader.l()) {
                        jsonReader.h();
                        while (jsonReader.l()) {
                            int iF2 = jsonReader.F(c);
                            if (iF2 == 0) {
                                int iR7 = jsonReader.r();
                                if (iR7 == 29) {
                                    sy0VarB = ty0.b(jsonReader, k35Var);
                                } else if (iR7 == 25) {
                                    hs2VarB = new is2().b(jsonReader, k35Var);
                                }
                            } else if (iF2 != 1) {
                                jsonReader.H();
                                jsonReader.J();
                            } else {
                                arrayList4.add(jsonReader.v());
                            }
                        }
                        jsonReader.k();
                    }
                    jsonReader.j();
                    k35Var.a("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: " + arrayList4);
                    break;
                case 14:
                    fQ = (float) jsonReader.q();
                    break;
                case 15:
                    fQ3 = (float) jsonReader.q();
                    break;
                case 16:
                    iR3 = (int) (jsonReader.r() * vj9.e());
                    break;
                case 17:
                    iR4 = (int) (jsonReader.r() * vj9.e());
                    break;
                case 18:
                    fQ2 = (float) jsonReader.q();
                    break;
                case 19:
                    f2 = (float) jsonReader.q();
                    break;
                case 20:
                    bVarF = com.airbnb.lottie.parser.a.f(jsonReader, k35Var, false);
                    break;
                case 21:
                    strV3 = jsonReader.v();
                    break;
                case 22:
                    zP = jsonReader.p();
                    break;
                default:
                    jsonReader.H();
                    jsonReader.J();
                    break;
            }
        }
        jsonReader.k();
        ArrayList arrayList5 = new ArrayList();
        if (fQ2 > 0.0f) {
            arrayList = arrayList5;
            arrayList.add(new ps4(k35Var, fValueOf2, fValueOf2, null, 0.0f, Float.valueOf(fQ2)));
            f = 0.0f;
        } else {
            arrayList = arrayList5;
            f = 0.0f;
        }
        if (f2 <= f) {
            f2 = k35Var.f();
        }
        arrayList.add(new ps4(k35Var, fValueOf, fValueOf, null, fQ2, Float.valueOf(f2)));
        arrayList.add(new ps4(k35Var, fValueOf2, fValueOf2, null, f2, Float.valueOf(Float.MAX_VALUE)));
        if (strV2.endsWith(".ai") || "ai".equals(strV3)) {
            k35Var.a("Convert your Illustrator layers to shape layers.");
        }
        return new Layer(arrayList3, k35Var, strV2, jR, layerType, jR2, strV, arrayList2, m60VarG, iR, iR2, color, fQ, fQ3, iR3, iR4, hVarD, k60VarA, arrayList, matteType2, bVarF, zP, sy0VarB, hs2VarB);
    }

    public static Layer b(k35 k35Var) {
        Rect rectB = k35Var.b();
        return new Layer(Collections.emptyList(), k35Var, "__container", -1L, Layer.LayerType.PRE_COMP, -1L, null, Collections.emptyList(), new m60(), 0, 0, 0, 0.0f, 0.0f, rectB.width(), rectB.height(), null, null, Collections.emptyList(), Layer.MatteType.NONE, null, false, null, null);
    }
}
