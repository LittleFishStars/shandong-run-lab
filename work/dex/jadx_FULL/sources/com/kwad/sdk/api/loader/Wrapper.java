package com.kwad.sdk.api.loader;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.kwad.sdk.api.core.ResContext;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Keep
public class Wrapper {
    private static final String CLAZZ_NAME = "com.kwad.sdk.api.loader.Wrapper";
    private static final int COUNT_LIMIT_AUTO_UN_WRAP = 5;
    private static final int COUNT_LIMIT_AUTO_UN_WRAP_APPLICATION = 15;
    private static final int COUNT_LIMIT_SAME_STACK_TRACE = 5;
    private static final String METHOD_GET_BASE_CONTEXT = "getBaseContext";
    private static final String METHOD_WRAP_CONTEXT = "wrapContextIfNeed";
    private static final String TAG = "Wrapper";
    private static final int TIMELINE_MINIWRAP = 150;
    private static final ThreadLocal<a> sAutoUnWrapModelTL = new ThreadLocal<>();
    private static final List<String> sAutoUnWrapStackList = new CopyOnWriteArrayList();
    private static Map<Context, Context> sResContextCache = new WeakHashMap();

    public static class a {
        private WeakReference<Context> aDW;
        private int aDX;
        private StackTraceElement[] aDY;
        private int aDZ;
        private long aEa;

        private a() {
            this.aDW = new WeakReference<>(null);
            this.aDX = 0;
            this.aDY = null;
            this.aDZ = 0;
        }

        public static /* synthetic */ int c(a aVar) {
            int i = aVar.aDX;
            aVar.aDX = i + 1;
            return i;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void clear() {
            this.aDW = new WeakReference<>(null);
            this.aDX = 0;
            this.aDY = null;
            this.aDZ = 0;
            this.aEa = 0L;
        }

        public static /* synthetic */ int g(a aVar) {
            int i = aVar.aDZ;
            aVar.aDZ = i + 1;
            return i;
        }

        public /* synthetic */ a(byte b) {
            this();
        }
    }

    public static boolean containsAllElements(StackTraceElement[] stackTraceElementArr, StackTraceElement[] stackTraceElementArr2) {
        if (stackTraceElementArr == null || stackTraceElementArr2 == null) {
            return false;
        }
        HashSet hashSet = new HashSet(Arrays.asList(stackTraceElementArr));
        for (StackTraceElement stackTraceElement : stackTraceElementArr2) {
            if (!hashSet.contains(stackTraceElement)) {
                return false;
            }
        }
        return true;
    }

    private static List<String> getAutoUnWrapStackList() {
        List<String> list = sAutoUnWrapStackList;
        if (list.isEmpty()) {
            list.add("com.sensorsdata.analytics.android.sdk");
        }
        return list;
    }

    public static int getThemeResId(Context context) {
        if (!(context instanceof ContextThemeWrapper)) {
            if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
                return ((androidx.appcompat.view.ContextThemeWrapper) context).getThemeResId();
            }
            return 0;
        }
        Object obj = ApiReflect.k(context).cZ("getThemeResId").get();
        if (obj != null) {
            return ((Integer) obj).intValue();
        }
        return 0;
    }

