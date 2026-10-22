package com.hp.hpl.sparta;

import java.util.Hashtable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class Sparta {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Internment f6849a = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static CacheFactory f32695a = new b();

    public interface Cache {
        Object get(Object obj);

        Object put(Object obj, Object obj2);

        int size();
    }

    public interface CacheFactory {
        Cache a();
    }

    public static class HashtableCache extends Hashtable implements Cache {
        private HashtableCache() {
        }

        public /* synthetic */ HashtableCache(a aVar) {
            this();
        }
    }

    public interface Internment {
        String a(String str);
    }

    public static class a implements Internment {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Hashtable f32696a = new Hashtable();

        @Override // com.hp.hpl.sparta.Sparta.Internment
        public String a(String str) {
            String str2 = (String) this.f32696a.get(str);
            if (str2 != null) {
                return str2;
            }
            this.f32696a.put(str, str);
            return str;
        }
    }

    public static class b implements CacheFactory {
        @Override // com.hp.hpl.sparta.Sparta.CacheFactory
        public Cache a() {
            return new HashtableCache(null);
        }
    }

    public static String a(String str) {
        return f6849a.a(str);
    }

    public static Cache b() {
        return f32695a.a();
    }

    public static void c(CacheFactory cacheFactory) {
        f32695a = cacheFactory;
    }

    public static void d(Internment internment) {
        f6849a = internment;
    }
}
