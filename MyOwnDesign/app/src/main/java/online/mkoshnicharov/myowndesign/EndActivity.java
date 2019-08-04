package online.mkoshnicharov.myowndesign;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class EndActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        /*
            Get Elements By ID
        */
        TextView nameOutput = findViewById(R.id.nameOutput);
        TextView emailOutput = findViewById(R.id.emailOutput);
        /*
            Get Input Values
        */
        Editable nameValue = MainActivity.nameInput;
        Editable emailValue = MainActivity.emailInput;

        /*
            My Button
        */

        Button myLink = findViewById(R.id.myLink);

        myLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PublicFunctionality.openLink(EndActivity.this);

            }
        });

        /*
            Display Values
        */
        nameOutput.setText(nameValue);
        emailOutput.setText(emailValue);

    }
}
