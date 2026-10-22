package com.byazt.cj;

import android.app.Dialog;
import android.content.Context;
import com.byazt.ete.ic;
import com.bytedance.sdk.openadsdk.core.activity.base.TTDelegateActivity;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.ls.tt
@com.byazt.zqa.c(c = {0, 1, 55, 34})
public class a implements com.byazt.kkb.ve {

    @com.byazt.ls.c(c = "outer_dislike")
    public Dialog c;

    @com.byazt.ls.c(c = "ad_dislike")
    public com.byazt.dyf.tt tt;

    @com.byazt.ls.c(c = "material_meta")
    public ic uj;

    @com.byazt.ls.c(c = "context")
    public Context ve;

    @Override // com.byazt.kkb.ve
    public boolean c(Map<String, Object> map, Map<String, Object> map2, com.byazt.cq.c cVar) {
        Dialog dialog = this.c;
        if (dialog != null) {
            dialog.show();
            cVar.c(map2);
            return true;
        }
        com.byazt.dyf.tt ttVar = this.tt;
        if (ttVar != null) {
            ttVar.showDislikeDialog();
            cVar.c(map2);
            return true;
        }
        TTDelegateActivity.c(this.ve, this.uj);
        cVar.c(map2);
        return true;
    }
}
