package com.byazt.dy;

import android.content.Context;
import android.text.TextUtils;
import android.widget.FrameLayout;
import com.zj.adlib.ue5;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, ue5.b, 20})
public class c extends com.byazt.xj.c<UGFrameLayout> {
    public UGFrameLayout yo;

    /* JADX INFO: renamed from: com.byazt.dy.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, ue5.b, 44})
    public static class C0391c extends com.byazt.xj.c.C0576c {
        public int yv;

        public C0391c(com.byazt.xj.c cVar) {
            super(cVar);
            this.yv = -1;
        }

        private int tt(String str) {
            str.hashCode();
            switch (str) {
                case "bottom":
                    return 80;
                case "center":
                    return 17;
                case "center_vertical":
                    return 16;
                case "top":
                    return 48;
                case "left":
                    return 3;
                case "right":
                    return 5;
                case "center_horizontal":
                    return 1;
                default:
                    return -1;
            }
        }

        @Override // com.byazt.xj.c.C0576c
        public void c(Context context, String str, String str2) {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            super.c(context, str, str2);
            if (TextUtils.equals(str, "layoutGravity")) {
                this.yv = c(str2);
            }
        }

        @Override // com.byazt.xj.c.C0576c
        /* JADX INFO: renamed from: tt, reason: merged with bridge method [inline-methods] */
        public FrameLayout.LayoutParams c() {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) this.c, (int) this.tt);
            layoutParams.leftMargin = (int) this.f29179a;
            layoutParams.rightMargin = (int) this.sp;
            layoutParams.topMargin = (int) this.x;
            layoutParams.bottomMargin = (int) this.i;
            layoutParams.gravity = this.yv;
            return layoutParams;
        }

        private int c(String str) {
            String[] strArrSplit;
            if (TextUtils.isEmpty(str) || (strArrSplit = str.split("\\|")) == null || strArrSplit.length <= 0) {
                return -1;
            }
            int iTt = 0;
            for (String str2 : strArrSplit) {
                iTt |= tt(str2);
            }
            return iTt;
        }
    }

    public c(Context context) {
        super(context);
    }

    @Override // com.byazt.xj.ve
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public UGFrameLayout c() {
        UGFrameLayout uGFrameLayout = new UGFrameLayout(this.tt);
        this.yo = uGFrameLayout;
        uGFrameLayout.c(this);
        return this.yo;
    }

    @Override // com.byazt.xj.c, com.byazt.xj.ve
    public void tt() {
        this.yo.setEventMap(this.gx);
        super.tt();
    }

    @Override // com.byazt.xj.c
    public com.byazt.xj.c.C0576c x() {
        return new C0391c(this);
    }
}
