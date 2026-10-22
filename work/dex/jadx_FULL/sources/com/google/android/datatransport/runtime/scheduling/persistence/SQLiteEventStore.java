package com.google.android.datatransport.runtime.scheduling.persistence;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseLockedException;
import android.os.SystemClock;
import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.fl.saas.base.cache.DatabaseHelper;
import com.google.android.datatransport.runtime.EventInternal;
import com.google.android.datatransport.runtime.TransportContext;
import com.google.android.datatransport.runtime.synchronization.SynchronizationException;
import com.google.android.datatransport.runtime.synchronization.SynchronizationGuard;
import com.google.android.datatransport.runtime.time.Clock;
import com.google.android.datatransport.runtime.time.Monotonic;
import com.google.android.datatransport.runtime.time.WallTime;
import com.igexin.assist.sdk.AssistPushConsts;
import com.zj.adlib.f33;
import com.zj.adlib.h25;
import com.zj.adlib.sy6;
import com.zj.adlib.t13;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Singleton
@WorkerThread
public class SQLiteEventStore implements EventStore, SynchronizationGuard {
    public static final int K = 16;
    public static final int L = 50;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final f33 f30445a = f33.b("proto");
    public static final String f = "SQLiteEventStore";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final EventStoreConfig f1955a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SchemaManager f1956a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Clock f1957a;
    public final Clock b;

    public interface Function<T, U> {
        U apply(T t);
    }

    public interface Producer<T> {
        T a();
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f30446a;
        public final String b;

        public b(String str, String str2) {
            this.f30446a = str;
            this.b = str2;
        }
    }

    @Inject
    public SQLiteEventStore(@WallTime Clock clock, @Monotonic Clock clock2, EventStoreConfig eventStoreConfig, SchemaManager schemaManager) {
        this.f1956a = schemaManager;
        this.f1957a = clock;
        this.b = clock2;
        this.f1955a = eventStoreConfig;
    }

    public static String A0(Iterable<PersistedEvent> iterable) {
        StringBuilder sb = new StringBuilder("(");
        Iterator<PersistedEvent> it = iterable.iterator();
        while (it.hasNext()) {
            sb.append(it.next().c());
            if (it.hasNext()) {
                sb.append(',');
            }
        }
        sb.append(')');
        return sb.toString();
    }

    @VisibleForTesting
    public static <T> T B0(Cursor cursor, Function<Cursor, T> function) {
        try {
            return function.apply(cursor);
        } finally {
            cursor.close();
        }
    }

    public static /* synthetic */ Object E(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.beginTransaction();
        return null;
    }

    public static /* synthetic */ Object F(Throwable th) {
        throw new SynchronizationException("Timed out while trying to acquire the lock.", th);
    }

    public static /* synthetic */ SQLiteDatabase H(Throwable th) {
        throw new SynchronizationException("Timed out while trying to open db.", th);
    }

    public static /* synthetic */ Long J(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return 0L;
    }

    public static /* synthetic */ Long L(Cursor cursor) {
        if (cursor.moveToNext()) {
            return Long.valueOf(cursor.getLong(0));
        }
        return null;
    }

    public static /* synthetic */ Boolean M(SQLiteEventStore sQLiteEventStore, TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        Long lQ = sQLiteEventStore.q(sQLiteDatabase, transportContext);
        return lQ == null ? Boolean.FALSE : (Boolean) B0(sQLiteEventStore.l().rawQuery("SELECT 1 FROM events WHERE context_id = ? LIMIT 1", new String[]{lQ.toString()}), o.a());
    }

    public static /* synthetic */ List R(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        while (cursor.moveToNext()) {
            arrayList.add(TransportContext.a().b(cursor.getString(1)).d(sy6.b(cursor.getInt(2))).c(u0(cursor.getString(3))).a());
        }
        return arrayList;
    }

    public static /* synthetic */ List S(SQLiteDatabase sQLiteDatabase) {
        return (List) B0(sQLiteDatabase.rawQuery("SELECT distinct t._id, t.backend_name, t.priority, t.extras FROM transport_contexts AS t, events AS e WHERE e.context_id = t._id", new String[0]), n.a());
    }

    public static /* synthetic */ List W(SQLiteEventStore sQLiteEventStore, TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        List<PersistedEvent> listQ0 = sQLiteEventStore.q0(sQLiteDatabase, transportContext);
        return sQLiteEventStore.v(listQ0, sQLiteEventStore.r0(sQLiteDatabase, listQ0));
    }

