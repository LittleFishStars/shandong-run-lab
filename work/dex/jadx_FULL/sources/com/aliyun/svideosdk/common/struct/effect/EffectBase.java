package com.aliyun.svideosdk.common.struct.effect;

import com.aliyun.Visible;
import com.aliyun.svideosdk.common.struct.project.Source;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Visible
public class EffectBase {
    private static Integer BASE_EFFECT_ID = 8192;
    protected Source mSource;
    protected int resId;
    protected int viewId = 0;

    public EffectBase() {
        synchronized (BASE_EFFECT_ID) {
            Integer numValueOf = Integer.valueOf(BASE_EFFECT_ID.intValue() + 1);
            BASE_EFFECT_ID = numValueOf;
            this.resId = numValueOf.intValue();
        }
    }

    public boolean checkIsInvalid() {
        return false;
    }

    public void copy(EffectBase effectBase) {
        if (getSource() != null) {
            Source source = new Source();
            source.setId(getSource().getId());
            source.setPath(getSource().getPath());
            source.setURL(getSource().getURL());
            effectBase.mSource = source;
        }
        effectBase.resId = this.resId;
        effectBase.viewId = this.viewId;
    }

    @Deprecated
    public String getPath() {
        Source source = this.mSource;
        if (source != null) {
            return source.getPath();
        }
        return null;
    }

    public int getResId() {
        return this.resId;
    }

    public Source getSource() {
        return this.mSource;
    }

    public int getViewId() {
        return this.viewId;
    }

    public String readString(String str) {
        StringBuffer stringBuffer = new StringBuffer("");
        try {
            FileReader fileReader = new FileReader(new File(str));
            while (true) {
                int i = fileReader.read();
                if (i == -1) {
                    break;
                }
                stringBuffer.append((char) i);
            }
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuffer.toString();
    }

    @Deprecated
    public void setPath(String str) {
        this.mSource = new Source(str);
    }

    @Deprecated
    public void setResId(int i) {
        this.resId = i;
    }

    public void setSource(Source source) {
        this.mSource = source;
    }

    public void setViewId(int i) {
        this.viewId = i;
    }

    public String toString() {
        return "EffectBase{resId=" + this.resId + ", path='" + this.mSource + "', viewId=" + this.viewId + '}';
    }
}
