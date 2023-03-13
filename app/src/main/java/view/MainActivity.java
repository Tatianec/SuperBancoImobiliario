package view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.superbancoimobiliariodmo.R;

import model.CreditCard;
import model.StarBank;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText inputEditTextCredit;
    private EditText inputEditTextDebit;
    private EditText inputEditTextValue;
    private Button creditButton;
    private Button debitButton;
    private Button payButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputEditTextDebit = findViewById(R.id.edittext_card_debit);
        inputEditTextCredit = findViewById(R.id.edittext_card_credit);
        inputEditTextValue = findViewById(R.id.edittext_value);

        creditButton = findViewById(R.id.button_credito);
        debitButton = findViewById(R.id.button_debito);

        payButton = findViewById(R.id.button_emprestimo);

        creditButton.setOnClickListener(this);
        debitButton.setOnClickListener(this);
        payButton.setOnClickListener(this);

        start();

    }

    @Override
    public void onClick(View view) {

        if(!isValidOperation()){
            Toast.makeText(this, "Por favor, verifique os ids dos cartoes e/ou valor", Toast.LENGTH_LONG).show();
            return;
        }

        CreditCard payer = StarBank.getInstance().getCardById(Integer.valueOf(inputEditTextCredit.getText().toString()));
        double value = Double.valueOf(inputEditTextValue.getText().toString());
        boolean isValidTranfer = true;

        switch (view.getId()){
            case R.id.button_credito: {
                if(!inputEditTextDebit.getText().toString().isEmpty()){
                    CreditCard receiver = StarBank.getInstance().getCardById(
                            Integer.valueOf(inputEditTextDebit.getText().toString()));

                    StarBank.getInstance().transfer(payer, receiver, value);

                    Toast.makeText(this, "Pagador: " + payer.getBalance() + "\nRecebedor: " + receiver.getBalance(),
                            Toast.LENGTH_LONG).show();
                }else {
                    isValidTranfer = false;
                    Toast.makeText(this, "Por favor, preencha o cartao do recebedor", Toast.LENGTH_LONG).show();
                }
            }
            break;

            case R.id.button_debito:
                StarBank.getInstance().pay(payer, value);
                 showToastPayer(payer);
            break;

            case R.id.button_emprestimo:
                StarBank.getInstance().receive(payer, value);
                showToastPayer(payer);
            break;
        }

        if(isValidTranfer){
            StarBank.getInstance().roundCompleted(payer, 20);
        }

    }

    private void start(){
        StarBank.getInstance().starCreditCards();
    }

    private void showToastPayer(CreditCard payer){
        Toast.makeText(this, "Cartão " + payer.getId() + " Saldo: " + payer.getBalance(),
                Toast.LENGTH_LONG).show();
    }

    private boolean isValidOperation(){

        if(inputEditTextCredit.getText().toString().isEmpty() || inputEditTextValue.getText().toString().isEmpty()){
            return false;
        }

        int firstCardId = Integer.valueOf(inputEditTextCredit.getText().toString());
        int secondCardId = inputEditTextDebit.getText().toString().isEmpty() ? 0 : Integer.valueOf(inputEditTextDebit.getText().toString());
        double value = Double.valueOf(inputEditTextValue.getText().toString());

        //Valida cartao
        if ( (firstCardId < 0 && firstCardId > 6) && (secondCardId < 0 && secondCardId > 6) ){
            return false;
        }
        //valida valor
        if (value < 0 ){
            return false;
        }

        return true;
    }
}