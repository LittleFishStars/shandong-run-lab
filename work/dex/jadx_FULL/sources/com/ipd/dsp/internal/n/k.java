package com.ipd.dsp.internal.n;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class k implements i {
    public final Map<String, List<j>> c;
    public volatile Map<String, String> d;

    public static final class a {
        public static final String d = "User-Agent";
        public static final String e;
        public static final Map<String, List<j>> f;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f38430a = true;
        public Map<String, List<j>> b = f;
        public boolean c = true;

        static {
            String strD = d();
            e = strD;
            HashMap map = new HashMap(2);
            if (!TextUtils.isEmpty(strD)) {
                map.put("User-Agent", Collections.singletonList(new b(strD)));
            }
            f = Collections.unmodifiableMap(map);
        }

        @VisibleForTesting
        public static String d() {
            String property = System.getProperty("http.agent");
            if (TextUtils.isEmpty(property)) {
                return property;
            }
            int length = property.length();
            StringBuilder sb = new StringBuilder(property.length());
            for (int i = 0; i < length; i++) {
                char cCharAt = property.charAt(i);
                if ((cCharAt > 31 || cCharAt == '\t') && cCharAt < 127) {
                    sb.append(cCharAt);
                } else {
                    sb.append('?');
                }
            }
            return sb.toString();
        }

        public a a(@NonNull String str, @NonNull String str2) {
            return a(str, new b(str2));
        }

        public a b(@NonNull String str, @Nullable String str2) {
            return b(str, str2 == null ? null : new b(str2));
        }

        public final void c() {
            if (this.f38430a) {
                this.f38430a = false;
                this.b = b();
            }
        }

        public a a(@NonNull String str, @NonNull j jVar) {
            if (this.c && "User-Agent".equalsIgnoreCase(str)) {
                return b(str, jVar);
            }
            c();
            a(str).add(jVar);
            return this;
        }

        public a b(@NonNull String str, @Nullable j jVar) {
            c();
            if (jVar == null) {
                this.b.remove(str);
            } else {
                List<j> listA = a(str);
                listA.clear();
                listA.add(jVar);
            }
            if (this.c && "User-Agent".equalsIgnoreCase(str)) {
                this.c = false;
            }
            return this;
        }

        public final List<j> a(String str) {
            List<j> list = this.b.get(str);
            if (list != null) {
                return list;
            }
            ArrayList arrayList = new ArrayList();
            this.b.put(str, arrayList);
            return arrayList;
        }

        public k a() {
            this.f38430a = true;
            return new k(this.b);
        }

        public final Map<String, List<j>> b() {
            HashMap map = new HashMap(this.b.size());
            for (Map.Entry<String, List<j>> entry : this.b.entrySet()) {
                map.put(entry.getKey(), new ArrayList(entry.getValue()));
            }
            return map;
        }
    }

    public static final class b implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NonNull
        public final String f38431a;

        public b(@NonNull String str) {
            this.f38431a = str;
        }

        @Override // com.ipd.dsp.internal.n.j
        public String a() {
            return this.f38431a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof b) {
                return this.f38431a.equals(((b) obj).f38431a);
            }
            return false;
        }

        public int hashCode() {
            return this.f38431a.hashCode();
        }

        public String toString() {
            return "StringHeaderFactory{value='" + this.f38431a + "'}";
        }
    }

    public k(Map<String, List<j>> map) {
        this.c = Collections.unmodifiableMap(map);
    }

    @Override // com.ipd.dsp.internal.n.i
    public Map<String, String> a() {
        if (this.d == null) {
            synchronized (this) {
                if (this.d == null) {
                    this.d = Collections.unmodifiableMap(b());
                }
            }
        }
        return this.d;
    }

    public final Map<String, String> b() {
        HashMap map = new HashMap();
        for (Map.Entry<String, List<j>> entry : this.c.entrySet()) {
            String strA = a(entry.getValue());
            if (!TextUtils.isEmpty(strA)) {
                map.put(entry.getKey(), strA);
            }
        }
        return map;
    }

    public boolean equals(Object obj) {
        if (obj instanceof k) {
            return this.c.equals(((k) obj).c);
        }
        return false;
    }

    public int hashCode() {
        return this.c.hashCode();
    }

    public String toString() {
        return "LazyHeaders{headers=" + this.c + '}';
    }

    @NonNull
    public final String a(@NonNull List<j> list) {
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            String strA = list.get(i).a();
            if (!TextUtils.isEmpty(strA)) {
                sb.append(strA);
                if (i != list.size() - 1) {
                    sb.append(',');
                }
            }
        }
        return sb.toString();
    }
}
