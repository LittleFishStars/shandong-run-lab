package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.zj.adlib.tv7;
import com.zj.adlib.uv7;
import com.zj.adlib.vv7;
import com.zj.adlib.wv7;
import java.util.Arrays;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class SchemaManager extends SQLiteOpenHelper {
    public static int L = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Migration f30447a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final List<Migration> f1958a;
    public static final Migration b;
    public static final Migration c;
    public static final Migration d;
    public static final String f = "com.google.android.datatransport.events";
    public static final String g = "CREATE TABLE events (_id INTEGER PRIMARY KEY, context_id INTEGER NOT NULL, transport_name TEXT NOT NULL, timestamp_ms INTEGER NOT NULL, uptime_ms INTEGER NOT NULL, payload BLOB NOT NULL, code INTEGER, num_attempts INTEGER NOT NULL,FOREIGN KEY (context_id) REFERENCES transport_contexts(_id) ON DELETE CASCADE)";
    public static final String h = "CREATE TABLE event_metadata (_id INTEGER PRIMARY KEY, event_id INTEGER NOT NULL, name TEXT NOT NULL, value TEXT NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE)";
    public static final String i = "CREATE TABLE transport_contexts (_id INTEGER PRIMARY KEY, backend_name TEXT NOT NULL, priority INTEGER NOT NULL, next_request_ms INTEGER NOT NULL)";
    public static final String j = "CREATE INDEX events_backend_id on events(context_id)";
    public static final String k = "CREATE UNIQUE INDEX contexts_backend_priority on transport_contexts(backend_name, priority)";
    public static final String l = "DROP TABLE events";
    public static final String m = "DROP TABLE event_metadata";
    public static final String n = "DROP TABLE transport_contexts";
    public static final String o = "CREATE TABLE event_payloads (sequence_num INTEGER NOT NULL, event_id INTEGER NOT NULL, bytes BLOB NOT NULL,FOREIGN KEY (event_id) REFERENCES events(_id) ON DELETE CASCADE,PRIMARY KEY (sequence_num, event_id))";
    public static final String p = "DROP TABLE IF EXISTS event_payloads";
    public final int K;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1959a;

    public interface Migration {
        void a(SQLiteDatabase sQLiteDatabase);
    }

    static {
        Migration migrationB = tv7.b();
        f30447a = migrationB;
        Migration migrationB2 = uv7.b();
        b = migrationB2;
        Migration migrationB3 = vv7.b();
        c = migrationB3;
        Migration migrationB4 = wv7.b();
        d = migrationB4;
        f1958a = Arrays.asList(migrationB, migrationB2, migrationB3, migrationB4);
    }

    @Inject
    public SchemaManager(Context context, @Named("SQLITE_DB_NAME") String str, @Named("SCHEMA_VERSION") int i2) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, i2);
        this.f1959a = false;
        this.K = i2;
    }

    public static /* synthetic */ void b(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL(g);
        sQLiteDatabase.execSQL(h);
        sQLiteDatabase.execSQL(i);
        sQLiteDatabase.execSQL(j);
        sQLiteDatabase.execSQL(k);
    }

    public static /* synthetic */ void c(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE transport_contexts ADD COLUMN extras BLOB");
        sQLiteDatabase.execSQL("CREATE UNIQUE INDEX contexts_backend_priority_extras on transport_contexts(backend_name, priority, extras)");
        sQLiteDatabase.execSQL("DROP INDEX contexts_backend_priority");
    }

    public static /* synthetic */ void f(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("ALTER TABLE events ADD COLUMN inline BOOLEAN NOT NULL DEFAULT 1");
        sQLiteDatabase.execSQL(p);
        sQLiteDatabase.execSQL(o);
    }

    public final void a(SQLiteDatabase sQLiteDatabase) {
        if (this.f1959a) {
            return;
        }
        onConfigure(sQLiteDatabase);
    }

    public final void g(SQLiteDatabase sQLiteDatabase, int i2) {
        a(sQLiteDatabase);
        h(sQLiteDatabase, 0, i2);
    }

    public final void h(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        List<Migration> list = f1958a;
        if (i3 <= list.size()) {
            while (i2 < i3) {
                f1958a.get(i2).a(sQLiteDatabase);
                i2++;
            }
            return;
        }
        throw new IllegalArgumentException("Migration from " + i2 + " to " + i3 + " was requested, but cannot be performed. Only " + list.size() + " migrations are provided");
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onConfigure(SQLiteDatabase sQLiteDatabase) {
        this.f1959a = true;
        sQLiteDatabase.rawQuery("PRAGMA busy_timeout=0;", new String[0]).close();
        sQLiteDatabase.setForeignKeyConstraintsEnabled(true);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        g(sQLiteDatabase, this.K);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        sQLiteDatabase.execSQL(l);
        sQLiteDatabase.execSQL(m);
        sQLiteDatabase.execSQL(n);
        sQLiteDatabase.execSQL(p);
        g(sQLiteDatabase, i3);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onOpen(SQLiteDatabase sQLiteDatabase) {
        a(sQLiteDatabase);
    }

    @Override // android.database.sqlite.SQLiteOpenHelper
    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        a(sQLiteDatabase);
        h(sQLiteDatabase, i2, i3);
    }
}
