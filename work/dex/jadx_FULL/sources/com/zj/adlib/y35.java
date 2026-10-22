package com.zj.adlib;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.kernel.RVParams;
import com.aliyun.vod.log.struct.AliyunLogKey;
import com.huachenjie.mall.page.goods_detail.GoodsSpecificationPreviewActivity;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class y35 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f45948a = JsonReader.a.a("w", y6b.g, LoginConstants.IP, AliyunLogKey.KEY_OUTPUT_PATH, "fr", "v", "layers", "assets", "fonts", "chars", "markers");
    public static JsonReader.a b = JsonReader.a.a("id", "layers", "w", y6b.g, "p", "u");
    public static final JsonReader.a c = JsonReader.a.a(GoodsSpecificationPreviewActivity.z);
    public static final JsonReader.a d = JsonReader.a.a("cm", RVParams.TOOLBAR_MENU, "dr");

    public static k35 a(JsonReader jsonReader) throws IOException {
        float fE = vj9.e();
        LongSparseArray<Layer> longSparseArray = new LongSparseArray<>();
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        HashMap map2 = new HashMap();
        HashMap map3 = new HashMap();
        ArrayList arrayList2 = new ArrayList();
        SparseArrayCompat<nk3> sparseArrayCompat = new SparseArrayCompat<>();
        k35 k35Var = new k35();
        jsonReader.h();
        float fQ = 0.0f;
        float fQ2 = 0.0f;
        float fQ3 = 0.0f;
        int iR = 0;
        int iR2 = 0;
        while (jsonReader.l()) {
            switch (jsonReader.F(f45948a)) {
                case 0:
                    iR = jsonReader.r();
                    break;
                case 1:
                    iR2 = jsonReader.r();
                    break;
                case 2:
                    fQ = (float) jsonReader.q();
                    break;
                case 3:
                    fQ2 = ((float) jsonReader.q()) - 0.01f;
                    map3 = map3;
                    arrayList2 = arrayList2;
                    break;
                case 4:
                    fQ3 = (float) jsonReader.q();
                    map3 = map3;
                    arrayList2 = arrayList2;
                    break;
                case 5:
                    String[] strArrSplit = jsonReader.v().split("\\.");
                    if (!vj9.j(Integer.parseInt(strArrSplit[0]), Integer.parseInt(strArrSplit[1]), Integer.parseInt(strArrSplit[2]), 4, 4, 0)) {
                        k35Var.a("Lottie only supports bodymovin >= 4.4.0");
                    }
                    map3 = map3;
                    arrayList2 = arrayList2;
                    break;
                case 6:
                    e(jsonReader, k35Var, arrayList, longSparseArray);
                    map3 = map3;
                    arrayList2 = arrayList2;
                    break;
                case 7:
                    b(jsonReader, k35Var, map, map2);
                    map3 = map3;
                    arrayList2 = arrayList2;
                    break;
                case 8:
                    d(jsonReader, map3);
                    map3 = map3;
                    arrayList2 = arrayList2;
                    break;
                case 9:
                    c(jsonReader, k35Var, sparseArrayCompat);
                    map3 = map3;
                    arrayList2 = arrayList2;
                    break;
                case 10:
                    f(jsonReader, arrayList2);
                    map3 = map3;
                    arrayList2 = arrayList2;
                    break;
                default:
                    jsonReader.H();
                    jsonReader.J();
                    map3 = map3;
                    arrayList2 = arrayList2;
                    break;
            }
        }
        k35Var.w(new Rect(0, 0, (int) (iR * fE), (int) (iR2 * fE)), fQ, fQ2, fQ3, arrayList, longSparseArray, map, map2, sparseArrayCompat, map3, arrayList2);
        return k35Var;
    }

    public static void b(JsonReader jsonReader, k35 k35Var, Map<String, List<Layer>> map, Map<String, b45> map2) throws IOException {
        jsonReader.g();
        while (jsonReader.l()) {
            ArrayList arrayList = new ArrayList();
            LongSparseArray longSparseArray = new LongSparseArray();
            jsonReader.h();
            int iR = 0;
            int iR2 = 0;
            String strV = null;
            String strV2 = null;
            String strV3 = null;
            while (jsonReader.l()) {
                int iF = jsonReader.F(b);
                if (iF == 0) {
                    strV = jsonReader.v();
                } else if (iF == 1) {
                    jsonReader.g();
                    while (jsonReader.l()) {
                        Layer layerA = dw4.a(jsonReader, k35Var);
                        longSparseArray.put(layerA.d(), layerA);
                        arrayList.add(layerA);
                    }
                    jsonReader.j();
                } else if (iF == 2) {
                    iR = jsonReader.r();
                } else if (iF == 3) {
                    iR2 = jsonReader.r();
                } else if (iF == 4) {
                    strV2 = jsonReader.v();
                } else if (iF != 5) {
                    jsonReader.H();
                    jsonReader.J();
                } else {
                    strV3 = jsonReader.v();
                }
            }
            jsonReader.k();
            if (strV2 != null) {
                b45 b45Var = new b45(iR, iR2, strV, strV2, strV3);
                map2.put(b45Var.e(), b45Var);
            } else {
                map.put(strV, arrayList);
            }
        }
        jsonReader.j();
    }

    public static void c(JsonReader jsonReader, k35 k35Var, SparseArrayCompat<nk3> sparseArrayCompat) throws IOException {
        jsonReader.g();
        while (jsonReader.l()) {
            nk3 nk3VarA = ok3.a(jsonReader, k35Var);
            sparseArrayCompat.put(nk3VarA.hashCode(), nk3VarA);
        }
        jsonReader.j();
    }

    public static void d(JsonReader jsonReader, Map<String, kk3> map) throws IOException {
        jsonReader.h();
        while (jsonReader.l()) {
            if (jsonReader.F(c) != 0) {
                jsonReader.H();
                jsonReader.J();
            } else {
                jsonReader.g();
                while (jsonReader.l()) {
                    kk3 kk3VarA = pk3.a(jsonReader);
                    map.put(kk3VarA.c(), kk3VarA);
                }
                jsonReader.j();
            }
        }
        jsonReader.k();
    }

    public static void e(JsonReader jsonReader, k35 k35Var, List<Layer> list, LongSparseArray<Layer> longSparseArray) throws IOException {
        jsonReader.g();
        int i = 0;
        while (jsonReader.l()) {
            Layer layerA = dw4.a(jsonReader, k35Var);
            if (layerA.f() == Layer.LayerType.IMAGE) {
                i++;
            }
            list.add(layerA);
            longSparseArray.put(layerA.d(), layerA);
            if (i > 4) {
                g25.e("You have " + i + " images. Lottie should primarily be used with shapes. If you are using Adobe Illustrator, convert the Illustrator layers to shape layers.");
            }
        }
        jsonReader.j();
    }

    public static void f(JsonReader jsonReader, List<b85> list) throws IOException {
        jsonReader.g();
        while (jsonReader.l()) {
            jsonReader.h();
            float fQ = 0.0f;
            String strV = null;
            float fQ2 = 0.0f;
            while (jsonReader.l()) {
                int iF = jsonReader.F(d);
                if (iF == 0) {
                    strV = jsonReader.v();
                } else if (iF == 1) {
                    fQ = (float) jsonReader.q();
                } else if (iF != 2) {
                    jsonReader.H();
                    jsonReader.J();
                } else {
                    fQ2 = (float) jsonReader.q();
                }
            }
            jsonReader.k();
            list.add(new b85(strV, fQ, fQ2));
        }
        jsonReader.j();
    }
}
