package com.byazt.fk;

import android.graphics.SurfaceTexture;
import android.util.SparseArray;
import android.view.SurfaceHolder;
import com.byazt.ut.ATSKeep;
import java.util.function.Function;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1696, 42})
public class i implements sp, Function {
    public volatile Function c;
    public volatile sp tt;

    public i(sp spVar) {
        this.tt = spVar;
    }

    public i(Function function) {
        this.c = function;
    }

    @Override // com.byazt.fk.sp
    public void addIVideoPlayerCallback(sp.c cVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 32);
        if (cVar != null) {
            cVar = new x(cVar);
        }
        sparseArray.put(1, cVar);
        this.c.apply(sparseArray);
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                Object ypVar = sparseArray.get(1);
                if (ypVar != null) {
                    ypVar = new yp((Function) ypVar);
                }
                this.tt.setDataSource((u) ypVar);
                return null;
            case 2:
                this.tt.setQuietPlay(((Boolean) sparseArray.get(1)).booleanValue());
                return null;
            case 3:
                this.tt.setSeekMode(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 4:
                this.tt.start(((Boolean) sparseArray.get(1)).booleanValue(), ((Long) sparseArray.get(2)).longValue(), ((Boolean) sparseArray.get(3)).booleanValue());
                return null;
            case 5:
                this.tt.restart();
                return null;
            case 6:
                this.tt.play();
                return null;
            case 7:
                this.tt.pause();
                return null;
            case 8:
                this.tt.stop();
                return null;
            case 9:
                this.tt.reset();
                return null;
            case 10:
                this.tt.release();
                return null;
            case 11:
                this.tt.seekTo(((Long) sparseArray.get(1)).longValue());
                return null;
            case 12:
                return Boolean.valueOf(this.tt.isFirstFrameSuccess());
            case 13:
                this.tt.setSurfaceValid(((Boolean) sparseArray.get(1)).booleanValue());
                return null;
            case 14:
                this.tt.setDisplay((SurfaceHolder) sparseArray.get(1));
                return null;
            case 15:
                return this.tt.getSurfaceHolder();
            case 16:
                this.tt.setSurface((SurfaceTexture) sparseArray.get(1));
                return null;
            case 17:
                return this.tt.getSurfaceTexture();
            case 18:
                return Boolean.valueOf(this.tt.isCompleted());
            case 19:
                return Boolean.valueOf(this.tt.isPrepared());
            case 20:
                return Boolean.valueOf(this.tt.isStarted());
            case 21:
                return Integer.valueOf(this.tt.getVideoWidth());
            case 22:
                return Integer.valueOf(this.tt.getVideoHeight());
            case 23:
                return Boolean.valueOf(this.tt.isPlaying());
            case 24:
                return Boolean.valueOf(this.tt.isPaused());
            case 25:
                return Boolean.valueOf(this.tt.isReleased());
            case 26:
                return Long.valueOf(this.tt.getTotalBufferTime());
            case 27:
                return Integer.valueOf(this.tt.getBufferCount());
            case 28:
                return Long.valueOf(this.tt.getVideoDuration());
            case 29:
                return Long.valueOf(this.tt.getCurrentPosition());
            case 30:
                this.tt.setLoop(((Boolean) sparseArray.get(1)).booleanValue());
                return null;
            case 31:
                return Boolean.valueOf(this.tt.isLooping());
            case 32:
                Object xVar = sparseArray.get(1);
                if (xVar != null) {
                    xVar = new x((Function) xVar);
                }
                this.tt.addIVideoPlayerCallback((sp.c) xVar);
                return null;
            case 33:
                Object xVar2 = sparseArray.get(1);
                if (xVar2 != null) {
                    xVar2 = new x((Function) xVar2);
                }
                this.tt.removeIVideoPlayerCallback((sp.c) xVar2);
                return null;
            case 34:
                this.tt.setUpdateProgressInterval(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 35:
                return Integer.valueOf(this.tt.getUpdateProgressInterval());
            case 36:
                this.tt.setPlaySpeedRatio(((Float) sparseArray.get(1)).floatValue());
                return null;
            case 37:
                return this.tt.getCodec();
            default:
                return null;
        }
    }

    @Override // com.byazt.fk.sp
    public int getBufferCount() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 27);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.fk.sp
    public String getCodec() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 37);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.sp
    public long getCurrentPosition() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 29);
        return ((Long) this.c.apply(sparseArray)).longValue();
    }

    @Override // com.byazt.fk.sp
    public SurfaceHolder getSurfaceHolder() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        return (SurfaceHolder) this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.sp
    public SurfaceTexture getSurfaceTexture() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        return (SurfaceTexture) this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.sp
    public long getTotalBufferTime() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 26);
        return ((Long) this.c.apply(sparseArray)).longValue();
    }

    @Override // com.byazt.fk.sp
    public int getUpdateProgressInterval() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 35);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.fk.sp
    public long getVideoDuration() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 28);
        return ((Long) this.c.apply(sparseArray)).longValue();
    }

    @Override // com.byazt.fk.sp
    public int getVideoHeight() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 22);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.fk.sp
    public int getVideoWidth() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 21);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.fk.sp
    public boolean isCompleted() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 18);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.fk.sp
    public boolean isFirstFrameSuccess() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.fk.sp
    public boolean isLooping() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 31);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.fk.sp
    public boolean isPaused() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 24);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.fk.sp
    public boolean isPlaying() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 23);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.fk.sp
    public boolean isPrepared() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 19);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.fk.sp
    public boolean isReleased() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 25);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.fk.sp
    public boolean isStarted() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 20);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.fk.sp
    public void pause() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.sp
    public void play() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.sp
    public void release() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.sp
    public void removeIVideoPlayerCallback(sp.c cVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 33);
        if (cVar != null) {
            cVar = new x(cVar);
        }
        sparseArray.put(1, cVar);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.sp
    public void reset() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.sp
    public void restart() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.sp
    public void seekTo(long j) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        sparseArray.put(1, Long.valueOf(j));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.sp
    public void setDataSource(u uVar) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        if (uVar != null) {
            uVar = new yp(uVar);
        }
        sparseArray.put(1, uVar);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.sp
    public void setDisplay(SurfaceHolder surfaceHolder) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        sparseArray.put(1, surfaceHolder);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.sp
    public void setLoop(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 30);
        sparseArray.put(1, Boolean.valueOf(z));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.sp
    public void setPlaySpeedRatio(float f) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 36);
        sparseArray.put(1, Float.valueOf(f));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.sp
    public void setQuietPlay(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, Boolean.valueOf(z));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.sp
    public void setSeekMode(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        sparseArray.put(1, Integer.valueOf(i));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.sp
    public void setSurface(SurfaceTexture surfaceTexture) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        sparseArray.put(1, surfaceTexture);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.sp
    public void setSurfaceValid(boolean z) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        sparseArray.put(1, Boolean.valueOf(z));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.sp
    public void setUpdateProgressInterval(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 34);
        sparseArray.put(1, Integer.valueOf(i));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.sp
    public void start(boolean z, long j, boolean z2) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, Boolean.valueOf(z));
        sparseArray.put(2, Long.valueOf(j));
        sparseArray.put(3, Boolean.valueOf(z2));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.sp
    public void stop() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        this.c.apply(sparseArray);
    }
}
