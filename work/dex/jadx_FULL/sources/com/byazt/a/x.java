package com.byazt.a;

import android.content.Context;
import android.content.Intent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 34, 71})
public class x extends c {
    public x(Context context, com.byazt.k.c cVar, String str) {
        super(context, cVar, str);
    }

    @Override // com.byazt.a.n
    public Intent tt() {
        Intent intent = new Intent(com.byazt.ev.n.ve + ".intent.action.OPEN_FILEMANAGER");
        intent.putExtra("CurrentDir", this.ve);
        intent.putExtra("first_position", 1);
        intent.putExtra("CurrentMode", 1);
        intent.putExtra("com.iqoo.secure", true);
        intent.addFlags(268435456);
        intent.addFlags(32768);
        intent.addFlags(1073741824);
        return intent;
    }
}
