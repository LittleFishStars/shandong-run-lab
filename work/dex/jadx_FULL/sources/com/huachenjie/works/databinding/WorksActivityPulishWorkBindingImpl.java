package com.huachenjie.works.databinding;

import android.graphics.drawable.Drawable;
import android.support.v4.media.session.PlaybackStateCompat;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.coroutines.DataBindingComponent;
import androidx.coroutines.InverseBindingListener;
import androidx.coroutines.ViewDataBinding;
import androidx.coroutines.adapters.ImageViewBindingAdapter;
import androidx.coroutines.adapters.TextViewBindingAdapter;
import androidx.p002lifecycle.LifecycleOwner;
import androidx.p002lifecycle.MutableLiveData;
import androidx.recyclerview.widget.RecyclerView;
import com.aliyun.vod.common.utils.FileUtils;
import com.huachenjie.common.R;
import com.huachenjie.common.bean.BindingTitleBean;
import com.huachenjie.common.binding_adapter.CommonBindingAdapter;
import com.huachenjie.common.databinding.LayoutToolbarBindingBinding;
import com.huachenjie.common.widget.DrawableCenterButton;
import com.huachenjie.common.widget.SelectBoldTabLayout;
import com.huachenjie.works.bean.RecommendWorksBean;
import com.huachenjie.works.bean.publish.PubWorkChannelBean;
import com.huachenjie.works.bean.publish.PubWorkLocationItemBean;
import com.huachenjie.works.page.publish.PublishWorkActivity;
import com.huachenjie.works.page.publish.PublishWorkTagAdapter;
import com.huachenjie.works.page.publish.PublishWorkViewModel;
import com.huachenjie.works.widget.PubWorkContentEditView;
import com.huachenjie.works.widget.select_media.SelectGridMediaView;
import com.zj.adlib.g89;
import com.zj.adlib.qk0;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class WorksActivityPulishWorkBindingImpl extends WorksActivityPulishWorkBinding {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public static final SparseIntArray f36796a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public static final ViewDataBinding.IncludedLayouts f13916a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f13917a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final EditText f13918a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final ImageView f13919a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final LinearLayout f13920a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final TextView f13921a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public InverseBindingListener f13922a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final LayoutToolbarBindingBinding f13923a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @NonNull
    public final DrawableCenterButton f13924a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public b f13925a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public c f13926a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public d f13927a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public e f13928a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public f f13929a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public g f13930a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public h f13931a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public i f13932a;

    @NonNull
    public final ImageView b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final LinearLayout f13933b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final TextView f13934b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @NonNull
    public final DrawableCenterButton f13935b;

    @NonNull
    public final ImageView c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final LinearLayout f13936c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @NonNull
    public final TextView f13937c;

    @NonNull
    public final LinearLayout d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    @NonNull
    public final TextView f13938d;

    @NonNull
    public final LinearLayout e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    @NonNull
    public final TextView f13939e;

    @NonNull
    public final LinearLayout f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    @NonNull
    public final TextView f13940f;

    @NonNull
    public final LinearLayout g;

    public class a implements InverseBindingListener {
        public a() {
        }

        @Override // androidx.coroutines.InverseBindingListener
        public void onChange() {
            String textString = TextViewBindingAdapter.getTextString(WorksActivityPulishWorkBindingImpl.this.f13918a);
            PublishWorkViewModel publishWorkViewModel = ((WorksActivityPulishWorkBinding) WorksActivityPulishWorkBindingImpl.this).f13913a;
            if (publishWorkViewModel != null) {
                MutableLiveData<String> mutableLiveDataE = publishWorkViewModel.E();
                if (mutableLiveDataE != null) {
                    mutableLiveDataE.setValue(textString);
                }
            }
        }
    }

    public static class b implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PublishWorkActivity.ClickProxy f36798a;

        public b a(PublishWorkActivity.ClickProxy value) {
            this.f36798a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36798a.i(arg0);
        }
    }

    public static class c implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PublishWorkActivity.ClickProxy f36799a;

        public c a(PublishWorkActivity.ClickProxy value) {
            this.f36799a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36799a.f(arg0);
        }
    }

    public static class d implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PublishWorkActivity.ClickProxy f36800a;

        public d a(PublishWorkActivity.ClickProxy value) {
            this.f36800a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36800a.c(arg0);
        }
    }

    public static class e implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PublishWorkActivity.ClickProxy f36801a;

        public e a(PublishWorkActivity.ClickProxy value) {
            this.f36801a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36801a.b(arg0);
        }
    }

    public static class f implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PublishWorkActivity.ClickProxy f36802a;

        public f a(PublishWorkActivity.ClickProxy value) {
            this.f36802a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36802a.g(arg0);
        }
    }

    public static class g implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PublishWorkActivity.ClickProxy f36803a;

        public g a(PublishWorkActivity.ClickProxy value) {
            this.f36803a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36803a.h(arg0);
        }
    }

    public static class h implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PublishWorkActivity.ClickProxy f36804a;

        public h a(PublishWorkActivity.ClickProxy value) {
            this.f36804a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36804a.j(arg0);
        }
    }

    public static class i implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public PublishWorkActivity.ClickProxy f36805a;

        public i a(PublishWorkActivity.ClickProxy value) {
            this.f36805a = value;
            if (value == null) {
                return null;
            }
            return this;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View arg0) {
            this.f36805a.d(arg0);
        }
    }

    static {
        ViewDataBinding.IncludedLayouts includedLayouts = new ViewDataBinding.IncludedLayouts(24);
        f13916a = includedLayouts;
        includedLayouts.setIncludes(0, new String[]{"layout_toolbar_binding"}, new int[]{20}, new int[]{R.layout.layout_toolbar_binding});
        SparseIntArray sparseIntArray = new SparseIntArray();
        f36796a = sparseIntArray;
        sparseIntArray.put(com.huachenjie.works.R.id.tab_layout, 21);
        sparseIntArray.put(com.huachenjie.works.R.id.et_content, 22);
        sparseIntArray.put(com.huachenjie.works.R.id.view_select_media, 23);
    }

    public WorksActivityPulishWorkBindingImpl(@Nullable DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, ViewDataBinding.mapBindings(bindingComponent, root, 24, f13916a, f36796a));
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0189  */
    /* JADX WARN: Code duplicated, block: B:16:0x0049  */
    /* JADX WARN: Code duplicated, block: B:25:0x0066  */
    @Override // androidx.coroutines.ViewDataBinding
    public void executeBindings() {
        long j;
        int colorFromResource;
        int i2;
        int colorFromResource2;
        String value;
        int iSafeUnbox;
        boolean z;
        String str;
        int colorFromResource3;
        boolean z2;
        String str2;
        BindingTitleBean value2;
        int i3;
        PublishWorkTagAdapter publishWorkTagAdapter;
        int i4;
        boolean z3;
        PubWorkChannelBean pubWorkChannelBean;
        PubWorkLocationItemBean value3;
        boolean z4;
        boolean z5;
        String str3;
        b bVar;
        f fVar;
        e eVar;
        i iVar;
        c cVar;
        d dVar;
        g gVar;
        h hVar;
        int i5;
        String string;
        Drawable drawable;
        Drawable drawable2;
        String str4;
        String string2;
        Drawable drawable3;
        PublishWorkTagAdapter value4;
        int colorFromResource4;
        boolean z6;
        int i6;
        int colorFromResource5;
        long j2;
        boolean z7;
        ImageView imageView;
        int i7;
        long j3;
        long j4;
        synchronized (this) {
            j = this.f13917a;
            this.f13917a = 0L;
        }
        PublishWorkViewModel publishWorkViewModel = ((WorksActivityPulishWorkBinding) this).f13913a;
        PublishWorkActivity.ClickProxy clickProxy = ((WorksActivityPulishWorkBinding) this).f13912a;
        if ((1535 & j) != 0) {
            if ((j & 1281) == 0) {
                value = null;
            } else {
                MutableLiveData<String> mutableLiveDataE = publishWorkViewModel != null ? publishWorkViewModel.E() : null;
                updateLiveDataRegistration(0, mutableLiveDataE);
                if (mutableLiveDataE != null) {
                    value = mutableLiveDataE.getValue();
                } else {
                    value = null;
                }
            }
            if ((j & 1282) == 0) {
                value4 = null;
            } else {
                MutableLiveData<PublishWorkTagAdapter> mutableLiveDataC = publishWorkViewModel != null ? publishWorkViewModel.C() : null;
                updateLiveDataRegistration(1, mutableLiveDataC);
                if (mutableLiveDataC != null) {
                    value4 = mutableLiveDataC.getValue();
                } else {
                    value4 = null;
                }
            }
            if ((j & 1284) != 0) {
                MutableLiveData<RecommendWorksBean> mutableLiveDataY = publishWorkViewModel != null ? publishWorkViewModel.y() : null;
                updateLiveDataRegistration(2, mutableLiveDataY);
                RecommendWorksBean value5 = mutableLiveDataY != null ? mutableLiveDataY.getValue() : null;
                str = String.format(this.f13921a.getResources().getString(com.huachenjie.works.R.string.works_publish_work_type), value5 != null ? value5.getCategoryName() : null);
            } else {
                str = null;
            }
            long j5 = j & 1288;
            if (j5 != 0) {
                MutableLiveData<Integer> mutableLiveDataX = publishWorkViewModel != null ? publishWorkViewModel.x() : null;
                updateLiveDataRegistration(3, mutableLiveDataX);
                iSafeUnbox = ViewDataBinding.safeUnbox(mutableLiveDataX != null ? mutableLiveDataX.getValue() : null);
                z2 = iSafeUnbox == 1;
                boolean z8 = iSafeUnbox > 1;
                if (j5 != 0) {
                    j = z2 ? j | PlaybackStateCompat.ACTION_PREPARE | PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH : j | 8192 | PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID;
                }
                if ((j & 1288) != 0) {
                    if (z8) {
                        j3 = j | 1048576;
                        j4 = FileUtils.ONE_GB;
                    } else {
                        j3 = j | PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED;
                        j4 = 536870912;
                    }
                    j = j3 | j4;
                }
                colorFromResource3 = ViewDataBinding.getColorFromResource(this.b, z8 ? com.huachenjie.works.R.color.color_main_v2 : com.huachenjie.works.R.color.color_2C3E50);
                colorFromResource4 = z8 ? ViewDataBinding.getColorFromResource(this.f13938d, com.huachenjie.works.R.color.color_main_v2) : ViewDataBinding.getColorFromResource(this.f13938d, com.huachenjie.works.R.color.color_2C3E50);
            } else {
                colorFromResource4 = 0;
                iSafeUnbox = 0;
                colorFromResource3 = 0;
                z2 = false;
            }
            if ((j & 1296) != 0) {
                MutableLiveData<ArrayList<String>> mutableLiveDataW = publishWorkViewModel != null ? publishWorkViewModel.w() : null;
                updateLiveDataRegistration(4, mutableLiveDataW);
                ArrayList<String> value6 = mutableLiveDataW != null ? mutableLiveDataW.getValue() : null;
                int size = value6 != null ? value6.size() : 0;
                str2 = String.format(this.f13937c.getResources().getString(com.huachenjie.works.R.string.works_publish_work_goods_size), Integer.valueOf(size));
                z6 = size > 0;
            } else {
                z6 = false;
                str2 = null;
            }
            if ((j & 1312) == 0) {
                value2 = null;
            } else {
                MutableLiveData<BindingTitleBean> mutableLiveDataD = publishWorkViewModel != null ? publishWorkViewModel.D() : null;
                updateLiveDataRegistration(5, mutableLiveDataD);
                if (mutableLiveDataD != null) {
                    value2 = mutableLiveDataD.getValue();
                } else {
                    value2 = null;
                }
            }
            long j6 = j & 1344;
            if (j6 != 0) {
                MutableLiveData<PubWorkLocationItemBean> mutableLiveDataB = publishWorkViewModel != null ? publishWorkViewModel.B() : null;
                updateLiveDataRegistration(6, mutableLiveDataB);
                value3 = mutableLiveDataB != null ? mutableLiveDataB.getValue() : null;
                boolean z9 = value3 != null;
                if (j6 != 0) {
                    j = z9 ? j | PlaybackStateCompat.ACTION_SET_PLAYBACK_SPEED | 16777216 | 17179869184L : j | 2097152 | 8388608 | g89.f;
                }
                int colorFromResource6 = z9 ? ViewDataBinding.getColorFromResource(this.f13934b, com.huachenjie.works.R.color.color_main_v2) : ViewDataBinding.getColorFromResource(this.f13934b, com.huachenjie.works.R.color.color_2C3E50);
                colorFromResource5 = ViewDataBinding.getColorFromResource(this.f13919a, z9 ? com.huachenjie.works.R.color.color_main_v2 : com.huachenjie.works.R.color.color_2C3E50);
                j2 = 1408;
                boolean z10 = z9;
                i6 = colorFromResource6;
                j = j;
                z7 = z10;
            } else {
                colorFromResource4 = colorFromResource4;
                z6 = z6;
                value3 = null;
                i6 = 0;
                colorFromResource5 = 0;
                j2 = 1408;
                z7 = false;
            }
            long j7 = j & j2;
            if (j7 != 0) {
                MutableLiveData<PubWorkChannelBean> mutableLiveDataA = publishWorkViewModel != null ? publishWorkViewModel.A() : null;
                updateLiveDataRegistration(7, mutableLiveDataA);
                PubWorkChannelBean value7 = mutableLiveDataA != null ? mutableLiveDataA.getValue() : null;
                boolean z11 = value7 == null;
                z4 = value7 != null;
                if (j7 != 0) {
                    j = z4 ? j | 4096 | 262144 | 268435456 : j | 2048 | 131072 | 134217728;
                }
                pubWorkChannelBean = value7;
                if (z4) {
                    imageView = this.c;
                    i7 = com.huachenjie.works.R.color.color_main_v2;
                } else {
                    imageView = this.c;
                    i7 = com.huachenjie.works.R.color.color_2C3E50;
                }
                colorFromResource = ViewDataBinding.getColorFromResource(imageView, i7);
                int i8 = i6;
                colorFromResource2 = ViewDataBinding.getColorFromResource(this.f13939e, z4 ? com.huachenjie.works.R.color.color_main_v2 : com.huachenjie.works.R.color.color_2C3E50);
                j = j;
                z5 = z7;
                z3 = z11;
                i2 = colorFromResource4;
                publishWorkTagAdapter = value4;
                z = z6;
                i4 = colorFromResource5;
                i3 = i8;
            } else {
                value3 = value3;
                i2 = colorFromResource4;
                z5 = z7;
                colorFromResource = 0;
                z3 = false;
                pubWorkChannelBean = null;
                z4 = false;
                publishWorkTagAdapter = value4;
                z = z6;
                i4 = colorFromResource5;
                i3 = i6;
                colorFromResource2 = 0;
            }
        } else {
            colorFromResource = 0;
            i2 = 0;
            colorFromResource2 = 0;
            value = null;
            iSafeUnbox = 0;
            z = false;
            str = null;
            colorFromResource3 = 0;
            z2 = false;
            str2 = null;
            value2 = null;
            i3 = 0;
            publishWorkTagAdapter = null;
            i4 = 0;
            z3 = false;
            pubWorkChannelBean = null;
            value3 = null;
            z4 = false;
            z5 = false;
        }
        if ((j & 1536) == 0 || clickProxy == null) {
            str3 = str2;
            bVar = null;
            fVar = null;
            eVar = null;
            iVar = null;
            cVar = null;
            dVar = null;
            gVar = null;
            hVar = null;
        } else {
            i iVar2 = this.f13932a;
            if (iVar2 == null) {
                iVar2 = new i();
                this.f13932a = iVar2;
            }
            i iVarA = iVar2.a(clickProxy);
            b bVar2 = this.f13925a;
            if (bVar2 == null) {
                bVar2 = new b();
                this.f13925a = bVar2;
            }
            b bVarA = bVar2.a(clickProxy);
            c cVar2 = this.f13926a;
            if (cVar2 == null) {
                cVar2 = new c();
                this.f13926a = cVar2;
            }
            c cVarA = cVar2.a(clickProxy);
            d dVar2 = this.f13927a;
            if (dVar2 == null) {
                dVar2 = new d();
                this.f13927a = dVar2;
            }
            d dVarA = dVar2.a(clickProxy);
            e eVar2 = this.f13928a;
            if (eVar2 == null) {
                eVar2 = new e();
                this.f13928a = eVar2;
            }
            e eVarA = eVar2.a(clickProxy);
            f fVar2 = this.f13929a;
            if (fVar2 == null) {
                fVar2 = new f();
                this.f13929a = fVar2;
            }
            f fVarA = fVar2.a(clickProxy);
            g gVar2 = this.f13930a;
            if (gVar2 == null) {
                gVar2 = new g();
                this.f13930a = gVar2;
            }
            g gVarA = gVar2.a(clickProxy);
            h hVar2 = this.f13931a;
            if (hVar2 == null) {
                hVar2 = new h();
                this.f13931a = hVar2;
            }
            h hVarA = hVar2.a(clickProxy);
            iVar = iVarA;
            bVar = bVarA;
            cVar = cVarA;
            fVar = fVarA;
            dVar = dVarA;
            gVar = gVarA;
            String str5 = str2;
            hVar = hVarA;
            eVar = eVarA;
            str3 = str5;
        }
        String subName = ((j & 17179869184L) == 0 || value3 == null) ? null : value3.getSubName();
        String title = ((j & 268435456) == 0 || pubWorkChannelBean == null) ? null : pubWorkChannelBean.getTitle();
        if ((j & 40960) != 0) {
            i5 = i3;
            boolean z12 = iSafeUnbox == 2;
            if ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID) != 0) {
                j |= z12 ? 67108864L : 33554432L;
            }
            if ((j & 8192) != 0) {
                j |= z12 ? 4294967296L : 2147483648L;
            }
            if ((j & PlaybackStateCompat.ACTION_PREPARE_FROM_MEDIA_ID) != 0) {
                drawable3 = AppCompatResources.getDrawable(this.b.getContext(), z12 ? com.huachenjie.works.R.drawable.works_ic_publish_permission_mine : com.huachenjie.works.R.drawable.works_ic_publish_permission_friend);
            } else {
                drawable3 = null;
            }
            if ((j & 8192) != 0) {
                drawable = drawable3;
                string = z12 ? this.f13938d.getResources().getString(com.huachenjie.works.R.string.works_publish_work_menu_permission_mine) : this.f13938d.getResources().getString(com.huachenjie.works.R.string.works_publish_work_menu_permission_friend);
                j = j;
            } else {
                drawable = drawable3;
                string = null;
            }
        } else {
            i5 = i3;
            string = null;
            drawable = null;
        }
        long j8 = j & 1288;
        if (j8 != 0) {
            if (z2) {
                string = this.f13938d.getResources().getString(com.huachenjie.works.R.string.works_publish_work_menu_permission_public);
            }
            if (z2) {
                drawable = AppCompatResources.getDrawable(this.b.getContext(), com.huachenjie.works.R.drawable.works_ic_publish_permission_public);
            }
            drawable2 = drawable;
        } else {
            string = null;
            drawable2 = null;
        }
        int i9 = ((1408 & j) > 0L ? 1 : ((1408 & j) == 0L ? 0 : -1));
        if (i9 != 0) {
            if (!z4) {
                title = this.f13939e.getResources().getString(com.huachenjie.works.R.string.works_publish_work_channel);
            }
            str4 = title;
        } else {
            string = string;
            i9 = i9;
            str4 = null;
        }
        long j9 = j & 1344;
        String str6 = str4;
        if (j9 != 0) {
            string2 = z5 ? subName : this.f13934b.getResources().getString(com.huachenjie.works.R.string.works_publish_work_location);
        } else {
            string2 = null;
        }
        if ((j & 1312) != 0) {
            this.f13923a.k(value2);
        }
        if ((j & 1284) != 0) {
            TextViewBindingAdapter.setText(this.f13921a, str);
        }
        if ((j & 1536) != 0) {
            CommonBindingAdapter.q(this.f13933b, iVar, null);
            CommonBindingAdapter.q(this.f13936c, eVar, null);
            CommonBindingAdapter.q(this.d, dVar, null);
            CommonBindingAdapter.q(this.f13924a, hVar, null);
            CommonBindingAdapter.q(this.f13935b, bVar, null);
            CommonBindingAdapter.q(this.e, cVar, null);
            CommonBindingAdapter.q(this.f, fVar, null);
            CommonBindingAdapter.q(this.g, gVar, null);
        }
        if (j9 != 0) {
            CommonBindingAdapter.Y(this.f13919a, Integer.valueOf(i4));
            TextViewBindingAdapter.setText(this.f13934b, string2);
            this.f13934b.setTextColor(i5);
        }
        if ((1296 & j) != 0) {
            CommonBindingAdapter.l0(this.f13937c, z);
            TextViewBindingAdapter.setText(this.f13937c, str3);
        }
        if (j8 != 0) {
            ImageViewBindingAdapter.setImageDrawable(this.b, drawable2);
            CommonBindingAdapter.Y(this.b, Integer.valueOf(colorFromResource3));
            TextViewBindingAdapter.setText(this.f13938d, string);
            this.f13938d.setTextColor(i2);
        }
        if ((j & 1281) != 0) {
            TextViewBindingAdapter.setText(this.f13918a, value);
        }
        if ((1024 & j) != 0) {
            TextViewBindingAdapter.setTextWatcher(this.f13918a, null, null, null, this.f13922a);
        }
        if (i9 != 0) {
            CommonBindingAdapter.Y(this.c, Integer.valueOf(colorFromResource));
            TextViewBindingAdapter.setText(this.f13939e, str6);
            this.f13939e.setTextColor(colorFromResource2);
            CommonBindingAdapter.l0(this.f13940f, z3);
        }
        if ((j & 1282) != 0) {
            CommonBindingAdapter.g(((WorksActivityPulishWorkBinding) this).f36795a, publishWorkTagAdapter, false, false);
        }
        ViewDataBinding.executeBindingsOn(this.f13923a);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            if (this.f13917a != 0) {
                return true;
            }
            return this.f13923a.hasPendingBindings();
        }
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.f13917a = 1024L;
        }
        this.f13923a.invalidateAll();
        requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksActivityPulishWorkBinding
    public void l(@Nullable PublishWorkActivity.ClickProxy Click) {
        ((WorksActivityPulishWorkBinding) this).f13912a = Click;
        synchronized (this) {
            this.f13917a |= 512;
        }
        notifyPropertyChanged(qk0.k);
        super.requestRebind();
    }

    @Override // com.huachenjie.works.databinding.WorksActivityPulishWorkBinding
    public void m(@Nullable PublishWorkViewModel Vm) {
        ((WorksActivityPulishWorkBinding) this).f13913a = Vm;
        synchronized (this) {
            this.f13917a |= 256;
        }
        notifyPropertyChanged(qk0.p0);
        super.requestRebind();
    }

    public final boolean o(MutableLiveData<ArrayList<String>> VmGoodsListBean, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13917a |= 16;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
            case 0:
                return v((MutableLiveData) object, fieldId);
            case 1:
                return t((MutableLiveData) object, fieldId);
            case 2:
                return q((MutableLiveData) object, fieldId);
            case 3:
                return p((MutableLiveData) object, fieldId);
            case 4:
                return o((MutableLiveData) object, fieldId);
            case 5:
                return u((MutableLiveData) object, fieldId);
            case 6:
                return s((MutableLiveData) object, fieldId);
            case 7:
                return r((MutableLiveData) object, fieldId);
            default:
                return false;
        }
    }

    public final boolean p(MutableLiveData<Integer> VmPermissionType, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13917a |= 8;
        }
        return true;
    }

    public final boolean q(MutableLiveData<RecommendWorksBean> VmSelCategory, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13917a |= 4;
        }
        return true;
    }

    public final boolean r(MutableLiveData<PubWorkChannelBean> VmSelectChannel, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13917a |= 128;
        }
        return true;
    }

    public final boolean s(MutableLiveData<PubWorkLocationItemBean> VmSelectLocation, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13917a |= 64;
        }
        return true;
    }

    @Override // androidx.coroutines.ViewDataBinding
    public void setLifecycleOwner(@Nullable LifecycleOwner lifecycleOwner) {
        super.setLifecycleOwner(lifecycleOwner);
        this.f13923a.setLifecycleOwner(lifecycleOwner);
    }

    @Override // androidx.coroutines.ViewDataBinding
    public boolean setVariable(int variableId, @Nullable Object variable) {
        if (qk0.p0 == variableId) {
            m((PublishWorkViewModel) variable);
        } else {
            if (qk0.k != variableId) {
                return false;
            }
            l((PublishWorkActivity.ClickProxy) variable);
        }
        return true;
    }

    public final boolean t(MutableLiveData<PublishWorkTagAdapter> VmTagAdapter, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13917a |= 2;
        }
        return true;
    }

    public final boolean u(MutableLiveData<BindingTitleBean> VmTitleBean, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13917a |= 32;
        }
        return true;
    }

    public final boolean v(MutableLiveData<String> VmTitleData, int fieldId) {
        if (fieldId != qk0.f44227a) {
            return false;
        }
        synchronized (this) {
            this.f13917a |= 1;
        }
        return true;
    }

    /* JADX WARN: Type inference failed for: r9v37, types: [android.view.View, com.huachenjie.common.widget.DrawableCenterButton] */
    /* JADX WARN: Type inference failed for: r9v40, types: [android.view.View, com.huachenjie.common.widget.DrawableCenterButton] */
    public WorksActivityPulishWorkBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 8, (PubWorkContentEditView) bindings[22], (RecyclerView) bindings[2], (SelectBoldTabLayout) bindings[21], (SelectGridMediaView) bindings[23]);
        this.f13922a = new a();
        this.f13917a = -1L;
        LayoutToolbarBindingBinding layoutToolbarBindingBinding = (LayoutToolbarBindingBinding) bindings[20];
        this.f13923a = layoutToolbarBindingBinding;
        setContainedBinding(layoutToolbarBindingBinding);
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.f13920a = linearLayout;
        linearLayout.setTag(null);
        TextView textView = (TextView) bindings[1];
        this.f13921a = textView;
        textView.setTag(null);
        LinearLayout linearLayout2 = (LinearLayout) bindings[10];
        this.f13933b = linearLayout2;
        linearLayout2.setTag(null);
        ImageView imageView = (ImageView) bindings[11];
        this.f13919a = imageView;
        imageView.setTag(null);
        TextView textView2 = (TextView) bindings[12];
        this.f13934b = textView2;
        textView2.setTag(null);
        LinearLayout linearLayout3 = (LinearLayout) bindings[13];
        this.f13936c = linearLayout3;
        linearLayout3.setTag(null);
        TextView textView3 = (TextView) bindings[14];
        this.f13937c = textView3;
        textView3.setTag(null);
        LinearLayout linearLayout4 = (LinearLayout) bindings[15];
        this.d = linearLayout4;
        linearLayout4.setTag(null);
        ImageView imageView2 = (ImageView) bindings[16];
        this.b = imageView2;
        imageView2.setTag(null);
        TextView textView4 = (TextView) bindings[17];
        this.f13938d = textView4;
        textView4.setTag(null);
        ?? r9 = (DrawableCenterButton) bindings[18];
        this.f13924a = r9;
        r9.setTag(null);
        ?? r10 = (DrawableCenterButton) bindings[19];
        this.f13935b = r10;
        r10.setTag(null);
        EditText editText = (EditText) bindings[3];
        this.f13918a = editText;
        editText.setTag(null);
        LinearLayout linearLayout5 = (LinearLayout) bindings[4];
        this.e = linearLayout5;
        linearLayout5.setTag(null);
        ImageView imageView3 = (ImageView) bindings[5];
        this.c = imageView3;
        imageView3.setTag(null);
        TextView textView5 = (TextView) bindings[6];
        this.f13939e = textView5;
        textView5.setTag(null);
        TextView textView6 = (TextView) bindings[7];
        this.f13940f = textView6;
        textView6.setTag(null);
        LinearLayout linearLayout6 = (LinearLayout) bindings[8];
        this.f = linearLayout6;
        linearLayout6.setTag(null);
        LinearLayout linearLayout7 = (LinearLayout) bindings[9];
        this.g = linearLayout7;
        linearLayout7.setTag(null);
        ((WorksActivityPulishWorkBinding) this).f36795a.setTag(null);
        setRootTag(root);
        invalidateAll();
    }
}
