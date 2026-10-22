package com.byazt.be;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.cd.x;
import com.byazt.xj.ve;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 798, 20})
public class c extends ve<DislikeView> {
    public int c;
    public int vp;
    public int yo;

    public c(Context context) {
        super(context);
        this.c = 0;
        this.vp = 0;
    }

    @Override // com.byazt.xj.ve
    /* JADX INFO: renamed from: sp, reason: merged with bridge method [inline-methods] */
    public DislikeView c() {
        DislikeView dislikeView = new DislikeView(this.tt);
        dislikeView.c(this);
        return dislikeView;
    }

    @Override // com.byazt.xj.ve
    public void tt() {
        super.tt();
        ((DislikeView) this.n).setRadius(this.hd);
        ((DislikeView) this.n).setStrokeWidth((int) this.kp);
        ((DislikeView) this.n).setDislikeColor(this.c);
        ((DislikeView) this.n).setStrokeColor(this.b);
        ((DislikeView) this.n).setDislikeWidth(this.yo);
        ((DislikeView) this.n).setBgColor(this.vp);
    }

    @Override // com.byazt.xj.ve
    public void c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.c(str, str2);
        str.hashCode();
        switch (str) {
            case "dislikeColor":
                this.c = com.byazt.cd.c.c(str2);
                break;
            case "dislikeWidth":
                this.yo = (int) x.c(this.tt, Integer.parseInt(str2));
                break;
            case "dislikeFillColor":
                this.vp = com.byazt.cd.c.c(str2);
                break;
        }
    }
}
