package kimonik.com.gamedevelopment.customview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.provider.Settings;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import kimonik.com.gamedevelopment.R;

/**
 * Created by 12348 on 2017/6/10 0010.
 * game view
 */

public class GameSurfaceView extends SurfaceView implements SurfaceHolder.Callback2, Runnable {
    private SurfaceHolder surfaceHolder;
    private Paint paint;
    private String TAG = "surfaceview";
    /**
     * 文本绘制的xy坐标位置
     */
    private int textX, textY;
    private Thread thread;
    private boolean flag = true;
    /**
     * 屏幕的宽高
     */
    private int screenW, screenH;
    /**
     * 画布
     */
    private Canvas canvas;
    private int count = 0;


    public GameSurfaceView(Context context) {
        this(context, null, 0);
    }

    public GameSurfaceView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public GameSurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    @TargetApi(21)
    public GameSurfaceView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView();
    }


    private void initView() {
        this.surfaceHolder = this.getHolder();
        surfaceHolder.addCallback(this);
        paint = new Paint();
        paint.setColor(Color.parseColor("#a3a3a3"));
        paint.setTextSize(150f);
        paint.setAntiAlias(true);//设置无锯齿
        paint.setStrokeWidth(5);//设置画笔粗细值
        paint.setStyle(Paint.Style.STROKE);//设置画笔是否填充
        setFocusable(true);//设置获取焦点

    }

    /**
     * 在surfaceChanged执行后执行2次
     */
    @Override
    public void surfaceRedrawNeeded(SurfaceHolder holder) {
        Log.e(TAG, "surfaceRedrawNeeded: ----------------------");

    }

    /**
     * 初始化view时,首先执行
     */
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Log.e(TAG, "surfaceCreated: ---------------------------");
        screenW = this.getWidth();
        screenH = this.getHeight();
        Log.e(TAG, "surfaceCreated:--- " + screenW);
        Log.e(TAG, "surfaceCreated:--- " + screenH);
//        textY = screenH - 500;
        textY = 0;
        flag = true;
        thread = new Thread(this);
