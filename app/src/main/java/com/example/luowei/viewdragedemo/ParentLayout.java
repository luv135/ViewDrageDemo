package com.example.luowei.viewdragedemo;

import android.content.Context;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Luo on 2015/12/26.
 */
public class ParentLayout extends ViewGroup {
    public ParentLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
//        ViewDragHelper dragHelper = ViewDragHelper.create(this,cb);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

    }


}
