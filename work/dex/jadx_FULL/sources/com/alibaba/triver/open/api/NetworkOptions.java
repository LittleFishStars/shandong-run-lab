package com.alibaba.triver.open.api;

import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class NetworkOptions {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f25031a = 3000;
    private String b;
    private String c;
    private Map<String, String> d;
    private String e;
    private Type f;
    private int g;

    public enum Type {
        json,
        text,
        jsonp,
        base64,
        arraybuffer
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f25032a;
        private String b;
        private Map<String, String> c = new HashMap();
        private String d;
        private Type e;
        private int f;

        public a a(String str) {
            this.f25032a = str;
            return this;
        }

        public a b(String str) {
            this.b = str;
            return this;
        }

        public a c(String str) {
            this.d = str;
            return this;
        }

        public a d(String str) {
            Type type = Type.json;
            if (type.name().equals(str)) {
                this.e = type;
            } else {
                Type type2 = Type.jsonp;
                if (type2.name().equals(str)) {
                    this.e = type2;
                } else {
                    Type type3 = Type.base64;
                    if (type3.name().equals(str)) {
                        this.e = type3;
                    } else {
                        Type type4 = Type.arraybuffer;
                        if (type4.name().equals(str)) {
                            this.e = type4;
                        } else {
                            this.e = Type.text;
                        }
                    }
                }
            }
            return this;
        }

        public a a(String str, String str2) {
            this.c.put(str, str2);
            return this;
        }

        public a a(Type type) {
            this.e = type;
            return this;
        }

        public a a(int i) {
            this.f = i;
            return this;
        }

        public NetworkOptions a() {
            return new NetworkOptions(this.f25032a, this.b, this.c, this.d, this.e, this.f);
        }
    }

    public String a() {
        return this.b;
    }

    public String b() {
        return this.c;
    }

    public Map<String, String> c() {
        return this.d;
    }

    public String d() {
        return this.e;
    }

    public Type e() {
        return this.f;
    }

    public int f() {
        return this.g;
    }

    private NetworkOptions(String str, String str2, Map<String, String> map, String str3, Type type, int i) {
        Type type2 = Type.text;
        this.g = 3000;
        this.b = str;
        this.c = str2;
        this.d = map;
        this.e = str3;
        this.f = type;
        this.g = i == 0 ? 3000 : i;
    }
}
