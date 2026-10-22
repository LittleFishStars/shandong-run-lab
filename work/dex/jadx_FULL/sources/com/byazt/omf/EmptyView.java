package com.byazt.omf;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.mapapi.SDKInitializer;
import com.byazt.aas.DeviceUtils;
import com.byazt.aas.nb;
import com.byazt.dna.qp;
import com.byazt.ete.ic;
import com.huachenjie.mall.page.pay.PayResultActivity;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 31, 32})
public class EmptyView extends View implements qp.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public List<View> f28876a;
    public com.byazt.aas.c.tt c;
    public final Handler da;
    public int i;
    public boolean m;
    public boolean my;
    public View n;
    public final AtomicBoolean nu;
    public int rh;
    public final AtomicBoolean sl;
    public List<View> sp;
    public int t;
    public volatile boolean tt;
    public ic u;
    public c uj;
    public volatile boolean ve;
    public List<View> x;
    public String yp;
    public boolean z;

    public interface c {
        void c();

        void c(View view, Map<String, Object> map);

        void c(boolean z);

        void tt();
    }

    @com.byazt.zqa.c(c = {0, 1, 31, 1960})
    public static final class tt implements c {
        public final c c;

        public tt(c cVar) {
            this.c = cVar;
        }

        @Override // com.byazt.omf.EmptyView.c
        public void tt() {
            if (this.c != null) {
                com.byazt.bzd.x.c(new Runnable() { // from class: com.byazt.omf.EmptyView.tt.3
                    @Override // java.lang.Runnable
                    public void run() {
                        tt.this.c.tt();
                    }
                });
            }
        }

        @Override // com.byazt.omf.EmptyView.c
        public void c(final boolean z) {
            if (this.c != null) {
                com.byazt.bzd.x.c(new Runnable() { // from class: com.byazt.omf.EmptyView.tt.1
                    @Override // java.lang.Runnable
                    public void run() {
                        tt.this.c.c(z);
                    }
                });
            }
        }

        @Override // com.byazt.omf.EmptyView.c
        public void c() {
            if (this.c != null) {
                com.byazt.bzd.x.c(new Runnable() { // from class: com.byazt.omf.EmptyView.tt.2
                    @Override // java.lang.Runnable
                    public void run() {
                        tt.this.c.c();
                    }
                });
            }
        }

        @Override // com.byazt.omf.EmptyView.c
        public void c(final View view, final Map<String, Object> map) {
            if (this.c != null) {
                com.byazt.bzd.x.c(new Runnable() { // from class: com.byazt.omf.EmptyView.tt.4
                    @Override // java.lang.Runnable
                    public void run() {
                        tt.this.c.c(view, map);
                    }
                });
            }
        }
    }

    public EmptyView(Context context, View view) {
        super(gt.getContext());
        this.ve = true;
        this.sl = new AtomicBoolean(true);
        this.t = 1000;
        this.z = false;
        this.m = false;
        this.nu = new AtomicBoolean(false);
        this.rh = 0;
        this.my = false;
        this.c = new com.byazt.aas.c.tt() { // from class: com.byazt.omf.EmptyView.6
            @Override // com.byazt.aas.c.tt
            public void onAppBackground() {
                if (!x.m().d() && EmptyView.this.my) {
                    EmptyView.this.my = false;
                    if (EmptyView.this.a()) {
                        com.byazt.rgb.tt.tt(EmptyView.this.getLifecycleId(), 1);
                    }
                    com.byazt.rgb.uj.uj(EmptyView.this.getLifecycleId());
                }
            }

            @Override // com.byazt.aas.c.tt
            public void onAppExit() {
            }

            @Override // com.byazt.aas.c.tt
            public void onAppForeground() {
                if (x.m().d() || EmptyView.this.my) {
                    return;
                }
                EmptyView emptyView = EmptyView.this;
                if (emptyView.c(emptyView.n)) {
                    EmptyView.this.my = true;
                    if (EmptyView.this.a()) {
                        com.byazt.rgb.tt.c(EmptyView.this.getLifecycleId(), 1);
                    }
                    com.byazt.rgb.uj.ve(EmptyView.this.getLifecycleId());
                }
            }

            @Override // com.byazt.aas.c.tt
            public void onAppStart() {
            }
        };
        this.n = view;
        setLayoutParams(new ViewGroup.LayoutParams(0, 0));
        this.da = new com.byazt.nr.d(com.byazt.bzd.x.tt(), this);
        this.z = gt.tt().jl();
        this.m = gt.tt().xx();
    }

    public static /* synthetic */ int a(EmptyView emptyView) {
        int i = emptyView.rh;
        emptyView.rh = i + 1;
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getLifecycleId() {
        ic icVar = this.u;
        if (icVar != null) {
            return icVar.zm();
        }
        return null;
    }

    public void finalize() throws Throwable {
        super.finalize();
        com.byazt.rgb.uj.tt(getLifecycleId(), 3);
    }

    @Override // com.byazt.dna.qp.c
    public void handleMsg(Message message) {
        int iC;
        boolean z = this.z || this.m;
        Object obj = message.obj;
        boolean z2 = (obj instanceof String) && (TextUtils.equals("checkWhenAddToWindow", obj.toString()) || TextUtils.equals("checkWhenClicked", message.obj.toString()));
        if (message.what != 1) {
            return;
        }
        if (this.tt || (z && z2)) {
            if (!this.my && c(this.n)) {
                this.my = true;
                if (a()) {
                    com.byazt.rgb.tt.c(getLifecycleId(), 0);
                }
                if (!sp()) {
                    com.byazt.rgb.uj.ve(getLifecycleId());
                }
            }
            String message2 = null;
            if (!z) {
                if (!zb.tt(this.n, 20, this.i)) {
                    this.da.sendEmptyMessageDelayed(1, this.t);
                    return;
                }
                n();
                c cVar = this.uj;
                if (cVar != null) {
                    cVar.c(this.n, null);
                    return;
                }
                return;
            }
            try {
                iC = zb.c(this.n, 20, this.i);
            } catch (Throwable th) {
                com.byazt.nr.m.c(th);
                message2 = th.getMessage();
                iC = 7;
            }
            if (iC == 0) {
                n();
                if (this.uj != null && !this.nu.get()) {
                    this.nu.set(true);
                    this.uj.c(this.n, c(z2, message));
                }
            } else if (!z2) {
                this.da.sendEmptyMessageDelayed(1, this.t);
            }
            Object obj2 = message.obj;
            if ((obj2 instanceof String) && TextUtils.equals("checkWhenClicked", obj2.toString())) {
                c(iC, message2);
            }
        }
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.nu.set(false);
        uj();
        if (this.z) {
            c("checkWhenAddToWindow");
        }
        if (!this.my && sp()) {
            this.my = true;
            com.byazt.rgb.uj.ve(getLifecycleId());
        }
        tt();
        x.m().ve().c(this.c);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.nu.set(false);
        n();
        if (this.my) {
            this.my = false;
            if (a()) {
                com.byazt.rgb.tt.tt(getLifecycleId(), 0);
            }
            com.byazt.rgb.uj.uj(getLifecycleId());
        }
        ve();
        x.m().ve().tt(this.c);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        View view;
        super.onWindowFocusChanged(z);
        com.byazt.rgb.uj.c(getLifecycleId(), z ? 1 : 2);
        c cVar = this.uj;
        if (cVar != null) {
            cVar.c(z);
        }
        if (!z) {
            if (!this.my || (view = this.n) == null) {
                return;
            }
            view.postDelayed(new Runnable() { // from class: com.byazt.omf.EmptyView.1
                @Override // java.lang.Runnable
                public void run() {
                    if (zb.tt(EmptyView.this.n, 20, EmptyView.this.i)) {
                        return;
                    }
                    EmptyView.this.my = false;
                    com.byazt.rgb.uj.uj(EmptyView.this.getLifecycleId());
                }
            }, 500L);
            return;
        }
        if (this.my || !c(this.n)) {
            return;
        }
        this.my = true;
        com.byazt.rgb.uj.ve(getLifecycleId());
    }

    public void setAdType(int i) {
        this.i = i;
    }

    public void setCallback(c cVar) {
        this.uj = new tt(cVar);
    }

    public void setNeedCheckingShow(final boolean z) {
        this.nu.set(false);
        this.da.post(new Runnable() { // from class: com.byazt.omf.EmptyView.5
            @Override // java.lang.Runnable
            public void run() {
                EmptyView.this.ve = z;
                if (!z && EmptyView.this.tt) {
                    EmptyView.this.n();
                } else {
                    if (!z || EmptyView.this.tt) {
                        return;
                    }
                    EmptyView.this.uj();
                }
            }
        });
    }

    public void setRefClickViews(List<View> list) {
        this.f28876a = list;
    }

    public void setRefCreativeViews(List<View> list) {
        this.sp = list;
    }

    public void setRefDirectDownloadViews(List<View> list) {
        this.x = list;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a() {
        int i = this.i;
        return i == 1 || i == 5 || i == 9;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n() {
        this.da.post(new Runnable() { // from class: com.byazt.omf.EmptyView.4
            @Override // java.lang.Runnable
            public void run() {
                EmptyView.this.tt = false;
                EmptyView.this.da.removeMessages(1);
            }
        });
    }

    private boolean sp() {
        int i = this.i;
        return i == 7 || i == 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uj() {
        this.da.post(new Runnable() { // from class: com.byazt.omf.EmptyView.2
            @Override // java.lang.Runnable
            public void run() {
                if (!EmptyView.this.ve || EmptyView.this.tt) {
                    return;
                }
                EmptyView.this.tt = true;
                EmptyView.a(EmptyView.this);
                Message messageObtain = Message.obtain();
                messageObtain.what = 1;
                EmptyView.this.da.handleMessage(messageObtain);
            }
        });
    }

    private void tt() {
        if (this.sl.getAndSet(false)) {
            com.byazt.rgb.uj.tt(getLifecycleId());
            c cVar = this.uj;
            if (cVar != null) {
                cVar.c();
            }
        }
    }

    private void ve() {
        if (this.sl.getAndSet(true)) {
            return;
        }
        com.byazt.rgb.uj.n(getLifecycleId());
        c cVar = this.uj;
        if (cVar != null) {
            cVar.tt();
        }
    }

    public void c() {
        c(this.f28876a, (com.byazt.hkv.uj) null);
        c(this.sp, (com.byazt.hkv.uj) null);
        c(this.x, (com.byazt.hkv.uj) null);
    }

    public void c(List<View> list, com.byazt.hkv.uj ujVar) {
        if (com.byazt.nr.u.tt(list)) {
            for (View view : list) {
                if (view != null) {
                    view.setOnClickListener(ujVar);
                    view.setOnTouchListener(ujVar);
                }
            }
        }
    }

    public void c(final String str) {
        this.da.post(new Runnable() { // from class: com.byazt.omf.EmptyView.3
            @Override // java.lang.Runnable
            public void run() {
                if (TextUtils.equals(str, "checkWhenClicked")) {
                    if (!EmptyView.this.ve) {
                        EmptyView.this.c(8, (String) null);
                    }
                    if (!EmptyView.this.tt) {
                        EmptyView.this.c(EmptyView.this.nu.get() ? 10 : 9, (String) null);
                    }
                }
                Message messageObtain = Message.obtain();
                messageObtain.what = 1;
                messageObtain.obj = str;
                EmptyView.this.da.handleMessage(messageObtain);
            }
        });
    }

    public void c(ic icVar, String str) {
        this.u = icVar;
        this.yp = str;
        if (icVar != null) {
            String strValueOf = String.valueOf(nb.t(icVar));
            int iSl = nb.sl(icVar);
            if (this.i == 0) {
                this.i = iSl;
            }
            com.byazt.rgb.uj.c(icVar, strValueOf, iSl, getLifecycleId());
        }
    }

    public EmptyView(Context context, View view, int i) {
        this(context, view);
        this.t = i;
    }

    private Map<String, Object> c(boolean z, Message message) {
        if (!z) {
            return null;
        }
        HashMap map = new HashMap();
        if (TextUtils.equals("checkWhenAddToWindow", message.obj.toString())) {
            map.put("show_send_type", 2);
        } else if (TextUtils.equals("checkWhenClicked", message.obj.toString())) {
            map.put("show_send_type", 1);
        }
        return map;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, String str) {
        HashMap map = new HashMap();
        if (i == 0) {
            map.put(PayResultActivity.t, Boolean.TRUE);
        } else {
            map.put(PayResultActivity.t, Boolean.FALSE);
            if (i != 7) {
                str = zb.c(i);
            }
            map.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, Integer.valueOf(i));
            map.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_MESSAGE, str);
        }
        map.put("checking_cnt", Integer.valueOf(this.rh));
        com.byazt.ddx.uj.c(this.u, this.yp, map);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(View view) {
        try {
            return DeviceUtils.c() && view != null && view.isShown();
        } catch (Throwable unused) {
        }
    }
}
