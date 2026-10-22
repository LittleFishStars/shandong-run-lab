package com.aliyun.svideosdk.mixrecorder.impl;

import android.graphics.Bitmap;
import com.aliyun.common.utils.c;
import com.aliyun.svideosdk.mixrecorder.AliyunIMixComposer;
import com.aliyun.svideosdk.mixrecorder.AliyunMixCallback;
import com.aliyun.svideosdk.mixrecorder.AliyunMixOutputParam;
import com.aliyun.svideosdk.mixrecorder.AliyunMixStream;
import com.aliyun.svideosdk.mixrecorder.AliyunMixTrack;
import com.aliyun.svideosdk.mixrecorder.AliyunMixTrackLayoutParam;
import com.aliyun.svideosdk.mixrecorder.NativeMixComposer;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
class a extends com.aliyun.svideosdk.nativeload.a implements AliyunIMixComposer {
    private AliyunMixOutputParam b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NativeMixComposer f25780a = new NativeMixComposer(false, 0);
    private List<AliyunMixTrack> c = new ArrayList();

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixComposer
    public int cancel() {
        return this.f25780a.a();
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixComposer
    public AliyunMixTrack createTrack(AliyunMixTrackLayoutParam aliyunMixTrackLayoutParam) {
        if (aliyunMixTrackLayoutParam == null) {
            com.aliyun.common.c.a.a.b("AliYunLog", "Invalid layoutParam!");
            return null;
        }
        AliyunMixTrack aliyunMixTrack = new AliyunMixTrack();
        this.c.add(aliyunMixTrack);
        aliyunMixTrack.setMixTrackLayoutParam(aliyunMixTrackLayoutParam);
        return aliyunMixTrack;
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixComposer
    public int pause() {
        return this.f25780a.b();
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixComposer
    public int release() {
        int iC;
        NativeMixComposer nativeMixComposer = this.f25780a;
        if (nativeMixComposer != null) {
            iC = nativeMixComposer.c();
            this.f25780a = null;
        } else {
            iC = 0;
        }
        List<AliyunMixTrack> list = this.c;
        if (list != null) {
            list.clear();
            this.c = null;
        }
        return iC;
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixComposer
    public int resume() {
        return this.f25780a.d();
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixComposer
    public int setBackgroundColor(int i) {
        return this.f25780a.a(i);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixComposer
    public int setBackgroundImage(Bitmap bitmap, int i) {
        this.f25780a.b(i);
        return this.f25780a.a(bitmap);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixComposer
    public int setBackgroundImage(String str, int i) {
        this.f25780a.b(i);
        return this.f25780a.a(str);
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixComposer
    public int setOutputParam(AliyunMixOutputParam aliyunMixOutputParam) {
        if (aliyunMixOutputParam == null) {
            com.aliyun.common.c.a.a.b("AliYunLog", "AliyunMixOutputParam is null!");
            return -20003002;
        }
        this.b = aliyunMixOutputParam;
        return 0;
    }

    @Override // com.aliyun.svideosdk.mixrecorder.AliyunIMixComposer
    public int start(AliyunMixCallback aliyunMixCallback) {
        String str;
        if (this.b == null) {
            com.aliyun.common.c.a.a.b("AliYunLog", "There's no outputParam!Start mixing failed!");
            return -4;
        }
        List<AliyunMixTrack> list = this.c;
        if (list != null && !list.isEmpty()) {
            ArrayList<AliyunMixTrack> arrayList = new ArrayList();
            int i = 0;
            int trackId = 0;
            for (AliyunMixTrack aliyunMixTrack : this.c) {
                if (i == 0) {
                    trackId = aliyunMixTrack.getTrackId();
                    i++;
                }
                AliyunMixTrackLayoutParam mixTrackLayoutParam = aliyunMixTrack.getMixTrackLayoutParam();
                if (mixTrackLayoutParam == null) {
                    str = "track's AliyunMixTrackLayoutParam is null";
                } else {
                    AliyunMixStream mixStream = aliyunMixTrack.getMixStream();
                    if (mixStream == null) {
                        str = "track's AliyunMixStream is null, please call AliyunMixTrack.addStream first";
                    } else {
                        int iA = this.f25780a.a(mixTrackLayoutParam.getCenterX(), mixTrackLayoutParam.getCenterY(), mixTrackLayoutParam.getWidthRatio(), mixTrackLayoutParam.getHeightRatio(), false);
                        aliyunMixTrack.setTrackId(iA);
                        mixStream.setStreamId(this.f25780a.a(mixStream.getFilePath(), iA, mixStream.getStreamStartTimeMills() * 1000, mixStream.getStreamEndTimeMills() * 1000, mixStream.getDisplayMode().ordinal()));
                        if (aliyunMixTrack.isAudioOutputTrack()) {
                            if (i == 0) {
                                trackId = aliyunMixTrack.getTrackId();
                                i++;
                            }
                            arrayList.add(aliyunMixTrack);
                        }
                        if (mixTrackLayoutParam.getMixBorderParam() != null) {
                            c.b(0, Integer.valueOf(this.b.getOutputWidth()));
                            this.f25780a.a(iA, (mixTrackLayoutParam.getMixBorderParam().getBorderWidth() * 1.0f) / this.b.getOutputWidth(), mixTrackLayoutParam.getMixBorderParam().getBorderColor(), mixTrackLayoutParam.getMixBorderParam().getCornerRadius() / this.b.getOutputWidth());
                        }
                    }
                }
            }
            AliyunMixTrack outputDurationReferenceTrack = this.b.getOutputDurationReferenceTrack();
            int trackId2 = outputDurationReferenceTrack == null ? 0 : outputDurationReferenceTrack.getTrackId();
            int[] iArr = new int[arrayList.size() * 2];
            int i2 = 0;
            for (AliyunMixTrack aliyunMixTrack2 : arrayList) {
                int i3 = i2 + 1;
                iArr[i2] = aliyunMixTrack2.getTrackId();
                i2 = i3 + 1;
                iArr[i3] = aliyunMixTrack2.getMixAudioWeight();
            }
            int iA2 = this.f25780a.a(this.b.getOutputPath(), trackId2, trackId, this.b.getOutputWidth(), this.b.getOutputHeight(), this.b.getCrf(), this.b.getBitrate(), this.b.getVideoQuality().ordinal(), this.b.getFps(), this.b.getGopSize(), iArr, arrayList.size(), new int[0], 0);
            return iA2 != 0 ? iA2 : this.f25780a.a(aliyunMixCallback);
        }
        str = "There's no track to mix!Start mixing failed! please createTrack first";
        com.aliyun.common.c.a.a.b("AliYunLog", str);
        return -2;
    }
}
