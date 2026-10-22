package com.byazt.oz;

import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.widget.ImageView;
import com.byazt.pc.i;
import com.byazt.yj.da;
import com.byazt.yj.gr;
import com.byazt.yj.gt;
import com.byazt.yj.m;
import com.byazt.yj.or;
import com.byazt.yj.t;
import com.byazt.yj.yp;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 213, 54})
public final class ve implements t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ImageView.ScaleType f28930a;
    public Future<?> c;
    public boolean d;
    public da da;
    public gt eo;
    public com.byazt.oz.c gr;
    public boolean gt;
    public a gu;
    public ExecutorService h;
    public int i;
    public or m;
    public boolean md;
    public final Handler my;
    public gr n;
    public int nu;
    public int p;
    public int qy;
    public Queue<i> rh;
    public com.byazt.yj.x rl;
    public int sl;
    public Bitmap.Config sp;
    public WeakReference<ImageView> t;
    public String tt;
    public volatile boolean u;
    public String uj;
    public String ve;
    public int x;
    public boolean yp;
    public int yv;
    public boolean z;
    public boolean zb;
    public com.byazt.yj.tt zm;

    @com.byazt.zqa.c(c = {0, 1, 213, 24})
    public class c implements gr {
        public gr tt;

        public c(gr grVar) {
            this.tt = grVar;
        }

        @Override // com.byazt.yj.gr
        public void onFailed(final int i, final String str, final Throwable th) {
            if (ve.this.nu == 5) {
                ve.this.my.post(new Runnable() { // from class: com.byazt.oz.ve.c.3
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.tt != null) {
                            c.this.tt.onFailed(i, str, th);
                        }
                    }
                });
                return;
            }
            gr grVar = this.tt;
            if (grVar != null) {
                grVar.onFailed(i, str, th);
            }
        }

        @Override // com.byazt.yj.gr
        public void onSuccess(final m mVar) {
            Bitmap bitmapCoverterTo;
            final ImageView imageView = (ImageView) ve.this.t.get();
            if (imageView != null && ve.this.sl != 3 && c(imageView) && (mVar.getResult() instanceof Bitmap)) {
                final Bitmap bitmap = (Bitmap) mVar.getResult();
                ve.this.my.post(new Runnable() { // from class: com.byazt.oz.ve.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
            try {
                if (ve.this.da != null && (mVar.getResult() instanceof Bitmap) && (bitmapCoverterTo = ve.this.da.coverterTo((Bitmap) mVar.getResult())) != null) {
                    mVar.setResult(bitmapCoverterTo);
                }
            } catch (Throwable unused) {
            }
            if (ve.this.nu == 5) {
                ve.this.my.postAtFrontOfQueue(new Runnable() { // from class: com.byazt.oz.ve.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        if (c.this.tt != null) {
                            c.this.tt.onSuccess(mVar);
                        }
                    }
                });
                return;
            }
            gr grVar = this.tt;
            if (grVar != null) {
                grVar.onSuccess(mVar);
            }
        }

        private boolean c(ImageView imageView) {
            Object tag;
            return (imageView == null || (tag = imageView.getTag(1094453505)) == null || !tag.equals(ve.this.ve)) ? false : true;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public t rh() {
        try {
            a aVar = this.gu;
            if (aVar == null) {
                gr grVar = this.n;
                if (grVar != null) {
                    grVar.onFailed(1005, "not init !", null);
                }
                return this;
            }
            ExecutorService executorServiceA = this.h == null ? aVar.a() : null;
            Runnable runnable = new Runnable() { // from class: com.byazt.oz.ve.1
                @Override // java.lang.Runnable
                public void run() {
                    i iVar;
                    while (!ve.this.u && (iVar = (i) ve.this.rh.poll()) != null) {
                        try {
                            if (ve.this.m != null) {
                                ve.this.m.onStepStart(iVar.c(), ve.this);
                            }
                            iVar.c(ve.this);
                            if (ve.this.m != null) {
                                ve.this.m.onStepEnd(iVar.c(), ve.this);
                            }
                        } catch (Throwable th) {
                            ve.this.c(2000, th.getMessage(), th);
                            if (ve.this.m != null) {
                                ve.this.m.onStepEnd(com.alibaba.triver.triver_render.view.canvas.tinyapp.c.f25231a, ve.this);
                                return;
                            }
                            return;
                        }
                    }
                    if (ve.this.u) {
                        ve.this.c(1003, "canceled", null);
                    }
                }
            };
            if (this.d) {
                runnable.run();
            } else {
                ExecutorService executorService = this.h;
                if (executorService != null) {
                    this.c = executorService.submit(runnable);
                } else if (executorServiceA != null) {
                    this.c = executorServiceA.submit(runnable);
                }
            }
            return this;
        } catch (Exception e) {
            com.byazt.nr.m.uj("ImageRequest", e.getMessage());
        }
    }

    @Override // com.byazt.yj.t
    public boolean cancelRequest() {
        this.u = true;
        Future<?> future = this.c;
        if (future != null) {
            return future.cancel(true);
        }
        return true;
    }

    @Override // com.byazt.yj.t
    public Bitmap.Config getBitmapConfig() {
        return this.sp;
    }

    @Override // com.byazt.yj.t
    public int getHeight() {
        return this.i;
    }

    @Override // com.byazt.yj.t
    public String getMemoryCacheKey() {
        return this.ve;
    }

    @Override // com.byazt.yj.t
    public String getRawCacheKey() {
        return this.uj;
    }

    @Override // com.byazt.yj.t
    public ImageView.ScaleType getScaleType() {
        return this.f28930a;
    }

    @Override // com.byazt.yj.t
    public String getUrl() {
        return this.tt;
    }

    @Override // com.byazt.yj.t
    public int getWidth() {
        return this.x;
    }

    public gt m() {
        return this.eo;
    }

    public String nu() {
        return getRawCacheKey();
    }

    public int sl() {
        return this.qy;
    }

    public com.byazt.oz.c t() {
        return this.gr;
    }

    public a u() {
        return this.gu;
    }

    public com.byazt.yj.tt yp() {
        return this.zm;
    }

    public boolean z() {
        return this.md;
    }

    @com.byazt.zqa.c(c = {0, 1, 213, MediaPlayer.MEDIA_PLAYER_OPTION_SET_LIVE_ABR_NON_KEY_FRAME_SWITCH_BUFFER_THRESHOLD})
    public static class tt implements yp {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public Bitmap.Config f28931a;
        public gr c;
        public boolean gr;
        public boolean gt;
        public gt gu;
        public a m;
        public int my;
        public ImageView.ScaleType n;
        public da nu;
        public boolean qy;
        public int rh;
        public ExecutorService rl;
        public or sl;
        public int sp;
        public boolean t;
        public ImageView tt;
        public boolean u;
        public String uj;
        public String ve;
        public int x;
        public String yp;
        public com.byazt.yj.tt z;
        public int i = 1;
        public int da = 5;

        public tt(a aVar) {
            this.m = aVar;
        }

        @Override // com.byazt.yj.yp
        public yp cache(com.byazt.yj.tt ttVar) {
            this.z = ttVar;
            return this;
        }

        @Override // com.byazt.yj.yp
        public yp cacheDir(String str) {
            this.yp = str;
            return this;
        }

        @Override // com.byazt.yj.yp
        public yp config(Bitmap.Config config) {
            this.f28931a = config;
            return this;
        }

        @Override // com.byazt.yj.yp
        public yp converter(da daVar) {
            this.nu = daVar;
            return this;
        }

        @Override // com.byazt.yj.yp
        public yp from(String str) {
            this.uj = str;
            return this;
        }

        @Override // com.byazt.yj.yp
        public yp headers(boolean z) {
            this.t = z;
            return this;
        }

        @Override // com.byazt.yj.yp
        public yp height(int i) {
            this.x = i;
            return this;
        }

        @Override // com.byazt.yj.yp
        public yp isLocalRes(boolean z) {
            this.gr = z;
            return this;
        }

        @Override // com.byazt.yj.yp
        public yp key(String str) {
            this.ve = str;
            return this;
        }

        @Override // com.byazt.yj.yp
        public yp loadSetp(gt gtVar) {
            this.gu = gtVar;
            return this;
        }

        @Override // com.byazt.yj.yp
        public yp maxHeight(int i) {
            this.my = i;
            return this;
        }

        @Override // com.byazt.yj.yp
        public yp maxWidth(int i) {
            this.rh = i;
            return this;
        }

        @Override // com.byazt.yj.yp
        public yp requestTime(boolean z) {
            this.u = z;
            return this;
        }

        @Override // com.byazt.yj.yp
        public yp runIn(ExecutorService executorService) {
            this.rl = executorService;
            return this;
        }

        @Override // com.byazt.yj.yp
        public yp scaleType(ImageView.ScaleType scaleType) {
            this.n = scaleType;
            return this;
        }

        @Override // com.byazt.yj.yp
        public yp sync(boolean z) {
            this.qy = z;
            return this;
        }

        @Override // com.byazt.yj.yp
        public t to(gr grVar, int i) {
            this.da = i;
            return to(grVar);
        }

        @Override // com.byazt.yj.yp
        public yp track(or orVar) {
            this.sl = orVar;
            return this;
        }

        @Override // com.byazt.yj.yp
        public yp type(int i) {
            this.i = i;
            return this;
        }

        @Override // com.byazt.yj.yp
        public yp width(int i) {
            this.sp = i;
            return this;
        }

        @Override // com.byazt.yj.yp
        public t to(gr grVar) {
            this.c = grVar;
            return new ve(this).rh();
        }

        @Override // com.byazt.yj.yp
        public t to(ImageView imageView) {
            this.tt = imageView;
            return new ve(this).rh();
        }
    }

    private ve(tt ttVar) {
        this.rh = new LinkedBlockingQueue();
        this.my = new Handler(Looper.getMainLooper());
        this.gt = true;
        this.tt = ttVar.uj;
        this.n = new c(ttVar.c);
        this.t = new WeakReference<>(ttVar.tt);
        this.f28930a = ttVar.n;
        this.sp = ttVar.f28931a;
        this.x = ttVar.sp;
        this.i = ttVar.x;
        this.sl = ttVar.i;
        this.nu = ttVar.da;
        this.m = ttVar.sl;
        this.zm = c(ttVar);
        if (!TextUtils.isEmpty(ttVar.ve)) {
            tt(ttVar.ve);
            c(ttVar.ve);
        }
        this.yp = ttVar.t;
        this.z = ttVar.u;
        this.gu = ttVar.m;
        this.da = ttVar.nu;
        this.p = ttVar.my;
        this.yv = ttVar.rh;
        this.h = ttVar.rl;
        this.md = ttVar.gt;
        this.d = ttVar.qy;
        this.eo = ttVar.gu;
        this.zb = ttVar.gr;
        this.rh.add(new com.byazt.pc.ve());
    }

    public boolean a() {
        return this.yp;
    }

    public com.byazt.yj.x da() {
        return this.rl;
    }

    public boolean i() {
        return this.zb;
    }

    public int n() {
        return this.sl;
    }

    public boolean sp() {
        return this.z;
    }

    public int tt() {
        return this.p;
    }

    public Bitmap.Config uj() {
        return this.sp;
    }

    public gr ve() {
        return this.n;
    }

    public boolean x() {
        return this.gt;
    }

    private com.byazt.yj.tt c(tt ttVar) {
        if (ttVar.z != null) {
            return ttVar.z;
        }
        if (!TextUtils.isEmpty(ttVar.yp)) {
            return com.byazt.ep.c.c(new File(ttVar.yp));
        }
        return com.byazt.ep.c.c();
    }

    public void tt(String str) {
        WeakReference<ImageView> weakReference = this.t;
        if (weakReference != null && weakReference.get() != null) {
            this.t.get().setTag(1094453505, str);
        }
        this.ve = str;
    }

    public int c() {
        return this.yv;
    }

    public void c(String str) {
        this.uj = str;
    }

    public void c(boolean z) {
        this.gt = z;
    }

    public void c(com.byazt.yj.x xVar) {
        this.rl = xVar;
    }

    public void c(int i) {
        this.qy = i;
    }

    public void c(com.byazt.oz.c cVar) {
        this.gr = cVar;
    }

    public boolean c(i iVar) {
        if (this.u) {
            return false;
        }
        return this.rh.add(iVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(int i, String str, Throwable th) {
        new com.byazt.pc.x(i, str, th).c(this);
        this.rh.clear();
    }
}
