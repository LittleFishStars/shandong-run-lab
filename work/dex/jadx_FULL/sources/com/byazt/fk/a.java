package com.byazt.fk;

import android.util.SparseArray;
import com.byazt.ut.ATSKeep;
import java.util.function.Function;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@ATSKeep
@com.byazt.zqa.c(c = {0, 1, 1696, 34})
public class a implements n, Function {
    public volatile Function c;
    public volatile n tt;

    public a(n nVar) {
        this.tt = nVar;
    }

    public a(Function function) {
        this.c = function;
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        switch (((Integer) sparseArray.get(0)).intValue()) {
            case 1:
                return Integer.valueOf(this.tt.getFallbackEndCardJudge());
            case 2:
                this.tt.setFallbackEndCardJudge(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 3:
                return Integer.valueOf(this.tt.getCover_height());
            case 4:
                this.tt.setCover_height(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 5:
                return Integer.valueOf(this.tt.getCover_width());
            case 6:
                this.tt.setCover_width(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 7:
                return Integer.valueOf(this.tt.getEndcardRender());
            case 8:
                this.tt.setEndcardRender(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 9:
                return Long.valueOf(this.tt.getSize());
            case 10:
                this.tt.setSize(((Long) sparseArray.get(1)).longValue());
                return null;
            case 11:
                return Double.valueOf(this.tt.getVideo_duration());
            case 12:
                this.tt.setVideo_duration(((Double) sparseArray.get(1)).doubleValue());
                return null;
            case 13:
                return Double.valueOf(this.tt.getStart());
            case 14:
                this.tt.setStart(((Double) sparseArray.get(1)).doubleValue());
                return null;
            case 15:
                return Float.valueOf(this.tt.getPlay_speed_ratio());
            case 16:
                this.tt.setPlay_speed_ratio(((Float) sparseArray.get(1)).floatValue());
                return null;
            case 17:
                return this.tt.getResolution();
            case 18:
                this.tt.setResolution((String) sparseArray.get(1));
                return null;
            case 19:
                return this.tt.getWidthAndHeight();
            case 20:
                return this.tt.getCover_url();
            case 21:
                this.tt.setCover_url((String) sparseArray.get(1));
                return null;
            case 22:
                return this.tt.getVideo_url();
            case 23:
                this.tt.setVideo_url((String) sparseArray.get(1));
                return null;
            case 24:
                return this.tt.getEndcard();
            case 25:
                this.tt.setEndcard((String) sparseArray.get(1));
                return null;
            case 26:
                return this.tt.getPlayableZipUrl();
            case 27:
                this.tt.setPlayableZipUrl((String) sparseArray.get(1));
                return null;
            case 28:
                return this.tt.getFileHash();
            case 29:
                this.tt.setFileHash((String) sparseArray.get(1));
                return null;
            case 30:
                return Integer.valueOf(this.tt.getVideoPreloadSize());
            case 31:
                this.tt.setVideoPreloadSize(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 32:
                return Integer.valueOf(this.tt.getRewardVideoCachedType());
            case 33:
                this.tt.setRewardVideoCachedType(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 34:
                return Integer.valueOf(this.tt.getExecuteCachedType());
            case 35:
                this.tt.setExecuteCachedType(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 36:
                return this.tt.toJsonObj();
            case 37:
                return Integer.valueOf(this.tt.getPlayableLoadingShow());
            case 38:
                this.tt.setPlayableLoadingShow(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 39:
                return Integer.valueOf(this.tt.getPlayableLoadingHide());
            case 40:
                this.tt.setPlayableLoadingHide(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 41:
                return Boolean.valueOf(this.tt.isExecCallbackWhenFail());
            case 42:
                return Boolean.valueOf(this.tt.isCacheAllVideo());
            case 43:
                this.tt.setReplayTime(((Integer) sparseArray.get(1)).intValue());
                return null;
            case 44:
                return Integer.valueOf(this.tt.getReplayTime());
            default:
                return null;
        }
    }

    @Override // com.byazt.fk.n
    public int getCover_height() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 3);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.fk.n
    public String getCover_url() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 20);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.n
    public int getCover_width() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 5);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.fk.n
    public String getEndcard() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 24);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.n
    public int getEndcardRender() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 7);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.fk.n
    public int getExecuteCachedType() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 34);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.fk.n
    public int getFallbackEndCardJudge() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 1);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.fk.n
    public String getFileHash() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 28);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.n
    public float getPlay_speed_ratio() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 15);
        return ((Float) this.c.apply(sparseArray)).floatValue();
    }

    @Override // com.byazt.fk.n
    public int getPlayableLoadingHide() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 39);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.fk.n
    public int getPlayableLoadingShow() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 37);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.fk.n
    public String getPlayableZipUrl() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 26);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.n
    public int getReplayTime() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 44);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.fk.n
    public String getResolution() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 17);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.n
    public int getRewardVideoCachedType() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 32);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.fk.n
    public long getSize() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 9);
        return ((Long) this.c.apply(sparseArray)).longValue();
    }

    @Override // com.byazt.fk.n
    public double getStart() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 13);
        return ((Double) this.c.apply(sparseArray)).doubleValue();
    }

    @Override // com.byazt.fk.n
    public int getVideoPreloadSize() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 30);
        return ((Integer) this.c.apply(sparseArray)).intValue();
    }

    @Override // com.byazt.fk.n
    public double getVideo_duration() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 11);
        return ((Double) this.c.apply(sparseArray)).doubleValue();
    }

    @Override // com.byazt.fk.n
    public String getVideo_url() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 22);
        return (String) this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.n
    public int[] getWidthAndHeight() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 19);
        return (int[]) this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.n
    public boolean isCacheAllVideo() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 42);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.fk.n
    public boolean isExecCallbackWhenFail() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 41);
        return ((Boolean) this.c.apply(sparseArray)).booleanValue();
    }

    @Override // com.byazt.fk.n
    public void setCover_height(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 4);
        sparseArray.put(1, Integer.valueOf(i));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.n
    public void setCover_url(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 21);
        sparseArray.put(1, str);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.n
    public void setCover_width(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 6);
        sparseArray.put(1, Integer.valueOf(i));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.n
    public void setEndcard(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 25);
        sparseArray.put(1, str);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.n
    public void setEndcardRender(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 8);
        sparseArray.put(1, Integer.valueOf(i));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.n
    public void setExecuteCachedType(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 35);
        sparseArray.put(1, Integer.valueOf(i));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.n
    public void setFallbackEndCardJudge(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 2);
        sparseArray.put(1, Integer.valueOf(i));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.n
    public void setFileHash(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 29);
        sparseArray.put(1, str);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.n
    public void setPlay_speed_ratio(float f) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 16);
        sparseArray.put(1, Float.valueOf(f));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.n
    public void setPlayableLoadingHide(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 40);
        sparseArray.put(1, Integer.valueOf(i));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.n
    public void setPlayableLoadingShow(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 38);
        sparseArray.put(1, Integer.valueOf(i));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.n
    public void setPlayableZipUrl(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 27);
        sparseArray.put(1, str);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.n
    public void setReplayTime(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 43);
        sparseArray.put(1, Integer.valueOf(i));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.n
    public void setResolution(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 18);
        sparseArray.put(1, str);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.n
    public void setRewardVideoCachedType(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 33);
        sparseArray.put(1, Integer.valueOf(i));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.n
    public void setSize(long j) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 10);
        sparseArray.put(1, Long.valueOf(j));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.n
    public void setStart(double d) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 14);
        sparseArray.put(1, Double.valueOf(d));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.n
    public void setVideoPreloadSize(int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 31);
        sparseArray.put(1, Integer.valueOf(i));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.n
    public void setVideo_duration(double d) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 12);
        sparseArray.put(1, Double.valueOf(d));
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.n
    public void setVideo_url(String str) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 23);
        sparseArray.put(1, str);
        this.c.apply(sparseArray);
    }

    @Override // com.byazt.fk.n
    public JSONObject toJsonObj() {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(0, 36);
        return (JSONObject) this.c.apply(sparseArray);
    }
}
