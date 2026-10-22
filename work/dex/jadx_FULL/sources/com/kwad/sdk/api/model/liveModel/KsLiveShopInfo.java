package com.kwad.sdk.api.model.liveModel;

import androidx.annotation.Keep;
import java.io.Serializable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@Keep
public class KsLiveShopInfo implements Serializable {
    private static final long serialVersionUID = 3745132899544688647L;
    private boolean haveCoupon;
    private String icon;
    private String name;
    private String originPrice;
    private String price;
    private String volume;

    public String getIcon() {
        return this.icon;
    }

    public String getName() {
        return this.name;
    }

    public String getOriginPrice() {
        return this.originPrice;
    }

    public String getPrice() {
        return this.price;
    }

    public String getVolume() {
        return this.volume;
    }

    public boolean isHaveCoupon() {
        return this.haveCoupon;
    }

    public void setHaveCoupon(boolean z) {
        this.haveCoupon = z;
    }

    public void setIcon(String str) {
        this.icon = str;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setOriginPrice(String str) {
        this.originPrice = str;
    }

    public void setPrice(String str) {
        this.price = str;
    }

    public void setVolume(String str) {
        this.volume = str;
    }

    public String toString() {
        return "KsLiveShopInfo{icon='" + this.icon + "', name='" + this.name + "', price='" + this.price + "', originPrice='" + this.originPrice + "', volume='" + this.volume + "', haveCoupon=" + this.haveCoupon + '}';
    }
}
