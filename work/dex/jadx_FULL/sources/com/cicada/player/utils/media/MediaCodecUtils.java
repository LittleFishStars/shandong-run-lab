package com.cicada.player.utils.media;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaFormat;
import android.util.Range;
import com.cicada.player.utils.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class MediaCodecUtils {
    private static final String TAG = "MediaCodecUtils";
    private static List<MediaCodecInfo> allDecoders;

    public static synchronized List<MediaCodecInfo> getCodecInfos(String str, boolean z, MediaFormat mediaFormat) {
        ArrayList arrayList;
        if (allDecoders == null) {
            allDecoders = getDeviceDecodecs();
        }
        arrayList = new ArrayList();
        for (MediaCodecInfo mediaCodecInfo : allDecoders) {
            String codecMimeType = getCodecMimeType(mediaCodecInfo, str);
            if (codecMimeType != null) {
                MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(codecMimeType);
                if (isSecureSupport(z, capabilitiesForType, codecMimeType) && isFormatSupport(mediaFormat, capabilitiesForType, codecMimeType)) {
                    arrayList.add(mediaCodecInfo);
                }
            }
        }
        return arrayList;
    }

    private static String getCodecMimeType(MediaCodecInfo mediaCodecInfo, String str) {
        for (String str2 : mediaCodecInfo.getSupportedTypes()) {
            if (str2.equalsIgnoreCase(str)) {
                return str2;
            }
        }
        return null;
    }

    private static List<MediaCodecInfo> getDeviceDecodecs() {
        ArrayList arrayList = new ArrayList();
        for (MediaCodecInfo mediaCodecInfo : new MediaCodecList(1).getCodecInfos()) {
            if (!mediaCodecInfo.isEncoder()) {
                arrayList.add(mediaCodecInfo);
            }
        }
        return arrayList;
    }

    private static int getFormatInteger(MediaFormat mediaFormat, String str, int i) {
        return mediaFormat.containsKey(str) ? mediaFormat.getInteger(str) : i;
    }

    public static synchronized boolean isDolbyAudioSupport() {
        boolean z;
        String str;
        Logger.i(TAG, "isDolbyAudioSupport begin");
        boolean z2 = false;
        try {
            if (allDecoders == null) {
                allDecoders = getDeviceDecodecs();
            }
            z = false;
            for (MediaCodecInfo mediaCodecInfo : allDecoders) {
                try {
                    for (String str2 : mediaCodecInfo.getSupportedTypes()) {
                        String str3 = TAG;
                        Logger.i(str3, "decoder mime:" + str2 + ", name:" + mediaCodecInfo.getName());
                        if (!str2.equals("audio/ac4") && str2.equals("audio/eac3")) {
                            if (mediaCodecInfo.getCapabilitiesForType(str2) != null) {
                                MediaCodecInfo.AudioCapabilities audioCapabilities = mediaCodecInfo.getCapabilitiesForType(str2).getAudioCapabilities();
                                int[] supportedSampleRates = audioCapabilities.getSupportedSampleRates();
                                if (audioCapabilities == null || supportedSampleRates == null) {
                                    str = "decoder mime:audio/eac3 getAudioCapabilities is null";
                                } else {
                                    String str4 = new String("");
                                    for (int i : supportedSampleRates) {
                                        str4 = (str4 + String.valueOf(i)) + ", ";
                                    }
                                    Logger.i(TAG, "find dolby decodeer, cap:" + audioCapabilities.getMaxInputChannelCount() + "," + str4);
                                    z = true;
                                }
                            } else {
                                str = "decoder mime:audio/eac3 getCapabilitiesForType is null";
                            }
                            Logger.e(str3, str);
                        }
                    }
                } catch (Exception e) {
                    e = e;
                    z2 = z;
                    Logger.e(TAG, "found exception: " + e.getMessage());
                    z = z2;
                }
            }
        } catch (Exception e2) {
            e = e2;
        }
        return z;
    }

    private static boolean isFormatSupport(MediaFormat mediaFormat, MediaCodecInfo.CodecCapabilities codecCapabilities, String str) {
        boolean zStartsWith = str.startsWith("video");
        boolean zStartsWith2 = str.startsWith("audio");
        boolean z = false;
        if (!zStartsWith) {
            if (!zStartsWith2) {
                return false;
            }
            MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
            if (audioCapabilities == null) {
                Logger.e(TAG, "audio format not support! audioCapabilities == null");
                return false;
            }
            int formatInteger = getFormatInteger(mediaFormat, com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_SAMPLE_RATE, -1);
            int formatInteger2 = getFormatInteger(mediaFormat, com.bykv.vk.component.ttvideo.player.MediaFormat.KEY_CHANNEL_COUNT, -1);
            boolean z2 = formatInteger == -1 || audioCapabilities.isSampleRateSupported(formatInteger);
            int maxInputChannelCount = audioCapabilities.getMaxInputChannelCount();
            boolean z3 = z2 && (formatInteger2 == -1 || maxInputChannelCount >= formatInteger2);
            if (!z3) {
                Logger.e(TAG, "audio format not support! sampleRate=" + formatInteger + ", supportedSampleRates=" + Arrays.toString(audioCapabilities.getSupportedSampleRates()) + ", channelCount=" + formatInteger2 + ", maxInputChannelCount=" + maxInputChannelCount);
            }
            return z3;
        }
        int formatInteger3 = getFormatInteger(mediaFormat, "width", -1);
        int formatInteger4 = getFormatInteger(mediaFormat, "height", -1);
        if (formatInteger3 <= 0 || formatInteger4 <= 0) {
            return true;
        }
        int iMax = Math.max(formatInteger3, formatInteger4);
        int iMin = Math.min(formatInteger3, formatInteger4);
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            Logger.e(TAG, "video format not support! videoCapabilities == null");
        } else {
            Range<Integer> supportedWidths = videoCapabilities.getSupportedWidths();
            Range<Integer> supportedHeights = videoCapabilities.getSupportedHeights();
            boolean zContains = supportedWidths.contains(Integer.valueOf(iMax));
            boolean zContains2 = supportedHeights.contains(Integer.valueOf(iMin));
            if (zContains && zContains2) {
                z = true;
            }
            if (!z) {
                Logger.e(TAG, "video format not support! width[" + iMax + "] not in widthRange [" + supportedWidths.getLower() + ", " + supportedWidths.getUpper() + "] or height[" + iMin + "] not in heightRange[" + supportedHeights.getLower() + ", " + supportedHeights.getUpper() + "]");
            }
            if (!z) {
                Logger.w(TAG, "Still mark isFormatSupported = true, as some devices claim not support but can run actually");
                return true;
            }
        }
        return z;
    }

    private static boolean isSecureSupport(boolean z, MediaCodecInfo.CodecCapabilities codecCapabilities, String str) {
        boolean zIsFeatureSupported = codecCapabilities.isFeatureSupported("secure-playback");
        boolean zIsFeatureRequired = codecCapabilities.isFeatureRequired("secure-playback");
        if (z || !zIsFeatureRequired) {
            return !z || zIsFeatureSupported;
        }
        return false;
    }
}
