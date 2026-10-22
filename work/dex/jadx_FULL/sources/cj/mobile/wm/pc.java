package cj.mobile.wm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class pc {
    public static final Object dexd = new Object();
    public File dexb;
    public final Object dexa = new Object();
    public HashMap<File, dexa> dexc = new HashMap<>();

    public static final class dexa implements nc {
        public static final Object dexg = new Object();
        public final File dexa;
        public final File dexb;
        public final int dexc;
        public Map dexd;
        public boolean dexe = false;
        public WeakHashMap<nc.dexb, Object> dexf;

        /* JADX INFO: renamed from: cj.mobile.wm.pc$dexa$dexa, reason: collision with other inner class name */
        public final class C0084dexa implements nc.dexa {
            public final Map<String, Object> dexa = new HashMap();
            public boolean dexb = false;

            public C0084dexa() {
            }

            @Override // cj.mobile.wm.nc.dexa
            public nc.dexa a(String str) {
                synchronized (this) {
                    this.dexa.put(str, this);
                }
                return this;
            }

            @Override // cj.mobile.wm.nc.dexa
            public nc.dexa a(String str, String str2) {
                synchronized (this) {
                    this.dexa.put(str, str2);
                }
                return this;
            }

            @Override // cj.mobile.wm.nc.dexa
            public boolean a() {
                boolean z;
                ArrayList arrayList;
                HashSet<nc.dexb> hashSet;
                boolean zDexb;
                synchronized (pc.dexd) {
                    z = dexa.this.dexf.size() > 0;
                    if (z) {
                        arrayList = new ArrayList();
                        hashSet = new HashSet(dexa.this.dexf.keySet());
                    } else {
                        arrayList = null;
                        hashSet = null;
                    }
                    synchronized (this) {
                        if (this.dexb) {
                            dexa.this.dexd.clear();
                            this.dexb = false;
                        }
                        for (Map.Entry<String, Object> entry : this.dexa.entrySet()) {
                            String key = entry.getKey();
                            Object value = entry.getValue();
                            if (value == this) {
                                dexa.this.dexd.remove(key);
                            } else {
                                dexa.this.dexd.put(key, value);
                            }
                            if (z) {
                                arrayList.add(key);
                            }
                        }
                        this.dexa.clear();
                    }
                    zDexb = dexa.this.dexb();
                    if (zDexb) {
                        dexa.this.dexa(true);
                    }
                }
                if (z) {
                    for (int size = arrayList.size() - 1; size >= 0; size--) {
                        String str = (String) arrayList.get(size);
                        for (nc.dexb dexbVar : hashSet) {
                            if (dexbVar != null) {
                                dexbVar.dexa(dexa.this, str);
                            }
                        }
                    }
                }
                return zDexb;
            }

            @Override // cj.mobile.wm.nc.dexa
            public nc.dexa clear() {
                synchronized (this) {
                    this.dexb = true;
                }
                return this;
            }

            @Override // cj.mobile.wm.nc.dexa
            public nc.dexa dexa(String str, float f) {
                synchronized (this) {
                    this.dexa.put(str, Float.valueOf(f));
                }
                return this;
            }

            @Override // cj.mobile.wm.nc.dexa
            public nc.dexa dexa(String str, int i) {
                synchronized (this) {
                    this.dexa.put(str, Integer.valueOf(i));
                }
                return this;
            }

            @Override // cj.mobile.wm.nc.dexa
            public nc.dexa dexa(String str, long j) {
                synchronized (this) {
                    this.dexa.put(str, Long.valueOf(j));
                }
                return this;
            }

            @Override // cj.mobile.wm.nc.dexa
            public nc.dexa dexa(String str, boolean z) {
                synchronized (this) {
                    this.dexa.put(str, Boolean.valueOf(z));
                }
                return this;
            }
        }

        public dexa(File file, int i, Map map) {
            this.dexa = file;
            this.dexb = pc.dexb(file);
            this.dexc = i;
            this.dexd = map == null ? new HashMap() : map;
            this.dexf = new WeakHashMap<>();
        }

        private FileOutputStream dexa(File file) {
            try {
                return new FileOutputStream(file);
            } catch (FileNotFoundException unused) {
                if (!file.getParentFile().mkdir()) {
                    return null;
                }
                try {
                    return new FileOutputStream(file);
                } catch (FileNotFoundException unused2) {
                    return null;
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean dexb() {
            if (this.dexa.exists()) {
                if (this.dexb.exists()) {
                    this.dexa.delete();
                } else if (!this.dexa.renameTo(this.dexb)) {
                    return false;
                }
            }
            try {
                FileOutputStream fileOutputStreamDexa = dexa(this.dexa);
                if (fileOutputStreamDexa == null) {
                    return false;
                }
                qc.dexa(this.dexd, fileOutputStreamDexa);
                fileOutputStreamDexa.close();
                this.dexb.delete();
                return true;
            } catch (IOException | XmlPullParserException unused) {
                if (this.dexa.exists()) {
                    this.dexa.delete();
                }
                return false;
            }
        }

        @Override // cj.mobile.wm.nc
        public String a(String str, String str2) {
            synchronized (this) {
                String str3 = (String) this.dexd.get(str);
                if (str3 != null) {
                    str2 = str3;
                }
            }
            return str2;
        }

        @Override // cj.mobile.wm.nc
        public boolean a() {
            File file = this.dexa;
            return file != null && new File(file.getAbsolutePath()).exists();
        }

        @Override // cj.mobile.wm.nc
        public nc.dexa b() {
            return new C0084dexa();
        }

        @Override // cj.mobile.wm.nc
        public Map<String, ?> c() {
            HashMap map;
            synchronized (this) {
                map = new HashMap(this.dexd);
            }
            return map;
        }

        @Override // cj.mobile.wm.nc
        public long dexa(String str, long j) {
            synchronized (this) {
                Long l = (Long) this.dexd.get(str);
                if (l != null) {
                    j = l.longValue();
                }
            }
            return j;
        }

        public void dexa(Map map) {
            if (map != null) {
                synchronized (this) {
                    this.dexd = map;
                }
            }
        }

        public void dexa(boolean z) {
            synchronized (this) {
                this.dexe = z;
            }
        }

        public boolean dexa() {
            boolean z;
            synchronized (this) {
                z = this.dexe;
            }
            return z;
        }
    }

    public pc(String str) {
        if (str == null || str.length() <= 0) {
            throw new RuntimeException("Directory can not be empty");
        }
        this.dexb = new File(str);
    }

    private File dexa(File file, String str) {
        if (str.indexOf(File.separatorChar) < 0) {
            return new File(file, str);
        }
        throw new IllegalArgumentException("File " + str + " contains a path separator");
    }

    private File dexa(String str) {
        return dexa(dexb(), str + ".xml");
    }

    private File dexb() {
        File file;
        synchronized (this.dexa) {
            file = this.dexb;
        }
        return file;
    }

    public static File dexb(File file) {
        return new File(file.getPath() + ".bak");
    }

    /* JADX WARN: Code duplicated, block: B:113:0x00d9 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:73:0x00c3 A[PHI: r2
      0x00c3: PHI (r2v9 java.io.FileInputStream) = (r2v8 java.io.FileInputStream), (r2v11 java.io.FileInputStream) binds: [B:67:0x00b8, B:71:0x00bf] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:75:0x00c6 A[Catch: all -> 0x0088, TRY_ENTER, TRY_LEAVE, TryCatch #8 {all -> 0x0088, blocks: (B:50:0x0085, B:75:0x00c6), top: B:106:0x003e }] */
    /* JADX WARN: Code duplicated, block: B:86:0x00db A[Catch: all -> 0x00f6, TRY_ENTER, TryCatch #18 {all -> 0x00f6, blocks: (B:86:0x00db, B:90:0x00f4, B:87:0x00df, B:89:0x00ea), top: B:113:0x00d9 }] */
    /* JADX WARN: Code duplicated, block: B:87:0x00df A[Catch: all -> 0x00f6, TryCatch #18 {all -> 0x00f6, blocks: (B:86:0x00db, B:90:0x00f4, B:87:0x00df, B:89:0x00ea), top: B:113:0x00d9 }] */
    /* JADX WARN: Code duplicated, block: B:89:0x00ea A[Catch: all -> 0x00f6, TryCatch #18 {all -> 0x00f6, blocks: (B:86:0x00db, B:90:0x00f4, B:87:0x00df, B:89:0x00ea), top: B:113:0x00d9 }] */
    /* JADX WARN: Code restructure failed: missing block: B:49:0x0083, code lost:
    
        if (r2 != null) goto L50;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v17 */
    /* JADX WARN: Type inference failed for: r0v18 */
    /* JADX WARN: Type inference failed for: r0v19 */
    /* JADX WARN: Type inference failed for: r0v20 */
    /* JADX WARN: Type inference failed for: r0v21 */
    /* JADX WARN: Type inference failed for: r0v23 */
    /* JADX WARN: Type inference failed for: r0v24 */
    /* JADX WARN: Type inference failed for: r0v25 */
    /* JADX WARN: Type inference failed for: r0v26 */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARN: Type inference failed for: r0v31 */
    /* JADX WARN: Type inference failed for: r0v6, types: [boolean] */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v2, types: [cj.mobile.wm.nc, cj.mobile.wm.pc$dexa] */
    /* JADX WARN: Type inference failed for: r1v6, types: [cj.mobile.wm.nc] */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r1v9 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v2, types: [java.util.Map] */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v24 */
    /* JADX WARN: Type inference failed for: r2v26 */
    /* JADX WARN: Type inference failed for: r2v28 */
    /* JADX WARN: Type inference failed for: r2v30, types: [java.util.HashMap] */
    /* JADX WARN: Type inference failed for: r2v33 */
    /* JADX WARN: Type inference failed for: r2v38 */
    /* JADX WARN: Type inference failed for: r2v39 */
    /* JADX WARN: Type inference failed for: r2v4 */
    /* JADX WARN: Type inference failed for: r2v40 */
    /* JADX WARN: Type inference failed for: r2v41 */
    /* JADX WARN: Type inference failed for: r8v2 */
    /* JADX WARN: Type inference failed for: r8v3 */
    /* JADX WARN: Type inference failed for: r8v4 */
    /* JADX WARN: Type inference failed for: r8v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public nc dexa(String str, int i) throws Throwable {
        dexa dexaVar;
        ?? r1;
        Exception e;
        IOException e2;
        FileNotFoundException e3;
        FileInputStream fileInputStream;
        ?? r0;
        File fileDexa = dexa(str);
        synchronized (dexd) {
            dexa dexaVar2 = this.dexc.get(fileDexa);
            if (dexaVar2 != 0 && !dexaVar2.dexa()) {
                return dexaVar2;
            }
            File fileDexb = dexb(fileDexa);
            if (fileDexb.exists()) {
                fileDexa.delete();
                fileDexb.renameTo(fileDexa);
            }
            if (fileDexa.exists()) {
                fileDexa.canRead();
            }
            ?? Dexa = 0;
            Dexa = 0;
            Dexa = 0;
            Dexa = 0;
            Dexa = 0;
            fileInputStream = null;
            fileInputStream = null;
            FileInputStream fileInputStream2 = null;
            FileInputStream fileInputStream3 = null;
            Dexa = 0;
            FileInputStream fileInputStream4 = null;
            if (fileDexa.exists()) {
                ?? CanRead = fileDexa.canRead();
                try {
                    try {
                        if (CanRead != 0) {
                            try {
                                FileInputStream fileInputStream5 = new FileInputStream(fileDexa);
                                try {
                                    Dexa = qc.dexa(fileInputStream5);
                                    fileInputStream5.close();
                                    try {
                                        fileInputStream5.close();
                                    } catch (Throwable unused) {
                                    }
                                } catch (FileNotFoundException e4) {
                                    e3 = e4;
                                    ?? r8 = Dexa;
                                    fileInputStream3 = fileInputStream5;
                                    CanRead = r8;
                                    e3.printStackTrace();
                                    r0 = CanRead;
                                } catch (IOException e5) {
                                    e2 = e5;
                                    ?? r9 = Dexa;
                                    fileInputStream3 = fileInputStream5;
                                    CanRead = r9;
                                    e2.printStackTrace();
                                    if (fileInputStream3 != null) {
                                        r0 = CanRead;
                                        fileInputStream3.close();
                                        CanRead = r0;
                                    }
                                    Dexa = CanRead;
                                } catch (XmlPullParserException unused2) {
                                    ?? r10 = Dexa;
                                    fileInputStream2 = fileInputStream5;
                                    CanRead = r10;
                                    try {
                                        try {
                                            try {
                                                fileInputStream = new FileInputStream(fileDexa);
                                                try {
                                                    int iAvailable = fileInputStream.available();
                                                    byte[] bArr = new byte[iAvailable];
                                                    fileInputStream.read(bArr);
                                                    new String(bArr, 0, iAvailable, "UTF-8");
                                                } catch (FileNotFoundException e6) {
                                                    e = e6;
                                                    fileInputStream2 = fileInputStream;
                                                    e.printStackTrace();
                                                    if (fileInputStream2 != null) {
                                                        fileInputStream = fileInputStream2;
                                                        fileInputStream.close();
                                                    } else {
                                                        fileInputStream = fileInputStream2;
                                                    }
                                                    if (fileInputStream != null) {
                                                        fileInputStream.close();
                                                        CanRead = CanRead;
                                                    }
                                                    Dexa = CanRead;
                                                    synchronized (dexd) {
                                                        try {
                                                            if (dexaVar2 != 0) {
                                                                dexaVar2.dexa((Map) Dexa);
                                                                r1 = dexaVar2;
                                                            } else {
                                                                dexaVar = this.dexc.get(fileDexa);
                                                                if (dexaVar == null) {
                                                                    r1 = dexaVar;
                                                                    dexa dexaVar3 = new dexa(fileDexa, i, Dexa);
                                                                    this.dexc.put(fileDexa, dexaVar3);
                                                                    r1 = dexaVar3;
                                                                }
                                                            }
                                                            return r1;
                                                        } catch (Throwable th) {
                                                            throw th;
                                                        }
                                                    }
                                                } catch (IOException e7) {
                                                    e = e7;
                                                    fileInputStream2 = fileInputStream;
                                                    e.printStackTrace();
                                                    if (fileInputStream2 != null) {
                                                        fileInputStream = fileInputStream2;
                                                        fileInputStream.close();
                                                    } else {
                                                        fileInputStream = fileInputStream2;
                                                    }
                                                    if (fileInputStream != null) {
                                                        fileInputStream.close();
                                                        CanRead = CanRead;
                                                    }
                                                    Dexa = CanRead;
                                                    synchronized (dexd) {
                                                        if (dexaVar2 != 0) {
                                                            dexaVar2.dexa((Map) Dexa);
                                                            r1 = dexaVar2;
                                                        } else {
                                                            dexaVar = this.dexc.get(fileDexa);
                                                            if (dexaVar == null) {
                                                                r1 = dexaVar;
                                                                dexa dexaVar4 = new dexa(fileDexa, i, Dexa);
                                                                this.dexc.put(fileDexa, dexaVar4);
                                                                r1 = dexaVar4;
                                                            }
                                                        }
                                                        return r1;
                                                    }
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    fileInputStream2 = fileInputStream;
                                                    if (fileInputStream2 != null) {
                                                        try {
                                                            fileInputStream2.close();
                                                        } catch (Throwable unused3) {
                                                        }
                                                    }
                                                    throw th;
                                                }
                                            } catch (Throwable th3) {
                                                th = th3;
                                            }
                                        } catch (FileNotFoundException e8) {
                                            e = e8;
                                        } catch (IOException e9) {
                                            e = e9;
                                        }
                                        fileInputStream.close();
                                    } catch (Throwable unused4) {
                                    }
                                    if (fileInputStream != null) {
                                        fileInputStream.close();
                                        CanRead = CanRead;
                                    }
                                    Dexa = CanRead;
                                } catch (Exception e10) {
                                    e = e10;
                                    ?? r11 = Dexa;
                                    fileInputStream3 = fileInputStream5;
                                    CanRead = r11;
                                    e.printStackTrace();
                                    if (fileInputStream3 != null) {
                                        r0 = CanRead;
                                        fileInputStream3.close();
                                        CanRead = r0;
                                    }
                                    Dexa = CanRead;
                                } catch (Throwable th4) {
                                    th = th4;
                                    fileInputStream4 = fileInputStream5;
                                    if (fileInputStream4 != null) {
                                        try {
                                            fileInputStream4.close();
                                        } catch (Throwable unused5) {
                                        }
                                    }
                                    throw th;
                                }
                            } catch (FileNotFoundException e11) {
                                e3 = e11;
                                CanRead = 0;
                            } catch (IOException e12) {
                                e2 = e12;
                                CanRead = 0;
                            } catch (XmlPullParserException unused6) {
                                CanRead = 0;
                            } catch (Exception e13) {
                                e = e13;
                                CanRead = 0;
                            }
                        }
                    } catch (Throwable unused7) {
                    }
                } catch (Throwable th5) {
                    th = th5;
                }
            }
            synchronized (dexd) {
                if (dexaVar2 != 0) {
                    dexaVar2.dexa((Map) Dexa);
                    r1 = dexaVar2;
                } else {
                    dexaVar = this.dexc.get(fileDexa);
                    if (dexaVar == null) {
                        r1 = dexaVar;
                        dexa dexaVar5 = new dexa(fileDexa, i, Dexa);
                        this.dexc.put(fileDexa, dexaVar5);
                        r1 = dexaVar5;
                    }
                }
            }
            return r1;
        }
    }
}
