package com.beizi.fusion;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.beizi.fusion.events.EventBean;
import com.beizi.fusion.model.AdSpacesBean;
import com.beizi.fusion.model.UnifiedAdDownloadAppInfo;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class n3 extends d2 implements a2 {
    protected Context U;
    protected long V;
    protected float W;
    protected float X;
    protected NativeUnifiedAdResponse Y;
    protected FrameLayout Z;
    protected boolean a0 = false;
    protected boolean b0 = false;

    public class a implements NativeUnifiedAdResponse {
        public a() {
        }

        @Override // com.beizi.fusion.NativeUnifiedAdResponse
        public String getActionText() {
            return n3.this.M0();
        }

        @Override // com.beizi.fusion.NativeUnifiedAdResponse
        public String getAdLogoUrl() {
            return n3.this.T0();
        }

        @Override // com.beizi.fusion.NativeUnifiedAdResponse
        public String getDescription() {
            return n3.this.O0();
        }

        @Override // com.beizi.fusion.NativeUnifiedAdResponse
        public UnifiedAdDownloadAppInfo getDownloadAppInfo() {
            return n3.this.P0();
        }

        @Override // com.beizi.fusion.NativeUnifiedAdResponse
        public int getECPM() {
            String strS = n3.this.s();
            if (strS == null) {
                return -1;
            }
            try {
                return Integer.parseInt(strS);
            } catch (Exception unused) {
                return -1;
            }
        }

        @Override // com.beizi.fusion.NativeUnifiedAdResponse
        public String getIconUrl() {
            return n3.this.Q0();
        }

        @Override // com.beizi.fusion.NativeUnifiedAdResponse
        public String getImageUrl() {
            return n3.this.R0();
        }

        @Override // com.beizi.fusion.NativeUnifiedAdResponse
        public List getImgList() {
            return n3.this.S0();
        }

        @Override // com.beizi.fusion.NativeUnifiedAdResponse
        public int getMaterialType() {
            return n3.this.U0();
        }

        @Override // com.beizi.fusion.NativeUnifiedAdResponse
        public String getTitle() {
            return n3.this.V0();
        }

        @Override // com.beizi.fusion.NativeUnifiedAdResponse
        public View getVideoView() {
            return n3.this.W0();
        }

        @Override // com.beizi.fusion.NativeUnifiedAdResponse
        public ViewGroup getViewContainer() {
            return n3.this.N0();
        }

        @Override // com.beizi.fusion.NativeUnifiedAdResponse
        public boolean isVideo() {
            return n3.this.Y0();
        }

        @Override // com.beizi.fusion.NativeUnifiedAdResponse
        public void registerDownloadAppInfoClickEvent(View view) {
            n3.this.a(view);
        }

        @Override // com.beizi.fusion.NativeUnifiedAdResponse
        public void registerViewForInteraction(List list) {
            n3.this.a(list);
        }
    }

    public n3(Context context, long j, AdSpacesBean.BuyerBean buyerBean, AdSpacesBean.ForwardBean forwardBean, m3 m3Var, int i) {
        this.U = context;
        this.V = j;
        this.e = buyerBean;
        this.d = m3Var;
        this.D = i;
        this.f = forwardBean;
        this.W = so.h(context);
        this.X = so.e(context);
        C();
    }

    private void Z0() {
        m3 m3Var = this.d;
        if (m3Var == null) {
            return;
        }
        Log.d("BeiZis", x() + " NativeUnifiedWorker:" + m3Var.C().toString());
        f();
        s5 s5Var = this.g;
        if (s5Var == s5.SUCCESS) {
            c1();
            this.d.b(x(), (View) null);
        } else if (s5Var == s5.FAIL) {
            Log.d("BeiZis", "other worker shown," + x() + " remove");
        }
    }

    private void c1() {
        this.Y = new a();
    }

    @Override // com.beizi.fusion.d2
    public void A0() {
        if (this.d == null) {
            return;
        }
        this.h = this.e.getAppId();
        this.i = this.e.getSpaceId();
        this.c = this.e.getBuyerSpaceUuId();
        ik ikVar = this.f27152a;
        if (ikVar != null) {
            EventBean eventBeanB = ikVar.a().b(this.c);
            this.b = eventBeanB;
            if (eventBeanB != null) {
                D();
                X0();
            }
        }
    }

    @Override // com.beizi.fusion.d2
    public void G0() {
    }

    public abstract String M0();

    public abstract ViewGroup N0();

    public abstract String O0();

    public abstract UnifiedAdDownloadAppInfo P0();

    public abstract String Q0();

    public abstract String R0();

    public abstract List S0();

    public abstract String T0();

    public abstract int U0();

    public abstract String V0();

    public abstract View W0();

    public abstract void X0();

    public abstract boolean Y0();

    public abstract void a(View view);

    public abstract void a(List list);

    public abstract void a1();

    public void b1() {
        try {
            if (V()) {
                Z0();
            } else {
                A();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.beizi.fusion.d2
    public b2 h() {
        return this.j;
    }

    @Override // com.beizi.fusion.d2
    public AdSpacesBean.BuyerBean m() {
        return this.e;
    }

    @Override // com.beizi.fusion.d2
    public NativeUnifiedAdResponse q() {
        return this.Y;
    }

    @Override // com.beizi.fusion.d2
    public abstract String x();

    @Override // com.beizi.fusion.d2
    public void z0() {
        g0();
        K0();
        a1();
    }
}
