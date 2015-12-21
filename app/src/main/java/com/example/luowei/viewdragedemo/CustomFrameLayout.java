package com.example.luowei.viewdragedemo;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by LuoWei on 2015/12/21.
 */
public class CustomFrameLayout extends FrameLayout {

    private final ViewDragHelper mDragHelper;
    private int initCenterViewX = 0, initCenterViewY = 0; // 最初时，中间View的x位置,y位置
    private int allWidth;
    private int allHeight;

    public CustomFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        mDragHelper = ViewDragHelper.create(this, 0.8f, new DragHelperCallback());

    }

    /**
     * 这是viewdraghelper拖拽效果的主要逻辑
     */
    private class DragHelperCallback extends ViewDragHelper.Callback {

        @Override
        public void onViewPositionChanged(View changedView, int left, int top,
                                          int dx, int dy) {
            System.out.println(String.format("left=%d, top=%d, dx=%d, dy=%d", left, top, dx, dy));
        }

        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            return true;
        }

        @Override
        public int getViewHorizontalDragRange(View child) {
            // 这个用来控制拖拽过程中松手后，自动滑行的速度
            return 128;
        }

        @Override
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            System.out.println(String.format("xvle=%f, yvel=%f",xvel,yvel));
            animToSide(releasedChild, xvel, yvel);
        }

        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            System.out.println(String.format("left=%d, dx=%d",left,dx));
            return left;
        }

        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
            System.out.println(String.format("top=%d, dy=%d",top,dy));
            return top;
        }
    }

    /**
     * 松手时处理滑动到边缘的动画
     *
     * @param xvel X方向上的滑动速度
     */
    private void animToSide(View changedView, float xvel, float yvel) {
        int finalX = initCenterViewX;
        int finalY = initCenterViewY;
        int flyType = -1;

        mDragHelper.settleCapturedViewAt(allWidth,allHeight);
        // 2. 启动动画
//        if (mDragHelper.smoothSlideViewTo(changedView, allWidth, allHeight)) {
//            ViewCompat.postInvalidateOnAnimation(this);
//        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        allWidth = getMeasuredWidth();
        allHeight = getMeasuredHeight();
    }

    @Override
    public void computeScroll() {
        if (mDragHelper.continueSettling(true)) {
            ViewCompat.postInvalidateOnAnimation(this);
        } else {
            // 动画结束
            if (mDragHelper.getViewDragState() == ViewDragHelper.STATE_IDLE) {
                System.out.println("STATE_IDLE");
            }
        }
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return mDragHelper.shouldInterceptTouchEvent(event);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mDragHelper.processTouchEvent(event);
        return true;
    }
}
