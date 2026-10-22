package com.baidu.mapsdkplatform.comapi.util;

import android.content.Context;
import android.content.SharedPreferences;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile e f26694a;
    private boolean b = false;
    private boolean c = true;
    private final List<d> d = new ArrayList();
    private d e = null;

    private e() {
    }

    public static e b() {
        if (f26694a == null) {
            synchronized (e.class) {
                if (f26694a == null) {
                    f26694a = new e();
                }
            }
        }
        return f26694a;
    }

    public d a() {
        return this.e;
    }

    public d a(Context context) {
        String string = context.getSharedPreferences("map_pref", 0).getString("PREFFERED_SD_CARD", "");
        if (string == null || string.length() <= 0) {
            return null;
        }
        for (d dVar : this.d) {
            if (dVar.c().equals(string)) {
                return dVar;
            }
        }
        return null;
    }

    public boolean a(Context context, d dVar) {
        String strC = dVar.c();
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("map_pref", 0).edit();
        editorEdit.putString("PREFFERED_SD_CARD", strC);
        return editorEdit.commit();
    }

    public void b(Context context) {
        if (this.b || context == null) {
            return;
        }
        this.b = true;
        try {
            this.c = false;
            this.e = new d(context);
            this.d.clear();
            this.d.add(this.e);
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            if (this.d.size() > 0) {
                d dVar = null;
                int i = 0;
                for (d dVar2 : this.d) {
                    if (new File(dVar2.a()).exists()) {
                        i++;
                        dVar = dVar2;
                    }
                }
                if (i == 0) {
                    d dVarA = a(context);
                    this.e = dVarA;
                    if (dVarA == null) {
                        for (d dVar3 : this.d) {
                            if (a(context, dVar3)) {
                                this.e = dVar3;
                                break;
                            }
                        }
                    }
                } else if (i == 1) {
                    if (a(context, dVar)) {
                        this.e = dVar;
                    }
                } else {
                    this.e = a(context);
                }
                if (this.e == null) {
                    this.e = this.d.get(0);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        try {
            if (this.e == null) {
                this.c = false;
                this.e = new d(context);
                this.d.clear();
                this.d.add(this.e);
            }
        } catch (Exception e3) {
            e3.printStackTrace();
        }
    }
}
