package cj.mobile.wm;

import android.net.Uri;
import android.text.TextUtils;
import java.net.URL;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class n4 {
    public final URL dexa;
    public final o4 dexb;
    public final String dexc;
    public String dexd;
    public URL dexe;

    public n4(String str) {
        this(str, o4.dexb);
    }

    public n4(String str, o4 o4Var) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("String url must not be empty or null: " + str);
        }
        if (o4Var == null) {
            throw new IllegalArgumentException("Headers must not be null");
        }
        this.dexc = str;
        this.dexa = null;
        this.dexb = o4Var;
    }

    public n4(URL url) {
        this(url, o4.dexb);
    }

    public n4(URL url, o4 o4Var) {
        if (url == null) {
            throw new IllegalArgumentException("URL must not be null!");
        }
        if (o4Var == null) {
            throw new IllegalArgumentException("Headers must not be null");
        }
        this.dexa = url;
        this.dexc = null;
        this.dexb = o4Var;
    }

    private String dexd() {
        if (TextUtils.isEmpty(this.dexd)) {
            String string = this.dexc;
            if (TextUtils.isEmpty(string)) {
                string = this.dexa.toString();
            }
            this.dexd = Uri.encode(string, "@#&=*+-_.,:!?()/~'%");
        }
        return this.dexd;
    }

    private URL dexe() {
        if (this.dexe == null) {
            this.dexe = new URL(dexd());
        }
        return this.dexe;
    }

    public String dexa() {
        String str = this.dexc;
        return str != null ? str : this.dexa.toString();
    }

    public Map<String, String> dexb() {
        return this.dexb.a();
    }

    public URL dexc() {
        return dexe();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof n4)) {
            return false;
        }
        n4 n4Var = (n4) obj;
        return dexa().equals(n4Var.dexa()) && this.dexb.equals(n4Var.dexb);
    }

    public int hashCode() {
        return (dexa().hashCode() * 31) + this.dexb.hashCode();
    }

    public String toString() {
        return dexa() + '\n' + this.dexb.toString();
    }
}
