package com.byazt.ng;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_SEEK_INTERRUPT, 158})
public class sl implements com.byazt.vb.a {
    public static final sl c = new sl();
    public volatile SQLiteDatabase tt;

    @Override // com.byazt.vb.a
    public String a() {
        return null;
    }

    @Override // com.byazt.vb.a
    public SQLiteDatabase c(Context context) {
        if (this.tt == null) {
            synchronized (this) {
                if (this.tt == null) {
                    this.tt = com.byazt.jd.a.c(context).c().c();
                    com.byazt.eu.tt.c("---------------DB CREATE  SUCCESS new------------");
                }
            }
        }
        return this.tt;
    }

    @Override // com.byazt.vb.a
    public String c() {
        return null;
    }

    @Override // com.byazt.vb.a
    public String n() {
        return null;
    }

    @Override // com.byazt.vb.a
    public String tt() {
        return "adevent";
    }

    @Override // com.byazt.vb.a
    public String uj() {
        return null;
    }

    @Override // com.byazt.vb.a
    public String ve() {
        return "adevent_applog";
    }
}
