package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice13GetTextBoundsView extends View {
    Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
    Rect rect = new Rect();
    String text1 = "A";
    String text2 = "a";
    String text3 = "J";
    String text4 = "j";
    String text5 = "Â";
    String text6 = "â";
    int top = 200;
    int bottom = 400;

    public Practice13GetTextBoundsView(Context context) {
        super(context);
    }

    public Practice13GetTextBoundsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice13GetTextBoundsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeWidth(20);
        paint1.setColor(Color.parseColor("#E91E63"));
        paint2.setTextSize(160);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(50, top, getWidth() - 50, bottom, paint1);

        // 使用 Paint.getTextBounds() 计算出文字的显示区域
        // 然后计算出文字的绘制位置，从而让文字上下居中
        // 这种居中算法的优点是，可以让文字精准地居中，分毫不差

        float middle = getBaseLine(text1);
        canvas.drawText(text1, 100, middle, paint2);
        middle = getBaseLine(text2);
        canvas.drawText(text2, 200, middle, paint2);
        middle = getBaseLine(text3);
        canvas.drawText(text3, 300, middle, paint2);
        middle = getBaseLine(text4);
        canvas.drawText(text4, 400, middle, paint2);
        middle = getBaseLine(text5);
        canvas.drawText(text5, 500, middle, paint2);
        middle = getBaseLine(text6);
        canvas.drawText(text6, 600, middle, paint2);
    }

    private float getBaseLine(String s) {
        paint2.getTextBounds(s, 0, s.length(), rect);
        // 本例为已知中心求基线
        // -(rect.top+rect.bottom)/2表示基线相对文字中心的位置
        // 而文字中心也就是显示区域的中心：(top+bottom)/2
        // 二者相加即为基线的位置
        return (top + bottom) / 2 - (rect.top + rect.bottom) / 2;
    }
}