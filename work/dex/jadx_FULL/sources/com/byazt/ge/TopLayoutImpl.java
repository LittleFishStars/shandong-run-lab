package com.byazt.ge;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.view.GravityCompat;
import com.byazt.aas.nb;
import com.byazt.aas.pf;
import com.byazt.ete.h;
import com.byazt.ete.ic;
import com.byazt.ete.lt;
import com.byazt.ete.my;
import com.byazt.nr.z;
import com.byazt.ukr.yp;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 758, 1058})
public class TopLayoutImpl extends FrameLayout implements c<TopLayoutImpl> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public View f28563a;
    public View c;
    public View da;
    public boolean gt;
    public TextView i;
    public TextView m;
    public TextView my;
    public TextView n;
    public View nu;
    public ic qy;
    public View rh;
    public tt rl;
    public TextView sl;
    public View sp;
    public View t;
    public ImageView tt;
    public View u;
    public View uj;
    public View ve;
    public View x;
    public View yp;
    public View z;

    public TopLayoutImpl(Context context) {
        this(context, null);
    }

    @Override // com.byazt.ge.c
    public View getCloseButton() {
        return this.da;
    }

    @Override // com.byazt.ge.c
    public boolean getSkipOrCloseVisible() {
        return pf.uj(this.da) || (this.f28563a != null && pf.uj(this.sl) && !TextUtils.isEmpty(this.sl.getText()));
    }

    public tt getTopListener() {
        return this.rl;
    }

    @Override // com.byazt.ge.c
    public void setDislikeLeft(boolean z) {
        if (this.c.getLayoutParams() instanceof FrameLayout.LayoutParams) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.c.getLayoutParams();
            layoutParams.gravity = z ? GravityCompat.START : GravityCompat.END;
            this.c.setLayoutParams(layoutParams);
        }
    }

    @Override // com.byazt.ge.c
    public void setListener(tt ttVar) {
        this.rl = ttVar;
    }

    @Override // com.byazt.ge.c
    public void setPlayAgainEntranceText(String str) {
        pf.c(this.n, str);
    }

    @Override // com.byazt.ge.c
    public void setShowAgain(boolean z) {
        pf.c(this.uj, z ? 0 : 8);
    }

    @Override // com.byazt.ge.c
    public void setShowBack(boolean z) {
        View view = this.ve;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.byazt.ge.c
    public void setShowDislike(boolean z) {
        View view = this.c;
        if (view != null) {
            view.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.byazt.ge.c
    public void setShowSound(boolean z) {
        ImageView imageView = this.tt;
        if (imageView != null) {
            imageView.setVisibility(z ? 0 : 8);
        }
    }

    @Override // com.byazt.ge.c
    public void setSoundMute(boolean z) {
        this.gt = z;
        z.c(getContext(), this.gt ? "tt_mute" : "tt_unmute", this.tt, 320);
    }

    @Override // com.byazt.ge.c
    public void setVisible(boolean z) {
        setVisibility(z ? 0 : 8);
    }

    public TopLayoutImpl(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    private void uj() {
        pf.c(this.c, new View.OnClickListener() { // from class: com.byazt.ge.TopLayoutImpl.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.rl != null) {
                    TopLayoutImpl.this.rl.ve(view);
                }
            }
        }, "top_dislike_button");
        pf.c(this.tt, new View.OnClickListener() { // from class: com.byazt.ge.TopLayoutImpl.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                TopLayoutImpl topLayoutImpl = TopLayoutImpl.this;
                topLayoutImpl.gt = !topLayoutImpl.gt;
                z.c(TopLayoutImpl.this.getContext(), TopLayoutImpl.this.gt ? "tt_mute" : "tt_unmute", TopLayoutImpl.this.tt, 320);
                if (TopLayoutImpl.this.rl != null) {
                    TopLayoutImpl.this.rl.tt(view);
                }
            }
        }, "top_mute_button");
        pf.c(this.sp, new View.OnClickListener() { // from class: com.byazt.ge.TopLayoutImpl.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        }, "top_before_button");
        pf.c(this.da, new View.OnClickListener() { // from class: com.byazt.ge.TopLayoutImpl.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("topListener", TopLayoutImpl.this.rl);
                    jSONObject.put("topImpl", 1);
                } catch (Throwable unused) {
                }
                if (!h.c(TopLayoutImpl.this.qy) || com.byazt.dl.uj.c(String.valueOf(nb.t(TopLayoutImpl.this.qy)))) {
                    yp.c().c(TopLayoutImpl.this.qy, "stats_reward_full_click_native_close", jSONObject);
                }
                if (TopLayoutImpl.this.rl != null) {
                    TopLayoutImpl.this.rl.c(view);
                }
            }
        }, "top_skip_button");
        pf.c(this.ve, new View.OnClickListener() { // from class: com.byazt.ge.TopLayoutImpl.5
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.rl != null) {
                    TopLayoutImpl.this.rl.uj(view);
                }
            }
        }, "top_back_button");
        pf.c(this.uj, new View.OnClickListener() { // from class: com.byazt.ge.TopLayoutImpl.6
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.rl != null) {
                    TopLayoutImpl.this.rl.n(view);
                }
            }
        }, "top_again_button");
        pf.c(this.f28563a, new View.OnClickListener() { // from class: com.byazt.ge.TopLayoutImpl.7
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.rl != null) {
                    TopLayoutImpl.this.rl.a(view);
                }
            }
        }, "top_skip_border");
        pf.c(this.rh, new View.OnClickListener() { // from class: com.byazt.ge.TopLayoutImpl.8
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (TopLayoutImpl.this.rl != null) {
                    TopLayoutImpl.this.rl.sp(view);
                }
            }
        }, "top_next_video_cancel");
    }

    @Override // com.byazt.ge.c
    public void tt() {
        ImageView imageView = this.tt;
        if (imageView != null) {
            imageView.performClick();
        }
    }

    @Override // com.byazt.ge.c
    public void ve() {
        View view = this.c;
        if (view != null) {
            view.performClick();
        }
    }

    public TopLayoutImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public TopLayoutImpl c(ic icVar) {
        this.qy = icVar;
        if (my.u(icVar)) {
            addView(com.byazt.vfu.a.x(getContext()));
        } else if (lt.x(this.qy)) {
            addView(com.byazt.vfu.a.sp(getContext()));
        } else {
            addView(com.byazt.vfu.a.a(getContext()));
        }
        this.c = findViewById(2114387845);
        this.tt = (ImageView) findViewById(2114387758);
        this.ve = findViewById(2114387819);
        this.uj = findViewById(2114387673);
        this.n = (TextView) findViewById(2114387632);
        this.f28563a = findViewById(2114387713);
        this.sp = findViewById(2114387951);
        this.x = findViewById(2114387725);
        this.i = (TextView) findViewById(2114387606);
        this.da = findViewById(2114387635);
        this.sl = (TextView) findViewById(2114387785);
        this.t = findViewById(2114387738);
        this.u = findViewById(2114387924);
        this.yp = findViewById(2114387950);
        this.z = findViewById(2114387949);
        this.m = (TextView) findViewById(2114387948);
        this.nu = findViewById(2114387947);
        this.rh = findViewById(2114387946);
        this.my = (TextView) findViewById(2114387945);
        View view = this.da;
        if (view != null) {
            view.setEnabled(false);
            this.da.setClickable(false);
        }
        uj();
        return this;
    }

    @Override // com.byazt.ge.c
    public void c(boolean z, String str, String str2, boolean z2, boolean z3) {
        pf.c(this.f28563a, 0);
        boolean z4 = z || !TextUtils.isEmpty(str);
        boolean z5 = z2 || !TextUtils.isEmpty(str2);
        boolean z6 = z4 && z5;
        pf.c(this.f28563a, (z4 || z5) ? 0 : 4);
        pf.c(this.sp, z4 ? 0 : 8);
        pf.c(this.da, z5 ? 0 : 8);
        pf.c(this.u, z6 ? 0 : 8);
        pf.c(this.x, z ? 0 : 8);
        pf.c((View) this.i, !TextUtils.isEmpty(str) ? 0 : 8);
        pf.c(this.t, z2 ? 0 : 8);
        pf.c((View) this.sl, TextUtils.isEmpty(str2) ? 8 : 0);
        if (!TextUtils.isEmpty(str)) {
            pf.c(this.i, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            pf.c(this.sl, str2);
        }
        View view = this.da;
        if (view != null) {
            view.setEnabled(z3);
            this.da.setClickable(z3);
        }
    }

    @Override // com.byazt.ge.c
    public void c(String str, String str2, boolean z) {
        boolean z2 = !TextUtils.isEmpty(str);
        boolean z3 = !TextUtils.isEmpty(str2);
        boolean z4 = z2 && z3;
        pf.c(this.yp, (z2 || z3) ? 0 : 4);
        pf.c(this.z, z2 ? 0 : 8);
        pf.c(this.rh, z3 ? 0 : 8);
        pf.c(this.nu, z4 ? 0 : 8);
        pf.c((View) this.m, !TextUtils.isEmpty(str) ? 0 : 8);
        pf.c((View) this.my, TextUtils.isEmpty(str2) ? 8 : 0);
        if (!TextUtils.isEmpty(str)) {
            pf.c(this.m, str);
        }
        if (!TextUtils.isEmpty(str2)) {
            pf.c(this.my, str2);
        }
        View view = this.da;
        if (view != null) {
            view.setEnabled(z);
            this.da.setClickable(z);
        }
    }

    @Override // com.byazt.ge.c
    public void c() {
        View view = this.da;
        if (view != null) {
            view.performClick();
        }
    }
}
