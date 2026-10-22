package cj.mobile.wm;

import android.widget.TextView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class rd {
    public final TextView dexa;
    public final ce dexb;
    public final int dexc;
    public int dexd;
    public boolean dexe = false;
    public dexb dexf;
    public final dexc dexg;

    public class dexa extends ce {
        public dexa(long j, long j2) {
            super(j, j2);
        }

        @Override // cj.mobile.wm.ce
        public void dexa(long j) {
            rd.this.dexd = Math.round(j / 1000.0f);
            if (rd.this.dexg != null) {
                rd.this.dexg.a(rd.this.dexd);
            }
            if (rd.this.dexd < 1) {
                rd.this.dexd = 1;
            }
            rd rdVar = rd.this;
            rdVar.dexa(rdVar.dexd);
        }

        @Override // cj.mobile.wm.ce
        public void dexc() {
            f1.dexa("CountDownComponent", "onFinish.");
            if (rd.this.dexf != null) {
                rd.this.dexf.a();
            }
        }
    }

    public interface dexb {
        void a();
    }

    public interface dexc {
        void a(int i);
    }

    public rd(TextView textView, int i, dexb dexbVar, dexc dexcVar) {
        this.dexa = textView;
        this.dexc = i;
        this.dexf = dexbVar;
        this.dexg = dexcVar;
        this.dexb = new dexa((((long) i) * 1000) + 300, 300L);
    }

    public void dexa() {
        ce ceVar = this.dexb;
        if (ceVar != null) {
            ceVar.dexd();
        }
    }

    public void dexa(int i) {
        TextView textView = this.dexa;
        if (textView == null || i <= 0) {
            return;
        }
        textView.setText(String.valueOf(i));
    }

    public void dexb() {
        ce ceVar = this.dexb;
        if (ceVar != null) {
            ceVar.dexe();
        }
    }

    public void dexc() {
        f1.dexa("CountDownComponent", "startCountDown: mCurrentCount = " + this.dexd + ", mIsTimerStarted = " + this.dexe + ", mCountDownTimer = " + this.dexb);
        if (this.dexe || this.dexb == null) {
            return;
        }
        this.dexa.setText(String.valueOf(this.dexc));
        this.dexb.dexf();
        this.dexe = true;
    }

    public void dexd() {
        ce ceVar;
        if (this.dexe && (ceVar = this.dexb) != null) {
            ceVar.dexa();
            this.dexe = false;
        }
        this.dexf = null;
    }
}
