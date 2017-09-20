package kmitl.lab04.benjarat58070079.simplemydot.View;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.ContextMenu;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;

import kmitl.lab04.benjarat58070079.simplemydot.Fragment.ViewDotFragment;
import kmitl.lab04.benjarat58070079.simplemydot.Model.Dot;
import kmitl.lab04.benjarat58070079.simplemydot.Model.Dots;

public class DotView extends View {

    private Paint paint;
    private Dots listDot;
    private OnDotViewPressListener onDotViewPressListener;

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(this.listDot != null) {
            for (Dot dot: listDot.getListDot()) {
                paint.setColor(dot.getColor());
                canvas.drawCircle(
                        dot.getCenterX(),
                        dot.getCenterY(), 30, paint);
            }
        }
    }


    public interface OnDotViewPressListener{
        void onDotViewPressed(int x, int y);

        void onDotViewLongPressed(int x, int y);
    }


    public void setOnDotViewPressListener(
            OnDotViewPressListener onDotViewPressListener) {
        this.onDotViewPressListener = onDotViewPressListener;
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener(){

        @Override
        public boolean onDown(MotionEvent e) {
            return true;
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            onDotViewPressListener.onDotViewPressed((int)e.getX(), (int)e.getY());
            return super.onSingleTapUp(e);
        }

        @Override
        public void onLongPress(MotionEvent e) {
            onDotViewPressListener.onDotViewLongPressed((int)e.getX(), (int)e.getY());
            super.onLongPress(e);
        }


    });


    public DotView(Context context) {
        super(context);
        paint = new Paint();
    }

    public DotView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
    }

    public DotView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
    }


    public void setDots(Dots dots) {
        this.listDot = dots;

    }
}
