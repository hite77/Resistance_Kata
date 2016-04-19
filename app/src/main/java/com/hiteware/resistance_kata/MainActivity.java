package com.hiteware.resistance_kata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button button = (Button) findViewById(R.id.solution1_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display_solution(Data.setup_condition_one());
            }
        });

        final Button button2 = (Button) findViewById(R.id.solution2_button);
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display_solution(Data.setup_condition_two());
            }
        });

        final Button button3 = (Button) findViewById(R.id.solution3_button);
        button3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                display_solution(Data.setup_condition_three());
            }
        });
    }

    private void display_solution(Integer[][] grid)
    {
        Resistance resistance = new Resistance(grid);
        print_grid(grid);
        String path_complete = (resistance.pathComplete()) ? "Yes" : "No";
        ((TextView) findViewById(R.id.Path_Completed)).setText(path_complete);
        ((TextView) findViewById(R.id.Resistance)).setText(Integer.toString(resistance.leastResistanceCount()));
        ((TextView) findViewById(R.id.Path)).setText(resistance.path().toString());
    }

    private void print_grid(Integer[][] grid)
    {
        ((TextView) findViewById(R.id.textView1)).setText(Arrays.toString(grid[0]));
        ((TextView) findViewById(R.id.textView2)).setText(Arrays.toString(grid[1]));
        ((TextView) findViewById(R.id.textView3)).setText(Arrays.toString(grid[2]));
        if (grid.length > 3) {
            ((TextView) findViewById(R.id.textView4)).setText(Arrays.toString(grid[3]));
            ((TextView) findViewById(R.id.textView5)).setText(Arrays.toString(grid[4]));
        }
        else
        {
            ((TextView) findViewById(R.id.textView4)).setText("");
            ((TextView) findViewById(R.id.textView5)).setText("");
        }
    }
}
