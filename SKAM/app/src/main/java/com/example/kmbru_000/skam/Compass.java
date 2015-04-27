package com.example.kmbru_000.skam;

/**
 * Created by kmbru_000 on 4/22/2015.
 *
 * This custom view displays the content of the Compass2Activity activity.
 * It uses a canvas bitmap to draw shapes such as the sweepGradient circle that is the circle of the compass.
 */
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;


public class Compass extends View {

    private float direction;

    private Paint rimPaint;
    private RectF rimRect;
    private Paint rimCirclePaint;
    private Paint nickPaint;

    private RectF faceRect;
    private Bitmap faceTexture;
    private Paint facePaint;
    private Paint rimShadowPaint;

    private Paint scalePaint;
    private RectF scaleRect;
    private Paint directionPaint;

    LightingColorFilter logoFilter;
    Paint logoPaint;

    private Bitmap mBackgroundImg;
    private int backgroundImgID;

    private Bitmap background; // holds the cached static part

    private Paint mPaint,  backgroundPaint;

    public Compass(Context context) {
        super(context);
        init(null);
    }

    public Compass(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs);

    }

    public Compass(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs);
    }

    private void init(AttributeSet attrs) {
        initAttrs(attrs);

        logoFilter = new LightingColorFilter(0xff5aa555, 0x88);
        logoPaint = new Paint();
        logoPaint.setFilterBitmap(true);
        logoPaint.setColorFilter(logoFilter);

        mBackgroundImg = BitmapFactory.decodeResource(getContext().getResources(), backgroundImgID);
       // backgroundPaint = new Paint();
       // backgroundPaint.setFilterBitmap(true);

        rimRect = new RectF(0.0f, 0.0f, 1.0f, 1.0f);
        rimPaint = new Paint();
        rimPaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        rimPaint.setShader(new LinearGradient(0.40f, 0.0f, 0.60f, 1.0f,
                Color.rgb(0xf0, 0xf5, 0xf0),
                Color.rgb(0x30, 0x31, 0x30),
                Shader.TileMode.CLAMP));

        rimCirclePaint = new Paint();
        rimCirclePaint.setAntiAlias(true);
        rimCirclePaint.setStyle(Paint.Style.STROKE);
        rimCirclePaint.setColor(Color.argb(0x4f, 0x33, 0x36, 0x33));
        rimCirclePaint.setStrokeWidth(0.005f);

        float rimSize = 0.06f;
        faceRect = new RectF();
        faceRect.set(rimRect.left + rimSize, rimRect.top + rimSize,
                rimRect.right - rimSize, rimRect.bottom - rimSize);


        faceTexture = BitmapFactory.decodeResource(getContext().getResources(),
                backgroundImgID);
        BitmapShader paperShader = new BitmapShader(faceTexture,
                Shader.TileMode.CLAMP,
                Shader.TileMode.CLAMP);
        Matrix paperMatrix = new Matrix();
        paperMatrix.setScale(1.0f / faceTexture.getWidth(),
                1.0f / faceTexture.getHeight());
        paperShader.setLocalMatrix(paperMatrix);

        facePaint = new Paint();
        facePaint.setColor(Color.argb(0xff, 0x00, 0x00, 0x00));
        facePaint.setStyle(Paint.Style.FILL);
        facePaint.setFilterBitmap(true);
        //facePaint.setShader(paperShader);


        scalePaint = new Paint();
        scalePaint.setStyle(Paint.Style.STROKE);
        scalePaint.setColor(0xffffffff);
        scalePaint.setStrokeWidth(0.002f);
        scalePaint.setAntiAlias(true);
        scalePaint.setTextSize(0.025f);
        scalePaint.setTypeface(Typeface.SANS_SERIF);
        //scalePaint.setTextScaleX(0.8f);
        scalePaint.setTextAlign(Paint.Align.CENTER);
        scalePaint.setLinearText(true); // added by Kevin to solve a display problem


        float scalePosition = 0.0f;
        scaleRect = new RectF();
        scaleRect.set(faceRect.left + scalePosition, faceRect.top + scalePosition,
                faceRect.right - scalePosition, faceRect.bottom - scalePosition);

        directionPaint = new Paint();
        directionPaint = new Paint();
        directionPaint.setStyle(Paint.Style.FILL);
        directionPaint.setColor(0xffffffff);
        directionPaint.setStrokeWidth(0.006f);
        directionPaint.setAntiAlias(true);
        directionPaint.setTextSize(0.1f);
        directionPaint.setTypeface(Typeface.SANS_SERIF);
        directionPaint.setTextAlign(Paint.Align.CENTER);
        directionPaint.setLinearText(true);


        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(2);
        mPaint.setTextSize(40);
        mPaint.setTextAlign(Paint.Align.CENTER);
        mPaint.setLinearText(true);

    }

    private void initAttrs(AttributeSet attrs){
        if (attrs != null) {
            String packageName = "http://schemas.android.com/apk/res-auto";
            //title = attrs.getAttributeValue(packageName, "title");
            //subtitle = attrs.getAttributeValue(packageName, "subtitle");
            backgroundImgID = attrs.getAttributeResourceValue(packageName, "image", R.drawable.compassbkg2);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(
                MeasureSpec.getSize(widthMeasureSpec),
                MeasureSpec.getSize(heightMeasureSpec));
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        regenerateBackground();
    }

    private void regenerateBackground() {
        float width = (float) getWidth();
        float height = (float) getHeight();

        background = Bitmap.createBitmap((int) width, (int) height, Bitmap.Config.ARGB_8888);
        Canvas backgroundCanvas = new Canvas(background);

        float scale = (float) getWidth();
        backgroundCanvas.scale(scale, scale);

        //drawRim(backgroundCanvas);
        //drawFace(backgroundCanvas);
        drawScale(backgroundCanvas);


    }

    @Override
    protected void onDraw(Canvas canvas) {

        int wid = getMeasuredWidth();
        int heig = getMeasuredHeight();
        int r;
        if(wid > heig){
            r = heig/2;
        }else{
            r = wid/2;
        }

        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);

        Paint myPaint = new Paint();
       // paint.setColor(Color.WHITE);

        //brown rim
    /*    paint.setShader(new LinearGradient(0.40f, 0.0f, 0.60f, 1.0f,
                Color.rgb(204,102,0),
                Color.rgb(102,51,0),
                Shader.TileMode.CLAMP));
     */
        paint.setShader(new SweepGradient(wid/2,heig/2,
                Color.rgb(204,102,0),
                Color.rgb(102,51,0)));
        paint.setStrokeWidth(100);
        paint.setColor(Color.rgb(102,51,0));
        canvas.drawCircle((wid/2), heig/2, r-60, paint);

        paint.setShader(null);

        //red rim
        paint.setStrokeWidth(40);
        paint.setColor(Color.rgb(153,0,0));
        canvas.drawCircle((wid/2), (heig/2), r-100, paint);


        //blue inside
        paint.setColor(Color.argb(80,0,51,102));
        paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(wid/2, heig/2,r-120, paint);

        //red compass line -dynamic
        paint.setStrokeWidth(10);
        paint.setColor(Color.RED);
        canvas.drawLine(
                wid / 2,
                heig / 2,
                (float) (wid / 2 + r * Math.sin(-direction)),
                (float) (heig / 2 - r * Math.cos(-direction)),
                paint);

        background = Bitmap.createBitmap((int) wid, (int) heig, Bitmap.Config.ARGB_8888);
        Canvas backgroundCanvas = new Canvas(background);

        drawScale(canvas);
    }

    public void update(float dir){
        direction = dir;
        invalidate();
    }

    private void drawScale(Canvas canvas) {
        canvas.drawOval(scaleRect, scalePaint);

        canvas.save(Canvas.MATRIX_SAVE_FLAG);

        int degreesPerNick = 3;
        int total = 360/degreesPerNick;

        for (int i = 0; i < total; ++i) {
            float y1 = scaleRect.top;
            float y2 = y1 + 0.020f;
            int degree = i*degreesPerNick;

            canvas.drawLine(0.5f, y1, 0.5f, y2, scalePaint);

            if (degree==0) {
                canvas.drawLine(0.5f, y1, 0.5f, y2 + 0.020f, directionPaint);
                directionPaint.setColor(0xffff0000);
                canvas.drawText("N", 0.5f, y2 + 0.1f, directionPaint);
                directionPaint.setColor(0xffffffff);
            } else if (degree==90){
                canvas.drawLine(0.5f, y1, 0.5f, y2 + 0.020f, directionPaint);
            }  else if (degree==180){
                canvas.drawLine(0.5f, y1, 0.5f, y2 + 0.020f, directionPaint);
            }  else if (degree==270){
                canvas.drawLine(0.5f, y1, 0.5f, y2 + 0.020f, directionPaint);
            } else if (i % 5 == 0) {
                int value = i*degreesPerNick;
                String valueString = Integer.toString(value);
                canvas.drawText(valueString, 0.5f, y2 + 0.025f, scalePaint);

            }

            canvas.rotate(degreesPerNick, 0.5f, 0.5f);
        }
        canvas.drawText("S", 0.5f,   0.88f, directionPaint);
        canvas.drawText("E", 0.85f,  0.53f, directionPaint);
        canvas.drawText("W", 0.15f, 0.53f, directionPaint);
        canvas.restore();

    }

}
