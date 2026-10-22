package com.aliyun.svideosdk.common.struct.common;

import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.util.Log;
import com.aliyun.Visible;
import com.aliyun.common.d.b;
import com.aliyun.svideosdk.common.struct.effect.TransitionBase;
import com.aliyun.svideosdk.transcode.NativeParser;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class AliyunVideoClip extends AliyunClip {
    private long mDuration;
    private long mEndTime;
    private int mRotation;
    private long mStartTime;

    @Visible
    public static final class Builder {
        private AliyunVideoClip mClip;

        public Builder() {
            AliyunVideoClip aliyunVideoClip = new AliyunVideoClip();
            this.mClip = aliyunVideoClip;
            aliyunVideoClip.setMediaType(MediaType.ANY_VIDEO_TYPE);
        }

        /* JADX WARN: Code duplicated, block: B:88:0x013d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        public AliyunVideoClip build() throws Throwable {
            Exception e;
            int i;
            MediaMetadataRetriever mediaMetadataRetriever;
            int i2;
            long j;
            long j2;
            MediaMetadataRetriever mediaMetadataRetriever2 = null;
            if (TextUtils.isEmpty(this.mClip.getSource())) {
                Log.e("AliYunLog", "Source is null!");
                return null;
            }
            int i3 = 0;
            try {
                mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    try {
                        mediaMetadataRetriever.setDataSource(this.mClip.getSource());
                        i2 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(18));
                        try {
                            i = Integer.parseInt(mediaMetadataRetriever.extractMetadata(19));
                            try {
                                i3 = Integer.parseInt(mediaMetadataRetriever.extractMetadata(24));
                                j2 = Long.parseLong(mediaMetadataRetriever.extractMetadata(9) + "000");
                                try {
                                    mediaMetadataRetriever.release();
                                } catch (Exception e2) {
                                    e = e2;
                                    e.printStackTrace();
                                }
                            } catch (Exception e3) {
                                e = e3;
                                try {
                                    Log.e("AliYunLog", "parseStreamSize failed", e);
                                    NativeParser nativeParser = new NativeParser();
                                    nativeParser.init(this.mClip.getSource());
                                    try {
                                        try {
                                            i2 = Integer.parseInt(nativeParser.getValue(6));
                                            i = Integer.parseInt(nativeParser.getValue(7));
                                            i3 = Integer.parseInt(nativeParser.getValue(14));
                                            j = Long.parseLong(nativeParser.getValue(3));
                                            nativeParser.release();
                                        } catch (Exception unused) {
                                            Log.e("AliYunLog", "parse rotation failed");
                                            nativeParser.release();
                                            j = 0;
                                        }
                                        nativeParser.dispose();
                                        if (mediaMetadataRetriever != null) {
                                            try {
                                                mediaMetadataRetriever.release();
                                            } catch (Exception e4) {
                                                e = e4;
                                                j2 = j;
                                                e.printStackTrace();
                                            }
                                        }
                                        j2 = j;
                                    } catch (Throwable th) {
                                        nativeParser.release();
                                        nativeParser.dispose();
                                        throw th;
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    mediaMetadataRetriever2 = mediaMetadataRetriever;
                                    mediaMetadataRetriever = mediaMetadataRetriever2;
                                    if (mediaMetadataRetriever != null) {
                                        try {
                                            mediaMetadataRetriever.release();
                                        } catch (Exception e5) {
                                            e5.printStackTrace();
                                        }
                                    }
                                    throw th;
                                }
                            }
                        } catch (Exception e6) {
                            e = e6;
                            i = 0;
                        }
                    } catch (Exception e7) {
                        e = e7;
                        i2 = 0;
                        i = 0;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    if (mediaMetadataRetriever != null) {
                        mediaMetadataRetriever.release();
                    }
                    throw th;
                }
            } catch (Exception e8) {
                e = e8;
                i = 0;
                mediaMetadataRetriever = null;
                i2 = 0;
            } catch (Throwable th4) {
                th = th4;
                mediaMetadataRetriever = mediaMetadataRetriever2;
                if (mediaMetadataRetriever != null) {
                    mediaMetadataRetriever.release();
                }
                throw th;
            }
            if (this.mClip.getEndTime() <= 0) {
                this.mClip.setEndTime(b.a(j2));
            }
            if (i3 == 90 || i3 == 270) {
                AliyunVideoClip aliyunVideoClip = this.mClip;
                aliyunVideoClip.mClipHeight = i2;
                aliyunVideoClip.mClipWidth = i;
            } else {
                AliyunVideoClip aliyunVideoClip2 = this.mClip;
                aliyunVideoClip2.mClipWidth = i2;
                aliyunVideoClip2.mClipHeight = i;
            }
            if (this.mClip.mDuration != 0 && this.mClip.mStartTime + this.mClip.mDuration > this.mClip.mEndTime) {
                AliyunVideoClip aliyunVideoClip3 = this.mClip;
                aliyunVideoClip3.mEndTime = aliyunVideoClip3.mStartTime + this.mClip.mDuration;
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

        public Builder endTime(long j) {
            this.mClip.setEndTime(j);
            return this;
        }

        public Builder id(int i) {
            this.mClip.setId(i);
            return this;
        }

        public Builder rotation(int i) {
            this.mClip.setRotation(i);
            return this;
        }

        public Builder source(String str) {
            this.mClip.setSource(str);
            return this;
        }

        public Builder startTime(long j) {
            this.mClip.setStartTime(j);
            return this;
        }

        public Builder transition(TransitionBase transitionBase) {
            this.mClip.setTransition(transitionBase);
            return this;
        }
    }

    private AliyunVideoClip() {
        this.mStartTime = 0L;
        this.mEndTime = 0L;
        this.mRotation = -1;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public long getEndTime() {
        return this.mEndTime;
    }

    public int getRotation() {
        return this.mRotation;
    }

    public long getStartTime() {
        return this.mStartTime;
    }

    public int getVideoHeight() {
        return getClipHeight();
    }

    public int getVideoWidth() {
        return getClipWidth();
    }

    public void setDuration(long j) {
        this.mDuration = Math.max(j, 0L);
    }

    public void setEndTime(long j) {
        this.mEndTime = Math.max(j, 0L);
    }

    public void setRotation(int i) {
        this.mRotation = i;
    }

    public void setStartTime(long j) {
        this.mStartTime = Math.max(j, 0L);
    }
}
