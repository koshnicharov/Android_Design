package online.mkoshnicharov.myowndesign;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    public static Editable nameInput;
    public static Editable emailInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        /*
            Hide Title Bar
            Load Strings
            Start Activity
        */
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        loadLocale();
        setContentView(R.layout.activity_main);
        /*
            Set title
        */
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.title));
        /*
            Define Buttons
        */
        Button changeLanguage = findViewById(R.id.changeLanguage);
        Button myLink = findViewById(R.id.myLink);
        Button submit = findViewById(R.id.submit);
        /*
            Define Input Variables
        */
        final EditText nameBox = findViewById(R.id.nameBox);
        final EditText emailBox = findViewById(R.id.emailBox);
        /*
            Load Languages
        */
        changeLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showLangDialog();

            }
        });
        /*
            Open Link
        */
        myLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                PublicFunctionality.openLink(MainActivity.this);

            }
        });
        /*
            Submit User Input
        */
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*
                    Assigns Values to Public Variables
                */
                nameInput = nameBox.getText();
                emailInput = emailBox.getText();
                /*
                    Open new Activity
                */
                Intent intent = new Intent(view.getContext(), EndActivity.class);
                view.getContext().startActivity(intent);

            }
        });

    }
    /*
        Change Language Function
    */
    public void showLangDialog(){
        /*
            Build Window
        */
        final String[] listItems = {"English", "Български"};
        AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
        myBuilder.setTitle(R.string.change);
        myBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener(){

            @Override
            public void onClick(DialogInterface dialogInterface, int i){
                /*
                    Listen for Clicks
                */
                if(i == 0){

                   setLocale("en");
                   recreate();

                }else if(i ==1){

                   setLocale("bg");
                   recreate();

                }else{

                   // Function

                }
                /*
                    Close Window
                */
                dialogInterface.dismiss();

            }

        });
        /*
            Display Window
        */
        AlertDialog myDialog = myBuilder.create();
        myDialog.show();

    }
    /*
        Configurate Language
    */
    private void setLocale(String selectedLang) {

        Locale locale = new Locale(selectedLang);
        Locale.setDefault(locale);

        Configuration config = new Configuration();
        config.locale = locale;

        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());

        SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString("MyLang", selectedLang);
        editor.apply();

    }
    /*
        Get Saved Preference Value
    */
    public void loadLocale(){

        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("MyLang", "");
        setLocale(language);

    }

}
