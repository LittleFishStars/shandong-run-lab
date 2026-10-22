package com.byazt.yf;

import androidx.annotation.Nullable;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 508, 158})
public abstract class sl {
    public int c;
    public String tt;
    public String uj;
    public String ve;

    public int c() {
        return this.c;
    }

    public String n() {
        switch (this.c) {
            case 1:
                return MediationConstant.ADN_PANGLE;
            case 2:
            default:
                return "";
            case 3:
                return "gdt";
            case 4:
                return MediationConstant.ADN_MINTEGRAL;
            case 5:
                return MediationConstant.ADN_UNITY;
            case 6:
                return "baidu";
            case 7:
                return MediationConstant.ADN_KS;
            case 8:
                return "sigmob";
            case 9:
                return MediationConstant.ADN_KLEVIN;
            case 10:
                return "xiaomi";
        }
    }

    @Nullable
    public String tt() {
        return this.tt;
    }

    @Nullable
    public String uj() {
        return this.uj;
    }

    @Nullable
    public String ve() {
        return this.ve;
    }
}
