package kimonik.com.gamedevelopment.customview;

import android.annotation.TargetApi;
import android.content.Context;
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

/**
 * Created by 12348 on 2017/6/10 0010.
 * game view
 */

public class GameSurfaceView extends SurfaceView implements SurfaceHolder.Callback2,Runnable{
    private SurfaceHolder surfaceHolder;
    private Paint paint;
    private String TAG="surfaceview";
    /**文本绘制的xy坐标位置*/
    private int textX,textY;
    private Thread thread;
    private boolean flag=true;
    /**屏幕的宽高*/
    private int screenW,screenH;
    /**画布*/
    private Canvas canvas;


    public GameSurfaceView(Context context) {
        this(context, null,0);
    }

    public GameSurfaceView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
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
        this.surfaceHolder=this.getHolder();
        surfaceHolder.addCallback(this);
        paint=new Paint();
        paint.setColor(Color.parseColor("#a3a3a3"));
        paint.setTextSize(150f);
        paint.setAntiAlias(true);//设置无锯齿
        paint.setStrokeWidth(10);//设置画笔粗细值
        paint.setStyle(Paint.Style.FILL);//设置画笔是否填充
        setFocusable(true);//设置获取焦点

    }
    /**在surfaceChanged执行后执行2次*/
    @Override
    public void surfaceRedrawNeeded(SurfaceHolder holder) {
        Log.e(TAG, "surfaceRedrawNeeded: ----------------------" );

    }

    /**初始化view时,首先执行*/
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        Log.e(TAG, "surfaceCreated: ---------------------------" );
        screenW=this.getWidth();
        screenH=this.getHeight();
        flag=true;
        thread=new Thread(this);
        thread.start();
        drawContent();

    }

    private void drawContent() {
        try {
            canvas=surfaceHolder.lockCanvas();
            if (canvas!=null){
                canvas.drawColor(Color.WHITE);
                canvas.drawText("Game",textX,textY,paint);

                canvas.drawPoint(100,100,paint);
                canvas.drawPoints(new float[]{100,100,120,120},paint);
                canvas.drawLine(100,80,70,150,paint);
                canvas.drawLines(new float[]{100,80,70,150,150,90,250,170},paint);
                canvas.drawRect(10,60,40,100,paint);

                Path path=new Path();
//                path.moveTo(0,0);
//                path.lineTo(500,500);
//                path.lineTo(300,800);
                path.addCircle(500,500,500,Path.Direction.CW);//ccw--字符顶部在圆内,cw---字符顶部在圆外
                canvas.drawTextOnPath("hfdsfgdfhjfhsjdfhdhfjdfhdjnfdjskfjdhnfkhgfhsghfgdfgfgssfgsfdgsdggfgfsgdgddjfkjfewjfeihfnkjdfndsjkfnh",path,0,0,paint);

            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (canvas!=null){
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }

    }
    /**在surfaceCreated后执行*/
    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        Log.e(TAG, "surfaceChanged: -----------------------" );

    }
    /**销毁时执行*/
    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        flag=false;//销毁时终止线程
        Log.e(TAG, "surfaceDestroyed: -----------------------" );
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        textX= (int) event.getX()-175;
        textY= (int) event.getY()+75;
//        drawContent();
        Log.e(TAG, "onTouchEvent: ------------------eee" );
        return true;
    }

    @Override
    public void run() {
        while (flag){
            long start= System.currentTimeMillis();
            drawContent();
            long end=System.currentTimeMillis();
            if (end-start<50){
                try {
                    Thread.sleep(50-end+start);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