//        thread.start();
        drawContent();

    }

    private void drawContent() {
        try {
            canvas = surfaceHolder.lockCanvas();
            if (canvas != null) {
                canvas.drawColor(Color.WHITE);
//                canvas.drawCircle(textX + 30, textY + 30, 30, paint);
//                canvas.drawLine(textX + 30, textY + 60, textX + 30, textY + 120, paint);
//                if (count % 3 == 1) {
//                    canvas.drawLine(textX + 30, textY + 120, textX, textY + 180, paint);
//                    canvas.drawLine(textX + 30, textY + 120, textX + 60, textY + 180, paint);
//                    canvas.drawLine(textX + 30, textY + 80, textX + 60, textY + 150, paint);
//                    canvas.drawLine(textX + 30, textY + 80, textX, textY + 150, paint);
//                } else if (count % 3 == 0) {
//                    canvas.drawLine(textX + 30, textY + 120, textX + 15, textY + 150, paint);//后腿
//                    canvas.drawLine(textX + 15, textY + 150, textX, textY + 130, paint);//后腿
//
//                    canvas.drawLine(textX + 30, textY + 120, textX + 60, textY + 180, paint);//前腿
//                    canvas.drawLine(textX + 30, textY + 80, textX + 60, textY + 150, paint);//前手臂
//                    canvas.drawLine(textX + 30, textY + 80, textX, textY + 120, paint);//后手臂
//                } else if (count % 3 == 2) {
//                    canvas.drawLine(textX + 30, textY + 120, textX, textY + 180, paint);
//
//                    canvas.drawLine(textX + 30, textY + 120, textX + 60, textY + 150, paint);//前腿
//                    canvas.drawLine(textX + 60, textY + 150, textX + 70, textY + 180, paint);//前腿
//
//                    canvas.drawLine(textX + 30, textY + 80, textX + 60, textY + 120, paint);//前手臂
//                    canvas.drawLine(textX + 30, textY + 80, textX, textY + 150, paint);//后手臂
//                }
//                if (count%6==0){
//                    Bitmap bitmap= BitmapFactory.decodeResource(this.getResources(), R.drawable.yu01);
////                    canvas.drawBitmap(bitmap,0,0,paint);
//                    canvas.drawBitmap(bitmap,textX,textY,paint);
//                }else if (count%6==1){
//                    Bitmap bitmap= BitmapFactory.decodeResource(this.getResources(), R.drawable.yu02);
//                    canvas.drawBitmap(bitmap,textX,textY,paint);
//                }else if (count%6==2){
//                    Bitmap bitmap= BitmapFactory.decodeResource(this.getResources(), R.drawable.yu03);
//                    canvas.drawBitmap(bitmap,textX,textY,paint);
//                }else if (count%6==3){
//                    Bitmap bitmap= BitmapFactory.decodeResource(this.getResources(), R.drawable.yu04);
//                    canvas.drawBitmap(bitmap,textX,textY,paint);
//                }else if (count%6==4){
//                    Bitmap bitmap= BitmapFactory.decodeResource(this.getResources(), R.drawable.yu05);
//                    canvas.drawBitmap(bitmap,textX,textY,paint);
//                }else if (count%6==5){
//                    Bitmap bitmap= BitmapFactory.decodeResource(this.getResources(), R.drawable.yu06);
//                    canvas.drawBitmap(bitmap,textX,textY,paint);
//                }

                Log.e(TAG, "drawContent: " + textX);
                Log.e(TAG, "drawContent: " + textY);


                Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.yu03);
                Bitmap bitmap1=Bitmap.createBitmap(bitmap.getWidth(),bitmap.getHeight(), Bitmap.Config.ARGB_8888);
//                Log.e(TAG, "drawContentgetWidth: " + bitmap.getWidth());
//                Log.e(TAG, "drawContentgetHeight: " + bitmap.getHeight());
//                Log.e(TAG, "getPixel: " + bitmap.getPixel(450, 450));
                    int[] pointInfo=new int[bitmap.getWidth()*bitmap.getHeight()];
                    bitmap.getPixels(pointInfo,0,bitmap.getWidth(),0,0,bitmap.getWidth(),bitmap.getHeight());
                Log.e(TAG, "drawContent:已来了 "+pointInfo.length );
//                for (int i = 0; i < 600; i++) {
////                    if (i%900>400&&i%900<600&&i>400*900&&i<600*900){
////                        pointInfo[i]=Color.BLUE;
////                    }
//                    //位图的像素点信息数组存储俺行顺序记录,某一个像素点的位置计算在数组中的下表为
//                    //在数组中的位置=行数*单行像素的个数+在当前航的横轴坐标位置
//                    if (i>400){
//                        int m=0;
//                        while (m<200){
//                            m++;
//                            Log.e(TAG, "drawContent: "+(400*i+m) );
//                            pointInfo[i*900+400+m]=Color.BLUE;
//                        }
//                    }
//                }
                for (int i = 0; i < pointInfo.length; i++) {
                    if (pointInfo[i]!=0){
                        if (i%3==0){
                            pointInfo[i]=Color.BLUE;

                        }else if (i%3==1){
                            pointInfo[i]=Color.GREEN;

                        }else if (i%3==2){
                            pointInfo[i]=Color.RED;

                        }
                    }
                }


//                    }

//                    if (i > 400) {
//                        Log.e(TAG, "drawContent:循环1 " );
//                        for (int j = 0; j < 600; j++) {
//                            Log.e(TAG, "drawContent:循环2 " );
//                            if (j > 400) {
//                                Log.e(TAG, "drawContent:执行前 " );
//                                pointInfo[i*j]= Color.BLUE;
//                                Log.e(TAG, "drawContent:在执行 " +j);
//                            }
//                        }
//                    }
//                }
                Log.e(TAG, "drawContent:已完成----------- " );

                bitmap1.setPixels(pointInfo,0,bitmap.getWidth(),0,0,bitmap.getWidth(),bitmap.getHeight());
                Log.e(TAG, "drawContent:已完成 " );
                canvas.drawBitmap(bitmap1, 0, 0, paint);

//                if (count%6==0){
//                    Bitmap bitmap= BitmapFactory.decodeResource(this.getResources(), R.drawable.yu01);
////                    canvas.drawBitmap(bitmap,0,0,paint);
//                    canvas.drawBitmap(bitmap,textX,textY,paint);
//                }else if (count%6==1){
//                    Bitmap bitmap= BitmapFactory.decodeResource(this.getResources(), R.drawable.yu02);
//                    canvas.drawBitmap(bitmap,textX,textY,paint);
//                }else if (count%6==2){
//                    Bitmap bitmap= BitmapFactory.decodeResource(this.getResources(), R.drawable.yu03);
//                    Log.e(TAG, "drawContentgetWidth: "+bitmap.getWidth() );
//                    Log.e(TAG, "drawContentgetHeight: "+bitmap.getHeight() );
//                    Log.e(TAG, "getPixel: "+bitmap.getPixel(450,450) );
////                    int[] pointInfo=new int[bitmap.getWidth()*bitmap.getHeight()];
////                    bitmap.getPixels(pointInfo,0,bitmap.getWidth(),0,0,bitmap.getWidth(),bitmap.getHeight());
//
//                    for (int i = 0; i < 500; i++) {
//                       if (i>400){
//                           for (int j = 0; j < 500; j++) {
//                               if (j>400){
//                                   bitmap.setPixel(i,j,Color.BLUE);
//                               }
//                           }
//                       }
//
//                    }
//
//                    canvas.drawBitmap(bitmap,textX,textY,paint);
//                }else if (count%6==3){
//                    Bitmap bitmap= BitmapFactory.decodeResource(this.getResources(), R.drawable.yu04);
//                    canvas.drawBitmap(bitmap,textX,textY,paint);
//                }else if (count%6==4){
//                    Bitmap bitmap= BitmapFactory.decodeResource(this.getResources(), R.drawable.yu05);
//                    canvas.drawBitmap(bitmap,textX,textY,paint);
//                }else if (count%6==5){
//                    Bitmap bitmap= BitmapFactory.decodeResource(this.getResources(), R.drawable.yu06);
//                    canvas.drawBitmap(bitmap,textX,textY,paint);
//                }


//                Path path=new Path();
//                path.moveTo(textX+30,textY+60);
//                path.lineTo(textX+30,textY+120);
//                path.lineTo(textX+15,textY+180);
//                canvas.drawPath(path,paint);
//
//                Path path1=new Path();
//                path1.moveTo(textX+30,textY+120);
//                path1.lineTo(textX+45,textY+180);
//                canvas.drawPath(path1,paint);

//                canvas.drawText("Game",textX,textY,paint);
//
//                canvas.drawPoint(100,100,paint);
//                canvas.drawPoints(new float[]{100,100,120,120},paint);
//                canvas.drawLine(100,80,70,150,paint);
//                canvas.drawLines(new float[]{100,80,70,150,150,90,250,170},paint);
//                canvas.drawRect(10,60,40,100,paint);
//
//                Path path=new Path();
////                path.moveTo(0,0);
////                path.lineTo(500,500);
////                path.lineTo(300,800);
//                path.addCircle(500,500,500,Path.Direction.CW);//ccw--字符顶部在圆内,cw---字符顶部在圆外
//                canvas.drawTextOnPath("hfdsfgdfhjfhsjdfhdhfjdfhdjnfdjskfjdhnfkhgfhsghfgdfgfgssfgsfdgsdggfgfsgdgddjfkjfewjfeihfnkjdfndsjkfnh",path,0,0,paint);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (canvas != null) {
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }

    }

    /**
     * 在surfaceCreated后执行
     */
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.e(TAG, "surfaceChanged: -----------------------");

    }

    /**
     * 销毁时执行
     */
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        flag = false;//销毁时终止线程
        Log.e(TAG, "surfaceDestroyed: -----------------------");
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        textX = (int) event.getX() - 175;
        textY = (int) event.getY() + 75;
//        drawContent();
        Log.e(TAG, "onTouchEvent: ------------------eee");
        return true;
    }

    @Override
    public void run() {
        while (flag) {
            count++;
            if (textX > 1920) {
                textX = 0;
            }
            textX = textX + 10;
//            textY=textY+5;

            long start = System.currentTimeMillis();
            drawContent();
            long end = System.currentTimeMillis();
            if (end - start < 3000) {
                try {
                    Thread.sleep(3000 - end + start);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
