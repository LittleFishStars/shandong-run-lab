package com.cicada.player.utils;

import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class FrameInfo {
    public static final int FrameType_audio = 2;
    public static final int FrameType_unknow = 0;
    public static final int FrameType_video = 1;
    public long audio_channel_layout;
    public int audio_channels;
    public int audio_format;
    public int audio_nb_samples;
    public int audio_sample_rate;
    public long duration;
    public int frameType;
    public boolean key;
    public long pts;
    public long timePosition;
    public int video_colorRange;
    public int video_colorSpace;
    public int video_crop_bottom;
    public int video_crop_left;
    public int video_crop_right;
    public int video_crop_top;
    public double video_dar;
    public int video_format;
    public int video_height;
    public int video_rotate;
    public int video_width;
    public byte[][] audio_data = null;
    public long[] audio_data_addr = null;
    public int audio_data_addr_lineSize = 0;
    public long video_glContext = -1;
    public int video_textureOES_id = -1;
    public float[] video_textureOES_matrix = null;
    public byte[][] video_data = null;
    public long[] video_data_addr = null;
    public int[] video_data_addr_lineSize = null;
    public int[] video_texture2D_id = null;
    public int sei_type = 0;
    public byte[] sei_data = null;

    public enum PixelFormat {
        AF_PIX_FMT_NONE(-1),
        AF_PIX_FMT_YUV420P(0),
        AF_PIX_FMT_YUYV422(1),
        AF_PIX_FMT_RGB24(2),
        AF_PIX_FMT_BGR24(3),
        AF_PIX_FMT_YUV422P(4),
        AF_PIX_FMT_YUV444P(5),
        AF_PIX_FMT_YUV410P(6),
        AF_PIX_FMT_YUV411P(7),
        AF_PIX_FMT_GRAY8(8),
        AF_PIX_FMT_MONOWHITE(9),
        AF_PIX_FMT_MONOBLACK(10),
        AF_PIX_FMT_PAL8(11),
        AF_PIX_FMT_YUVJ420P(12),
        AF_PIX_FMT_YUVJ422P(13),
        AF_PIX_FMT_YUVJ444P(14),
        AF_PIX_FMT_UYVY422(15),
        AF_PIX_FMT_UYYVYY411(16),
        AF_PIX_FMT_BGR8(17),
        AF_PIX_FMT_BGR4(18),
        AF_PIX_FMT_BGR4_BYTE(19),
        AF_PIX_FMT_RGB8(20),
        AF_PIX_FMT_RGB4(21),
        AF_PIX_FMT_RGB4_BYTE(22),
        AF_PIX_FMT_NV12(23),
        AF_PIX_FMT_NV21(24),
        AF_PIX_FMT_YUV420P10BE(63),
        AF_PIX_FMT_YUV420P10LE(64),
        AF_PIX_FMT_D3D11(900),
        AF_PIX_FMT_DXVA2_VLD(901),
        AF_PIX_FMT_APPLE_PIXEL_BUFFER(1000),
        AF_PIX_FMT_CICADA_AF(1001),
        AF_PIX_FMT_CICADA_MEDIA_CODEC(1002);

        private int mValue;

        PixelFormat(int i) {
            this.mValue = i;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    public static class Rational {
        public int den;
        public int num;

        public String toString() {
            return "Rational{num=" + this.num + ", den=" + this.den + '}';
        }
    }

    public enum SampleFormat {
        AF_SAMPLE_FMT_NONE(-1),
        AF_SAMPLE_FMT_U8(0),
        AF_SAMPLE_FMT_S16(1),
        AF_SAMPLE_FMT_S32(2),
        AF_SAMPLE_FMT_FLT(3),
        AF_SAMPLE_FMT_DBL(4),
        AF_SAMPLE_FMT_U8P(5),
        AF_SAMPLE_FMT_S16P(6),
        AF_SAMPLE_FMT_S32P(7),
        AF_SAMPLE_FMT_FLTP(8),
        AF_SAMPLE_FMT_DBLP(9),
        AF_SAMPLE_FMT_NB(10);

        private int mValue;

        SampleFormat(int i) {
            this.mValue = i;
        }

        public int getValue() {
            return this.mValue;
        }
    }

    @NativeUsed
    private void setAudioData(byte[][] bArr) {
        this.audio_data = bArr;
    }

    @NativeUsed
    private void setAudioDataAddr(long[] jArr) {
        this.audio_data_addr = jArr;
    }

    @NativeUsed
    private void setSEIData(int i, byte[] bArr) {
        this.sei_type = i;
        this.sei_data = bArr;
    }

    @NativeUsed
    private void setVideoData(byte[][] bArr) {
        this.video_data = bArr;
    }

    @NativeUsed
    private void setVideoDataAddr(long[] jArr) {
        this.video_data_addr = jArr;
    }

    @NativeUsed
    private void setVideoDataAddrLineSize(int[] iArr) {
        this.video_data_addr_lineSize = iArr;
    }

    @NativeUsed
    private void setVideoTextureOESMatrix(float[] fArr) {
        this.video_textureOES_matrix = fArr;
    }

    @NativeUsed
    private void setVideo_texture2D_id(int[] iArr) {
        this.video_texture2D_id = iArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("FrameInfo{frameType=");
        sb.append(this.frameType);
        sb.append(", pts=");
        sb.append(this.pts);
        sb.append(", duration=");
        sb.append(this.duration);
        sb.append(", key=");
        sb.append(this.key);
        sb.append(", timePosition=");
        sb.append(this.timePosition);
        sb.append(", audio_format=");
        sb.append(this.audio_format);
        sb.append(", audio_nb_samples=");
        sb.append(this.audio_nb_samples);
        sb.append(", audio_channels=");
        sb.append(this.audio_channels);
        sb.append(", audio_sample_rate=");
        sb.append(this.audio_sample_rate);
        sb.append(", audio_channel_layout=");
        sb.append(this.audio_channel_layout);
        sb.append(", audio_data=");
        byte[][] bArr = this.audio_data;
        sb.append(bArr == null ? "null" : Integer.valueOf(bArr.length));
        sb.append(", audio_data_addr_lineSize=");
        sb.append(this.audio_data_addr_lineSize);
        sb.append(", video_format=");
        sb.append(this.video_format);
        sb.append(", video_width=");
        sb.append(this.video_width);
        sb.append(", video_height=");
        sb.append(this.video_height);
        sb.append(", video_rotate=");
        sb.append(this.video_rotate);
        sb.append(", video_crop_top=");
        sb.append(this.video_crop_top);
        sb.append(", video_crop_bottom=");
        sb.append(this.video_crop_bottom);
        sb.append(", video_crop_left=");
        sb.append(this.video_crop_left);
        sb.append(", video_crop_right=");
        sb.append(this.video_crop_right);
        sb.append(", video_colorRange=");
        sb.append(this.video_colorRange);
        sb.append(", video_colorSpace=");
        sb.append(this.video_colorSpace);
        sb.append(", video_glContext=");
        sb.append(this.video_glContext);
        sb.append(", video_textureOES_id=");
        sb.append(this.video_textureOES_id);
        sb.append(", video_textureOES_matrix=");
        sb.append(Arrays.toString(this.video_textureOES_matrix));
        sb.append(", video_data=");
        byte[][] bArr2 = this.video_data;
        sb.append(bArr2 != null ? Integer.valueOf(bArr2.length) : "null");
        sb.append(", video_data_addr=");
        sb.append(Arrays.toString(this.video_data_addr));
        sb.append(", video_texture2D_id=");
        sb.append(Arrays.toString(this.video_texture2D_id));
        sb.append(", video_dar=");
        sb.append(this.video_dar);
        sb.append('}');
        return sb.toString();
    }
}