    public static /* synthetic */ Object b0(SQLiteEventStore sQLiteEventStore, List list, TransportContext transportContext, Cursor cursor) {
        while (cursor.moveToNext()) {
            long j = cursor.getLong(0);
            boolean z = cursor.getInt(7) != 0;
            EventInternal.Builder builderI = EventInternal.a().h(cursor.getString(1)).g(cursor.getLong(2)).i(cursor.getLong(3));
            if (z) {
                builderI.f(new t13(z0(cursor.getString(4)), cursor.getBlob(5)));
            } else {
                builderI.f(new t13(z0(cursor.getString(4)), sQLiteEventStore.v0(j)));
            }
            if (!cursor.isNull(6)) {
                builderI.e(Integer.valueOf(cursor.getInt(6)));
            }
            list.add(PersistedEvent.a(j, transportContext, builderI.d()));
        }
        return null;
    }

    public static /* synthetic */ Object i0(Map map, Cursor cursor) {
        while (true) {
            if (!cursor.moveToNext()) {
                return null;
            }
            long j = cursor.getLong(0);
            Set hashSet = (Set) map.get(Long.valueOf(j));
            if (hashSet == null) {
                hashSet = new HashSet();
                map.put(Long.valueOf(j), hashSet);
            }
            hashSet.add(new b(cursor.getString(1), cursor.getString(2)));
        }
    }

