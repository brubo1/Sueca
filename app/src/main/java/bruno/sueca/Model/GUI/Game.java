package bruno.sueca.Model.GUI;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import bruno.sueca.Model.Core.Engine;
import bruno.sueca.R;

public class Game extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Engine engine = new Engine();

        //TODO: BUILD THE GUI MANUALLY. ASK DIFFICULTY (create the buttons, wait for input, remove buttons), start game!

    }

}
