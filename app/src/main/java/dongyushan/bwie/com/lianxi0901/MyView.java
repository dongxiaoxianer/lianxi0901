package dongyushan.bwie.com.lianxi0901;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ，全是妖怪 on 2018/9/1.
 */

public class MyView extends View {

    private Paint paint;
    private Paint paint01;
    private Paint paint02;
    private Paint paint03;
    private int width_num = 50;
    private int height_num = 50;
    private int left = 70;
    private int right = 120;
    private int top;

    private List<Integer> list=new ArrayList<>();

    public MyView(Context context) {
        this(context,null);
    }

    public MyView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();
        paint01 = new Paint();
        paint.setColor(Color.BLUE);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(5);
        paint01.setColor(Color.BLUE);
        paint01.setAntiAlias(true);
        paint01.setStrokeWidth(2);
        paint01.setTextSize(30);
        paint02 = new Paint();
        paint02.setTextSize(20);
        paint02.setStrokeWidth(2);
        paint02.setAntiAlias(true);
        paint03 = new Paint();
        paint03.setAntiAlias(true);
        paint03.setStrokeWidth(2);
        paint03.setColor(Color.GREEN);

        for (int i=0;i<7;i++){
            if (i==0){
                list.add(50);
            }else {
                list.add(100*i);
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawLine(50,400,700,400,paint);//横轴
        canvas.drawLine(50,50,50,400,paint);//竖轴
        canvas.drawText("周日",70,430,paint01);
        canvas.drawText("周一",160,430,paint01);
        canvas.drawText("周二",250,430,paint01);
        canvas.drawText("周三",340,430,paint01);
        canvas.drawText("周四",430,430,paint01);
        canvas.drawText("周五",520,430,paint01);
        canvas.drawText("周六",610,430,paint01);
        canvas.drawText("600",680,100,paint02);
        canvas.drawText("500",680,150,paint02);
        canvas.drawText("400",680,200,paint02);
        canvas.drawText("300",680,250,paint02);
        canvas.drawText("200",680,300,paint02);
        canvas.drawText("100",680,350,paint02);

        //竖轴循环
        for (int i = 0 ; i < 7 ; i++){
            width_num+=90;
            canvas.drawLine(width_num,50,width_num,400,paint01);
            //Log.i("aaaaaaaaaaaaaa",width_num+"-----------------------------------"+line_num);
        }

        //横轴循环
        for (int i = 0 ; i < 7 ; i++){
            height_num+=50;
            canvas.drawLine(50,height_num,679,height_num,paint01);
        }

        //循环画矩形

        for (int j = 0 ; j < list.size() ; j++){
            top = list.get(j) / 2;
            canvas.drawRect(left,400-top,right,400,paint03);
            left+=90;
            right+=90;
        }



    }
}
