package com.byazt.fs;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.JsonReader;
import cn.hzjizhun.admin.util.ShellUtils;
import com.ali.auth.third.login.LoginConstants;
import com.alibaba.ariver.kernel.RVParams;
import com.aliyun.vod.log.struct.AliyunLogKey;
import com.amap.api.col.p0003l.ef;
import com.bykv.vk.component.ttvideo.LiveConfigKey;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.zj.adlib.y6b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 720, 110})
public class qy {

    /* JADX INFO: renamed from: com.byazt.fs.qy$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 720, 721})
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[com.byazt.zk.x.tt.values().length];
            c = iArr;
            try {
                iArr[com.byazt.zk.x.tt.LUMA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[com.byazt.zk.x.tt.LUMA_INVERTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public static com.byazt.zk.x c(com.byazt.ga.a aVar) {
        Rect rectUj = aVar.uj();
        return new com.byazt.zk.x(Collections.emptyList(), aVar, "__container", -1L, com.byazt.zk.x.c.PRE_COMP, -1L, null, Collections.emptyList(), new com.byazt.kd.t(), 0, 0, 0, 0.0f, 0.0f, rectUj.width(), rectUj.height(), null, null, Collections.emptyList(), com.byazt.zk.x.tt.NONE, null, false, null, null);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static com.byazt.zk.x c(JsonReader jsonReader, com.byazt.ga.a aVar) throws IOException {
        com.byazt.zk.x.tt ttVar = com.byazt.zk.x.tt.NONE;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        jsonReader.beginObject();
        Float fValueOf = Float.valueOf(0.0f);
        Float fValueOf2 = Float.valueOf(1.0f);
        com.byazt.zk.x.tt ttVar2 = ttVar;
        com.byazt.zk.x.c cVar = null;
        String strNextString = null;
        com.byazt.kd.t tVarC = null;
        com.byazt.kd.da daVarA = null;
        com.byazt.kd.sl slVarC = null;
        com.byazt.kd.tt ttVarC = null;
        com.byazt.jx.c cVarC = null;
        da daVarC = null;
        long jNextInt = 0;
        int iNextInt = 0;
        int iNextInt2 = 0;
        int color = 0;
        boolean zNextBoolean = false;
        float fNextDouble = 0.0f;
        float fNextDouble2 = 0.0f;
        float fNextDouble3 = 0.0f;
        float fSp = 0.0f;
        long jNextInt2 = -1;
        float fNextDouble4 = 1.0f;
        String strNextString2 = "UNSET";
        String strNextString3 = null;
        float fNextDouble5 = 0.0f;
        while (jsonReader.hasNext()) {
            String strNextName = jsonReader.nextName();
            strNextName.hashCode();
            byte b = -1;
            switch (strNextName.hashCode()) {
                case -995424086:
                    if (strNextName.equals("parent")) {
                        b = 0;
                    }
                    break;
                case -903568142:
                    if (strNextName.equals("shapes")) {
                        b = 1;
                    }
                    break;
                case 104:
                    if (strNextName.equals(y6b.g)) {
                        b = 2;
                    }
                    break;
                case 116:
                    if (strNextName.equals("t")) {
                        b = 3;
                    }
                    break;
                case 119:
                    if (strNextName.equals("w")) {
                        b = 4;
                    }
                    break;
                case 3177:
                    if (strNextName.equals("cl")) {
                        b = 5;
                    }
                    break;
                case 3233:
                    if (strNextName.equals(ef.f25915a)) {
                        b = 6;
                    }
                    break;
                case 3324:
                    if (strNextName.equals(LiveConfigKey.HIGH)) {
                        b = 7;
                    }
                    break;
                case 3367:
                    if (strNextName.equals(LoginConstants.IP)) {
                        b = 8;
                    }
                    break;
                case 3432:
                    if (strNextName.equals(MediationConstant.ADN_KS)) {
                        b = 9;
                    }
                    break;
                case 3519:
                    if (strNextName.equals("nm")) {
                        b = 10;
                    }
                    break;
                case 3553:
                    if (strNextName.equals(AliyunLogKey.KEY_OUTPUT_PATH)) {
                        b = 11;
                    }
                    break;
                case 3664:
                    if (strNextName.equals("sc")) {
                        b = 12;
                    }
                    break;
                case 3669:
                    if (strNextName.equals(ShellUtils.COMMAND_SH)) {
                        b = 13;
                    }
                    break;
                case 3679:
                    if (strNextName.equals(RVParams.SHOW_REPORT_BTN)) {
                        b = com.google.common.base.a.p;
                    }
                    break;
                case 3681:
                    if (strNextName.equals("st")) {
                        b = com.google.common.base.a.q;
                    }
                    break;
                case 3684:
                    if (strNextName.equals("sw")) {
                        b = com.google.common.base.a.r;
                    }
                    break;
                case 3705:
                    if (strNextName.equals(RVParams.TOOLBAR_MENU)) {
                        b = 17;
                    }
                    break;
                case 3712:
                    if (strNextName.equals("tt")) {
                        b = com.google.common.base.a.u;
                    }
                    break;
                case 3717:
                    if (strNextName.equals(com.alipay.sdk.m.w.a.u)) {
                        b = 19;
                    }
                    break;
                case 104415:
                    if (strNextName.equals("ind")) {
                        b = com.google.common.base.a.x;
                    }
                    break;
                case 108390670:
                    if (strNextName.equals("refId")) {
                        b = com.google.common.base.a.y;
                    }
                    break;
                case 1441620890:
                    if (strNextName.equals("masksProperties")) {
                        b = com.google.common.base.a.z;
                    }
                    break;
            }
            switch (b) {
                case 0:
                    jNextInt2 = jsonReader.nextInt();
                    break;
                case 1:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        com.byazt.jx.ve veVarC = x.c(jsonReader, aVar);
                        if (veVarC != null) {
                            arrayList2.add(veVarC);
                        }
                    }
                    jsonReader.endArray();
                    break;
                case 2:
                    fNextDouble3 = (float) (jsonReader.nextDouble() * ((double) com.byazt.kk.da.c()));
                    break;
                case 3:
                    jsonReader.beginObject();
                    while (jsonReader.hasNext()) {
                        String strNextName2 = jsonReader.nextName();
                        strNextName2.hashCode();
                        if (strNextName2.equals("a")) {
                            jsonReader.beginArray();
                            if (jsonReader.hasNext()) {
                                slVarC = tt.c(jsonReader, aVar);
                            }
                            while (jsonReader.hasNext()) {
                                jsonReader.skipValue();
                            }
                            jsonReader.endArray();
                        } else if (!strNextName2.equals("d")) {
                            jsonReader.skipValue();
                        } else {
                            daVarA = uj.a(jsonReader, aVar);
                        }
                    }
                    jsonReader.endObject();
                    break;
                case 4:
                    fNextDouble2 = (float) (jsonReader.nextDouble() * ((double) com.byazt.kk.da.c()));
                    break;
                case 5:
                    strNextString3 = jsonReader.nextString();
                    break;
                case 6:
                    jsonReader.beginArray();
                    ArrayList arrayList3 = new ArrayList();
                    while (jsonReader.hasNext()) {
                        jsonReader.beginObject();
                        while (jsonReader.hasNext()) {
                            String strNextName3 = jsonReader.nextName();
                            strNextName3.hashCode();
                            if (strNextName3.equals("nm")) {
                                arrayList3.add(jsonReader.nextString());
                            } else if (!strNextName3.equals(com.alipay.sdk.m.w.a.u)) {
                                jsonReader.skipValue();
                            } else {
                                int iNextInt3 = jsonReader.nextInt();
                                if (iNextInt3 == 29) {
                                    cVarC = n.c(jsonReader, aVar);
                                } else if (iNextInt3 == 25) {
                                    daVarC = new sl().c(jsonReader, aVar);
                                }
                            }
                        }
                        jsonReader.endObject();
                    }
                    jsonReader.endArray();
                    aVar.c("Lottie doesn't support layer effects. If you are using them for  fills, strokes, trim paths etc. then try adding them directly as contents  in your shape. Found: ".concat(String.valueOf(arrayList3)));
                    break;
                case 7:
                    zNextBoolean = jsonReader.nextBoolean();
                    break;
                case 8:
                    fNextDouble5 = (float) jsonReader.nextDouble();
                    break;
                case 9:
                    tVarC = ve.c(jsonReader, aVar);
                    break;
                case 10:
                    strNextString2 = jsonReader.nextString();
                    break;
                case 11:
                    fSp = (float) jsonReader.nextDouble();
                    break;
                case 12:
                    color = Color.parseColor(jsonReader.nextString());
                    break;
                case 13:
                    iNextInt2 = (int) (jsonReader.nextInt() * com.byazt.kk.da.c());
                    break;
                case 14:
                    fNextDouble4 = (float) jsonReader.nextDouble();
                    break;
                case 15:
                    fNextDouble = (float) jsonReader.nextDouble();
                    break;
                case 16:
                    iNextInt = (int) (jsonReader.nextInt() * com.byazt.kk.da.c());
                    break;
                case 17:
                    ttVarC = uj.c(jsonReader, aVar, false);
                    break;
                case 18:
                    int iNextInt4 = jsonReader.nextInt();
                    if (iNextInt4 >= com.byazt.zk.x.tt.values().length) {
                        aVar.c("Unsupported matte type: ".concat(String.valueOf(iNextInt4)));
                    } else {
                        ttVar2 = com.byazt.zk.x.tt.values()[iNextInt4];
                        int i = AnonymousClass1.c[ttVar2.ordinal()];
                        if (i == 1) {
                            aVar.c("Unsupported matte type: Luma");
                        } else if (i == 2) {
                            aVar.c("Unsupported matte type: Luma Inverted");
                        }
                        aVar.c(1);
                    }
                    break;
                case 19:
                    int iNextInt5 = jsonReader.nextInt();
                    cVar = com.byazt.zk.x.c.UNKNOWN;
                    if (iNextInt5 < cVar.ordinal()) {
                        cVar = com.byazt.zk.x.c.values()[iNextInt5];
                    }
                    break;
                case 20:
                    jNextInt = jsonReader.nextInt();
                    break;
                case 21:
                    strNextString = jsonReader.nextString();
                    break;
                case 22:
                    jsonReader.beginArray();
                    while (jsonReader.hasNext()) {
                        arrayList.add(gr.c(jsonReader, aVar));
                    }
                    aVar.c(arrayList.size());
                    jsonReader.endArray();
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        ArrayList arrayList4 = new ArrayList();
        if (fNextDouble5 > 0.0f) {
            arrayList4.add(new com.byazt.vc.c(aVar, fValueOf, fValueOf, null, 0.0f, Float.valueOf(fNextDouble5)));
        }
        if (fSp <= 0.0f) {
            fSp = aVar.sp();
        }
        arrayList4.add(new com.byazt.vc.c(aVar, fValueOf2, fValueOf2, null, fNextDouble5, Float.valueOf(fSp)));
        arrayList4.add(new com.byazt.vc.c(aVar, fValueOf, fValueOf, null, fSp, Float.valueOf(Float.MAX_VALUE)));
        if (strNextString2.endsWith(".ai") || "ai".equals(strNextString3)) {
            aVar.c("Convert your Illustrator layers to shape layers.");
        }
        return new com.byazt.zk.x(arrayList2, aVar, strNextString2, jNextInt, cVar, jNextInt2, strNextString, arrayList, tVarC, iNextInt, iNextInt2, color, fNextDouble4, fNextDouble, fNextDouble2, fNextDouble3, daVarA, slVarC, arrayList4, ttVar2, ttVarC, zNextBoolean, cVarC, daVarC);
    }
}
