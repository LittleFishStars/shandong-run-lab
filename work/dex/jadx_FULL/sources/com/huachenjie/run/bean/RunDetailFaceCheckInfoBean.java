package com.huachenjie.run.bean;

import android.os.Parcel;
import android.os.Parcelable;
import com.blankj.utilcode.util.SizeUtils;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.huachenjie.run.R;
import com.zj.adlib.c49;
import com.zj.adlib.v79;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class RunDetailFaceCheckInfoBean implements Parcelable {
    private String ImgName;
    private int checkDistance;
    private int checkIndex;
    private float checkLat;
    private float checkLng;
    private long popTime;
    private String runFaceImg;
    private boolean runFaceUpload;
    public static RequestOptions rounded12 = new RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL).transforms(new CenterCrop(), new RoundedCorners(SizeUtils.b(12.0f))).error(R.drawable.run_bg_run_detail_face_error);
    public static final Parcelable.Creator<RunDetailFaceCheckInfoBean> CREATOR = new Parcelable.Creator<RunDetailFaceCheckInfoBean>() { // from class: com.huachenjie.run.bean.RunDetailFaceCheckInfoBean.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RunDetailFaceCheckInfoBean createFromParcel(Parcel in) {
            return new RunDetailFaceCheckInfoBean(in);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public RunDetailFaceCheckInfoBean[] newArray(int size) {
            return new RunDetailFaceCheckInfoBean[size];
        }
    };

    public RunDetailFaceCheckInfoBean() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String formatterCheckDistance() {
        if (this.checkDistance <= 0) {
            return c49.f40900a;
        }
        return this.checkDistance + "米";
    }

    public String formatterPopTime() {
        long j = this.popTime;
        return j <= 0 ? c49.f40900a : v79.P0(j);
    }

    public int getCheckDistance() {
        return this.checkDistance;
    }

    public int getCheckIndex() {
        return this.checkIndex;
    }

    public float getCheckLat() {
        return this.checkLat;
    }

    public float getCheckLng() {
        return this.checkLng;
    }

    public String getImgName() {
        return this.ImgName;
    }

    public long getPopTime() {
        return this.popTime;
    }

    public String getRunFaceImg() {
        return this.runFaceImg;
    }

    public boolean isRunFaceUpload() {
        return this.runFaceUpload;
    }

    public void setCheckDistance(int checkDistance) {
        this.checkDistance = checkDistance;
    }

    public void setCheckIndex(int checkIndex) {
        this.checkIndex = checkIndex;
    }

    public void setCheckLat(float checkLat) {
        this.checkLat = checkLat;
    }

    public void setCheckLng(float checkLng) {
        this.checkLng = checkLng;
    }

    public void setImgName(String imgName) {
        this.ImgName = imgName;
    }

    public void setPopTime(long popTime) {
        this.popTime = popTime;
    }

    public void setRunFaceImg(String runFaceImg) {
        this.runFaceImg = runFaceImg;
    }

    public void setRunFaceUpload(boolean runFaceUpload) {
        this.runFaceUpload = runFaceUpload;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.checkIndex);
        parcel.writeString(this.ImgName);
        parcel.writeByte(this.runFaceUpload ? (byte) 1 : (byte) 0);
        parcel.writeLong(this.popTime);
        parcel.writeFloat(this.checkLng);
        parcel.writeFloat(this.checkLat);
        parcel.writeString(this.runFaceImg);
        parcel.writeInt(this.checkDistance);
    }

    public RunDetailFaceCheckInfoBean(Parcel in) {
        this.checkIndex = in.readInt();
        this.ImgName = in.readString();
        this.runFaceUpload = in.readByte() != 0;
        this.popTime = in.readLong();
        this.checkLng = in.readFloat();
        this.checkLat = in.readFloat();
        this.runFaceImg = in.readString();
        this.checkDistance = in.readInt();
    }
}
