package com.aliyun.svideosdk.common.struct.effect;

import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.util.Log;
import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.project.Source;
import com.aliyun.svideosdk.transcode.NativeParser;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class EffectStream extends EffectBase {
    protected long duration;
    protected long streamDuration;
    protected long streamStartTime;

    @Visible
    public static final class Builder {
        private EffectStream mEffectStream = new EffectStream();

        public EffectStream build() {
            NativeParser nativeParser = new NativeParser();
            nativeParser.init(this.mEffectStream.getSource().getPath());
            nativeParser.getValue(16);
            if (this.mEffectStream.streamStartTime >= 0) {
                MediaMetadataRetriever mediaMetadataRetriever = new MediaMetadataRetriever();
                try {
                    try {
                        mediaMetadataRetriever.setDataSource(this.mEffectStream.getSource().getPath());
                        String strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
                        if (!TextUtils.isEmpty(strExtractMetadata)) {
                            long j = Long.parseLong(strExtractMetadata);
                            String value = nativeParser.getValue(18);
                            if (TextUtils.isEmpty(value)) {
                                this.mEffectStream.duration = j;
                            } else {
                                long j2 = Long.parseLong(value) / 1000;
                                EffectStream effectStream = this.mEffectStream;
                                effectStream.streamStartTime = (effectStream.streamStartTime * j2) / j;
                                effectStream.duration = Math.min(j2, j);
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } catch (Throwable th) {
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                    throw th;
                }
            }
            nativeParser.release();
            nativeParser.dispose();
            EffectStream effectStream2 = this.mEffectStream;
            long j3 = effectStream2.streamStartTime;
            long j4 = effectStream2.streamDuration + j3;
            long j5 = effectStream2.duration;
            if (j4 > j5) {
                effectStream2.streamDuration = j5 - j3;
                Log.e("AliYunLog", "EffectStream streamDuration exceed the stream duration, the streamDuration adjust to " + this.mEffectStream.streamDuration);
            }
            return this.mEffectStream;
        }

        public Builder source(Source source) {
            this.mEffectStream.setSource(source);
            return this;
        }

        public Builder streamDuration(long j, TimeUnit timeUnit) {
            this.mEffectStream.streamDuration = Math.max(timeUnit.toMillis(j), 0L);
            return this;
        }

        public Builder streamStartTime(long j, TimeUnit timeUnit) {
            this.mEffectStream.streamStartTime = Math.max(timeUnit.toMillis(j), 0L);
            return this;
        }
    }

    public long getDuration() {
        return this.duration;
    }

    public long getDuration(TimeUnit timeUnit) {
        return timeUnit.convert(this.duration, TimeUnit.MILLISECONDS);
    }

    public long getStreamDuration() {
        return this.streamDuration;
    }

    public long getStreamDuration(TimeUnit timeUnit) {
        return timeUnit.convert(this.streamDuration, TimeUnit.MILLISECONDS);
    }

    public long getStreamEndTime() {
        return this.streamStartTime + this.streamDuration;
    }

    public long getStreamEndTime(TimeUnit timeUnit) {
        return timeUnit.convert(getStreamEndTime(), TimeUnit.MILLISECONDS);
    }

    public long getStreamStartTime() {
        return this.streamStartTime;
    }

    public long getStreamStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.streamStartTime, TimeUnit.MILLISECONDS);
    }

    public void setStreamDuration(long j, TimeUnit timeUnit) {
        this.streamDuration = Math.max(timeUnit.toMillis(j), 0L);
    }

    public void setStreamStartTime(long j, TimeUnit timeUnit) {
        this.streamStartTime = Math.max(timeUnit.toMillis(j), 0L);
    }
}
