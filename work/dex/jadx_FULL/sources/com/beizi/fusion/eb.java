package com.beizi.fusion;

import android.content.Context;
import com.alibaba.sdk.android.oss.common.OSSConstants;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class eb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final Context f27231a;
    private final boolean b;

    public eb(Context context, boolean z) {
        this.f27231a = context;
        this.b = z;
    }

    public void a(String str, sa saVar) {
        q5 q5VarA = a(cm.GET, str, saVar);
        if (q5VarA != null) {
            q5VarA.a(this.f27231a);
        }
    }

    public void a(String str, String str2, sa saVar) {
        q5 q5VarA = a(cm.POST, str, saVar);
        if (q5VarA != null) {
            q5VarA.a(str2.getBytes()).a(this.f27231a);
        }
    }

    public void a(String str, byte[] bArr, sa saVar) {
        q5 q5VarA = a(cm.STREAM, str, saVar);
        if (q5VarA != null) {
            q5VarA.a(bArr).a(this.f27231a);
        }
    }

    public q5 a(cm cmVar, String str, sa saVar) {
        q5 q5VarA = new q5().a(this.b).a(saVar);
        if (cm.POST == cmVar) {
            q5VarA.c(str);
        }
        if (cm.GET == cmVar) {
            q5VarA.b(str);
        }
        if (cm.STREAM == cmVar) {
            q5VarA.d(str);
            q5VarA.a("Content-Type", OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE);
        }
        return q5VarA;
    }
}
