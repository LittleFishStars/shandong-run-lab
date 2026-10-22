package com.aliyun.player.videoview.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import com.aliyun.player.IPlayer;
import com.cicada.player.utils.Logger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class b extends com.aliyun.player.videoview.a.a {
    private static final String m = "AliDisplayView_" + b.class.getSimpleName();
    private SurfaceView l;

    public class a implements SurfaceHolder.Callback2 {
        public a() {
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
            Logger.i(b.m, "surfaceChanged ");
            com.aliyun.player.videoview.a.a.h hVar = b.this.b;
            if (hVar != null) {
                hVar.onSurfaceSizeChanged();
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceCreated(SurfaceHolder surfaceHolder) {
            Surface surface = surfaceHolder.getSurface();
            Logger.i(b.m, "onSurfaceCreated  " + surface);
            com.aliyun.player.videoview.a.a.h hVar = b.this.b;
            if (hVar != null) {
                hVar.onSurfaceCreated(surface);
            }
        }

        @Override // android.view.SurfaceHolder.Callback
        public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            Logger.i(b.m, "surfaceDestroyed ");
            com.aliyun.player.videoview.a.a.h hVar = b.this.b;
            if (hVar != null) {
                hVar.onSurfaceDestroy();
            }
        }

        @Override // android.view.SurfaceHolder.Callback2
        public void surfaceRedrawNeeded(SurfaceHolder surfaceHolder) {
            Logger.i(b.m, "surfaceRedrawNeeded ");
        }
    }

    public b(ViewGroup viewGroup) {
        super(viewGroup);
        this.l = null;
    }

    @Override // com.aliyun.player.videoview.a.a
    public View a(Context context) {
        SurfaceView surfaceView = new SurfaceView(context);
        this.l = surfaceView;
        surfaceView.getHolder().addCallback(new a());
        return this.l;
    }

    @Override // com.aliyun.player.videoview.a.a
    public boolean a(IPlayer.MirrorMode mirrorMode) {
        return false;
    }

    @Override // com.aliyun.player.videoview.a.a
    public boolean a(IPlayer.RotateMode rotateMode) {
        return false;
    }

    @Override // com.aliyun.player.videoview.a.a
    public void b(boolean z) {
    }

    @Override // com.aliyun.player.videoview.a.a
    public Bitmap e() {
        return null;
    }
}
