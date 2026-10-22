package com.aliyun.svideosdk.editor;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Log;
import android.view.Surface;
import com.aliyun.Visible;
import com.aliyun.svideosdk.common.AliyunCaption;
import com.aliyun.svideosdk.nativerender.BitmapGenerator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@Visible
public class NativeEditor extends com.aliyun.svideosdk.nativeload.a implements b {
    private static final int ALIVC_SVIDEO_ERROR_EDITOR_NATIVE_NOT_INITED = -20011024;
    private static final String TAG = "AliYunLog";
    private long nativeHandle;
    private boolean isBackground = false;
    private int mFboWidth = 0;
    private int mFboHeight = 0;

    public NativeEditor() {
        this.nativeHandle = 0L;
        this.nativeHandle = create();
    }

    private native int addCaption(long j, AliyunCaption aliyunCaption);

    private native int addFrameAniamtion(long j, int i, Object obj);

    private native int addGifImageTextView(long j, String str, float f, float f2, float f3, float f4, float f5, boolean z, long j2, long j3, boolean z2, BitmapGenerator bitmapGenerator, float f6, float f7, float f8, float f9, float f10, int i, int i2, long j4, long j5, boolean z3, long j6);

    private native int addGifView(long j, String str, float f, float f2, float f3, float f4, float f5, boolean z, long j2, long j3, boolean z2);

    private native int addImageBufferView(long j, Bitmap bitmap, float f, float f2, float f3, float f4, float f5, long j2, long j3, boolean z, long j4, int i);

    private native int addImageElement(long j, String str, long j2, Object obj);

    private native int addImageView(long j, String str, float f, float f2, float f3, float f4, float f5, long j2, long j3, boolean z, long j4, int i);

    private native int addPipElement(long j, long j2);

    private native int addRollCaptionItemView(long j, BitmapGenerator bitmapGenerator, float f, float f2, float f3, float f4, float f5, int i, int i2, long j2, long j3);

    private native int addScaledImageView(long j, BitmapGenerator bitmapGenerator, float f, float f2, float f3, float f4, float f5, int i, int i2, long j2, long j3, boolean z, long j4);

    private native int addVideoElement(long j, String str, long j2, long j3, Object obj);

    private native int applyAnimationFilter(long j, String str, long j2, long j3, String str2);

    private native int applyBlurBackground(long j, int i, long j2, long j3, float f);

    private native int applyFilter(long j, String str, long j2, long j3, int i);

    private native int applyMv(long j, String str, long j2, long j3);

    private native int applyRollCaptionEffects(long j);

    private native int audioEffect(long j, int i, int i2, float f);

    private native int checkTemplatePermission(long j);

    private native int clearFrameAnimation(long j, int i);

    private native int clearRollCaptions(long j);

    private native long create();

    private native int deleteAnimationFilter(long j, int i);

    private native int deleteBlurBackground(long j, int i, int i2);

    private native int deleteTimeEffect(long j, int i);

    private native int deleteView(long j, int i, int i2);

    private native int denoise(long j, int i, float f);

    private native void dispose(long j);

    private native int draw(long j, long j2);

    private native int dub(long j, String str, int i, long j2, long j3, long j4, long j5);

    private native List<AliyunCaption> findCaptions(long j, long j2);

    private native long getClipStartTime(long j, int i);

    private native long getDuration(long j);

    private native Bitmap getFrameAtTime(long j, long j2);

    private native int getMvAudioId(long j);

    private native long getPlayTime(long j);

    private native long getStreamDuration(long j);

    private native long getStreamPlayTime(long j);

    private native int getTimeEffect(long j);

    private native int init(long j, int i, int i2, int i3, long j2, Object obj);

    private native int innerPause(long j);

    private native int innerStart(long j);

    private native int invert(long j);

    private native boolean isNativePrepared(long j);

    private native int mix(long j, String str, int i, long j2, long j3, long j4, long j5);

    private native int mixAlpha(long j, int i, int i2);

    private native int mute(long j, boolean z);

    private native void onBatchEditEnd(long j);

    private native void onBatchEditStart(long j);

    private native int pause(long j);

    private native int prepare(long j);

    private native void release(long j);

    private native int removeAudioEffect(long j, int i, int i2);

    private native int removeCaption(long j, AliyunCaption aliyunCaption);

    private native int removeDub(long j, int i);

    private native int removeFrameAnimation(long j, int i, Object obj);

    private native int removeMix(long j, int i);

    private native int removePip(long j, int i);

    private native int removeRollCaptionItemView(long j, int i);

    private native int removeRunningDisplayMode(long j, int i);

