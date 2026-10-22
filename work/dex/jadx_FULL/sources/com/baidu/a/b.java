package com.baidu.a;

import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private EnumC0255b f26237a;
    private final a b;
    private ArrayList<String> c;
    private ArrayList<String> d;

    public enum a {
        BDHttpDnsResolveOK,
        BDHttpDnsInputError,
        BDHttpDnsResolveErrorCacheMiss,
        BDHttpDnsResolveErrorDnsResolve
    }

    /* JADX INFO: renamed from: com.baidu.a.b$b, reason: collision with other inner class name */
    public enum EnumC0255b {
        RESOLVE_NONE,
        RESOLVE_NONEED,
        RESOLVE_FROM_HTTPDNS_CACHE,
        RESOLVE_FROM_HTTPDNS_EXPIRED_CACHE,
        RESOLVE_FROM_DNS_CACHE,
        RESOLVE_FROM_DNS
    }

    public b(a aVar) {
        this.f26237a = EnumC0255b.RESOLVE_NONE;
        this.b = aVar;
    }

    public b(EnumC0255b enumC0255b, a aVar, ArrayList<String> arrayList, ArrayList<String> arrayList2) {
        EnumC0255b enumC0255b2 = EnumC0255b.RESOLVE_NONE;
        this.f26237a = enumC0255b;
        this.b = aVar;
        this.c = arrayList;
        this.d = arrayList2;
    }

    public EnumC0255b a() {
        return this.f26237a;
    }

    public a b() {
        return this.b;
    }

    public ArrayList<String> c() {
        return this.c;
    }

    public ArrayList<String> d() {
        return this.d;
    }
}
