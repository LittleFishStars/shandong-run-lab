package com.huachenjie.common.widget.xScrollView;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class XScrollViewAdapter<T> extends RecyclerView.Adapter<XScrollViewHolder> {
    private static final String TAG = "XScrollViewAdapter";
    private AdapterItemViewListener adapterItemViewListener;
    private List<XScrollItemData<T>> itemDataList;
    private List<XScrollItemTypeInfo> itemTypeInfoList;

    public interface AdapterItemViewListener {
        void changeLayout(int value);

        void onBindViewHolder(XScrollViewHolder holder, int position, XScrollItemData data);
    }

    public XScrollViewAdapter(List<XScrollItemTypeInfo> typeInfoList) {
        if (typeInfoList == null || typeInfoList.isEmpty()) {
            throw new RuntimeException("Please initialize item type info!");
        }
        setItemTypeInfoList(typeInfoList);
    }

    private int findLayoutResIdByItemType(int itemType) {
        List<XScrollItemTypeInfo> list = this.itemTypeInfoList;
        if (list != null && !list.isEmpty()) {
            for (XScrollItemTypeInfo xScrollItemTypeInfo : this.itemTypeInfoList) {
                if (xScrollItemTypeInfo.getItemType() == itemType) {
                    return xScrollItemTypeInfo.getLayoutResId();
                }
            }
        }
        return -1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        List<XScrollItemData<T>> list = this.itemDataList;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        return this.itemDataList.size();
    }

    public List<XScrollItemTypeInfo> getItemTypeInfoList() {
        return this.itemTypeInfoList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        List<XScrollItemData<T>> list = this.itemDataList;
        if (list == null || list.isEmpty()) {
            return -1;
        }
        return this.itemDataList.get(position).getItemType();
    }

    public void setAdapterItemViewListener(AdapterItemViewListener adapterItemViewListener) {
        this.adapterItemViewListener = adapterItemViewListener;
    }

    public void setData(List<XScrollItemData<T>> dataList) {
        List<XScrollItemData<T>> list = this.itemDataList;
        if (list == null) {
            this.itemDataList = new ArrayList();
        } else {
            list.clear();
        }
        this.itemDataList.addAll(dataList);
        notifyDataSetChanged();
    }

    public void setItemTypeInfoList(List<XScrollItemTypeInfo> typeInfoList) {
        List<XScrollItemTypeInfo> list = this.itemTypeInfoList;
        if (list == null) {
            this.itemTypeInfoList = new ArrayList();
        } else {
            list.clear();
        }
        this.itemTypeInfoList.addAll(typeInfoList);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(final XScrollViewHolder holder, final int position) {
        AdapterItemViewListener adapterItemViewListener;
        XScrollItemData<T> xScrollItemData = this.itemDataList.get(position);
        if (xScrollItemData == null || (adapterItemViewListener = this.adapterItemViewListener) == null) {
            return;
        }
        adapterItemViewListener.onBindViewHolder(holder, position, xScrollItemData);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public XScrollViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        int iFindLayoutResIdByItemType = findLayoutResIdByItemType(viewType);
        if (iFindLayoutResIdByItemType != -1) {
            return new XScrollViewHolder(LayoutInflater.from(parent.getContext()).inflate(iFindLayoutResIdByItemType, parent, false));
        }
        return null;
    }
}
