package com.example.jeannie.budgetapp;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText txtMonthlyNetIncome;
    private EditText txtRent;
    private EditText txtCar;
    private EditText txtCarInsurance;
    private EditText txtMemberships;
    private EditText txtTravel;
    private EditText txtStudentLoans;
    private EditText txtGas;
    private EditText txtGym;
    private EditText txtFun;
    private EditText txtMiscEtc;
    private TextView lblOutputTotalExpenses;
    private TextView lblOutputRemainingBudget;
    private Button btnCalculate;
    private Button btnReset;

    private String messageExpenses = "";
    private String messageRemainingBudget = "";

    public void resetBudget() {

        txtMonthlyNetIncome.setText("");
        txtRent.setText("");
        txtCar.setText("");
        txtCarInsurance.setText("");
        txtMemberships.setText("");
        txtTravel.setText("");
        txtStudentLoans.setText("");
        txtGas.setText("");
        txtGym.setText("");
        txtFun.setText("");
        txtMiscEtc.setText("");


        messageExpenses = "Enter in your expenses above and click Calculate!";
        lblOutputTotalExpenses.setText(messageExpenses);

        messageRemainingBudget = " ";
        lblOutputRemainingBudget.setText(messageRemainingBudget);
    }
    public void calculate(){
        /*String monthlyNetIncome = formatter.format(Float.valueOf(txtMonthlyNetIncome.getText().toString()));
        String rent = formatter.format(Float.valueOf(txtRent.getText().toString()));
        String car = formatter.format(Float.valueOf(txtCar.getText().toString()));
        String carInsurance = formatter.format(Float.valueOf(txtCarInsurance.getText().toString()));
        String memberships = formatter.format(Float.valueOf(txtMemberships.getText().toString()));
        String travel = formatter.format(Float.valueOf(txtTravel.getText().toString()));
        String studentLoans = formatter.format(Float.valueOf(txtStudentLoans.getText().toString()));
        String gas = formatter.format(Float.valueOf(txtGas.getText().toString()));
        String gym = formatter.format(Float.valueOf(txtGym.getText().toString()));
        String fun = formatter.format(Float.valueOf(txtFun.getText().toString()));
        String miscEtc = formatter.format(Float.valueOf(txtMiscEtc.getText().toString()));
        */
        String monthlyNetIncomeText = txtMonthlyNetIncome.getText().toString();
        String rentText = txtRent.getText().toString();
        String carText = txtCar.getText().toString();
        String carInsuranceText = txtCarInsurance.getText().toString();
        String membershipsText = txtMemberships.getText().toString();
        String travelText = txtTravel.getText().toString();
        String studentLoansText = txtStudentLoans.getText().toString();
        String gasText = txtGas.getText().toString();
        String gymText = txtGym.getText().toString();
        String funText = txtFun.getText().toString();
        String miscEtcText = txtMiscEtc.getText().toString();


        //Calculate Total Expenses
        try {
            int monthlyNetIncome = Integer.parseInt(monthlyNetIncomeText);
            int rent = Integer.parseInt(rentText);
            int car = Integer.parseInt(carText);
            int carInsurance = Integer.parseInt(carInsuranceText);
            int memberships = Integer.parseInt(membershipsText);
            int travel = Integer.parseInt(travelText);
            int studentLoans = Integer.parseInt(studentLoansText);
            int gas = Integer.parseInt(gasText);
            int gym = Integer.parseInt(gymText);
            int fun = Integer.parseInt(funText);
            int miscEtc = Integer.parseInt(miscEtcText);

            //Display error message if inputs are <0
            if (monthlyNetIncome<0 || rent<0 || car<0 || carInsurance<0 || memberships<0 || travel<0 || studentLoans<0 || gas<0 || gym<0 || fun<0 || miscEtc<0){
                throw new Exception("Please enter positive numbers and no letters please!");
            }

            //Total Expenses
            int totalExpenses = rent + car + carInsurance + memberships + travel + studentLoans + gas + gym + fun + miscEtc;
            //String totalExpensesXX = String.format("%.2f", totalExpenses);
            messageExpenses = "Total Expenses is: $" + totalExpenses;//XX;

            //Remaining Budget
            int remainingBudget = monthlyNetIncome - totalExpenses;
            //String remainingBudgetXX = String.format("%.2f", remainingBudget);
            messageRemainingBudget = "Remaining Budget is: $" + remainingBudget;//XX;
        }
        catch (Exception e){
            messageExpenses = "Please enter positive integers and no letters please!";
            messageRemainingBudget = "";
        }
        finally {
            //Show expenses & Remaining Budget once calculated
            lblOutputTotalExpenses.setText(messageExpenses);
            lblOutputRemainingBudget.setText(messageRemainingBudget);
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMonthlyNetIncome = (EditText) findViewById(R.id.txtMonthlyNetIncome);
        txtRent = (EditText) findViewById(R.id.txtRent);
        txtCar = (EditText) findViewById(R.id.txtCar);
        txtCarInsurance = (EditText) findViewById(R.id.txtCarInsurance);
        txtMemberships = (EditText) findViewById(R.id.txtMemberships);
        txtTravel = (EditText) findViewById(R.id.txtTravel);
        txtStudentLoans = (EditText) findViewById(R.id.txtStudentLoans);
        txtGas = (EditText) findViewById(R.id.txtGas);
        txtGym = (EditText) findViewById(R.id.txtGym);
        txtFun = (EditText) findViewById(R.id.txtFun);
        txtMiscEtc = (EditText) findViewById(R.id.txtMiscEtc);

        btnCalculate = (Button) findViewById(R.id.btnCalculate);
        btnReset = (Button) findViewById(R.id.btnReset);

        lblOutputTotalExpenses = (TextView) findViewById(R.id.lblOutputTotalExpenses);
        lblOutputRemainingBudget = (TextView) findViewById(R.id.lblOutputRemainingBudget);

        //resetBudget();

        btnCalculate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                calculate();
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                resetBudget();
            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
