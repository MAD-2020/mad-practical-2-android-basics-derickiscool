package sg.edu.np.WhackAMole;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    final String TAG = "Whack-A-Mole";
    private Button leftButton;
    private Button middleButton;
    private Button rightButton;
    private TextView scoreText;
    Integer score;



    /* Hint
        - The function setNewMole() uses the Random class to generate a random value ranged from 0 to 2.
        - Feel free to modify the function to suit your program.
    */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        leftButton = (Button) findViewById(R.id.buttonLeft);
        middleButton = (Button) findViewById(R.id.buttonMiddle);
        rightButton = (Button) findViewById(R.id.buttonRight);
        scoreText = (TextView) findViewById(R.id.scoreText);
        final ArrayList<Button> buttonList = new ArrayList<>();
        buttonList.add(leftButton);
        buttonList.add(middleButton);
        buttonList.add(rightButton);
        setNewMole(buttonList);
        score = 0;


        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG,"Left Button clicked!");
                if (leftButton.getText() == "*")
                {
                    Log.v(TAG,"Hit!, score added!");
                    score+=1;
                }
                else{
                    Log.v(TAG,"Missed, score deducted");
                    score -=1;
                }
                leftButton.setText("O");
                middleButton.setText("O");
                rightButton.setText("O");
                setNewMole(buttonList);
                scoreText.setText(String.valueOf(score));
            }
        });
        middleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG,"Middle Button clicked!");
                if (middleButton.getText() == "*")
                {
                    Log.v(TAG,"Hit!, score added!");
                    score+=1;
                }
                else{
                    Log.v(TAG,"Missed, score deducted");
                    score -=1;
                }
                leftButton.setText("O");
                middleButton.setText("O");
                rightButton.setText("O");
                setNewMole(buttonList);
                scoreText.setText(String.valueOf(score));
            }
        });
        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v(TAG,"Right Button clicked!");
                if (rightButton.getText() == "*")
                {
                    Log.v(TAG,"Hit!, score added!");
                    score+=1;
                }
                else{
                    Log.v(TAG,"Missed, score deducted");
                    score -=1;
                }
                leftButton.setText("O");
                middleButton.setText("O");
                rightButton.setText("O");
                setNewMole(buttonList);
                scoreText.setText(String.valueOf(score));

            }
        });


        Log.v(TAG, "Finished Pre-Initialisation!");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.v(TAG, "Starting GUI!");
        scoreText.setText(String.valueOf(score));

    }



    public void setNewMole(ArrayList<Button> bList)
    {

        leftButton.setText("O");
        middleButton.setText("O");
        rightButton.setText("O");
        Random ran = new Random();
        int randomLocation = ran.nextInt(3);
        Button selectedButton = bList.get(randomLocation);
        selectedButton.setText("*");






    }
}