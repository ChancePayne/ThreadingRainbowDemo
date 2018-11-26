package com.lambdaschool.threadingrainbowdemo;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.drawable.TransitionDrawable;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final int TRANSITION_DURATION = 500;
    View     parent;
    TextView textView;
    int      colorCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = findViewById(R.id.output_text);

        colorCode = 0;
        parent = findViewById(R.id.parent_main);
        findViewById(R.id.color_change_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeParentBackgroundColor();
            }
        });
        new Task().execute();
    }

    @Override
    protected void onResume() {
        super.onResume();

        /*String text = "";
        for(int i = 0; i < 10000; ++i) {
            text += i;
        }
        Log.i(getPackageName(), text);*/

//        exceptionCheck();


        /*Thread task = new Thread(new Runnable() {
            @Override
            public void run() {
                String text = "";
                for(int i = 0; i < 10000; ++i) {
                    text += i;
                    *//*try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }*//*
                }
                final String finalText = text;
                Log.i(getPackageName(), text);
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        ((TextView)findViewById(R.id.output_text)).setText(finalText);
                        changeParentBackgroundColor();
                    }
                });
            }
        });
        task.start();*/
        /*try {
            task.join();
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    private int exceptionCheck() {
        Integer num = null;
        if(num != null) {
            return num.byteValue();
        } else {
            return 0;
        }
    }

    public class Task extends AsyncTask<Void, Integer, String> {
        @Override
        protected void onPreExecute() {
            findViewById(R.id.progress_bar).setVisibility(View.VISIBLE);
        }

        @Override
        protected String doInBackground(Void... voids) {
            String text = "";
            for(int i = 0; i < 100; ++i) {
                text += i;
                publishProgress(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return text;
        }

        @Override
        protected void onPostExecute(String finalText) {
            findViewById(R.id.progress_bar).setVisibility(View.GONE);
            textView.setText(finalText);
            changeParentBackgroundColor();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            textView.setText(values[0].toString());
        }
    }

    private void changeParentBackgroundColor() {
    /*switch(colorCode) {
        case 0:
            parent.setBackgroundColor(getResources().getColor(android.R.color.holo_red_dark));
            break;
        case 1:
            parent.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_dark));
            break;
        case 2:
            parent.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
            break;
        case 3:
            parent.setBackgroundColor(getResources().getColor(android.R.color.holo_green_dark));
            break;
        case 4:
            parent.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_dark));
            break;
        case 5:
            parent.setBackgroundColor(getResources().getColor(android.R.color.holo_purple));
            break;
        default:
            parent.setBackgroundColor(getResources().getColor(android.R.color.background_light));
            colorCode = -1;
    }
    colorCode++;*/
        // To use this, must create a transition drawable like transition_drawable.xml
        // and reference it in the View using android:background="@drawable/transition_drawable"
        // (replace transition_drawable with the name of your file)
                /*TransitionDrawable transition = (TransitionDrawable) parent.getBackground();
                transition.startTransition(500);*/
        int colorFrom;
        int colorTo;

        switch (colorCode) {
            case 0:
                colorFrom = getResources().getColor(android.R.color.background_light);
                colorTo = getResources().getColor(android.R.color.holo_red_dark);
                break;
            case 1:
                colorFrom = getResources().getColor(android.R.color.holo_red_dark);
                colorTo = getResources().getColor(android.R.color.holo_orange_dark);
                break;
            case 2:
                colorFrom = getResources().getColor(android.R.color.holo_orange_dark);
                colorTo = getResources().getColor(android.R.color.holo_orange_light);
                break;
            case 3:
                colorFrom = getResources().getColor(android.R.color.holo_orange_light);
                colorTo = getResources().getColor(android.R.color.holo_green_dark);
                break;
            case 4:
                colorFrom = getResources().getColor(android.R.color.holo_green_dark);
                colorTo = getResources().getColor(android.R.color.holo_blue_dark);
                break;
            case 5:
                colorFrom = getResources().getColor(android.R.color.holo_blue_dark);
                colorTo = getResources().getColor(android.R.color.holo_purple);
                break;
            default:
                colorFrom = getResources().getColor(android.R.color.holo_purple);
                colorTo = getResources().getColor(android.R.color.background_light);
                colorCode = -1;
        }
        colorCode++;

        ValueAnimator colorAnimation = ValueAnimator.ofObject(new ArgbEvaluator(), colorFrom, colorTo);
        colorAnimation.setDuration(TRANSITION_DURATION);
        colorAnimation.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {

            @Override
            public void onAnimationUpdate(ValueAnimator animator) {
                parent.setBackgroundColor((int) animator.getAnimatedValue());
            }

        });
        colorAnimation.start();
    }
}
