package com.byazt.dc;

import android.util.SparseArray;
import com.zj.adlib.y6b;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2063, 54})
public class ve implements com.byazt.xiv.ve {
    public String c;
    public Function<SparseArray<Object>, Object> tt;
    public String ve;

    public ve(String str) {
        this.c = str;
    }

    private String c() {
        String str = this.c;
        str.hashCode();
        switch (str) {
            case "sigmob":
                return "s";
            case "xiaomi":
                return "x";
            case "ks":
                return "k";
            case "gdt":
                return y6b.f;
            case "baidu":
                return "b";
            case "unity":
                return "u";
            default:
                return null;
        }
    }

    @Override // com.byazt.xiv.ve
    public String getAdnName() {
        return this.c;
    }

    @Override // com.byazt.xiv.ve
    public String getAdnVersion() {
        String str = this.c;
        str.hashCode();
        switch (str) {
            case "xiaomi":
                return com.byazt.xiv.n.x();
            case "ks":
                return com.byazt.xiv.n.a();
            case "gdt":
                return com.byazt.xiv.n.sp();
            default:
                return null;
        }
    }

    @Override // com.byazt.xiv.ve
    public String getAdnVersionListKey() {
        return c() + "_adn_version";
    }

    @Override // com.byazt.xiv.ve
    public String getClassName() {
        return c() + "_class_name";
    }

    @Override // com.byazt.xiv.ve
    public Function<SparseArray<Object>, Object> getInitBridge() {
        return n.tt(this.c);
    }

    @Override // com.byazt.xiv.ve
    public Function<SparseArray<Object>, Object> getManager() {
        return this.tt;
    }

    @Override // com.byazt.xiv.ve
    public String getUnSupportVersion() {
        return this.ve;
    }

    @Override // com.byazt.xiv.ve
    public void saveManager(Function<SparseArray<Object>, Object> function) {
        this.tt = function;
    }

    @Override // com.byazt.xiv.ve
    public void saveUnSupportVersion(String str) {
        this.ve = str;
    }
}
