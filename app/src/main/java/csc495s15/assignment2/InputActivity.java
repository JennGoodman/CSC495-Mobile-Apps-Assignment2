package csc495s15.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;

/**
 * Created by Andrew Schaefer.
 * Modified by Jenn Goodman on 1/21/15.
 */

public class InputActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);

        Intent callingIntent = this.getIntent();
        Bundle incomingBundle = callingIntent.getExtras();
        PositionPlayer player = incomingBundle.getParcelable("player");

        TextView pNameTextView = (TextView) findViewById(R.id.positionNameTextView);
        EditText fNameEditText = (EditText) findViewById(R.id.fNameEditText);
        EditText lNameEditText = (EditText) findViewById(R.id.lNameEditText);

        pNameTextView.setText(player.getPositionName());
        fNameEditText.setText(player.getFirstName());
        lNameEditText.setText(player.getLastName());
    }

    public void handleSubmitButtonClick(View v) {
        // Gui Objects
        TextView pNameTextView = (TextView) findViewById(R.id.positionNameTextView);
        EditText fNameEditText = (EditText) findViewById(R.id.fNameEditText);
        EditText lNameEditText = (EditText) findViewById(R.id.lNameEditText);

        // Data Objects
        Bundle outgoingBundle = new Bundle();
        Intent returnIntent = new Intent();

        // Booya Object
        outgoingBundle.putParcelable("mPlayer",
                new PositionPlayer(
                    pNameTextView.getText().toString(),
                    fNameEditText.getText().toString(),
                    lNameEditText.getText().toString()));

        // Goodbye
        setResult(RESULT_OK, returnIntent.putExtras(outgoingBundle));
        finish();
    }

    public void handleCancelButtonClick(View v) {
        setResult(RESULT_CANCELED);
        finish();
    }
}