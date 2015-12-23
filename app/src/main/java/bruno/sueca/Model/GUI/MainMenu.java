package bruno.sueca.Model.GUI;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import bruno.sueca.R;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainmenu);

        Button newgamebutton = (Button) findViewById(R.id.newgame);
        newgamebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Game.class);
                startActivity(intent);
            }
        });

        Button rulesbutton = (Button) findViewById(R.id.rules);
        rulesbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //show rules
            }
        });

        Button settingsbutton = (Button) findViewById(R.id.settings);
        settingsbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //show settings
            }
        });

    }

}
