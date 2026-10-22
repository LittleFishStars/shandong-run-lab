package com.byazt.yc;

import android.animation.FloatEvaluator;
import android.animation.Keyframe;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.content.Context;
import android.text.TextUtils;
import com.byazt.cd.x;
import com.byazt.nr.m;
import com.byazt.rb.n;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1136, 15})
public class uj extends c {
    public List<Keyframe> x;

    /* JADX INFO: renamed from: com.byazt.yc.uj$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 1136, 99})
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[n.values().length];
            c = iArr;
            try {
                iArr[n.TRANSLATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[n.SCALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public uj(Context context, com.byazt.xj.ve veVar, String str, Map<Float, String> map) {
        super(context, veVar, str, map);
        this.x = new ArrayList();
    }

    @Override // com.byazt.yc.c
    public TypeEvaluator a() {
        return new FloatEvaluator();
    }

    @Override // com.byazt.yc.c
    public void c(float f, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            if (jSONArray.length() != 2) {
                return;
            }
            float fOptDouble = (float) jSONArray.optDouble(0);
            float fOptDouble2 = (float) jSONArray.optDouble(1);
            if (this.uj == n.TRANSLATE) {
                fOptDouble = x.c(this.c, fOptDouble);
                fOptDouble2 = x.c(this.c, fOptDouble2);
            }
            this.n.add(Keyframe.ofFloat(f, fOptDouble));
            this.x.add(Keyframe.ofFloat(f, fOptDouble2));
        } catch (JSONException e) {
            m.c(e);
        }
    }

    @Override // com.byazt.yc.c
    public List<PropertyValuesHolder> n() {
        String strTt = this.uj.tt();
        uj();
        PropertyValuesHolder propertyValuesHolderOfKeyframe = PropertyValuesHolder.ofKeyframe(strTt + "X", (Keyframe[]) this.n.toArray(new Keyframe[0]));
        this.f29198a.add(propertyValuesHolderOfKeyframe);
        PropertyValuesHolder propertyValuesHolderOfKeyframe2 = PropertyValuesHolder.ofKeyframe(strTt + "Y", (Keyframe[]) this.x.toArray(new Keyframe[0]));
        this.f29198a.add(propertyValuesHolderOfKeyframe2);
        TypeEvaluator typeEvaluatorA = a();
        if (typeEvaluatorA != null) {
            propertyValuesHolderOfKeyframe.setEvaluator(typeEvaluatorA);
            propertyValuesHolderOfKeyframe2.setEvaluator(typeEvaluatorA);
        }
        return this.f29198a;
    }

    @Override // com.byazt.yc.c
    public void tt() {
        Keyframe keyframeOfFloat;
        Keyframe keyframeOfFloat2;
        int i = AnonymousClass1.c[this.uj.ordinal()];
        if (i == 1) {
            keyframeOfFloat = Keyframe.ofFloat(0.0f, this.sp.u());
            keyframeOfFloat2 = Keyframe.ofFloat(0.0f, this.sp.yp());
        } else if (i != 2) {
            keyframeOfFloat = null;
            keyframeOfFloat2 = null;
        } else {
            keyframeOfFloat = Keyframe.ofFloat(0.0f, this.sp.z());
            keyframeOfFloat2 = Keyframe.ofFloat(0.0f, this.sp.m());
        }
        if (keyframeOfFloat != null) {
            this.n.add(keyframeOfFloat);
        }
        if (keyframeOfFloat2 != null) {
            this.x.add(keyframeOfFloat2);
        }
    }
}