    public static /* synthetic */ Long j0(SQLiteEventStore sQLiteEventStore, TransportContext transportContext, EventInternal eventInternal, SQLiteDatabase sQLiteDatabase) {
        if (sQLiteEventStore.s()) {
            return -1L;
        }
        long j = sQLiteEventStore.j(sQLiteDatabase, transportContext);
        int iE = sQLiteEventStore.f1955a.e();
        byte[] bArrA = eventInternal.d().a();
        boolean z = bArrA.length <= iE;
        ContentValues contentValues = new ContentValues();
        contentValues.put("context_id", Long.valueOf(j));
        contentValues.put("transport_name", eventInternal.k());
        contentValues.put("timestamp_ms", Long.valueOf(eventInternal.e()));
        contentValues.put("uptime_ms", Long.valueOf(eventInternal.l()));
        contentValues.put("payload_encoding", eventInternal.d().b().a());
        contentValues.put("code", eventInternal.c());
        contentValues.put("num_attempts", (Integer) 0);
        contentValues.put("inline", Boolean.valueOf(z));
        contentValues.put(AssistPushConsts.MSG_TYPE_PAYLOAD, z ? bArrA : new byte[0]);
        long jInsert = sQLiteDatabase.insert("events", null, contentValues);
        if (!z) {
            int iCeil = (int) Math.ceil(((double) bArrA.length) / ((double) iE));
            for (int i = 1; i <= iCeil; i++) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(bArrA, (i - 1) * iE, Math.min(i * iE, bArrA.length));
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("event_id", Long.valueOf(jInsert));
                contentValues2.put("sequence_num", Integer.valueOf(i));
                contentValues2.put("bytes", bArrCopyOfRange);
                sQLiteDatabase.insert("event_payloads", null, contentValues2);
            }
        }
        for (Map.Entry<String, String> entry : eventInternal.h().entrySet()) {
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("event_id", Long.valueOf(jInsert));
            contentValues3.put("name", entry.getKey());
            contentValues3.put("value", entry.getValue());
            sQLiteDatabase.insert("event_metadata", null, contentValues3);
        }
        return Long.valueOf(jInsert);
    }

    public static /* synthetic */ byte[] k0(Cursor cursor) {
        ArrayList arrayList = new ArrayList();
        int length = 0;
        while (cursor.moveToNext()) {
            byte[] blob = cursor.getBlob(0);
            arrayList.add(blob);
            length += blob.length;
        }
        byte[] bArr = new byte[length];
        int length2 = 0;
        for (int i = 0; i < arrayList.size(); i++) {
            byte[] bArr2 = (byte[]) arrayList.get(i);
            System.arraycopy(bArr2, 0, bArr, length2, bArr2.length);
            length2 += bArr2.length;
        }
        return bArr;
    }

    public static /* synthetic */ Object m0(String str, SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.compileStatement(str).execute();
        sQLiteDatabase.compileStatement("DELETE FROM events WHERE num_attempts >= 16").execute();
        return null;
    }

    public static /* synthetic */ Object o0(long j, TransportContext transportContext, SQLiteDatabase sQLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("next_request_ms", Long.valueOf(j));
        if (sQLiteDatabase.update("transport_contexts", contentValues, "backend_name = ? and priority = ?", new String[]{transportContext.b(), String.valueOf(sy6.a(transportContext.d()))}) < 1) {
            contentValues.put("backend_name", transportContext.b());
            contentValues.put("priority", Integer.valueOf(sy6.a(transportContext.d())));
            sQLiteDatabase.insert("transport_contexts", null, contentValues);
        }
        return null;
    }

    public static byte[] u0(@Nullable String str) {
        if (str == null) {
            return null;
        }
        return Base64.decode(str, 0);
    }

    public static /* synthetic */ Object y(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.delete("events", null, new String[0]);
        sQLiteDatabase.delete("transport_contexts", null, new String[0]);
        return null;
    }

    public static f33 z0(@Nullable String str) {
        return str == null ? f30445a : f33.b(str);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public void F0(Iterable<PersistedEvent> iterable) {
        if (iterable.iterator().hasNext()) {
            r(s.a("UPDATE events SET num_attempts = num_attempts + 1 WHERE _id in " + A0(iterable)));
        }
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    @Nullable
    public PersistedEvent I(TransportContext transportContext, EventInternal eventInternal) {
        h25.d(f, "Storing event with priority=%s, name=%s for destination %s", transportContext.d(), eventInternal.k(), transportContext.b());
        long jLongValue = ((Long) r(q.a(this, transportContext, eventInternal))).longValue();
        if (jLongValue < 1) {
            return null;
        }
        return PersistedEvent.a(jLongValue, transportContext, eventInternal);
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public int O() {
        return ((Integer) r(f.a(this.f1957a.getTime() - this.f1955a.c()))).intValue();
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public Iterable<PersistedEvent> T(TransportContext transportContext) {
        return (Iterable) r(d.a(this, transportContext));
    }

    @Override // com.google.android.datatransport.runtime.synchronization.SynchronizationGuard
    public <T> T a(SynchronizationGuard.CriticalSection<T> criticalSection) {
        SQLiteDatabase sQLiteDatabaseL = l();
        h(sQLiteDatabaseL);
        try {
            T tA = criticalSection.a();
            sQLiteDatabaseL.setTransactionSuccessful();
            return tA;
        } finally {
            sQLiteDatabaseL.endTransaction();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.f1956a.close();
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public void e0(Iterable<PersistedEvent> iterable) {
        if (iterable.iterator().hasNext()) {
            l().compileStatement("DELETE FROM events WHERE _id in " + A0(iterable)).execute();
        }
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    public void g() {
        r(g.a());
    }

    public final long getPageSize() {
        return l().compileStatement("PRAGMA page_size").simpleQueryForLong();
    }

    public final void h(SQLiteDatabase sQLiteDatabase) {
        y0(k.b(sQLiteDatabase), l.a());
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public void h0(TransportContext transportContext, long j) {
        r(c.a(j, transportContext));
    }

    public final long j(SQLiteDatabase sQLiteDatabase, TransportContext transportContext) {
        Long lQ = q(sQLiteDatabase, transportContext);
        if (lQ != null) {
            return lQ.longValue();
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("backend_name", transportContext.b());
        contentValues.put("priority", Integer.valueOf(sy6.a(transportContext.d())));
        contentValues.put("next_request_ms", (Integer) 0);
        if (transportContext.c() != null) {
            contentValues.put("extras", Base64.encodeToString(transportContext.c(), 0));
        }
        return sQLiteDatabase.insert("transport_contexts", null, contentValues);
    }

    @VisibleForTesting
    public long k() {
        return p() * getPageSize();
    }

    @VisibleForTesting
    public SQLiteDatabase l() {
        SchemaManager schemaManager = this.f1956a;
        schemaManager.getClass();
        return (SQLiteDatabase) y0(m.b(schemaManager), p.a());
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public Iterable<TransportContext> l0() {
        return (Iterable) r(e.a());
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public boolean n0(TransportContext transportContext) {
        return ((Boolean) r(u.a(this, transportContext))).booleanValue();
    }

    public final long p() {
        return l().compileStatement("PRAGMA page_count").simpleQueryForLong();
    }

    @Nullable
    public final Long q(SQLiteDatabase sQLiteDatabase, TransportContext transportContext) {
        StringBuilder sb = new StringBuilder("backend_name = ? and priority = ?");
        ArrayList arrayList = new ArrayList(Arrays.asList(transportContext.b(), String.valueOf(sy6.a(transportContext.d()))));
        if (transportContext.c() != null) {
            sb.append(" and extras = ?");
            arrayList.add(Base64.encodeToString(transportContext.c(), 0));
        } else {
            sb.append(" and extras is null");
        }
        return (Long) B0(sQLiteDatabase.query("transport_contexts", new String[]{DatabaseHelper.COLUMN_ID}, sb.toString(), (String[]) arrayList.toArray(new String[0]), null, null, null), r.a());
    }

    public final List<PersistedEvent> q0(SQLiteDatabase sQLiteDatabase, TransportContext transportContext) {
        ArrayList arrayList = new ArrayList();
        Long lQ = q(sQLiteDatabase, transportContext);
        if (lQ == null) {
            return arrayList;
        }
        B0(sQLiteDatabase.query("events", new String[]{DatabaseHelper.COLUMN_ID, "transport_name", "timestamp_ms", "uptime_ms", "payload_encoding", AssistPushConsts.MSG_TYPE_PAYLOAD, "code", "inline"}, "context_id = ?", new String[]{lQ.toString()}, null, null, null, String.valueOf(this.f1955a.d())), h.a(this, arrayList, transportContext));
        return arrayList;
    }

    @VisibleForTesting
    public <T> T r(Function<SQLiteDatabase, T> function) {
        SQLiteDatabase sQLiteDatabaseL = l();
        sQLiteDatabaseL.beginTransaction();
        try {
            T tApply = function.apply(sQLiteDatabaseL);
            sQLiteDatabaseL.setTransactionSuccessful();
            return tApply;
        } finally {
            sQLiteDatabaseL.endTransaction();
        }
    }

    public final Map<Long, Set<b>> r0(SQLiteDatabase sQLiteDatabase, List<PersistedEvent> list) {
        HashMap map = new HashMap();
        StringBuilder sb = new StringBuilder("event_id IN (");
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i).c());
            if (i < list.size() - 1) {
                sb.append(',');
            }
        }
        sb.append(')');
        B0(sQLiteDatabase.query("event_metadata", new String[]{"event_id", "name", "value"}, sb.toString(), null, null, null, null), j.a(map));
        return map;
    }

    public final boolean s() {
        return p() * getPageSize() >= this.f1955a.f();
    }

    @Override // com.google.android.datatransport.runtime.scheduling.persistence.EventStore
    public long t(TransportContext transportContext) {
        return ((Long) B0(l().rawQuery("SELECT next_request_ms FROM transport_contexts WHERE backend_name = ? and priority = ?", new String[]{transportContext.b(), String.valueOf(sy6.a(transportContext.d()))}), t.a())).longValue();
    }

    public final List<PersistedEvent> v(List<PersistedEvent> list, Map<Long, Set<b>> map) {
        ListIterator<PersistedEvent> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            PersistedEvent next = listIterator.next();
            if (map.containsKey(Long.valueOf(next.c()))) {
                EventInternal.Builder builderM = next.b().m();
                for (b bVar : map.get(Long.valueOf(next.c()))) {
                    builderM.c(bVar.f30446a, bVar.b);
                }
                listIterator.set(PersistedEvent.a(next.c(), next.d(), builderM.d()));
            }
        }
        return list;
    }

    public final byte[] v0(long j) {
        return (byte[]) B0(l().query("event_payloads", new String[]{"bytes"}, "event_id = ?", new String[]{String.valueOf(j)}, null, null, "sequence_num"), i.a());
    }

    public final <T> T y0(Producer<T> producer, Function<Throwable, T> function) {
        long time = this.b.getTime();
        while (true) {
            try {
                return producer.a();
            } catch (SQLiteDatabaseLockedException e) {
                if (this.b.getTime() >= ((long) this.f1955a.b()) + time) {
                    return function.apply(e);
                }
                SystemClock.sleep(50L);
            }
        }
    }
}
