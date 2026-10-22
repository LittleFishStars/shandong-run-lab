package com.byazt.yc;

import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.content.Context;
import com.byazt.rb.n;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1136, 20})
public abstract class c {
    public Context c;
    public com.byazt.xj.ve sp;
    public String tt;
    public n uj;
    public Map<Float, String> ve;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<PropertyValuesHolder> f29198a = new ArrayList();
    public List<Keyframe> n = new ArrayList();

    public c(Context context, com.byazt.xj.ve veVar, String str, Map<Float, String> map) {
        this.c = context;
        this.tt = str;
        this.ve = map;
        this.uj = n.c(this.tt);
        this.sp = veVar;
    }

    public abstract TypeEvaluator a();

    public abstract void c(float f, String str);

    public boolean c() {
        Map<Float, String> map = this.ve;
        if (map == null || map.size() <= 0) {
            return false;
        }
        return this.ve.containsKey(Float.valueOf(0.0f));
    }

    public String getType() {
        return this.uj.ve();
    }

    public List<PropertyValuesHolder> n() {
        String strTt = this.uj.tt();
        uj();
        PropertyValuesHolder propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe(strTt, (Keyframe[]) this.n.toArray(new Keyframe[0]));
        TypeEvaluator typeEvaluatorA = a();
        if (typeEvaluatorA != null) {
            propertyValuesHolderOfKeyframe.setEvaluator(typeEvaluatorA);
        }
        this.f29198a.add(propertyValuesHolderOfKeyframe);
        return this.f29198a;
    }

    public abstract void tt();

    public void uj() {
        Map<Float, String> map = this.ve;
        if (map == null || map.size() <= 0) {
            return;
        }
        if (!c()) {
            tt();
        }
        for (Map.Entry<Float, String> entry : this.ve.entrySet()) {
            if (entry != null) {
                c(entry.getKey().floatValue() / 100.0f, entry.getValue());
            }
        }
        ve();
    }

    public void ve() {
        Map<Float, String> map = this.ve;
        if (map == null || map.size() <= 0) {
            return;
        }
        Map<Float, String> map2 = this.ve;
        if (map2 instanceof TreeMap) {
            float fFloatValue = ((Float) ((TreeMap) map2).lastKey()).floatValue();
            if (fFloatValue != 100.0f) {
                c(100.0f, this.ve.get(Float.valueOf(fFloatValue)));
            }
        }
    }
}
