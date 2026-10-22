package com.byazt.kf;

import android.content.Context;
import com.byazt.xj.ve;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1176, 20})
public class c extends ve<PageWebView> {
    public String c;

    public c(Context context) {
        super(context);
    }

    @Override // com.byazt.xj.ve
    /* JADX INFO: renamed from: sp, reason: merged with bridge method [inline-methods] */
    public PageWebView c() {
        return new PageWebView(this.tt);
    }

    @Override // com.byazt.xj.ve
    public void tt() {
        super.tt();
        ((PageWebView) this.n).setMeta(com.byazt.omf.c.c(da()));
        ((PageWebView) this.n).tt(da());
        ((PageWebView) this.n).setUGenContext(this.i);
        ((PageWebView) this.n).c();
        ((PageWebView) this.n).c(this.c);
    }

    @Override // com.byazt.xj.ve
    public void c(String str, String str2) {
        super.c(str, str2);
        str.hashCode();
        if (str.equals("src")) {
            this.c = str2;
        }
    }
}
