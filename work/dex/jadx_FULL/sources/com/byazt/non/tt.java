package com.byazt.non;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.byazt.nr.m;
import com.byazt.twu.a;
import com.byazt.twu.sp;
import com.byazt.twu.uj;
import com.huachenjie.common.constants.UserConstants;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, UserConstants.MODIFY_PHONE_ERROR_CODE.c, 13})
public class tt extends ve {
    public final String tt;

    public tt(Context context, int i) {
        super(context, "ttopensdk.db", i);
        this.tt = "OldSqliteDatabase";
    }

    private void tt(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL(a.n("adevent"));
        sQLiteDatabase.execSQL(uj.ve("loghighpriority"));
        sQLiteDatabase.execSQL(sp.n("logstats"));
        sQLiteDatabase.execSQL(com.byazt.twu.c.ve("logstatsbatch"));
        ve(sQLiteDatabase, i, i2);
    }

    private void ve(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL(com.byazt.pvs.a.ve());
        sQLiteDatabase.execSQL(com.byazt.pvs.a.uj());
    }

    @Override // com.byazt.non.ve
    public void c(SQLiteDatabase sQLiteDatabase, Context context) {
        com.byazt.ukr.tt.ve.get();
        sQLiteDatabase.execSQL(a.uj("adevent"));
        sQLiteDatabase.execSQL(uj.tt("loghighpriority"));
        sQLiteDatabase.execSQL(sp.uj("logstats"));
        sQLiteDatabase.execSQL(com.byazt.twu.c.tt("logstatsbatch"));
        sQLiteDatabase.execSQL(com.byazt.pvs.a.tt());
        sQLiteDatabase.execSQL(com.byazt.six.tt.ve());
        sQLiteDatabase.execSQL(com.byazt.zlb.ve.ve());
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_base_info (_id INTEGER PRIMARY KEY,value TEXT)");
        sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_global_info (_id INTEGER PRIMARY KEY,value TEXT)");
        sQLiteDatabase.execSQL(com.byazt.nq.ve.ve());
    }

    @Override // com.byazt.non.ve
    public void c(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        while (i < i2) {
            switch (i) {
                case 1:
                    tt(sQLiteDatabase, i, i2);
                    break;
                case 2:
                    sQLiteDatabase.execSQL("DROP TABLE IF EXISTS 'ad_video_info';");
                    tt(sQLiteDatabase, i, i2);
                    break;
                case 3:
                    sQLiteDatabase.execSQL(sp.uj("logstats"));
                    tt(sQLiteDatabase, i, i2);
                    break;
                case 4:
                    sQLiteDatabase.execSQL(com.byazt.six.tt.ve());
                    tt(sQLiteDatabase, i, i2);
                    break;
                case 5:
                    sQLiteDatabase.execSQL(com.byazt.twu.c.tt("logstatsbatch"));
                    tt(sQLiteDatabase, i, i2);
                    break;
                case 6:
                case 8:
                case 9:
                    tt(sQLiteDatabase, i, i2);
                    break;
                case 7:
                    sQLiteDatabase.execSQL(com.byazt.zlb.ve.ve());
                    sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_base_info (_id INTEGER PRIMARY KEY,value TEXT)");
                    sQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS setting_global_info (_id INTEGER PRIMARY KEY,value TEXT)");
                    tt(sQLiteDatabase, i, i2);
                    break;
                case 10:
                case 11:
                    try {
                        ve(sQLiteDatabase, i, i2);
                    } catch (Exception e) {
                        m.uj("OldSqliteDatabase", "database onUpgrade error version: " + i + ", msg: " + e.getMessage());
                    }
                    break;
            }
            i++;
        }
    }
}
