package com.aliyun.svideosdk.common.struct.common;

import android.graphics.BitmapFactory;
import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.effect.TransitionBase;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class AliyunImageClip extends AliyunClip {
    private long mDuration;

    @Visible
    public static final class Builder {
        private AliyunImageClip mClip;

        public Builder() {
            AliyunImageClip aliyunImageClip = new AliyunImageClip();
            this.mClip = aliyunImageClip;
            aliyunImageClip.setMediaType(MediaType.ANY_IMAGE_TYPE);
        }

        public AliyunImageClip build() {
            try {
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inJustDecodeBounds = true;
                BitmapFactory.decodeFile(this.mClip.getSource(), options);
                AliyunImageClip aliyunImageClip = this.mClip;
                aliyunImageClip.mClipWidth = options.outWidth;
                aliyunImageClip.mClipHeight = options.outHeight;
            } catch (Exception e) {
                e.printStackTrace();
            }
            return this.mClip;
        }

        public Builder displayMode(AliyunDisplayMode aliyunDisplayMode) {
            this.mClip.setDisplayMode(aliyunDisplayMode);
            return this;
        }

        public Builder duration(long j) {
            this.mClip.setDuration(j);
            return this;
        }

        public Builder id(int i) {
            this.mClip.setId(i);
            return this;
        }

        public Builder source(String str) {
            this.mClip.setSource(str);
            return this;
        }

        public Builder transition(TransitionBase transitionBase) {
            this.mClip.setTransition(transitionBase);
            return this;
        }
    }

    private AliyunImageClip() {
    }

    public long getDuration() {
        return this.mDuration;
    }

    public int getImageHeight() {
        return getClipHeight();
    }

    public int getImageWidth() {
        return getClipWidth();
    }

    public void setDuration(long j) {
        this.mDuration = j;
    }
}
