package com.huawei.hms.hatool;

import com.zj.adlib.c49;
import java.util.ArrayList;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class i1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f37561a;
    private String b;
    private String c;
    private String d;
    private long e;

    public i1(String str, String str2, String str3, String str4, long j) {
        this.f37561a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = j;
    }

    public void a() {
        v.c("StreamEventHandler", "Begin to handle stream events...");
        b1 b1Var = new b1();
        b1Var.b(this.c);
        b1Var.d(this.b);
        b1Var.a(this.d);
        b1Var.c(String.valueOf(this.e));
        if ("oper".equals(this.b) && z.i(this.f37561a, "oper")) {
            p0 p0VarA = y.a().a(this.f37561a, this.e);
            String strA = p0VarA.a();
            Boolean boolValueOf = Boolean.valueOf(p0VarA.b());
            b1Var.f(strA);
            b1Var.e(String.valueOf(boolValueOf));
        }
        String strReplace = UUID.randomUUID().toString().replace(c49.f40900a, "");
        ArrayList arrayList = new ArrayList();
        arrayList.add(b1Var);
        new l0(this.f37561a, this.b, q0.g(), arrayList, strReplace).a();
    }
}
