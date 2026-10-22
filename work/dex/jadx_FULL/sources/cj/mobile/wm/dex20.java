package cj.mobile.wm;

import com.alibaba.android.arouter.utils.Consts;
import java.lang.reflect.Type;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class dex20 {
    public Object dexa;
    public final dex20 dexb;
    public final Object dexc;
    public Type dexd;
    public transient String dexe;

    public dex20(dex20 dex20Var, Object obj, Object obj2) {
        this.dexb = dex20Var;
        this.dexa = obj;
        this.dexc = obj2;
    }

    public String toString() {
        StringBuilder sb;
        String string;
        if (this.dexe == null) {
            if (this.dexb == null) {
                string = "$";
            } else {
                if (this.dexc instanceof Integer) {
                    sb = new StringBuilder();
                    sb.append(this.dexb.toString());
                    sb.append("[");
                    sb.append(this.dexc);
                    sb.append("]");
                } else {
                    sb = new StringBuilder();
                    sb.append(this.dexb.toString());
                    sb.append(Consts.DOT);
                    sb.append(this.dexc);
                }
                string = sb.toString();
            }
            this.dexe = string;
        }
        return this.dexe;
    }
}
