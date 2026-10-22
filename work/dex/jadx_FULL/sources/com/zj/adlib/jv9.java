package com.zj.adlib;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.Subtitle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class jv9 implements Subtitle {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<cv9> f42683a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long[] f17506a;
    public final long[] b;

    public jv9(List<cv9> list) {
        this.f42683a = Collections.unmodifiableList(new ArrayList(list));
        this.f17506a = new long[list.size() * 2];
        for (int i = 0; i < list.size(); i++) {
            cv9 cv9Var = list.get(i);
            int i2 = i * 2;
            long[] jArr = this.f17506a;
            jArr[i2] = cv9Var.f41049a;
            jArr[i2 + 1] = cv9Var.b;
        }
        long[] jArr2 = this.f17506a;
        long[] jArrCopyOf = Arrays.copyOf(jArr2, jArr2.length);
        this.b = jArrCopyOf;
        Arrays.sort(jArrCopyOf);
    }

    public static /* synthetic */ int b(cv9 cv9Var, cv9 cv9Var2) {
        return Long.compare(cv9Var.f41049a, cv9Var2.f41049a);
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public List<Cue> getCues(long j) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (int i = 0; i < this.f42683a.size(); i++) {
            long[] jArr = this.f17506a;
            int i2 = i * 2;
            if (jArr[i2] <= j && j < jArr[i2 + 1]) {
                cv9 cv9Var = this.f42683a.get(i);
                Cue cue = cv9Var.f15893a;
                if (cue.f4519a == -3.4028235E38f) {
                    arrayList2.add(cv9Var);
                } else {
                    arrayList.add(cue);
                }
            }
        }
        Collections.sort(arrayList2, new Comparator() { // from class: com.zj.adlib.iv9
            @Override // java.util.Comparator
            public final int compare(Object obj, Object obj2) {
                return jv9.b((cv9) obj, (cv9) obj2);
            }
        });
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            arrayList.add(((cv9) arrayList2.get(i3)).f15893a.b().t((-1) - i3, 1).a());
        }
        return arrayList;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public long getEventTime(int i) {
        sb0.a(i >= 0);
        sb0.a(i < this.b.length);
        return this.b[i];
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getEventTimeCount() {
        return this.b.length;
    }

    @Override // com.google.android.exoplayer2.text.Subtitle
    public int getNextEventTimeIndex(long j) {
        int iF = gj9.f(this.b, j, false, false);
        if (iF < this.b.length) {
            return iF;
        }
        return -1;
    }
}
