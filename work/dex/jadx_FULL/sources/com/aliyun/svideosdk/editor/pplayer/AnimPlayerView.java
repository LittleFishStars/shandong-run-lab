package com.aliyun.svideosdk.editor.pplayer;

import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import android.view.TextureView;
import com.aliyun.Visible;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public class AnimPlayerView implements TextureView.SurfaceTextureListener {
    private static final String TAG = "AnimPlayerView";
    private boolean _isMirror;
    private c clock;
    private long end;
    private boolean isPreview;
    private List<com.aliyun.svideosdk.editor.pplayer.a> mAnimBlocks = new ArrayList();
    private List<a> mAnimFrames = new ArrayList();
    private b mAnimationPlayer;
    private long mDuration;
    private Surface mSurface;
    private TextureView mTextureView;
    private String path;
    private long start;

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f25764a;
        public int b;

        public a(AnimPlayerView animPlayerView, long j, int i) {
            this.f25764a = j;
            this.b = i;
        }
    }

    public AnimPlayerView(TextureView textureView) {
        this.mTextureView = textureView;
        textureView.setSurfaceTextureListener(this);
        this.mTextureView.setOpaque(false);
    }

    private void initAnimation() {
        if (TextUtils.isEmpty(this.path) || this.mSurface == null) {
            return;
        }
        this.mAnimationPlayer = new b(this.mSurface, this.path);
        Iterator<com.aliyun.svideosdk.editor.pplayer.a> it = this.mAnimBlocks.iterator();
        while (it.hasNext()) {
            this.mAnimationPlayer.a(it.next());
        }
        for (a aVar : this.mAnimFrames) {
            this.mAnimationPlayer.a(aVar.f25764a, aVar.b);
        }
        this.mAnimationPlayer.b(this.mDuration);
        this.mAnimationPlayer.a(this.start, this.end);
        this.mAnimationPlayer.a(this.isPreview);
        this.mAnimationPlayer.a(this.clock);
        this.mAnimationPlayer.f();
    }

    public void addFrameList(long j, int i) {
        this.mAnimFrames.add(new a(this, j, i));
    }

    public String getAnimationPath() {
        return this.path;
    }

    public long getCurrentPosition() {
        b bVar = this.mAnimationPlayer;
        if (bVar == null) {
            return 0L;
        }
        return bVar.d();
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        Log.d(TAG, "onSurfaceTextureAvailable");
        this.mSurface = new Surface(this.mTextureView.getSurfaceTexture());
        initAnimation();
        Matrix matrix = new Matrix();
        if (this._isMirror) {
            matrix.setScale(-1.0f, 1.0f, i / 2, 0.0f);
        }
        this.mTextureView.setTransform(matrix);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        Log.d(TAG, "onSurfaceTextureDestroyed");
        release();
        this.mSurface.release();
        this.mSurface = null;
        this.mAnimationPlayer = null;
        return false;
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        Matrix matrix = new Matrix();
        if (this._isMirror) {
            matrix.setScale(-1.0f, 1.0f, i / 2, 0.0f);
        }
        this.mTextureView.setTransform(matrix);
    }

    @Override // android.view.TextureView.SurfaceTextureListener
    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void pause() {
        b bVar = this.mAnimationPlayer;
        if (bVar != null) {
            bVar.e();
        }
    }

    public void release() {
        b bVar = this.mAnimationPlayer;
        if (bVar != null) {
            bVar.g();
        }
    }

    public void setAnimationBlocks(List<com.aliyun.svideosdk.editor.pplayer.a> list) {
        this.mAnimBlocks.addAll(list);
    }

    public void setAnimationPath(String str) {
        this.path = str;
        initAnimation();
    }

    public void setDefaltDuration(long j) {
        this.mDuration = j;
    }

    public void setExternalClock(c cVar) {
        this.clock = cVar;
        b bVar = this.mAnimationPlayer;
        if (bVar != null) {
            bVar.a(cVar);
        }
    }

    public void setMirror(boolean z) {
        this._isMirror = z;
        Matrix matrix = new Matrix();
        if (z) {
            matrix.setScale(-1.0f, 1.0f, this.mTextureView.getWidth() / 2, 0.0f);
        }
        this.mTextureView.setTransform(matrix);
    }

    public void setPlayTime(long j, long j2) {
        this.start = j;
        this.end = j2;
        b bVar = this.mAnimationPlayer;
        if (bVar != null) {
            bVar.a(j, j2);
        }
    }

    public void setPreview(boolean z) {
        this.isPreview = z;
        b bVar = this.mAnimationPlayer;
        if (bVar != null) {
            bVar.a(z);
        }
    }

    public void start() {
        b bVar = this.mAnimationPlayer;
        if (bVar != null) {
            bVar.f();
        } else {
            initAnimation();
        }
    }

    public void stop() {
        b bVar = this.mAnimationPlayer;
        if (bVar != null) {
            bVar.g();
        }
    }
}
