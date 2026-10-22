package com.byazt.ro;

import android.content.Context;
import com.byazt.dy.UGFrameLayout;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2469, 20})
public abstract class c extends com.byazt.xj.c<UGFrameLayout> {
    public c(Context context) {
        super(context);
    }

    @Override // com.byazt.xj.ve
    public void c(String str, String str2) {
        super.c(str, str2);
        str.hashCode();
        switch (str) {
            case "onVideoProgress":
            case "onVideoFinish":
            case "onVideoPlay":
            case "onVideoResume":
            case "onVideoPause":
                tt(str, str2);
                break;
        }
    }

    @Override // com.byazt.xj.c, com.byazt.xj.ve
    public void tt() {
        super.tt();
    }
}
