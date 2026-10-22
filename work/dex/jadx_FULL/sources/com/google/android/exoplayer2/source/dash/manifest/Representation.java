package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.source.dash.DashSegmentIndex;
import com.google.common.collect.ImmutableList;
import com.zj.adlib.ka7;
import com.zj.adlib.ri8;
import com.zj.adlib.rk2;
import com.zj.adlib.sb0;
import com.zj.adlib.vr0;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class Representation {
    public static final long c = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f30892a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final d f3983a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ImmutableList<vr0> f3984a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ka7 f3985a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<rk2> f3986a;
    public final long b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final List<rk2> f3987b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final List<rk2> f3988c;

    public static class b extends Representation implements DashSegmentIndex {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @VisibleForTesting
        public final SegmentBase.MultiSegmentBase f30893a;

        public b(long j, d dVar, List<vr0> list, SegmentBase.MultiSegmentBase multiSegmentBase, @Nullable List<rk2> list2, List<rk2> list3, List<rk2> list4) {
            super(j, dVar, list, multiSegmentBase, list2, list3, list4);
            this.f30893a = multiSegmentBase;
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public boolean a() {
            return this.f30893a.l();
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public long b(long j, long j2) {
            return this.f30893a.f(j, j2);
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public long c(long j, long j2) {
            return this.f30893a.h(j, j2);
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public ka7 d(long j) {
            return this.f30893a.k(this, j);
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public long e(long j, long j2) {
            return this.f30893a.i(j, j2);
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public long f() {
            return this.f30893a.e();
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public long g(long j) {
            return this.f30893a.g(j);
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public long getTimeUs(long j) {
            return this.f30893a.j(j);
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public long h(long j, long j2) {
            return this.f30893a.d(j, j2);
        }

        @Override // com.google.android.exoplayer2.source.dash.DashSegmentIndex
        public long i(long j, long j2) {
            return this.f30893a.c(j, j2);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        @Nullable
        public String j() {
            return null;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        public DashSegmentIndex k() {
            return this;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        @Nullable
        public ka7 l() {
            return null;
        }
    }

    public static class c extends Representation {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f30894a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final ri8 f3989a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final String f3990a;

        @Nullable
        public final ka7 b;
        public final long d;

        public c(long j, d dVar, List<vr0> list, SegmentBase.d dVar2, @Nullable List<rk2> list2, List<rk2> list3, List<rk2> list4, @Nullable String str, long j2) {
            super(j, dVar, list, dVar2, list2, list3, list4);
            this.f30894a = Uri.parse(list.get(0).f20281a);
            ka7 ka7VarC = dVar2.c();
            this.b = ka7VarC;
            this.f3990a = str;
            this.d = j2;
            this.f3989a = ka7VarC != null ? null : new ri8(new ka7(null, 0L, j2));
        }

        public static c p(long j, d dVar, String str, long j2, long j3, long j4, long j5, List<rk2> list, @Nullable String str2, long j6) {
            return new c(j, dVar, ImmutableList.of(new vr0(str)), new SegmentBase.d(new ka7(null, j2, (j3 - j2) + 1), 1L, 0L, j4, (j5 - j4) + 1), list, ImmutableList.of(), ImmutableList.of(), str2, j6);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        @Nullable
        public String j() {
            return this.f3990a;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        @Nullable
        public DashSegmentIndex k() {
            return this.f3989a;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.Representation
        @Nullable
        public ka7 l() {
            return this.b;
        }
    }

    public static Representation n(long j, d dVar, List<vr0> list, SegmentBase segmentBase) {
        return o(j, dVar, list, segmentBase, null, ImmutableList.of(), ImmutableList.of(), null);
    }

    public static Representation o(long j, d dVar, List<vr0> list, SegmentBase segmentBase, @Nullable List<rk2> list2, List<rk2> list3, List<rk2> list4, @Nullable String str) {
        if (segmentBase instanceof SegmentBase.d) {
            return new c(j, dVar, list, (SegmentBase.d) segmentBase, list2, list3, list4, str, -1L);
        }
        if (segmentBase instanceof SegmentBase.MultiSegmentBase) {
            return new b(j, dVar, list, (SegmentBase.MultiSegmentBase) segmentBase, list2, list3, list4);
        }
        throw new IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
    }

    @Nullable
    public abstract String j();

    @Nullable
    public abstract DashSegmentIndex k();

    @Nullable
    public abstract ka7 l();

    @Nullable
    public ka7 m() {
        return this.f3985a;
    }

    public Representation(long j, d dVar, List<vr0> list, SegmentBase segmentBase, @Nullable List<rk2> list2, List<rk2> list3, List<rk2> list4) {
        sb0.a(!list.isEmpty());
        this.f30892a = j;
        this.f3983a = dVar;
        this.f3984a = ImmutableList.copyOf((Collection) list);
        this.f3986a = list2 == null ? Collections.emptyList() : Collections.unmodifiableList(list2);
        this.f3987b = list3;
        this.f3988c = list4;
        this.f3985a = segmentBase.a(this);
        this.b = segmentBase.b();
    }
}
