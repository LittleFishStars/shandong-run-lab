package com.byazt.un;

import android.view.View;
import android.widget.TextView;
import com.byazt.ff.RoundImageView;
import com.byazt.nr.m;
import com.byazt.sgn.z;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 96, 91})
public class sp {
    public a c;

    public sp(a aVar) {
        this.c = aVar;
    }

    public boolean c() {
        z zVar = this.c.p;
        boolean zC = zVar != null ? zVar.c() : false;
        StringBuilder sb = new StringBuilder("isVisible=");
        sb.append(zC);
        sb.append(",mPlayBtn.getVisibility() == VISIBLE->");
        sb.append(this.c.ve.getVisibility() == 0);
        m.c("ClickCreativeListener", sb.toString());
        return zC || this.c.ve.getVisibility() == 0;
    }

    public boolean tt() {
        View view;
        RoundImageView roundImageView;
        TextView textView;
        if (com.byazt.ex.c.c(this.c.zm)) {
            return true;
        }
        View view2 = this.c.x;
        return (view2 != null && view2.getVisibility() == 0) || ((view = this.c.da) != null && view.getVisibility() == 0) || (((roundImageView = this.c.sl) != null && roundImageView.getVisibility() == 0) || ((textView = this.c.t) != null && textView.getVisibility() == 0));
    }
}
