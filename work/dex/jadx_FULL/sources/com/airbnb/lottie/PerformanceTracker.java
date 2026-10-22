package com.airbnb.lottie;

import android.util.Log;
import androidx.collection.ArraySet;
import androidx.core.util.Pair;
import com.zj.adlib.rg5;
import com.zj.adlib.vs4;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class PerformanceTracker {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f361a = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Set<FrameListener> f360a = new ArraySet();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<String, rg5> f359a = new HashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Comparator<Pair<String, Float>> f23326a = new a();

    public interface FrameListener {
        void a(float f);
    }

    public class a implements Comparator<Pair<String, Float>> {
        public a() {
        }

        @Override // java.util.Comparator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(Pair<String, Float> pair, Pair<String, Float> pair2) {
            float fFloatValue = pair.second.floatValue();
            float fFloatValue2 = pair2.second.floatValue();
            if (fFloatValue2 > fFloatValue) {
                return 1;
            }
            return fFloatValue > fFloatValue2 ? -1 : 0;
        }
    }

    public void a(FrameListener frameListener) {
        this.f360a.add(frameListener);
    }

    public void b() {
        this.f359a.clear();
    }

    public List<Pair<String, Float>> c() {
        if (!this.f361a) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(this.f359a.size());
        for (Map.Entry<String, rg5> entry : this.f359a.entrySet()) {
            arrayList.add(new Pair(entry.getKey(), Float.valueOf(entry.getValue().b())));
        }
        Collections.sort(arrayList, this.f23326a);
        return arrayList;
    }

    public void d() {
        if (this.f361a) {
            List<Pair<String, Float>> listC = c();
            Log.d(vs4.f20320a, "Render times:");
            for (int i = 0; i < listC.size(); i++) {
                Pair<String, Float> pair = listC.get(i);
                Log.d(vs4.f20320a, String.format("\t\t%30s:%.2f", pair.first, pair.second));
            }
        }
    }

    public void e(String str, float f) {
        if (this.f361a) {
            rg5 rg5Var = this.f359a.get(str);
            if (rg5Var == null) {
                rg5Var = new rg5();
                this.f359a.put(str, rg5Var);
            }
            rg5Var.a(f);
            if (str.equals("__container")) {
                Iterator<FrameListener> it = this.f360a.iterator();
                while (it.hasNext()) {
                    it.next().a(f);
                }
            }
        }
    }

    public void f(FrameListener frameListener) {
        this.f360a.remove(frameListener);
    }

    public void g(boolean z) {
        this.f361a = z;
    }
}
