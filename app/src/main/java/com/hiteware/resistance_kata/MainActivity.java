package com.hiteware.resistance_kata;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private Integer[][] grid_condition_one;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setup_condition_one();

        final Button button = (Button) findViewById(R.id.solution1_button);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Resistance resistance = new Resistance(grid_condition_one);
                print_grid(grid_condition_one);
                ((TextView) findViewById(R.id.Path_Completed)).setText("Yes");
                ((TextView) findViewById(R.id.Resistance)).setText(Integer.toString(resistance.leastResistanceCount()));
                ((TextView) findViewById(R.id.Path)).setText(resistance.path().toString());
            }
        });
    }

    private void print_grid(Integer[][] grid)
    {
        ((TextView) findViewById(R.id.textView1)).setText(Arrays.toString(grid[0]));
        ((TextView) findViewById(R.id.textView2)).setText(Arrays.toString(grid[1]));
        ((TextView) findViewById(R.id.textView3)).setText(Arrays.toString(grid[2]));
        ((TextView) findViewById(R.id.textView4)).setText(Arrays.toString(grid[3]));
        ((TextView) findViewById(R.id.textView5)).setText(Arrays.toString(grid[4]));
    }

    private void setup_condition_one() {
        int rows = 5;
        int columns = 6;
        grid_condition_one = new Integer[rows][columns];
        grid_condition_one[0][0]=3 ;
        grid_condition_one[0][1]=4 ;
        grid_condition_one[0][2]=1 ;
        grid_condition_one[0][3]=2 ;
        grid_condition_one[0][4]=8 ;
        grid_condition_one[0][5]=6 ;
        grid_condition_one[1][0]=6 ;
        grid_condition_one[1][1]=1 ;
        grid_condition_one[1][2]=8 ;
        grid_condition_one[1][3]=2 ;
        grid_condition_one[1][4]=7 ;
        grid_condition_one[1][5]=4 ;
        grid_condition_one[2][0]=5 ;
        grid_condition_one[2][1]=9 ;
        grid_condition_one[2][2]=3 ;
        grid_condition_one[2][3]=9 ;
        grid_condition_one[2][4]=9 ;
        grid_condition_one[2][5]=5 ;
        grid_condition_one[3][0]=8 ;
        grid_condition_one[3][1]=4 ;
        grid_condition_one[3][2]=1 ;
        grid_condition_one[3][3]=3 ;
        grid_condition_one[3][4]=2 ;
        grid_condition_one[3][5]=6 ;
        grid_condition_one[4][0]=3 ;
        grid_condition_one[4][1]=7 ;
        grid_condition_one[4][2]=2 ;
        grid_condition_one[4][3]=8 ;
        grid_condition_one[4][4]=6 ;
        grid_condition_one[4][5]=4 ;
    }


}
