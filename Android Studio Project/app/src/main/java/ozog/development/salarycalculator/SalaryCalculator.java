package ozog.development.salarycalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Currency;
import java.util.Locale;

public class SalaryCalculator extends AppCompatActivity {

    TextView salaryPerWeek, salaryPerMonth, salaryPerYear;
    Button btnCalculate;
    EditText hoursAmount, hourRate;
    Locale location;
    String localCurrency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary_calculator);

        location = Locale.getDefault();
        localCurrency = (Currency.getInstance(location)).getSymbol();

        salaryPerWeek = findViewById(R.id.salaryPerWeek);
        salaryPerMonth = findViewById(R.id.salaryPerMonth);
        salaryPerYear = findViewById(R.id.salaryPerYear);

        btnCalculate = findViewById(R.id.btnCalculate);
        hoursAmount = findViewById(R.id.hoursAmount);
        hourRate = findViewById(R.id.hourRate);

        salaryPerWeek.setText( ( localCurrency + 0 + " per week" ) );
        salaryPerMonth.setText( ( localCurrency + 0 + " per month" ) );
        salaryPerYear.setText( ( localCurrency + 0 + " per year" ) );
    }

    public double hourToWeek( double hourRate, int hoursAmount ) {
        return ( hourRate * hoursAmount );
    }

    public double hourToMonth( double hourRate, int hoursAmount) {
        return ( hourRate * hoursAmount * 4.345);
    }

    public double hourToYear( double hourRate, int hoursAmount ) {
        return ( hourRate * hoursAmount * 52.143);
    }

    public void calculateAll(View v) {

        try {

            double weekSalary = hourToWeek(Double.parseDouble(hourRate.getText().toString()), Integer.parseInt(hoursAmount.getText().toString()));
            double monthSalary = hourToMonth(Double.parseDouble(hourRate.getText().toString()), Integer.parseInt(hoursAmount.getText().toString()));
            double yearSalary = hourToYear(Double.parseDouble(hourRate.getText().toString()), Integer.parseInt(hoursAmount.getText().toString()));

            weekSalary = Math.round(weekSalary * 100.0) / 100.0;
            monthSalary = Math.round(monthSalary * 100.0) / 100.0;
            yearSalary = Math.round(yearSalary * 100.0) / 100.0;

            salaryPerWeek.setText((localCurrency + Double.toString(weekSalary) + " per week"));
            salaryPerMonth.setText((localCurrency + Double.toString(monthSalary) + " per month"));
            salaryPerYear.setText((localCurrency + Double.toString(yearSalary) + " per year"));
        }
        catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Empty value!", Toast.LENGTH_SHORT).show();
        }
    }
}