    private native int resetEffect(long j, int i);

    private native int seek(long j, long j2);

    private native int setAudioFadeInFadeOut(long j, int i, int i2, long j2, boolean z);

    private native int setBackgroundColor(long j, int i);

    private native int setBrightness(long j, int i, float f);

    private native int setContrast(long j, int i, float f);

    private native int setDisplay(long j, Surface surface);

    private native int setDisplayMode(long j, int i);

    private native int setDisplaySize(long j, int i, int i2);

    private native int setEncodeParam(long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10);

    private native int setHorizontalFlip(long j, int i, boolean z);

    private native int setLutFilter(long j, int i, String str, float f, long j2, long j3);

    private native int setMode(long j, int i);

    private native int setOutputPath(long j, String str);

    private native int setRate(long j, float f, long j2, long j3, boolean z);

    private native int setRepeat(long j, int i, long j2, long j3, boolean z);

    private native int setRunningDisplayMode(long j, int i, int i2, long j2, long j3);

    private native int setSaturation(long j, int i, float f);

    private native int setSharpness(long j, int i, float f);

    private native int setTailImage(long j, String str, float f, float f2, float f3, float f4, long j2);

    private native int setVignette(long j, int i, float f);

    private native int setVolume(long j, int i);

    private native int start(long j);

    private native int stop(long j);

    private native int unPrepare(long j);

    private native int updateAnimationFilter(long j, int i, long j2, long j3, String str);

    private native int updateCaption(long j, AliyunCaption aliyunCaption);

    private native int updatePipElement(long j, long j2);

    private native int updateStreamVolume(long j, int i, float f);

    private native int updateTransition(long j, int i, String str);

    private native int updateVideoElement(long j, int i, long j2, long j3);

    @Override // com.aliyun.svideosdk.editor.b
    public int addAnimationEff(String str, long j, long j2, String str2) {
        long j3 = this.nativeHandle;
        if (j3 == 0) {
            return -20011024;
        }
        return applyAnimationFilter(j3, str, j, j2, str2);
    }

    @Override // com.aliyun.svideosdk.editor.b
    public int addCaption(AliyunCaption aliyunCaption) {
        return addCaption(this.nativeHandle, aliyunCaption);
    }

    public int addFrameAnimation(int i, Object obj) {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return addFrameAniamtion(j, i, obj);
    }

    @Override // com.aliyun.svideosdk.editor.b
    public int addGifTextView(String str, float f, float f2, float f3, float f4, float f5, boolean z, long j, long j2, boolean z2, BitmapGenerator bitmapGenerator, float f6, float f7, float f8, float f9, float f10, int i, int i2, long j3, long j4, boolean z3, long j5) {
        long j6 = this.nativeHandle;
        if (j6 == 0) {
            return -20011024;
        }
        return addGifImageTextView(j6, str, f, f2, f3, f4, f5, z, j, j2, z2, bitmapGenerator, f6, f7, f8, f9, f10, i, i2, j3, j4, z3, j5);
    }

    @Override // com.aliyun.svideosdk.editor.b
    public int addGifView(String str, float f, float f2, float f3, float f4, float f5, boolean z, long j, long j2, boolean z2) {
        long j3 = this.nativeHandle;
        if (j3 == 0) {
            return -20011024;
        }
        int iAddGifView = addGifView(j3, str, f, f2, f3, f4, f5, z, j, j2, z2);
        Log.d("NativeEditorJava", "Add gif view vid[" + iAddGifView + "], return ret[" + iAddGifView + "]");
        return iAddGifView;
    }

    public int addImageElement(String str, long j, Object obj, int i, int i2, float f, float f2) {
        long j2 = this.nativeHandle;
        if (j2 == 0) {
            return -20011024;
        }
        return addImageElement(j2, str, j, obj);
    }

