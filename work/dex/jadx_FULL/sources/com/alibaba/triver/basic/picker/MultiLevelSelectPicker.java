package com.alibaba.triver.basic.picker;

import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.triver.basic.api.R;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class MultiLevelSelectPicker {

    public static class MultiLevelSelectDialog extends DialogFragment {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final String f24715a = "name";
        private static final String b = "subList";
        private String c;
        private JSONArray d;
        private View e;
        private RecyclerView f;
        private TextView g;
        private LinearLayout h;
        private b j;
        private ArrayList<JSONObject> i = new ArrayList<>();
        private boolean k = false;
        private MultiLevelSelectDataAdapter.a l = new MultiLevelSelectDataAdapter.a() { // from class: com.alibaba.triver.basic.picker.MultiLevelSelectPicker.MultiLevelSelectDialog.1
            @Override // com.alibaba.triver.basic.picker.MultiLevelSelectDataAdapter.a
            public void a(JSONObject jSONObject) {
                if (MultiLevelSelectDialog.this.a(jSONObject)) {
                    MultiLevelSelectDialog.this.c(jSONObject);
                    return;
                }
                MultiLevelSelectDialog.this.i.add(jSONObject);
                if (MultiLevelSelectDialog.this.j != null) {
                    MultiLevelSelectDialog.this.j.a(MultiLevelSelectDialog.this.i);
                    MultiLevelSelectDialog.this.k = true;
                    MultiLevelSelectDialog.this.dismiss();
                }
            }
        };

        public class a extends FrameLayout {
            private TextView b;
            private JSONObject c;

            public a(Context context) {
                super(context);
                a(context);
            }

            private void a(Context context) {
                View.inflate(context, R.layout.view_multilevelselect_picker_content_text, this);
                this.b = (TextView) findViewById(R.id.multilSelectTextContent_data);
            }

            public JSONObject getJsonObject() {
                return this.c;
            }

            public void setJsonObject(JSONObject jSONObject) {
                TextView textView;
                this.c = jSONObject;
                if (jSONObject == null || (textView = this.b) == null) {
                    return;
                }
                textView.setText(jSONObject.getString("name"));
            }
        }

        public interface b {
            void a();

            void a(ArrayList<JSONObject> arrayList);
        }

        @Override // android.app.DialogFragment, android.app.Fragment
        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            setStyle(1, android.R.style.Theme.Holo.Light.Dialog.MinWidth);
        }

        @Override // android.app.Fragment
        @Nullable
        public View onCreateView(LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, Bundle bundle) {
            View viewInflate = layoutInflater.inflate(R.layout.view_multilevelselect_picker, viewGroup, false);
            this.e = viewInflate;
            this.f = (RecyclerView) viewInflate.findViewById(R.id.multilSelectData);
            this.h = (LinearLayout) this.e.findViewById(R.id.multilSelectTextContent);
            TextView textView = (TextView) this.e.findViewById(R.id.multilSelectTitle);
            this.g = textView;
            textView.setText(this.c);
            MultiLevelSelectDataAdapter multiLevelSelectDataAdapter = new MultiLevelSelectDataAdapter(this.d);
            multiLevelSelectDataAdapter.a(this.l);
            this.f.setLayoutManager(new LinearLayoutManager(layoutInflater.getContext()));
            this.f.setAdapter(multiLevelSelectDataAdapter);
            return viewInflate;
        }

        @Override // android.app.DialogFragment, android.content.DialogInterface.OnDismissListener
        public void onDismiss(DialogInterface dialogInterface) {
            b bVar;
            super.onDismiss(dialogInterface);
            if (this.k || (bVar = this.j) == null) {
                return;
            }
            bVar.a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void c(JSONObject jSONObject) {
            this.i.add(jSONObject);
            a();
        }

        public JSONArray b(JSONObject jSONObject) {
            if (jSONObject == null) {
                return null;
            }
            return jSONObject.getJSONArray(b);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void b() {
            MultiLevelSelectDataAdapter multiLevelSelectDataAdapter = new MultiLevelSelectDataAdapter(this.d);
            multiLevelSelectDataAdapter.a(this.l);
            this.f.setAdapter(multiLevelSelectDataAdapter);
        }

        public boolean a(JSONObject jSONObject) {
            JSONArray jSONArray;
            return (jSONObject == null || (jSONArray = jSONObject.getJSONArray(b)) == null || jSONArray.size() <= 0) ? false : true;
        }

        public void a(JSONArray jSONArray) {
            this.d = jSONArray;
        }

        public void a(String str) {
            this.c = str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            if (this.i == null) {
                return;
            }
            this.h.removeAllViews();
            for (JSONObject jSONObject : this.i) {
                a aVar = new a(getActivity());
                aVar.setJsonObject(jSONObject);
                this.h.addView(aVar);
                aVar.setOnClickListener(new View.OnClickListener() { // from class: com.alibaba.triver.basic.picker.MultiLevelSelectPicker.MultiLevelSelectDialog.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        if (MultiLevelSelectDialog.this.h.getChildCount() == 0) {
                            return;
                        }
                        if (view.equals(MultiLevelSelectDialog.this.h.getChildAt(0))) {
                            if (view instanceof a) {
                                MultiLevelSelectDialog.this.i.clear();
                                MultiLevelSelectDialog.this.b();
                                MultiLevelSelectDialog.this.a();
                                return;
                            }
                            return;
                        }
                        if (view instanceof a) {
                            int size = MultiLevelSelectDialog.this.i.size();
                            ArrayList arrayList = new ArrayList();
                            for (int iIndexOf = MultiLevelSelectDialog.this.i.indexOf(((a) view).getJsonObject()); iIndexOf < size; iIndexOf++) {
                                arrayList.add(MultiLevelSelectDialog.this.i.get(iIndexOf));
                            }
                            MultiLevelSelectDialog.this.i.removeAll(arrayList);
                            if (MultiLevelSelectDialog.this.i.size() == 0) {
                                MultiLevelSelectDialog.this.b();
                            }
                            MultiLevelSelectDialog.this.a();
                        }
                    }
                });
            }
            if (this.i.size() > 0) {
                ArrayList<JSONObject> arrayList = this.i;
                JSONObject jSONObject2 = arrayList.get(arrayList.size() - 1);
                if (!a(jSONObject2)) {
                    b bVar = this.j;
                    if (bVar != null) {
                        bVar.a(this.i);
                        dismiss();
                        return;
                    }
                    return;
                }
                MultiLevelSelectDataAdapter multiLevelSelectDataAdapter = new MultiLevelSelectDataAdapter(b(jSONObject2));
                this.f.setAdapter(multiLevelSelectDataAdapter);
                multiLevelSelectDataAdapter.a(this.l);
            }
        }

        public void a(b bVar) {
            this.j = bVar;
        }
    }
}
