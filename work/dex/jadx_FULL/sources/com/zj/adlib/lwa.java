package com.zj.adlib;

import android.content.Context;
import android.text.TextUtils;
import com.amap.api.maps.model.LatLng;
import java.lang.ref.WeakReference;
import java.util.Hashtable;
import java.util.Iterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class lwa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static volatile lwa f43175a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static boolean f18100a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Hashtable<String, String> f18102a = new Hashtable<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public WeakReference<Context> f18101a = null;

    public static lwa a() {
        if (f43175a == null) {
            synchronized (lwa.class) {
                if (f43175a == null) {
                    f43175a = new lwa();
                }
            }
        }
        return f43175a;
    }

    public static void e(boolean z) {
        f18100a = z;
    }

    public static void f() {
        if (f43175a != null) {
            if (f43175a.f18102a != null && f43175a.f18102a.size() > 0) {
                synchronized (f43175a.f18102a) {
                    f43175a.h();
                    if (f43175a.f18101a != null) {
                        f43175a.f18101a.clear();
                    }
                }
            }
            f43175a = null;
        }
        e(false);
    }

    public static boolean g() {
        return f18100a;
    }

    public final void b(Context context) {
        if (context != null) {
            this.f18101a = new WeakReference<>(context);
        }
    }

    public final void c(LatLng latLng, String str, String str2) {
        if (!f18100a) {
            this.f18102a.clear();
            return;
        }
        if (latLng == null || TextUtils.isEmpty(str)) {
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(bv9.b);
        stringBuffer.append("\"lon\":");
        stringBuffer.append(latLng.longitude);
        stringBuffer.append(",");
        stringBuffer.append("\"lat\":");
        stringBuffer.append(latLng.latitude);
        stringBuffer.append(",");
        stringBuffer.append("\"title\":\"");
        stringBuffer.append(str);
        stringBuffer.append("\",");
        if (TextUtils.isEmpty(str2)) {
            str2 = "";
        }
        stringBuffer.append("\"snippet\":\"");
        stringBuffer.append(str2);
        stringBuffer.append("\"");
        stringBuffer.append("}");
        d(stringBuffer.toString());
    }

    public final void d(String str) {
        Hashtable<String, String> hashtable;
        if (str == null || (hashtable = this.f18102a) == null) {
            return;
        }
        synchronized (hashtable) {
            String strD = p4b.d(str);
            Hashtable<String, String> hashtable2 = this.f18102a;
            if (hashtable2 != null && !hashtable2.contains(strD)) {
                this.f18102a.put(strD, str);
            }
            if (i()) {
                h();
            }
        }
    }

    public final void h() {
        WeakReference<Context> weakReference;
        if (!f18100a) {
            this.f18102a.clear();
            return;
        }
        if (this.f18102a != null) {
            StringBuffer stringBuffer = new StringBuffer();
            int size = this.f18102a.size();
            if (size > 0) {
                stringBuffer.append("[");
                Iterator<String> it = this.f18102a.values().iterator();
                int i = 0;
                while (it.hasNext()) {
                    i++;
                    stringBuffer.append(it.next());
                    if (i < size) {
                        stringBuffer.append(",");
                    }
                }
                stringBuffer.append("]");
                String string = stringBuffer.toString();
                if (!TextUtils.isEmpty(string) && (weakReference = this.f18101a) != null && weakReference.get() != null) {
                    m9b.a(string, this.f18101a.get());
                }
            }
            this.f18102a.clear();
        }
    }

    public final boolean i() {
        Hashtable<String, String> hashtable = this.f18102a;
        return hashtable != null && hashtable.size() > 20;
    }
}
