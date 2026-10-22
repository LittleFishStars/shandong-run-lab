package androidx.coroutines;

import android.util.Log;
import android.view.View;
import androidx.annotation.RestrictTo;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class MergedDataBinderMapper extends DataBinderMapper {
    private static final String TAG = "MergedDataBinderMapper";
    private Set<Class<? extends DataBinderMapper>> mExistingMappers = new HashSet();
    private List<DataBinderMapper> mMappers = new CopyOnWriteArrayList();
    private List<String> mFeatureBindingMappers = new CopyOnWriteArrayList();

    private boolean loadFeatures() {
        boolean z = false;
        for (String str : this.mFeatureBindingMappers) {
            try {
                Class<?> cls = Class.forName(str);
                if (DataBinderMapper.class.isAssignableFrom(cls)) {
                    addMapper((DataBinderMapper) cls.newInstance());
                    this.mFeatureBindingMappers.remove(str);
                    z = true;
                }
            } catch (ClassNotFoundException unused) {
            } catch (IllegalAccessException e) {
                Log.e(TAG, "unable to add feature mapper for " + str, e);
            } catch (InstantiationException e2) {
                Log.e(TAG, "unable to add feature mapper for " + str, e2);
            }
        }
        return z;
    }

    public void addMapper(DataBinderMapper dataBinderMapper) {
        if (this.mExistingMappers.add((Class<? extends DataBinderMapper>) dataBinderMapper.getClass())) {
            this.mMappers.add(dataBinderMapper);
            Iterator<DataBinderMapper> it = dataBinderMapper.collectDependencies().iterator();
            while (it.hasNext()) {
                addMapper(it.next());
            }
        }
    }

    @Override // androidx.coroutines.DataBinderMapper
    public String convertBrIdToString(int i) {
        Iterator<DataBinderMapper> it = this.mMappers.iterator();
        while (it.hasNext()) {
            String strConvertBrIdToString = it.next().convertBrIdToString(i);
            if (strConvertBrIdToString != null) {
                return strConvertBrIdToString;
            }
        }
        if (loadFeatures()) {
            return convertBrIdToString(i);
        }
        return null;
    }

    @Override // androidx.coroutines.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View view, int i) {
        Iterator<DataBinderMapper> it = this.mMappers.iterator();
        while (it.hasNext()) {
            ViewDataBinding dataBinder = it.next().getDataBinder(dataBindingComponent, view, i);
            if (dataBinder != null) {
                return dataBinder;
            }
        }
        if (loadFeatures()) {
            return getDataBinder(dataBindingComponent, view, i);
        }
        return null;
    }

    @Override // androidx.coroutines.DataBinderMapper
    public int getLayoutId(String str) {
        Iterator<DataBinderMapper> it = this.mMappers.iterator();
        while (it.hasNext()) {
            int layoutId = it.next().getLayoutId(str);
            if (layoutId != 0) {
                return layoutId;
            }
        }
        if (loadFeatures()) {
            return getLayoutId(str);
        }
        return 0;
    }

    @Override // androidx.coroutines.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent dataBindingComponent, View[] viewArr, int i) {
        Iterator<DataBinderMapper> it = this.mMappers.iterator();
        while (it.hasNext()) {
            ViewDataBinding dataBinder = it.next().getDataBinder(dataBindingComponent, viewArr, i);
            if (dataBinder != null) {
                return dataBinder;
            }
        }
        if (loadFeatures()) {
            return getDataBinder(dataBindingComponent, viewArr, i);
        }
        return null;
    }

    public void addMapper(String str) {
        this.mFeatureBindingMappers.add(str + ".DataBinderMapperImpl");
    }
}
