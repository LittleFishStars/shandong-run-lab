package com.kc.bw.okhttp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.kc.bw.dexg;
import com.kc.bw.okhttp.OkHttp;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class DBHelper extends SQLiteOpenHelper {
    public static final int DB_CACHE_VERSION = 1;
    public static final String TABLE_CACHE = dexg.dexa("dbdif");
    public static final String TABLE_COOKIE = dexg.dexa("dppljf");
    public static final String TABLE_DOWNLOAD = dexg.dexa("epxompbe");
    public static final String TABLE_UPLOAD = dexg.dexa("vqmpbe");
    public static final Lock lock = new ReentrantLock();
    public TableEntity cacheTableEntity;
    public TableEntity cookieTableEntity;
    public TableEntity downloadTableEntity;
    public TableEntity uploadTableEntity;

    public DBHelper() {
        this(OkHttp.getInstance().getContext().getApplicationContext());
    }

    public DBHelper(Context context) {
        super(context, dexg.dexa("ldcxiuuq/ec"), (SQLiteDatabase.CursorFactory) null, 1);
        this.cacheTableEntity = new TableEntity(dexg.dexa("dbdif"));
        this.cookieTableEntity = new TableEntity(dexg.dexa("dppljf"));
        this.downloadTableEntity = new TableEntity(dexg.dexa("epxompbe"));
        this.uploadTableEntity = new TableEntity(dexg.dexa("vqmpbe"));
        this.cacheTableEntity.addColumn(new ColumnEntity(dexg.dexa("lfz"), dexg.dexa("WBSDIBS"), true, true)).addColumn(new ColumnEntity(dexg.dexa("mpdbmFyqjsf"), dexg.dexa("JOUFHFS"))).addColumn(new ColumnEntity(dexg.dexa("ifbe"), dexg.dexa("CMPC"))).addColumn(new ColumnEntity(dexg.dexa("ebub"), dexg.dexa("CMPC")));
        this.cookieTableEntity.addColumn(new ColumnEntity(dexg.dexa("iptu"), dexg.dexa("WBSDIBS"))).addColumn(new ColumnEntity(dexg.dexa("obnf"), dexg.dexa("WBSDIBS"))).addColumn(new ColumnEntity(dexg.dexa("epnbjo"), dexg.dexa("WBSDIBS"))).addColumn(new ColumnEntity(dexg.dexa("dppljf"), dexg.dexa("CMPC"))).addColumn(new ColumnEntity(dexg.dexa("iptu"), dexg.dexa("obnf"), dexg.dexa("epnbjo")));
        this.downloadTableEntity.addColumn(new ColumnEntity(dexg.dexa("ubh"), dexg.dexa("WBSDIBS"), true, true)).addColumn(new ColumnEntity(dexg.dexa("vsm"), dexg.dexa("WBSDIBS"))).addColumn(new ColumnEntity(dexg.dexa("gpmefs"), dexg.dexa("WBSDIBS"))).addColumn(new ColumnEntity(dexg.dexa("gjmfQbui"), dexg.dexa("WBSDIBS"))).addColumn(new ColumnEntity(dexg.dexa("gjmfObnf"), dexg.dexa("WBSDIBS"))).addColumn(new ColumnEntity(dexg.dexa("gsbdujpo"), dexg.dexa("WBSDIBS"))).addColumn(new ColumnEntity(dexg.dexa("upubmTj{f"), dexg.dexa("JOUFHFS"))).addColumn(new ColumnEntity(dexg.dexa("dvssfouTj{f"), dexg.dexa("JOUFHFS"))).addColumn(new ColumnEntity(dexg.dexa("tubuvt"), dexg.dexa("JOUFHFS"))).addColumn(new ColumnEntity(dexg.dexa("qsjpsjuz"), dexg.dexa("JOUFHFS"))).addColumn(new ColumnEntity(dexg.dexa("ebuf"), dexg.dexa("JOUFHFS"))).addColumn(new ColumnEntity(dexg.dexa("sfrvftu"), dexg.dexa("CMPC"))).addColumn(new ColumnEntity(dexg.dexa("fyusb2"), dexg.dexa("CMPC"))).addColumn(new ColumnEntity(dexg.dexa("fyusb3"), dexg.dexa("CMPC"))).addColumn(new ColumnEntity(dexg.dexa("fyusb4"), dexg.dexa("CMPC")));
        this.uploadTableEntity.addColumn(new ColumnEntity(dexg.dexa("ubh"), dexg.dexa("WBSDIBS"), true, true)).addColumn(new ColumnEntity(dexg.dexa("vsm"), dexg.dexa("WBSDIBS"))).addColumn(new ColumnEntity(dexg.dexa("gpmefs"), dexg.dexa("WBSDIBS"))).addColumn(new ColumnEntity(dexg.dexa("gjmfQbui"), dexg.dexa("WBSDIBS"))).addColumn(new ColumnEntity(dexg.dexa("gjmfObnf"), dexg.dexa("WBSDIBS"))).addColumn(new ColumnEntity(dexg.dexa("gsbdujpo"), dexg.dexa("WBSDIBS"))).addColumn(new ColumnEntity(dexg.dexa("upubmTj{f"), dexg.dexa("JOUFHFS"))).addColumn(new ColumnEntity(dexg.dexa("dvssfouTj{f"), dexg.dexa("JOUFHFS"))).addColumn(new ColumnEntity(dexg.dexa("tubuvt"), dexg.dexa("JOUFHFS"))).addColumn(new ColumnEntity(dexg.dexa("qsjpsjuz"), dexg.dexa("JOUFHFS"))).addColumn(new ColumnEntity(dexg.dexa("ebuf"), dexg.dexa("JOUFHFS"))).addColumn(new ColumnEntity(dexg.dexa("sfrvftu"), dexg.dexa("CMPC"))).addColumn(new ColumnEntity(dexg.dexa("fyusb2"), dexg.dexa("CMPC"))).addColumn(new ColumnEntity(dexg.dexa("fyusb3"), dexg.dexa("CMPC"))).addColumn(new ColumnEntity(dexg.dexa("fyusb4"), dexg.dexa("CMPC")));
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(this.cacheTableEntity.buildTableString());
        sQLiteDatabase.execSQL(this.cookieTableEntity.buildTableString());
        sQLiteDatabase.execSQL(this.downloadTableEntity.buildTableString());
        sQLiteDatabase.execSQL(this.uploadTableEntity.buildTableString());
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        onUpgrade(sQLiteDatabase, i, i2);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        if (DBUtils.isNeedUpgradeTable(sQLiteDatabase, this.cacheTableEntity)) {
            sQLiteDatabase.execSQL(dexg.dexa("ESPQ!UBCMF!JG!FYJTUT!dbdif"));
        }
        if (DBUtils.isNeedUpgradeTable(sQLiteDatabase, this.cookieTableEntity)) {
            sQLiteDatabase.execSQL(dexg.dexa("ESPQ!UBCMF!JG!FYJTUT!dppljf"));
        }
        if (DBUtils.isNeedUpgradeTable(sQLiteDatabase, this.downloadTableEntity)) {
            sQLiteDatabase.execSQL(dexg.dexa("ESPQ!UBCMF!JG!FYJTUT!epxompbe"));
        }
        if (DBUtils.isNeedUpgradeTable(sQLiteDatabase, this.uploadTableEntity)) {
            sQLiteDatabase.execSQL(dexg.dexa("ESPQ!UBCMF!JG!FYJTUT!vqmpbe"));
        }
        onCreate(sQLiteDatabase);
    }
}
