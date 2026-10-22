package com.huachenjie.run.adapter;

import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder;
import com.huachenjie.common.bean.GeoFenceDetail;
import com.huachenjie.run.R;
import com.huachenjie.run.databinding.RunItemGeofenceListV2Binding;
import com.huachenjie.run.page.run_index.adapter.RunIndexRecordAdapter;
import com.zj.adlib.r90;
import com.zj.adlib.ys8;
import huachenjie.sdk.map.adapter.map.utils.HCJMapUtils;
import huachenjie.sdk.map.lib_base.HCJLatLng;
import huachenjie.sdk.map.mapentry.HCJMapEntry;
import java.math.BigDecimal;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class GeoFenceListV2Adapter extends BaseQuickAdapter<GeoFenceDetail, BaseDataBindingHolder<RunItemGeofenceListV2Binding>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public HCJMapUtils f35433a;

    public GeoFenceListV2Adapter() {
        super(R.layout.run_item_geofence_list_v2);
        this.f35433a = HCJMapEntry.getInstance().createMapUtils();
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    @Nullable
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public GeoFenceDetail getItem(int position) {
        return (GeoFenceDetail) super.getItem(position);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public void convert(@NonNull BaseDataBindingHolder<RunItemGeofenceListV2Binding> helper, GeoFenceDetail item) {
        String str;
        RunItemGeofenceListV2Binding runItemGeofenceListV2Binding = (RunItemGeofenceListV2Binding) helper.getDataBinding();
        if (runItemGeofenceListV2Binding == null) {
            return;
        }
        runItemGeofenceListV2Binding.p(item);
        runItemGeofenceListV2Binding.r(Integer.valueOf(helper.getBindingAdapterPosition() + 1));
        boolean zContainsLocation = false;
        if (r90.o() != null && r90.o().getLat() != AudioStats.AUDIO_AMPLITUDE_NONE) {
            zContainsLocation = this.f35433a.containsLocation(new HCJLatLng(r90.o().getLat(), r90.o().getLng()), item.getFenceList(), false);
        }
        runItemGeofenceListV2Binding.o(Boolean.valueOf(zContainsLocation));
        if (item.getDistance() > 0) {
            str = "距离" + BigDecimal.valueOf(item.getDistance()).divide(BigDecimal.valueOf(1000L), 2, 4).toString() + ys8.e(R.string.kilometer);
        } else {
            str = "";
        }
        runItemGeofenceListV2Binding.q(str);
        ImageView imageView = runItemGeofenceListV2Binding.f35616a;
        if (imageView != null) {
            imageView.setColorFilter(item.isOpenStatus() ? RunIndexRecordAdapter.P : -6841702);
        }
        runItemGeofenceListV2Binding.executePendingBindings();
    }
}
