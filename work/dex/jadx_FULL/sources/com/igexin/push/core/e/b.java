package com.igexin.push.core.e;

import android.database.sqlite.SQLiteDatabase;
import com.igexin.push.g.p;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class b implements a {
    private static b b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Map<String, byte[]> f38002a = new HashMap();

    private b() {
    }

    private static b a() {
        if (b == null) {
            b = new b();
        }
        return b;
    }

    private String a(byte[] bArr) {
        String strA;
        do {
            strA = p.a();
        } while (this.f38002a.containsKey(strA));
        this.f38002a.put(strA, bArr);
        return strA;
    }

    private synchronized byte[] a(String str) {
        byte[] bArr;
        bArr = this.f38002a.get(str);
        if (bArr != null) {
            this.f38002a.remove(str);
        }
        return bArr;
    }

    @Override // com.igexin.push.core.e.a
    public final void a(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // com.igexin.push.core.e.a
    public final void b(SQLiteDatabase sQLiteDatabase) {
    }

    @Override // com.igexin.push.core.e.a
    public final void c(SQLiteDatabase sQLiteDatabase) {
    }
}
