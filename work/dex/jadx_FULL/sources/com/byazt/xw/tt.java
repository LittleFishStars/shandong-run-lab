package com.byazt.xw;

import android.app.Activity;
import androidx.annotation.Nullable;
import com.byazt.yf.sp;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 226, 13})
public class tt extends com.byazt.dw.ve {
    public com.byazt.yf.tt c;

    public tt(Activity activity, Map<String, Object> map, com.byazt.oc.ve veVar) {
        if (veVar == null || activity == null) {
            return;
        }
        if (map != null) {
            this.c = veVar.c(activity, map);
        } else {
            this.c = veVar.c(activity);
        }
    }

    @Override // com.byazt.dw.ve
    public void setDislikeCallback(final com.byazt.am.c cVar) {
        com.byazt.yf.tt ttVar = this.c;
        if (ttVar != null) {
            ttVar.c(new sp() { // from class: com.byazt.xw.tt.1
                @Override // com.byazt.yf.sp
                public void c(int i, @Nullable String str) {
                    com.byazt.am.c cVar2 = cVar;
                    if (cVar2 != null) {
                        cVar2.c(i, str);
                    }
                }

                @Override // com.byazt.yf.sp
                public void tt() {
                    com.byazt.am.c cVar2 = cVar;
                    if (cVar2 != null) {
                        cVar2.tt();
                    }
                }

                @Override // com.byazt.yf.sp
                public void c() {
                    com.byazt.am.c cVar2 = cVar;
                    if (cVar2 != null) {
                        cVar2.c();
                    }
                }
            });
        }
    }

    @Override // com.byazt.dw.ve
    public void showDislikeDialog() {
        com.byazt.yf.tt ttVar = this.c;
        if (ttVar != null) {
            ttVar.c();
        }
    }

    public tt(com.byazt.yf.tt ttVar) {
        this.c = ttVar;
    }
}