    @Override // com.aliyun.svideosdk.editor.b
    public int addImgView(Bitmap bitmap, float f, float f2, float f3, float f4, float f5, long j, long j2, boolean z, long j3, int i) {
        if (this.nativeHandle == 0) {
            return -20011024;
        }
        if (bitmap == null) {
            Log.e("AliYunLog", "Bitmap is null");
            return -2;
        }
        int i2 = (int) (this.mFboWidth * f3);
        int i3 = (int) (this.mFboHeight * f4);
        try {
            if (i2 >= bitmap.getWidth() || i3 >= bitmap.getHeight()) {
                return addImageBufferView(this.nativeHandle, bitmap, f, f2, f3, f4, f5, j, j2, z, j3, i);
            }
            Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, i3, true);
            bitmap.recycle();
            try {
                return addImageBufferView(this.nativeHandle, bitmapCreateScaledBitmap, f, f2, f3, f4, f5, j, j2, z, j3, i);
            } catch (IllegalArgumentException e) {
                e = e;
            }
        } catch (IllegalArgumentException e2) {
            e = e2;
        }
        Log.e("AliYunLog", "Create scaled image failed", e);
        return -2;
    }

    @Override // com.aliyun.svideosdk.editor.b
    public int addImgView(BitmapGenerator bitmapGenerator, float f, float f2, float f3, float f4, float f5, int i, int i2, long j, long j2, boolean z, long j3) {
        long j4 = this.nativeHandle;
        if (j4 == 0) {
            return -20011024;
        }
        return addScaledImageView(j4, bitmapGenerator, f, f2, f3, f4, f5, i, i2, j, j2, z, j3);
    }

    @Override // com.aliyun.svideosdk.editor.b
    public int addImgView(String str, float f, float f2, float f3, float f4, float f5, long j, long j2, boolean z, long j3, int i) {
        if (this.nativeHandle == 0) {
            return -20011024;
        }
        if (TextUtils.isEmpty(str)) {
            Log.e("AliYunLog", "Image path is null");
            return -2;
        }
        int i2 = (int) (this.mFboWidth * f3);
        int i3 = (int) (this.mFboHeight * f4);
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        try {
            BitmapFactory.decodeFile(str, options);
            Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str);
            if (bitmapDecodeFile != null && !bitmapDecodeFile.isRecycled()) {
                try {
                    if (i2 >= options.outWidth || i3 >= options.outHeight) {
                        return addImageBufferView(this.nativeHandle, bitmapDecodeFile, f, f2, f3, f4, f5, j, j2, z, j3, i);
                    }
                    Bitmap bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmapDecodeFile, i2, i3, true);
                    bitmapDecodeFile.recycle();
                    return addImageBufferView(this.nativeHandle, bitmapCreateScaledBitmap, f, f2, f3, f4, f5, j, j2, z, j3, i);
                } catch (IllegalArgumentException e) {
                    e = e;
                }
                Log.e("AliYunLog", "Decode image failed,path[" + str + "]", e);
                return -2;
            }
            return -2;
        } catch (IllegalArgumentException e2) {
            e = e2;
        }
    }

    public int addPicInPic(long j) {
        long j2 = this.nativeHandle;
        if (j2 == 0) {
            return -20011024;
        }
        return addPipElement(j2, j);
    }

    public int addRollCaptionItemView(BitmapGenerator bitmapGenerator, float f, float f2, float f3, float f4, float f5, int i, int i2, long j, long j2) {
        long j3 = this.nativeHandle;
        if (j3 == 0) {
            return -20011024;
        }
        return addRollCaptionItemView(j3, bitmapGenerator, f, f2, f3, f4, f5, i, i2, j, j2);
    }

    public int addVideoElement(String str, long j, long j2, Object obj, int i, int i2, float f, float f2) {
        long j3 = this.nativeHandle;
        if (j3 == 0) {
            return -20011024;
        }
        return addVideoElement(j3, str, j, j2, obj);
    }

    public int applyBlurBackground(int i, long j, long j2, float f) {
        long j3 = this.nativeHandle;
        if (j3 == 0) {
            return -20011024;
        }
        return applyBlurBackground(j3, i, j, j2, f);
    }

    public int applyMv(String str, long j, long j2) {
        long j3 = this.nativeHandle;
        if (j3 == 0) {
            return -20011024;
        }
        return applyMv(j3, str, j, j2);
    }

    public int applyRollCaptionEffects() {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return applyRollCaptionEffects(j);
    }

    public int audioEffect(int i, int i2, float f) {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return audioEffect(j, i, i2, f);
    }

    public int checkTemplatePermission() {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return checkTemplatePermission(j);
    }

    public int clearFrameAnimation(int i) {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return clearFrameAnimation(j, i);
    }

    public void clearRollCaptions() {
        long j = this.nativeHandle;
        if (j == 0) {
            return;
        }
        clearRollCaptions(j);
    }

    public int deleteAnimationFilter(int i) {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return deleteAnimationFilter(j, i);
    }

    public int deleteBlurBackground(int i, int i2) {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return deleteBlurBackground(j, i, i2);
    }

    public int deleteTimeEffect(int i) {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return deleteTimeEffect(j, i);
    }

    @Override // com.aliyun.svideosdk.editor.b
    public int deleteView(int i, int i2) {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        int iDeleteView = deleteView(j, i, i2);
        Log.d("NativeEditorJava", "delete view vid[" + i + "], return ret[" + iDeleteView + "]");
        return iDeleteView;
    }

    public int denoise(int i, float f) {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return denoise(j, i, f);
    }

    public void dispose() {
        long j = this.nativeHandle;
        if (j == 0) {
            return;
        }
        dispose(j);
        this.nativeHandle = 0L;
    }

    public int draw(long j) {
        long j2 = this.nativeHandle;
        if (j2 == 0) {
            return -20011024;
        }
        pause(j2);
        return draw(this.nativeHandle, j);
    }

    public int dub(String str, int i, long j, long j2, long j3, long j4) {
        long j5 = this.nativeHandle;
        if (j5 == 0) {
            return -20011024;
        }
        return dub(j5, str, i, j, j2, j3, j4);
    }

    @Override // com.aliyun.svideosdk.editor.b
    public List<AliyunCaption> findCaptions(long j) {
        return findCaptions(this.nativeHandle, j);
    }

    public long getClipStartTime(int i) {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024L;
        }
        return getClipStartTime(j, i);
    }

    public long getDuration() {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024L;
        }
        return getDuration(j);
    }

    public Bitmap getFrameAtTime(long j) {
        long j2 = this.nativeHandle;
        if (j2 == 0) {
            return null;
        }
        return getFrameAtTime(j2, j);
    }

    public int getMvAudioId() {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return getMvAudioId(j);
    }

    public long getPlayTime() {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024L;
        }
        return getPlayTime(j);
    }

    public long getStreamDuration() {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024L;
        }
        return getStreamDuration(j);
    }

    public long getStreamPlayTime() {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024L;
        }
        return getStreamPlayTime(j);
    }

    public int getTimeEffect() {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return getTimeEffect(j);
    }

    public int init(int i, int i2, int i3, long j, Object obj) {
        this.mFboWidth = i;
        this.mFboHeight = i2;
        return init(this.nativeHandle, i, i2, i3, j, obj);
    }

    public int innerPause() {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return innerPause(j);
    }

    public int innerStart() {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return innerStart(j);
    }

    public int invert() {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return invert(j);
    }

    public boolean isNativePrepared() {
        long j = this.nativeHandle;
        if (j == 0) {
            return false;
        }
        return isNativePrepared(j);
    }

    public int mix(String str, int i, long j, long j2, long j3, long j4) {
        long j5 = this.nativeHandle;
        if (j5 == 0) {
            return -20011024;
        }
        return mix(j5, str, i, j, j2, j3, j4);
    }

    public int mixAlpha(int i, int i2) {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return mixAlpha(j, i, i2);
    }

    public void onStartBatchEdit() {
        onBatchEditStart(this.nativeHandle);
    }

    public void onSubmitBatchEdit() {
        onBatchEditEnd(this.nativeHandle);
    }

    public int pause() {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return pause(j);
    }

    public int prepare() {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return prepare(j);
    }

    public void release() {
        long j = this.nativeHandle;
        if (j == 0) {
            return;
        }
        release(j);
    }

    public int removeAudioEffect(int i, int i2) {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return removeAudioEffect(j, i, i2);
    }

    @Override // com.aliyun.svideosdk.editor.b
    public int removeCaption(AliyunCaption aliyunCaption) {
        return removeCaption(this.nativeHandle, aliyunCaption);
    }

    public int removeDub(int i) {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return removeDub(j, i);
    }

    public int removeFrameAnimation(int i, Object obj) {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return removeFrameAnimation(j, i, obj);
    }

    public int removeMix(int i) {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return removeMix(j, i);
    }

    public int removePipInPic(int i) {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return removePip(j, i);
    }

    public int removeRollCaptionItemView(int i) {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return removeRollCaptionItemView(j, i);
    }

    public int removeRunningDisplayMode(int i) {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return removeRunningDisplayMode(j, i);
    }

    public void replay() {
        long j = this.nativeHandle;
        if (j == 0) {
            return;
        }
        stop(j);
        start(this.nativeHandle);
    }

    public int resetEffect(int i) {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return resetEffect(j, i);
    }

    public int resume() {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return start(j);
    }

    public int seek(long j) {
        long j2 = this.nativeHandle;
        if (j2 == 0) {
            return -20011024;
        }
        pause(j2);
        return seek(this.nativeHandle, j);
    }

    public int setAudioFadeInFadeOut(int i, int i2, long j, boolean z) {
        long j2 = this.nativeHandle;
        if (j2 == 0) {
            return -20011024;
        }
        return setAudioFadeInFadeOut(j2, i, i2, j, z);
    }

    public int setBrightness(int i, float f) {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return setBrightness(j, i, f);
    }

    public int setContrast(int i, float f) {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return setContrast(j, i, f);
    }

    public int setDisplay(Surface surface) {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return setDisplay(j, surface);
    }

    public int setDisplayMode(int i) {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return setDisplayMode(j, i);
    }

    public int setDisplaySize(int i, int i2) {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        this.mFboWidth = i;
        this.mFboHeight = i2;
        return setDisplaySize(j, i, i2);
    }

    public int setEncodeParam(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return setEncodeParam(j, i, i2, i3, i4, i5, i6, i7, i8, i9, i10);
    }

    public int setFillBackgroundColor(int i) {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return setBackgroundColor(j, i);
    }

    public int setHorizontalFlip(int i, boolean z) {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return setHorizontalFlip(j, i, z);
    }

    public int setLutFilter(int i, String str, float f, long j, long j2) {
        long j3 = this.nativeHandle;
        if (j3 == 0) {
            return -20011024;
        }
        return setLutFilter(j3, i, str, f, j, j2);
    }

    public int setMode(c cVar) {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return setMode(j, cVar.a());
    }

    public int setMute(boolean z) {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return mute(j, z);
    }

    public int setOutputPath(String str) {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return setOutputPath(j, str);
    }

    public int setRate(float f, long j, long j2, boolean z) {
        long j3 = this.nativeHandle;
        if (j3 == 0) {
            return -20011024;
        }
        return setRate(j3, f, j, j2, z);
    }

    public int setRepeat(int i, long j, long j2, boolean z) {
        long j3 = this.nativeHandle;
        if (j3 == 0) {
            return -20011024;
        }
        return setRepeat(j3, i, j, j2, z);
    }

    public int setRunningDisplayMode(int i, int i2, long j, long j2) {
        long j3 = this.nativeHandle;
        if (j3 == 0) {
            return -20011024;
        }
        return setRunningDisplayMode(j3, i, i2, j, j2);
    }

    public int setSaturation(int i, float f) {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return setSaturation(j, i, f);
    }

    public int setSharpness(int i, float f) {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return setSharpness(j, i, f);
    }

    public int setTailBmp(String str, float f, float f2, float f3, float f4, long j) {
        long j2 = this.nativeHandle;
        if (j2 == 0) {
            return -20011024;
        }
        return setTailImage(j2, str, f3, f4, f, f2, j);
    }

    public int setVignette(int i, float f) {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return setVignette(j, i, f);
    }

    public int setVolume(int i) {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return setVolume(j, i);
    }

    public int start() {
        long j = this.nativeHandle;
        if (j == 0 || this.isBackground) {
            return -20011024;
        }
        return start(j);
    }

    public int stop() {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return stop(j);
    }

    public int switchEff(String str, long j, long j2, int i) {
        long j3 = this.nativeHandle;
        if (j3 == 0) {
            return -20011024;
        }
        return applyFilter(j3, str, j, j2, i);
    }

    public int switchMV(String str) {
        if (this.nativeHandle == 0) {
            return -20011024;
        }
        return applyMv(str, 0L, 2147483647L);
    }

    public int unPrepare() {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return unPrepare(j);
    }

    @Override // com.aliyun.svideosdk.editor.b
    public int updateAnimationEff(int i, long j, long j2, String str) {
        long j3 = this.nativeHandle;
        if (j3 == 0) {
            return -20011024;
        }
        return updateAnimationFilter(j3, i, j, j2, str);
    }

    public int updateAnimationFilter(int i, long j, long j2) {
        long j3 = this.nativeHandle;
        if (j3 == 0) {
            return -20011024;
        }
        return updateAnimationFilter(j3, i, j, j2, null);
    }

    @Override // com.aliyun.svideosdk.editor.b
    public int updateCaption(AliyunCaption aliyunCaption) {
        return updateCaption(this.nativeHandle, aliyunCaption);
    }

    public int updatePicInPic(long j) {
        long j2 = this.nativeHandle;
        if (j2 == 0) {
            return -20011024;
        }
        return updatePipElement(j2, j);
    }

    public int updateStreamVolume(int i, float f) {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return updateStreamVolume(j, i, f);
    }

    @Override // com.aliyun.svideosdk.editor.b
    public int updateTransition(int i, String str) {
        long j = this.nativeHandle;
        if (j == 0) {
            return -20011024;
        }
        return updateTransition(j, i, str);
    }

    public int updateVideoElement(int i, long j, long j2, int i2, int i3, float f, float f2) {
        long j3 = this.nativeHandle;
        if (j3 == 0) {
            return -20011024;
        }
        return updateVideoElement(j3, i, j, j2);
    }
}
