package com.zj.adlib;

import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import com.blankj.utilcode.util.Utils;
import com.tencent.wcdb.database.SQLiteCipherSpec;
import com.tencent.wcdb.room.db.WCDBOpenHelperFactory;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class fj7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static fj7 f41689a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<String, Object> f16534a = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final WCDBOpenHelperFactory f16533a = new WCDBOpenHelperFactory().passphrase("#BN^%dE-uMT$^ro$RSz5k$4cLkp@Fiw&".getBytes()).cipherSpec(new SQLiteCipherSpec().setPageSize(4096).setKDFIteration(64000)).writeAheadLoggingEnabled(true).asyncCheckpointEnabled(true);

    public static fj7 b() {
        if (f41689a == null) {
            f41689a = new fj7();
        }
        return f41689a;
    }

    public <T extends RoomDatabase> T a(Class<T> cls, Migration... migrationArr) {
        String simpleName = cls.getSimpleName();
        if (this.f16534a.containsKey(simpleName)) {
            return (T) this.f16534a.get(simpleName);
        }
        RoomDatabase.Builder<T> journalMode = Room.databaseBuilder(Utils.a(), cls, simpleName).openHelperFactory(this.f16533a).fallbackToDestructiveMigration().setJournalMode(RoomDatabase.JournalMode.AUTOMATIC);
        if (migrationArr != null && migrationArr.length > 0) {
            journalMode.addMigrations(migrationArr);
        }
        T t = (T) journalMode.build();
        this.f16534a.put(simpleName, t);
        return t;
    }
}
