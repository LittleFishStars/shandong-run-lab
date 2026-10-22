package com.zj.adlib;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AutoCompleteTextView;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.amap.api.col.p0003l.eq;
import com.amap.api.maps.offlinemap.DownLoadExpandListView;
import com.amap.api.maps.offlinemap.OfflineMapCity;
import com.amap.api.maps.offlinemap.OfflineMapManager;
import com.amap.api.maps.offlinemap.OfflineMapProvince;
import com.huachenjie.shandong_school.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class k1b extends com.amap.api.offlineservice.a implements TextWatcher, View.OnTouchListener, AbsListView.OnScrollListener, OfflineMapManager.OfflineLoadedListener, OfflineMapManager.OfflineMapDownloadListener {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AutoCompleteTextView f17539a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ExpandableListView f17540a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ImageView f17541a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ListView f17542a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public RelativeLayout f17543a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public eq f17544a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public DownLoadExpandListView f17545a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e1b f17547a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public f1b f17548a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public h1b f17549a;
    public ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public RelativeLayout f17552b;
    public ImageView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public RelativeLayout f17554c;
    public ImageView d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public RelativeLayout f17556d;
    public ImageView e;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public List<OfflineMapProvince> f17550a = new ArrayList();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public OfflineMapManager f17546a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f17551a = true;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f17553b = true;
    public int K = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f42721a = 0;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f17555c = true;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View view) {
            try {
                k1b.this.f17539a.setText("");
                k1b.this.d.setVisibility(8);
                k1b.this.k(false);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) k1b.this.e.getLayoutParams();
                layoutParams.leftMargin = k1b.this.a(95.0f);
                k1b.this.e.setLayoutParams(layoutParams);
                k1b.this.f17539a.setPadding(k1b.this.a(105.0f), 0, 0, 0);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public class b implements Comparator<OfflineMapCity> {
        public b() {
        }

        public static int a(OfflineMapCity offlineMapCity, OfflineMapCity offlineMapCity2) {
            char[] charArray = offlineMapCity.getJianpin().toCharArray();
            char[] charArray2 = offlineMapCity2.getJianpin().toCharArray();
            return (charArray[0] >= charArray2[0] && charArray[1] >= charArray2[1]) ? 0 : 1;
        }

        @Override // java.util.Comparator
        public final /* synthetic */ int compare(OfflineMapCity offlineMapCity, OfflineMapCity offlineMapCity2) {
            return a(offlineMapCity, offlineMapCity2);
        }
    }

    @Override // android.text.TextWatcher
    public final void afterTextChanged(Editable editable) {
    }

    @Override // android.text.TextWatcher
    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override // com.amap.api.offlineservice.a
    public final void c(View view) {
        try {
            int id = view.getId();
            if (id == 2131165205) {
                ((com.amap.api.offlineservice.a) this).f26157a.closeScr();
                return;
            }
            if (id == 2131165184) {
                if (this.f17553b) {
                    this.f17545a.setVisibility(8);
                    this.b.setBackgroundResource(2130837508);
                    this.f17553b = false;
                    return;
                } else {
                    this.f17545a.setVisibility(0);
                    this.b.setBackgroundResource(2130837504);
                    this.f17553b = true;
                    return;
                }
            }
            if (id == 2131165189) {
                if (this.f17551a) {
                    this.f17548a.c();
                    this.c.setBackgroundResource(2130837508);
                    this.f17551a = false;
                } else {
                    this.f17548a.a();
                    this.c.setBackgroundResource(2130837504);
                    this.f17551a = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // com.amap.api.offlineservice.a
    public final void e() {
        View viewD = q1b.d(((com.amap.api.offlineservice.a) this).f26157a, R.array.attendance_title);
        DownLoadExpandListView downLoadExpandListView = (DownLoadExpandListView) viewD.findViewById(2131165187);
        this.f17545a = downLoadExpandListView;
        downLoadExpandListView.setOnTouchListener(this);
        this.f17552b = (RelativeLayout) viewD.findViewById(2131165184);
        this.b = (ImageView) viewD.findViewById(2131165186);
        this.f17552b.setOnClickListener(((com.amap.api.offlineservice.a) this).f26157a);
        this.f17554c = (RelativeLayout) viewD.findViewById(2131165189);
        this.c = (ImageView) viewD.findViewById(2131165190);
        this.f17554c.setOnClickListener(((com.amap.api.offlineservice.a) this).f26157a);
        this.f17556d = (RelativeLayout) viewD.findViewById(2131165188);
        ImageView imageView = (ImageView) this.f17543a.findViewById(2131165205);
        this.f17541a = imageView;
        imageView.setOnClickListener(((com.amap.api.offlineservice.a) this).f26157a);
        this.e = (ImageView) this.f17543a.findViewById(2131165207);
        ImageView imageView2 = (ImageView) this.f17543a.findViewById(2131165209);
        this.d = imageView2;
        imageView2.setOnClickListener(new a());
        this.f17543a.findViewById(2131165210).setOnTouchListener(this);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) this.f17543a.findViewById(2131165208);
        this.f17539a = autoCompleteTextView;
        autoCompleteTextView.addTextChangedListener(this);
        this.f17539a.setOnTouchListener(this);
        this.f17542a = (ListView) this.f17543a.findViewById(2131165212);
        ExpandableListView expandableListView = (ExpandableListView) this.f17543a.findViewById(2131165211);
        this.f17540a = expandableListView;
        expandableListView.addHeaderView(viewD);
        this.f17540a.setOnTouchListener(this);
        this.f17540a.setOnScrollListener(this);
        try {
            OfflineMapManager offlineMapManager = new OfflineMapManager(((com.amap.api.offlineservice.a) this).f26157a, this);
            this.f17546a = offlineMapManager;
            offlineMapManager.setOnOfflineLoadedListener(this);
        } catch (Exception e) {
            Log.e("OfflineMapPage", "e=".concat(String.valueOf(e)));
        }
        q();
        f1b f1bVar = new f1b(this.f17550a, this.f17546a, ((com.amap.api.offlineservice.a) this).f26157a);
        this.f17548a = f1bVar;
        this.f17540a.setAdapter(f1bVar);
        this.f17540a.setOnGroupCollapseListener(this.f17548a);
        this.f17540a.setOnGroupExpandListener(this.f17548a);
        this.f17540a.setGroupIndicator(null);
        if (this.f17551a) {
            this.c.setBackgroundResource(2130837504);
            this.f17540a.setVisibility(0);
        } else {
            this.c.setBackgroundResource(2130837508);
            this.f17540a.setVisibility(8);
        }
        if (this.f17553b) {
            this.b.setBackgroundResource(2130837504);
            this.f17545a.setVisibility(0);
        } else {
            this.b.setBackgroundResource(2130837508);
            this.f17545a.setVisibility(8);
        }
    }

    @Override // com.amap.api.offlineservice.a
    public final boolean f() {
        try {
            if (this.f17542a.getVisibility() == 0) {
                this.f17539a.setText("");
                this.d.setVisibility(8);
                k(false);
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.f();
    }

    @Override // com.amap.api.offlineservice.a
    public final RelativeLayout g() {
        if (this.f17543a == null) {
            this.f17543a = (RelativeLayout) q1b.d(((com.amap.api.offlineservice.a) this).f26157a, 2130903044);
        }
        return this.f17543a;
    }

    @Override // com.amap.api.offlineservice.a
    public final void h() {
        this.f17546a.destroy();
    }

    public final void j(OfflineMapCity offlineMapCity) {
        try {
            if (this.f17544a == null) {
                this.f17544a = new eq(((com.amap.api.offlineservice.a) this).f26157a, this.f17546a);
            }
            this.f17544a.a(offlineMapCity.getState(), offlineMapCity.getCity());
            this.f17544a.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void k(boolean z) {
        if (z) {
            this.f17552b.setVisibility(8);
            this.f17554c.setVisibility(8);
            this.f17545a.setVisibility(8);
            this.f17540a.setVisibility(8);
            this.f17556d.setVisibility(8);
            this.f17542a.setVisibility(0);
            return;
        }
        this.f17552b.setVisibility(0);
        this.f17554c.setVisibility(0);
        this.f17556d.setVisibility(0);
        this.f17545a.setVisibility(this.f17553b ? 0 : 8);
        this.f17540a.setVisibility(this.f17551a ? 0 : 8);
        this.f17542a.setVisibility(8);
    }

    public final void n() {
        try {
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.e.getLayoutParams();
            layoutParams.leftMargin = a(18.0f);
            this.e.setLayoutParams(layoutParams);
            this.f17539a.setPadding(a(30.0f), 0, 0, 0);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void o() {
        q();
        h1b h1bVar = new h1b(this.f17546a, ((com.amap.api.offlineservice.a) this).f26157a);
        this.f17549a = h1bVar;
        this.f17542a.setAdapter((ListAdapter) h1bVar);
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener
    public final void onCheckUpdate(boolean z, String str) {
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener
    public final void onDownload(int i, int i2, String str) {
        if (i == 101) {
            try {
                Toast.makeText(((com.amap.api.offlineservice.a) this).f26157a, "网络异常", 0).show();
                this.f17546a.pause();
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }
        if (i == 2) {
            this.f17547a.b();
        }
        if (this.K == i) {
            if (System.currentTimeMillis() - this.f42721a > 1200) {
                if (this.f17555c) {
                    this.f17547a.notifyDataSetChanged();
                }
                this.f42721a = System.currentTimeMillis();
                return;
            }
            return;
        }
        f1b f1bVar = this.f17548a;
        if (f1bVar != null) {
            f1bVar.notifyDataSetChanged();
        }
        e1b e1bVar = this.f17547a;
        if (e1bVar != null) {
            e1bVar.notifyDataSetChanged();
        }
        h1b h1bVar = this.f17549a;
        if (h1bVar != null) {
            h1bVar.notifyDataSetChanged();
        }
        this.K = i;
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineMapDownloadListener
    public final void onRemove(boolean z, String str, String str2) {
        e1b e1bVar = this.f17547a;
        if (e1bVar != null) {
            e1bVar.c();
        }
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public final void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 2) {
            this.f17555c = false;
        } else {
            this.f17555c = true;
        }
    }

    @Override // android.text.TextWatcher
    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (TextUtils.isEmpty(charSequence)) {
            k(false);
            this.d.setVisibility(8);
            return;
        }
        this.d.setVisibility(0);
        ArrayList arrayList = new ArrayList();
        List<OfflineMapProvince> list = this.f17550a;
        if (list != null && list.size() > 0) {
            ArrayList<OfflineMapCity> arrayList2 = new ArrayList();
            Iterator<OfflineMapProvince> it = this.f17550a.iterator();
            while (it.hasNext()) {
                arrayList2.addAll(it.next().getCityList());
            }
            for (OfflineMapCity offlineMapCity : arrayList2) {
                String city = offlineMapCity.getCity();
                String pinyin = offlineMapCity.getPinyin();
                String jianpin = offlineMapCity.getJianpin();
                if (charSequence.length() == 1) {
                    if (jianpin.startsWith(String.valueOf(charSequence))) {
                        arrayList.add(offlineMapCity);
                    }
                } else if (jianpin.startsWith(String.valueOf(charSequence)) || pinyin.startsWith(String.valueOf(charSequence)) || city.startsWith(String.valueOf(charSequence))) {
                    arrayList.add(offlineMapCity);
                }
            }
        }
        if (arrayList.size() <= 0) {
            Toast.makeText(((com.amap.api.offlineservice.a) this).f26157a, "未找到相关城市", 0).show();
            return;
        }
        k(true);
        Collections.sort(arrayList, new b());
        h1b h1bVar = this.f17549a;
        if (h1bVar != null) {
            h1bVar.b(arrayList);
            this.f17549a.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnTouchListener
    public final boolean onTouch(View view, MotionEvent motionEvent) {
        r();
        if (view.getId() != 2131165208) {
            return false;
        }
        n();
        return false;
    }

    @Override // com.amap.api.maps.offlinemap.OfflineMapManager.OfflineLoadedListener
    public final void onVerifyComplete() {
        o();
        p();
    }

    public final void p() {
        e1b e1bVar = new e1b(((com.amap.api.offlineservice.a) this).f26157a, this, this.f17546a, this.f17550a);
        this.f17547a = e1bVar;
        this.f17545a.setAdapter(e1bVar);
        this.f17547a.notifyDataSetChanged();
    }

    public final void q() {
        ArrayList<OfflineMapProvince> offlineMapProvinceList = this.f17546a.getOfflineMapProvinceList();
        this.f17550a.clear();
        this.f17550a.add(null);
        ArrayList<OfflineMapCity> arrayList = new ArrayList<>();
        ArrayList<OfflineMapCity> arrayList2 = new ArrayList<>();
        ArrayList<OfflineMapCity> arrayList3 = new ArrayList<>();
        for (int i = 0; i < offlineMapProvinceList.size(); i++) {
            OfflineMapProvince offlineMapProvince = offlineMapProvinceList.get(i);
            if (offlineMapProvince.getCityList().size() != 1) {
                this.f17550a.add(i + 1, offlineMapProvince);
            } else {
                String provinceName = offlineMapProvince.getProvinceName();
                if (provinceName.contains("香港")) {
                    arrayList2.addAll(offlineMapProvince.getCityList());
                } else if (provinceName.contains("澳门")) {
                    arrayList2.addAll(offlineMapProvince.getCityList());
                } else if (provinceName.contains("全国概要图")) {
                    arrayList3.addAll(0, offlineMapProvince.getCityList());
                } else {
                    arrayList3.addAll(offlineMapProvince.getCityList());
                }
            }
        }
        OfflineMapProvince offlineMapProvince2 = new OfflineMapProvince();
        offlineMapProvince2.setProvinceName("基本功能包+直辖市");
        offlineMapProvince2.setCityList(arrayList3);
        this.f17550a.set(0, offlineMapProvince2);
        OfflineMapProvince offlineMapProvince3 = new OfflineMapProvince();
        offlineMapProvince3.setProvinceName("直辖市");
        offlineMapProvince3.setCityList(arrayList);
        OfflineMapProvince offlineMapProvince4 = new OfflineMapProvince();
        offlineMapProvince4.setProvinceName("港澳");
        offlineMapProvince4.setCityList(arrayList2);
        this.f17550a.add(offlineMapProvince4);
    }

    public final void r() {
        AutoCompleteTextView autoCompleteTextView = this.f17539a;
        if (autoCompleteTextView == null || !autoCompleteTextView.isFocused()) {
            return;
        }
        this.f17539a.clearFocus();
        InputMethodManager inputMethodManager = (InputMethodManager) ((com.amap.api.offlineservice.a) this).f26157a.getSystemService("input_method");
        if (inputMethodManager != null ? inputMethodManager.isActive() : false) {
            inputMethodManager.hideSoftInputFromWindow(this.f17539a.getWindowToken(), 2);
        }
    }
}
