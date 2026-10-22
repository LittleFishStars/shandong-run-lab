package com.zj.adlib;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import com.alibaba.android.arouter.utils.Consts;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.HashSet;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class l1b extends ContextThemeWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String[] f42972a = {"android.widget", "android.webkit", "android.app"};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Resources f17853a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LayoutInflater.Factory f17854a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LayoutInflater f17855a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f17856a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ClassLoader f17857a;

    public class a implements LayoutInflater.Factory {
        public a() {
        }

        @Override // android.view.LayoutInflater.Factory
        public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return l1b.this.b(str, context, attributeSet);
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public HashSet<String> f17859a = new HashSet<>();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public HashMap<String, Constructor<?>> f17858a = new HashMap<>();

        public b() {
        }
    }

    public l1b(Context context, int i, ClassLoader classLoader) {
        super(context, i);
        this.f17856a = new b();
        this.f17854a = new a();
        this.f17853a = q1b.b();
        this.f17857a = classLoader;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x0064 A[PHI: r5
      0x0064: PHI (r5v1 java.lang.Class<?>) = 
      (r5v0 java.lang.Class<?>)
      (r5v12 java.lang.Class<?>)
      (r5v12 java.lang.Class<?>)
      (r5v12 java.lang.Class<?>)
      (r5v12 java.lang.Class<?>)
     binds: [B:25:0x0063, B:17:0x0051, B:20:0x0056, B:35:0x0064, B:22:0x005e] A[DONT_GENERATE, DONT_INLINE]] */
    public final View b(String str, Context context, AttributeSet attributeSet) {
        Class<?> clsLoadClass;
        boolean z;
        if (this.f17856a.f17859a.contains(str)) {
            return null;
        }
        Constructor<?> constructor = this.f17856a.f17858a.get(str);
        if (constructor == null) {
            try {
                if (!str.contains("api.navi")) {
                    String[] strArr = f42972a;
                    int length = strArr.length;
                    int i = 0;
                    while (true) {
                        if (i >= length) {
                            clsLoadClass = null;
                            break;
                        }
                        String str2 = strArr[i];
                        try {
                            clsLoadClass = this.f17857a.loadClass(str2 + Consts.DOT + str);
                            break;
                        } catch (Throwable unused) {
                            i++;
                        }
                    }
                } else {
                    clsLoadClass = this.f17857a.loadClass(str);
                }
                if (clsLoadClass == null || clsLoadClass == ViewStub.class) {
                    z = false;
                } else {
                    try {
                        if (clsLoadClass.getClassLoader() != this.f17857a) {
                            z = false;
                        } else {
                            z = true;
                        }
                    } catch (Throwable unused2) {
                    }
                }
            } catch (Throwable unused3) {
                clsLoadClass = null;
            }
            if (!z) {
                this.f17856a.f17859a.add(str);
                return null;
            }
            try {
                constructor = clsLoadClass.getConstructor(Context.class, AttributeSet.class);
                this.f17856a.f17858a.put(str, constructor);
            } catch (Throwable unused4) {
            }
        }
        if (constructor == null) {
            return null;
        }
        try {
            return (View) constructor.newInstance(context, attributeSet);
        } catch (Throwable unused5) {
            return null;
        }
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        Resources resources = this.f17853a;
        return resources != null ? resources : super.getResources();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return super.getSystemService(str);
        }
        if (this.f17855a == null) {
            LayoutInflater layoutInflater = (LayoutInflater) super.getSystemService(str);
            if (layoutInflater != null) {
                this.f17855a = layoutInflater.cloneInContext(this);
            }
            this.f17855a.setFactory(this.f17854a);
            this.f17855a = this.f17855a.cloneInContext(this);
        }
        return this.f17855a;
    }
}