    private static boolean needAutoUnWrap(Context context, a aVar) {
        Context context2 = sResContextCache.get(context);
        String name = context2 != null ? context2.getClass().getName() : "";
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (containsAllElements(stackTrace, aVar.aDY)) {
            a.g(aVar);
            aVar.aDY = stackTrace;
            if (aVar.aDZ < 5) {
                return false;
            }
            Log.d(TAG, "needAutoUnWrap true 连续相同堆栈");
            return true;
        }
        if (aVar.aDY != null) {
            aVar.clear();
            return false;
        }
        aVar.aDY = stackTrace;
        int i = 0;
        int i2 = 0;
        while (i < stackTrace.length) {
            StackTraceElement stackTraceElement = stackTrace[i];
            String className = stackTraceElement.getClassName();
            for (String str : getAutoUnWrapStackList()) {
                if (!TextUtils.isEmpty(str) && className.contains(str)) {
                    Log.d(TAG, "needAutoUnWrap true 命中白名单");
                    return true;
                }
            }
            String methodName = stackTraceElement.getMethodName();
            i++;
            if (i < stackTrace.length && CLAZZ_NAME.equals(className) && METHOD_WRAP_CONTEXT.equals(methodName)) {
                StackTraceElement stackTraceElement2 = stackTrace[i];
                if (TextUtils.equals(name, stackTraceElement2.getClassName()) && METHOD_GET_BASE_CONTEXT.equals(stackTraceElement2.getMethodName()) && (i2 = i2 + 1) >= 5) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void onDestroy(Context context) {
        if (context == null) {
            return;
        }
        sResContextCache.remove(context);
    }

    public static ClassLoader replaceExternalClassLoader(ClassLoader classLoader) {
        ClassLoader externalClassLoader = Loader.get().getExternalClassLoader();
        return externalClassLoader != null ? externalClassLoader : classLoader;
    }

    public static Resources replaceExternalResources(Resources resources) {
        Resources externalResource = Loader.get().getExternalResource();
        return externalResource != null ? externalResource : resources;
    }

    public static Resources.Theme replaceTheme(Resources.Theme theme, Resources.Theme theme2, int i) {
        Resources.Theme theme3 = (Resources.Theme) com.kwad.sdk.api.c.g("WRT", theme, theme2, Integer.valueOf(i));
        if (theme3 != null) {
            return theme3;
        }
        Resources externalResource = Loader.get().getExternalResource();
        if (externalResource == null) {
            return theme;
        }
        if (theme2 != null) {
            return theme2;
        }
        Resources.Theme themeNewTheme = externalResource.newTheme();
        themeNewTheme.applyStyle(i, true);
        return themeNewTheme;
    }

    private static boolean returnUnWrappedContext(Context context) {
        ThreadLocal<a> threadLocal = sAutoUnWrapModelTL;
        a aVar = threadLocal.get();
        byte b = 0;
        if (aVar == null) {
            threadLocal.set(new a(b));
        } else if (aVar.aDW.get() != context || Math.abs(System.currentTimeMillis() - aVar.aEa) >= 150) {
            aVar.clear();
            aVar.aDW = new WeakReference(context);
            aVar.aEa = System.currentTimeMillis();
        } else {
            a.c(aVar);
            if (aVar.aDX >= (context instanceof Application ? 15 : 5) && needAutoUnWrap(context, aVar)) {
                aVar.clear();
                return true;
            }
        }
        return false;
    }

    @Keep
    @Deprecated
    public static Context unwrapContextIfNeed(Context context) {
        Context context2 = (Context) com.kwad.sdk.api.c.g("URC", context);
        if (context2 != null) {
            return context2;
        }
        ResContext resContext = context instanceof ResContext ? (ResContext) context : null;
        Context delegatedContext = context;
        while (delegatedContext instanceof ContextWrapper) {
            if (delegatedContext instanceof Activity) {
                return delegatedContext;
            }
            if (delegatedContext instanceof ResContext) {
                resContext = (ResContext) delegatedContext;
                delegatedContext = resContext.getDelegatedContext();
            } else {
                delegatedContext = ((ContextWrapper) delegatedContext).getBaseContext();
            }
        }
        return resContext != null ? resContext.getDelegatedContext() : context;
    }

    @NonNull
    @Keep
    public static Context wrapContextIfNeed(@Nullable Context context) {
        Context context2 = (Context) com.kwad.sdk.api.c.g("WRC", context);
        if (context2 != null) {
            return context2;
        }
        if (!Loader.get().isExternalLoaded()) {
            return context;
        }
        if (context == null) {
            return null;
        }
        if ((context instanceof ResContext) || returnUnWrappedContext(context)) {
            return context;
        }
        if (context instanceof ContextThemeWrapper) {
            Context context3 = sResContextCache.get(context);
            if (context3 != null) {
                return context3;
            }
            t tVar = new t((ContextThemeWrapper) context);
            sResContextCache.put(context, tVar);
            return tVar;
        }
        if (context instanceof androidx.appcompat.view.ContextThemeWrapper) {
            Context context4 = sResContextCache.get(context);
            if (context4 != null) {
                return context4;
            }
            u uVar = new u((androidx.appcompat.view.ContextThemeWrapper) context);
            sResContextCache.put(context, uVar);
            return uVar;
        }
        if (context instanceof ContextWrapper) {
            Context context5 = sResContextCache.get(context);
            if (context5 != null) {
                return context5;
            }
            v vVar = new v(context);
            sResContextCache.put(context, vVar);
            return vVar;
        }
        Context context6 = sResContextCache.get(context);
        if (context6 != null) {
            return context6;
        }
        v vVar2 = new v(context);
        sResContextCache.put(context, vVar2);
        return vVar2;
    }

    @Keep
    @Deprecated
    public static LayoutInflater wrapInflaterIfNeed(LayoutInflater layoutInflater) {
        LayoutInflater layoutInflater2 = (LayoutInflater) com.kwad.sdk.api.c.g("WRI", layoutInflater);
        if (layoutInflater2 != null) {
            return layoutInflater2;
        }
        if (!Loader.get().isExternalLoaded()) {
            return layoutInflater;
        }
        Context context = layoutInflater.getContext();
        if (context instanceof ResContext) {
            return layoutInflater;
        }
        Context contextWrapContextIfNeed = wrapContextIfNeed(context);
        return contextWrapContextIfNeed instanceof ResContext ? layoutInflater.cloneInContext(contextWrapContextIfNeed) : layoutInflater;
    }

    public static Object wrapSystemService(Object obj, String str, Context context) {
        if (!"layout_inflater".equals(str) || !(obj instanceof LayoutInflater)) {
            return obj;
        }
        LayoutInflater layoutInflater = (LayoutInflater) obj;
        return layoutInflater.getContext() instanceof ResContext ? layoutInflater : layoutInflater.cloneInContext(context);
    }
}
