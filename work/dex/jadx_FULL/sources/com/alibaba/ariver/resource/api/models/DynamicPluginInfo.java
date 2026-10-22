package com.alibaba.ariver.resource.api.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DynamicPluginInfo implements Parcelable {
    public static final Parcelable.Creator<DynamicPluginInfo> CREATOR = new Parcelable.Creator<DynamicPluginInfo>() { // from class: com.alibaba.ariver.resource.api.models.DynamicPluginInfo.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DynamicPluginInfo createFromParcel(Parcel parcel) {
            return new DynamicPluginInfo(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DynamicPluginInfo[] newArray(int i) {
            return new DynamicPluginInfo[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private List<PluginModel> f24429a;

    public DynamicPluginInfo() {
        this.f24429a = new ArrayList();
    }

    public boolean addPlugin(PluginModel pluginModel) {
        PluginModel next;
        if (pluginModel == null) {
            return false;
        }
        Iterator<PluginModel> it = this.f24429a.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (TextUtils.equals(pluginModel.getAppId(), next.getAppId()) && TextUtils.equals(pluginModel.getVersion(), next.getVersion())) {
                break;
            }
        }
        if (next != null) {
            this.f24429a.remove(next);
        }
        return this.f24429a.add(pluginModel);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public List<PluginModel> getPluginModels() {
        return this.f24429a;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeTypedList(this.f24429a);
    }

    public DynamicPluginInfo(Parcel parcel) {
        this.f24429a = new ArrayList();
        this.f24429a = parcel.createTypedArrayList(PluginModel.CREATOR);
    }
}
