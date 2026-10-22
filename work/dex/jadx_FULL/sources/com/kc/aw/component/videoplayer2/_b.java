package com.kc.aw.component.videoplayer2;

import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;
import com.kc.aw._j8;
import com.kc.aw._kk;
import com.kc.aw.component.video.PtgVideoView;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public final class _b implements Runnable {
    public final String _a;
    public final long _b;
    public final _c._a _c;

    @Keep
    public final class _a implements Runnable {
        public final Bitmap _a;
        public final _b _b;

        public _a(_b _bVar, Bitmap bitmap) {
            this._b = _bVar;
            this._a = bitmap;
        }

        @Override // java.lang.Runnable
        public final void run() {
            ImageView imageView;
            _c._a _aVar = this._b._c;
            Bitmap bitmap = this._a;
            PtgCoreVideo ptgCoreVideo = ((com.kc.aw.component.videoplayer2._a) _aVar)._a;
            ptgCoreVideo._o = bitmap;
            _j8 _j8Var = ptgCoreVideo._q;
            if (_j8Var != null) {
                PtgVideoView ptgVideoView = ((_kk) _j8Var)._a;
                int i = PtgVideoView._w;
                ptgVideoView.getClass();
                if (bitmap == null || bitmap.isRecycled() || (imageView = ptgVideoView._g) == null) {
                    return;
                }
                imageView.setImageBitmap(bitmap);
                ptgVideoView._g.setVisibility(0);
            }
        }
    }

    /* JADX INFO: renamed from: com.kc.aw.component.videoplayer2._b$_b, reason: collision with other inner class name */
    @Keep
    public final class RunnableC0952_b implements Runnable {
        public final Exception _a;
        public final _b _b;

        public RunnableC0952_b(_b _bVar, Exception exc) {
            this._b = _bVar;
            this._a = exc;
        }

        @Override // java.lang.Runnable
        public final void run() {
            _c._a _aVar = this._b._c;
            Exception exc = this._a;
            PtgCoreVideo ptgCoreVideo = ((com.kc.aw.component.videoplayer2._a) _aVar)._a;
            exc.getMessage();
            ptgCoreVideo.getClass();
        }
    }

    public _b(String str, long j, com.kc.aw.component.videoplayer2._a _aVar) {
        this._a = str;
        this._b = j;
        this._c = _aVar;
    }

    @Override // java.lang.Runnable
    public final void run() throws IOException {
        MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
        try {
            try {
                mediaMetadataRetriever.setDataSource(this._a);
                new Handler(Looper.getMainLooper()).post(new _a(this, mediaMetadataRetriever.getFrameAtTime(this._b, 2)));
            } catch (Exception e) {
                new Handler(Looper.getMainLooper()).post(new RunnableC0952_b(this, e));
            }
        } finally {
            mediaMetadataRetriever.release();
        }
    }
}
