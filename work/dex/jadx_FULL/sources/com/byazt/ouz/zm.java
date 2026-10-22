package com.byazt.ouz;

import android.content.Context;
import com.byazt.ete.ic;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 27, 482})
public class zm extends gu {
    public zm(Context context, ic icVar, com.byazt.dj.tt ttVar, int i) {
        super(context, icVar, ttVar, i);
    }

    @Override // com.byazt.ouz.tt
    public com.byazt.ua.c getVideoModel() {
        WeakReference<u> weakReference = this.n;
        if (weakReference != null && weakReference.get() != null) {
            return this.n.get().getVideoModel();
        }
        NativeExpressView nativeExpressView = ((gu) this).c;
        if (!(nativeExpressView instanceof NativeExpressVideoView)) {
            return null;
        }
        ((NativeExpressVideoView) nativeExpressView).yp();
        return ((NativeExpressVideoView) ((gu) this).c).getVideoModel();
    }

    @Override // com.byazt.ouz.gu
    public void initExpressView(Context context, ic icVar, com.byazt.dj.tt ttVar) {
        NativeExpressVideoView nativeExpressVideoView = new NativeExpressVideoView(context, icVar, ttVar, com.byazt.dyf.tt.AD_TAG_FEED);
        ((gu) this).c = nativeExpressVideoView;
        c(nativeExpressVideoView, this.ve);
    }

    @Override // com.byazt.ouz.tt, com.byazt.nc.yp
    public void setVideoAdListener(final com.byazt.ft.ve veVar) {
        NativeExpressView nativeExpressView = ((gu) this).c;
        if (nativeExpressView != null) {
            nativeExpressView.setVideoAdListener(new com.byazt.dh.ve.uj() { // from class: com.byazt.ouz.zm.1
                @Override // com.byazt.dh.ve.uj
                public void onVideoError(int i, int i2) {
                    com.byazt.ft.ve veVar2 = veVar;
                    if (veVar2 != null) {
                        veVar2.c(i, i2);
                    }
                }

                @Override // com.byazt.dh.ve.uj
                public void onVideoLoad() {
                    com.byazt.ft.ve veVar2 = veVar;
                    if (veVar2 != null) {
                        veVar2.c();
                    }
                }
            });
            ((gu) this).c.setVideoAdInteractionListener(new com.byazt.dh.ve.InterfaceC0386ve() { // from class: com.byazt.ouz.zm.2
                @Override // com.byazt.dh.ve.InterfaceC0386ve
                public void onProgressUpdate(long j, long j2) {
                    com.byazt.ft.ve veVar2 = veVar;
                    if (veVar2 != null) {
                        veVar2.c(j, j2);
                    }
                }

                @Override // com.byazt.dh.ve.InterfaceC0386ve
                public void onVideoAdContinuePlay() {
                    com.byazt.ft.ve veVar2 = veVar;
                    if (veVar2 != null) {
                        veVar2.uj();
                    }
                }

                @Override // com.byazt.dh.ve.InterfaceC0386ve
                public void onVideoAdPaused() {
                    com.byazt.ft.ve veVar2 = veVar;
                    if (veVar2 != null) {
                        veVar2.ve();
                    }
                }

                @Override // com.byazt.dh.ve.InterfaceC0386ve
                public void onVideoAdStartPlay() {
                    com.byazt.ft.ve veVar2 = veVar;
                    if (veVar2 != null) {
                        veVar2.tt();
                    }
                }

                @Override // com.byazt.dh.ve.InterfaceC0386ve
                public void onVideoComplete() {
                    com.byazt.ft.ve veVar2 = veVar;
                    if (veVar2 != null) {
                        veVar2.n();
                    }
                }
            });
        }
    }
}
