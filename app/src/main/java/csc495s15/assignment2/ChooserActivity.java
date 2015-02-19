package csc495s15.assignment2;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.content.Intent;

/**
 * Created by Andrew Schaefer.
 * Modified by Jenn Goodman on 1/21/15.
 */

public class ChooserActivity extends ActionBarActivity {

    private PositionPlayer[] positionPlayers = new PositionPlayer[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chooser);

        positionPlayers[0] = new PositionPlayer("QB","Cam","Newton");
        positionPlayers[1] = new PositionPlayer("RB", "DeAngelo", "Williams");
        positionPlayers[2] = new PositionPlayer("WR", "Jerricho", "Cotchery");

        Spinner playerSpinner = (Spinner) findViewById(R.id.positionSpinner);

        ArrayAdapter<PositionPlayer> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, positionPlayers);

        playerSpinner.setAdapter(adapter);
    }

    public void handleModifyClick(View v) {
        Intent intent = new Intent(this, InputActivity.class);
        Spinner playerSpinner = (Spinner) findViewById(R.id.positionSpinner);
        Bundle bundle = new Bundle();
        
        bundle.putParcelable("player", positionPlayers[playerSpinner.getSelectedItemPosition()]);

        intent.putExtras(bundle);

        startActivityForResult(intent, 1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent returnIntent) {
        if(requestCode == 1 && resultCode == RESULT_OK) {
            Bundle returnBundle = returnIntent.getExtras();
            PositionPlayer mPlayer = returnBundle.getParcelable("mPlayer");

            // Changed to a switch, cause better code yo.
            switch (mPlayer.getPositionName()) {
                case "QB":
                    positionPlayers[0] = mPlayer;
                    break;
                case "RB":
                    positionPlayers[1] = mPlayer;
                    break;
                case "WR":
                    positionPlayers[2] = mPlayer;
            }

            Spinner playerSpinner = (Spinner) findViewById(R.id.positionSpinner);
            ArrayAdapter<PositionPlayer> adapter = new ArrayAdapter<>(this,
                    android.R.layout.simple_spinner_item, positionPlayers);

            playerSpinner.setAdapter(adapter);
        }
    }
}
