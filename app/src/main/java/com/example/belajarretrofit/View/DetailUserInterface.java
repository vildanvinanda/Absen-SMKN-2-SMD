package com.example.belajarretrofit.View;

public interface DetailUserInterface {
    void onProgres();

    void doneProgress();

    void onError(String localizedMessage);

    void onSuccses(String message);

    void message();

    void onTasksCompleted();
}
