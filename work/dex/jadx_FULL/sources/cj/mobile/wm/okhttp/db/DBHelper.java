package cj.mobile.wm.okhttp.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import cj.mobile.wm.dexc;
import cj.mobile.wm.okhttp.OkHttp;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DBHelper extends SQLiteOpenHelper {
    public static final int DB_CACHE_VERSION = 1;
    public static final String TABLE_CACHE = dexc.dexa("dbdif");
    public static final String TABLE_COOKIE = dexc.dexa("dppljf");
    public static final String TABLE_DOWNLOAD = dexc.dexa("epxompbe");
    public static final String TABLE_UPLOAD = dexc.dexa("vqmpbe");
    public static final Lock lock = new ReentrantLock();
    public TableEntity cacheTableEntity;
    public TableEntity cookieTableEntity;
    public TableEntity downloadTableEntity;
    public TableEntity uploadTableEntity;

    public DBHelper() {
        this(OkHttp.getInstance().getContext().getApplicationContext());
    }

    public DBHelper(Context context) {
        super(context, dexc.dexa("mzxniuuq/ec"), (SQLiteDatabase.CursorFactory) null, 1);
        this.cacheTableEntity = new TableEntity(dexc.dexa("dbdif"));
        this.cookieTableEntity = new TableEntity(dexc.dexa("dppljf"));
        this.downloadTableEntity = new TableEntity(dexc.dexa("epxompbe"));
        this.uploadTableEntity = new TableEntity(dexc.dexa("vqmpbe"));
        this.cacheTableEntity.addColumn(new ColumnEntity(dexc.dexa("lfz"), dexc.dexa("WBSDIBS"), true, true)).addColumn(new ColumnEntity(dexc.dexa("mpdbmFyqjsf"), dexc.dexa("JOUFHFS"))).addColumn(new ColumnEntity(dexc.dexa("ifbe"), dexc.dexa("CMPC"))).addColumn(new ColumnEntity(dexc.dexa("ebub"), dexc.dexa("CMPC")));
        this.cookieTableEntity.addColumn(new ColumnEntity(dexc.dexa("iptu"), dexc.dexa("WBSDIBS"))).addColumn(new ColumnEntity(dexc.dexa("obnf"), dexc.dexa("WBSDIBS"))).addColumn(new ColumnEntity(dexc.dexa("epnbjo"), dexc.dexa("WBSDIBS"))).addColumn(new ColumnEntity(dexc.dexa("dppljf"), dexc.dexa("CMPC"))).addColumn(new ColumnEntity(dexc.dexa("iptu"), dexc.dexa("obnf"), dexc.dexa("epnbjo")));
        this.downloadTableEntity.addColumn(new ColumnEntity(dexc.dexa("ubh"), dexc.dexa("WBSDIBS"), true, true)).addColumn(new ColumnEntity(dexc.dexa("vsm"), dexc.dexa("WBSDIBS"))).addColumn(new ColumnEntity(dexc.dexa("gpmefs"), dexc.dexa("WBSDIBS"))).addColumn(new ColumnEntity(dexc.dexa("gjmfQbui"), dexc.dexa("WBSDIBS"))).addColumn(new ColumnEntity(dexc.dexa("gjmfObnf"), dexc.dexa("WBSDIBS"))).addColumn(new ColumnEntity(dexc.dexa("gsbdujpo"), dexc.dexa("WBSDIBS"))).addColumn(new ColumnEntity(dexc.dexa("upubmTj{f"), dexc.dexa("JOUFHFS"))).addColumn(new ColumnEntity(dexc.dexa("dvssfouTj{f"), dexc.dexa("JOUFHFS"))).addColumn(new ColumnEntity(dexc.dexa("tubuvt"), dexc.dexa("JOUFHFS"))).addColumn(new ColumnEntity(dexc.dexa("qsjpsjuz"), dexc.dexa("JOUFHFS"))).addColumn(new ColumnEntity(dexc.dexa("ebuf"), dexc.dexa("JOUFHFS"))).addColumn(new ColumnEntity(dexc.dexa("sfrvftu"), dexc.dexa("CMPC"))).addColumn(new ColumnEntity(dexc.dexa("fyusb2"), dexc.dexa("CMPC"))).addColumn(new ColumnEntity(dexc.dexa("fyusb3"), dexc.dexa("CMPC"))).addColumn(new ColumnEntity(dexc.dexa("fyusb4"), dexc.dexa("CMPC")));
        this.uploadTableEntity.addColumn(new ColumnEntity(dexc.dexa("ubh"), dexc.dexa("WBSDIBS"), true, true)).addColumn(new ColumnEntity(dexc.dexa("vsm"), dexc.dexa("WBSDIBS"))).addColumn(new ColumnEntity(dexc.dexa("gpmefs"), dexc.dexa("WBSDIBS"))).addColumn(new ColumnEntity(dexc.dexa("gjmfQbui"), dexc.dexa("WBSDIBS"))).addColumn(new ColumnEntity(dexc.dexa("gjmfObnf"), dexc.dexa("WBSDIBS"))).addColumn(new ColumnEntity(dexc.dexa("gsbdujpo"), dexc.dexa("WBSDIBS"))).addColumn(new ColumnEntity(dexc.dexa("upubmTj{f"), dexc.dexa("JOUFHFS"))).addColumn(new ColumnEntity(dexc.dexa("dvssfouTj{f"), dexc.dexa("JOUFHFS"))).addColumn(new ColumnEntity(dexc.dexa("tubuvt"), dexc.dexa("JOUFHFS"))).addColumn(new ColumnEntity(dexc.dexa("qsjpsjuz"), dexc.dexa("JOUFHFS"))).addColumn(new ColumnEntity(dexc.dexa("ebuf"), dexc.dexa("JOUFHFS"))).addColumn(new ColumnEntity(dexc.dexa("sfrvftu"), dexc.dexa("CMPC"))).addColumn(new ColumnEntity(dexc.dexa("fyusb2"), dexc.dexa("CMPC"))).addColumn(new ColumnEntity(dexc.dexa("fyusb3"), dexc.dexa("CMPC"))).addColumn(new ColumnEntity(dexc.dexa("fyusb4"), dexc.dexa("CMPC")));
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
            sQLiteDatabase.execSQL(dexc.dexa("ESPQ!UBCMF!JG!FYJTUT!dbdif"));
        }
        if (DBUtils.isNeedUpgradeTable(sQLiteDatabase, this.cookieTableEntity)) {
            sQLiteDatabase.execSQL(dexc.dexa("ESPQ!UBCMF!JG!FYJTUT!dppljf"));
        }
        if (DBUtils.isNeedUpgradeTable(sQLiteDatabase, this.downloadTableEntity)) {
            sQLiteDatabase.execSQL(dexc.dexa("ESPQ!UBCMF!JG!FYJTUT!epxompbe"));
        }
        if (DBUtils.isNeedUpgradeTable(sQLiteDatabase, this.uploadTableEntity)) {
            sQLiteDatabase.execSQL(dexc.dexa("ESPQ!UBCMF!JG!FYJTUT!vqmpbe"));
        }
        onCreate(sQLiteDatabase);
    }
}
