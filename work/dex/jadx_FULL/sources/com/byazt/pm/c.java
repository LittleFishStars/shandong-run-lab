package com.byazt.pm;

import android.content.Context;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1355, 20})
public class c implements x {
    @Override // com.byazt.pm.x
    public List<sp> c() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new sp("slide") { // from class: com.byazt.pm.c.1
            @Override // com.byazt.pm.sp
            public com.byazt.ji.tt c(Context context) {
                return new com.byazt.ji.uj(context);
            }
        });
        arrayList.add(new sp("tap") { // from class: com.byazt.pm.c.2
            @Override // com.byazt.pm.sp
            public com.byazt.ji.tt c(Context context) {
                return new com.byazt.ji.n(context);
            }
        });
        arrayList.add(new sp("timer") { // from class: com.byazt.pm.c.3
            @Override // com.byazt.pm.sp
            public com.byazt.ji.tt c(Context context) {
                return new com.byazt.ji.a(context);
            }
        });
        arrayList.add(new sp("touchStart") { // from class: com.byazt.pm.c.4
            @Override // com.byazt.pm.sp
            public com.byazt.ji.tt c(Context context) {
                return new com.byazt.ji.da(context);
            }
        });
        arrayList.add(new sp("touchEnd") { // from class: com.byazt.pm.c.5
            @Override // com.byazt.pm.sp
            public com.byazt.ji.tt c(Context context) {
                return new com.byazt.ji.i(context);
            }
        });
        arrayList.add(new sp("animateState") { // from class: com.byazt.pm.c.6
            @Override // com.byazt.pm.sp
            public com.byazt.ji.tt c(Context context) {
                return new com.byazt.ji.c(context);
            }
        });
        arrayList.add(new sp("timerState") { // from class: com.byazt.pm.c.7
            @Override // com.byazt.pm.sp
            public com.byazt.ji.tt c(Context context) {
                return new com.byazt.ji.x(context);
            }
        });
        return arrayList;
    }
}
