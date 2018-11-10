package sunrec.com.sunrec.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;

import sunrec.com.sunrec.R;

public class ProfileActivity extends AppCompatActivity {

    private ProgressBar progressLVL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        progressLVL = findViewById(R.id.progressLVL);
        ProgressAnimation lvlAnimation = new ProgressAnimation(progressLVL, 0f, calculateXpProgress(666, 1260));
        lvlAnimation.setDuration(1000);
        progressLVL.startAnimation(lvlAnimation);
    }

    public int calculateXpProgress(int currentXp, int fullXp){
        int levelProgress = 0;
        float result = ((float) currentXp / (float) fullXp) * 100;
        levelProgress = (int) result;
        return levelProgress;
    }

    private class ProgressAnimation extends Animation {
        private ProgressBar bar;
        private float from;
        private float to;

        public ProgressAnimation(ProgressBar bar, float from, float to){
            super();
            this.bar = bar;
            this.from = from;
            this.to = to;
        }

        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            super.applyTransformation(interpolatedTime, t);
            float value = from + (to - from) * interpolatedTime;
            bar.setProgress((int) value);
        }
    }
}
