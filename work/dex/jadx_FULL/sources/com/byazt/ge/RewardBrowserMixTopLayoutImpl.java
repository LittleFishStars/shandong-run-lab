package com.byazt.ge;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.byazt.aas.pf;
import com.byazt.ete.ic;
import com.byazt.ete.my;
import com.byazt.ukr.yp;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 758, 1384})
public class RewardBrowserMixTopLayoutImpl extends FrameLayout implements c<RewardBrowserMixTopLayoutImpl> {
    public View c;
    public Context n;
    public View tt;
    public ic uj;
    public tt ve;

    public RewardBrowserMixTopLayoutImpl(Context context) {
        this(context, null);
    }

    private void uj() {
        pf.c(this.c, new View.OnClickListener() { // from class: com.byazt.ge.RewardBrowserMixTopLayoutImpl.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("topListener", RewardBrowserMixTopLayoutImpl.this.ve);
                    jSONObject.put("topImpl", 2);
                } catch (Throwable unused) {
                }
                yp.c().c(RewardBrowserMixTopLayoutImpl.this.uj, "stats_reward_full_click_native_close", jSONObject);
                if (RewardBrowserMixTopLayoutImpl.this.ve != null) {
                    RewardBrowserMixTopLayoutImpl.this.ve.c(view);
                }
            }
        }, "top_skip_border");
        pf.c(this.tt, new View.OnClickListener() { // from class: com.byazt.ge.RewardBrowserMixTopLayoutImpl.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (RewardBrowserMixTopLayoutImpl.this.ve != null) {
                    RewardBrowserMixTopLayoutImpl.this.ve.ve(view);
                }
            }
        }, "top_dislike_button");
    }

    @Override // com.byazt.ge.c
    public void c(String str, String str2, boolean z) {
    }

    @Override // com.byazt.ge.c
    public void c(boolean z, String str, String str2, boolean z2, boolean z3) {
    }

    @Override // com.byazt.ge.c
    public View getCloseButton() {
        return this.c;
    }

    @Override // com.byazt.ge.c
    public boolean getSkipOrCloseVisible() {
        return pf.uj(this.c);
    }

    public tt getTopListener() {
        return this.ve;
    }

    @Override // com.byazt.ge.c
    public void setDislikeLeft(boolean z) {
    }

    @Override // com.byazt.ge.c
    public void setListener(tt ttVar) {
        this.ve = ttVar;
    }

    @Override // com.byazt.ge.c
    public void setPlayAgainEntranceText(String str) {
    }

    @Override // com.byazt.ge.c
    public void setShowAgain(boolean z) {
    }

    @Override // com.byazt.ge.c
    public void setShowBack(boolean z) {
    }

    @Override // com.byazt.ge.c
    public void setShowDislike(boolean z) {
    }

    @Override // com.byazt.ge.c
    public void setShowSound(boolean z) {
    }

    @Override // com.byazt.ge.c
    public void setSoundMute(boolean z) {
    }

    @Override // com.byazt.ge.c
    public void setVisible(boolean z) {
        setVisibility(z ? 0 : 8);
    }

    @Override // com.byazt.ge.c
    public void tt() {
    }

    @Override // com.byazt.ge.c
    public void ve() {
        View view = this.tt;
        if (view != null) {
            view.performClick();
        }
    }

    public RewardBrowserMixTopLayoutImpl(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RewardBrowserMixTopLayoutImpl c(ic icVar) {
        this.uj = icVar;
        addView(com.byazt.vfu.a.x(getContext()));
        this.c = findViewById(2114387869);
        View viewFindViewById = findViewById(2114387453);
        this.tt = findViewById(2114387454);
        if (my.z(icVar)) {
            this.c = findViewById(2114387869);
            this.tt.setVisibility(8);
            viewFindViewById.setVisibility(8);
            this.c.setBackground(com.byazt.vfu.a.kk(this.n));
        } else if (my.m(icVar)) {
            findViewById(2114387738).setVisibility(8);
            this.c = findViewById(2114387869);
        } else {
            this.c = findViewById(2114387713);
            this.tt.setVisibility(8);
            viewFindViewById.setVisibility(8);
        }
        if (this.c != null) {
            if (icVar.sv()) {
                this.c.setVisibility(8);
            } else {
                this.c.setVisibility(0);
                this.c.setEnabled(true);
                this.c.setClickable(true);
            }
        }
        uj();
        return this;
    }

    public RewardBrowserMixTopLayoutImpl(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.n = context;
    }

    @Override // com.byazt.ge.c
    public void c() {
        View view = this.c;
        if (view != null) {
            view.performClick();
        }
    }
}
