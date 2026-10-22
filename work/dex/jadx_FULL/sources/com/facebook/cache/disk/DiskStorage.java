package com.facebook.cache.disk;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.WriterCallback;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public interface DiskStorage {

    public interface Entry {
        BinaryResource a();

        String getId();

        long getSize();

        long getTimestamp();
    }

    public interface Inserter {
        BinaryResource a(Object obj) throws IOException;

        void b(WriterCallback writerCallback, Object obj) throws IOException;

        boolean c();
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public List<b> f29943a = new ArrayList();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Map<String, Integer> f1536a = new HashMap();
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f29944a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f1537a;
        public final String b;
        public final String c;

        public b(String str, String str2, float f, String str3) {
            this.f1537a = str;
            this.b = str2;
            this.f29944a = f;
            this.c = str3;
        }
    }

    a a() throws IOException;

    BinaryResource b(String str, Object obj) throws IOException;

    boolean c(String str, Object obj) throws IOException;

    void clearAll() throws IOException;

    long d(String str) throws IOException;

    Collection<Entry> e() throws IOException;

    void f();

    boolean g(String str, Object obj) throws IOException;

    long h(Entry entry) throws IOException;

    Inserter insert(String str, Object obj) throws IOException;

    boolean isEnabled();
}
