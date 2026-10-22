package com.ipd.dsp.internal.g1;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import com.ipd.dsp.Dsp;
import com.ipd.dsp.internal.c2.k;
import com.ipd.dsp.internal.c2.o;
import com.ipd.dsp.internal.e1.m;
import com.ipd.dsp.request.DspAdRequest;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public abstract class c<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f38309a;
    public String b;
    public String c;
    public String d;
    public int e = 1;
    public boolean f;
    public int g;

    public interface b<T> {
        @WorkerThread
        void a(@Nullable T t, int i);
    }

    public abstract List<T> a(@NonNull List<com.ipd.dsp.internal.e1.d> list);

    public abstract void a(int i, @NonNull String str);

    public void a(m mVar, b<List<T>> bVar) {
    }

    public abstract void c(@NonNull List<T> list);

    public abstract void d(@NonNull List<? extends com.ipd.dsp.internal.e1.d> list);

    public class a implements com.ipd.dsp.internal.y1.b.a {
        public a() {
        }

        @Override // com.ipd.dsp.internal.y1.b.a
        public void a(String str) {
            Pair<List<com.ipd.dsp.internal.e1.d>, List<m>> pairA = com.ipd.dsp.internal.e1.e.a(str, c.this.f38309a, c.this.b, c.this.c, c.this.d);
            c.this.a((List<com.ipd.dsp.internal.e1.d>) pairA.first, (List<m>) pairA.second);
        }

        @Override // com.ipd.dsp.internal.y1.b.a
        public void a(int i, String str, Throwable th) {
            c.this.a(i, str);
            if (Dsp.isDebugLogEnable()) {
                k.e("BAL", "req error", th);
            }
        }
    }

    public void b(int i) {
        this.e = i;
        int iMin = Math.min(6, i);
        this.e = iMin;
        this.e = Math.max(1, iMin);
    }

    public void a(DspAdRequest dspAdRequest, String str) {
        this.c = str;
        this.f38309a = dspAdRequest.getAppId();
        this.b = dspAdRequest.getPosId();
        this.d = dspAdRequest.getUserId();
        this.f = dspAdRequest.isDownloadConfirm();
        this.g = Math.max(0, dspAdRequest.getBidFloor());
    }

    public final /* synthetic */ void b(List list) {
        if (list.isEmpty()) {
            com.ipd.dsp.internal.f1.a aVarI = com.ipd.dsp.internal.f1.a.i();
            a(aVarI.f38306a, aVarI.b);
        } else {
            c(list);
        }
    }

    public void a() {
        a((HashMap<String, Object>) null, 5);
    }

    public final /* synthetic */ void b(final List list, final List list2, final int i) {
        a(new Runnable() { // from class: com.zj.adlib.wpa
            @Override // java.lang.Runnable
            public final void run() {
                this.f45657a.a(list2, list, i);
            }
        });
    }

    public void a(int i) {
        a((HashMap<String, Object>) null, i);
    }

    public void a(HashMap<String, Object> map) {
        a(map, 3);
    }

    public void a(HashMap<String, Object> map, int i) {
        HashMap map2 = new HashMap();
        map2.put(MediationConstant.EXTRA_ADID, this.b);
        map2.put("ad_type", this.c);
        map2.put("appid", TextUtils.isEmpty(this.f38309a) ? Dsp.getAppId() : this.f38309a);
        int i2 = this.e;
        if (i2 > 1) {
            map2.put("ad_num", Integer.valueOf(i2));
        }
        if (!TextUtils.isEmpty(this.d)) {
            try {
                map2.put("user_id_o", o.d(URLEncoder.encode(this.d, "utf-8")));
            } catch (Throwable unused) {
            }
        }
        map2.put("floor_price", Integer.valueOf(this.g));
        map2.put("psr", Integer.valueOf(com.ipd.dsp.internal.l1.a.a().getPersonalRecommend() ? 1 : 0));
        map2.put("pgr", Integer.valueOf(com.ipd.dsp.internal.l1.a.a().getProgrammaticRecommend() ? 1 : 0));
        if (map != null) {
            map2.putAll(map);
        }
        map2.putAll(com.ipd.dsp.internal.c2.g.a().h());
        com.ipd.dsp.internal.y1.b.a(new com.ipd.dsp.internal.b2.a(map2, i, new a()));
    }

    @WorkerThread
    public final void a(List<com.ipd.dsp.internal.e1.d> list, List<m> list2) {
        m mVar;
        d(list);
        d(list2);
        final List<T> listA = a(list);
        if (!list2.isEmpty() && (mVar = list2.get(0)) != null) {
            a(mVar, new b() { // from class: com.zj.adlib.xoa
                @Override // com.ipd.dsp.internal.g1.c.b
                public final void a(Object obj, int i) {
                    this.f45865a.b(listA, (List) obj, i);
                }
            });
        } else {
            a(new Runnable() { // from class: com.zj.adlib.npa
                @Override // java.lang.Runnable
                public final void run() {
                    this.f43585a.b(listA);
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final /* synthetic */ void a(List list, List list2, int i) {
        if (list != null && !list.isEmpty()) {
            if (list2.isEmpty()) {
                c(list);
                return;
            }
            Object obj = list2.get(0);
            if ((obj instanceof com.ipd.dsp.internal.g1.a ? Math.min(0, ((com.ipd.dsp.internal.g1.a) obj).b()) : 0) >= i) {
                list = list2;
            }
            c(list);
            return;
        }
        if (!list2.isEmpty()) {
            c(list2);
        } else {
            com.ipd.dsp.internal.f1.a aVarI = com.ipd.dsp.internal.f1.a.i();
            a(aVarI.f38306a, aVarI.b);
        }
    }

    public final void a(Runnable runnable) {
        new Handler(Looper.getMainLooper()).post(runnable);
    }
}
