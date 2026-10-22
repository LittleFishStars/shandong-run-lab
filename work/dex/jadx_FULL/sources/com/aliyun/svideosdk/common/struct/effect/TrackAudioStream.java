package com.aliyun.svideosdk.common.struct.effect;

import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import android.util.Log;
import com.aliyun.Visible;
import com.aliyun.common.utils.q;
import com.aliyun.svideosdk.common.struct.project.Source;
import com.aliyun.svideosdk.transcode.NativeParser;
import java.io.File;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class TrackAudioStream extends EffectBase {
    private int audioWeight = 50;
    protected long duration;
    private long startTime;
    protected long streamDuration;
    protected int streamId;
    protected long streamStartTime;

    @Visible
    public static final class Builder {
        private TrackAudioStream mEffectStream = new TrackAudioStream();

        public Builder audioWeight(int i) {
            this.mEffectStream.audioWeight = Math.min(100, Math.max(i, 0));
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:45:0x00a4  */
        /* JADX WARN: Code duplicated, block: B:49:0x00b8  */
        /* JADX WARN: Code duplicated, block: B:52:0x009a A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Code duplicated, block: B:65:? A[SYNTHETIC] */
        /* JADX WARN: Instruction removed from duplicated block: B:49:0x00b8, please report this as an issue */
        public TrackAudioStream build() throws Throwable {
            TrackAudioStream trackAudioStream;
            long j;
            long j2;
            long j3;
            Throwable th;
            NativeParser nativeParser;
            MediaMetadataRetriever mediaMetadataRetriever;
            Exception e;
            TrackAudioStream trackAudioStream2;
            if (this.mEffectStream.streamStartTime >= 0) {
                MediaMetadataRetriever mediaMetadataRetriever2 = null;
                try {
                    nativeParser = new NativeParser();
                    try {
                        nativeParser.init(this.mEffectStream.getSource().getPath());
                        mediaMetadataRetriever = new MediaMetadataRetriever();
                        try {
                            try {
                                mediaMetadataRetriever.setDataSource(this.mEffectStream.getSource().getPath());
                                String strExtractMetadata = mediaMetadataRetriever.extractMetadata(9);
                                if (!TextUtils.isEmpty(strExtractMetadata)) {
                                    long jMin = Long.parseLong(strExtractMetadata);
                                    String value = nativeParser.getValue(18);
                                    if (TextUtils.isEmpty(value)) {
                                        trackAudioStream2 = this.mEffectStream;
                                    } else {
                                        long j4 = Long.parseLong(value) / 1000;
                                        trackAudioStream2 = this.mEffectStream;
                                        trackAudioStream2.streamStartTime = (trackAudioStream2.streamStartTime * j4) / jMin;
                                        jMin = Math.min(j4, jMin);
                                    }
                                    trackAudioStream2.duration = jMin;
                                }
                                try {
                                    mediaMetadataRetriever.release();
                                } catch (Exception e2) {
                                    e2.printStackTrace();
                                }
                            } catch (Exception e3) {
                                e = e3;
                                e.printStackTrace();
                                if (mediaMetadataRetriever != null) {
                                    try {
                                        mediaMetadataRetriever.release();
                                    } catch (Exception e4) {
                                        e4.printStackTrace();
                                    }
                                }
                                if (nativeParser != null) {
                                }
                                trackAudioStream = this.mEffectStream;
                                j = trackAudioStream.streamStartTime;
                                j2 = trackAudioStream.streamDuration + j;
                                j3 = trackAudioStream.duration;
                                if (j2 > j3) {
                                    trackAudioStream.streamDuration = j3 - j;
                                    Log.e("AliYunLog", "EffectStream streamDuration exceed the stream duration, the streamDuration adjust to " + this.mEffectStream.streamDuration);
                                }
                                return this.mEffectStream;
                            }
                        } catch (Throwable th2) {
                            MediaMetadataRetriever mediaMetadataRetriever3 = mediaMetadataRetriever;
                            th = th2;
                            mediaMetadataRetriever2 = mediaMetadataRetriever3;
                            if (mediaMetadataRetriever2 != null) {
                                try {
                                    mediaMetadataRetriever2.release();
                                } catch (Exception e5) {
                                    e5.printStackTrace();
                                }
                            }
                            if (nativeParser != null) {
                                throw th;
                            }
                            nativeParser.release();
                            nativeParser.dispose();
                            throw th;
                        }
                    } catch (Exception e6) {
                        mediaMetadataRetriever = null;
                        e = e6;
                    } catch (Throwable th3) {
                        th = th3;
                        if (mediaMetadataRetriever2 != null) {
                            mediaMetadataRetriever2.release();
                        }
                        if (nativeParser != null) {
                            throw th;
                        }
                        nativeParser.release();
                        nativeParser.dispose();
                        throw th;
                    }
                } catch (Exception e7) {
                    mediaMetadataRetriever = null;
                    e = e7;
                    nativeParser = null;
                } catch (Throwable th4) {
                    th = th4;
                    nativeParser = null;
                }
                nativeParser.release();
                nativeParser.dispose();
            }
            trackAudioStream = this.mEffectStream;
            j = trackAudioStream.streamStartTime;
            j2 = trackAudioStream.streamDuration + j;
            j3 = trackAudioStream.duration;
            if (j2 > j3) {
                trackAudioStream.streamDuration = j3 - j;
                Log.e("AliYunLog", "EffectStream streamDuration exceed the stream duration, the streamDuration adjust to " + this.mEffectStream.streamDuration);
            }
            return this.mEffectStream;
        }

        public Builder source(Source source) {
            this.mEffectStream.setSource(source);
            return this;
        }

        public Builder startTime(long j, TimeUnit timeUnit) {
            this.mEffectStream.startTime = Math.max(timeUnit.toMillis(j), 0L);
            return this;
        }

        public Builder streamDuration(long j, TimeUnit timeUnit) {
            this.mEffectStream.streamDuration = Math.max(timeUnit.toMillis(j), 0L);
            return this;
        }

        public Builder streamId(int i) {
            this.mEffectStream.streamId = i;
            return this;
        }

        public Builder streamStartTime(long j, TimeUnit timeUnit) {
            this.mEffectStream.streamStartTime = Math.max(timeUnit.toMillis(j), 0L);
            return this;
        }
    }

    @Override // com.aliyun.svideosdk.common.struct.effect.EffectBase
    public boolean checkIsInvalid() {
        Source source = getSource();
        if (getSource() == null) {
            return true;
        }
        String path = source.getPath();
        if (!q.b(path) && new File(path).exists() && getStreamDuration() >= 0) {
            return super.checkIsInvalid();
        }
        return true;
    }

    public int getAudioWeight() {
        return this.audioWeight;
    }

    public long getDuration() {
        return this.duration;
    }

    public long getDuration(TimeUnit timeUnit) {
        return timeUnit.convert(this.duration, TimeUnit.MILLISECONDS);
    }

    public long getStartTime() {
        return this.startTime;
    }

    public long getStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.startTime, TimeUnit.MILLISECONDS);
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

    public int getStreamId() {
        return this.streamId;
    }

    public long getStreamStartTime() {
        return this.streamStartTime;
    }

    public long getStreamStartTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.streamStartTime, TimeUnit.MILLISECONDS);
    }

    public void setStreamDuration(long j, TimeUnit timeUnit) {
        if (j < 0) {
            j = 0;
        }
        this.streamDuration = timeUnit.toMillis(j);
    }

    public void setStreamId(int i) {
        this.streamId = i;
    }

    public void setStreamStartTime(long j, TimeUnit timeUnit) {
        if (j < 0) {
            j = 0;
        }
        this.streamStartTime = timeUnit.toMillis(j);
    }
}
