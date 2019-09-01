package com.hoanngothanh.scorekeeper;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<Integer> mScoreTeamA;
    private MutableLiveData<Integer> mScoreTeamB;
    private MutableLiveData<Integer> mFoulsTeamA;
    private MutableLiveData<Integer> mFoulsTeamB;

    public MutableLiveData<Integer> getScoreTeamA() {
        if (mScoreTeamA == null) {
            mScoreTeamA = new MutableLiveData<>();
        }
        return mScoreTeamA;

    }

    public MutableLiveData<Integer> getFoulsTeamA() {
        if (mFoulsTeamA == null) {
            mFoulsTeamA = new MutableLiveData<>();
        }
        return mFoulsTeamA;

    }

    public MutableLiveData<Integer> getScoreTeamB() {
        if (mScoreTeamB == null) {
            mScoreTeamB = new MutableLiveData<>();
        }
        return mScoreTeamB;

    }

    public MutableLiveData<Integer> getFoulsTeamB() {
        if (mFoulsTeamB == null) {
            mFoulsTeamB = new MutableLiveData<>();
        }
        return mFoulsTeamB;

    }

    public void setScoreTeamA(int score) {
        mScoreTeamA.setValue(score);
    }

    public void setScoreTeamB(int score) {
        mScoreTeamB.setValue(score);
    }

    public void setFoulsTeamA(int fouls) {
        mFoulsTeamA.setValue(fouls);
    }

    public void setFoulsTeamB(int fouls) {
        mFoulsTeamB.setValue(fouls);
    }
}
