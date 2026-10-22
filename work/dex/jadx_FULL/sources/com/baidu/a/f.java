package com.baidu.a;

import android.util.LruCache;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f26244a;
    private final LruCache<String, a> b = new LruCache<>(((int) Runtime.getRuntime().maxMemory()) / 16);
    private boolean c;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ArrayList<String> f26245a;
        private ArrayList<String> b;
        private long c;
        private long d;

        public void a(long j) {
            this.c = j;
        }

        public void a(ArrayList<String> arrayList) {
            this.f26245a = arrayList;
        }

        public boolean a() {
            return e() + this.c < System.currentTimeMillis() / 1000;
        }

        public ArrayList<String> b() {
            return this.f26245a;
        }

        public void b(long j) {
            this.d = j;
        }

        public void b(ArrayList<String> arrayList) {
            this.b = arrayList;
        }

        public ArrayList<String> c() {
            return this.b;
        }

        public long d() {
            return this.c;
        }

        public long e() {
            return this.d;
        }
    }

    public f(String str, boolean z) {
        this.c = false;
        this.f26244a = str;
        this.c = z;
    }

    public a a(String str) {
        a aVar = this.b.get(str);
        if (aVar == null || !aVar.a() || !this.c) {
            return aVar;
        }
        this.b.remove(str);
        j.a("Remove expired entry from %s cache while reading, host(%s)", this.f26244a, str);
        return null;
    }

    public void a() {
        this.b.evictAll();
        j.a("Clear %s cache", this.f26244a);
    }

    public void a(String str, a aVar) {
        ArrayList<String> arrayListB = aVar.b();
        ArrayList<String> arrayListC = aVar.c();
        if ((arrayListB == null || arrayListB.isEmpty()) && (arrayListC == null || arrayListC.isEmpty())) {
            return;
        }
        this.b.put(str, aVar);
        Object[] objArr = new Object[5];
        objArr[0] = this.f26244a;
        objArr[1] = str;
        objArr[2] = arrayListB != null ? arrayListB.toString() : null;
        objArr[3] = arrayListC != null ? arrayListC.toString() : null;
        objArr[4] = Long.valueOf(aVar.d());
        j.a("Set entry to %s cache, host(%s), ipv4List(%s), ipv6List(%s), ttl(%d)", objArr);
    }

    public void a(boolean z) {
        this.c = z;
    }

    public ArrayList<String> b() {
        ArrayList<String> arrayList = new ArrayList<>();
        Iterator<String> it = this.b.snapshot().keySet().iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public void b(String str) {
        a aVarA = a(str);
        if (aVarA == null || !aVarA.a()) {
            return;
        }
        this.b.remove(str);
        j.a("Remove expired entry from %s cache, host(%s)", this.f26244a, str);
    }
}
