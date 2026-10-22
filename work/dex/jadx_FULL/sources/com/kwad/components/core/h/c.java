package com.kwad.components.core.h;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.kwad.components.core.video.i;
import com.kwad.sdk.core.imageloader.core.assist.FailReason;
import com.kwad.sdk.core.imageloader.core.decode.DecodedResult;
import com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class c implements ImageLoadingListener {

    @Nullable
    private a SA;
    private long SD;
    private b Sz;
    private long ky;
    private int SB = 1;
    private int SC = 16;
    private List<i> SE = new CopyOnWriteArrayList();

    /* JADX INFO: renamed from: com.kwad.components.core.h.c$6, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType;

        static {
            int[] iArr = new int[FailReason.FailType.values().length];
            $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType = iArr;
            try {
                iArr[FailReason.FailType.IO_ERROR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.DECODING_ERROR.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.NETWORK_DENIED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.OUT_OF_MEMORY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[FailReason.FailType.UNKNOWN.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public c() {
        a aVar = new a(new Handler(Looper.getMainLooper()));
        this.SA = aVar;
        aVar.a(new a.InterfaceC1202a() { // from class: com.kwad.components.core.h.c.1
            private boolean SF = false;
            private boolean SG = false;

            private void mB() {
                if (this.SF) {
                    return;
                }
                c.this.c(new com.kwad.sdk.g.a<i>() { // from class: com.kwad.components.core.h.c.1.2
                    private static void e(i iVar) {
                        iVar.onMediaPlayCompleted();
                    }

                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(i iVar) {
                        e(iVar);
                    }
                });
                this.SF = true;
            }

            private void qZ() {
                if (this.SG) {
                    return;
                }
                com.kwad.sdk.core.d.c.d("KSImagePlayer", "onFirstFrame: ");
                this.SG = true;
                c.this.c(new com.kwad.sdk.g.a<i>() { // from class: com.kwad.components.core.h.c.1.3
                    private static void e(i iVar) {
                        iVar.onMediaPlayStart();
                    }

                    @Override // com.kwad.sdk.g.a
                    public final /* synthetic */ void accept(i iVar) {
                        e(iVar);
                    }
                });
            }

            @Override // com.kwad.components.core.h.a.InterfaceC1202a
            public final void G(final long j) {
                com.kwad.sdk.core.d.c.d("KSImagePlayer", "onTimerProgress: " + j);
                if (j == 0) {
                    qZ();
                }
                c.this.ky = j;
                c.this.c(new com.kwad.sdk.g.a<i>() { // from class: com.kwad.components.core.h.c.1.1
                    /* JADX INFO: Access modifiers changed from: private */
                    @Override // com.kwad.sdk.g.a
                    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
                    public void accept(i iVar) {
                        iVar.onMediaPlayProgress(c.this.SD, j);
                    }
                });
                if (c.this.ky < c.this.SD || c.this.SD <= 0) {
                    return;
                }
                mB();
            }
        });
    }

    public static /* synthetic */ int a(c cVar, FailReason.FailType failType) {
        return a(failType);
    }

    private void qY() {
        b bVar = this.Sz;
        if (bVar != null) {
            bVar.setImageGravity(this.SB | this.SC);
        }
    }

    public final void H(long j) {
        this.SD = j;
    }

    public final void c(i iVar) {
        if (iVar != null) {
            this.SE.add(iVar);
        }
    }

    public final void d(i iVar) {
        if (iVar != null) {
            this.SE.remove(iVar);
        }
    }

    public final void destroy() {
        this.SE.clear();
        b bVar = this.Sz;
        if (bVar != null && bVar.getParent() != null) {
            ((ViewGroup) this.Sz.getParent()).removeView(this.Sz);
        }
        this.Sz = null;
        a aVar = this.SA;
        if (aVar != null) {
            aVar.destroy();
            this.SA = null;
        }
    }

    public final FrameLayout getImagePlayerView(Context context) {
        if (this.Sz == null) {
            this.Sz = new b(context);
        }
        return this.Sz;
    }

    public final long getPlayDuration() {
        return this.ky;
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final boolean onDecode(String str, InputStream inputStream, DecodedResult decodedResult) {
        return false;
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final void onLoadingCancelled(String str, View view) {
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final void onLoadingComplete(String str, View view, DecodedResult decodedResult) {
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final void onLoadingFailed(String str, View view, final FailReason failReason) {
        c(new com.kwad.sdk.g.a<i>() { // from class: com.kwad.components.core.h.c.5
            /* JADX INFO: Access modifiers changed from: private */
            @Override // com.kwad.sdk.g.a
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public void accept(i iVar) {
                iVar.onMediaPlayError(-1, c.a(c.this, failReason.getType()));
            }
        });
    }

    @Override // com.kwad.sdk.core.imageloader.core.listener.ImageLoadingListener
    public final void onLoadingStarted(String str, View view) {
    }

    public final void pause() {
        a aVar = this.SA;
        if (aVar != null) {
            aVar.pause();
        }
        c(new com.kwad.sdk.g.a<i>() { // from class: com.kwad.components.core.h.c.2
            private static void e(i iVar) {
                iVar.onMediaPlayPaused();
            }

            @Override // com.kwad.sdk.g.a
            public final /* synthetic */ void accept(i iVar) {
                e(iVar);
            }
        });
    }

    public final void play() {
        a aVar = this.SA;
        if (aVar != null) {
            aVar.start();
        }
    }

    public final void resume() {
        a aVar = this.SA;
        if (aVar != null) {
            aVar.resume();
            c(new com.kwad.sdk.g.a<i>() { // from class: com.kwad.components.core.h.c.3
                private static void e(i iVar) {
                    iVar.onMediaPlaying();
                }

                @Override // com.kwad.sdk.g.a
                public final /* synthetic */ void accept(i iVar) {
                    e(iVar);
                }
            });
        }
    }

    public final void setHorizontalGravity(int i) {
        this.SC = com.kwad.components.core.b.c.aJ(i);
        qY();
    }

    public final void setImageScaleType(ImageView.ScaleType scaleType) {
        b bVar = this.Sz;
        if (bVar != null) {
            bVar.setImageScaleType(scaleType);
        }
    }

    public final void setRadius(float f, float f2, float f3, float f4) {
        b bVar = this.Sz;
        if (bVar != null) {
            bVar.setRadius(f, f2, f3, f4);
        }
    }

    public final void setSpeed(float f) {
        a aVar = this.SA;
        if (aVar != null) {
            aVar.setSpeed(f);
        }
    }

    public final void setURLs(List<String> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        String str = list.get(0);
        b bVar = this.Sz;
        if (bVar != null) {
            bVar.a(str, this);
        }
    }

    public final void setVerticalGravity(int i) {
        this.SC = com.kwad.components.core.b.c.aI(i);
        qY();
    }

    public final void skipToEnd() {
        c(new com.kwad.sdk.g.a<i>() { // from class: com.kwad.components.core.h.c.4
            private static void e(i iVar) {
                iVar.onMediaPlayCompleted();
            }

            @Override // com.kwad.sdk.g.a
            public final /* synthetic */ void accept(i iVar) {
                e(iVar);
            }
        });
    }

    public final void stop() {
        a aVar = this.SA;
        if (aVar != null) {
            aVar.stop();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public <T> void c(com.kwad.sdk.g.a<i> aVar) {
        List<i> list;
        if (aVar == null || (list = this.SE) == null) {
            return;
        }
        Iterator<i> it = list.iterator();
        while (it.hasNext()) {
            aVar.accept(it.next());
        }
    }

    private static int a(FailReason.FailType failType) {
        int i = AnonymousClass6.$SwitchMap$com$kwad$sdk$core$imageloader$core$assist$FailReason$FailType[failType.ordinal()];
        if (i == 1) {
            return -2;
        }
        if (i == 2) {
            return -3;
        }
        if (i != 3) {
            return i != 4 ? -1 : -5;
        }
        return -4;
    }
}
