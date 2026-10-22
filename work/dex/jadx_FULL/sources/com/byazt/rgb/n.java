package com.byazt.rgb;

import android.text.TextUtils;
import com.alibaba.ariver.engine.api.bridge.model.NativeCallContext;
import com.byazt.dna.gu;
import com.byazt.ky.sp;
import com.byazt.omf.gt;
import com.byazt.omf.x;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_OUTLET_DROPCOUNT_ONCE, 46})
public class n {
    public static String c;
    public static AtomicBoolean tt = new AtomicBoolean(false);
    public static String n = "tt_csj_node_line_app_exit";
    public static AtomicBoolean ve = new AtomicBoolean(false);
    public static com.byazt.aas.c.tt uj = new com.byazt.aas.c.tt() { // from class: com.byazt.rgb.n.1
        @Override // com.byazt.aas.c.tt
        public void onAppBackground() {
            if (x.m().d()) {
                return;
            }
            n.c(n.c);
        }

        @Override // com.byazt.aas.c.tt
        public void onAppExit() {
            if (x.m().d()) {
                return;
            }
            n.tt(n.c, 1);
        }

        @Override // com.byazt.aas.c.tt
        public void onAppForeground() {
            int i;
            if (x.m().d()) {
                return;
            }
            if (n.ve.get()) {
                n.ve.set(false);
                i = 1;
            } else {
                i = 2;
            }
            n.c(n.c, i);
        }

        @Override // com.byazt.aas.c.tt
        public void onAppStart() {
            if (x.m().d()) {
                return;
            }
            n.c(2);
        }
    };

    public static void c(int i) {
        if (tt.get()) {
            return;
        }
        if (TextUtils.isEmpty(c)) {
            c = ve();
        }
        com.byazt.lh.a aVarC = c();
        aVarC.tt(c, com.byazt.vxy.c.uj());
        aVarC.c(c, new sp());
        c(c, i == 1 ? com.byazt.qw.ve.ve().c() : System.currentTimeMillis(), i);
        if (i == 1) {
            if (x.m().ve().tt()) {
                c(c);
            } else {
                c(c, 1);
            }
        }
    }

    public static void tt(String str, int i) {
        com.byazt.lh.a aVarC = c();
        if (aVarC != null) {
            com.byazt.ip.x xVar = new com.byazt.ip.x(System.currentTimeMillis());
            xVar.c("source", Integer.valueOf(i));
            aVarC.c(str, com.byazt.hi.a.END, xVar);
        }
        tt.set(false);
        String string = UUID.randomUUID().toString();
        c = string;
        ve(string);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x001c  */
    private static String ve() {
        String string;
        gu guVar = (gu) com.byazt.ut.uj.getService("m_d_s");
        if (guVar != null) {
            Object data = guVar.getData(2);
            if (data instanceof String) {
                string = (String) data;
                if (TextUtils.isEmpty(string)) {
                    string = UUID.randomUUID().toString();
                    guVar.setData(2, string);
                }
            } else {
                string = UUID.randomUUID().toString();
                guVar.setData(2, string);
            }
        } else {
            string = null;
        }
        return TextUtils.isEmpty(string) ? UUID.randomUUID().toString() : string;
    }

    public static void tt() {
        if (gt.tt().vl()) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.putOpt("l_type", NativeCallContext.DOMAIN_APP);
                jSONObject.putOpt("type", "end");
                jSONObject.putOpt("ts", Long.valueOf(System.currentTimeMillis()));
                jSONObject.putOpt("source", 2);
                tt(com.byazt.vxy.c.uj()).put(com.byazt.qcl.c.c(NativeCallContext.DOMAIN_APP) + c, jSONObject.toString());
            } catch (Throwable unused) {
            }
        }
        tt(c, 2);
    }

    private static void ve(String str) {
        gu guVar = (gu) com.byazt.ut.uj.getService("m_d_s");
        if (guVar != null) {
            guVar.setData(2, str);
        }
    }

    public static void c(String str, long j, int i) {
        tt.set(true);
        if (i == 2) {
            ve.set(true);
        }
        com.byazt.lh.a aVarC = c();
        if (aVarC != null) {
            com.byazt.ip.x xVar = new com.byazt.ip.x(j);
            xVar.c("source", Integer.valueOf(i));
            aVarC.c(str, com.byazt.hi.a.STARTED, xVar);
        }
    }

    public static com.byazt.it.ve tt(String str) {
        return com.byazt.vif.uj.c(str, n);
    }

    public static void c(String str, int i) {
        com.byazt.lh.a aVarC = c();
        if (aVarC != null) {
            com.byazt.ip.x xVar = new com.byazt.ip.x(System.currentTimeMillis());
            xVar.c("source", Integer.valueOf(i));
            aVarC.c(str, com.byazt.hi.a.FOREGROUNDED, xVar);
        }
    }

    public static void c(String str) {
        com.byazt.lh.a aVarC = c();
        if (aVarC != null) {
            aVarC.c(str, com.byazt.hi.a.BACKGROUNDED);
        }
    }

    public static com.byazt.lh.a c() {
        return (com.byazt.lh.a) com.byazt.ip.n.c(4);
    }
}
