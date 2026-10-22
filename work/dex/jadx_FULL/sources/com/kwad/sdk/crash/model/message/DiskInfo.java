package com.kwad.sdk.crash.model.message;

import androidx.annotation.Nullable;
import com.kwad.sdk.core.b;
import com.kwad.sdk.utils.ac;
import java.io.Serializable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class DiskInfo implements b, Serializable {
    private static final long serialVersionUID = -154725647775465930L;
    public double mDataAvailableGB;
    public double mDataTotalGB;
    public double mExternalStorageAvailableGB;
    public double mExternalStorageTotalGB;

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        this.mDataTotalGB = jSONObject.optDouble("mDataTotalGB");
        this.mDataAvailableGB = jSONObject.optDouble("mDataAvailableGB");
        this.mExternalStorageTotalGB = jSONObject.optDouble("mExternalStorageTotalGB");
        this.mExternalStorageAvailableGB = jSONObject.optDouble("mExternalStorageAvailableGB");
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        ac.putValue(jSONObject, "mDataTotalGB", this.mDataTotalGB);
        ac.putValue(jSONObject, "mDataAvailableGB", this.mDataAvailableGB);
        ac.putValue(jSONObject, "mExternalStorageTotalGB", this.mExternalStorageTotalGB);
        ac.putValue(jSONObject, "mExternalStorageAvailableGB", this.mExternalStorageAvailableGB);
        return jSONObject;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\t总存储空间: ");
        sb.append(this.mDataTotalGB);
        sb.append(" (GB)\n\t可用存储空间: ");
        sb.append(this.mDataAvailableGB);
        sb.append(" (GB)\n\t总SD卡空间: ");
        sb.append(this.mExternalStorageTotalGB);
        sb.append(" (GB)\n\t可用SD卡空间: ");
        sb.append(this.mExternalStorageAvailableGB);
        sb.append(" (GB)\n");
        return sb.substring(0);
    }
}
