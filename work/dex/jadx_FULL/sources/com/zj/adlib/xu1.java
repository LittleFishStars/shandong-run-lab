package com.zj.adlib;

import androidx.annotation.Nullable;
import cn.hzjizhun.admin.util.ShellUtils;
import com.airbnb.lottie.model.content.ContentModel;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.alibaba.ariver.kernel.RVParams;
import com.alipay.sdk.m.w.a;
import com.aliyun.vod.log.struct.AliyunLogKey;
import com.kuaishou.weapon.p0.t;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class xu1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final JsonReader.a f45898a = JsonReader.a.a(a.u, "d");

    @Nullable
    public static ContentModel a(JsonReader jsonReader, k35 k35Var) throws IOException {
        ContentModel contentModelA;
        String strV;
        jsonReader.h();
        byte b = 2;
        int iR = 2;
        while (true) {
            contentModelA = null;
            if (!jsonReader.l()) {
                strV = null;
                break;
            }
            int iF = jsonReader.F(f45898a);
            if (iF == 0) {
                strV = jsonReader.v();
                break;
            }
            if (iF != 1) {
                jsonReader.H();
                jsonReader.J();
            } else {
                iR = jsonReader.r();
            }
        }
        if (strV == null) {
            return null;
        }
        switch (strV.hashCode()) {
            case 3239:
                b = !strV.equals(t.n) ? (byte) -1 : (byte) 0;
                break;
            case 3270:
                b = !strV.equals("fl") ? (byte) -1 : (byte) 1;
                break;
            case 3295:
                if (!strV.equals("gf")) {
                    b = -1;
                }
                break;
            case 3307:
                b = !strV.equals("gr") ? (byte) -1 : (byte) 3;
                break;
            case 3308:
                b = !strV.equals("gs") ? (byte) -1 : (byte) 4;
                break;
            case 3488:
                b = !strV.equals("mm") ? (byte) -1 : (byte) 5;
                break;
            case 3633:
                b = !strV.equals("rc") ? (byte) -1 : (byte) 6;
                break;
            case 3634:
                b = !strV.equals("rd") ? (byte) -1 : (byte) 7;
                break;
            case 3646:
                b = !strV.equals(AliyunLogKey.KEY_RESOURCE_PATH) ? (byte) -1 : (byte) 8;
                break;
            case 3669:
                b = !strV.equals(ShellUtils.COMMAND_SH) ? (byte) -1 : (byte) 9;
                break;
            case 3679:
                b = !strV.equals(RVParams.SHOW_REPORT_BTN) ? (byte) -1 : (byte) 10;
                break;
            case 3681:
                b = !strV.equals("st") ? (byte) -1 : (byte) 11;
                break;
            case 3705:
                b = !strV.equals(RVParams.TOOLBAR_MENU) ? (byte) -1 : (byte) 12;
                break;
            case 3710:
                b = !strV.equals("tr") ? (byte) -1 : (byte) 13;
                break;
            default:
                b = -1;
                break;
        }
        switch (b) {
            case 0:
                contentModelA = il1.a(jsonReader, k35Var, iR);
                break;
            case 1:
                contentModelA = i88.a(jsonReader, k35Var);
                break;
            case 2:
                contentModelA = ew3.a(jsonReader, k35Var);
                break;
            case 3:
                contentModelA = k88.a(jsonReader, k35Var);
                break;
            case 4:
                contentModelA = hw3.a(jsonReader, k35Var);
                break;
            case 5:
                contentModelA = bm5.a(jsonReader);
                k35Var.a("Animation contains merge paths. Merge paths are only supported on KitKat+ and must be manually enabled by calling enableMergePathsForKitKatAndAbove().");
                break;
            case 6:
                contentModelA = yc7.a(jsonReader, k35Var);
                break;
            case 7:
                contentModelA = sj7.a(jsonReader, k35Var);
                break;
            case 8:
                contentModelA = xe7.a(jsonReader, k35Var);
                break;
            case 9:
                contentModelA = o88.a(jsonReader, k35Var);
                break;
            case 10:
                contentModelA = ku6.a(jsonReader, k35Var, iR);
                break;
            case 11:
                contentModelA = p88.a(jsonReader, k35Var);
                break;
            case 12:
                contentModelA = q88.a(jsonReader, k35Var);
                break;
            case 13:
                contentModelA = n60.g(jsonReader, k35Var);
                break;
            default:
                g25.e("Unknown shape type " + strV);
                break;
        }
        while (jsonReader.l()) {
            jsonReader.J();
        }
        jsonReader.k();
        return contentModelA;
    }
}
