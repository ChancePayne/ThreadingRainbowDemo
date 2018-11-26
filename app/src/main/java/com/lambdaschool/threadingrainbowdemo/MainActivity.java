package com.lambdaschool.threadingrainbowdemo;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.drawable.TransitionDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    public static final int TRANSITION_DURATION = 500;
    View parent;
    int  colorCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        colorCode = 0;
        parent = findViewById(R.id.parent_main);
        findViewById(R.id.color_change_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changeParentBackgroundColor();

            }
        });
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
