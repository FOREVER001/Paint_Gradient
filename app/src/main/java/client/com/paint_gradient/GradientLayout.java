package client.com.paint_gradient;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ComposeShader;
import android.graphics.LightingColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class GradientLayout extends View {
    private Paint mPaint;
    private Shader mShader;
    private Bitmap mBitmap;
    public GradientLayout(Context context) {
        this(context,null);
    }

    public GradientLayout(Context context,  AttributeSet attrs) {
        this(context, attrs,0);
    }

    public GradientLayout(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        BitmapFactory.Options options=new BitmapFactory.Options();
        options.inSampleSize=3;
        mBitmap= BitmapFactory.decodeResource(getResources(),R.drawable.beauty,options);
        mPaint=new Paint();//初始化
//        mPaint.setColor(Color.RED);//设置颜色
//        mPaint.setARGB(255,255,255,0);//设置Paint对象颜色，范围0-2525
//        mPaint.setAlpha(200);//设置alpha不透明度，范围为0-255
        mPaint.setAntiAlias(true);//抗锯齿
        mPaint.setStyle(Paint.Style.FILL);//设置画笔的描边效果
//        mPaint.setStrokeCap(Paint.Cap.BUTT);//设置圆角效果
//        mPaint.setStrokeJoin(Paint.Join.BEVEL);//设置拐角效果
//        mPaint.setShader(new SweepGradient(200,200,Color.BLUE,Color.RED));//设置环形渲染器
//        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DARKEN));//设置图层混合模式
//        mPaint.setColorFilter(new LightingColorFilter(0x00ffff,0x000000));//设置颜色过滤器
//        mPaint.setFilterBitmap(true);//设置双线性过滤
//        mPaint.setMaskFilter(new BlurMaskFilter(10,BlurMaskFilter.Blur.NORMAL));//设置画笔遮罩滤镜，传入度数和样式
//
//        mPaint.setTextScaleX(2);//设置文本缩放倍数
//        mPaint.setTextAlign(Paint.Align.LEFT);//设置文本的对齐方式
//        mPaint.setUnderlineText(true);//设置下划线
//
//        String str="Android高级开发工程师";
//        Rect rect=new Rect();
//        mPaint.getTextBounds(str,0,str.length(),rect);//测量文本大小，将文本信息存放在rect中
//        mPaint.measureText(str);//获取文本的宽
//        mPaint.getFontMetrics();//获取字体度量的对象

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        mShader=new LinearGradient(0,0,500,500,new int[]{Color.RED,Color.BLUE,Color.GREEN},new float[]{0f,0.7f,1f},Shader.TileMode.REPEAT);
//        mPaint.setShader(mShader);
//        canvas.drawRect(0,0,getWidth(),getHeight(),mPaint);

//        mShader =new RadialGradient(250,250,250,new int[]{Color.GREEN,Color.YELLOW,Color.RED},null,Shader.TileMode.CLAMP);
//        mPaint.setShader(mShader);
//        canvas.drawCircle(250,250,250,mPaint);

        /**
         * cx,,cy渐变中心坐标
         * color0,color1:渐变开始结束颜色
         * color,positions:类似linearGradient,用于多颜色渐变，positions为null时，根据颜色线性渐变
         *
         * */
//        mShader=new SweepGradient(250,250,Color.RED,Color.GREEN);
//        mPaint.setShader(mShader);
//        canvas.drawCircle(250,250,250,mPaint);
        /**
         * bitmap:构造shader使用的bitmap
         * titlex:X轴方向的TileMode
         * titleY:Y轴方向的TitleMode
         *
         * */
//        mShader=new BitmapShader(mBitmap,Shader.TileMode.MIRROR,Shader.TileMode.MIRROR);
//        mPaint.setShader(mShader);
//        canvas.drawRect(0,0,500,500,mPaint);
        BitmapShader bitmapShader=new BitmapShader(mBitmap,Shader.TileMode.REPEAT,Shader.TileMode.REPEAT);
        LinearGradient mLinearGradient=new LinearGradient(0,0,getWidth(),getHeight(),new int[]{Color.RED,Color.GREEN,Color.BLUE},null,Shader.TileMode.CLAMP);
        mShader=new ComposeShader(bitmapShader,mLinearGradient,PorterDuff.Mode.MULTIPLY);
        mPaint.setShader(mShader);
        canvas.drawCircle(250,250,250,mPaint);
    }
}
