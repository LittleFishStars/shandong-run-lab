package com.bykv.vk.component.ttvideo.player;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@JNINamespace("PLAYER")
public class SidxListObject extends NativeObject {
    private long mBitrate;
    private int mEndIndex;
    private String mFileId;
    private List<SidxItem> mItems = new ArrayList();
    private int mMediaType;
    private int mStartIndex;
    private int mTotalNum;

    public static class SidxItem {
        private long mDuration;
        private int mIndex;
        private long mOffset;
        private long mSize;
        private long mTimestamp;

        public SidxItem(int i, long j, long j2, long j3, long j4) {
            this.mIndex = i;
            this.mOffset = j;
            this.mTimestamp = j2;
            this.mDuration = j3;
            this.mSize = j4;
        }

        public long getDuration() {
            return this.mDuration;
        }

        public int getIndex() {
            return this.mIndex;
        }

        public long getOffset() {
            return this.mOffset;
        }

        public long getSize() {
            return this.mSize;
        }

        public long getTimestamp() {
            return this.mTimestamp;
        }
    }

    @CalledByNative
    public SidxListObject(int i, int i2, int i3, int i4, long j, String str) {
        this.mMediaType = i;
        this.mTotalNum = i2;
        this.mStartIndex = i3;
        this.mEndIndex = i4;
        this.mBitrate = j;
        this.mFileId = str;
    }

    @CalledByNative
    public void addItem(int i, long j, long j2, long j3, long j4) {
        this.mItems.add(new SidxItem(i, j, j2, j3, j4));
    }

    public long getBitrate() {
        return this.mBitrate;
    }

    public int getEndIndex() {
        return this.mEndIndex;
    }

    public String getFileId() {
        return this.mFileId;
    }

    public SidxItem getItem(int i) {
        if (i < 0 || i >= this.mItems.size()) {
            return null;
        }
        return this.mItems.get(i);
    }

    public int getMediaType() {
        return this.mMediaType;
    }

    public int getStartIndex() {
        return this.mStartIndex;
    }

    public int getTotalNum() {
        return this.mTotalNum;
    }
}
