package kmitl.lab04.benjarat58070079.simplemydot.View;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

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
    }


    public void setOnDotViewPressListener(
            OnDotViewPressListener onDotViewPressListener) {
        this.onDotViewPressListener = onDotViewPressListener;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            this.onDotViewPressListener
                    .onDotViewPressed(
                            (int)event.getX(),
                            (int)event.getY());
        }
        return false;
    }

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
