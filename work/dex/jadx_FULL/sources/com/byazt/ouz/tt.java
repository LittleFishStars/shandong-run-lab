package com.byazt.ouz;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import com.byazt.ete.ic;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 27, 13})
public abstract class tt extends com.byazt.nc.yp {
    public Integer[] c;
    public Dialog i;
    public c x;

    @com.byazt.zqa.c(c = {0, 1, 27, MediaPlayer.MEDIA_PLAYER_OPTION_JX_CODEC_LOW_LATENCY})
    public static class c implements com.byazt.pop.c {
        public WeakReference<com.byazt.pop.c> c;
        public String tt;

        public c(com.byazt.pop.c cVar, String str) {
            this.tt = "";
            this.c = new WeakReference<>(cVar);
            this.tt = str;
        }

        public void c(com.byazt.pop.c cVar) {
            this.c = new WeakReference<>(cVar);
        }

        @Override // com.byazt.pop.c
        public void tt(long j, long j2, String str, String str2) {
            WeakReference<com.byazt.pop.c> weakReference = this.c;
            if (weakReference != null && weakReference.get() != null) {
                this.c.get().tt(j, j2, str, str2);
            }
            com.byazt.nt.c.tt(this.tt, j, j2);
        }

        @Override // com.byazt.pop.c
        public void ve(long j, long j2, String str, String str2) {
            WeakReference<com.byazt.pop.c> weakReference = this.c;
            if (weakReference != null && weakReference.get() != null) {
                this.c.get().ve(j, j2, str, str2);
            }
            com.byazt.nt.c.ve(this.tt, j, j2);
        }

        @Override // com.byazt.pop.c
        public void c() {
            WeakReference<com.byazt.pop.c> weakReference = this.c;
            if (weakReference != null && weakReference.get() != null) {
                this.c.get().c();
            }
            com.byazt.nt.c.c(this.tt);
        }

        @Override // com.byazt.pop.c
        public void c(long j, long j2, String str, String str2) {
            WeakReference<com.byazt.pop.c> weakReference = this.c;
            if (weakReference != null && weakReference.get() != null) {
                this.c.get().c(j, j2, str, str2);
            }
            com.byazt.nt.c.c(this.tt, j, j2);
        }

        @Override // com.byazt.pop.c
        public void c(long j, String str, String str2) {
            WeakReference<com.byazt.pop.c> weakReference = this.c;
            if (weakReference != null && weakReference.get() != null) {
                this.c.get().c(j, str, str2);
            }
            com.byazt.nt.c.tt(this.tt);
        }

        @Override // com.byazt.pop.c
        public void c(String str, String str2) {
            WeakReference<com.byazt.pop.c> weakReference = this.c;
            if (weakReference != null && weakReference.get() != null) {
                this.c.get().c(str, str2);
            }
            com.byazt.nt.c.ve(this.tt);
        }
    }

    public void c(Dialog dialog) {
    }

    public void c(com.byazt.vo.tt ttVar) {
        Dialog dialog;
        if (ttVar == null || (dialog = this.i) == null) {
            return;
        }
        com.byazt.pr.tt.c(ttVar, dialog, this.c);
    }

    @Override // com.byazt.nc.yp
    public void destroy() {
        if (getMaterialMeta() != null) {
            com.byazt.omf.rl.c(getMaterialMeta().rl());
            com.byazt.omf.rl.c(getMaterialMeta().lw());
        }
    }

    @Override // com.byazt.nc.yp
    public com.byazt.nc.sp getDislikeDialog(Activity activity) {
        return null;
    }

    @Override // com.byazt.nc.yp
    public com.byazt.nc.uj getDislikeInfo() {
        return null;
    }

    @Override // com.byazt.nc.yp
    public View getExpressAdView() {
        return null;
    }

    @Override // com.byazt.nc.yp
    public int getImageMode() {
        return 0;
    }

    @Override // com.byazt.nc.yp
    public int getInteractionType() {
        return 0;
    }

    public abstract ic getMaterialMeta();

    @Override // com.byazt.nc.yp
    public Map<String, Object> getMediaExtraInfo() {
        return null;
    }

    public com.byazt.ua.c getVideoModel() {
        return null;
    }

    @Override // com.byazt.nc.x
    public void loss(Double d, String str, String str2) {
    }

    @Override // com.byazt.nc.yp
    public void render() {
    }

    @Override // com.byazt.nc.x
    public void setAdInteractionListener(com.byazt.ocd.tt ttVar) {
        if (getMaterialMeta() != null) {
            com.byazt.omf.rl.c(getMaterialMeta().rl(), ttVar, com.byazt.ocd.tt.class);
        }
    }

    @Override // com.byazt.nc.yp
    public void setCanInterruptVideoPlay(boolean z) {
    }

    @Override // com.byazt.nc.yp
    public void setDislikeCallback(Activity activity, com.byazt.dhf.c cVar) {
    }

    @Override // com.byazt.nc.yp
    public void setDislikeDialog(Dialog dialog, Integer[] numArr) {
        this.i = dialog;
        this.c = numArr;
        try {
            dialog.getWindow().getDecorView().addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.byazt.ouz.tt.1
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view) {
                    if (tt.this.getMaterialMeta() != null) {
                        tt ttVar = tt.this;
                        ttVar.c(ttVar.getMaterialMeta().wq());
                    }
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view) {
                }
            });
        } catch (Throwable unused) {
        }
        c(this.i);
    }

    @Override // com.byazt.nc.yp
    public void setDownloadListener(com.byazt.ocd.ve veVar) {
    }

    @Override // com.byazt.nc.yp
    public void setExpressInteractionListener(com.byazt.ft.c cVar) {
    }

    @Override // com.byazt.nc.yp
    public void setExpressInteractionListener(com.byazt.ft.tt ttVar) {
    }

    @Override // com.byazt.nc.x
    public void setPrice(Double d) {
    }

    @Override // com.byazt.nc.yp
    public void setSlideIntervalTime(int i) {
    }

    @Override // com.byazt.nc.yp
    public void setVideoAdListener(com.byazt.ft.ve veVar) {
    }

    @Override // com.byazt.nc.yp
    public void showInteractionExpressAd(Activity activity) {
    }

    @Override // com.byazt.nc.x
    public void win(Double d) {
    }
}
