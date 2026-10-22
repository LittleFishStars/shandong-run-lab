package com.aliyun.svideosdk.common.struct.effect;

import android.graphics.Bitmap;
import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.project.Source;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
@Deprecated
public class EffectPicture {
    private Bitmap bitmap;
    public long end;
    public float height;

    @Deprecated
    public boolean isTrack;
    private String mPicturePath;
    public boolean mirror;
    private int oldId;
    public float rotation;
    public long start;
    private int viewId;
    public float width;
    public float x;
    public float y;

    public EffectPicture(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public EffectPicture(String str) {
        this.mPicturePath = str;
    }

    public EffectPicture(String str, float f, float f2, long j, long j2, float f3, float f4, float f5, boolean z, boolean z2) {
        this.mPicturePath = str;
        this.x = f;
        this.y = f2;
        this.start = j;
        this.end = j2;
        this.width = f3;
        this.height = f4;
        this.rotation = f5;
        this.mirror = z;
        this.isTrack = z2;
    }

    public boolean equals(Object obj) {
        return (obj instanceof EffectPicture) && this.viewId == ((EffectPicture) obj).getViewId();
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public int getOldId() {
        return this.oldId;
    }

    public String getPicturePath() {
        return this.mPicturePath;
    }

    public int getViewId() {
        return this.viewId;
    }

    public void setOldId(int i) {
        this.oldId = i;
    }

    public void setViewId(int i) {
        this.viewId = i;
    }

    public String toString() {
        return "EffectPicture{viewId=" + this.viewId + ", bitmap=" + this.bitmap + ", mPicturePath='" + this.mPicturePath + "', x=" + this.x + ", y=" + this.y + ", start=" + this.start + ", end=" + this.end + ", width=" + this.width + ", height=" + this.height + ", rotation=" + this.rotation + ", mirror=" + this.mirror + ", isTrack=" + this.isTrack + '}';
    }

    public TrackEffect<EffectImage> toTrackEffectImage() {
        EffectImage effectImage = new EffectImage(getBitmap());
        effectImage.setSource(new Source(getPicturePath()));
        effectImage.setViewId(getViewId());
        effectImage.setXRadio(this.x);
        effectImage.setYRatio(this.y);
        effectImage.setWidthRatio(this.width);
        effectImage.setHeightRatio(this.height);
        effectImage.setRotation(this.rotation);
        TimeUnit timeUnit = TimeUnit.MICROSECONDS;
        return new TrackEffect<>(timeUnit.toMillis(this.start), timeUnit.toMillis(this.end - this.start), effectImage);
    }
}
