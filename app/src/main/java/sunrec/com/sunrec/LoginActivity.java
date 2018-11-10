package sunrec.com.sunrec;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private EditText edtUser;
    private EditText edtPassword;
    private Button btnConfirmLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUser = findViewById(R.id.edtUser);
        edtPassword = findViewById(R.id.edtPassword);
        btnConfirmLogin = findViewById(R.id.btnConfirmLogin);

        btnConfirmLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO implement server connection to retrieve login information
                String user = "user";
                String password = "1234";

                if (edtUser.getText().toString().equals(user) && edtPassword.getText().toString().equals(password)){
                    Intent goMain = new Intent(LoginActivity.this, MainActivity.class);
                    finish();
                    startActivity(goMain);
                }
            }
        });
    }
}
