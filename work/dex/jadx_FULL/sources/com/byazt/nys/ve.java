package com.byazt.nys;

import android.annotation.SuppressLint;
import android.content.Context;
import android.taobao.windvane.util.WVNativeCallbackUtil;
import android.text.TextUtils;
import android.util.SparseArray;
import com.alibaba.baichuan.log.TLogConstant;
import com.bykv.vk.openvk.api.proto.EventListener;
import com.bykv.vk.openvk.api.proto.Result;
import com.bykv.vk.openvk.api.proto.ValueSet;
import com.huachenjie.base.interact.bean.WorksInteractEventBean;
import com.zj.adlib.c49;
import java.io.File;
import java.util.List;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, WorksInteractEventBean.EVENT_TYPE_COMMENT_ALUMNI_SAY_LIKE, 54})
public class ve {
    public static final String c;
    public static final String tt;

    @SuppressLint({"StaticFieldLeak"})
    public static volatile ve ve;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public x.c f28859a;
    public final Function<SparseArray<Object>, Object> n = new i.ve();
    public volatile boolean sp;
    public final Context uj;

    static {
        StringBuilder sb = new StringBuilder();
        String str = File.separator;
        sb.append(str);
        sb.append("next");
        c = sb.toString();
        tt = str + TLogConstant.RUBBISH_DIR;
    }

    private ve(Context context) {
        this.uj = context;
    }

    private File tt() {
        return new File(c(), tt);
    }

    private File ve() {
        return new File(c(), c);
    }

    public static ve c(Context context) {
        if (ve == null) {
            synchronized (ve.class) {
                if (ve == null) {
                    ve = new ve(context);
                }
            }
        }
        return ve;
    }

    public void c(List<x.c> list) {
        if (list != null && !list.isEmpty()) {
            x.c cVar = list.get(0);
            this.f28859a = cVar;
            if (TextUtils.isEmpty(cVar.ve)) {
                return;
            }
            String str = this.f28859a.c + c49.f40900a + this.f28859a.tt + c49.f40900a + this.f28859a.f28860a + c49.f40900a + this.f28859a.sp + ".apk";
            File fileVe = ve();
            File file = new File(fileVe, str);
            if (file.exists()) {
                n.c("plugin_download", "plugin file already exists");
                com.byazt.bog.a.tt("FileDownloadTask", "Plugin file already exists.");
                this.f28859a.i = file.getAbsolutePath();
                x.c cVar2 = this.f28859a;
                cVar2.da = cVar2.tt < 7611;
                c(true, cVar2.c, cVar2.toString());
                return;
            }
            File fileTt = tt();
            if (!fileVe.exists()) {
                fileVe.mkdirs();
            }
            if (!fileTt.exists()) {
                fileTt.mkdirs();
            }
            c(this.f28859a.ve, fileVe.getAbsolutePath(), fileTt.getAbsolutePath(), str);
            return;
        }
        n.c("plugin_download", "plugin is empty");
    }

    private void c(String str, String str2, String str3, String str4) {
        if (this.sp) {
            com.byazt.bog.a.tt("FileDownloadTask", "Downloading...");
            return;
        }
        this.sp = true;
        try {
            File file = new File(str2 + WVNativeCallbackUtil.SEPERATER + str4);
            if (file.exists()) {
                file.delete();
            }
            com.byazt.uc.ve.c().c(str, str2, str4, new EventListener() { // from class: com.byazt.nys.ve.1
                @Override // com.bykv.vk.openvk.api.proto.EventListener
                public ValueSet onEvent(int i, Result result) {
                    ve.this.sp = false;
                    if (i != 0) {
                        String strMessage = result.message();
                        n.c("plugin_download", "download failed: ".concat(String.valueOf(strMessage)));
                        com.byazt.bog.a.n("FileDownloadTask", "Download failed. ".concat(String.valueOf(strMessage)));
                        ve veVar = ve.this;
                        veVar.c(false, veVar.f28859a.c, ve.this.f28859a.toString());
                        return null;
                    }
                    n.c("plugin_download", "download success");
                    ve.this.f28859a.i = result.message();
                    com.byazt.bog.a.tt("FileDownloadTask", "Download end." + ve.this.f28859a.i);
                    ve.this.f28859a.da = ve.this.f28859a.tt < 7611;
                    ve veVar2 = ve.this;
                    veVar2.c(true, veVar2.f28859a.c, ve.this.f28859a.toString());
                    return null;
                }
            });
            n.c("plugin_download", "start download");
            com.byazt.bog.a.tt("FileDownloadTask", "Download start.");
        } catch (Throwable th) {
            n.c("plugin_download", "download error: ".concat(String.valueOf(th)));
            com.byazt.bog.a.n("FileDownloadTask", "Download file error: ".concat(String.valueOf(th)));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(boolean z, String str, String str2) {
        ValueSet valueSetTt = com.byazt.rl.ve.c().c(-999900, z ? 0 : 1004).c(-999903, z).c(-999902, com.byazt.rl.ve.c().c(2, str2).c(3, str).tt().sparseArray()).tt();
        SparseArray<Object> sparseArray = new SparseArray<>();
        sparseArray.put(-99999987, 1);
        sparseArray.put(-99999985, Void.class);
        sparseArray.put(-99999979, valueSetTt.sparseArray());
        this.n.apply(sparseArray);
    }

    private File c() {
        return tt.c(this.uj, "tt_pangle_bykv_file", 0);
    }
}
