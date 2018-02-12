package ozog.development.salarycalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SalaryCalculator extends AppCompatActivity {

    TextView salaryPerWeek, salaryPerMonth, salaryPerYear;
    Button btnCalculate;
    EditText hoursAmount, hourRate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salary_calculator);

        salaryPerWeek = findViewById(R.id.salaryPerWeek);
        salaryPerMonth = findViewById(R.id.salaryPerMonth);
        salaryPerYear = findViewById(R.id.salaryPerYear);

        btnCalculate = findViewById(R.id.btnCalculate);
        hoursAmount = findViewById(R.id.hoursAmount);
        hourRate = findViewById(R.id.hourRate);
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
        double weekSalary = hourToWeek( Double.parseDouble(hourRate.getText().toString()), Integer.parseInt(hoursAmount.getText().toString()) );
        double monthSalary = hourToMonth( Double.parseDouble(hourRate.getText().toString()), Integer.parseInt(hoursAmount.getText().toString()) );
        double yearSalary = hourToYear( Double.parseDouble(hourRate.getText().toString()), Integer.parseInt(hoursAmount.getText().toString()) );

        weekSalary = Math.round(weekSalary * 100.0) / 100.0;
        monthSalary = Math.round(monthSalary * 100.0) / 100.0;
        yearSalary = Math.round(yearSalary * 100.0) / 100.0;

        String salaryResultRightSide = " per week";

        salaryPerWeek.setText( ( "$" + Double.toString( weekSalary ) + salaryResultRightSide ) );
        salaryPerMonth.setText( ( "$" + Double.toString( monthSalary ) + salaryResultRightSide ) );
        salaryPerYear.setText( ( "$" + Double.toString( yearSalary ) + salaryResultRightSide ) );
    }
}
