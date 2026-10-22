package cj.mobile.wm;

import com.alibaba.android.arouter.utils.Consts;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class j0 {
    public final j0 dexa;
    public final Object dexb;
    public final Object dexc;
    public final int dexd;

    public j0(j0 j0Var, Object obj, Object obj2, int i) {
        this.dexa = j0Var;
        this.dexb = obj;
        this.dexc = obj2;
        this.dexd = i;
    }

    public String toString() {
        StringBuilder sb;
        if (this.dexa == null) {
            return "$";
        }
        if (this.dexc instanceof Integer) {
            sb = new StringBuilder();
            sb.append(this.dexa.toString());
            sb.append("[");
            sb.append(this.dexc);
            sb.append("]");
        } else {
            sb = new StringBuilder();
            sb.append(this.dexa.toString());
            sb.append(Consts.DOT);
            sb.append(this.dexc);
        }
        return sb.toString();
    }
}
