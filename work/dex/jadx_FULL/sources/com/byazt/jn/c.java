package com.byazt.jn;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import com.byazt.cd.uj;
import com.byazt.cd.x;
import com.byazt.sa.n;
import com.byazt.sm.UGTextView;
import com.byazt.sm.tt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 940, 20})
public class c extends tt {
    public int az;
    public int cf;
    public com.byazt.cd.c.C0376c ij;
    public boolean is;
    public boolean jt;
    public String kz;
    public String mq;
    public String vi;
    public String vp;

    public c(Context context) {
        super(context);
        this.kz = "row";
    }

    private void x() {
        if (TextUtils.isEmpty(this.vp)) {
            return;
        }
        ((UGTextView) this.n).setCompoundDrawables(null, null, null, null);
        if (!this.vp.startsWith("local://")) {
            n.c().tt().c(this.i, this.vp, new com.byazt.sa.c.InterfaceC0516c() { // from class: com.byazt.jn.c.1
                @Override // com.byazt.sa.c.InterfaceC0516c
                public void c(final Bitmap bitmap) {
                    if (bitmap == null) {
                        return;
                    }
                    x.c(new Runnable() { // from class: com.byazt.jn.c.1.1
                        @Override // java.lang.Runnable
                        public void run() {
                            c.this.tt(new BitmapDrawable(c.this.tt.getResources(), bitmap));
                        }
                    });
                }
            });
        } else {
            try {
                sl(this.vp.replace("local://", ""));
            } catch (Throwable unused) {
            }
        }
    }

    @Override // com.byazt.xj.ve
    public void aw() {
        super.aw();
        if (this.is) {
            ((UGTextView) this.n).setTextColor(((tt) this).yo);
        }
        if (this.jt) {
            if (this.gy) {
                c(this.mm);
            } else {
                ve(this.nb);
            }
        }
    }

    public void sl(String str) {
        Context context = this.tt;
        tt(x.c(context, uj.tt(context, str)));
    }

    @Override // com.byazt.xj.ve
    public void sv() {
        super.sv();
        if (this.is) {
            ((UGTextView) this.n).setTextColor(this.az);
        }
        if (this.jt) {
            if (this.gy) {
                c(this.ij);
            } else {
                ve(this.cf);
            }
        }
    }

    @Override // com.byazt.sm.tt, com.byazt.xj.ve
    public void tt() {
        super.tt();
        x();
        ((UGTextView) this.n).setGravity(17);
    }

    @Override // com.byazt.sm.tt, com.byazt.xj.ve
    public void c(String str, String str2) {
        super.c(str, str2);
        str.hashCode();
        switch (str) {
            case "direction":
                this.kz = str2;
                break;
            case "highlightTextColor":
            case "highlightedTextColor":
                this.az = com.byazt.cd.c.c(str2);
                this.is = true;
                break;
            case "image":
                this.vp = str2;
                break;
            case "highlightImage":
                this.vi = str2;
                break;
            case "highlightBackgroundColor":
                if (com.byazt.cd.c.ve(str2)) {
                    this.gy = true;
                    this.ij = com.byazt.cd.c.tt(str2);
                } else {
                    this.cf = com.byazt.cd.c.c(str2);
                    this.gy = false;
                }
                this.jt = true;
                break;
            case "highlightBackgroundImage":
                this.mq = str2;
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:19:0x0037  */
    public void tt(Drawable drawable) {
        byte b;
        if (drawable == null) {
            return;
        }
        switch (this.kz) {
            case "column_reverse":
                b = 2;
                break;
            case "column":
                b = 1;
                break;
            case "row_reverse":
                b = 0;
                break;
            case "row":
                b = 3;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            ((UGTextView) this.n).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
            return;
        }
        if (b == 1) {
            ((UGTextView) this.n).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, drawable, (Drawable) null, (Drawable) null);
        } else if (b != 2) {
            ((UGTextView) this.n).setCompoundDrawablesWithIntrinsicBounds(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        } else {
            ((UGTextView) this.n).setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, drawable);
        }
    }
}
