package com.cicada.player.utils.media;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.text.TextUtils;
import android.view.Surface;
import com.cicada.player.utils.Logger;
import com.cicada.player.utils.NativeUsed;
import com.google.android.exoplayer2.video.a;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@NativeUsed
public class MediaCodecDecoder {
    private static int CODEC_CATEGORY_AUDIO = 1;
    private static int CODEC_CATEGORY_VIDEO = 0;
    private static final int ERROR = -1;
    private static final String TAG = "MediaCodecDecoder";
    private static final int TRY_AGAIN = -11;
    private String mMime;
    private static final Object queLock = new Object();
    static List<String> blackCodecPrefix = new ArrayList();
    static List<String> blackCodecSuffix = new ArrayList();
    private Map<String, byte[]> mCodecSpecificDataMap = new LinkedHashMap();
    private int mCodecCateGory = CODEC_CATEGORY_VIDEO;
    private MediaCodec mMediaCodec = null;
    private MediaCrypto mediaCrypto = null;
    private boolean forceInsecureDecoder = false;
    private ByteBuffer[] mInputBuffers = null;
    private ByteBuffer[] mOutputBuffers = null;
    private MediaCodec.BufferInfo mBufferInfo = null;
    private boolean started = false;

    /* JADX WARN: Code duplicated, block: B:24:0x007d  */
    private MediaCodec.CryptoInfo createCryptoInfo(EncryptionInfo encryptionInfo) {
        int i;
        MediaCodec.CryptoInfo cryptoInfo = new MediaCodec.CryptoInfo();
        cryptoInfo.key = encryptionInfo.key_id;
        cryptoInfo.iv = encryptionInfo.iv;
        List<SubsampleEncryptionInfo> list = encryptionInfo.subsamples;
        if (list != null) {
            int size = list.size();
            cryptoInfo.numSubSamples = size;
            cryptoInfo.numBytesOfClearData = new int[size];
            cryptoInfo.numBytesOfEncryptedData = new int[size];
            for (int i2 = 0; i2 < encryptionInfo.subsamples.size(); i2++) {
                SubsampleEncryptionInfo subsampleEncryptionInfo = encryptionInfo.subsamples.get(i2);
                cryptoInfo.numBytesOfClearData[i2] = subsampleEncryptionInfo.bytes_of_clear_data;
                cryptoInfo.numBytesOfEncryptedData[i2] = subsampleEncryptionInfo.bytes_of_protected_data;
            }
        }
        if (!"cenc".equals(encryptionInfo.scheme) && !"cens".equals(encryptionInfo.scheme)) {
            i = ("cbc1".equals(encryptionInfo.scheme) || "cbcs".equals(encryptionInfo.scheme)) ? 2 : 1;
            if ("cens".equals(encryptionInfo.scheme) || "cbcs".equals(encryptionInfo.scheme)) {
                cryptoInfo.setPattern(new MediaCodec.CryptoInfo.Pattern(encryptionInfo.crypt_byte_block, encryptionInfo.skip_byte_block));
            }
            return cryptoInfo;
        }
        cryptoInfo.mode = i;
        if ("cens".equals(encryptionInfo.scheme)) {
            cryptoInfo.setPattern(new MediaCodec.CryptoInfo.Pattern(encryptionInfo.crypt_byte_block, encryptionInfo.skip_byte_block));
        } else {
            cryptoInfo.setPattern(new MediaCodec.CryptoInfo.Pattern(encryptionInfo.crypt_byte_block, encryptionInfo.skip_byte_block));
        }
        return cryptoInfo;
    }

    private OutputBufferInfo fillDecodeBufferInfo(int i) {
        OutputBufferInfo outputBufferInfo = new OutputBufferInfo();
        outputBufferInfo.type = 0;
        outputBufferInfo.index = i;
        MediaCodec.BufferInfo bufferInfo = this.mBufferInfo;
        outputBufferInfo.pts = bufferInfo.presentationTimeUs;
        outputBufferInfo.eos = (bufferInfo.flags & 4) != 0;
        outputBufferInfo.bufferSize = bufferInfo.size;
        outputBufferInfo.bufferOffset = bufferInfo.offset;
        return outputBufferInfo;
    }

