package com.zj.adlib;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.offline.FilterableManifest;
import com.google.android.exoplayer2.offline.StreamKey;
import com.google.android.exoplayer2.source.dash.manifest.Representation;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class c62 implements FilterableManifest<c62> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f40908a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Uri f15738a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final c68 f15739a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final f17 f15740a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final yi9 f15741a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<eo6> f15742a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f15743a;
    public final long b;
    public final long c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;

    public c62(long j, long j2, long j3, boolean z, long j4, long j5, long j6, long j7, @Nullable f17 f17Var, @Nullable yi9 yi9Var, @Nullable c68 c68Var, @Nullable Uri uri, List<eo6> list) {
        this.f40908a = j;
        this.b = j2;
        this.c = j3;
        this.f15743a = z;
        this.d = j4;
        this.e = j5;
        this.f = j6;
        this.g = j7;
        this.f15740a = f17Var;
        this.f15741a = yi9Var;
        this.f15738a = uri;
        this.f15739a = c68Var;
        this.f15742a = list == null ? Collections.emptyList() : list;
    }

    public static ArrayList<vz> b(List<vz> list, LinkedList<StreamKey> linkedList) {
        StreamKey streamKeyPoll = linkedList.poll();
        int i = streamKeyPoll.periodIndex;
        ArrayList<vz> arrayList = new ArrayList<>();
        do {
            int i2 = streamKeyPoll.groupIndex;
            vz vzVar = list.get(i2);
            List<Representation> list2 = vzVar.f20347a;
            ArrayList arrayList2 = new ArrayList();
            do {
                arrayList2.add(list2.get(streamKeyPoll.streamIndex));
                streamKeyPoll = linkedList.poll();
                if (streamKeyPoll.periodIndex != i) {
                    break;
                }
            } while (streamKeyPoll.groupIndex == i2);
            arrayList.add(new vz(vzVar.f45491a, vzVar.b, arrayList2, vzVar.f20348b, vzVar.f20349c, vzVar.d));
        } while (streamKeyPoll.periodIndex == i);
        linkedList.addFirst(streamKeyPoll);
        return arrayList;
    }

    @Override // com.google.android.exoplayer2.offline.FilterableManifest
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public final c62 copy(List<StreamKey> list) {
        LinkedList linkedList = new LinkedList(list);
        Collections.sort(linkedList);
        linkedList.add(new StreamKey(-1, -1, -1));
        ArrayList arrayList = new ArrayList();
        long j = 0;
        int i = 0;
        while (true) {
            if (i >= d()) {
                break;
            }
            if (((StreamKey) linkedList.peek()).periodIndex != i) {
                long jE = e(i);
                if (jE != -9223372036854775807L) {
                    j += jE;
                }
            } else {
                eo6 eo6VarC = c(i);
                arrayList.add(new eo6(eo6VarC.f16369a, eo6VarC.f41481a - j, b(eo6VarC.f16370a, linkedList), eo6VarC.b));
            }
            i++;
        }
        long j2 = this.b;
        return new c62(this.f40908a, j2 != -9223372036854775807L ? j2 - j : -9223372036854775807L, this.c, this.f15743a, this.d, this.e, this.f, this.g, this.f15740a, this.f15741a, this.f15739a, this.f15738a, arrayList);
    }

    public final eo6 c(int i) {
        return this.f15742a.get(i);
    }

    public final int d() {
        return this.f15742a.size();
    }

    public final long e(int i) {
        long j;
        long j2;
        if (i == this.f15742a.size() - 1) {
            j = this.b;
            if (j == -9223372036854775807L) {
                return -9223372036854775807L;
            }
            j2 = this.f15742a.get(i).f41481a;
        } else {
            j = this.f15742a.get(i + 1).f41481a;
            j2 = this.f15742a.get(i).f41481a;
        }
        return j - j2;
    }

    public final long f(int i) {
        return gj9.Z0(e(i));
    }
}
