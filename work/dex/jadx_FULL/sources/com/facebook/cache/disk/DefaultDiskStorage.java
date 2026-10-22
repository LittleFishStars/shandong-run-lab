package com.facebook.cache.disk;

import com.alibaba.android.arouter.utils.Consts;
import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.WriterCallback;
import com.facebook.common.file.FileTreeVisitor;
import com.facebook.common.file.FileUtils;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.time.Clock;
import com.fl.saas.common.util.FileTypeUtils;
import com.zj.adlib.ax6;
import com.zj.adlib.fg3;
import com.zj.adlib.hw1;
import com.zj.adlib.uf3;
import com.zj.adlib.uy8;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class DefaultDiskStorage implements DiskStorage {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f29937a = 100;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f1524a = ".cnt";
    public static final String b = ".tmp";
    public static final String c = "v2";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CacheErrorLogger f1525a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Clock f1526a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final File f1527a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final File f1528b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Class<?> f1523a = DefaultDiskStorage.class;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final long f1522a = TimeUnit.MINUTES.toMillis(30);

    public enum FileType {
        CONTENT(DefaultDiskStorage.f1524a),
        TEMP(".tmp");

        public final String extension;

        FileType(String str) {
            this.extension = str;
        }

        public static FileType fromExtension(String str) {
            if (DefaultDiskStorage.f1524a.equals(str)) {
                return CONTENT;
            }
            if (".tmp".equals(str)) {
                return TEMP;
            }
            return null;
        }
    }

    public static class IncompleteFileException extends IOException {
        public final long actual;
        public final long expected;

        public IncompleteFileException(long j, long j2) {
            super("File was not written completely. Expected: " + j + ", found: " + j2);
            this.expected = j;
            this.actual = j2;
        }
    }

    public class b implements FileTreeVisitor {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final List<DiskStorage.Entry> f1529a;

        public b() {
            this.f1529a = new ArrayList();
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void a(File file) {
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void b(File file) {
            d dVarT = DefaultDiskStorage.this.t(file);
            if (dVarT == null || dVarT.f29940a != FileType.CONTENT) {
                return;
            }
            this.f1529a.add(new c(dVarT.f1532a, file));
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void c(File file) {
        }

        public List<DiskStorage.Entry> d() {
            return Collections.unmodifiableList(this.f1529a);
        }
    }

    @VisibleForTesting
    public static class c implements DiskStorage.Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f29939a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final uf3 f1530a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f1531a;
        public long b;

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public uf3 a() {
            return this.f1530a;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public String getId() {
            return this.f1531a;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public long getSize() {
            if (this.f29939a < 0) {
                this.f29939a = this.f1530a.size();
            }
            return this.f29939a;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Entry
        public long getTimestamp() {
            if (this.b < 0) {
                this.b = this.f1530a.d().lastModified();
            }
            return this.b;
        }

        public c(String str, File file) {
            ax6.i(file);
            this.f1531a = (String) ax6.i(str);
            this.f1530a = uf3.c(file);
            this.f29939a = -1L;
            this.b = -1L;
        }
    }

    public static class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final FileType f29940a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f1532a;

        @Nullable
        public static d b(File file) {
            FileType fileTypeFromExtension;
            String name = file.getName();
            int iLastIndexOf = name.lastIndexOf(46);
            if (iLastIndexOf <= 0 || (fileTypeFromExtension = FileType.fromExtension(name.substring(iLastIndexOf))) == null) {
                return null;
            }
            String strSubstring = name.substring(0, iLastIndexOf);
            if (fileTypeFromExtension.equals(FileType.TEMP)) {
                int iLastIndexOf2 = strSubstring.lastIndexOf(46);
                if (iLastIndexOf2 <= 0) {
                    return null;
                }
                strSubstring = strSubstring.substring(0, iLastIndexOf2);
            }
            return new d(fileTypeFromExtension, strSubstring);
        }

        public File a(File file) throws IOException {
            return File.createTempFile(this.f1532a + Consts.DOT, ".tmp", file);
        }

        public String c(String str) {
            return str + File.separator + this.f1532a + this.f29940a.extension;
        }

        public String toString() {
            return this.f29940a + "(" + this.f1532a + ")";
        }

        public d(FileType fileType, String str) {
            this.f29940a = fileType;
            this.f1532a = str;
        }
    }

    @VisibleForTesting
    public class e implements DiskStorage.Inserter {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @VisibleForTesting
        public final File f1533a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f1534a;

        public e(String str, File file) {
            this.f1534a = str;
            this.f1533a = file;
        }

        @Override // com.facebook.cache.disk.DiskStorage.Inserter
        public BinaryResource a(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File fileQ = DefaultDiskStorage.this.q(this.f1534a);
            try {
                FileUtils.b(this.f1533a, fileQ);
                if (fileQ.exists()) {
                    fileQ.setLastModified(DefaultDiskStorage.this.f1526a.now());
                }
                return uf3.c(fileQ);
            } catch (FileUtils.RenameException e) {
                Throwable cause = e.getCause();
                if (cause == null) {
                    cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_OTHER;
                } else if (cause instanceof FileUtils.ParentDirNotFoundException) {
                    cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND;
                } else {
                    cacheErrorCategory = cause instanceof FileNotFoundException ? CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND : CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_OTHER;
                }
                DefaultDiskStorage.this.f1525a.a(cacheErrorCategory, DefaultDiskStorage.f1523a, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.DiskStorage.Inserter
        public void b(WriterCallback writerCallback, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.f1533a);
                try {
                    hw1 hw1Var = new hw1(fileOutputStream);
                    writerCallback.b(hw1Var);
                    hw1Var.flush();
                    long jG = hw1Var.g();
                    fileOutputStream.close();
                    if (this.f1533a.length() != jG) {
                        throw new IncompleteFileException(jG, this.f1533a.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.f1525a.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.f1523a, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.DiskStorage.Inserter
        public boolean c() {
            return !this.f1533a.exists() || this.f1533a.delete();
        }
    }

    public class f implements FileTreeVisitor {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f1535a;

        public f() {
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void a(File file) {
            if (!DefaultDiskStorage.this.f1527a.equals(file) && !this.f1535a) {
                file.delete();
            }
            if (this.f1535a && file.equals(DefaultDiskStorage.this.f1528b)) {
                this.f1535a = false;
            }
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void b(File file) {
            if (this.f1535a && d(file)) {
                return;
            }
            file.delete();
        }

        @Override // com.facebook.common.file.FileTreeVisitor
        public void c(File file) {
            if (this.f1535a || !file.equals(DefaultDiskStorage.this.f1528b)) {
                return;
            }
            this.f1535a = true;
        }

        public final boolean d(File file) {
            d dVarT = DefaultDiskStorage.this.t(file);
            if (dVarT == null) {
                return false;
            }
            FileType fileType = dVarT.f29940a;
            if (fileType == FileType.TEMP) {
                return e(file);
            }
            ax6.o(fileType == FileType.CONTENT);
            return true;
        }

        public final boolean e(File file) {
            return file.lastModified() > DefaultDiskStorage.this.f1526a.now() - DefaultDiskStorage.f1522a;
        }
    }

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        ax6.i(file);
        this.f1527a = file;
        this.f1528b = new File(file, w(i));
        this.f1525a = cacheErrorLogger;
        y();
        this.f1526a = uy8.a();
    }

    private boolean query(String str, boolean z) {
        File fileQ = q(str);
        boolean zExists = fileQ.exists();
        if (z && zExists) {
            fileQ.setLastModified(this.f1526a.now());
        }
        return zExists;
    }

    @VisibleForTesting
    public static String w(int i) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public DiskStorage.a a() throws IOException {
        List<DiskStorage.Entry> listE = e();
        DiskStorage.a aVar = new DiskStorage.a();
        Iterator<DiskStorage.Entry> it = listE.iterator();
        while (it.hasNext()) {
            DiskStorage.b bVarP = p(it.next());
            String str = bVarP.b;
            if (!aVar.f1536a.containsKey(str)) {
                aVar.f1536a.put(str, 0);
            }
            Map<String, Integer> map = aVar.f1536a;
            map.put(str, Integer.valueOf(map.get(str).intValue() + 1));
            aVar.f29943a.add(bVarP);
        }
        return aVar;
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public BinaryResource b(String str, Object obj) {
        File fileQ = q(str);
        if (!fileQ.exists()) {
            return null;
        }
        fileQ.setLastModified(this.f1526a.now());
        return uf3.c(fileQ);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean c(String str, Object obj) {
        return query(str, true);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public void clearAll() {
        fg3.a(this.f1527a);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public long d(String str) {
        return o(q(str));
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public void f() {
        fg3.c(this.f1527a, new f());
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean g(String str, Object obj) {
        return query(str, false);
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public long h(DiskStorage.Entry entry) {
        return o(((c) entry).a().d());
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public DiskStorage.Inserter insert(String str, Object obj) throws IOException {
        d dVar = new d(FileType.TEMP, str);
        File fileU = u(dVar.f1532a);
        if (!fileU.exists()) {
            x(fileU, "insert");
        }
        try {
            return new e(str, dVar.a(fileU));
        } catch (IOException e2) {
            this.f1525a.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, f1523a, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.DiskStorage
    public boolean isEnabled() {
        return true;
    }

    public final long o(File file) {
        if (!file.exists()) {
            return 0L;
        }
        long length = file.length();
        if (file.delete()) {
            return length;
        }
        return -1L;
    }

    public final DiskStorage.b p(DiskStorage.Entry entry) throws IOException {
        c cVar = (c) entry;
        byte[] bArrA = cVar.a().a();
        String strZ = z(bArrA);
        return new DiskStorage.b(cVar.a().d().getPath(), strZ, cVar.getSize(), (!strZ.equals("undefined") || bArrA.length < 4) ? "" : String.format(null, "0x%02X 0x%02X 0x%02X 0x%02X", Byte.valueOf(bArrA[0]), Byte.valueOf(bArrA[1]), Byte.valueOf(bArrA[2]), Byte.valueOf(bArrA[3])));
    }

    @VisibleForTesting
    public File q(String str) {
        return new File(s(str));
    }

    @Override // com.facebook.cache.disk.DiskStorage
    /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
    public List<DiskStorage.Entry> e() throws IOException {
        b bVar = new b();
        fg3.c(this.f1528b, bVar);
        return bVar.d();
    }

    public final String s(String str) {
        d dVar = new d(FileType.CONTENT, str);
        return dVar.c(v(dVar.f1532a));
    }

    public final d t(File file) {
        d dVarB = d.b(file);
        if (dVarB != null && u(dVarB.f1532a).equals(file.getParentFile())) {
            return dVarB;
        }
        return null;
    }

    public final File u(String str) {
        return new File(v(str));
    }

    public final String v(String str) {
        return this.f1528b + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    public final void x(File file, String str) throws IOException {
        try {
            FileUtils.a(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.f1525a.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, f1523a, str, e2);
            throw e2;
        }
    }

    public final void y() {
        boolean z = true;
        if (this.f1527a.exists()) {
            if (this.f1528b.exists()) {
                z = false;
            } else {
                fg3.b(this.f1527a);
            }
        }
        if (z) {
            try {
                FileUtils.a(this.f1528b);
            } catch (FileUtils.CreateDirectoryException unused) {
                this.f1525a.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, f1523a, "version directory could not be created: " + this.f1528b, null);
            }
        }
    }

    public final String z(byte[] bArr) {
        if (bArr.length < 2) {
            return "undefined";
        }
        byte b2 = bArr[0];
        if (b2 == -1 && bArr[1] == -40) {
            return "jpg";
        }
        if (b2 == -119 && bArr[1] == 80) {
            return "png";
        }
        if (b2 == 82 && bArr[1] == 73) {
            return "webp";
        }
        return (b2 == 71 && bArr[1] == 73) ? FileTypeUtils.FILE_TYPE_GIF : "undefined";
    }
}
