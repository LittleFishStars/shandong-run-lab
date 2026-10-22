package com.byazt.rs;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import com.byazt.yj.gr;
import com.byazt.yj.m;
import com.byazt.yj.md;
import com.byazt.yj.yv;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.io.File;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_DECODE_SEI_ONCE, 20})
public class c {
    public static volatile c c;
    public Context tt;

    private c() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tt(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        x.c().tt(str);
    }

    public static c c() {
        if (c == null) {
            synchronized (c.class) {
                if (c == null) {
                    c = new c();
                }
            }
        }
        return c;
    }

    public void c(Context context) {
        if (context == null || this.tt != null) {
            return;
        }
        this.tt = context.getApplicationContext();
    }

    public void c(com.byazt.ga.a.tt ttVar, String str, i iVar) {
        uj ujVar;
        if (iVar == null) {
            return;
        }
        if (a.c().ve()) {
            iVar.c();
            return;
        }
        if (ttVar != null && (ujVar = ttVar.x) != null) {
            String strC = ujVar.c();
            if (TextUtils.isEmpty(strC)) {
                iVar.c();
                return;
            }
            String strVe = x.c().ve(strC);
            if (TextUtils.isEmpty(strVe)) {
                iVar.c();
                return;
            }
            String strC2 = c(str);
            if (TextUtils.isEmpty(strC2)) {
                iVar.c();
                return;
            } else if (!new File(strVe, strC2).exists()) {
                iVar.c();
                return;
            } else {
                c(strC, strVe, strC2, iVar);
                return;
            }
        }
        iVar.c();
    }

    private String c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (!str.startsWith("http")) {
            return str;
        }
        try {
            String lastPathSegment = Uri.parse(str).getLastPathSegment();
            if (!TextUtils.isEmpty(lastPathSegment)) {
                return lastPathSegment;
            }
            int iLastIndexOf = str.lastIndexOf(47);
            return (iLastIndexOf < 0 || iLastIndexOf >= str.length() + (-1)) ? str : str.substring(iLastIndexOf + 1);
        } catch (Exception unused) {
            return str;
        }
    }

    private void c(final String str, String str2, String str3, final i iVar) {
        ((yv) com.byazt.ut.uj.getService("local_img_loader")).from(c(str2, str3)).cacheDir(str2).isLocalRes(true).sync(false).config(Bitmap.Config.ARGB_8888).type(2).to(new gr() { // from class: com.byazt.rs.c.1
            @Override // com.byazt.yj.gr
            public void onFailed(int i, String str4, Throwable th) {
                iVar.c();
            }

            @Override // com.byazt.yj.gr
            public void onSuccess(m mVar) {
                Bitmap bitmap = mVar != null ? (Bitmap) mVar.getResult() : null;
                if (bitmap == null || bitmap.isRecycled()) {
                    iVar.c();
                } else {
                    c.this.tt(str);
                    iVar.c(bitmap);
                }
            }
        });
    }

    private static md c(final String str, final String str2) {
        return new md() { // from class: com.byazt.rs.c.2
            @Override // com.byazt.yj.md
            public SparseArray<Object> extra() {
                return null;
            }

            @Override // com.byazt.yj.md
            public String getCacheDir() {
                return str;
            }

            @Override // com.byazt.yj.md
            public int getMemoryCacheSize() {
                return 1048576;
            }

            @Override // com.byazt.yj.md
            public String getName() {
                return str2;
            }

            @Override // com.byazt.yj.md
            public int getRawCacheSize() {
                return 0;
            }
        };
    }
}