    private OutputBufferInfo fillFormatOutputBufferInfo() {
        try {
            MediaFormat outputFormat = this.mMediaCodec.getOutputFormat();
            OutputBufferInfo outputBufferInfo = new OutputBufferInfo();
            outputBufferInfo.type = 1;
            outputBufferInfo.eos = false;
            if (this.mCodecCateGory == CODEC_CATEGORY_VIDEO) {
                outputBufferInfo.videoCropBottom = getFormatInteger(outputFormat, a.j);
                outputBufferInfo.videoCropLeft = getFormatInteger(outputFormat, a.h);
                outputBufferInfo.videoCropRight = getFormatInteger(outputFormat, a.i);
                outputBufferInfo.videoCropTop = getFormatInteger(outputFormat, a.k);
                outputBufferInfo.videoHeight = getFormatInteger(outputFormat, "width");
                outputBufferInfo.videoWidth = getFormatInteger(outputFormat, "height");
                outputBufferInfo.videoPixelFormat = getFormatInteger(outputFormat, "color-format");
                outputBufferInfo.videoSliceHeight = getFormatInteger(outputFormat, "slice-height");
                outputBufferInfo.videoStride = getFormatInteger(outputFormat, "stride");
            } else {
                outputBufferInfo.audioChannelCount = getFormatInteger(outputFormat, com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT);
                outputBufferInfo.audioChannelMask = getFormatInteger(outputFormat, "channel-mask");
                outputBufferInfo.audioSampleRate = getFormatInteger(outputFormat, com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE);
                outputBufferInfo.audioFormat = getFormatInteger(outputFormat, "pcm-encoding");
            }
            return outputBufferInfo;
        } catch (Exception unused) {
            return null;
        }
    }

    private String findDecoderName(MediaFormat mediaFormat) {
        MediaCrypto mediaCrypto = this.mediaCrypto;
        boolean z = false;
        if (mediaCrypto != null && !this.forceInsecureDecoder && mediaCrypto.requiresSecureDecoderComponent(this.mMime)) {
            z = true;
        }
        String decoderName = getDecoderName(mediaFormat, z);
        Logger.i(TAG, "findDecoderName : " + decoderName + " , secure = " + z);
        return decoderName;
    }

    private String getDecoderName(MediaFormat mediaFormat, boolean z) {
        List<MediaCodecInfo> codecInfos = MediaCodecUtils.getCodecInfos(this.mMime, z, mediaFormat);
        String notBlackCodecName = getNotBlackCodecName(codecInfos);
        return (this.mediaCrypto == null || !TextUtils.isEmpty(notBlackCodecName) || codecInfos.isEmpty()) ? notBlackCodecName : codecInfos.get(0).getName();
    }

    private static int getFormatInteger(MediaFormat mediaFormat, String str) {
        if (mediaFormat.containsKey(str)) {
            return mediaFormat.getInteger(str);
        }
        return -1;
    }

    private ByteBuffer getInputBuffer(int i) {
        try {
            return this.mMediaCodec.getInputBuffer(i);
        } catch (Exception e) {
            Logger.e(TAG, "getInputBuffer fail " + e.getMessage());
            return null;
        }
    }

    private String getNotBlackCodecName(List<MediaCodecInfo> list) {
        if (!list.isEmpty()) {
            for (MediaCodecInfo mediaCodecInfo : list) {
                if (!isBlackCodec(mediaCodecInfo)) {
                    return mediaCodecInfo.getName();
                }
            }
        }
        return null;
    }

