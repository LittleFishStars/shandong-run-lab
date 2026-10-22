package com.coremedia.iso.boxes.fragment;

import android.support.v4.media.session.PlaybackStateCompat;
import com.coremedia.iso.IsoTypeReader;
import com.coremedia.iso.IsoTypeWriter;
import com.google.common.base.a;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class SampleFlags {
    private byte isLeading;
    private byte reserved;
    private int sampleDegradationPriority;
    private byte sampleDependsOn;
    private byte sampleHasRedundancy;
    private byte sampleIsDependedOn;
    private boolean sampleIsDifferenceSample;
    private byte samplePaddingValue;

    public SampleFlags() {
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        SampleFlags sampleFlags = (SampleFlags) obj;
        return this.isLeading == sampleFlags.isLeading && this.reserved == sampleFlags.reserved && this.sampleDegradationPriority == sampleFlags.sampleDegradationPriority && this.sampleDependsOn == sampleFlags.sampleDependsOn && this.sampleHasRedundancy == sampleFlags.sampleHasRedundancy && this.sampleIsDependedOn == sampleFlags.sampleIsDependedOn && this.sampleIsDifferenceSample == sampleFlags.sampleIsDifferenceSample && this.samplePaddingValue == sampleFlags.samplePaddingValue;
    }

    public void getContent(ByteBuffer byteBuffer) {
        IsoTypeWriter.writeUInt32(byteBuffer, ((long) (this.reserved << a.F)) | 0 | ((long) (this.isLeading << a.D)) | ((long) (this.sampleDependsOn << a.B)) | ((long) (this.sampleIsDependedOn << a.z)) | ((long) (this.sampleHasRedundancy << a.x)) | ((long) (this.samplePaddingValue << 17)) | ((long) ((this.sampleIsDifferenceSample ? 1 : 0) << 16)) | ((long) this.sampleDegradationPriority));
    }

    public byte getIsLeading() {
        return this.isLeading;
    }

    public int getReserved() {
        return this.reserved;
    }

    public int getSampleDegradationPriority() {
        return this.sampleDegradationPriority;
    }

    public int getSampleDependsOn() {
        return this.sampleDependsOn;
    }

    public int getSampleHasRedundancy() {
        return this.sampleHasRedundancy;
    }

    public int getSampleIsDependedOn() {
        return this.sampleIsDependedOn;
    }

    public int getSamplePaddingValue() {
        return this.samplePaddingValue;
    }

    public int hashCode() {
        return (((((((((((((this.reserved * 31) + this.isLeading) * 31) + this.sampleDependsOn) * 31) + this.sampleIsDependedOn) * 31) + this.sampleHasRedundancy) * 31) + this.samplePaddingValue) * 31) + (this.sampleIsDifferenceSample ? 1 : 0)) * 31) + this.sampleDegradationPriority;
    }

    public boolean isSampleIsDifferenceSample() {
        return this.sampleIsDifferenceSample;
    }

    public void setIsLeading(byte b) {
        this.isLeading = b;
    }

    public void setReserved(int i) {
        this.reserved = (byte) i;
    }

    public void setSampleDegradationPriority(int i) {
        this.sampleDegradationPriority = i;
    }

    public void setSampleDependsOn(int i) {
        this.sampleDependsOn = (byte) i;
    }

    public void setSampleHasRedundancy(int i) {
        this.sampleHasRedundancy = (byte) i;
    }

    public void setSampleIsDependedOn(int i) {
        this.sampleIsDependedOn = (byte) i;
    }

    public void setSampleIsDifferenceSample(boolean z) {
        this.sampleIsDifferenceSample = z;
    }

    public void setSamplePaddingValue(int i) {
        this.samplePaddingValue = (byte) i;
    }

    public String toString() {
        return "SampleFlags{reserved=" + ((int) this.reserved) + ", isLeading=" + ((int) this.isLeading) + ", depOn=" + ((int) this.sampleDependsOn) + ", isDepOn=" + ((int) this.sampleIsDependedOn) + ", hasRedundancy=" + ((int) this.sampleHasRedundancy) + ", padValue=" + ((int) this.samplePaddingValue) + ", isDiffSample=" + this.sampleIsDifferenceSample + ", degradPrio=" + this.sampleDegradationPriority + '}';
    }

    public SampleFlags(ByteBuffer byteBuffer) {
        long uInt32 = IsoTypeReader.readUInt32(byteBuffer);
        this.reserved = (byte) (((-268435456) & uInt32) >> 28);
        this.isLeading = (byte) ((201326592 & uInt32) >> 26);
        this.sampleDependsOn = (byte) ((50331648 & uInt32) >> 24);
        this.sampleIsDependedOn = (byte) ((12582912 & uInt32) >> 22);
        this.sampleHasRedundancy = (byte) ((3145728 & uInt32) >> 20);
        this.samplePaddingValue = (byte) ((917504 & uInt32) >> 17);
        this.sampleIsDifferenceSample = ((PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH & uInt32) >> 16) > 0;
        this.sampleDegradationPriority = (int) (uInt32 & 65535);
    }
}
