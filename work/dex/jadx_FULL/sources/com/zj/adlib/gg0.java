package com.zj.adlib;

import android.content.Context;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaExtractor;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.ParcelFileDescriptor;
import android.util.Pair;
import android.view.Surface;
import androidx.camera.video.AudioStats;
import com.alibaba.ariver.commonability.device.jsapi.wifi.WifiManagerBridgeExtension;
import com.google.android.exoplayer2.source.i;
import com.google.android.exoplayer2.util.FileTypes;
import com.google.android.exoplayer2.video.spherical.a;
import com.hw.videoprocessor.util.VideoProgressListener;
import com.ipd.dsp.internal.v1.b;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import net.surina.soundtouch.SoundTouch;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class gg0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static int f41896a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f16757a = "VideoProcessor";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Map<Integer, Integer> f16758a;

    static {
        HashMap map = new HashMap();
        f16758a = map;
        map.put(96000, 0);
        map.put(88200, 1);
        map.put(64000, 2);
        map.put(48000, 3);
        map.put(Integer.valueOf(i.K), 4);
        map.put(Integer.valueOf(a.h), 5);
        map.put(24000, 6);
        map.put(22050, 7);
        map.put(16000, 8);
        map.put(Integer.valueOf(WifiManagerBridgeExtension.ERROR_12000), 9);
        map.put(11025, 10);
        map.put(8000, 11);
        map.put(7350, 12);
        f41896a = 1;
    }

    public static void a(Context context, jo9.c cVar, String str, int i, @Nullable VideoProgressListener videoProgressListener) throws Throwable {
        String str2 = "temp_aac_" + System.currentTimeMillis();
        File file = new File(np9.h(context), str2 + ".pcm");
        File file2 = new File(np9.h(context), str2 + "_2.pcm");
        File file3 = new File(np9.h(context), str2 + FileTypes.B);
        h(cVar, file.getAbsolutePath(), null, null);
        b(file.getAbsolutePath(), file2.getAbsolutePath(), i);
        MediaExtractor mediaExtractor = new MediaExtractor();
        cVar.a(mediaExtractor);
        MediaFormat trackFormat = mediaExtractor.getTrackFormat(np9.m(mediaExtractor, true));
        int integer = trackFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE);
        int integer2 = trackFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT);
        new nn6(integer, integer2 == 2 ? 12 : 16, integer2, 2).a(file2.getAbsolutePath(), file3.getAbsolutePath());
        i(file3.getPath(), str, trackFormat, videoProgressListener);
    }

    public static void b(String str, String str2, int i) throws IOException {
        if (i == 100) {
            g(str, str2);
            return;
        }
        float fN = n(i);
        byte[] bArr = new byte[2048];
        FileInputStream fileInputStream = new FileInputStream(str);
        FileOutputStream fileOutputStream = new FileOutputStream(str2);
        while (fileInputStream.read(bArr) != -1) {
            try {
                for (int i2 = 0; i2 < 2048; i2 += 2) {
                    int i3 = i2 + 1;
                    int i4 = (int) (((short) ((bArr[i2] & 255) | ((bArr[i3] & 255) << 8))) * fN);
                    int i5 = 32767;
                    if (i4 > 32767) {
                        i4 = i5;
                    } else {
                        i5 = -32768;
                        if (i4 < -32768) {
                            i4 = i5;
                        }
                    }
                    bArr[i2] = (byte) (i4 & 255);
                    bArr[i3] = (byte) ((i4 >>> 8) & 255);
                }
                fileOutputStream.write(bArr);
            } catch (Throwable th) {
                fileInputStream.close();
                fileOutputStream.close();
                throw th;
            }
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    public static Pair<Integer, Integer> c(String str, String str2, MediaFormat mediaFormat, MediaFormat mediaFormat2) {
        int i;
        int i2 = 1;
        int integer = mediaFormat.containsKey(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT) ? mediaFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT) : 1;
        int integer2 = mediaFormat2.containsKey(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT) ? mediaFormat2.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT) : 1;
        boolean zContainsKey = mediaFormat.containsKey(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE);
        int integer3 = i.K;
        int integer4 = zContainsKey ? mediaFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE) : 44100;
        if (mediaFormat2.containsKey(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE)) {
            integer3 = mediaFormat2.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE);
        }
        if (integer == integer2 && integer4 == integer3 && integer <= 2) {
            return new Pair<>(Integer.valueOf(integer), Integer.valueOf(integer4));
        }
        File file = new File(str + ".temp");
        File file2 = new File(str2 + ".temp");
        if (integer != integer2 || integer > 2 || integer2 > 2) {
            if (integer > 1) {
                try {
                    try {
                        t(str, file.getAbsolutePath(), integer);
                        File file3 = new File(str);
                        file3.delete();
                        file.renameTo(file3);
                        i = 1;
                    } finally {
                        file.delete();
                        file2.exists();
                    }
                } catch (Exception e) {
                    e = e;
                    v61.g(e);
                    return new Pair<>(Integer.valueOf(integer), Integer.valueOf(integer4));
                }
            } else {
                i = integer;
            }
            if (integer2 > 1) {
                t(str2, file2.getAbsolutePath(), integer2);
                File file4 = new File(str2);
                file4.delete();
                file2.renameTo(file4);
                integer2 = 1;
            }
            integer = i;
        } else {
            i2 = integer;
        }
        if (integer4 != integer3) {
            try {
                int iMin = Math.min(integer4, integer3);
                if (integer4 != iMin) {
                    try {
                        o(str, file.getAbsolutePath(), integer4, iMin, integer);
                        File file5 = new File(str);
                        file5.delete();
                        file.renameTo(file5);
                    } catch (Exception e2) {
                        e = e2;
                        integer4 = iMin;
                        integer = i2;
                        v61.g(e);
                        return new Pair<>(Integer.valueOf(integer), Integer.valueOf(integer4));
                    }
                }
                if (integer3 != iMin) {
                    o(str2, file2.getAbsolutePath(), integer3, iMin, integer2);
                    File file6 = new File(str2);
                    file6.delete();
                    file2.renameTo(file6);
                }
                integer4 = iMin;
            } catch (Exception e3) {
                e = e3;
            }
        }
        return new Pair<>(Integer.valueOf(i2), Integer.valueOf(integer4));
    }

    /* JADX WARN: Code duplicated, block: B:44:0x00b1 A[Catch: IOException -> 0x00ad, TryCatch #7 {IOException -> 0x00ad, blocks: (B:40:0x00a9, B:44:0x00b1, B:46:0x00b6, B:48:0x00bb), top: B:72:0x00a9 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x00b6 A[Catch: IOException -> 0x00ad, TryCatch #7 {IOException -> 0x00ad, blocks: (B:40:0x00a9, B:44:0x00b1, B:46:0x00b6, B:48:0x00bb), top: B:72:0x00a9 }] */
    /* JADX WARN: Code duplicated, block: B:48:0x00bb A[Catch: IOException -> 0x00ad, TRY_LEAVE, TryCatch #7 {IOException -> 0x00ad, blocks: (B:40:0x00a9, B:44:0x00b1, B:46:0x00b6, B:48:0x00bb), top: B:72:0x00a9 }] */
    /* JADX WARN: Code duplicated, block: B:57:0x00cc A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:58:0x00ce A[Catch: IOException -> 0x00ca, TryCatch #1 {IOException -> 0x00ca, blocks: (B:54:0x00c6, B:58:0x00ce, B:60:0x00d3, B:62:0x00d8), top: B:68:0x00c6 }] */
    /* JADX WARN: Code duplicated, block: B:60:0x00d3 A[Catch: IOException -> 0x00ca, TryCatch #1 {IOException -> 0x00ca, blocks: (B:54:0x00c6, B:58:0x00ce, B:60:0x00d3, B:62:0x00d8), top: B:68:0x00c6 }] */
    /* JADX WARN: Code duplicated, block: B:62:0x00d8 A[Catch: IOException -> 0x00ca, TRY_LEAVE, TryCatch #1 {IOException -> 0x00ca, blocks: (B:54:0x00c6, B:58:0x00ce, B:60:0x00d3, B:62:0x00d8), top: B:68:0x00c6 }] */
    /* JADX WARN: Code duplicated, block: B:68:0x00c6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    public static File d(File file, int i, int i2) throws Throwable {
        FileChannel fileChannel;
        FileOutputStream fileOutputStream;
        FileChannel channel;
        if (i >= i2) {
            return file;
        }
        File file2 = new File(file.getAbsolutePath() + ".concat");
        float f = ((float) i2) / ((float) i);
        int i3 = (int) f;
        FileInputStream fileInputStream = null;
        channel = null;
        FileChannel channel2 = null;
        fileInputStream = null;
        try {
            FileInputStream fileInputStream2 = new FileInputStream(file);
            try {
                fileOutputStream = new FileOutputStream(file2);
                try {
                    channel = fileInputStream2.getChannel();
                    try {
                        channel2 = fileOutputStream.getChannel();
                        for (int i4 = 0; i4 < i3; i4++) {
                            channel.transferTo(0L, channel.size(), channel2);
                            channel.position(0L);
                        }
                        int length = (int) (file.length() * (f - i3));
                        if (length > 1024) {
                            channel.transferTo(0L, length, channel2);
                        }
                        channel.close();
                        channel2.close();
                        file.delete();
                        file2.renameTo(file);
                        try {
                            fileInputStream2.close();
                            fileOutputStream.close();
                            channel.close();
                            channel2.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        return file;
                    } catch (Exception e2) {
                        e = e2;
                        fileChannel = channel2;
                        fileInputStream = fileInputStream2;
                        try {
                            e.printStackTrace();
                            file2.delete();
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    if (channel != null) {
                                        channel.close();
                                    }
                                    if (fileChannel != null) {
                                        fileChannel.close();
                                    }
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                    return file;
                                }
                            } else {
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                if (channel != null) {
                                    channel.close();
                                }
                                if (fileChannel != null) {
                                    fileChannel.close();
                                }
                            }
                            return file;
                        } catch (Throwable th) {
                            th = th;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                    if (fileOutputStream != null) {
                                        fileOutputStream.close();
                                    }
                                    if (channel != null) {
                                        channel.close();
                                    }
                                    if (fileChannel != null) {
                                        fileChannel.close();
                                    }
                                } catch (IOException e4) {
                                    e4.printStackTrace();
                                    throw th;
                                }
                            } else {
                                if (fileOutputStream != null) {
                                    fileOutputStream.close();
                                }
                                if (channel != null) {
                                    channel.close();
                                }
                                if (fileChannel != null) {
                                    fileChannel.close();
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        fileChannel = channel2;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            if (channel != null) {
                                channel.close();
                            }
                            if (fileChannel != null) {
                                fileChannel.close();
                            }
                        } else {
                            if (fileOutputStream != null) {
                                fileOutputStream.close();
                            }
                            if (channel != null) {
                                channel.close();
                            }
                            if (fileChannel != null) {
                                fileChannel.close();
                            }
                        }
                        throw th;
                    }
                } catch (Exception e5) {
                    e = e5;
                    fileChannel = null;
                    channel = null;
                } catch (Throwable th3) {
                    th = th3;
                    fileChannel = null;
                    channel = null;
                }
            } catch (Exception e6) {
                e = e6;
                fileChannel = null;
                fileOutputStream = null;
                channel = null;
            } catch (Throwable th4) {
                th = th4;
                fileChannel = null;
                fileOutputStream = null;
                channel = null;
            }
        } catch (Exception e7) {
            e = e7;
            fileChannel = null;
            fileOutputStream = null;
            channel = null;
        } catch (Throwable th5) {
            th = th5;
            fileChannel = null;
            fileOutputStream = null;
            channel = null;
        }
    }

    public static void e(MediaFormat mediaFormat, int i, int i2, int i3) {
        Map<Integer, Integer> map = f16758a;
        int iIntValue = map.containsKey(Integer.valueOf(i2)) ? map.get(Integer.valueOf(i2)).intValue() : 4;
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(2);
        byteBufferAllocate.put(0, (byte) ((i << 3) | (iIntValue >> 1)));
        byteBufferAllocate.put(1, (byte) (((iIntValue & 1) << 7) | (i3 << 3)));
        mediaFormat.setByteBuffer("csd-0", byteBufferAllocate);
    }

    public static void f(jo9.c cVar, String str) throws IOException {
        String str2 = cVar.f17451a;
        if (str2 != null) {
            g(str2, str);
            return;
        }
        ParcelFileDescriptor parcelFileDescriptorOpenFileDescriptor = cVar.f42634a.getContentResolver().openFileDescriptor(cVar.f17450a, "rw");
        FileChannel channel = new FileOutputStream(str).getChannel();
        FileChannel channel2 = new FileInputStream(parcelFileDescriptorOpenFileDescriptor.getFileDescriptor()).getChannel();
        channel2.transferTo(0L, channel2.size(), channel);
    }

    public static void g(String str, String str2) throws IOException {
        FileChannel channel = new FileOutputStream(str2).getChannel();
        FileChannel channel2 = new FileInputStream(str).getChannel();
        channel2.transferTo(0L, channel2.size(), channel);
    }

    /* JADX WARN: Code duplicated, block: B:28:0x009e A[Catch: all -> 0x00ed, TryCatch #0 {all -> 0x00ed, blocks: (B:14:0x0070, B:16:0x0076, B:28:0x009e, B:34:0x00f3, B:39:0x0100, B:41:0x011d, B:42:0x0135, B:46:0x015d, B:45:0x013c, B:29:0x00ae, B:19:0x0082, B:21:0x008b, B:23:0x0091), top: B:53:0x0070 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x00ae A[Catch: all -> 0x00ed, TryCatch #0 {all -> 0x00ed, blocks: (B:14:0x0070, B:16:0x0076, B:28:0x009e, B:34:0x00f3, B:39:0x0100, B:41:0x011d, B:42:0x0135, B:46:0x015d, B:45:0x013c, B:29:0x00ae, B:19:0x0082, B:21:0x008b, B:23:0x0091), top: B:53:0x0070 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x00f3 A[Catch: all -> 0x00ed, TryCatch #0 {all -> 0x00ed, blocks: (B:14:0x0070, B:16:0x0076, B:28:0x009e, B:34:0x00f3, B:39:0x0100, B:41:0x011d, B:42:0x0135, B:46:0x015d, B:45:0x013c, B:29:0x00ae, B:19:0x0082, B:21:0x008b, B:23:0x0091), top: B:53:0x0070 }] */
    /* JADX WARN: Code duplicated, block: B:37:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:44:0x013a  */
    /* JADX WARN: Code duplicated, block: B:45:0x013c A[Catch: all -> 0x00ed, TryCatch #0 {all -> 0x00ed, blocks: (B:14:0x0070, B:16:0x0076, B:28:0x009e, B:34:0x00f3, B:39:0x0100, B:41:0x011d, B:42:0x0135, B:46:0x015d, B:45:0x013c, B:29:0x00ae, B:19:0x0082, B:21:0x008b, B:23:0x0091), top: B:53:0x0070 }] */
    /* JADX WARN: Code duplicated, block: B:65:0x00fc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:66:0x011b A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:67:0x0100 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:68:0x0135 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:69:0x011d A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:29:0x00ae, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:45:0x013c, please report this as an issue */
    public static void h(jo9.c cVar, String str, Integer num, Integer num2) throws IOException {
        String str2;
        int iDequeueOutputBuffer;
        boolean z;
        MediaExtractor mediaExtractor = new MediaExtractor();
        cVar.a(mediaExtractor);
        boolean z2 = true;
        int iM = np9.m(mediaExtractor, true);
        mediaExtractor.selectTrack(iM);
        Integer num3 = num == null ? 0 : num;
        mediaExtractor.seekTo(num3.intValue(), 2);
        MediaFormat trackFormat = mediaExtractor.getTrackFormat(iM);
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(trackFormat.containsKey("max-input-size") ? trackFormat.getInteger("max-input-size") : 100000);
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        MediaCodec mediaCodecCreateDecoderByType = MediaCodec.createDecoderByType(trackFormat.getString("mime"));
        mediaCodecCreateDecoderByType.configure(trackFormat, (Surface) null, (MediaCrypto) null, 0);
        mediaCodecCreateDecoderByType.start();
        FileChannel channel = new FileOutputStream(new File(str)).getChannel();
        boolean z3 = false;
        boolean z4 = false;
        while (!z3) {
            if (!z4) {
                try {
                    int iDequeueInputBuffer = mediaCodecCreateDecoderByType.dequeueInputBuffer(b.C0923b.f);
                    if (iDequeueInputBuffer >= 0) {
                        long sampleTime = mediaExtractor.getSampleTime();
                        if (sampleTime != -1) {
                            if (sampleTime < num3.intValue()) {
                                mediaExtractor.advance();
                            } else {
                                if (num2 == null || sampleTime <= num2.intValue()) {
                                    z = false;
                                }
                                if (z) {
                                    str2 = "VideoProcessor";
                                    mediaCodecCreateDecoderByType.queueInputBuffer(iDequeueInputBuffer, 0, 0, 0L, 4);
                                    z4 = true;
                                } else {
                                    str2 = "VideoProcessor";
                                    bufferInfo.size = mediaExtractor.readSampleData(byteBufferAllocateDirect, 0);
                                    bufferInfo.presentationTimeUs = sampleTime;
                                    bufferInfo.flags = mediaExtractor.getSampleFlags();
                                    mediaCodecCreateDecoderByType.getInputBuffer(iDequeueInputBuffer).put(byteBufferAllocateDirect);
                                    v61.n(str2, "audio decode queueInputBuffer " + (bufferInfo.presentationTimeUs / 1000), new Object[0]);
                                    mediaCodecCreateDecoderByType.queueInputBuffer(iDequeueInputBuffer, 0, bufferInfo.size, bufferInfo.presentationTimeUs, bufferInfo.flags);
                                    mediaExtractor.advance();
                                }
                                while (!z3) {
                                    iDequeueOutputBuffer = mediaCodecCreateDecoderByType.dequeueOutputBuffer(bufferInfo, b.C0923b.f);
                                    if (iDequeueOutputBuffer == -1) {
                                        break;
                                    }
                                    if (iDequeueOutputBuffer == -2) {
                                        v61.n(str2, "audio decode newFormat = " + mediaCodecCreateDecoderByType.getOutputFormat(), new Object[0]);
                                    } else if (iDequeueOutputBuffer < 0) {
                                        v61.h(str2, "unexpected result from audio decoder.dequeueOutputBuffer: " + iDequeueOutputBuffer, new Object[0]);
                                    } else {
                                        if (bufferInfo.flags == 4) {
                                            z3 = true;
                                        } else {
                                            ByteBuffer outputBuffer = mediaCodecCreateDecoderByType.getOutputBuffer(iDequeueOutputBuffer);
                                            v61.n(str2, "audio decode saveFrame " + (bufferInfo.presentationTimeUs / 1000), new Object[0]);
                                            channel.write(outputBuffer);
                                        }
                                        mediaCodecCreateDecoderByType.releaseOutputBuffer(iDequeueOutputBuffer, false);
                                    }
                                }
                                z2 = true;
                            }
                        }
                        z = z2;
                        if (z) {
                            str2 = "VideoProcessor";
                            mediaCodecCreateDecoderByType.queueInputBuffer(iDequeueInputBuffer, 0, 0, 0L, 4);
                            z4 = true;
                        } else {
                            str2 = "VideoProcessor";
                            bufferInfo.size = mediaExtractor.readSampleData(byteBufferAllocateDirect, 0);
                            bufferInfo.presentationTimeUs = sampleTime;
                            bufferInfo.flags = mediaExtractor.getSampleFlags();
                            mediaCodecCreateDecoderByType.getInputBuffer(iDequeueInputBuffer).put(byteBufferAllocateDirect);
                            v61.n(str2, "audio decode queueInputBuffer " + (bufferInfo.presentationTimeUs / 1000), new Object[0]);
                            mediaCodecCreateDecoderByType.queueInputBuffer(iDequeueInputBuffer, 0, bufferInfo.size, bufferInfo.presentationTimeUs, bufferInfo.flags);
                            mediaExtractor.advance();
                        }
                        while (!z3) {
                            iDequeueOutputBuffer = mediaCodecCreateDecoderByType.dequeueOutputBuffer(bufferInfo, b.C0923b.f);
                            if (iDequeueOutputBuffer == -1) {
                                break;
                                break;
                            }
                            if (iDequeueOutputBuffer == -2) {
                                v61.n(str2, "audio decode newFormat = " + mediaCodecCreateDecoderByType.getOutputFormat(), new Object[0]);
                            } else if (iDequeueOutputBuffer < 0) {
                                v61.h(str2, "unexpected result from audio decoder.dequeueOutputBuffer: " + iDequeueOutputBuffer, new Object[0]);
                            } else {
                                if (bufferInfo.flags == 4) {
                                    z3 = true;
                                } else {
                                    ByteBuffer outputBuffer2 = mediaCodecCreateDecoderByType.getOutputBuffer(iDequeueOutputBuffer);
                                    v61.n(str2, "audio decode saveFrame " + (bufferInfo.presentationTimeUs / 1000), new Object[0]);
                                    channel.write(outputBuffer2);
                                }
                                mediaCodecCreateDecoderByType.releaseOutputBuffer(iDequeueOutputBuffer, false);
                            }
                        }
                        z2 = true;
                    }
                } catch (Throwable th) {
                    channel.close();
                    mediaExtractor.release();
                    mediaCodecCreateDecoderByType.stop();
                    mediaCodecCreateDecoderByType.release();
                    throw th;
                }
            }
            str2 = "VideoProcessor";
            while (!z3) {
                iDequeueOutputBuffer = mediaCodecCreateDecoderByType.dequeueOutputBuffer(bufferInfo, b.C0923b.f);
                if (iDequeueOutputBuffer == -1) {
                    break;
                    break;
                }
                if (iDequeueOutputBuffer == -2) {
                    v61.n(str2, "audio decode newFormat = " + mediaCodecCreateDecoderByType.getOutputFormat(), new Object[0]);
                } else if (iDequeueOutputBuffer < 0) {
                    v61.h(str2, "unexpected result from audio decoder.dequeueOutputBuffer: " + iDequeueOutputBuffer, new Object[0]);
                } else {
                    if (bufferInfo.flags == 4) {
                        z3 = true;
                    } else {
                        ByteBuffer outputBuffer3 = mediaCodecCreateDecoderByType.getOutputBuffer(iDequeueOutputBuffer);
                        v61.n(str2, "audio decode saveFrame " + (bufferInfo.presentationTimeUs / 1000), new Object[0]);
                        channel.write(outputBuffer3);
                    }
                    mediaCodecCreateDecoderByType.releaseOutputBuffer(iDequeueOutputBuffer, false);
                }
            }
            z2 = true;
        }
        channel.close();
        mediaExtractor.release();
        mediaCodecCreateDecoderByType.stop();
        mediaCodecCreateDecoderByType.release();
    }

    /* JADX WARN: Code duplicated, block: B:19:0x0120  */
    /* JADX WARN: Code duplicated, block: B:21:0x0123 A[Catch: all -> 0x0235, TryCatch #1 {all -> 0x0235, blocks: (B:5:0x0083, B:9:0x008f, B:11:0x0097, B:16:0x0118, B:21:0x0123, B:23:0x0140, B:25:0x015d, B:29:0x016f, B:33:0x01a3, B:12:0x00bd), top: B:71:0x0083 }] */
    /* JADX WARN: Code duplicated, block: B:22:0x013e A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:23:0x0140 A[Catch: all -> 0x0235, TryCatch #1 {all -> 0x0235, blocks: (B:5:0x0083, B:9:0x008f, B:11:0x0097, B:16:0x0118, B:21:0x0123, B:23:0x0140, B:25:0x015d, B:29:0x016f, B:33:0x01a3, B:12:0x00bd), top: B:71:0x0083 }] */
    /* JADX WARN: Code duplicated, block: B:25:0x015d A[Catch: all -> 0x0235, TryCatch #1 {all -> 0x0235, blocks: (B:5:0x0083, B:9:0x008f, B:11:0x0097, B:16:0x0118, B:21:0x0123, B:23:0x0140, B:25:0x015d, B:29:0x016f, B:33:0x01a3, B:12:0x00bd), top: B:71:0x0083 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x016f A[Catch: all -> 0x0235, TryCatch #1 {all -> 0x0235, blocks: (B:5:0x0083, B:9:0x008f, B:11:0x0097, B:16:0x0118, B:21:0x0123, B:23:0x0140, B:25:0x015d, B:29:0x016f, B:33:0x01a3, B:12:0x00bd), top: B:71:0x0083 }] */
    /* JADX WARN: Code duplicated, block: B:40:0x01d5 A[Catch: all -> 0x0231, TryCatch #0 {all -> 0x0231, blocks: (B:36:0x01ad, B:40:0x01d5, B:41:0x01f2, B:43:0x01f7, B:44:0x01f9, B:46:0x01fe, B:52:0x0214, B:54:0x021e), top: B:69:0x01ad }] */
    /* JADX WARN: Code duplicated, block: B:43:0x01f7 A[Catch: all -> 0x0231, TryCatch #0 {all -> 0x0231, blocks: (B:36:0x01ad, B:40:0x01d5, B:41:0x01f2, B:43:0x01f7, B:44:0x01f9, B:46:0x01fe, B:52:0x0214, B:54:0x021e), top: B:69:0x01ad }] */
    /* JADX WARN: Code duplicated, block: B:46:0x01fe A[Catch: all -> 0x0231, TryCatch #0 {all -> 0x0231, blocks: (B:36:0x01ad, B:40:0x01d5, B:41:0x01f2, B:43:0x01f7, B:44:0x01f9, B:46:0x01fe, B:52:0x0214, B:54:0x021e), top: B:69:0x01ad }] */
    /* JADX WARN: Code duplicated, block: B:48:0x020c  */
    /* JADX WARN: Code duplicated, block: B:51:0x0213  */
    /* JADX WARN: Code duplicated, block: B:53:0x021c  */
    /* JADX WARN: Code duplicated, block: B:79:0x011f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:80:0x0162 A[SYNTHETIC] */
    /* JADX WARN: Instruction removed from duplicated block: B:21:0x0123, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:23:0x0140, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:29:0x016f, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:40:0x01d5, please report this as an issue */
    public static void i(String str, String str2, MediaFormat mediaFormat, @Nullable VideoProgressListener videoProgressListener) throws Throwable {
        MediaCodec mediaCodec;
        int i;
        ByteBuffer byteBuffer;
        long j;
        int iDequeueOutputBuffer;
        MediaCodec mediaCodec2;
        int i2;
        long j2;
        int i3;
        float f;
        int integer = mediaFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE);
        int integer2 = mediaFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT);
        int iJ = j(mediaFormat);
        int iK = k(mediaFormat);
        MediaCodec mediaCodecCreateEncoderByType = MediaCodec.createEncoderByType("audio/mp4a-latm");
        MediaFormat mediaFormatCreateAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", integer, integer2);
        mediaFormatCreateAudioFormat.setInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_BIT_RATE, iJ);
        mediaFormatCreateAudioFormat.setInteger("aac-profile", 2);
        mediaFormatCreateAudioFormat.setInteger("max-input-size", iK);
        mediaCodecCreateEncoderByType.configure(mediaFormatCreateAudioFormat, (Surface) null, (MediaCrypto) null, 1);
        mediaCodecCreateEncoderByType.start();
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(str);
        int iM = np9.m(mediaExtractor, true);
        mediaExtractor.selectTrack(iM);
        MediaFormat trackFormat = mediaExtractor.getTrackFormat(iM);
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(k(trackFormat));
        long j3 = trackFormat.getLong("durationUs");
        int i4 = 1024000000 / integer;
        int i5 = 0;
        MediaMuxer mediaMuxer = new MediaMuxer(str2, 0);
        int iAddTrack = mediaMuxer.addTrack(mediaFormat);
        mediaMuxer.start();
        boolean z = false;
        boolean z2 = false;
        int i6 = 0;
        long j4 = -1;
        while (!z) {
            try {
                int iDequeueInputBuffer = mediaCodecCreateEncoderByType.dequeueInputBuffer(b.C0923b.f);
                if (z2 || iDequeueInputBuffer < 0) {
                    i = i5;
                    byteBuffer = byteBufferAllocateDirect;
                } else {
                    long sampleTime = mediaExtractor.getSampleTime();
                    if (sampleTime < 0) {
                        i = i5;
                        j3 = j3;
                        mediaCodecCreateEncoderByType.queueInputBuffer(iDequeueInputBuffer, 0, 0, 0L, 4);
                        byteBuffer = byteBufferAllocateDirect;
                        j = b.C0923b.f;
                        z2 = true;
                    } else {
                        i = i5;
                        ByteBuffer byteBuffer2 = byteBufferAllocateDirect;
                        int sampleFlags = mediaExtractor.getSampleFlags();
                        byteBuffer2.clear();
                        int sampleData = mediaExtractor.readSampleData(byteBuffer2, i);
                        ByteBuffer inputBuffer = mediaCodecCreateEncoderByType.getInputBuffer(iDequeueInputBuffer);
                        inputBuffer.clear();
                        inputBuffer.put(byteBuffer2);
                        inputBuffer.position(i);
                        v61.k("audio queuePcmBuffer " + (sampleTime / 1000) + " size:" + sampleData, new Object[i]);
                        byteBuffer = byteBuffer2;
                        mediaCodecCreateEncoderByType.queueInputBuffer(iDequeueInputBuffer, 0, sampleData, sampleTime, sampleFlags);
                        mediaExtractor.advance();
                    }
                    while (true) {
                        iDequeueOutputBuffer = mediaCodecCreateEncoderByType.dequeueOutputBuffer(bufferInfo, j);
                        if (iDequeueOutputBuffer != -1) {
                            break;
                        }
                        if (iDequeueOutputBuffer == -2) {
                            v61.k("audio decode newFormat = " + mediaCodecCreateEncoderByType.getOutputFormat(), new Object[i]);
                        } else {
                            if (iDequeueOutputBuffer < 0) {
                                v61.f("unexpected result from audio decoder.dequeueOutputBuffer: " + iDequeueOutputBuffer, new Object[i]);
                            } else {
                                if (bufferInfo.flags == 4) {
                                    z = true;
                                    break;
                                }
                                ByteBuffer outputBuffer = mediaCodecCreateEncoderByType.getOutputBuffer(iDequeueOutputBuffer);
                                v61.k("audio writeSampleData " + bufferInfo.presentationTimeUs + " size:" + bufferInfo.size + " flags:" + bufferInfo.flags, new Object[i]);
                                try {
                                    if (i6 == 0 || j4 == -1) {
                                        mediaCodec2 = mediaCodecCreateEncoderByType;
                                    } else {
                                        mediaCodec2 = mediaCodecCreateEncoderByType;
                                        if (bufferInfo.presentationTimeUs < ((long) i4) + j4) {
                                            try {
                                                v61.f("audio 时间戳错误，lastAudioFrameTimeUs:" + j4 + " info.presentationTimeUs:" + bufferInfo.presentationTimeUs, new Object[i]);
                                                i2 = 1;
                                            } catch (Throwable th) {
                                                th = th;
                                                mediaCodec = mediaCodec2;
                                                mediaExtractor.release();
                                                mediaCodec.release();
                                                mediaMuxer.release();
                                                throw th;
                                            }
                                        }
                                        if (i2 != 0) {
                                            bufferInfo.presentationTimeUs = ((long) i4) + j4;
                                            v61.f("audio 时间戳错误，使用修正的时间戳:" + bufferInfo.presentationTimeUs, new Object[i]);
                                            i2 = i;
                                        }
                                        if (bufferInfo.flags != 2) {
                                            j4 = bufferInfo.presentationTimeUs;
                                        }
                                        mediaMuxer.writeSampleData(iAddTrack, outputBuffer, bufferInfo);
                                        if (videoProgressListener != null) {
                                            j2 = j3;
                                            f = (bufferInfo.presentationTimeUs - 0) / j2;
                                            if (f < 0.0f) {
                                                f = 0.0f;
                                            }
                                            if (f > 1.0f) {
                                                f = 1.0f;
                                            }
                                            videoProgressListener.onProgress((f * 0.5f) + 0.5f);
                                        } else {
                                            j2 = j3;
                                        }
                                        outputBuffer.clear();
                                        mediaCodec = mediaCodec2;
                                        i3 = 0;
                                        mediaCodec.releaseOutputBuffer(iDequeueOutputBuffer, false);
                                        i6 = i2;
                                    }
                                    mediaCodec.releaseOutputBuffer(iDequeueOutputBuffer, false);
                                    i6 = i2;
                                } catch (Throwable th2) {
                                    th = th2;
                                    mediaExtractor.release();
                                    mediaCodec.release();
                                    mediaMuxer.release();
                                    throw th;
                                }
                                i2 = i6;
                                if (i2 != 0) {
                                    bufferInfo.presentationTimeUs = ((long) i4) + j4;
                                    v61.f("audio 时间戳错误，使用修正的时间戳:" + bufferInfo.presentationTimeUs, new Object[i]);
                                    i2 = i;
                                }
                                if (bufferInfo.flags != 2) {
                                    j4 = bufferInfo.presentationTimeUs;
                                }
                                mediaMuxer.writeSampleData(iAddTrack, outputBuffer, bufferInfo);
                                if (videoProgressListener != null) {
                                    j2 = j3;
                                    f = (bufferInfo.presentationTimeUs - 0) / j2;
                                    if (f < 0.0f) {
                                        f = 0.0f;
                                    }
                                    if (f > 1.0f) {
                                        f = 1.0f;
                                    }
                                    videoProgressListener.onProgress((f * 0.5f) + 0.5f);
                                } else {
                                    j2 = j3;
                                }
                                outputBuffer.clear();
                                mediaCodec = mediaCodec2;
                                i3 = 0;
                            }
                            j3 = j2;
                            mediaCodecCreateEncoderByType = mediaCodec;
                            i = i3;
                            j = b.C0923b.f;
                        }
                        i3 = i;
                        mediaCodec = mediaCodecCreateEncoderByType;
                        j2 = j3;
                        j3 = j2;
                        mediaCodecCreateEncoderByType = mediaCodec;
                        i = i3;
                        j = b.C0923b.f;
                    }
                    i5 = i;
                    j4 = j4;
                    byteBufferAllocateDirect = byteBuffer;
                    j3 = j3;
                }
                j = b.C0923b.f;
                while (true) {
                    iDequeueOutputBuffer = mediaCodecCreateEncoderByType.dequeueOutputBuffer(bufferInfo, j);
                    if (iDequeueOutputBuffer != -1) {
                        break;
                        break;
                    }
                    if (iDequeueOutputBuffer == -2) {
                        v61.k("audio decode newFormat = " + mediaCodecCreateEncoderByType.getOutputFormat(), new Object[i]);
                    } else {
                        if (iDequeueOutputBuffer < 0) {
                            v61.f("unexpected result from audio decoder.dequeueOutputBuffer: " + iDequeueOutputBuffer, new Object[i]);
                        } else {
                            if (bufferInfo.flags == 4) {
                                z = true;
                                break;
                                break;
                            }
                            ByteBuffer outputBuffer2 = mediaCodecCreateEncoderByType.getOutputBuffer(iDequeueOutputBuffer);
                            v61.k("audio writeSampleData " + bufferInfo.presentationTimeUs + " size:" + bufferInfo.size + " flags:" + bufferInfo.flags, new Object[i]);
                            if (i6 == 0) {
                            }
                            mediaCodec2 = mediaCodecCreateEncoderByType;
                            i2 = i6;
                            if (i2 != 0) {
                                bufferInfo.presentationTimeUs = ((long) i4) + j4;
                                v61.f("audio 时间戳错误，使用修正的时间戳:" + bufferInfo.presentationTimeUs, new Object[i]);
                                i2 = i;
                            }
                            if (bufferInfo.flags != 2) {
                                j4 = bufferInfo.presentationTimeUs;
                            }
                            mediaMuxer.writeSampleData(iAddTrack, outputBuffer2, bufferInfo);
                            if (videoProgressListener != null) {
                                j2 = j3;
                                f = (bufferInfo.presentationTimeUs - 0) / j2;
                                if (f < 0.0f) {
                                    f = 0.0f;
                                }
                                if (f > 1.0f) {
                                    f = 1.0f;
                                }
                                videoProgressListener.onProgress((f * 0.5f) + 0.5f);
                            } else {
                                j2 = j3;
                            }
                            outputBuffer2.clear();
                            mediaCodec = mediaCodec2;
                            i3 = 0;
                            mediaCodec.releaseOutputBuffer(iDequeueOutputBuffer, false);
                            i6 = i2;
                        }
                        j3 = j2;
                        mediaCodecCreateEncoderByType = mediaCodec;
                        i = i3;
                        j = b.C0923b.f;
                    }
                    i3 = i;
                    mediaCodec = mediaCodecCreateEncoderByType;
                    j2 = j3;
                    j3 = j2;
                    mediaCodecCreateEncoderByType = mediaCodec;
                    i = i3;
                    j = b.C0923b.f;
                }
                i5 = i;
                j4 = j4;
                byteBufferAllocateDirect = byteBuffer;
                j3 = j3;
            } catch (Throwable th3) {
                th = th3;
                mediaCodec = mediaCodecCreateEncoderByType;
            }
        }
        mediaExtractor.release();
        mediaCodecCreateEncoderByType.release();
        mediaMuxer.release();
    }

    public static int j(MediaFormat mediaFormat) {
        if (mediaFormat.containsKey(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_BIT_RATE)) {
            return mediaFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_BIT_RATE);
        }
        return 192000;
    }

    public static int k(MediaFormat mediaFormat) {
        if (mediaFormat.containsKey("max-input-size")) {
            return mediaFormat.getInteger("max-input-size");
        }
        return 100000;
    }

    public static boolean l(String str) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(str);
        int trackCount = mediaExtractor.getTrackCount();
        MediaFormat trackFormat = null;
        for (int i = 0; i < trackCount; i++) {
            trackFormat = mediaExtractor.getTrackFormat(i);
            if (trackFormat.getString("mime").startsWith("audio/")) {
                break;
            }
        }
        mediaExtractor.release();
        return trackFormat != null && trackFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT) > 1;
    }

    public static void m(String str, String str2, String str3, int i, int i2) throws IOException {
        float fN = n(i);
        float fN2 = n(i2);
        int i3 = 2048;
        byte[] bArr = new byte[2048];
        byte[] bArr2 = new byte[2048];
        byte[] bArr3 = new byte[2048];
        FileInputStream fileInputStream = new FileInputStream(str);
        FileInputStream fileInputStream2 = new FileInputStream(str2);
        FileOutputStream fileOutputStream = new FileOutputStream(str3);
        boolean z = false;
        boolean z2 = false;
        while (true) {
            if (z && z2) {
                fileInputStream.close();
                fileInputStream2.close();
                fileOutputStream.close();
                return;
            }
            if (!z) {
                try {
                    z = fileInputStream.read(bArr) == -1;
                    System.arraycopy(bArr, 0, bArr3, 0, i3);
                } catch (Throwable th) {
                    fileInputStream.close();
                    fileInputStream2.close();
                    fileOutputStream.close();
                    throw th;
                }
            }
            if (!z2) {
                z2 = fileInputStream2.read(bArr2) == -1;
                int i4 = 0;
                while (i4 < i3) {
                    int i5 = i4 + 1;
                    int i6 = (int) ((((short) (((bArr2[i5] & 255) << 8) | (bArr2[i4] & 255))) * fN2) + (((short) ((bArr[i4] & 255) | ((bArr[i5] & 255) << 8))) * fN));
                    int i7 = 32767;
                    if (i6 > 32767) {
                        i6 = i7;
                    } else {
                        i7 = -32768;
                        if (i6 < -32768) {
                            i6 = i7;
                        }
                    }
                    bArr3[i4] = (byte) (i6 & 255);
                    bArr3[i5] = (byte) ((i6 >>> 8) & 255);
                    i4 += 2;
                    i3 = 2048;
                }
            }
            fileOutputStream.write(bArr3);
            i3 = 2048;
        }
    }

    public static float n(int i) {
        return (i / 100.0f) * f41896a;
    }

    public static boolean o(String str, String str2, int i, int i2, int i3) {
        try {
            new du7(new FileInputStream(str), new FileOutputStream(str2), i, i2, 2, 2, i3, (int) new File(str).length(), AudioStats.AUDIO_AMPLITUDE_NONE, 0, true);
            return true;
        } catch (IOException e) {
            v61.g(e);
            e.printStackTrace();
            return true;
        }
    }

    public static void p(String str, String str2) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(str);
        try {
            int iM = np9.m(mediaExtractor, false);
            mediaExtractor.selectTrack(iM);
            MediaFormat trackFormat = mediaExtractor.getTrackFormat(iM);
            MediaMuxer mediaMuxer = new MediaMuxer(str2, 0);
            int iAddTrack = mediaMuxer.addTrack(trackFormat);
            mediaMuxer.start();
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(trackFormat.getInteger("max-input-size"));
            while (true) {
                long sampleTime = mediaExtractor.getSampleTime();
                if (sampleTime == -1) {
                    mediaMuxer.stop();
                    mediaMuxer.release();
                    return;
                }
                int sampleFlags = mediaExtractor.getSampleFlags();
                int sampleData = mediaExtractor.readSampleData(byteBufferAllocateDirect, 0);
                bufferInfo.presentationTimeUs = sampleTime;
                bufferInfo.flags = sampleFlags;
                bufferInfo.size = sampleData;
                mediaMuxer.writeSampleData(iAddTrack, byteBufferAllocateDirect, bufferInfo);
                mediaExtractor.advance();
            }
        } finally {
            mediaExtractor.release();
        }
    }

    public static void q(String str, String str2, String str3, boolean z) throws IOException {
        MediaExtractor mediaExtractor = new MediaExtractor();
        mediaExtractor.setDataSource(str);
        MediaExtractor mediaExtractor2 = new MediaExtractor();
        mediaExtractor2.setDataSource(str2);
        try {
            int iM = np9.m(mediaExtractor, false);
            int iM2 = np9.m(mediaExtractor2, true);
            mediaExtractor.selectTrack(iM);
            mediaExtractor2.selectTrack(iM2);
            MediaFormat trackFormat = mediaExtractor2.getTrackFormat(iM2);
            MediaFormat trackFormat2 = mediaExtractor.getTrackFormat(iM);
            MediaMuxer mediaMuxer = new MediaMuxer(str3, 0);
            int iAddTrack = mediaMuxer.addTrack(trackFormat);
            int iAddTrack2 = mediaMuxer.addTrack(trackFormat2);
            mediaMuxer.start();
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(trackFormat2.getInteger("max-input-size"));
            long j = 0;
            long j2 = 0;
            while (true) {
                long sampleTime = mediaExtractor.getSampleTime();
                if (sampleTime == -1) {
                    break;
                }
                int sampleFlags = mediaExtractor.getSampleFlags();
                int sampleData = mediaExtractor.readSampleData(byteBufferAllocateDirect, 0);
                bufferInfo.presentationTimeUs = sampleTime;
                bufferInfo.flags = sampleFlags;
                bufferInfo.size = sampleData;
                mediaMuxer.writeSampleData(iAddTrack2, byteBufferAllocateDirect, bufferInfo);
                mediaExtractor.advance();
                j2 = sampleTime;
                j = 0;
            }
            int integer = 1024000000 / trackFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE);
            ByteBuffer byteBufferAllocateDirect2 = ByteBuffer.allocateDirect(k(trackFormat));
            long j3 = j;
            long j4 = j3;
            while (j3 < j2) {
                mediaExtractor2.seekTo(j, 2);
                while (true) {
                    long sampleTime2 = mediaExtractor2.getSampleTime();
                    if (sampleTime2 == -1) {
                        break;
                    }
                    j3 = sampleTime2 + j4;
                    if (j3 > j2) {
                        break;
                    }
                    int sampleFlags2 = mediaExtractor2.getSampleFlags();
                    int sampleData2 = mediaExtractor2.readSampleData(byteBufferAllocateDirect2, 0);
                    bufferInfo.presentationTimeUs = j3;
                    bufferInfo.flags = sampleFlags2;
                    bufferInfo.size = sampleData2;
                    mediaMuxer.writeSampleData(iAddTrack, byteBufferAllocateDirect2, bufferInfo);
                    mediaExtractor2.advance();
                }
                j4 = j3 + ((long) integer);
                if (!z) {
                    break;
                } else {
                    j = 0;
                }
            }
            mediaMuxer.stop();
            mediaMuxer.release();
        } finally {
            mediaExtractor.release();
            mediaExtractor2.release();
        }
    }

    public static void r(String str, String str2) throws Throwable {
        FileOutputStream fileOutputStream;
        RandomAccessFile randomAccessFile = null;
        try {
            RandomAccessFile randomAccessFile2 = new RandomAccessFile(str, "r");
            try {
                fileOutputStream = new FileOutputStream(str2);
                try {
                    long j = 2;
                    byte[] bArr = new byte[2];
                    for (long length = randomAccessFile2.length() - j; length >= 0; length -= j) {
                        randomAccessFile2.seek(length);
                        randomAccessFile2.read(bArr);
                        fileOutputStream.write(bArr);
                    }
                    randomAccessFile2.close();
                    fileOutputStream.close();
                } catch (Throwable th) {
                    th = th;
                    randomAccessFile = randomAccessFile2;
                    if (randomAccessFile != null) {
                        randomAccessFile.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                fileOutputStream = null;
            }
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
        }
    }

    public static void s(String str, String str2) throws IOException {
        t(str, str2, 2);
    }

    public static void t(String str, String str2, int i) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(str);
        FileOutputStream fileOutputStream = new FileOutputStream(str2);
        byte[] bArr = new byte[i * 1024];
        byte[] bArr2 = new byte[1024];
        while (fileInputStream.read(bArr) != -1) {
            for (int i2 = 0; i2 < 1024; i2 += 2) {
                int i3 = i * i2;
                bArr2[i2] = bArr[i3];
                bArr2[i2 + 1] = bArr[i3 + 1];
            }
            fileOutputStream.write(bArr2);
        }
        fileInputStream.close();
        fileOutputStream.close();
    }

    public static long u(MediaExtractor mediaExtractor, MediaMuxer mediaMuxer, int i, Integer num, Integer num2, long j, VideoProgressListener videoProgressListener) throws IOException {
        int iM = np9.m(mediaExtractor, true);
        mediaExtractor.selectTrack(iM);
        Integer num3 = num == null ? 0 : num;
        mediaExtractor.seekTo(num3.intValue(), 2);
        MediaFormat trackFormat = mediaExtractor.getTrackFormat(iM);
        long j2 = trackFormat.getLong("durationUs");
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(trackFormat.getInteger("max-input-size"));
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        long j3 = j;
        while (true) {
            long sampleTime = mediaExtractor.getSampleTime();
            if (sampleTime == -1) {
                break;
            }
            if (sampleTime >= num3.intValue()) {
                if (num2 != null && sampleTime > num2.intValue()) {
                    break;
                }
                if (videoProgressListener != null) {
                    float fIntValue = (sampleTime - ((long) num3.intValue())) / (num2 == null ? j2 : num2.intValue() - num3.intValue());
                    if (fIntValue < 0.0f) {
                        fIntValue = 0.0f;
                    }
                    if (fIntValue > 1.0f) {
                        fIntValue = 1.0f;
                    }
                    videoProgressListener.onProgress(fIntValue);
                }
                bufferInfo.presentationTimeUs = (sampleTime - ((long) num3.intValue())) + j;
                bufferInfo.flags = mediaExtractor.getSampleFlags();
                int sampleData = mediaExtractor.readSampleData(byteBufferAllocateDirect, 0);
                bufferInfo.size = sampleData;
                if (sampleData < 0) {
                    break;
                }
                v61.k("writeAudioSampleData,time:" + (bufferInfo.presentationTimeUs / 1000.0f), new Object[0]);
                mediaMuxer.writeSampleData(i, byteBufferAllocateDirect, bufferInfo);
                long j4 = bufferInfo.presentationTimeUs;
                mediaExtractor.advance();
                j3 = j4;
            } else {
                mediaExtractor.advance();
            }
        }
        return j3;
    }

    public static long v(MediaExtractor mediaExtractor, MediaMuxer mediaMuxer, int i, Integer num, Integer num2, VideoProgressListener videoProgressListener) throws IOException {
        return u(mediaExtractor, mediaMuxer, i, num, num2, 0L, videoProgressListener);
    }

    /* JADX WARN: Code duplicated, block: B:102:0x042b  */
    /* JADX WARN: Code duplicated, block: B:105:0x0434 A[Catch: all -> 0x04b2, TryCatch #0 {all -> 0x04b2, blocks: (B:101:0x0408, B:105:0x0434, B:106:0x0452, B:108:0x0457, B:109:0x0459, B:111:0x0462, B:115:0x047e, B:121:0x048d, B:123:0x0499, B:114:0x0474), top: B:140:0x0408 }] */
    /* JADX WARN: Code duplicated, block: B:108:0x0457 A[Catch: all -> 0x04b2, TryCatch #0 {all -> 0x04b2, blocks: (B:101:0x0408, B:105:0x0434, B:106:0x0452, B:108:0x0457, B:109:0x0459, B:111:0x0462, B:115:0x047e, B:121:0x048d, B:123:0x0499, B:114:0x0474), top: B:140:0x0408 }] */
    /* JADX WARN: Code duplicated, block: B:111:0x0462 A[Catch: all -> 0x04b2, TryCatch #0 {all -> 0x04b2, blocks: (B:101:0x0408, B:105:0x0434, B:106:0x0452, B:108:0x0457, B:109:0x0459, B:111:0x0462, B:115:0x047e, B:121:0x048d, B:123:0x0499, B:114:0x0474), top: B:140:0x0408 }] */
    /* JADX WARN: Code duplicated, block: B:113:0x0471  */
    /* JADX WARN: Code duplicated, block: B:114:0x0474 A[Catch: all -> 0x04b2, TryCatch #0 {all -> 0x04b2, blocks: (B:101:0x0408, B:105:0x0434, B:106:0x0452, B:108:0x0457, B:109:0x0459, B:111:0x0462, B:115:0x047e, B:121:0x048d, B:123:0x0499, B:114:0x0474), top: B:140:0x0408 }] */
    /* JADX WARN: Code duplicated, block: B:117:0x0485  */
    /* JADX WARN: Code duplicated, block: B:120:0x048c  */
    /* JADX WARN: Code duplicated, block: B:122:0x0495  */
    /* JADX WARN: Code duplicated, block: B:153:0x0130 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:154:0x014f A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:156:0x0135 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:157:0x0167 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:158:0x0151 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:167:0x0360 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:168:0x03b1 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:25:0x00ba A[Catch: all -> 0x011b, TryCatch #4 {all -> 0x011b, blocks: (B:10:0x0085, B:12:0x008b, B:25:0x00ba, B:31:0x0127, B:36:0x0135, B:38:0x0151, B:39:0x0167, B:50:0x01b4, B:42:0x0170, B:44:0x0194, B:48:0x01ac, B:47:0x01a2, B:26:0x00cf, B:16:0x0099, B:18:0x00a6, B:20:0x00ad), top: B:148:0x0085 }] */
    /* JADX WARN: Code duplicated, block: B:26:0x00cf A[Catch: all -> 0x011b, TryCatch #4 {all -> 0x011b, blocks: (B:10:0x0085, B:12:0x008b, B:25:0x00ba, B:31:0x0127, B:36:0x0135, B:38:0x0151, B:39:0x0167, B:50:0x01b4, B:42:0x0170, B:44:0x0194, B:48:0x01ac, B:47:0x01a2, B:26:0x00cf, B:16:0x0099, B:18:0x00a6, B:20:0x00ad), top: B:148:0x0085 }] */
    /* JADX WARN: Code duplicated, block: B:29:0x011e  */
    /* JADX WARN: Code duplicated, block: B:31:0x0127 A[Catch: all -> 0x011b, TryCatch #4 {all -> 0x011b, blocks: (B:10:0x0085, B:12:0x008b, B:25:0x00ba, B:31:0x0127, B:36:0x0135, B:38:0x0151, B:39:0x0167, B:50:0x01b4, B:42:0x0170, B:44:0x0194, B:48:0x01ac, B:47:0x01a2, B:26:0x00cf, B:16:0x0099, B:18:0x00a6, B:20:0x00ad), top: B:148:0x0085 }] */
    /* JADX WARN: Code duplicated, block: B:34:0x0132  */
    /* JADX WARN: Code duplicated, block: B:41:0x016c  */
    /* JADX WARN: Code duplicated, block: B:42:0x0170 A[Catch: all -> 0x011b, TryCatch #4 {all -> 0x011b, blocks: (B:10:0x0085, B:12:0x008b, B:25:0x00ba, B:31:0x0127, B:36:0x0135, B:38:0x0151, B:39:0x0167, B:50:0x01b4, B:42:0x0170, B:44:0x0194, B:48:0x01ac, B:47:0x01a2, B:26:0x00cf, B:16:0x0099, B:18:0x00a6, B:20:0x00ad), top: B:148:0x0085 }] */
    /* JADX WARN: Code duplicated, block: B:44:0x0194 A[Catch: all -> 0x011b, TryCatch #4 {all -> 0x011b, blocks: (B:10:0x0085, B:12:0x008b, B:25:0x00ba, B:31:0x0127, B:36:0x0135, B:38:0x0151, B:39:0x0167, B:50:0x01b4, B:42:0x0170, B:44:0x0194, B:48:0x01ac, B:47:0x01a2, B:26:0x00cf, B:16:0x0099, B:18:0x00a6, B:20:0x00ad), top: B:148:0x0085 }] */
    /* JADX WARN: Code duplicated, block: B:46:0x019f  */
    /* JADX WARN: Code duplicated, block: B:47:0x01a2 A[Catch: all -> 0x011b, TryCatch #4 {all -> 0x011b, blocks: (B:10:0x0085, B:12:0x008b, B:25:0x00ba, B:31:0x0127, B:36:0x0135, B:38:0x0151, B:39:0x0167, B:50:0x01b4, B:42:0x0170, B:44:0x0194, B:48:0x01ac, B:47:0x01a2, B:26:0x00cf, B:16:0x0099, B:18:0x00a6, B:20:0x00ad), top: B:148:0x0085 }] */
    /* JADX WARN: Code duplicated, block: B:82:0x0364  */
    /* JADX WARN: Code duplicated, block: B:84:0x0367 A[Catch: all -> 0x04b6, TryCatch #2 {all -> 0x04b6, blocks: (B:79:0x0357, B:84:0x0367, B:86:0x0383, B:88:0x03ac, B:92:0x03c0, B:76:0x0324), top: B:144:0x0357 }] */
    /* JADX WARN: Code duplicated, block: B:85:0x0381 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:86:0x0383 A[Catch: all -> 0x04b6, TryCatch #2 {all -> 0x04b6, blocks: (B:79:0x0357, B:84:0x0367, B:86:0x0383, B:88:0x03ac, B:92:0x03c0, B:76:0x0324), top: B:144:0x0357 }] */
    /* JADX WARN: Code duplicated, block: B:88:0x03ac A[Catch: all -> 0x04b6, TryCatch #2 {all -> 0x04b6, blocks: (B:79:0x0357, B:84:0x0367, B:86:0x0383, B:88:0x03ac, B:92:0x03c0, B:76:0x0324), top: B:144:0x0357 }] */
    /* JADX WARN: Code duplicated, block: B:92:0x03c0 A[Catch: all -> 0x04b6, TRY_LEAVE, TryCatch #2 {all -> 0x04b6, blocks: (B:79:0x0357, B:84:0x0367, B:86:0x0383, B:88:0x03ac, B:92:0x03c0, B:76:0x0324), top: B:144:0x0357 }] */
    /* JADX WARN: Instruction removed from duplicated block: B:105:0x0434, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:26:0x00cf, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:42:0x0170, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:84:0x0367, please report this as an issue */
    /* JADX WARN: Instruction removed from duplicated block: B:86:0x0383, please report this as an issue */
    public static void w(Context context, MediaExtractor mediaExtractor, MediaMuxer mediaMuxer, int i, Integer num, Integer num2, @NotNull Float f, @Nullable VideoProgressListener videoProgressListener) throws Exception {
        MediaFormat mediaFormat;
        File file;
        MediaExtractor mediaExtractor2;
        boolean z;
        int iDequeueOutputBuffer;
        int i2;
        String str;
        boolean z2;
        long jIntValue;
        float f2;
        boolean z3;
        boolean z4;
        boolean z5;
        String str2;
        int iDequeueOutputBuffer2;
        boolean z6;
        long jIntValue2;
        MediaExtractor mediaExtractor3 = mediaExtractor;
        int iM = np9.m(mediaExtractor3, true);
        mediaExtractor3.selectTrack(iM);
        Integer num3 = num == null ? 0 : num;
        mediaExtractor3.seekTo(num3.intValue(), 2);
        MediaFormat trackFormat = mediaExtractor3.getTrackFormat(iM);
        long j = trackFormat.getLong("durationUs");
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(k(trackFormat));
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        MediaCodec mediaCodecCreateDecoderByType = MediaCodec.createDecoderByType(trackFormat.getString("mime"));
        mediaCodecCreateDecoderByType.configure(trackFormat, (Surface) null, (MediaCrypto) null, 0);
        mediaCodecCreateDecoderByType.start();
        File file2 = new File(context.getCacheDir(), System.currentTimeMillis() + ".pcm");
        FileChannel channel = new FileOutputStream(file2).getChannel();
        boolean z7 = false;
        boolean z8 = false;
        while (true) {
            mediaFormat = trackFormat;
            if (z7) {
                break;
            }
            if (z8) {
                z3 = z7;
                z4 = z8;
                str2 = "audio decode newFormat = ";
                while (!z3) {
                    iDequeueOutputBuffer2 = mediaCodecCreateDecoderByType.dequeueOutputBuffer(bufferInfo, b.C0923b.f);
                    if (iDequeueOutputBuffer2 == -1) {
                        break;
                        break;
                    }
                    if (iDequeueOutputBuffer2 == -2) {
                        v61.k(str2 + mediaCodecCreateDecoderByType.getOutputFormat(), new Object[0]);
                    } else if (iDequeueOutputBuffer2 < 0) {
                        v61.f("unexpected result from audio decoder.dequeueOutputBuffer: " + iDequeueOutputBuffer2, new Object[0]);
                    } else {
                        if (bufferInfo.flags == 4) {
                            z6 = false;
                            z3 = true;
                        } else {
                            ByteBuffer outputBuffer = mediaCodecCreateDecoderByType.getOutputBuffer(iDequeueOutputBuffer2);
                            v61.k("audio decode saveFrame " + (bufferInfo.presentationTimeUs / 1000), new Object[0]);
                            channel.write(outputBuffer);
                            if (videoProgressListener != null) {
                                float fIntValue = bufferInfo.presentationTimeUs - ((long) num3.intValue());
                                if (num2 == null) {
                                    jIntValue2 = j;
                                } else {
                                    jIntValue2 = num2.intValue() - num3.intValue();
                                }
                                videoProgressListener.onProgress((fIntValue / jIntValue2) * 0.5f);
                            }
                            z6 = false;
                        }
                        mediaCodecCreateDecoderByType.releaseOutputBuffer(iDequeueOutputBuffer2, z6);
                    }
                }
                mediaExtractor3 = mediaExtractor;
                file2 = file2;
            } else {
                try {
                    int iDequeueInputBuffer = mediaCodecCreateDecoderByType.dequeueInputBuffer(b.C0923b.f);
                    if (iDequeueInputBuffer >= 0) {
                        long sampleTime = mediaExtractor.getSampleTime();
                        if (sampleTime == -1) {
                            z3 = z7;
                            z4 = z8;
                        } else {
                            z3 = z7;
                            z4 = z8;
                            if (sampleTime < num3.intValue()) {
                                mediaExtractor.advance();
                            } else {
                                if (num2 == null || sampleTime <= num2.intValue()) {
                                    z5 = false;
                                }
                                if (z5) {
                                    mediaCodecCreateDecoderByType.queueInputBuffer(iDequeueInputBuffer, 0, 0, 0L, 4);
                                    str2 = "audio decode newFormat = ";
                                    z4 = true;
                                } else {
                                    bufferInfo.size = mediaExtractor3.readSampleData(byteBufferAllocateDirect, 0);
                                    bufferInfo.presentationTimeUs = sampleTime;
                                    bufferInfo.flags = mediaExtractor.getSampleFlags();
                                    mediaCodecCreateDecoderByType.getInputBuffer(iDequeueInputBuffer).put(byteBufferAllocateDirect);
                                    v61.k("audio decode queueInputBuffer " + (bufferInfo.presentationTimeUs / 1000), new Object[0]);
                                    str2 = "audio decode newFormat = ";
                                    mediaCodecCreateDecoderByType.queueInputBuffer(iDequeueInputBuffer, 0, bufferInfo.size, bufferInfo.presentationTimeUs, bufferInfo.flags);
                                    mediaExtractor.advance();
                                }
                            }
                        }
                        z5 = true;
                        if (z5) {
                            mediaCodecCreateDecoderByType.queueInputBuffer(iDequeueInputBuffer, 0, 0, 0L, 4);
                            str2 = "audio decode newFormat = ";
                            z4 = true;
                        } else {
                            bufferInfo.size = mediaExtractor3.readSampleData(byteBufferAllocateDirect, 0);
                            bufferInfo.presentationTimeUs = sampleTime;
                            bufferInfo.flags = mediaExtractor.getSampleFlags();
                            mediaCodecCreateDecoderByType.getInputBuffer(iDequeueInputBuffer).put(byteBufferAllocateDirect);
                            v61.k("audio decode queueInputBuffer " + (bufferInfo.presentationTimeUs / 1000), new Object[0]);
                            str2 = "audio decode newFormat = ";
                            mediaCodecCreateDecoderByType.queueInputBuffer(iDequeueInputBuffer, 0, bufferInfo.size, bufferInfo.presentationTimeUs, bufferInfo.flags);
                            mediaExtractor.advance();
                        }
                    } else {
                        z3 = z7;
                        z4 = z8;
                        str2 = "audio decode newFormat = ";
                    }
                    while (!z3) {
                        iDequeueOutputBuffer2 = mediaCodecCreateDecoderByType.dequeueOutputBuffer(bufferInfo, b.C0923b.f);
                        if (iDequeueOutputBuffer2 == -1) {
                            break;
                        }
                        if (iDequeueOutputBuffer2 == -2) {
                            v61.k(str2 + mediaCodecCreateDecoderByType.getOutputFormat(), new Object[0]);
                        } else if (iDequeueOutputBuffer2 < 0) {
                            v61.f("unexpected result from audio decoder.dequeueOutputBuffer: " + iDequeueOutputBuffer2, new Object[0]);
                        } else {
                            if (bufferInfo.flags == 4) {
                                z6 = false;
                                z3 = true;
                            } else {
                                ByteBuffer outputBuffer2 = mediaCodecCreateDecoderByType.getOutputBuffer(iDequeueOutputBuffer2);
                                v61.k("audio decode saveFrame " + (bufferInfo.presentationTimeUs / 1000), new Object[0]);
                                channel.write(outputBuffer2);
                                if (videoProgressListener != null) {
                                    float fIntValue2 = bufferInfo.presentationTimeUs - ((long) num3.intValue());
                                    if (num2 == null) {
                                        jIntValue2 = j;
                                    } else {
                                        jIntValue2 = num2.intValue() - num3.intValue();
                                    }
                                    videoProgressListener.onProgress((fIntValue2 / jIntValue2) * 0.5f);
                                }
                                z6 = false;
                            }
                            mediaCodecCreateDecoderByType.releaseOutputBuffer(iDequeueOutputBuffer2, z6);
                        }
                    }
                    mediaExtractor3 = mediaExtractor;
                    file2 = file2;
                } catch (Throwable th) {
                    channel.close();
                    mediaExtractor.release();
                    mediaCodecCreateDecoderByType.release();
                    throw th;
                }
            }
            trackFormat = mediaFormat;
            z7 = z3;
            z8 = z4;
        }
        String str3 = "unexpected result from audio decoder.dequeueOutputBuffer: ";
        File file3 = file2;
        String str4 = "audio decode newFormat = ";
        channel.close();
        mediaExtractor.release();
        mediaCodecCreateDecoderByType.release();
        int integer = mediaFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE);
        int integer2 = mediaFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT);
        File file4 = new File(context.getCacheDir(), file3.getName() + FileTypes.B);
        new nn6(integer, integer2 == 2 ? 12 : 16, integer2, 2).a(file3.getAbsolutePath(), file4.getAbsolutePath());
        v61.k("start process pcm speed", new Object[0]);
        File file5 = new File(context.getCacheDir(), file3.getName() + ".outpcm");
        SoundTouch soundTouch = new SoundTouch();
        soundTouch.e(f.floatValue());
        if (soundTouch.b(file4.getAbsolutePath(), file5.getAbsolutePath()) < 0) {
            file3.delete();
            file4.delete();
            file5.delete();
            return;
        }
        MediaExtractor mediaExtractor4 = new MediaExtractor();
        mediaExtractor4.setDataSource(file5.getAbsolutePath());
        int iM2 = np9.m(mediaExtractor4, true);
        mediaExtractor4.selectTrack(iM2);
        MediaFormat trackFormat2 = mediaExtractor4.getTrackFormat(iM2);
        int iK = k(trackFormat2);
        long j2 = trackFormat2.getLong("durationUs");
        ByteBuffer byteBufferAllocateDirect2 = ByteBuffer.allocateDirect(iK);
        int iJ = j(mediaFormat);
        MediaFormat mediaFormatCreateAudioFormat = MediaFormat.createAudioFormat("audio/mp4a-latm", integer, mediaFormat.getInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT));
        mediaFormatCreateAudioFormat.setInteger(com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_BIT_RATE, iJ);
        mediaFormatCreateAudioFormat.setInteger("aac-profile", 2);
        mediaFormatCreateAudioFormat.setInteger("max-input-size", iK);
        MediaCodec mediaCodecCreateEncoderByType = MediaCodec.createEncoderByType("audio/mp4a-latm");
        mediaCodecCreateEncoderByType.configure(mediaFormatCreateAudioFormat, (Surface) null, (MediaCrypto) null, 1);
        mediaCodecCreateEncoderByType.start();
        int i3 = 1024000000 / integer;
        long j3 = -1;
        boolean z9 = false;
        boolean z10 = false;
        boolean z11 = false;
        while (!z9) {
            boolean z12 = z9;
            boolean z13 = z10;
            try {
                int iDequeueInputBuffer2 = mediaCodecCreateEncoderByType.dequeueInputBuffer(b.C0923b.f);
                String str5 = " size:";
                if (!z13 && iDequeueInputBuffer2 >= 0) {
                    long sampleTime2 = mediaExtractor4.getSampleTime();
                    if (sampleTime2 < 0) {
                        mediaCodecCreateEncoderByType.queueInputBuffer(iDequeueInputBuffer2, 0, 0, 0L, 4);
                        byteBufferAllocateDirect2 = byteBufferAllocateDirect2;
                        file5 = file5;
                        file4 = file4;
                        z = true;
                    } else {
                        int sampleFlags = mediaExtractor4.getSampleFlags();
                        byteBufferAllocateDirect2.clear();
                        int sampleData = mediaExtractor4.readSampleData(byteBufferAllocateDirect2, 0);
                        ByteBuffer inputBuffer = mediaCodecCreateEncoderByType.getInputBuffer(iDequeueInputBuffer2);
                        inputBuffer.clear();
                        inputBuffer.put(byteBufferAllocateDirect2);
                        inputBuffer.position(0);
                        StringBuilder sb = new StringBuilder();
                        sb.append("audio queuePcmBuffer ");
                        sb.append(sampleTime2 / 1000);
                        sb.append(" size:");
                        sb.append(sampleData);
                        v61.k(sb.toString(), new Object[0]);
                        mediaCodecCreateEncoderByType.queueInputBuffer(iDequeueInputBuffer2, 0, sampleData, sampleTime2, sampleFlags);
                        mediaExtractor4.advance();
                    }
                    while (true) {
                        try {
                            iDequeueOutputBuffer = mediaCodecCreateEncoderByType.dequeueOutputBuffer(bufferInfo, b.C0923b.f);
                            if (iDequeueOutputBuffer == -1) {
                                z9 = z12;
                                break;
                            }
                            if (iDequeueOutputBuffer == -2) {
                                v61.k(str4 + mediaCodecCreateEncoderByType.getOutputFormat(), new Object[0]);
                            } else {
                                if (iDequeueOutputBuffer < 0) {
                                    v61.f(str3 + iDequeueOutputBuffer, new Object[0]);
                                } else {
                                    if (bufferInfo.flags == 4) {
                                        z9 = true;
                                        break;
                                    }
                                    ByteBuffer outputBuffer3 = mediaCodecCreateEncoderByType.getOutputBuffer(iDequeueOutputBuffer);
                                    StringBuilder sb2 = new StringBuilder();
                                    sb2.append("audio writeSampleData ");
                                    file = file3;
                                    try {
                                        sb2.append(bufferInfo.presentationTimeUs);
                                        sb2.append(str5);
                                        sb2.append(bufferInfo.size);
                                        sb2.append(" flags:");
                                        sb2.append(bufferInfo.flags);
                                        v61.k(sb2.toString(), new Object[0]);
                                        if (!z11 || j3 == -1) {
                                            i2 = i3;
                                            mediaExtractor2 = mediaExtractor4;
                                            str = str5;
                                        } else {
                                            i2 = i3;
                                            mediaExtractor2 = mediaExtractor4;
                                            str = str5;
                                            if (bufferInfo.presentationTimeUs < ((long) i2) + j3) {
                                                try {
                                                    v61.f("audio 时间戳错误，lastAudioFrameTimeUs:" + j3 + " info.presentationTimeUs:" + bufferInfo.presentationTimeUs, new Object[0]);
                                                    z2 = true;
                                                } catch (Throwable th2) {
                                                    th = th2;
                                                    file.delete();
                                                    file4.delete();
                                                    file5.delete();
                                                    mediaExtractor2.release();
                                                    mediaCodecCreateEncoderByType.release();
                                                    throw th;
                                                }
                                            }
                                            if (z2) {
                                                bufferInfo.presentationTimeUs = ((long) i2) + j3;
                                                v61.f("audio 时间戳错误，使用修正的时间戳:" + bufferInfo.presentationTimeUs, new Object[0]);
                                                z2 = false;
                                            }
                                            if (bufferInfo.flags != 2) {
                                                j3 = bufferInfo.presentationTimeUs;
                                            }
                                            mediaMuxer.writeSampleData(i, outputBuffer3, bufferInfo);
                                            if (videoProgressListener != null) {
                                                float fIntValue3 = bufferInfo.presentationTimeUs - ((long) num3.intValue());
                                                if (num2 == null) {
                                                    jIntValue = j2;
                                                } else {
                                                    jIntValue = num2.intValue() - num3.intValue();
                                                }
                                                f2 = fIntValue3 / jIntValue;
                                                if (f2 < 0.0f) {
                                                    f2 = 0.0f;
                                                }
                                                if (f2 > 1.0f) {
                                                    f2 = 1.0f;
                                                }
                                                videoProgressListener.onProgress((f2 * 0.5f) + 0.5f);
                                            }
                                            outputBuffer3.clear();
                                            mediaCodecCreateEncoderByType.releaseOutputBuffer(iDequeueOutputBuffer, false);
                                            z11 = z2;
                                            j3 = j3;
                                        }
                                        z2 = z11;
                                        if (z2) {
                                            bufferInfo.presentationTimeUs = ((long) i2) + j3;
                                            v61.f("audio 时间戳错误，使用修正的时间戳:" + bufferInfo.presentationTimeUs, new Object[0]);
                                            z2 = false;
                                        }
                                        if (bufferInfo.flags != 2) {
                                            j3 = bufferInfo.presentationTimeUs;
                                        }
                                        mediaMuxer.writeSampleData(i, outputBuffer3, bufferInfo);
                                        if (videoProgressListener != null) {
                                            float fIntValue4 = bufferInfo.presentationTimeUs - ((long) num3.intValue());
                                            if (num2 == null) {
                                                jIntValue = j2;
                                            } else {
                                                jIntValue = num2.intValue() - num3.intValue();
                                            }
                                            f2 = fIntValue4 / jIntValue;
                                            if (f2 < 0.0f) {
                                                f2 = 0.0f;
                                            }
                                            if (f2 > 1.0f) {
                                                f2 = 1.0f;
                                            }
                                            videoProgressListener.onProgress((f2 * 0.5f) + 0.5f);
                                        }
                                        outputBuffer3.clear();
                                        mediaCodecCreateEncoderByType.releaseOutputBuffer(iDequeueOutputBuffer, false);
                                        z11 = z2;
                                        j3 = j3;
                                    } catch (Throwable th3) {
                                        th = th3;
                                        mediaExtractor2 = mediaExtractor4;
                                        file.delete();
                                        file4.delete();
                                        file5.delete();
                                        mediaExtractor2.release();
                                        mediaCodecCreateEncoderByType.release();
                                        throw th;
                                    }
                                }
                                mediaExtractor4 = mediaExtractor2;
                                str3 = str3;
                                i3 = i2;
                                bufferInfo = bufferInfo;
                                str4 = str4;
                                file3 = file;
                                str5 = str;
                            }
                            i2 = i3;
                            file = file3;
                            bufferInfo = bufferInfo;
                            mediaExtractor2 = mediaExtractor4;
                            str = str5;
                            mediaExtractor4 = mediaExtractor2;
                            str3 = str3;
                            i3 = i2;
                            bufferInfo = bufferInfo;
                            str4 = str4;
                            file3 = file;
                            str5 = str;
                        } catch (Throwable th4) {
                            th = th4;
                            file = file3;
                            mediaExtractor2 = mediaExtractor4;
                            file.delete();
                            file4.delete();
                            file5.delete();
                            mediaExtractor2.release();
                            mediaCodecCreateEncoderByType.release();
                            throw th;
                        }
                    }
                    i3 = i3;
                    j3 = j3;
                    file4 = file4;
                    file5 = file5;
                    z10 = z;
                    byteBufferAllocateDirect2 = byteBufferAllocateDirect2;
                }
                z11 = z11;
                z = z13;
                while (true) {
                    iDequeueOutputBuffer = mediaCodecCreateEncoderByType.dequeueOutputBuffer(bufferInfo, b.C0923b.f);
                    if (iDequeueOutputBuffer == -1) {
                        z9 = z12;
                        break;
                        break;
                    }
                    if (iDequeueOutputBuffer == -2) {
                        v61.k(str4 + mediaCodecCreateEncoderByType.getOutputFormat(), new Object[0]);
                    } else {
                        if (iDequeueOutputBuffer < 0) {
                            v61.f(str3 + iDequeueOutputBuffer, new Object[0]);
                        } else {
                            if (bufferInfo.flags == 4) {
                                z9 = true;
                                break;
                                break;
                            }
                            ByteBuffer outputBuffer4 = mediaCodecCreateEncoderByType.getOutputBuffer(iDequeueOutputBuffer);
                            StringBuilder sb3 = new StringBuilder();
                            sb3.append("audio writeSampleData ");
                            file = file3;
                            sb3.append(bufferInfo.presentationTimeUs);
                            sb3.append(str5);
                            sb3.append(bufferInfo.size);
                            sb3.append(" flags:");
                            sb3.append(bufferInfo.flags);
                            v61.k(sb3.toString(), new Object[0]);
                            if (z11) {
                                i2 = i3;
                                mediaExtractor2 = mediaExtractor4;
                                str = str5;
                                z2 = z11;
                            } else {
                                i2 = i3;
                                mediaExtractor2 = mediaExtractor4;
                                str = str5;
                                z2 = z11;
                            }
                            if (z2) {
                                bufferInfo.presentationTimeUs = ((long) i2) + j3;
                                v61.f("audio 时间戳错误，使用修正的时间戳:" + bufferInfo.presentationTimeUs, new Object[0]);
                                z2 = false;
                            }
                            if (bufferInfo.flags != 2) {
                                j3 = bufferInfo.presentationTimeUs;
                            }
                            mediaMuxer.writeSampleData(i, outputBuffer4, bufferInfo);
                            if (videoProgressListener != null) {
                                float fIntValue5 = bufferInfo.presentationTimeUs - ((long) num3.intValue());
                                if (num2 == null) {
                                    jIntValue = j2;
                                } else {
                                    jIntValue = num2.intValue() - num3.intValue();
                                }
                                f2 = fIntValue5 / jIntValue;
                                if (f2 < 0.0f) {
                                    f2 = 0.0f;
                                }
                                if (f2 > 1.0f) {
                                    f2 = 1.0f;
                                }
                                videoProgressListener.onProgress((f2 * 0.5f) + 0.5f);
                            }
                            outputBuffer4.clear();
                            mediaCodecCreateEncoderByType.releaseOutputBuffer(iDequeueOutputBuffer, false);
                            z11 = z2;
                            j3 = j3;
                        }
                        mediaExtractor4 = mediaExtractor2;
                        str3 = str3;
                        i3 = i2;
                        bufferInfo = bufferInfo;
                        str4 = str4;
                        file3 = file;
                        str5 = str;
                    }
                    i2 = i3;
                    file = file3;
                    bufferInfo = bufferInfo;
                    mediaExtractor2 = mediaExtractor4;
                    str = str5;
                    mediaExtractor4 = mediaExtractor2;
                    str3 = str3;
                    i3 = i2;
                    bufferInfo = bufferInfo;
                    str4 = str4;
                    file3 = file;
                    str5 = str;
                }
                i3 = i3;
                j3 = j3;
                file4 = file4;
                file5 = file5;
                z10 = z;
                byteBufferAllocateDirect2 = byteBufferAllocateDirect2;
            } catch (Throwable th5) {
                th = th5;
                file5 = file5;
                file4 = file4;
            }
        }
        file3.delete();
        file4.delete();
        file5.delete();
        mediaExtractor4.release();
        mediaCodecCreateEncoderByType.release();
    }
}
