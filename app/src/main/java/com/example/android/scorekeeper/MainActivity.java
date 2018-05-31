package com.example.android.scorekeeper;

import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private int[][] metrics = {{0, 0}, {0, 0}, {0,0}};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * The method used to update a metric
     * @param text The text that represents the content of the metric
     * @param number The value of the metric
     * @param id the id of resource containing the metrci
     */
    public void updateMetric(String text, int number, int id) {
        TextView updateText = findViewById(id);
        updateText.setText(text + " " + number);
    }

    /**
     * The method that updates the number of goals made by the first team
     * @param view
     */
    public void updateFirstTeamGoals(View view) {
        metrics[0][0]++;
        updateMetric("", metrics[0][0], R.id.first_team_score);
    }

    public void updateSecondTeamGoals(View view) {
        metrics[0][1]++;
        updateMetric("", metrics[0][1], R.id.second_team_score);
    }

    public void updateFirstTeamPenalties(View view) {
        metrics[1][0]++;
        updateMetric("Penalties: ", metrics[1][0], R.id.first_team_penalties);
    }

    public void updateSecondTeamPenalties(View view) {
        metrics[1][1]++;
        updateMetric("Penalties: ", metrics[1][1], R.id.second_team_penalties);
    }

    public void updateFirstTeamFouls(View view) {
        metrics[2][0]++;
        updateMetric("Fouls: ", metrics[2][0], R.id.first_team_fouls);
    }

    public void updateSecondTeamFouls(View view) {
        metrics[2][1]++;
        updateMetric("Fouls: ", metrics[2][1], R.id.second_team_fouls);
    }

    public void resetMetrics(View view) {
        for (int i = 0; i < metrics.length; i++)
            for (int j = 0; j < metrics[0].length; j++)
                metrics[i][j] = -1;
        updateFirstTeamGoals(view);
        updateFirstTeamFouls(view);
        updateFirstTeamPenalties(view);
        updateSecondTeamGoals(view);
        updateSecondTeamFouls(view);
        updateSecondTeamPenalties(view);
    }
}
