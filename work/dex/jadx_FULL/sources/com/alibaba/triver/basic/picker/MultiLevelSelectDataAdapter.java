package com.alibaba.triver.basic.picker;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.basic.api.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MultiLevelSelectDataAdapter extends RecyclerView.Adapter<MultiLevelSelectDataViewHolder> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private JSONArray f24712a;
    private a b;

    public class MultiLevelSelectDataViewHolder extends RecyclerView.ViewHolder {
        private TextView b;
        private JSONObject c;

        public MultiLevelSelectDataViewHolder(@NonNull View view) {
            super(view);
            this.b = (TextView) view.findViewById(R.id.multilSelectTextContent_item_data);
            view.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.triver.basic.picker.MultiLevelSelectDataAdapter.MultiLevelSelectDataViewHolder.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (MultiLevelSelectDataAdapter.this.b != null) {
                        MultiLevelSelectDataAdapter.this.b.a(MultiLevelSelectDataViewHolder.this.c);
                    }
                }
            });
        }

        public void a(int i) {
            if (MultiLevelSelectDataAdapter.this.f24712a == null) {
                a();
                return;
            }
            JSONObject jSONObject = MultiLevelSelectDataAdapter.this.f24712a.getJSONObject(i);
            if (jSONObject == null) {
                a();
            } else {
                a(jSONObject.getString("name"));
                this.c = jSONObject;
            }
        }

        private void a() {
            TextView textView = this.b;
            if (textView != null) {
                textView.setText("");
            }
        }

        private void a(String str) {
            TextView textView = this.b;
            if (textView != null) {
                textView.setText(str);
            }
        }
    }

    public interface a {
        void a(JSONObject jSONObject);
    }

    public MultiLevelSelectDataAdapter(JSONArray jSONArray) {
        this.f24712a = jSONArray;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        JSONArray jSONArray = this.f24712a;
        if (jSONArray == null) {
            return 0;
        }
        return jSONArray.size();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NonNull
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public MultiLevelSelectDataViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MultiLevelSelectDataViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.view_multilevelselect_picker_recycleview_item, viewGroup, false));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public void onBindViewHolder(@NonNull MultiLevelSelectDataViewHolder multiLevelSelectDataViewHolder, int i) {
        multiLevelSelectDataViewHolder.a(i);
    }

    public void a(a aVar) {
        this.b = aVar;
    }
}
