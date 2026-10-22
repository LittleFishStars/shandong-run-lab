package com.byazt.jd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.byazt.nr.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1500, 91})
public class sp {
    public static final Object ve = new Object();
    public c c;
    public Context tt;

    @com.byazt.zqa.c(c = {0, 1, 1500, 180})
    public class c {
        public SQLiteDatabase tt = null;

        public c() {
        }

        private void tt() {
            try {
                synchronized (sp.ve) {
                    SQLiteDatabase sQLiteDatabase = this.tt;
                    if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
                        SQLiteDatabase writableDatabase = new x(sp.this.getContext(), "tt_mediation_open_sdk.db", 4).getWritableDatabase();
                        this.tt = writableDatabase;
                        writableDatabase.setLockingEnabled(false);
                    }
                }
            } catch (Throwable th) {
                m.c(th);
                ve();
            }
        }

        private boolean ve() {
            SQLiteDatabase sQLiteDatabase = this.tt;
            return sQLiteDatabase != null && sQLiteDatabase.isOpen() && sQLiteDatabase.inTransaction();
        }

        public SQLiteDatabase c() {
            tt();
            return this.tt;
        }
    }

    public sp(Context context) {
        try {
            this.tt = context == null ? com.byazt.bp.tt.getContext() : context.getApplicationContext();
            if (this.c == null) {
                this.c = new c();
            }
        } catch (Throwable th) {
            m.c(th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Context getContext() {
        Context context = this.tt;
        return context == null ? com.byazt.bp.tt.getContext() : context;
    }

    public c c() {
        return this.c;
    }
}
