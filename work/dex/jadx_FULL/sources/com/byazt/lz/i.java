package com.byazt.lz;

import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 601, 42})
public class i implements a, Function {
    public volatile Function c;
    public volatile a tt;

    public i(a aVar) {
        this.tt = aVar;
    }

    public i(Function function) {
        this.c = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        switch (((Integer) ((SparseArray) obj).get(0)).intValue()) {
            case 1:
                return this.tt.getPublisherDid();
            case 2:
                return Boolean.valueOf(this.tt.isOpenAdnTest());
            case 3:
                sp mediationConfigUserInfoForSegment = this.tt.getMediationConfigUserInfoForSegment();
                return mediationConfigUserInfoForSegment != null ? new x(mediationConfigUserInfoForSegment) : mediationConfigUserInfoForSegment;
            case 4:
                return this.tt.getLocalExtra();
            case 5:
                return Boolean.valueOf(this.tt.getHttps());
            case 6:
                return this.tt.getCustomLocalConfig();
            case 7:
                return this.tt.getOpensdkVer();
            case 8:
                return Boolean.valueOf(this.tt.isWxInstalled());
            case 9:
                return Boolean.valueOf(this.tt.isSupportH265());
            case 10:
                return Boolean.valueOf(this.tt.isSupportSplashZoomout());
            case 11:
                return this.tt.wxAppId();
            default:
                return null;
        }
    }

    @Override // com.byazt.lz.a
    public JSONObject getCustomLocalConfig() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        return (JSONObject) this.c.apply(sparseArray);
    }

    @Override // com.byazt.lz.a
    public boolean getHttps() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.lz.a
    public Map getLocalExtra() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        return (Map) this.c.apply(sparseArray);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1, types: [java.lang.Object, java.util.function.Function] */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    @Override // com.byazt.lz.a
    public sp getMediationConfigUserInfoForSegment() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        ?? Apply = this.c.apply(sparseArray);
        ?? xVar = Apply;
        if (Apply != 0) {
            xVar = new x((Function) Apply);
        }
        return (sp) xVar;
    }

    @Override // com.byazt.lz.a
    public String getOpensdkVer() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.lz.a
    public String getPublisherDid() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.lz.a
    public boolean isOpenAdnTest() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.lz.a
    public boolean isSupportH265() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.lz.a
    public boolean isSupportSplashZoomout() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.lz.a
    public boolean isWxInstalled() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.lz.a
    public String wxAppId() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        return (String) this.c.apply(sparseArray);
    }
}
