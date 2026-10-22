package com.alibaba.ariver.app;

import android.os.Parcel;
import android.os.Parcelable;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.app.api.Visit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class VisitNode extends NodeInstance implements Visit {
    public static final Parcelable.Creator<VisitNode> CREATOR = new Parcelable.Creator<VisitNode>() { // from class: com.alibaba.ariver.app.VisitNode.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VisitNode createFromParcel(Parcel parcel) {
            return new VisitNode(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VisitNode[] newArray(int i) {
            return new VisitNode[i];
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f23816a;

    public VisitNode(Page page) {
        super(page);
    }

    @Override // com.alibaba.ariver.app.api.Visit
    public String getVisitUrl() {
        return this.f23816a;
    }

    public void setVisitUrl(String str) {
        this.f23816a = str;
    }

    @Override // com.alibaba.ariver.app.NodeInstance, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    public VisitNode(Parcel parcel) {
        super(parcel);
    }
}
