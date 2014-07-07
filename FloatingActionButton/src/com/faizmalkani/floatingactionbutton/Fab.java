package com.faizmalkani.floatingactionbutton;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;

public class Fab extends View {
    Context mContext;
    Paint mButtonPaint, mDrawablePaint;
    Bitmap mBitmap;
    int mScreenHeight;
    int mColor;
    float mCurrentY;
    boolean mHidden = false;

    public Fab(Context context) {
        this(context, null);
    }

    public Fab(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public Fab(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mContext = context;

        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.Fab);
        mColor = a.getColor(R.styleable.Fab_color, Color.WHITE);
        Drawable drawable = a.getDrawable(R.styleable.Fab_drawable);
        if (null != drawable) {
            mBitmap = ((BitmapDrawable) drawable).getBitmap();
        }
        init();
    }

    public void setColor(int color) {
        mColor = color;
        init();
    }

    public void setDrawable(Drawable drawable) {
        mBitmap = ((BitmapDrawable) drawable).getBitmap();
        invalidate();
    }


    public void init() {
        setWillNotDraw(false);
        this.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        mButtonPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mButtonPaint.setColor(mColor);
        mButtonPaint.setStyle(Paint.Style.FILL);
        mButtonPaint.setShadowLayer(10.0f, 0.0f, 3.5f, Color.argb(100, 0, 0, 0));
        mDrawablePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        invalidate();

        WindowManager mWindowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        Display display = mWindowManager.getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        mScreenHeight = size.y;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        setClickable(true);
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, (float) (getWidth() / 2.6), mButtonPaint);
        if (null != mBitmap) {
            canvas.drawBitmap(mBitmap, (getWidth() - mBitmap.getWidth()) / 2,
                    (getHeight() - mBitmap.getHeight()) / 2, mDrawablePaint);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_UP) {
            setAlpha(1.0f);
        } else if (event.getAction() == MotionEvent.ACTION_DOWN) {
            setAlpha(0.6f);
        }
        return super.onTouchEvent(event);
    }

    public void hideFab() {
        if (!mHidden) {
            mCurrentY = getY();
            ObjectAnimator mHideAnimation = ObjectAnimator.ofFloat(this, "Y", mScreenHeight);
            mHideAnimation.setInterpolator(new AccelerateInterpolator());
            mHideAnimation.start();
            mHidden = true;
        }
    }

    public void showFab() {
        if (mHidden) {
            ObjectAnimator mShowAnimation = ObjectAnimator.ofFloat(this, "Y", mCurrentY);
            mShowAnimation.setInterpolator(new DecelerateInterpolator());
            mShowAnimation.start();
            mHidden = false;
        }
    }

}