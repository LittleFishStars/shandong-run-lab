package com.byazt.feb;

import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.byazt.omf.x;
import com.byazt.pik.n;
import com.byazt.pik.ve;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONArray;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_CONFIG_CACHED, 13})
public class tt {
    public static tt c;
    public List<ve> tt = new CopyOnWriteArrayList();
    public Handler ve;

    private tt() {
        if (com.byazt.jze.tt.c() != null) {
            this.ve = new Handler(com.byazt.jze.tt.c().getLooper()) { // from class: com.byazt.feb.tt.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    if (message.what == 1) {
                        Object obj = message.obj;
                        if (obj instanceof String) {
                            String str = (String) obj;
                            c.c().c(str);
                            ve veVarC = tt.this.c(str);
                            if (veVarC != null) {
                                tt.this.c(veVarC);
                            }
                        }
                    }
                }
            };
        }
    }

    private void ve() {
        this.ve.removeMessages(1);
    }

    public List<ve> tt() {
        return this.tt;
    }

    public static tt c() {
        if (c == null) {
            synchronized (tt.class) {
                if (c == null) {
                    c = new tt();
                }
            }
        }
        return c;
    }

    private void c(List<ve> list) {
        ve();
        this.tt.clear();
        if (list != null) {
            this.tt.addAll(list);
            Iterator<ve> it = list.iterator();
            while (it.hasNext()) {
                c(it.next());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(ve veVar) {
        n nVarUj;
        if (veVar == null || this.ve == null || x.m().d() || (nVarUj = veVar.uj()) == null || !nVarUj.ve() || nVarUj.tt() <= 0) {
            return;
        }
        String strC = veVar.c();
        this.ve.removeMessages(1, strC);
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.obj = strC;
        this.ve.sendMessageDelayed(messageObtain, nVarUj.tt() * 1000);
    }

    public void c(JSONArray jSONArray) {
        c(com.byazt.jze.c.c(jSONArray));
    }

    public ve c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        for (ve veVar : this.tt) {
            if (str.equals(veVar.c())) {
                return veVar;
            }
        }
        return null;
    }
}
