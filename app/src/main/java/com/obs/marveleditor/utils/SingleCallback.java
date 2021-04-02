package com.obs.marveleditor.utils;

import com.obs.marveleditor.model.FrameEntity;

import java.util.List;

public interface SingleCallback<T, V> {
    void onSingleCallback(List<T> t, Integer v);
}
