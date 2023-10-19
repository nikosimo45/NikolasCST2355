package algonquin.cst2335.sime0023;

import static algonquin.cst2335.sime0023.R.id.loginButton;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
/**
 * @author Nikolas Simeunovic
 * @version 1.0
 */
public class MainActivity extends AppCompatActivity {
    TextView tv = null;
    EditText et = null;
    Button btn = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /** this holds the text at the centre of the screen */
        tv = findViewById(R.id.textView);
        /** This holds the password text at the centre of the screen */
        et = findViewById(R.id.editTextTextPassword);
        /** this holds the button for logging in */
        btn = findViewById(loginButton);

        btn.setOnClickListener(clk -> {
            String password = et.getText().toString();
            boolean passwordCheck = true;
            passwordCheck = checkPasswordComplexity(password);

            if (passwordCheck) {
                tv.setText("Your password meets the requirements");
            } else {
                tv.setText("You shall not pass!");
            }
        });
    }
    /** This function checks the password complexity
     *
     * @param pw The String object that we are checking
     * @return Returns true if
     */
    boolean checkPasswordComplexity(String pw) {
        boolean foundUpperCase, foundLowerCase, foundNumber, foundSpecial;
        foundUpperCase = foundLowerCase = foundNumber = foundSpecial = false;
        for (int i = 0; i < pw.length(); i++) {
            char charAtIndex = pw.charAt(i);
            if (Character.isUpperCase(charAtIndex)) {
                foundUpperCase = true;

            } else if (Character.isLowerCase(charAtIndex)) {
                foundLowerCase = true;

            } else if (Character.isDigit(charAtIndex)) {
                foundNumber = true;

            }else if(isSpecialCharacter(charAtIndex)){
                foundSpecial = true;
            }
        }
            if (!foundUpperCase) {
                Toast.makeText(this, "You are missing an uppercase letter", Toast.LENGTH_SHORT).show();
                return false;
            } else if (!foundLowerCase) {
                Toast.makeText(this, "You are missing a lowercase letter", Toast.LENGTH_SHORT).show();
                return false;
            } else if (!foundNumber) {
                Toast.makeText(this, "You are missing a number", Toast.LENGTH_SHORT).show();
                return false;
            } else if (!foundSpecial) {
                Toast.makeText(this, "You are missing a special character", Toast.LENGTH_SHORT).show();
                return false;
            }





        return true;
    }
    /** This function checks if the password has any special characters
     *
     * @param c - a character from the password
     * @return
     */
    boolean isSpecialCharacter(char c) {
        switch (c) {
            case '#':
                return true;
            case '$':
                return true;
            case '%':
                return true;
            case '^':
                return true;
            case '&':
                return true;
            case '!':
                return true;
            case '@':
                return true;
            case '?':
                return true;
            case '*':
                return true;
            default:
                return false;
        }
    }
}