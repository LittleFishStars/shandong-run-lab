package cj.mobile.wm;

import android.graphics.Rect;
import android.view.ViewTreeObserver;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class t1 implements ViewTreeObserver.OnPreDrawListener {
    public i1 dexa;
    public volatile ce dexb;
    public boolean dexe;
    public long dexh;
    public s1 dexr;
    public boolean dexc = false;
    public boolean dexd = true;
    public volatile boolean dexf = false;
    public volatile boolean dexg = false;
    public float dexi = 0.5f;
    public long dexj = 100;
    public boolean dexk = true;
    public long dexl = 0;
    public Rect dexm = new Rect();
    public boolean dexn = false;
    public long dexo = 200;
    public long dexp = 0;
    public long dexq = 0;

    public class dexa extends ce {
        public dexa(long j, long j2) {
            super(j, j2);
        }

        @Override // cj.mobile.wm.ce
        public void dexa(long j) {
            t1.this.dexq += t1.this.dexo;
            long j2 = t1.this.dexq;
            t1 t1Var = t1.this;
            if (j2 >= t1Var.dexj) {
                if (t1Var.dexa() && t1.this.dexr.b() && t1.this.dexr.c() == 0) {
                    t1.this.dexk();
                }
            }
            f1.dexa("AdMonitor-Timer", "initTimer  onTick 是否曝光完成 = " + t1.this.dexg + " ，是否在监测过程中 = " + t1.this.dexf + ", 累计时间 = " + t1.this.dexq);
        }

        @Override // cj.mobile.wm.ce
        public void dexc() {
            f1.dexa("AdMonitor-Timer", "initTimer - onFinish 累计计数时间 = " + t1.this.dexq);
            t1.this.dexq = 0L;
        }
    }

    public t1(i1 i1Var, int i) {
        this.dexa = i1Var;
        dexc();
    }

    private boolean dexb(long j) {
        this.dexr.dexa(this.dexm);
        boolean z = this.dexi <= 0.0f || (((float) Math.abs(this.dexm.height())) > ((float) this.dexr.getHeight()) * this.dexi && ((float) Math.abs(this.dexm.width())) > ((float) this.dexr.getWidth()) * this.dexi);
        long j2 = this.dexj;
        return z && ((j2 > 0L ? 1 : (j2 == 0L ? 0 : -1)) <= 0 || (j > j2 ? 1 : (j == j2 ? 0 : -1)) >= 0);
    }

    private void dexj() {
        try {
            f1.dexa("AdMonitor-Timer", "cancelTimer");
            this.dexq = 0L;
            if (this.dexb != null) {
                this.dexb.dexa();
                this.dexb = null;
            }
        } catch (Exception e) {
            f1.dexb("AdMonitor-Timer", "cancelTimer " + e.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dexk() {
        if (this.dexg) {
            return;
        }
        if (!dexb(this.dexq)) {
            dexm();
            dexg();
        } else {
            dexf();
            dexa(this.dexq);
            dexj();
        }
    }

    private void dexl() {
        try {
            if (this.dexb != null) {
                return;
            }
            f1.dexa("AdMonitor-Timer", "initTimer  init start");
            this.dexq = 0L;
            this.dexb = new dexa(this.dexp, this.dexo);
        } catch (Exception e) {
            f1.dexb("AdMonitor", "initTimer " + e.getMessage());
        }
    }

    private void dexm() {
        try {
            f1.dexa("AdMonitor", "startTimer");
            if (this.dexg) {
                f1.dexa("AdMonitor-Timer", "startTimer 已经曝光，不再重复启动");
                return;
            }
            dexl();
            if (this.dexb == null) {
                f1.dexa("AdMonitor-Timer", "startTimer timer为空");
            } else if (this.dexb.dexb()) {
                f1.dexa("AdMonitor-Timer", "startTimer resume");
                this.dexb.dexe();
            } else {
                f1.dexa("AdMonitor-Timer", "startTimer start");
                this.dexb.dexf();
            }
        } catch (Exception e) {
            f1.dexb("AdMonitor-Timer", "startTimer " + e.getMessage());
            dexj();
        }
    }

    private void dexn() {
        try {
            f1.dexa("AdMonitor-Timer", "stopTimer");
            if (this.dexb != null) {
                this.dexb.dexd();
            }
        } catch (Exception e) {
            f1.dexb("AdMonitor-Timer", "stopTimer " + e.getMessage());
        }
    }

    public void dexa(long j) {
        i1 i1Var = this.dexa;
        if (i1Var != null) {
            i1Var.a(j);
        }
    }

    public void dexa(s1 s1Var) {
        this.dexr = s1Var;
    }

    public void dexa(boolean z) {
        this.dexe = z;
        if (z) {
            return;
        }
        f1.dexa("AdMonitor_Lifecycle", "广告变为不可见");
        dexi();
    }

    public boolean dexa() {
        f1.dexa("AdMonitor-Cover", "checkCover");
        if (System.currentTimeMillis() - this.dexl < 200) {
            f1.dexa("AdMonitor-Cover", "checkCover时间间隔条件触发熔断，直接返回coverBoolean：" + this.dexk);
            return this.dexk;
        }
        this.dexl = System.currentTimeMillis();
        if (this.dexg) {
            f1.dexa("AdMonitor-Cover", "checkCover-已经曝光，不再计算遮挡比例");
            this.dexk = true;
        } else {
            long jCurrentTimeMillis = System.currentTimeMillis();
            float fA = this.dexr.a();
            this.dexk = fA <= 1.0f - this.dexi;
            f1.dexa("AdMonitor-Cover", "checkCover-coverFloat:" + fA + ",coverBoolean:" + this.dexk + ",耗时：" + (System.currentTimeMillis() - jCurrentTimeMillis));
        }
        return this.dexk;
    }

    public void dexb() {
        this.dexi = dexv.dexj().dexg();
        this.dexj = dexv.dexj().dexh();
        this.dexo = 200L;
        this.dexp = 180000L;
    }

    public void dexb(boolean z) {
        this.dexd = z;
        f1.dexa("AdMonitor_Lifecycle", "广告焦点发生变化，onWindowFocusChanged=" + z);
        if (z) {
            dexk();
        } else {
            dexi();
        }
    }

    public void dexc() {
        dexb();
    }

    public void dexd() {
        this.dexc = true;
        dexl();
        f1.dexa("AdMonitor_Lifecycle", "广告onAttachedToWindow");
    }

    public void dexe() {
        this.dexc = false;
        f1.dexa("AdMonitor_Lifecycle", "广告onDetachedFromWindow");
        dexi();
        dexj();
    }

    public void dexf() {
        if (this.dexg) {
            return;
        }
        this.dexg = true;
        f1.dexa("AdMonitor", "完成曝光");
        i1 i1Var = this.dexa;
        if (i1Var != null) {
            i1Var.a();
        }
    }

    public void dexg() {
        this.dexf = true;
        this.dexh = System.currentTimeMillis();
    }

    public void dexh() {
        this.dexf = false;
    }

    public void dexi() {
        if (this.dexf) {
            dexh();
            f1.dexa("AdMonitor", "停止曝光,曝光时长=" + (System.currentTimeMillis() - this.dexh) + " showTime=" + this.dexj);
        }
        dexn();
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        if (this.dexn) {
            return true;
        }
        this.dexn = true;
        boolean z = dexa() && this.dexr.b() && this.dexr.c() == 0;
        f1.dexa("AdMonitor", "onPreDraw 是否可见 sss= " + z + " 需要露出的比例 = " + this.dexi);
        if (z) {
            dexk();
            return true;
        }
        dexi();
        return true;
    }
}
