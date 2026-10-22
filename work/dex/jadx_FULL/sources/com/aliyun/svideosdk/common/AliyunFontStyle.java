package com.aliyun.svideosdk.common;

import com.aliyun.Visible;
import com.aliyun.common.utils.q;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class AliyunFontStyle extends AliyunObject {
    private String mFontPath;
    private float mFontSize;
    private ISource mFontSource;
    private AliyunTypeface mTypeface;

    public class a implements ISource {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f25622a;

        public a(String str) {
            this.f25622a = str;
        }

        @Override // com.aliyun.svideosdk.common.ISource
        public String getId() {
            return null;
        }

        @Override // com.aliyun.svideosdk.common.ISource
        public String getPath() {
            return this.f25622a;
        }

        @Override // com.aliyun.svideosdk.common.ISource
        public String getURL() {
            return null;
        }
    }

    public class b implements ISource {
        public b() {
        }

        @Override // com.aliyun.svideosdk.common.ISource
        public String getId() {
            return null;
        }

        @Override // com.aliyun.svideosdk.common.ISource
        public String getPath() {
            return AliyunFontStyle.this.mFontPath;
        }

        @Override // com.aliyun.svideosdk.common.ISource
        public String getURL() {
            return null;
        }
    }

    public class c implements ISource {
        public c() {
        }

        @Override // com.aliyun.svideosdk.common.ISource
        public String getId() {
            return null;
        }

        @Override // com.aliyun.svideosdk.common.ISource
        public String getPath() {
            return AliyunFontStyle.this.mFontPath;
        }

        @Override // com.aliyun.svideosdk.common.ISource
        public String getURL() {
            return null;
        }
    }

    public AliyunFontStyle(ISource iSource) {
        this(iSource, 128.0f, AliyunTypeface.NORMAL);
    }

    public AliyunFontStyle(ISource iSource, float f, AliyunTypeface aliyunTypeface) {
        this.mFontPath = iSource.getPath();
        this.mFontSource = iSource;
        this.mFontSize = f;
        this.mTypeface = aliyunTypeface;
    }

    public AliyunFontStyle(String str, float f, AliyunTypeface aliyunTypeface) {
        this(new a(str), f, aliyunTypeface);
    }

    public String getFontPath() {
        return this.mFontPath;
    }

    public float getFontSize() {
        return this.mFontSize;
    }

    public ISource getFontSource() {
        return (this.mFontSource != null || q.b(this.mFontPath)) ? this.mFontSource : new c();
    }

    public AliyunTypeface getTypeface() {
        return this.mTypeface;
    }

    public void setFontPath(String str) {
        this.mFontPath = str;
        this.mFontSource = !q.b(str) ? new b() : null;
    }

    public void setFontSize(float f) {
        this.mFontSize = f;
    }

    public void setFontSource(ISource iSource) {
        if (iSource == null || q.b(iSource.getPath())) {
            this.mFontPath = "";
            iSource = null;
        } else {
            this.mFontPath = iSource.getPath();
        }
        this.mFontSource = iSource;
    }

    public void setTypeface(AliyunTypeface aliyunTypeface) {
        this.mTypeface = aliyunTypeface;
    }
}
