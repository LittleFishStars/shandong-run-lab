package com.google.firebase.components;

import android.util.Log;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import com.google.firebase.dynamicloading.ComponentLoader;
import com.google.firebase.events.Publisher;
import com.google.firebase.events.Subscriber;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import com.zj.adlib.ay6;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class ComponentRuntime extends AbstractComponentContainer implements ComponentLoader {
    private static final Provider<Set<Object>> EMPTY_PROVIDER = ComponentRuntime$$Lambda$5.instance;
    private final Map<Component<?>, Provider<?>> components;
    private final AtomicReference<Boolean> eagerComponentsInitializedWith;
    private final EventBus eventBus;
    private final Map<Class<?>, Provider<?>> lazyInstanceMap;
    private final Map<Class<?>, LazySet<?>> lazySetMap;
    private final List<Provider<ComponentRegistrar>> unprocessedRegistrarProviders;

    public static final class Builder {
        private final Executor defaultExecutor;
        private final List<Provider<ComponentRegistrar>> lazyRegistrars = new ArrayList();
        private final List<Component<?>> additionalComponents = new ArrayList();

        public Builder(Executor executor) {
            this.defaultExecutor = executor;
        }

        public static /* synthetic */ ComponentRegistrar lambda$addComponentRegistrar$0(ComponentRegistrar componentRegistrar) {
            return componentRegistrar;
        }

        public Builder addComponent(Component<?> component) {
            this.additionalComponents.add(component);
            return this;
        }

        public Builder addComponentRegistrar(ComponentRegistrar componentRegistrar) {
            this.lazyRegistrars.add(ComponentRuntime$Builder$$Lambda$1.lambdaFactory$(componentRegistrar));
            return this;
        }

        public Builder addLazyComponentRegistrars(Collection<Provider<ComponentRegistrar>> collection) {
            this.lazyRegistrars.addAll(collection);
            return this;
        }

        public ComponentRuntime build() {
            return new ComponentRuntime(this.defaultExecutor, this.lazyRegistrars, this.additionalComponents);
        }
    }

    public static Builder builder(Executor executor) {
        return new Builder(executor);
    }

    private void discoverComponents(List<Component<?>> list) {
        ArrayList arrayList = new ArrayList();
        synchronized (this) {
            Iterator<Provider<ComponentRegistrar>> it = this.unprocessedRegistrarProviders.iterator();
            while (it.hasNext()) {
                try {
                    ComponentRegistrar componentRegistrar = it.next().get();
                    if (componentRegistrar != null) {
                        list.addAll(componentRegistrar.getComponents());
                        it.remove();
                    }
                } catch (InvalidRegistrarException e) {
                    it.remove();
                    Log.w("ComponentDiscovery", "Invalid component registrar.", e);
                }
            }
            if (this.components.isEmpty()) {
                CycleDetector.detect(list);
            } else {
                ArrayList arrayList2 = new ArrayList(this.components.keySet());
                arrayList2.addAll(list);
                CycleDetector.detect(arrayList2);
            }
            for (Component<?> component : list) {
                this.components.put(component, new Lazy(ComponentRuntime$$Lambda$1.lambdaFactory$(this, component)));
            }
            arrayList.addAll(processInstanceComponents(list));
            arrayList.addAll(processSetComponents());
            processDependencies();
        }
        Iterator it2 = arrayList.iterator();
        while (it2.hasNext()) {
            ((Runnable) it2.next()).run();
        }
        maybeInitializeEagerComponents();
    }

    private void doInitializeEagerComponents(Map<Component<?>, Provider<?>> map, boolean z) {
        for (Map.Entry<Component<?>, Provider<?>> entry : map.entrySet()) {
            Component<?> key = entry.getKey();
            Provider<?> value = entry.getValue();
            if (key.isAlwaysEager() || (key.isEagerInDefaultApp() && z)) {
                value.get();
            }
        }
        this.eventBus.enablePublishingAndFlushPending();
    }

    private static <T> List<T> iterableToList(Iterable<T> iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return arrayList;
    }

    public static /* synthetic */ Object lambda$discoverComponents$0(ComponentRuntime componentRuntime, Component component) {
        return component.getFactory().create(new RestrictedComponentContainer(component, componentRuntime));
    }

    public static /* synthetic */ ComponentRegistrar lambda$toProviders$1(ComponentRegistrar componentRegistrar) {
        return componentRegistrar;
    }

    private void maybeInitializeEagerComponents() {
        Boolean bool = this.eagerComponentsInitializedWith.get();
        if (bool != null) {
            doInitializeEagerComponents(this.components, bool.booleanValue());
        }
    }

    private void processDependencies() {
        for (Component<?> component : this.components.keySet()) {
            for (Dependency dependency : component.getDependencies()) {
                if (dependency.isSet() && !this.lazySetMap.containsKey(dependency.getInterface())) {
                    this.lazySetMap.put(dependency.getInterface(), LazySet.fromCollection(Collections.emptySet()));
                } else if (this.lazyInstanceMap.containsKey(dependency.getInterface())) {
                    continue;
                } else {
                    if (dependency.isRequired()) {
                        throw new MissingDependencyException(String.format("Unsatisfied dependency for component %s: %s", component, dependency.getInterface()));
                    }
                    if (!dependency.isSet()) {
                        this.lazyInstanceMap.put(dependency.getInterface(), OptionalProvider.empty());
                    }
                }
            }
        }
    }

    private List<Runnable> processInstanceComponents(List<Component<?>> list) {
        ArrayList arrayList = new ArrayList();
        for (Component<?> component : list) {
            if (component.isValue()) {
                Provider<?> provider = this.components.get(component);
                for (Class<? super Object> cls : component.getProvidedInterfaces()) {
                    if (this.lazyInstanceMap.containsKey(cls)) {
                        arrayList.add(ComponentRuntime$$Lambda$3.lambdaFactory$((OptionalProvider) this.lazyInstanceMap.get(cls), provider));
                    } else {
                        this.lazyInstanceMap.put(cls, provider);
                    }
                }
            }
        }
        return arrayList;
    }

    private List<Runnable> processSetComponents() {
        ArrayList arrayList = new ArrayList();
        HashMap map = new HashMap();
        for (Map.Entry<Component<?>, Provider<?>> entry : this.components.entrySet()) {
            Component<?> key = entry.getKey();
            if (!key.isValue()) {
                Provider<?> value = entry.getValue();
                for (Class<? super Object> cls : key.getProvidedInterfaces()) {
                    if (!map.containsKey(cls)) {
                        map.put(cls, new HashSet());
                    }
                    ((Set) map.get(cls)).add(value);
                }
            }
        }
        for (Map.Entry entry2 : map.entrySet()) {
            if (this.lazySetMap.containsKey(entry2.getKey())) {
                LazySet<?> lazySet = this.lazySetMap.get(entry2.getKey());
                Iterator it = ((Set) entry2.getValue()).iterator();
                while (it.hasNext()) {
                    arrayList.add(ComponentRuntime$$Lambda$4.lambdaFactory$(lazySet, (Provider) it.next()));
                }
            } else {
                this.lazySetMap.put((Class) entry2.getKey(), LazySet.fromCollection((Collection) entry2.getValue()));
            }
        }
        return arrayList;
    }

    private static Iterable<Provider<ComponentRegistrar>> toProviders(Iterable<ComponentRegistrar> iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator<ComponentRegistrar> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(ComponentRuntime$$Lambda$2.lambdaFactory$(it.next()));
        }
        return arrayList;
    }

    @Override // com.google.firebase.components.AbstractComponentContainer, com.google.firebase.components.ComponentContainer
    public /* bridge */ /* synthetic */ Object get(Class cls) {
        return super.get(cls);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public <T> Deferred<T> getDeferred(Class<T> cls) {
        Provider<T> provider = getProvider(cls);
        if (provider == null) {
            return OptionalProvider.empty();
        }
        return provider instanceof OptionalProvider ? (OptionalProvider) provider : OptionalProvider.of(provider);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public synchronized <T> Provider<T> getProvider(Class<T> cls) {
        Preconditions.checkNotNull(cls, "Null interface requested.");
        return (Provider) this.lazyInstanceMap.get(cls);
    }

    @RestrictTo({RestrictTo.Scope.TESTS})
    @VisibleForTesting
    public void initializeAllComponentsForTests() {
        Iterator<Provider<?>> it = this.components.values().iterator();
        while (it.hasNext()) {
            it.next().get();
        }
    }

    public void initializeEagerComponents(boolean z) {
        HashMap map;
        if (ay6.a(this.eagerComponentsInitializedWith, null, Boolean.valueOf(z))) {
            synchronized (this) {
                map = new HashMap(this.components);
            }
            doInitializeEagerComponents(map, z);
        }
    }

    @Override // com.google.firebase.components.AbstractComponentContainer, com.google.firebase.components.ComponentContainer
    public /* bridge */ /* synthetic */ Set setOf(Class cls) {
        return super.setOf(cls);
    }

    @Override // com.google.firebase.components.ComponentContainer
    public synchronized <T> Provider<Set<T>> setOfProvider(Class<T> cls) {
        LazySet<?> lazySet = this.lazySetMap.get(cls);
        if (lazySet != null) {
            return lazySet;
        }
        return (Provider<Set<T>>) EMPTY_PROVIDER;
    }

    @Deprecated
    public ComponentRuntime(Executor executor, Iterable<ComponentRegistrar> iterable, Component<?>... componentArr) {
        this(executor, toProviders(iterable), Arrays.asList(componentArr));
    }

    private ComponentRuntime(Executor executor, Iterable<Provider<ComponentRegistrar>> iterable, Collection<Component<?>> collection) {
        this.components = new HashMap();
        this.lazyInstanceMap = new HashMap();
        this.lazySetMap = new HashMap();
        this.eagerComponentsInitializedWith = new AtomicReference<>();
        EventBus eventBus = new EventBus(executor);
        this.eventBus = eventBus;
        ArrayList arrayList = new ArrayList();
        arrayList.add(Component.of(eventBus, EventBus.class, Subscriber.class, Publisher.class));
        arrayList.add(Component.of(this, ComponentLoader.class, new Class[0]));
        for (Component<?> component : collection) {
            if (component != null) {
                arrayList.add(component);
            }
        }
        this.unprocessedRegistrarProviders = iterableToList(iterable);
        discoverComponents(arrayList);
    }

    @Override // com.google.firebase.dynamicloading.ComponentLoader
    public void discoverComponents() {
        synchronized (this) {
            if (this.unprocessedRegistrarProviders.isEmpty()) {
                return;
            }
            discoverComponents(new ArrayList());
        }
    }
}
