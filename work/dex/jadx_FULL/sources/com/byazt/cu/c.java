package com.byazt.cu;

import android.content.Context;
import android.text.TextUtils;
import android.widget.EditText;
import com.byazt.xj.ve;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 121, 20})
public class c extends ve<EditText> {
    public String az;
    public int c;
    public String cf;
    public int ij;
    public String is;
    public String kz;
    public int mq;
    public int vi;
    public float vp;
    public int yo;

    public c(Context context) {
        super(context);
        this.c = 1;
        this.vi = Integer.MAX_VALUE;
        this.ij = 2;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:20:0x003d  */
    private int sl(String str) {
        byte b;
        switch (str) {
            case "number":
                b = 2;
                break;
            case "text":
                b = 4;
                break;
            case "email":
                b = 3;
                break;
            case "phone":
                b = 1;
                break;
            case "password":
                b = 0;
                break;
            default:
                b = -1;
                break;
        }
        if (b == 0) {
            return 128;
        }
        if (b == 1) {
            return 3;
        }
        if (b != 2) {
            return b != 3 ? 1 : 32;
        }
        return 2;
    }

    private int t(String str) {
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
    public EditText c() {
        UGEditText uGEditText = new UGEditText(this.tt);
        uGEditText.c(this);
        return uGEditText;
    }

    @Override // com.byazt.xj.ve
    public void tt() {
        super.tt();
        ((EditText) this.n).setInputType(this.c);
        ((EditText) this.n).setText(this.az);
        ((EditText) this.n).setTextSize(1, this.vp);
        ((EditText) this.n).setTextColor(this.yo);
        ((EditText) this.n).setLines(this.mq);
        ((EditText) this.n).setMaxLines(this.vi);
        ((EditText) this.n).setGravity(this.ij);
        ((EditText) this.n).setHint(this.is);
    }

    @Override // com.byazt.xj.ve
    public void c(String str, String str2) {
        if (TextUtils.isEmpty(str)) {
        }
        super.c(str, str2);
        str.hashCode();
        switch (str) {
            case "textAlign":
                this.ij = t(str2);
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
            case "hint":
                this.is = str2;
                break;
            case "text":
                this.az = str2;
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
            case "inputType":
                this.c = sl(str2);
                break;
        }
    }
}
