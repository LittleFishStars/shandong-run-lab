package com.google.android.exoplayer2.upstream.cache;

import android.os.ConditionVariable;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.android.exoplayer2.util.Log;
import com.zj.adlib.aa1;
import com.zj.adlib.ca1;
import com.zj.adlib.gj9;
import com.zj.adlib.kg8;
import com.zj.adlib.sb0;
import com.zj.adlib.t91;
import com.zj.adlib.u91;
import com.zj.adlib.wu1;
import java.io.File;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a implements Cache {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f31141a = 10;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f5189a = "SimpleCache";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final HashSet<File> f5190a = new HashSet<>();
    public static final String b = ".uid";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Cache.CacheException f5191a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CacheEvictor f5192a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CachedContentIndex f5193a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final u91 f5194a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final File f5195a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HashMap<String, ArrayList<Cache.Listener>> f5196a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Random f5197a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f5198a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f5199b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f5200b;
    public long c;

    /* JADX INFO: renamed from: com.google.android.exoplayer2.upstream.cache.a$a, reason: collision with other inner class name */
    public class C0702a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ConditionVariable f31142a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C0702a(String str, ConditionVariable conditionVariable) {
            super(str);
            this.f31142a = conditionVariable;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            synchronized (a.this) {
                this.f31142a.open();
                a.this.p();
                a.this.f5192a.onCacheInitialized();
            }
        }
    }

    @Deprecated
    public a(File file, CacheEvictor cacheEvictor) {
        this(file, cacheEvictor, (byte[]) null, false);
    }

    public static synchronized void B(File file) {
        f5190a.remove(file.getAbsoluteFile());
    }

    @WorkerThread
    public static void delete(File file, @Nullable DatabaseProvider databaseProvider) {
        if (file.exists()) {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                file.delete();
                return;
            }
            if (databaseProvider != null) {
                long jS = s(fileArrListFiles);
                if (jS != -1) {
                    try {
                        u91.delete(databaseProvider, jS);
                    } catch (DatabaseIOException unused) {
                        Log.n(f5189a, "Failed to delete file metadata: " + jS);
                    }
                    try {
                        CachedContentIndex.delete(databaseProvider, jS);
                    } catch (DatabaseIOException unused2) {
                        Log.n(f5189a, "Failed to delete file metadata: " + jS);
                    }
                }
            }
            gj9.l1(file);
        }
    }

    public static void m(File file) throws Cache.CacheException {
        if (file.mkdirs() || file.isDirectory()) {
            return;
        }
        String str = "Failed to create cache directory: " + file;
        Log.d(f5189a, str);
        throw new Cache.CacheException(str);
    }

    public static long n(File file) throws IOException {
        long jNextLong = new SecureRandom().nextLong();
        long jAbs = jNextLong == Long.MIN_VALUE ? 0L : Math.abs(jNextLong);
        File file2 = new File(file, Long.toString(jAbs, 16) + b);
        if (file2.createNewFile()) {
            return jAbs;
        }
        throw new IOException("Failed to create UID file: " + file2);
    }

    public static synchronized boolean q(File file) {
        return f5190a.contains(file.getAbsoluteFile());
    }

    public static long s(File[] fileArr) {
        int length = fileArr.length;
        for (int i = 0; i < length; i++) {
            File file = fileArr[i];
            String name = file.getName();
            if (name.endsWith(b)) {
                try {
                    return x(name);
                } catch (NumberFormatException unused) {
                    Log.d(f5189a, "Malformed UID file: " + file);
                    file.delete();
                }
            }
        }
        return -1L;
    }

    public static synchronized boolean t(File file) {
        return f5190a.add(file.getAbsoluteFile());
    }

    public static long x(String str) {
        return Long.parseLong(str.substring(0, str.indexOf(46)), 16);
    }

    public final kg8 A(String str, kg8 kg8Var) {
        boolean z;
        if (!this.f5198a) {
            return kg8Var;
        }
        String name = ((File) sb0.g(((aa1) kg8Var).f15218a)).getName();
        long j = kg8Var.b;
        long jCurrentTimeMillis = System.currentTimeMillis();
        u91 u91Var = this.f5194a;
        if (u91Var != null) {
            try {
                u91Var.h(name, j, jCurrentTimeMillis);
            } catch (IOException unused) {
                Log.n(f5189a, "Failed to update index with new touch timestamp.");
            }
            z = false;
        } else {
            z = true;
        }
        kg8 kg8VarL = this.f5193a.g(str).l(kg8Var, jCurrentTimeMillis, z);
        w(kg8Var, kg8VarL);
        return kg8VarL;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    @Nullable
    public synchronized aa1 a(String str, long j, long j2) throws Cache.CacheException {
        sb0.i(!this.f5200b);
        l();
        kg8 kg8VarO = o(str, j, j2);
        if (((aa1) kg8VarO).f15219a) {
            return A(str, kg8VarO);
        }
        if (this.f5193a.n(str).j(j, kg8VarO.b)) {
            return kg8VarO;
        }
        return null;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized NavigableSet<aa1> b(String str, Cache.Listener listener) {
        sb0.i(!this.f5200b);
        sb0.g(str);
        sb0.g(listener);
        ArrayList<Cache.Listener> arrayList = this.f5196a.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f5196a.put(str, arrayList);
        }
        arrayList.add(listener);
        return getCachedSpans(str);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized ContentMetadata c(String str) {
        sb0.i(!this.f5200b);
        return this.f5193a.j(str);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void commitFile(File file, long j) throws Cache.CacheException {
        boolean z = true;
        sb0.i(!this.f5200b);
        if (file.exists()) {
            if (j == 0) {
                file.delete();
                return;
            }
            kg8 kg8Var = (kg8) sb0.g(kg8.f(file, j, this.f5193a));
            ca1 ca1Var = (ca1) sb0.g(this.f5193a.g(kg8Var.f));
            sb0.i(ca1Var.h(((aa1) kg8Var).f40491a, kg8Var.b));
            long jA = ContentMetadata.a(ca1Var.d());
            if (jA != -1) {
                if (((aa1) kg8Var).f40491a + kg8Var.b > jA) {
                    z = false;
                }
                sb0.i(z);
            }
            if (this.f5194a == null) {
                k(kg8Var);
                this.f5193a.t();
                notifyAll();
                return;
            }
            try {
                this.f5194a.h(file.getName(), kg8Var.b, kg8Var.c);
                k(kg8Var);
                try {
                    this.f5193a.t();
                    notifyAll();
                    return;
                } catch (IOException e) {
                    throw new Cache.CacheException(e);
                }
            } catch (IOException e2) {
                throw new Cache.CacheException(e2);
            }
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void d(String str, Cache.Listener listener) {
        if (this.f5200b) {
            return;
        }
        ArrayList<Cache.Listener> arrayList = this.f5196a.get(str);
        if (arrayList != null) {
            arrayList.remove(listener);
            if (arrayList.isEmpty()) {
                this.f5196a.remove(str);
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void e(aa1 aa1Var) {
        sb0.i(!this.f5200b);
        ca1 ca1Var = (ca1) sb0.g(this.f5193a.g(aa1Var.f));
        ca1Var.m(aa1Var.f40491a);
        this.f5193a.q(ca1Var.f15772a);
        notifyAll();
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void f(String str, wu1 wu1Var) throws Cache.CacheException {
        sb0.i(!this.f5200b);
        l();
        this.f5193a.e(str, wu1Var);
        try {
            this.f5193a.t();
        } catch (IOException e) {
            throw new Cache.CacheException(e);
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized aa1 g(String str, long j, long j2) throws InterruptedException, Cache.CacheException {
        aa1 aa1VarA;
        sb0.i(!this.f5200b);
        l();
        while (true) {
            aa1VarA = a(str, j, j2);
            if (aa1VarA == null) {
                wait();
            }
        }
        return aa1VarA;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized long getCacheSpace() {
        sb0.i(!this.f5200b);
        return this.c;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized long getCachedBytes(String str, long j, long j2) {
        long j3;
        long j4 = j2 == -1 ? Long.MAX_VALUE : j + j2;
        long j5 = j4 < 0 ? Long.MAX_VALUE : j4;
        long j6 = j;
        j3 = 0;
        while (j6 < j5) {
            long cachedLength = getCachedLength(str, j6, j5 - j6);
            if (cachedLength > 0) {
                j3 += cachedLength;
            } else {
                cachedLength = -cachedLength;
            }
            j6 += cachedLength;
        }
        return j3;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized long getCachedLength(String str, long j, long j2) {
        ca1 ca1VarG;
        sb0.i(!this.f5200b);
        if (j2 == -1) {
            j2 = Long.MAX_VALUE;
        }
        ca1VarG = this.f5193a.g(str);
        return ca1VarG != null ? ca1VarG.c(j, j2) : -j2;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized NavigableSet<aa1> getCachedSpans(String str) {
        ca1 ca1VarG;
        sb0.i(!this.f5200b);
        ca1VarG = this.f5193a.g(str);
        return (ca1VarG == null || ca1VarG.g()) ? new TreeSet() : new TreeSet((Collection) ca1VarG.f());
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized Set<String> getKeys() {
        sb0.i(!this.f5200b);
        return new HashSet(this.f5193a.l());
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized long getUid() {
        return this.f5199b;
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void h(aa1 aa1Var) {
        sb0.i(!this.f5200b);
        y(aa1Var);
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized boolean isCached(String str, long j, long j2) {
        ca1 ca1VarG;
        sb0.i(!this.f5200b);
        ca1VarG = this.f5193a.g(str);
        return ca1VarG != null && ca1VarG.c(j, j2) >= j2;
    }

    public final void k(kg8 kg8Var) {
        this.f5193a.n(kg8Var.f).a(kg8Var);
        this.c += kg8Var.b;
        u(kg8Var);
    }

    public synchronized void l() throws Cache.CacheException {
        Cache.CacheException cacheException = this.f5191a;
        if (cacheException != null) {
            throw cacheException;
        }
    }

    public final kg8 o(String str, long j, long j2) {
        kg8 kg8VarE;
        ca1 ca1VarG = this.f5193a.g(str);
        if (ca1VarG == null) {
            return kg8.g(str, j, j2);
        }
        while (true) {
            kg8VarE = ca1VarG.e(j, j2);
            if (!((aa1) kg8VarE).f15219a || ((aa1) kg8VarE).f15218a.length() == kg8VarE.b) {
                break;
            }
            z();
        }
        return kg8VarE;
    }

    public final void p() {
        if (!this.f5195a.exists()) {
            try {
                m(this.f5195a);
            } catch (Cache.CacheException e) {
                this.f5191a = e;
                return;
            }
        }
        File[] fileArrListFiles = this.f5195a.listFiles();
        if (fileArrListFiles == null) {
            String str = "Failed to list cache directory files: " + this.f5195a;
            Log.d(f5189a, str);
            this.f5191a = new Cache.CacheException(str);
            return;
        }
        long jS = s(fileArrListFiles);
        this.f5199b = jS;
        if (jS == -1) {
            try {
                this.f5199b = n(this.f5195a);
            } catch (IOException e2) {
                String str2 = "Failed to create cache UID: " + this.f5195a;
                Log.e(f5189a, str2, e2);
                this.f5191a = new Cache.CacheException(str2, e2);
                return;
            }
        }
        try {
            this.f5193a.o(this.f5199b);
            u91 u91Var = this.f5194a;
            if (u91Var != null) {
                u91Var.e(this.f5199b);
                Map<String, t91> mapB = this.f5194a.b();
                r(this.f5195a, true, fileArrListFiles, mapB);
                this.f5194a.g(mapB.keySet());
            } else {
                r(this.f5195a, true, fileArrListFiles, null);
            }
            this.f5193a.s();
            try {
                this.f5193a.t();
            } catch (IOException e3) {
                Log.e(f5189a, "Storing index file failed", e3);
            }
        } catch (IOException e4) {
            String str3 = "Failed to initialize cache indices: " + this.f5195a;
            Log.e(f5189a, str3, e4);
            this.f5191a = new Cache.CacheException(str3, e4);
        }
    }

    public final void r(File file, boolean z, @Nullable File[] fileArr, @Nullable Map<String, t91> map) {
        long j;
        long j2;
        if (fileArr == null || fileArr.length == 0) {
            if (z) {
                return;
            }
            file.delete();
            return;
        }
        for (File file2 : fileArr) {
            String name = file2.getName();
            if (z && name.indexOf(46) == -1) {
                r(file2, false, file2.listFiles(), map);
            } else if (!z || (!CachedContentIndex.p(name) && !name.endsWith(b))) {
                t91 t91VarRemove = map != null ? map.remove(name) : null;
                if (t91VarRemove != null) {
                    j2 = t91VarRemove.f44874a;
                    j = t91VarRemove.b;
                } else {
                    j = -9223372036854775807L;
                    j2 = -1;
                }
                kg8 kg8VarE = kg8.e(file2, j2, j, this.f5193a);
                if (kg8VarE != null) {
                    k(kg8VarE);
                } else {
                    file2.delete();
                }
            }
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void release() {
        if (this.f5200b) {
            return;
        }
        this.f5196a.clear();
        z();
        try {
            try {
                this.f5193a.t();
                B(this.f5195a);
            } catch (IOException e) {
                Log.e(f5189a, "Storing index file failed", e);
                B(this.f5195a);
            }
            this.f5200b = true;
        } catch (Throwable th) {
            B(this.f5195a);
            this.f5200b = true;
            throw th;
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized void removeResource(String str) {
        sb0.i(!this.f5200b);
        Iterator<aa1> it = getCachedSpans(str).iterator();
        while (it.hasNext()) {
            y(it.next());
        }
    }

    @Override // com.google.android.exoplayer2.upstream.cache.Cache
    public synchronized File startFile(String str, long j, long j2) throws Cache.CacheException {
        ca1 ca1VarG;
        File file;
        sb0.i(!this.f5200b);
        l();
        ca1VarG = this.f5193a.g(str);
        sb0.g(ca1VarG);
        sb0.i(ca1VarG.h(j, j2));
        if (!this.f5195a.exists()) {
            m(this.f5195a);
            z();
        }
        this.f5192a.d(this, str, j, j2);
        file = new File(this.f5195a, Integer.toString(this.f5197a.nextInt(10)));
        if (!file.exists()) {
            m(file);
        }
        return kg8.i(file, ca1VarG.f40931a, j, System.currentTimeMillis());
    }

    public final void u(kg8 kg8Var) {
        ArrayList<Cache.Listener> arrayList = this.f5196a.get(kg8Var.f);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).a(this, kg8Var);
            }
        }
        this.f5192a.a(this, kg8Var);
    }

    public final void v(aa1 aa1Var) {
        ArrayList<Cache.Listener> arrayList = this.f5196a.get(aa1Var.f);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).b(this, aa1Var);
            }
        }
        this.f5192a.b(this, aa1Var);
    }

    public final void w(kg8 kg8Var, aa1 aa1Var) {
        ArrayList<Cache.Listener> arrayList = this.f5196a.get(kg8Var.f);
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                arrayList.get(size).c(this, kg8Var, aa1Var);
            }
        }
        this.f5192a.c(this, kg8Var, aa1Var);
    }

    public final void y(aa1 aa1Var) {
        ca1 ca1VarG = this.f5193a.g(aa1Var.f);
        if (ca1VarG == null || !ca1VarG.k(aa1Var)) {
            return;
        }
        this.c -= aa1Var.b;
        if (this.f5194a != null) {
            String name = aa1Var.f15218a.getName();
            try {
                this.f5194a.f(name);
            } catch (IOException unused) {
                Log.n(f5189a, "Failed to remove file index entry for: " + name);
            }
        }
        this.f5193a.q(ca1VarG.f15772a);
        v(aa1Var);
    }

    public final void z() {
        ArrayList arrayList = new ArrayList();
        Iterator<ca1> it = this.f5193a.h().iterator();
        while (it.hasNext()) {
            for (kg8 kg8Var : it.next().f()) {
                if (((aa1) kg8Var).f15218a.length() != kg8Var.b) {
                    arrayList.add(kg8Var);
                }
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            y((aa1) arrayList.get(i));
        }
    }

    @Deprecated
    public a(File file, CacheEvictor cacheEvictor, @Nullable byte[] bArr) {
        this(file, cacheEvictor, bArr, bArr != null);
    }

    @Deprecated
    public a(File file, CacheEvictor cacheEvictor, @Nullable byte[] bArr, boolean z) {
        this(file, cacheEvictor, null, bArr, z, true);
    }

    public a(File file, CacheEvictor cacheEvictor, DatabaseProvider databaseProvider) {
        this(file, cacheEvictor, databaseProvider, null, false, false);
    }

    public a(File file, CacheEvictor cacheEvictor, @Nullable DatabaseProvider databaseProvider, @Nullable byte[] bArr, boolean z, boolean z2) {
        this(file, cacheEvictor, new CachedContentIndex(databaseProvider, file, bArr, z, z2), (databaseProvider == null || z2) ? null : new u91(databaseProvider));
    }

    public a(File file, CacheEvictor cacheEvictor, CachedContentIndex cachedContentIndex, @Nullable u91 u91Var) {
        if (t(file)) {
            this.f5195a = file;
            this.f5192a = cacheEvictor;
            this.f5193a = cachedContentIndex;
            this.f5194a = u91Var;
            this.f5196a = new HashMap<>();
            this.f5197a = new Random();
            this.f5198a = cacheEvictor.requiresCacheSpanTouches();
            this.f5199b = -1L;
            ConditionVariable conditionVariable = new ConditionVariable();
            new C0702a("ExoPlayer:SimpleCacheInit", conditionVariable).start();
            conditionVariable.block();
            return;
        }
        throw new IllegalStateException("Another SimpleCache instance uses the folder: " + file);
    }
}
