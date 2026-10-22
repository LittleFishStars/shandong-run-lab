package com.byazt.cj;

import android.content.Context;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.ls.tt
@com.byazt.zqa.c(c = {0, 1, 55, 20})
public class c implements com.byazt.kkb.ve {

    @com.byazt.ls.c(c = "url")
    public String c;

    @com.byazt.ls.c(c = "title")
    public String tt;

    @com.byazt.ls.c(c = "context")
    public Context ve;

    @Override // com.byazt.kkb.ve
    public boolean c(Map<String, Object> map, Map<String, Object> map2, com.byazt.cq.c cVar) {
        TTDelegateActivity.uj(this.ve, this.c, this.tt);
        cVar.c(map2);
        return true;
    }
}
