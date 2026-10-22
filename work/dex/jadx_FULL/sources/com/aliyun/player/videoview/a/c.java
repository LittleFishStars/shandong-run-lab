package com.aliyun.player.videoview.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import com.aliyun.player.IPlayer;
import com.cicada.player.utils.Logger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class c extends com.aliyun.player.videoview.a.a {
    private static final String p = "AliDisplayView_" + c.class.getSimpleName();
    private TextureView l;
    private SurfaceTexture m;
    private Surface n;
    private boolean o;

    public class a implements TextureView.SurfaceTextureListener {
        public a() {
        }

        /* JADX WARN: Code duplicated, block: B:12:0x006d  */
        /* JADX WARN: Code duplicated, block: B:14:? A[RETURN, SYNTHETIC] */
        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
            c cVar;
            Surface surface;
            c cVar2;
            com.aliyun.player.videoview.a.a.h hVar;
            if (c.this.m != null) {
                if (c.this.o) {
                    c.this.l.setSurfaceTexture(c.this.m);
                } else {
                    c.this.n.release();
                    c.this.m = surfaceTexture;
                    cVar = c.this;
                    surface = new Surface(surfaceTexture);
                }
                Logger.i(c.p, c.this.l + " onSurfaceTextureAvailable  " + surfaceTexture);
                cVar2 = c.this;
                hVar = cVar2.b;
                if (hVar != null) {
                    hVar.onSurfaceCreated(cVar2.n);
                }
            }
            c.this.m = surfaceTexture;
            cVar = c.this;
            surface = new Surface(surfaceTexture);
            cVar.n = surface;
            Logger.i(c.p, c.this.l + " onSurfaceTextureAvailable  " + surfaceTexture);
            cVar2 = c.this;
            hVar = cVar2.b;
            if (hVar != null) {
                hVar.onSurfaceCreated(cVar2.n);
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
            Logger.i(c.p, c.this.l + " onSurfaceTextureDestroyed  ");
            com.aliyun.player.videoview.a.a.h hVar = c.this.b;
            if (hVar == null) {
                return false;
            }
            hVar.onSurfaceDestroy();
            return false;
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
            Logger.i(c.p, c.this.l + " onSurfaceTextureSizeChanged  ");
            com.aliyun.player.videoview.a.a.h hVar = c.this.b;
            if (hVar != null) {
                hVar.onSurfaceSizeChanged();
            }
        }

        @Override // android.view.TextureView.SurfaceTextureListener
        public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        }
    }

    public c(ViewGroup viewGroup) {
        super(viewGroup);
        this.l = null;
        this.m = null;
        this.n = null;
        this.o = true;
    }

    private Bitmap a(Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.preRotate(this.l.getRotation());
        matrix.preScale(this.l.getScaleX(), this.l.getScaleY());
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    @Override // com.aliyun.player.videoview.a.a
    public View a(Context context) {
        TextureView textureView = new TextureView(context);
        this.l = textureView;
        textureView.setSurfaceTextureListener(new a());
        return this.l;
    }

    @Override // com.aliyun.player.videoview.a.a
    public boolean a(IPlayer.MirrorMode mirrorMode) {
        if (mirrorMode == IPlayer.MirrorMode.MIRROR_MODE_HORIZONTAL) {
            this.l.setScaleX(-1.0f);
            this.l.setScaleY(1.0f);
            return true;
        }
        if (mirrorMode == IPlayer.MirrorMode.MIRROR_MODE_VERTICAL) {
            this.l.setScaleY(-1.0f);
        } else {
            this.l.setScaleY(1.0f);
        }
        this.l.setScaleX(1.0f);
        return true;
    }

    @Override // com.aliyun.player.videoview.a.a
    public boolean a(IPlayer.RotateMode rotateMode) {
        TextureView textureView;
        float f;
        if (rotateMode == IPlayer.RotateMode.ROTATE_90) {
            textureView = this.l;
            f = 90.0f;
        } else if (rotateMode == IPlayer.RotateMode.ROTATE_180) {
            textureView = this.l;
            f = 180.0f;
        } else if (rotateMode == IPlayer.RotateMode.ROTATE_270) {
            textureView = this.l;
            f = 270.0f;
        } else {
            textureView = this.l;
            f = 0.0f;
        }
        textureView.setRotation(f);
        return true;
    }

    @Override // com.aliyun.player.videoview.a.a
    public void b(boolean z) {
        this.o = z;
    }

    @Override // com.aliyun.player.videoview.a.a
    public Bitmap e() {
        Bitmap bitmap = this.l.getBitmap();
        Bitmap bitmapA = a(bitmap);
        bitmap.recycle();
        return bitmapA;
    }
}
