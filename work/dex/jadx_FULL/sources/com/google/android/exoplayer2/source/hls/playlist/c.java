package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.d;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.offline.StreamKey;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class c extends HlsPlaylist {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30934a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final c f4262a = new c("", Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, Collections.emptyList(), false, Collections.emptyMap(), Collections.emptyList());
    public static final int b = 1;
    public static final int c = 2;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final d f4263a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Map<String, String> f4264a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final List<Uri> f4265b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final List<b> f4266c;
    public final List<a> d;
    public final List<a> e;
    public final List<a> f;
    public final List<a> g;

    @Nullable
    public final List<d> h;
    public final List<DrmInitData> i;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final Uri f30935a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final d f4267a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final String f4268a;
        public final String b;

        public a(@Nullable Uri uri, d dVar, String str, String str2) {
            this.f30935a = uri;
            this.f4267a = dVar;
            this.f4268a = str;
            this.b = str2;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Uri f30936a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final d f4269a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final String f4270a;

        @Nullable
        public final String b;

        @Nullable
        public final String c;

        @Nullable
        public final String d;

        public b(Uri uri, d dVar, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
            this.f30936a = uri;
            this.f4269a = dVar;
            this.f4270a = str;
            this.b = str2;
            this.c = str3;
            this.d = str4;
        }

        public static b b(Uri uri) {
            return new b(uri, new d.b().S("0").K("application/x-mpegURL").E(), null, null, null, null);
        }

        public b a(d dVar) {
            return new b(this.f30936a, dVar, this.f4270a, this.b, this.c, this.d);
        }
    }

    public c(String str, List<String> list, List<b> list2, List<a> list3, List<a> list4, List<a> list5, List<a> list6, @Nullable d dVar, @Nullable List<d> list7, boolean z, Map<String, String> map, List<DrmInitData> list8) {
        super(str, list, z);
        this.f4265b = Collections.unmodifiableList(e(list2, list3, list4, list5, list6));
        this.f4266c = Collections.unmodifiableList(list2);
        this.d = Collections.unmodifiableList(list3);
        this.e = Collections.unmodifiableList(list4);
        this.f = Collections.unmodifiableList(list5);
        this.g = Collections.unmodifiableList(list6);
        this.f4263a = dVar;
        this.h = list7 != null ? Collections.unmodifiableList(list7) : null;
        this.f4264a = Collections.unmodifiableMap(map);
        this.i = Collections.unmodifiableList(list8);
    }

    public static void a(List<a> list, List<Uri> list2) {
        for (int i = 0; i < list.size(); i++) {
            Uri uri = list.get(i).f30935a;
            if (uri != null && !list2.contains(uri)) {
                list2.add(uri);
            }
        }
    }

    public static <T> List<T> c(List<T> list, int i, List<StreamKey> list2) {
        ArrayList arrayList = new ArrayList(list2.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            T t = list.get(i2);
            for (int i3 = 0; i3 < list2.size(); i3++) {
                StreamKey streamKey = list2.get(i3);
                if (streamKey.groupIndex == i && streamKey.streamIndex == i2) {
                    arrayList.add(t);
                    break;
                }
            }
        }
        return arrayList;
    }

    public static c d(String str) {
        return new c("", Collections.emptyList(), Collections.singletonList(b.b(Uri.parse(str))), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), null, null, false, Collections.emptyMap(), Collections.emptyList());
    }

    public static List<Uri> e(List<b> list, List<a> list2, List<a> list3, List<a> list4, List<a> list5) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            Uri uri = list.get(i).f30936a;
            if (!arrayList.contains(uri)) {
                arrayList.add(uri);
            }
        }
        a(list2, arrayList);
        a(list3, arrayList);
        a(list4, arrayList);
        a(list5, arrayList);
        return arrayList;
    }

    @Override // com.google.android.exoplayer2.offline.FilterableManifest
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public c copy(List<StreamKey> list) {
        return new c(((HlsPlaylist) this).f30928a, ((HlsPlaylist) this).f4187a, c(this.f4266c, 0, list), Collections.emptyList(), c(this.e, 1, list), c(this.f, 2, list), Collections.emptyList(), this.f4263a, this.h, ((HlsPlaylist) this).f4188a, this.f4264a, this.i);
    }
}
