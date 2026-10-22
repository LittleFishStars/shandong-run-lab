package com.byazt.sm;

import android.content.Context;
import android.text.TextUtils;
import com.byazt.xj.ve;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 40, 20})
public class c extends ve<RichTextView> {
    public String c;
    public String cf;
    public int ij;
    public String kz;
    public int mq;
    public int vi;
    public float vp;
    public int yo;

    public c(Context context) {
        super(context);
        this.vi = Integer.MAX_VALUE;
        this.ij = 2;
    }

    private int sl(String str) {
        str.hashCode();
        switch (str) {
            case "center":
                return 17;
            case "left":
                return 3;
            case "right":
                return 5;
            default:
                return 2;
        }
    }

    @Override // com.byazt.xj.ve
    /* JADX INFO: renamed from: sp, reason: merged with bridge method [inline-methods] */
    public RichTextView c() {
        RichTextView richTextView = new RichTextView(this.tt);
        richTextView.c(this);
        return richTextView;
    }

    @Override // com.byazt.xj.ve
    public void tt() {
        super.tt();
        ((RichTextView) this.n).setRichText(this.c);
        ((RichTextView) this.n).setTextSize(1, this.vp);
        ((RichTextView) this.n).setTextColor(this.yo);
        ((RichTextView) this.n).setLines(this.mq);
        ((RichTextView) this.n).setMaxLines(this.vi);
        ((RichTextView) this.n).setGravity(this.ij);
    }

    @Override // com.byazt.xj.ve
    public void c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.c(str, str2);
        str.hashCode();
        switch (str) {
            case "textAlign":
                this.ij = sl(str2);
                break;
            case "textColor":
                this.yo = com.byazt.cd.c.c(str2);
                break;
            case "textStyle":
                this.kz = str2;
                break;
            case "textSize":
                this.vp = Float.parseFloat(str2);
                break;
            case "text":
                this.c = str2;
                break;
            case "lines":
                this.mq = Integer.parseInt(str2);
                break;
            case "maxLines":
                this.vi = Integer.parseInt(str2);
                break;
            case "ellipsize":
                this.cf = str2;
                break;
        }
    }
}
