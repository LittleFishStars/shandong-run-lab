package cj.mobile.wm;

import android.content.Context;
import android.provider.Settings;
import com.hjq.permissions.Permission;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
import java.util.regex.Pattern;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class uc {
    public static uc dexj;
    public Context dexa;
    public wc dexc;
    public String dexd;
    public String dexe;
    public oc dexf;
    public oc dexg;
    public static final Object dexi = new Object();
    public static final String dexk = ".UTSystemConfig" + File.separator + "Global";
    public String dexb = null;
    public Pattern dexh = Pattern.compile("[^0-9a-zA-Z=/+]+");

    public uc(Context context) {
        this.dexa = null;
        this.dexc = null;
        this.dexd = "xx_utdid_key";
        this.dexe = "xx_utdid_domain";
        this.dexf = null;
        this.dexg = null;
        this.dexa = context;
        this.dexg = new oc(context, dexk, "Alvin2", false, true);
        this.dexf = new oc(context, ".DataStorage", "ContextData", false, true);
        this.dexc = new wc();
        this.dexd = String.format("K_%d", Integer.valueOf(lc.dexa(this.dexd)));
        this.dexe = String.format("D_%d", Integer.valueOf(lc.dexa(this.dexe)));
    }

    public static uc dexa(Context context) {
        if (context != null && dexj == null) {
            synchronized (dexi) {
                if (dexj == null) {
                    uc ucVar = new uc(context);
                    dexj = ucVar;
                    ucVar.dexd();
                }
            }
        }
        return dexj;
    }

    public static String dexa(byte[] bArr) throws NoSuchAlgorithmException, InvalidKeyException {
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(new SecretKeySpec("d6fc3a4a06adbde89223bvefedc24fecde188aaa9161".getBytes(), mac.getAlgorithm()));
        return jc.dexc(mac.doFinal(bArr), 2);
    }

    private boolean dexa(String str) {
        if (str != null) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (24 == str.length() && !this.dexh.matcher(str).find()) {
                return true;
            }
        }
        return false;
    }

    private void dexb(String str) throws Throwable {
        oc ocVar;
        if (str == null || (ocVar = this.dexf) == null || str.equals(ocVar.dexa(this.dexd))) {
            return;
        }
        this.dexf.dexa(this.dexd, str);
        this.dexf.dexa();
    }

    private void dexc(String str) {
        String string;
        if (dexe() && dexa(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (24 == str.length()) {
                try {
                    string = Settings.System.getString(this.dexa.getContentResolver(), "mqBRboGZkQPcAkyk");
                } catch (Exception unused) {
                    string = null;
                }
                if (dexa(string)) {
                    return;
                }
                try {
                    Settings.System.putString(this.dexa.getContentResolver(), "mqBRboGZkQPcAkyk", str);
                } catch (Exception unused2) {
                }
            }
        }
    }

    private final byte[] dexc() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int iCurrentTimeMillis = (int) (System.currentTimeMillis() / 1000);
        int iNextInt = new Random().nextInt();
        byte[] bArrDexa = kc.dexa(iCurrentTimeMillis);
        byte[] bArrDexa2 = kc.dexa(iNextInt);
        byteArrayOutputStream.write(bArrDexa, 0, 4);
        byteArrayOutputStream.write(bArrDexa2, 0, 4);
        byteArrayOutputStream.write(3);
        byteArrayOutputStream.write(0);
        byteArrayOutputStream.write(kc.dexa(lc.dexa("")), 0, 4);
        byteArrayOutputStream.write(kc.dexa(lc.dexa(dexa(byteArrayOutputStream.toByteArray()))));
        return byteArrayOutputStream.toByteArray();
    }

    private void dexd() throws Throwable {
        boolean z;
        oc ocVar = this.dexg;
        if (ocVar != null) {
            if (lc.dexb(ocVar.dexa("UTDID2"))) {
                String strDexa = this.dexg.dexa("UTDID");
                if (!lc.dexb(strDexa)) {
                    dexe(strDexa);
                }
            }
            boolean z2 = true;
            if (lc.dexb(this.dexg.dexa("DID"))) {
                z = false;
            } else {
                this.dexg.dexb("DID");
                z = true;
            }
            if (!lc.dexb(this.dexg.dexa("EI"))) {
                this.dexg.dexb("EI");
                z = true;
            }
            if (lc.dexb(this.dexg.dexa("SI"))) {
                z2 = z;
            } else {
                this.dexg.dexb("SI");
            }
            if (z2) {
                this.dexg.dexa();
            }
        }
    }

    private void dexd(String str) {
        if (!dexe() || str == null) {
            return;
        }
        dexf(str);
    }

    private void dexe(String str) throws Throwable {
        oc ocVar;
        if (dexa(str)) {
            if (str.endsWith("\n")) {
                str = str.substring(0, str.length() - 1);
            }
            if (str.length() != 24 || (ocVar = this.dexg) == null) {
                return;
            }
            ocVar.dexa("UTDID2", str);
            this.dexg.dexa();
        }
    }

    private boolean dexe() {
        return this.dexa.checkCallingPermission(Permission.WRITE_SETTINGS) == 0;
    }

    private String dexf() throws Throwable {
        oc ocVar = this.dexg;
        if (ocVar == null) {
            return null;
        }
        String strDexa = ocVar.dexa("UTDID2");
        if (lc.dexb(strDexa) || this.dexc.dexb(strDexa) == null) {
            return null;
        }
        return strDexa;
    }

    private void dexf(String str) {
        String string;
        try {
            string = Settings.System.getString(this.dexa.getContentResolver(), "dxCRMxhQkdGePGnp");
        } catch (Exception unused) {
            string = null;
        }
        if (str.equals(string)) {
            return;
        }
        try {
            Settings.System.putString(this.dexa.getContentResolver(), "dxCRMxhQkdGePGnp", str);
        } catch (Exception unused2) {
        }
    }

    public synchronized String dexa() {
        String strDexb;
        strDexb = this.dexb;
        if (strDexb == null) {
            strDexb = dexb();
        }
        return strDexb;
    }

    public synchronized String dexb() {
        String string;
        boolean z;
        String string2 = "";
        try {
            string2 = Settings.System.getString(this.dexa.getContentResolver(), "mqBRboGZkQPcAkyk");
        } catch (Exception unused) {
        }
        if (dexa(string2)) {
            return string2;
        }
        vc vcVar = new vc();
        try {
            string = Settings.System.getString(this.dexa.getContentResolver(), "dxCRMxhQkdGePGnp");
        } catch (Exception unused2) {
            string = null;
        }
        if (lc.dexb(string)) {
            z = true;
        } else {
            String strDexb = vcVar.dexb(string);
            if (dexa(strDexb)) {
                dexc(strDexb);
                return strDexb;
            }
            String strDexa = vcVar.dexa(string);
            if (dexa(strDexa)) {
                String strDexb2 = this.dexc.dexb(strDexa);
                if (!lc.dexb(strDexb2)) {
                    dexd(strDexb2);
                    try {
                        string = Settings.System.getString(this.dexa.getContentResolver(), "dxCRMxhQkdGePGnp");
                    } catch (Exception unused3) {
                    }
                }
            }
            String strDexa2 = this.dexc.dexa(string);
            if (dexa(strDexa2)) {
                this.dexb = strDexa2;
                dexe(strDexa2);
                dexb(string);
                dexc(this.dexb);
                return this.dexb;
            }
            z = false;
        }
        String strDexf = dexf();
        if (dexa(strDexf)) {
            String strDexb3 = this.dexc.dexb(strDexf);
            if (z) {
                dexd(strDexb3);
            }
            dexc(strDexf);
            dexb(strDexb3);
            this.dexb = strDexf;
            return strDexf;
        }
        String strDexa3 = this.dexf.dexa(this.dexd);
        if (!lc.dexb(strDexa3)) {
            String strDexa4 = vcVar.dexa(strDexa3);
            if (!dexa(strDexa4)) {
                strDexa4 = this.dexc.dexa(strDexa3);
            }
            if (dexa(strDexa4)) {
                String strDexb4 = this.dexc.dexb(strDexa4);
                if (!lc.dexb(strDexa4)) {
                    this.dexb = strDexa4;
                    if (z) {
                        dexd(strDexb4);
                    }
                    dexe(this.dexb);
                    return this.dexb;
                }
            }
        }
        try {
            byte[] bArrDexc = dexc();
            if (bArrDexc != null) {
                String strDexc = jc.dexc(bArrDexc, 2);
                this.dexb = strDexc;
                dexe(strDexc);
                String strDexa5 = this.dexc.dexa(bArrDexc);
                if (strDexa5 != null) {
                    if (z) {
                        dexd(strDexa5);
                    }
                    dexb(strDexa5);
                }
                return this.dexb;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
