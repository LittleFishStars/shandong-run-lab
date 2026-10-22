package com.alibaba.triver.prefetch.http;

import androidx.annotation.NonNull;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.triver.prefetch.a.c;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b implements c<a> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private a f25112a;
    private Page b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f25113a;
        private Object b;
        private String c;
        private Object d;
        private int e;
        private String f;

        public String a() {
            return this.f25113a;
        }

        public Object b() {
            return this.b;
        }

        public String c() {
            return this.c;
        }

        public Object d() {
            return this.d;
        }

        public int e() {
            return this.e;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.e == aVar.e && a(this.b, aVar.b) && a(this.f25113a, aVar.f25113a) && a(this.f, aVar.f)) {
                return a(this.d, aVar.d);
            }
            return false;
        }

        public String f() {
            return this.f;
        }

        /* JADX WARN: Code duplicated, block: B:22:0x003f A[PHI: r0
          0x003f: PHI (r0v8 int) = (r0v7 int), (r0v15 int) binds: [B:20:0x0038, B:17:0x002d] A[DONT_GENERATE, DONT_INLINE]] */
        public int hashCode() {
            int i;
            int iHashCode;
            String str = this.f25113a;
            int iHashCode2 = (str != null ? str.hashCode() : 0) * 31;
            Object obj = this.b;
            int iHashCode3 = (iHashCode2 + (obj != null ? obj.hashCode() : 0)) * 31;
            String str2 = this.c;
            int iHashCode4 = iHashCode3 + (str2 != null ? str2.hashCode() : 0);
            Object obj2 = this.d;
            if (obj2 instanceof byte[]) {
                i = iHashCode4 * 31;
                if (obj2 != null) {
                    iHashCode = Arrays.hashCode((byte[]) obj2);
                } else {
                    iHashCode = 0;
                }
            } else {
                i = iHashCode4 * 31;
                if (obj2 != null) {
                    iHashCode = obj2.hashCode();
                } else {
                    iHashCode = 0;
                }
            }
            int i2 = (((i + iHashCode) * 31) + this.e) * 31;
            String str3 = this.f;
            return i2 + (str3 != null ? str3.hashCode() : 0);
        }

        public String toString() {
            return "HttpPrefetchOptionData{url='" + this.f25113a + "', headers=" + this.b + ", method='" + this.c + "', data=" + this.d + ", timeout=" + this.e + ", dataType='" + this.f + "'}";
        }

        public void a(String str) {
            this.f25113a = str;
        }

        public void b(String str) {
            this.c = str;
        }

        public void c(String str) {
            this.f = str;
        }

        public void a(Object obj) {
            this.b = obj;
        }

        public void b(Object obj) {
            this.d = obj;
        }

        public void a(int i) {
            this.e = i;
        }

        private static boolean a(Object obj, Object obj2) {
            if (obj == obj2) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (obj instanceof byte[]) {
                if (obj2 instanceof byte[]) {
                    return Arrays.equals((byte[]) obj, (byte[]) obj2);
                }
                return false;
            }
            return obj.equals(obj2);
        }
    }

    private b(@NonNull a aVar) {
        this.f25112a = aVar;
    }

    public Page b() {
        return this.b;
    }

    @Override // com.alibaba.triver.prefetch.a.c
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public a a() {
        return this.f25112a;
    }

    public void a(Page page) {
        this.b = page;
    }

    public static b a(a aVar) {
        return new b(aVar);
    }

    public static b a(a aVar, Page page) {
        b bVar = new b(aVar);
        bVar.b = page;
        return bVar;
    }
}
