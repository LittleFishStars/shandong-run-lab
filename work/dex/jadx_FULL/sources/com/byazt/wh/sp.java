package com.byazt.wh;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import com.byazt.w.i;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1172, 91})
public class sp {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public SQLiteStatement f29161a;
    public final SQLiteDatabase c;
    public SQLiteStatement n;
    public SQLiteStatement sp;
    public final String tt;
    public final String[] uj;
    public final String[] ve;
    public SQLiteStatement x;

    public sp(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String[] strArr2) {
        this.c = sQLiteDatabase;
        this.tt = str;
        this.ve = strArr;
        this.uj = strArr2;
    }

    public SQLiteStatement c() {
        if (this.n == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.c.compileStatement(i.c("INSERT INTO ", this.tt, this.ve));
            synchronized (this) {
                if (this.n == null) {
                    this.n = sQLiteStatementCompileStatement;
                }
            }
            if (this.n != sQLiteStatementCompileStatement) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return this.n;
    }

    public SQLiteStatement tt() {
        if (this.sp == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.c.compileStatement(i.c(this.tt, this.uj));
            synchronized (this) {
                if (this.sp == null) {
                    this.sp = sQLiteStatementCompileStatement;
                }
            }
            if (this.sp != sQLiteStatementCompileStatement) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return this.sp;
    }

    public SQLiteStatement uj() {
        if (this.x == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.c.compileStatement(i.tt(this.tt, this.ve, this.uj));
            synchronized (this) {
                if (this.x == null) {
                    this.x = sQLiteStatementCompileStatement;
                }
            }
            if (this.x != sQLiteStatementCompileStatement) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return this.x;
    }

    public SQLiteStatement ve() {
        if (this.f29161a == null) {
            SQLiteStatement sQLiteStatementCompileStatement = this.c.compileStatement(i.c(this.tt, this.ve, this.uj));
            synchronized (this) {
                if (this.f29161a == null) {
                    this.f29161a = sQLiteStatementCompileStatement;
                }
            }
            if (this.f29161a != sQLiteStatementCompileStatement) {
                sQLiteStatementCompileStatement.close();
            }
        }
        return this.f29161a;
    }
}
