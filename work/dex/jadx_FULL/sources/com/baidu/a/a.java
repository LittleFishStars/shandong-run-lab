package com.baidu.a;

import android.content.Context;
import android.content.IntentFilter;
import com.igexin.sdk.PushConsts;
import java.util.ArrayList;
import java.util.HashSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile a f26234a;
    private c f;
    private final Context g;
    private long i;
    private long j;
    private int k;
    private final g b = g.a();
    private final e c = e.a();
    private final f d = new f("DNS", true);
    private final f e = new f("HTTPDNS", false);
    private EnumC0254a h = EnumC0254a.POLICY_TOLERANT;

    /* JADX INFO: renamed from: com.baidu.a.a$a, reason: collision with other inner class name */
    public enum EnumC0254a {
        POLICY_AGGRESSIVE,
        POLICY_TOLERANT,
        POLICY_STRICT
    }

    private a(Context context) {
        this.g = context;
        f();
        this.f.a();
        this.j = System.currentTimeMillis();
    }

    public static a a(Context context) {
        if (f26234a == null) {
            synchronized (a.class) {
                if (f26234a == null) {
                    f26234a = new a(context);
                }
            }
        }
        return f26234a;
    }

    private boolean a(long j) {
        return this.b.f() || j - this.i > 1000;
    }

    private boolean b(long j) {
        if (j - this.j <= 60000) {
            return false;
        }
        this.j = j;
        return true;
    }

    private void f() {
        this.f = new c();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(PushConsts.ACTION_BROADCAST_NETWORK_CHANGE);
        this.g.registerReceiver(this.f, intentFilter);
    }

    public b a(String str, boolean z) {
        if (d.a(str)) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(str);
            return new b(b.EnumC0255b.RESOLVE_NONEED, b.a.BDHttpDnsResolveOK, arrayList, null);
        }
        if (d.b(str)) {
            ArrayList arrayList2 = new ArrayList();
            arrayList2.add(str.replaceAll("[\\[\\]]", ""));
            return new b(b.EnumC0255b.RESOLVE_NONEED, b.a.BDHttpDnsResolveOK, null, arrayList2);
        }
        b.EnumC0255b enumC0255b = b.EnumC0255b.RESOLVE_NONE;
        f.a aVarA = this.e.a(str);
        long jCurrentTimeMillis = System.currentTimeMillis();
        ArrayList<String> arrayList3 = new ArrayList<>();
        if (a(jCurrentTimeMillis)) {
            if (aVarA == null) {
                arrayList3.add(str);
            } else if (aVarA.a()) {
                this.b.a(str);
            }
            if (b(jCurrentTimeMillis)) {
                arrayList3.addAll(this.b.c());
            }
            this.b.a(arrayList3, new i(this.g));
        } else {
            j.a("please wait a moment to send request for %s, until preResolve finished or has passed 1000ms ", str);
        }
        if (aVarA != null) {
            b.EnumC0255b enumC0255b2 = aVarA.a() ? b.EnumC0255b.RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE : b.EnumC0255b.RESOLVE_FROM_HTTPDNS_CACHE;
            Object[] objArr = new Object[4];
            objArr[0] = str;
            objArr[1] = aVarA.b() != null ? aVarA.b().toString() : null;
            objArr[2] = aVarA.c() != null ? aVarA.c().toString() : null;
            objArr[3] = enumC0255b2.toString();
            j.a("Sync resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr);
            return new b(enumC0255b2, b.a.BDHttpDnsResolveOK, aVarA.b(), aVarA.c());
        }
        if (aVarA == null && z) {
            j.a("Sync resolve failed, host(%s), find no httpdns cache entry and cacheOnly is true", str);
            return new b(enumC0255b, b.a.BDHttpDnsResolveErrorCacheMiss, null, null);
        }
        f.a aVarA2 = this.d.a(str);
        if (aVarA2 != null) {
            b.EnumC0255b enumC0255b3 = b.EnumC0255b.RESOLVE_FROM_DNS_CACHE;
            Object[] objArr2 = new Object[4];
            objArr2[0] = str;
            objArr2[1] = aVarA2.b() != null ? aVarA2.b().toString() : null;
            objArr2[2] = aVarA2.c() != null ? aVarA2.c().toString() : null;
            objArr2[3] = enumC0255b3.toString();
            j.a("Sync resolve successful, host(%s) ipv4List(%s) ipv6List(%s) resolveType(%s)", objArr2);
            return new b(enumC0255b3, b.a.BDHttpDnsResolveOK, aVarA2.b(), aVarA2.c());
        }
        b bVarA = this.c.a(str);
        if (bVarA.b() == b.a.BDHttpDnsResolveOK) {
            f.a aVar = new f.a();
            aVar.a(60L);
            aVar.b(System.currentTimeMillis() / 1000);
            aVar.a(bVarA.c());
            aVar.b(bVarA.d());
            this.d.a(str, aVar);
            Object[] objArr3 = new Object[4];
            objArr3[0] = str;
            objArr3[1] = aVar.b() != null ? aVar.b().toString() : null;
            objArr3[2] = aVar.c() != null ? aVar.c().toString() : null;
            objArr3[3] = bVarA.a().toString();
            j.a("Sync resolve successful, host(%s) ipList(%s) ipv6List(%s) resolveType(%s)", objArr3);
        } else {
            j.a("Sync resolve failed, host(%s), dns resolve failed", str);
        }
        return bVarA;
    }

    public f a() {
        return this.e;
    }

    public void a(EnumC0254a enumC0254a) {
        this.h = enumC0254a;
        if (enumC0254a == EnumC0254a.POLICY_STRICT) {
            this.e.a(true);
        } else {
            this.e.a(false);
        }
        j.a("Set cache policy to %s", enumC0254a.name());
    }

    public void a(String str) {
        if (str.length() <= 64) {
            this.b.c(str);
            j.a("Set account id to %s", str);
        } else {
            throw new IllegalArgumentException("accountID length(" + str.length() + ") is bigger than 64");
        }
    }

    public void a(ArrayList<String> arrayList) {
        if (arrayList.size() <= 0) {
            j.a("Set pre resolve hosts error, get empty hosts", new Object[0]);
            return;
        }
        ArrayList arrayList2 = new ArrayList(new HashSet(arrayList));
        int iD = this.b.d();
        if (arrayList2.size() > iD) {
            j.a("The current number of hosts is %d, and the max supported size is %s.Please reduce it to %s or less.", Integer.valueOf(arrayList2.size()), Integer.valueOf(iD), Integer.valueOf(iD));
            return;
        }
        int i = this.k + 1;
        this.k = i;
        if (i > 1) {
            j.a("You have already set PreResolveHosts, it is best to set it only once.", new Object[0]);
        }
        this.i = System.currentTimeMillis();
        String str = "";
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            str = str + ((String) arrayList2.get(i2)) + ",";
        }
        if (str == null || str.isEmpty()) {
            return;
        }
        String strSubstring = str.substring(0, str.length() - 1);
        j.a("Set pre resolve hosts: %s", strSubstring);
        this.b.a(strSubstring, g.d.DNLIST_HOSTS, new i(this.g));
    }

    public void a(boolean z) {
        this.b.a(z);
        j.a("Set https enabled to %b", Boolean.valueOf(z));
    }

    public void a(boolean z, boolean z2) {
        this.f.a(z);
        this.f.b(z2);
        j.a("Set network change policy, clearCache(%b), httpDnsPrefetch(%b)", Boolean.valueOf(z), Boolean.valueOf(z2));
    }

    public f b() {
        return this.d;
    }

    public void b(String str) {
        int length = str.length();
        if (length > 64 || length < 8) {
            throw new IllegalArgumentException("secret length(" + str.length() + ") check failed");
        }
        this.b.d(str);
        String strSubstring = str.substring(0, 3);
        for (int i = 0; i < length - 6; i++) {
            strSubstring = strSubstring + String.valueOf('*');
        }
        j.a("Set secret to %s", strSubstring + str.substring(length - 3));
    }

    public EnumC0254a c() {
        return this.h;
    }

    public g d() {
        return this.b;
    }

    public int e() {
        return this.k;
    }
}
