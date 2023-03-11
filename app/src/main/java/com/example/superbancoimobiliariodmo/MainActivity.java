package com.example.superbancoimobiliariodmo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText inputEditTextCredit;
    private EditText inputEditTextDebit;
    private EditText inputEditTextValue;
    private Button creditButton;
    private Button debitButton;
    private TextView outputTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEditTextDebit = findViewById(R.id.edittext_card_debit);
        inputEditTextCredit = findViewById(R.id.edittext_card_credit);
        inputEditTextValue = findViewById(R.id.edittext_value);

        creditButton = findViewById(R.id.button_credito);
        debitButton = findViewById(R.id.button_debito);
        outputTextView = findViewById(R.id.textview_value);

    }
}