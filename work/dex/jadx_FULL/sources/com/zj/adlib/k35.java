package com.zj.adlib;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.Cancellable;
import com.airbnb.lottie.LottieListener;
import com.airbnb.lottie.OnCompositionLoadedListener;
import com.airbnb.lottie.PerformanceTracker;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.parser.moshi.JsonReader;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class k35 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f42734a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Rect f17565a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public LongSparseArray<Layer> f17566a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public SparseArrayCompat<nk3> f17567a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<b85> f17570a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Map<String, List<Layer>> f17571a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f17572a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public List<Layer> f17573b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public Map<String, b45> f17574b;
    public float c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public Map<String, kk3> f17575c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PerformanceTracker f17568a = new PerformanceTracker();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final HashSet<String> f17569a = new HashSet<>();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f17564a = 0;

    @Deprecated
    public static class b {

        public static final class a implements LottieListener<k35>, Cancellable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final OnCompositionLoadedListener f42735a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public boolean f17576a;

            @Override // com.airbnb.lottie.LottieListener
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public void onResult(k35 k35Var) {
                if (this.f17576a) {
                    return;
                }
                this.f42735a.a(k35Var);
            }

            @Override // com.airbnb.lottie.Cancellable
            public void cancel() {
                this.f17576a = true;
            }

            private a(OnCompositionLoadedListener onCompositionLoadedListener) {
                this.f17576a = false;
                this.f42735a = onCompositionLoadedListener;
            }
        }

        @Deprecated
        public static Cancellable a(Context context, String str, OnCompositionLoadedListener onCompositionLoadedListener) {
            a aVar = new a(onCompositionLoadedListener);
            x35.o(context, str).d(aVar);
            return aVar;
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static k35 b(Context context, String str) {
            return x35.q(context, str).b();
        }

        @Deprecated
        public static Cancellable c(InputStream inputStream, OnCompositionLoadedListener onCompositionLoadedListener) {
            a aVar = new a(onCompositionLoadedListener);
            x35.t(inputStream, null).d(aVar);
            return aVar;
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static k35 d(InputStream inputStream) {
            return x35.u(inputStream, null).b();
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static k35 e(InputStream inputStream, boolean z) {
            if (z) {
                g25.e("Lottie now auto-closes input stream!");
            }
            return x35.u(inputStream, null).b();
        }

        @Deprecated
        public static Cancellable f(JsonReader jsonReader, OnCompositionLoadedListener onCompositionLoadedListener) {
            a aVar = new a(onCompositionLoadedListener);
            x35.w(jsonReader, null).d(aVar);
            return aVar;
        }

        @Deprecated
        public static Cancellable g(String str, OnCompositionLoadedListener onCompositionLoadedListener) {
            a aVar = new a(onCompositionLoadedListener);
            x35.z(str, null).d(aVar);
            return aVar;
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static k35 h(Resources resources, JSONObject jSONObject) {
            return x35.B(jSONObject, null).b();
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static k35 i(JsonReader jsonReader) {
            return x35.x(jsonReader, null).b();
        }

        @Nullable
        @WorkerThread
        @Deprecated
        public static k35 j(String str) {
            return x35.A(str, null).b();
        }

        @Deprecated
        public static Cancellable k(Context context, @RawRes int i, OnCompositionLoadedListener onCompositionLoadedListener) {
            a aVar = new a(onCompositionLoadedListener);
            x35.C(context, i).d(aVar);
            return aVar;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void a(String str) {
        g25.e(str);
        this.f17569a.add(str);
    }

    public Rect b() {
        return this.f17565a;
    }

    public SparseArrayCompat<nk3> c() {
        return this.f17567a;
    }

    public float d() {
        return (long) ((e() / this.c) * 1000.0f);
    }

    public float e() {
        return this.b - this.f42734a;
    }

    public float f() {
        return this.b;
    }

    public Map<String, kk3> g() {
        return this.f17575c;
    }

    public float h(float f) {
        return up5.k(this.f42734a, this.b, f);
    }

    public float i() {
        return this.c;
    }

    public Map<String, b45> j() {
        return this.f17574b;
    }

    public List<Layer> k() {
        return this.f17573b;
    }

    @Nullable
    public b85 l(String str) {
        int size = this.f17570a.size();
        for (int i = 0; i < size; i++) {
            b85 b85Var = this.f17570a.get(i);
            if (b85Var.d(str)) {
                return b85Var;
            }
        }
        return null;
    }

    public List<b85> m() {
        return this.f17570a;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public int n() {
        return this.f17564a;
    }

    public PerformanceTracker o() {
        return this.f17568a;
    }

    @Nullable
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public List<Layer> p(String str) {
        return this.f17571a.get(str);
    }

    public float q(float f) {
        float f2 = this.f42734a;
        return (f - f2) / (this.b - f2);
    }

    public float r() {
        return this.f42734a;
    }

    public ArrayList<String> s() {
        HashSet<String> hashSet = this.f17569a;
        return new ArrayList<>(Arrays.asList((String[]) hashSet.toArray(new String[hashSet.size()])));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean t() {
        return this.f17572a;
    }

    @NonNull
    public String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator<Layer> it = this.f17573b.iterator();
        while (it.hasNext()) {
            sb.append(it.next().y("\t"));
        }
        return sb.toString();
    }

    public boolean u() {
        return !this.f17574b.isEmpty();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void v(int i) {
        this.f17564a += i;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void w(Rect rect, float f, float f2, float f3, List<Layer> list, LongSparseArray<Layer> longSparseArray, Map<String, List<Layer>> map, Map<String, b45> map2, SparseArrayCompat<nk3> sparseArrayCompat, Map<String, kk3> map3, List<b85> list2) {
        this.f17565a = rect;
        this.f42734a = f;
        this.b = f2;
        this.c = f3;
        this.f17573b = list;
        this.f17566a = longSparseArray;
        this.f17571a = map;
        this.f17574b = map2;
        this.f17567a = sparseArrayCompat;
        this.f17575c = map3;
        this.f17570a = list2;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public Layer x(long j) {
        return this.f17566a.get(j);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public void y(boolean z) {
        this.f17572a = z;
    }

    public void z(boolean z) {
        this.f17568a.g(z);
    }
}
