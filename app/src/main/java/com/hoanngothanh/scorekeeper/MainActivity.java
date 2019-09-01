package com.hoanngothanh.scorekeeper;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import butterknife.BindView;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.team_a_score)
    TextView mScoreTeamA;
    @BindView(R.id.team_b_score)
    TextView mScoreTeamB;
    @BindView(R.id.team_a_foul)
    TextView mFoulTeamA;
    @BindView(R.id.team_b_foul)
    TextView mFoulTeamB;
    @BindView(R.id.add_score_team_a_btn)
    Button mAddScoreTeamA;
    @BindView(R.id.add_score_team_b_btn)
    Button mAddScoreTeamB;
    @BindView(R.id.add_foul_team_a_btn)
    Button mAddFoulsTeamA;
    @BindView(R.id.add_foul_team_b_btn)
    Button mAddFoulsTeamB;
    @BindView(R.id.reset_btn)
    Button mResetBtn;

    @BindView(R.id.team_a_foul_label)
    TextView mFoulLabelTeamA;
    @BindView(R.id.team_b_foul_label)
    TextView mFoulLabelTeamB;


    MainActivityViewModel model;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        model = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        model.getScoreTeamA().observe(this, integer -> {
            mScoreTeamA.setText(integer);
        });
        model.getScoreTeamB().observe(this, integer -> {
            mScoreTeamB.setText(integer);
        });
        model.getFoulsTeamA().observe(this, integer -> {
            mFoulTeamA.setText(integer);
        });
        model.getFoulsTeamB().observe(this, integer -> {
            mFoulTeamB.setText(integer);
        });
    }

    @OnClick(R.id.add_score_team_a_btn)
    void teamAddScoreClickA() {
        int value = model.getScoreTeamA().getValue() + 1;
        model.setScoreTeamA(value);
    }

    @OnClick(R.id.add_foul_team_a_btn)
    void foulAddTeamA() {
        int value = model.getFoulsTeamA().getValue() + 1;
        if (value >= 2) {
            mFoulLabelTeamA.setText("Fouls");
        }
        model.setFoulsTeamA(value);
    }

    @OnClick(R.id.add_score_team_b_btn)
    void teamAddScoreClickB() {
        int value = model.getScoreTeamB().getValue() + 1;
        model.setScoreTeamB(value);
    }

    @OnClick(R.id.add_foul_team_b_btn)
    void addFoulTeamB() {
        int value = model.getFoulsTeamB().getValue() + 1;
        if (value >= 2) {
            mFoulLabelTeamB.setText("Fouls");
        }
        model.setFoulsTeamB(value);
    }

    @OnClick(R.id.reset_btn)
    void resetPress() {
        model.setScoreTeamA(0);
        model.setScoreTeamB(0);
        model.setFoulsTeamA(0);
        model.setFoulsTeamB(0);
        mFoulLabelTeamA.setText("Foul");
        mFoulLabelTeamB.setText("Foul");
    }
}