    private static boolean isBlackCodec(MediaCodecInfo mediaCodecInfo) {
        if (blackCodecPrefix.isEmpty()) {
            blackCodecPrefix.add("OMX.PV.");
            blackCodecPrefix.add("OMX.google.");
            blackCodecPrefix.add("OMX.ARICENT.");
            blackCodecPrefix.add("OMX.SEC.WMV.Decoder");
            blackCodecPrefix.add("OMX.SEC.MP3.Decoder");
            blackCodecPrefix.add("OMX.MTK.VIDEO.DECODER.VC1");
            blackCodecPrefix.add("OMX.SEC.vp8.dec");
        }
        if (blackCodecSuffix.isEmpty()) {
            blackCodecSuffix.add(".sw.dec");
            blackCodecSuffix.add(".hevcswvdec");
        }
        String name = mediaCodecInfo.getName();
        Iterator<String> it = blackCodecPrefix.iterator();
        while (it.hasNext()) {
            if (name.startsWith(it.next())) {
                return true;
            }
        }
        Iterator<String> it2 = blackCodecSuffix.iterator();
        while (it2.hasNext()) {
            if (name.endsWith(it2.next())) {
                return true;
            }
        }
        return false;
    }

    private int queueInputBufferInner(int i, byte[] bArr, long j, boolean z, boolean z2, Object obj) {
        ByteBuffer inputBuffer;
        if (this.mMediaCodec == null || (inputBuffer = getInputBuffer(i)) == null) {
            return -1;
        }
        inputBuffer.clear();
        if (bArr != null) {
            inputBuffer.put(bArr, 0, bArr.length);
            inputBuffer.flip();
        }
        int i2 = z ? 2 : 0;
        if (bArr == null) {
            i2 |= 4;
        }
        int i3 = i2;
        try {
            if (z2 && bArr != null) {
                MediaCodec.CryptoInfo cryptoInfoCreateCryptoInfo = createCryptoInfo((EncryptionInfo) obj);
                synchronized (queLock) {
                    this.mMediaCodec.queueSecureInputBuffer(i, 0, cryptoInfoCreateCryptoInfo, j, i3);
                }
            } else if ((i3 & 4) == 4) {
                this.mMediaCodec.queueInputBuffer(i, 0, 0, 0L, i3);
            } else {
                this.mMediaCodec.queueInputBuffer(i, 0, inputBuffer.limit(), j, i3);
            }
            return 0;
        } catch (Exception e) {
            Logger.e(TAG, "queueInputBufferInner  fail " + e.getLocalizedMessage());
            return -1;
        }
    }

