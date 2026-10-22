package com.google.android.exoplayer2.upstream.cache;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.annotation.WorkerThread;
import com.google.android.exoplayer2.database.DatabaseIOException;
import com.google.android.exoplayer2.database.DatabaseProvider;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.UnmodifiableIterator;
import com.zj.adlib.ca1;
import com.zj.adlib.dh7;
import com.zj.adlib.ef2;
import com.zj.adlib.gj9;
import com.zj.adlib.ic0;
import com.zj.adlib.mm9;
import com.zj.adlib.sb0;
import com.zj.adlib.wu1;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class CachedContentIndex {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f31137a = 10485760;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f5169a = "cached_content_index.exi";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SparseArray<String> f5170a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final SparseBooleanArray f5171a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Storage f5172a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HashMap<String, ca1> f5173a;
    public final SparseBooleanArray b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public Storage f5174b;

    public interface Storage {
        void a(ca1 ca1Var);

        void b(ca1 ca1Var, boolean z);

        void delete() throws IOException;

        boolean exists() throws IOException;

        void initialize(long j);

        void load(HashMap<String, ca1> map, SparseArray<String> sparseArray) throws IOException;

        void storeFully(HashMap<String, ca1> map) throws IOException;

        void storeIncremental(HashMap<String, ca1> map) throws IOException;
    }

    public static final class a implements Storage {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f31138a = 1;
        public static final int b = 0;
        public static final int c = 1;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public static final String f5176c = "ExoPlayerCacheIndex";
        public static final int d = 2;

        /* JADX INFO: renamed from: d, reason: collision with other field name */
        public static final String f5177d = "id";
        public static final String f = "metadata";
        public static final String g = "id = ?";
        public static final String h = "(id INTEGER PRIMARY KEY NOT NULL,key TEXT NOT NULL,metadata BLOB NOT NULL)";

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final SparseArray<ca1> f5178a = new SparseArray<>();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final DatabaseProvider f5179a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f5180a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public String f5181b;
        public static final String e = "key";

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public static final String[] f5175a = {"id", e, "metadata"};

        public a(DatabaseProvider databaseProvider) {
            this.f5179a = databaseProvider;
        }

        public static void delete(DatabaseProvider databaseProvider, long j) throws DatabaseIOException {
            delete(databaseProvider, Long.toHexString(j));
        }

        public static void e(SQLiteDatabase sQLiteDatabase, String str) {
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + str);
        }

        public static String g(String str) {
            return f5176c + str;
        }

        @Override // com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage
        public void a(ca1 ca1Var) {
            this.f5178a.put(ca1Var.f40931a, ca1Var);
        }

        @Override // com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage
        public void b(ca1 ca1Var, boolean z) {
            if (z) {
                this.f5178a.delete(ca1Var.f40931a);
            } else {
                this.f5178a.put(ca1Var.f40931a, null);
            }
        }

        public final void c(SQLiteDatabase sQLiteDatabase, ca1 ca1Var) throws IOException {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            CachedContentIndex.u(ca1Var.d(), new DataOutputStream(byteArrayOutputStream));
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            ContentValues contentValues = new ContentValues();
            contentValues.put("id", Integer.valueOf(ca1Var.f40931a));
            contentValues.put(e, ca1Var.f15772a);
            contentValues.put("metadata", byteArray);
            sQLiteDatabase.replaceOrThrow((String) sb0.g(this.f5181b), null, contentValues);
        }

        public final void d(SQLiteDatabase sQLiteDatabase, int i) {
            sQLiteDatabase.delete((String) sb0.g(this.f5181b), "id = ?", new String[]{Integer.toString(i)});
        }

        @Override // com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage
        public boolean exists() throws DatabaseIOException {
            return mm9.b(this.f5179a.getReadableDatabase(), 1, (String) sb0.g(this.f5180a)) != -1;
        }

        public final Cursor f() {
            return this.f5179a.getReadableDatabase().query((String) sb0.g(this.f5181b), f5175a, null, null, null, null, null);
        }

        public final void h(SQLiteDatabase sQLiteDatabase) throws DatabaseIOException {
            mm9.d(sQLiteDatabase, 1, (String) sb0.g(this.f5180a), 1);
            e(sQLiteDatabase, (String) sb0.g(this.f5181b));
            sQLiteDatabase.execSQL("CREATE TABLE " + this.f5181b + " " + h);
        }

        @Override // com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage
        public void initialize(long j) {
            String hexString = Long.toHexString(j);
            this.f5180a = hexString;
            this.f5181b = g(hexString);
        }

        @Override // com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage
        public void load(HashMap<String, ca1> map, SparseArray<String> sparseArray) throws IOException {
            sb0.i(this.f5178a.size() == 0);
            try {
                if (mm9.b(this.f5179a.getReadableDatabase(), 1, (String) sb0.g(this.f5180a)) != 1) {
                    SQLiteDatabase writableDatabase = this.f5179a.getWritableDatabase();
                    writableDatabase.beginTransactionNonExclusive();
                    try {
                        h(writableDatabase);
                        writableDatabase.setTransactionSuccessful();
                        writableDatabase.endTransaction();
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                }
                Cursor cursorF = f();
                while (cursorF.moveToNext()) {
                    try {
                        ca1 ca1Var = new ca1(cursorF.getInt(0), (String) sb0.g(cursorF.getString(1)), CachedContentIndex.r(new DataInputStream(new ByteArrayInputStream(cursorF.getBlob(2)))));
                        map.put(ca1Var.f15772a, ca1Var);
                        sparseArray.put(ca1Var.f40931a, ca1Var.f15772a);
                    } catch (Throwable th2) {
                        if (cursorF != null) {
                            try {
                                cursorF.close();
                            } catch (Throwable th3) {
                                th2.addSuppressed(th3);
                            }
                        }
                        throw th2;
                    }
                }
                cursorF.close();
            } catch (SQLiteException e2) {
                map.clear();
                sparseArray.clear();
                throw new DatabaseIOException(e2);
            }
        }

        @Override // com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage
        public void storeFully(HashMap<String, ca1> map) throws IOException {
            try {
                SQLiteDatabase writableDatabase = this.f5179a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    h(writableDatabase);
                    Iterator<ca1> it = map.values().iterator();
                    while (it.hasNext()) {
                        c(writableDatabase, it.next());
                    }
                    writableDatabase.setTransactionSuccessful();
                    this.f5178a.clear();
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e2) {
                throw new DatabaseIOException(e2);
            }
        }

        @Override // com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage
        public void storeIncremental(HashMap<String, ca1> map) throws IOException {
            if (this.f5178a.size() == 0) {
                return;
            }
            try {
                SQLiteDatabase writableDatabase = this.f5179a.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                for (int i = 0; i < this.f5178a.size(); i++) {
                    try {
                        ca1 ca1VarValueAt = this.f5178a.valueAt(i);
                        if (ca1VarValueAt == null) {
                            d(writableDatabase, this.f5178a.keyAt(i));
                        } else {
                            c(writableDatabase, ca1VarValueAt);
                        }
                    } catch (Throwable th) {
                        writableDatabase.endTransaction();
                        throw th;
                    }
                }
                writableDatabase.setTransactionSuccessful();
                this.f5178a.clear();
                writableDatabase.endTransaction();
            } catch (SQLException e2) {
                throw new DatabaseIOException(e2);
            }
        }

        @Override // com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage
        public void delete() throws DatabaseIOException {
            delete(this.f5179a, (String) sb0.g(this.f5180a));
        }

        private static void delete(DatabaseProvider databaseProvider, String str) throws DatabaseIOException {
            try {
                String strG = g(str);
                SQLiteDatabase writableDatabase = databaseProvider.getWritableDatabase();
                writableDatabase.beginTransactionNonExclusive();
                try {
                    mm9.c(writableDatabase, 1, str);
                    e(writableDatabase, strG);
                    writableDatabase.setTransactionSuccessful();
                } finally {
                    writableDatabase.endTransaction();
                }
            } catch (SQLException e2) {
                throw new DatabaseIOException(e2);
            }
        }
    }

    public static class b implements Storage {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f31139a = 2;
        public static final int b = 2;
        public static final int c = 1;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public dh7 f5182a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ic0 f5183a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final SecureRandom f5184a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final Cipher f5185a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final SecretKeySpec f5186a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f5187a;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f5188b;

        public b(File file, @Nullable byte[] bArr, boolean z) {
            Cipher cipherI;
            SecretKeySpec secretKeySpec;
            sb0.i((bArr == null && z) ? false : true);
            if (bArr != null) {
                sb0.a(bArr.length == 16);
                try {
                    cipherI = CachedContentIndex.i();
                    secretKeySpec = new SecretKeySpec(bArr, "AES");
                } catch (NoSuchAlgorithmException | NoSuchPaddingException e) {
                    throw new IllegalStateException(e);
                }
            } else {
                sb0.a(!z);
                cipherI = null;
                secretKeySpec = null;
            }
            this.f5187a = z;
            this.f5185a = cipherI;
            this.f5186a = secretKeySpec;
            this.f5184a = z ? new SecureRandom() : null;
            this.f5183a = new ic0(file);
        }

        @Override // com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage
        public void a(ca1 ca1Var) {
            this.f5188b = true;
        }

        @Override // com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage
        public void b(ca1 ca1Var, boolean z) {
            this.f5188b = true;
        }

        public final int c(ca1 ca1Var, int i) {
            int i2;
            int iHashCode;
            int iHashCode2 = (ca1Var.f40931a * 31) + ca1Var.f15772a.hashCode();
            if (i < 2) {
                long jA = ContentMetadata.a(ca1Var.d());
                i2 = iHashCode2 * 31;
                iHashCode = (int) (jA ^ (jA >>> 32));
            } else {
                i2 = iHashCode2 * 31;
                iHashCode = ca1Var.d().hashCode();
            }
            return i2 + iHashCode;
        }

        public final ca1 d(int i, DataInputStream dataInputStream) throws IOException {
            ef2 ef2VarR;
            int i2 = dataInputStream.readInt();
            String utf = dataInputStream.readUTF();
            if (i < 2) {
                long j = dataInputStream.readLong();
                wu1 wu1Var = new wu1();
                wu1.h(wu1Var, j);
                ef2VarR = ef2.f41422a.e(wu1Var);
            } else {
                ef2VarR = CachedContentIndex.r(dataInputStream);
            }
            return new ca1(i2, utf, ef2VarR);
        }

        @Override // com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage
        public void delete() {
            this.f5183a.delete();
        }

        public final boolean e(HashMap<String, ca1> map, SparseArray<String> sparseArray) throws Throwable {
            if (!this.f5183a.b()) {
                return true;
            }
            DataInputStream dataInputStream = null;
            try {
                BufferedInputStream bufferedInputStream = new BufferedInputStream(this.f5183a.c());
                DataInputStream dataInputStream2 = new DataInputStream(bufferedInputStream);
                try {
                    int i = dataInputStream2.readInt();
                    if (i >= 0 && i <= 2) {
                        if ((dataInputStream2.readInt() & 1) != 0) {
                            if (this.f5185a == null) {
                                gj9.p(dataInputStream2);
                                return false;
                            }
                            byte[] bArr = new byte[16];
                            dataInputStream2.readFully(bArr);
                            try {
                                this.f5185a.init(2, (Key) gj9.k(this.f5186a), new IvParameterSpec(bArr));
                                dataInputStream2 = new DataInputStream(new CipherInputStream(bufferedInputStream, this.f5185a));
                            } catch (InvalidAlgorithmParameterException e) {
                                e = e;
                                throw new IllegalStateException(e);
                            } catch (InvalidKeyException e2) {
                                e = e2;
                                throw new IllegalStateException(e);
                            }
                        } else if (this.f5187a) {
                            this.f5188b = true;
                        }
                        int i2 = dataInputStream2.readInt();
                        int iC = 0;
                        for (int i3 = 0; i3 < i2; i3++) {
                            ca1 ca1VarD = d(i, dataInputStream2);
                            map.put(ca1VarD.f15772a, ca1VarD);
                            sparseArray.put(ca1VarD.f40931a, ca1VarD.f15772a);
                            iC += c(ca1VarD, i);
                        }
                        int i4 = dataInputStream2.readInt();
                        boolean z = dataInputStream2.read() == -1;
                        if (i4 == iC && z) {
                            gj9.p(dataInputStream2);
                            return true;
                        }
                        gj9.p(dataInputStream2);
                        return false;
                    }
                    gj9.p(dataInputStream2);
                    return false;
                } catch (IOException unused) {
                    dataInputStream = dataInputStream2;
                    if (dataInputStream != null) {
                        gj9.p(dataInputStream);
                    }
                    return false;
                } catch (Throwable th) {
                    th = th;
                    dataInputStream = dataInputStream2;
                    if (dataInputStream != null) {
                        gj9.p(dataInputStream);
                    }
                    throw th;
                }
            } catch (IOException unused2) {
            } catch (Throwable th2) {
                th = th2;
            }
        }

        @Override // com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage
        public boolean exists() {
            return this.f5183a.b();
        }

        public final void f(ca1 ca1Var, DataOutputStream dataOutputStream) throws IOException {
            dataOutputStream.writeInt(ca1Var.f40931a);
            dataOutputStream.writeUTF(ca1Var.f15772a);
            CachedContentIndex.u(ca1Var.d(), dataOutputStream);
        }

        public final void g(HashMap<String, ca1> map) throws Throwable {
            DataOutputStream dataOutputStream = null;
            try {
                OutputStream outputStreamE = this.f5183a.e();
                dh7 dh7Var = this.f5182a;
                if (dh7Var == null) {
                    this.f5182a = new dh7(outputStreamE);
                } else {
                    dh7Var.a(outputStreamE);
                }
                dh7 dh7Var2 = this.f5182a;
                DataOutputStream dataOutputStream2 = new DataOutputStream(dh7Var2);
                try {
                    dataOutputStream2.writeInt(2);
                    int iC = 0;
                    dataOutputStream2.writeInt(this.f5187a ? 1 : 0);
                    if (this.f5187a) {
                        byte[] bArr = new byte[16];
                        ((SecureRandom) gj9.k(this.f5184a)).nextBytes(bArr);
                        dataOutputStream2.write(bArr);
                        try {
                            ((Cipher) gj9.k(this.f5185a)).init(1, (Key) gj9.k(this.f5186a), new IvParameterSpec(bArr));
                            dataOutputStream2.flush();
                            dataOutputStream2 = new DataOutputStream(new CipherOutputStream(dh7Var2, this.f5185a));
                        } catch (InvalidAlgorithmParameterException e) {
                            e = e;
                            throw new IllegalStateException(e);
                        } catch (InvalidKeyException e2) {
                            e = e2;
                            throw new IllegalStateException(e);
                        }
                    }
                    dataOutputStream2.writeInt(map.size());
                    for (ca1 ca1Var : map.values()) {
                        f(ca1Var, dataOutputStream2);
                        iC += c(ca1Var, 2);
                    }
                    dataOutputStream2.writeInt(iC);
                    this.f5183a.a(dataOutputStream2);
                    gj9.p(null);
                } catch (Throwable th) {
                    th = th;
                    dataOutputStream = dataOutputStream2;
                    gj9.p(dataOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }

        @Override // com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage
        public void initialize(long j) {
        }

        @Override // com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage
        public void load(HashMap<String, ca1> map, SparseArray<String> sparseArray) {
            sb0.i(!this.f5188b);
            if (e(map, sparseArray)) {
                return;
            }
            map.clear();
            sparseArray.clear();
            this.f5183a.delete();
        }

        @Override // com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage
        public void storeFully(HashMap<String, ca1> map) throws Throwable {
            g(map);
            this.f5188b = false;
        }

        @Override // com.google.android.exoplayer2.upstream.cache.CachedContentIndex.Storage
        public void storeIncremental(HashMap<String, ca1> map) throws Throwable {
            if (this.f5188b) {
                storeFully(map);
            }
        }
    }

    public CachedContentIndex(DatabaseProvider databaseProvider) {
        this(databaseProvider, null, null, false, false);
    }

    @WorkerThread
    public static void delete(DatabaseProvider databaseProvider, long j) throws DatabaseIOException {
        a.delete(databaseProvider, j);
    }

    @SuppressLint({"GetInstance"})
    public static Cipher i() throws NoSuchPaddingException, NoSuchAlgorithmException {
        if (gj9.f41922a == 18) {
            try {
                return Cipher.getInstance("AES/CBC/PKCS5PADDING", "BC");
            } catch (Throwable unused) {
            }
        }
        return Cipher.getInstance("AES/CBC/PKCS5PADDING");
    }

    @VisibleForTesting
    public static int m(SparseArray<String> sparseArray) {
        int size = sparseArray.size();
        int i = 0;
        int iKeyAt = size == 0 ? 0 : sparseArray.keyAt(size - 1) + 1;
        if (iKeyAt >= 0) {
            return iKeyAt;
        }
        while (i < size && i == sparseArray.keyAt(i)) {
            i++;
        }
        return i;
    }

    public static boolean p(String str) {
        return str.startsWith(f5169a);
    }

    public static ef2 r(DataInputStream dataInputStream) throws IOException {
        int i = dataInputStream.readInt();
        HashMap map = new HashMap();
        for (int i2 = 0; i2 < i; i2++) {
            String utf = dataInputStream.readUTF();
            int i3 = dataInputStream.readInt();
            if (i3 < 0) {
                throw new IOException("Invalid value size: " + i3);
            }
            int iMin = Math.min(i3, f31137a);
            byte[] bArrCopyOf = gj9.f16790a;
            int i4 = 0;
            while (i4 != i3) {
                int i5 = i4 + iMin;
                bArrCopyOf = Arrays.copyOf(bArrCopyOf, i5);
                dataInputStream.readFully(bArrCopyOf, i4, iMin);
                iMin = Math.min(i3 - i5, f31137a);
                i4 = i5;
            }
            map.put(utf, bArrCopyOf);
        }
        return new ef2(map);
    }

    public static void u(ef2 ef2Var, DataOutputStream dataOutputStream) throws IOException {
        Set<Map.Entry<String, byte[]>> setF = ef2Var.f();
        dataOutputStream.writeInt(setF.size());
        for (Map.Entry<String, byte[]> entry : setF) {
            dataOutputStream.writeUTF(entry.getKey());
            byte[] value = entry.getValue();
            dataOutputStream.writeInt(value.length);
            dataOutputStream.write(value);
        }
    }

    public final ca1 d(String str) {
        int iM = m(this.f5170a);
        ca1 ca1Var = new ca1(iM, str);
        this.f5173a.put(str, ca1Var);
        this.f5170a.put(iM, str);
        this.b.put(iM, true);
        this.f5172a.a(ca1Var);
        return ca1Var;
    }

    public void e(String str, wu1 wu1Var) {
        ca1 ca1VarN = n(str);
        if (ca1VarN.b(wu1Var)) {
            this.f5172a.a(ca1VarN);
        }
    }

    public int f(String str) {
        return n(str).f40931a;
    }

    @Nullable
    public ca1 g(String str) {
        return this.f5173a.get(str);
    }

    public Collection<ca1> h() {
        return Collections.unmodifiableCollection(this.f5173a.values());
    }

    public ContentMetadata j(String str) {
        ca1 ca1VarG = g(str);
        return ca1VarG != null ? ca1VarG.d() : ef2.f41422a;
    }

    @Nullable
    public String k(int i) {
        return this.f5170a.get(i);
    }

    public Set<String> l() {
        return this.f5173a.keySet();
    }

    public ca1 n(String str) {
        ca1 ca1Var = this.f5173a.get(str);
        return ca1Var == null ? d(str) : ca1Var;
    }

    @WorkerThread
    public void o(long j) throws IOException {
        Storage storage;
        this.f5172a.initialize(j);
        Storage storage2 = this.f5174b;
        if (storage2 != null) {
            storage2.initialize(j);
        }
        if (this.f5172a.exists() || (storage = this.f5174b) == null || !storage.exists()) {
            this.f5172a.load(this.f5173a, this.f5170a);
        } else {
            this.f5174b.load(this.f5173a, this.f5170a);
            this.f5172a.storeFully(this.f5173a);
        }
        Storage storage3 = this.f5174b;
        if (storage3 != null) {
            storage3.delete();
            this.f5174b = null;
        }
    }

    public void q(String str) {
        ca1 ca1Var = this.f5173a.get(str);
        if (ca1Var != null && ca1Var.g() && ca1Var.i()) {
            this.f5173a.remove(str);
            int i = ca1Var.f40931a;
            boolean z = this.b.get(i);
            this.f5172a.b(ca1Var, z);
            if (z) {
                this.f5170a.remove(i);
                this.b.delete(i);
            } else {
                this.f5170a.put(i, null);
                this.f5171a.put(i, true);
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void s() {
        UnmodifiableIterator it = ImmutableSet.copyOf((Collection) this.f5173a.keySet()).iterator();
        while (it.hasNext()) {
            q((String) it.next());
        }
    }

    @WorkerThread
    public void t() throws IOException {
        this.f5172a.storeIncremental(this.f5173a);
        int size = this.f5171a.size();
        for (int i = 0; i < size; i++) {
            this.f5170a.remove(this.f5171a.keyAt(i));
        }
        this.f5171a.clear();
        this.b.clear();
    }

    public CachedContentIndex(@Nullable DatabaseProvider databaseProvider, @Nullable File file, @Nullable byte[] bArr, boolean z, boolean z2) {
        sb0.i((databaseProvider == null && file == null) ? false : true);
        this.f5173a = new HashMap<>();
        this.f5170a = new SparseArray<>();
        this.f5171a = new SparseBooleanArray();
        this.b = new SparseBooleanArray();
        a aVar = databaseProvider != null ? new a(databaseProvider) : null;
        b bVar = file != null ? new b(new File(file, f5169a), bArr, z) : null;
        if (aVar == null || (bVar != null && z2)) {
            this.f5172a = (Storage) gj9.k(bVar);
            this.f5174b = aVar;
        } else {
            this.f5172a = aVar;
            this.f5174b = bVar;
        }
    }
}
