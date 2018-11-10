package sunrec.com.sunrec;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;

public class ProfileActivity extends AppCompatActivity {

    private ProgressBar progressEXP;
    private ProgressBar progressLVL;
    private ProgressBar progressRank;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        progressEXP = findViewById(R.id.progressEXP);
        progressLVL = findViewById(R.id.progressLVL);
        progressRank = findViewById(R.id.progressRank);

        ProgressAnimation expAnimation = new ProgressAnimation(progressEXP, 0f, 100f);
        expAnimation.setDuration(1000);
        ProgressAnimation rankAnimation = new ProgressAnimation(progressRank, 0f, 100f);
        rankAnimation.setDuration(1000);
        ProgressAnimation lvlAnimation = new ProgressAnimation(progressLVL, 0f, calculateXpProgress(666, 1260));
        lvlAnimation.setDuration(1000);

        progressRank.startAnimation(rankAnimation);
        progressEXP.startAnimation(expAnimation);
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
