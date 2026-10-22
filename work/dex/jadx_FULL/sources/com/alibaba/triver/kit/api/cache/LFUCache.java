package com.alibaba.triver.kit.api.cache;

import android.util.Log;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class LFUCache<K, V> implements Serializable {
    private Map<K, DataNode<K, V>> cacheData;
    private int capacity;
    private Map<Integer, CountNode<K, V>> countNodeMap;
    private CountNodeList<K, V> nodeList;
    private int size;

    public static class CountNode<K, V> implements Serializable {
        int count;
        DataNode<K, V> head;
        CountNode<K, V> next;
        CountNode<K, V> pre;
        DataNode<K, V> tail;

        private CountNode() {
        }
    }

    public static class CountNodeList<K, V> implements Serializable {
        CountNode<K, V> head;
        CountNode<K, V> tail;

        private CountNodeList() {
        }
    }

    public static class DataNode<K, V> implements Serializable {
        int count;
        V data;
        K key;
        DataNode next;
        DataNode pre;

        private DataNode() {
        }

        public String toString() {
            return "DataNode{count=" + this.count + ", key=" + this.key + ", data=" + this.data + ", next=" + this.next + ", pre=" + this.pre + '}';
        }
    }

    public LFUCache(int i) {
        this.capacity = i;
        this.size = 0;
        this.cacheData = new HashMap();
        this.countNodeMap = new HashMap();
        this.nodeList = new CountNodeList<>();
    }

    private void addCountNodeInNodeList(CountNode<K, V> countNode) {
        CountNodeList<K, V> countNodeList = this.nodeList;
        CountNode<K, V> countNode2 = countNodeList.head;
        if (countNode2 == null) {
            countNodeList.head = countNode;
            countNodeList.tail = countNode;
            this.countNodeMap.put(Integer.valueOf(countNode.count), countNode);
            return;
        }
        int i = countNode.count;
        CountNode<K, V> countNode3 = countNodeList.tail;
        if (i > countNode3.count) {
            countNode3.next = countNode;
            countNodeList.tail = countNode;
            this.countNodeMap.put(Integer.valueOf(i), countNode);
            return;
        }
        while (countNode2 != null && countNode.count > countNode2.count) {
            CountNode<K, V> countNode4 = countNode2.next;
            if (countNode4 == null) {
                break;
            } else {
                countNode2 = countNode4;
            }
        }
        int i2 = countNode.count;
        if (i2 < countNode2.count) {
            CountNode<K, V> countNode5 = countNode2.pre;
            if (countNode5 == null) {
                countNode.next = countNode2;
                this.nodeList.head = countNode;
            } else {
                countNode.next = countNode2;
                countNode.pre = countNode5;
                countNode2.pre.next = countNode;
            }
        } else if (countNode2.pre == null) {
            CountNode<K, V> countNode6 = countNode2.next;
            if (countNode6 == null) {
                countNode.next = null;
                this.nodeList.tail = countNode;
                countNode2.next = countNode;
            } else {
                countNode.next = countNode6;
                countNode.pre = countNode2;
                countNode2.next = countNode;
            }
        } else {
            CountNode<K, V> countNode7 = countNode2.next;
            if (countNode7 == null) {
                countNode.next = null;
                countNode2.next = countNode;
                countNode.pre = countNode2;
                this.nodeList.tail = countNode;
            } else {
                countNode.next = countNode7;
                countNode.pre = countNode2;
                countNode2.next = countNode;
            }
        }
        this.countNodeMap.put(Integer.valueOf(i2), countNode);
    }

    private void addDataNodeToCountNode(DataNode<K, V> dataNode, int i) {
        CountNode<K, V> countNode = this.countNodeMap.get(Integer.valueOf(i));
        if (countNode == null) {
            CountNode<K, V> countNode2 = new CountNode<>();
            countNode2.count = i;
            countNode2.head = dataNode;
            countNode2.tail = dataNode;
            addCountNodeInNodeList(countNode2);
        } else {
            DataNode<K, V> dataNode2 = countNode.head;
            if (dataNode2 != null) {
                dataNode2.pre = dataNode;
                dataNode.next = dataNode2;
                countNode.head = dataNode;
                dataNode.pre = null;
            } else {
                countNode.head = dataNode;
                countNode.tail = dataNode;
            }
        }
        this.cacheData.put(dataNode.key, dataNode);
        this.size++;
    }

    private void removeCountNodeInNodeList(CountNode<K, V> countNode) {
        if (countNode == null) {
            return;
        }
        CountNodeList<K, V> countNodeList = this.nodeList;
        CountNode<K, V> countNode2 = countNodeList.head;
        if (countNode2 == countNode && countNodeList.tail == countNode) {
            countNodeList.head = null;
            countNodeList.tail = null;
        } else if (countNode2 == countNode) {
            CountNode<K, V> countNode3 = countNode.next;
            countNodeList.head = countNode3;
            countNode3.pre = null;
            countNode.next = null;
        } else if (countNodeList.tail == countNode) {
            CountNode<K, V> countNode4 = countNode.pre;
            countNodeList.tail = countNode4;
            countNode4.next = null;
            countNode.pre = null;
        } else {
            CountNode<K, V> countNode5 = countNode.pre;
            countNode5.next = countNode.next;
            countNode.next.pre = countNode5;
            countNode.next = null;
            countNode.pre = null;
        }
        this.countNodeMap.remove(Integer.valueOf(countNode.count));
    }

    private void removeDataNodeFromCountNode(DataNode<K, V> dataNode) {
        CountNode<K, V> countNode;
        if (dataNode == null || (countNode = this.countNodeMap.get(Integer.valueOf(dataNode.count))) == null) {
            return;
        }
        DataNode<K, V> dataNode2 = dataNode.pre;
        if (dataNode2 == null) {
            DataNode<K, V> dataNode3 = dataNode.next;
            countNode.head = dataNode3;
            if (dataNode3 == null) {
                countNode.tail = null;
            }
        } else {
            DataNode dataNode4 = dataNode.next;
            if (dataNode4 == null) {
                dataNode2.next = null;
                countNode.tail = dataNode2;
            } else {
                dataNode2.next = dataNode4;
            }
        }
        dataNode.pre = null;
        dataNode.next = null;
        this.cacheData.remove(dataNode.key);
        this.size--;
    }

    private void removeLittleDataNode() {
        CountNode<K, V> countNode = this.nodeList.head;
        if (countNode == null) {
            return;
        }
        boolean z = false;
        while (!z && countNode != null) {
            CountNode<K, V> countNode2 = countNode.next;
            DataNode<K, V> dataNode = countNode.tail;
            if (dataNode == null) {
                removeCountNodeInNodeList(countNode);
            } else {
                removeDataNodeFromCountNode(dataNode);
                if (countNode.head == null) {
                    removeCountNodeInNodeList(countNode);
                }
                z = true;
            }
            countNode = countNode2;
        }
    }

    public synchronized V get(K k) {
        V v = null;
        try {
            DataNode<K, V> dataNode = this.cacheData.get(k);
            if (dataNode == null) {
                return null;
            }
            removeDataNodeFromCountNode(dataNode);
            int i = dataNode.count + 1;
            dataNode.count = i;
            addDataNodeToCountNode(dataNode, i);
            v = dataNode.data;
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
        }
        return v;
    }

    public synchronized int getCapacity() {
        return this.capacity;
    }

    public synchronized int getSize() {
        return this.size;
    }

    public synchronized void put(K k, V v) {
        try {
            if (this.size >= this.capacity) {
                removeLittleDataNode();
            }
            DataNode<K, V> dataNode = this.cacheData.get(k);
            if (dataNode == null) {
                DataNode<K, V> dataNode2 = new DataNode<>();
                dataNode2.count = 1;
                dataNode2.data = v;
                dataNode2.key = k;
                addDataNodeToCountNode(dataNode2, 1);
            } else {
                dataNode.data = v;
            }
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
        }
    }

    public synchronized void remove(K k) {
        try {
            DataNode<K, V> dataNode = this.cacheData.get(k);
            if (dataNode == null) {
                return;
            }
            removeDataNodeFromCountNode(dataNode);
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
        }
    }

    public LFUCache() {
        this(100);
    }
}
