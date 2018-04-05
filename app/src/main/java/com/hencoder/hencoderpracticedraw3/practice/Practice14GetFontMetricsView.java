package com.hencoder.hencoderpracticedraw3.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice14GetFontMetricsView extends View {
    Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
    String[] texts = {"A", "a", "J", "j", "Â", "â"};
    int top = 200;
    int bottom = 400;

    public Practice14GetFontMetricsView(Context context) {
        super(context);
    }

    public Practice14GetFontMetricsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice14GetFontMetricsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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

        Paint.FontMetrics fontMetrics = paint2.getFontMetrics();
        // 使用 Paint.getFontMetrics() 计算出文字的显示区域
        // 然后计算出文字的绘制位置，从而让文字上下居中
        // 这种居中算法的优点是，可以让不同的文字的 baseline 对齐

        // 本题和上一题不同的地方应该是：
        // 每个字的top和bottom都不一样，导致文字中心会变动
        // 而每个字的ascent和descent都是一样的，所以以ascent和descent为矩形上下限居中
        // 也因此可以从paint统一获取ascent和descent，而文字区域则必须根据文字获取
        float middle = (top + bottom) / 2 - (fontMetrics.ascent + fontMetrics.descent) / 2;
        canvas.drawText(texts[0], 100, middle, paint2);
        canvas.drawText(texts[1], 200, middle, paint2);
        canvas.drawText(texts[2], 300, middle, paint2);
        canvas.drawText(texts[3], 400, middle, paint2);
        canvas.drawText(texts[4], 500, middle, paint2);
        canvas.drawText(texts[5], 600, middle, paint2);
    }
}
