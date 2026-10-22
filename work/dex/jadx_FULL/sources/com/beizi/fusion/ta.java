package com.beizi.fusion;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import com.alibaba.android.arouter.utils.Consts;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class ta {
    private final long b = 1048576;
    protected final Object e = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final long f27780a = ((long) a()) * 1048576;
    private final Map c = new HashMap();
    private final Map d = new HashMap();

    public interface b {
        void a(String str);

        void a(String str, Object obj);
    }

    public static abstract class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final String f27782a;
        protected final File b;
        protected final String c;
        protected b d;

        public c(String str, File file, String str2) {
            this.f27782a = str;
            this.b = file;
            this.c = str2;
        }

        public void a(b bVar) {
            this.d = bVar;
        }
    }

    private Set c(String str) {
        synchronized (this.d) {
            Set set = (Set) this.d.get(str);
            if (set == null) {
                return null;
            }
            HashSet hashSet = new HashSet(set);
            set.clear();
            return hashSet;
        }
    }

    private boolean d(String str) {
        boolean zContainsKey;
        synchronized (this.c) {
            zContainsKey = this.c.containsKey(b(str));
        }
        return zContainsKey;
    }

    public abstract int a();

    public abstract c a(String str, File file, String str2);

    public abstract File a(Context context, ph phVar);

    public void a(Context context, String str, ph phVar) {
        if (TextUtils.isEmpty(str) || c(context, str, phVar) || d(str) || context == null) {
            return;
        }
        String strA = a(str);
        File fileA = a(context, phVar);
        if (fileA != null) {
            String strB = b(str);
            c cVarA = a(str, new File(fileA, strA), strB);
            a(strB, cVarA);
            ((fb) cn.a().b(context.getApplicationContext())).c(cVarA);
        }
    }

    public File b(Context context, String str, ph phVar) {
        File fileA = a(context, phVar);
        if (fileA != null) {
            return new File(fileA, a(str));
        }
        return null;
    }

    public void e(String str) {
        synchronized (this.c) {
            this.c.remove(str);
        }
    }

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final File f27781a;
        private final long b;
        private final int c;

        private a(File file, long j) {
            this.c = 7;
            this.f27781a = file;
            this.b = j;
        }

        private void a() {
            File[] fileArrA = c8.a(this.f27781a, l6.a(7));
            if (fileArrA == null || fileArrA.length <= 0) {
                return;
            }
            a(fileArrA);
        }

        private void b() {
            if (c8.a(this.f27781a) > this.b) {
                ArrayList arrayList = new ArrayList();
                File[] fileArrListFiles = this.f27781a.listFiles();
                if (fileArrListFiles != null) {
                    Collections.addAll(arrayList, fileArrListFiles);
                    Collections.sort(arrayList, new Comparator() { // from class: com.beizi.fusion.zq
                        @Override // java.util.Comparator
                        public final int compare(Object obj, Object obj2) {
                            return ta.a.a((File) obj, (File) obj2);
                        }
                    });
                    int size = arrayList.size() / 2;
                    if (size > 0) {
                        File[] fileArr = new File[size];
                        for (int i = 0; i < size; i++) {
                            fileArr[i] = (File) arrayList.get(i);
                        }
                        a(fileArr);
                    }
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            File file = this.f27781a;
            if (file != null && file.exists() && this.f27781a.isDirectory()) {
                a();
                b();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static /* synthetic */ int a(File file, File file2) {
            return file.lastModified() < file2.lastModified() ? 1 : -1;
        }

        private void a(File[] fileArr) {
            if (fileArr != null) {
                for (File file : fileArr) {
                    try {
                        file.delete();
                    } catch (Exception unused) {
                    }
                }
            }
        }
    }

    public String b(String str) {
        return qh.a(str);
    }

    private boolean c(Context context, String str, ph phVar) {
        File fileA = a(context, phVar);
        if (fileA == null || !fileA.exists()) {
            return false;
        }
        return c8.b(fileA, a(str));
    }

    public void a(Context context, String str, ph phVar, le leVar, me meVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strB = b(str);
        synchronized (this.e) {
            if (d(str)) {
                a(strB, leVar);
                if (meVar != null) {
                    meVar.b(str);
                }
            } else {
                File fileA = a(context, phVar);
                if (fileA != null) {
                    File file = new File(fileA, a(str));
                    if (!file.exists()) {
                        a(strB, leVar);
                        a(context, str, phVar);
                    } else if (leVar != null) {
                        leVar.a(strB, file);
                    }
                }
            }
        }
    }

    public void a(Context context) {
        File fileA = a(context, ph.TEMPORARY);
        if (fileA != null) {
            a(context, fileA);
        }
    }

    public void a(String str, Bitmap bitmap) {
        Set<le> setC = c(str);
        if (setC == null || setC.isEmpty()) {
            return;
        }
        for (le leVar : setC) {
            if (leVar != null) {
                if (bitmap != null && (leVar instanceof w4.b)) {
                    ((w4.b) leVar).a(str, bitmap);
                } else {
                    leVar.a(str);
                }
            }
        }
    }

    private void a(String str, c cVar) {
        synchronized (this.c) {
            this.c.put(str, cVar);
        }
    }

    private void a(String str, le leVar) {
        synchronized (this.d) {
            if (leVar != null) {
                Set hashSet = (Set) this.d.get(str);
                if (hashSet == null) {
                    hashSet = new HashSet();
                }
                hashSet.add(leVar);
                this.d.put(str, hashSet);
            }
        }
    }

    public void a(String str, File file) {
        Set<le> setC = c(str);
        if (setC != null) {
            for (le leVar : setC) {
                if (leVar != null) {
                    if (file != null && file.exists()) {
                        leVar.a(str, file);
                    } else {
                        leVar.a(str);
                    }
                }
            }
        }
    }

    private void a(Context context, File file) {
        ((fb) cn.a().b(context.getApplicationContext())).c(new a(file, this.f27780a));
    }

    public String a(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String strC = no.c(str);
        if (TextUtils.isEmpty(strC)) {
            return "";
        }
        return qh.a(str) + Consts.DOT + strC;
    }
}