    @NativeUsed
    public int configureAudio(String str, int i, int i2, int i3) {
        String str2 = TAG;
        Logger.i(str2, "--> configureAudio start " + str + i + " , " + i2);
        this.mCodecCateGory = CODEC_CATEGORY_AUDIO;
        this.mMime = str;
        MediaFormat mediaFormatCreateAudioFormat = MediaFormat.createAudioFormat(str, i, i2);
        mediaFormatCreateAudioFormat.setInteger("is-adts", i3);
        String strFindDecoderName = findDecoderName(mediaFormatCreateAudioFormat);
        if (TextUtils.isEmpty(strFindDecoderName)) {
            Logger.e(str2, "not found codec : " + str);
            return -12;
        }
        try {
            this.mMediaCodec = MediaCodec.createByCodecName(strFindDecoderName);
        } catch (IOException unused) {
        }
        MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec == null) {
            Logger.e(TAG, "createByCodecName fail : " + strFindDecoderName);
            return -13;
        }
        try {
            mediaCodec.configure(mediaFormatCreateAudioFormat, (Surface) null, this.mediaCrypto, 0);
            return 0;
        } catch (Exception e) {
            Logger.e(TAG, "configure fail : " + e.getMessage());
            return -14;
        }
    }

    @NativeUsed
    public int configureVideo(String str, int i, int i2, int i3, boolean z, Object obj) {
        MediaCrypto mediaCrypto;
        Surface surface;
        Logger.i(TAG, "--> configureVideo start " + str + ", " + i + ", " + i2 + ", " + i3 + ", " + z + ", " + obj);
        this.mCodecCateGory = CODEC_CATEGORY_VIDEO;
        this.mMime = str;
        int i4 = z ? 2 : 1;
        while (true) {
            int i5 = i4 - 1;
            if (i4 <= 0) {
                return 0;
            }
            MediaFormat mediaFormatCreateVideoFormat = MediaFormat.createVideoFormat(str, i, i2);
            if (i3 != 0) {
                mediaFormatCreateVideoFormat.setInteger("rotation-degrees", i3);
            }
            if (z) {
                mediaFormatCreateVideoFormat.setInteger("low-latency", 1);
                mediaFormatCreateVideoFormat.setInteger("vendor.hisi-ext-low-latency-video-dec.video-scene-for-low-latency-req", 1);
                mediaFormatCreateVideoFormat.setInteger("vendor.hisi-ext-low-latency-video-dec.video-scene-for-low-latency-rdy", -1);
            }
            String strFindDecoderName = findDecoderName(mediaFormatCreateVideoFormat);
            if (TextUtils.isEmpty(strFindDecoderName)) {
                Logger.e(TAG, "not found video codec : " + str);
                return -12;
            }
            try {
                this.mMediaCodec = MediaCodec.createByCodecName(strFindDecoderName);
            } catch (IOException e) {
                Logger.e(TAG, "MediaCodec.createByCodecName fail:" + e.getMessage());
            }
            MediaCodec mediaCodec = this.mMediaCodec;
            if (mediaCodec == null) {
                Logger.e(TAG, "createByCodecName fail : " + strFindDecoderName);
                return -13;
            }
            try {
                if (obj instanceof Surface) {
                    surface = (Surface) obj;
                    mediaCrypto = this.mediaCrypto;
                } else {
                    mediaCrypto = this.mediaCrypto;
                    surface = null;
                }
                mediaCodec.configure(mediaFormatCreateVideoFormat, surface, mediaCrypto, 0);
                return 0;
            } catch (Exception e2) {
                String str2 = TAG;
                Logger.e(str2, "configure fail : " + e2.getMessage());
                if (!z) {
                    return -14;
                }
                Logger.e(str2, "try configure again with lowLatency=false");
                i4 = i5;
                z = false;
            }
        }
    }

    @NativeUsed
    public int dequeueInputBufferIndex(long j) {
        ByteBuffer inputBuffer;
        if (this.mMediaCodec == null) {
            return -1;
        }
        try {
            if (!this.mCodecSpecificDataMap.isEmpty()) {
                for (String str : this.mCodecSpecificDataMap.keySet()) {
                    int iDequeueInputBuffer = this.mMediaCodec.dequeueInputBuffer(j);
                    if (iDequeueInputBuffer < 0 || (inputBuffer = getInputBuffer(iDequeueInputBuffer)) == null) {
                        return -11;
                    }
                    byte[] bArr = this.mCodecSpecificDataMap.get(str);
                    if (bArr != null) {
                        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(bArr.length);
                        byteBufferAllocate.put(bArr);
                        byteBufferAllocate.flip();
                        inputBuffer.put(byteBufferAllocate);
                        this.mMediaCodec.queueInputBuffer(iDequeueInputBuffer, 0, byteBufferAllocate.limit(), 0L, 2);
                    }
                }
                this.mCodecSpecificDataMap.clear();
            }
            int iDequeueInputBuffer2 = this.mMediaCodec.dequeueInputBuffer(j);
            if (iDequeueInputBuffer2 >= 0) {
                return iDequeueInputBuffer2;
            }
            return -11;
        } catch (Exception e) {
            Logger.e(TAG, "dequeueInputBufferIndex fail " + e.getMessage());
            return -1;
        }
    }

    @NativeUsed
    public int dequeueOutputBufferIndex(long j) {
        MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec == null) {
            return -1;
        }
        try {
            int iDequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(this.mBufferInfo, j);
            if (iDequeueOutputBuffer >= 0) {
                return iDequeueOutputBuffer;
            }
            if (iDequeueOutputBuffer == -1) {
                return -11;
            }
            if (iDequeueOutputBuffer == -2 || iDequeueOutputBuffer == -3) {
                return iDequeueOutputBuffer;
            }
            return -1;
        } catch (Exception e) {
            Logger.e(TAG, "dequeueOutputBufferIndex fail " + e.getMessage());
            return -1;
        }
    }

    @NativeUsed
    public int flush() {
        String str = TAG;
        Logger.i(str, "--> flush start");
        MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec == null) {
            Logger.e(str, "mMediaCodec  null ");
            return -1;
        }
        try {
            mediaCodec.flush();
            return 0;
        } catch (Exception e) {
            Logger.e(TAG, "flush  fail " + e.getMessage());
            return 0;
        }
    }

    @NativeUsed
    public Object getOutBuffer(int i) {
        if (i < 0) {
            return null;
        }
        try {
            return this.mMediaCodec.getOutputBuffer(i);
        } catch (Exception e) {
            Logger.e(TAG, "getOutBuffer fail " + e.getMessage());
            return null;
        }
    }

    @NativeUsed
    public Object getOutputBufferInfo(int i) {
        if (i == -2) {
            return fillFormatOutputBufferInfo();
        }
        if (i >= 0) {
            return fillDecodeBufferInfo(i);
        }
        return null;
    }

    @NativeUsed
    public int queueInputBuffer(int i, byte[] bArr, long j, boolean z) {
        return queueInputBufferInner(i, bArr, j, z, false, null);
    }

    @NativeUsed
    public int queueSecureInputBuffer(int i, byte[] bArr, Object obj, long j, boolean z) {
        return queueInputBufferInner(i, bArr, j, z, true, obj);
    }

    @NativeUsed
    public int release() {
        Logger.i(TAG, "--> release ");
        MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec == null) {
            return -1;
        }
        mediaCodec.release();
        this.mMediaCodec = null;
        MediaCrypto mediaCrypto = this.mediaCrypto;
        if (mediaCrypto == null) {
            return 0;
        }
        mediaCrypto.release();
        return 0;
    }

    @NativeUsed
    public int releaseOutputBuffer(int i, boolean z) {
        MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec == null) {
            return -1;
        }
        try {
            mediaCodec.releaseOutputBuffer(i, z);
            return 0;
        } catch (Exception e) {
            Logger.e(TAG, "releaseOutputBuffer fail " + e.getMessage());
            return -1;
        }
    }

    @NativeUsed
    public void setCodecSpecificData(Object obj) {
        Logger.d(TAG, "--> setCodecSpecificData datas " + obj);
        this.mCodecSpecificDataMap.clear();
        if (obj == null) {
            return;
        }
        this.mCodecSpecificDataMap.putAll((LinkedHashMap) obj);
    }

    @NativeUsed
    public boolean setDrmInfo(String str, byte[] bArr) {
        Logger.d(TAG, "--> setDrmInfo uuid " + str);
        try {
            this.mediaCrypto = new MediaCrypto(UUID.fromString(str), bArr);
            return true;
        } catch (Exception e) {
            Logger.e(TAG, "createMediaCrypto failed: " + e.getMessage());
            return false;
        }
    }

    @NativeUsed
    public void setForceInsecureDecoder(boolean z) {
        Logger.d(TAG, "--> setForceInsecureDecoder  " + z);
        this.forceInsecureDecoder = z;
    }

    @NativeUsed
    public int start() {
        String str = TAG;
        Logger.i(str, "--> start ");
        MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec == null) {
            Logger.e(str, "mMediaCodec  null ");
            return -1;
        }
        try {
            mediaCodec.start();
            this.started = true;
            this.mBufferInfo = new MediaCodec.BufferInfo();
            return 0;
        } catch (Exception e) {
            Logger.e(TAG, this.mMediaCodec.getName() + " start fail : " + e.getMessage());
            return -1;
        }
    }

    public int stop() {
        Logger.i(TAG, "--> stop start");
        MediaCodec mediaCodec = this.mMediaCodec;
        if (mediaCodec == null) {
            return -1;
        }
        if (!this.started) {
            return 0;
        }
        try {
            mediaCodec.stop();
            return 0;
        } catch (Exception e) {
            Logger.e(TAG, "stop fail " + e.getMessage());
            return -1;
        }
    }
}
