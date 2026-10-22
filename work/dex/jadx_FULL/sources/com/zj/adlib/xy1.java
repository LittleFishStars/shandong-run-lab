package com.zj.adlib;

import android.os.Bundle;
import com.google.android.exoplayer2.Bundleable;
import com.google.android.exoplayer2.text.Cue;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class xy1 implements Bundleable {
    public static final int K = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ImmutableList<Cue> f20751a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final xy1 f20750a = new xy1(ImmutableList.of());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Bundleable.Creator<xy1> f45918a = new Bundleable.Creator() { // from class: com.zj.adlib.wy1
        @Override // com.google.android.exoplayer2.Bundleable.Creator
        public final Bundleable a(Bundle bundle) {
            return xy1.c(bundle);
        }
    };

    public xy1(List<Cue> list) {
        this.f20751a = ImmutableList.copyOf((Collection) list);
    }

    public static ImmutableList<Cue> b(List<Cue> list) {
        ImmutableList.a aVarBuilder = ImmutableList.builder();
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).f4520a == null) {
                aVarBuilder.a(list.get(i));
            }
        }
        return aVarBuilder.e();
    }

    public static final xy1 c(Bundle bundle) {
        ArrayList parcelableArrayList = bundle.getParcelableArrayList(d(0));
        return new xy1(parcelableArrayList == null ? ImmutableList.of() : a51.b(Cue.f31001a, parcelableArrayList));
    }

    public static String d(int i) {
        return Integer.toString(i, 36);
    }

    @Override // com.google.android.exoplayer2.Bundleable
    public Bundle toBundle() {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(d(0), a51.d(b(this.f20751a)));
        return bundle;
    }
}
