package com.baidu.mapauto.auth.net;

import com.baidu.mapauto.auth.AuthCore;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f26602a;
    public String b;
    public Map<String, Object> c;
    public HostnameVerifier d;

    public static final class a {
        public String b;
        public HostnameVerifier d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f26603a = 5000;
        public final HashMap c = new HashMap();

        public final a a(AuthCore.a aVar) {
            this.d = aVar;
            return this;
        }

        public final a a(HashMap map) {
            this.c.clear();
            this.c.putAll(map);
            return this;
        }

        public final c a() {
            return new c(this.b, this.f26603a, this.c, this.d);
        }

        public final a b() {
            this.b = "https://api.map.baidu.com";
            return this;
        }

        public final a c() {
            this.f26603a = 10000;
            return this;
        }

        public final a d() {
            return this;
        }
    }

    public c(String str, int i, HashMap map, HostnameVerifier hostnameVerifier) {
        this.b = str;
        this.f26602a = i;
        this.c = map;
        this.d = hostnameVerifier;
    }
}
