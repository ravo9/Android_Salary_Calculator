package ozog.development.salarycalculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        salaryPerWeek = (TextView) findViewById(R.id.salaryPerWeek);
        salaryPerMonth = (TextView) findViewById(R.id.salaryPerMonth);
        salaryPerYear = (TextView) findViewById(R.id.salaryPerYear);

        btnCalculate = (Button) findViewById(R.id.btnCalculate);

        hoursAmount = (EditText) findViewById(R.id.hoursAmount);
        hourRate = (EditText) findViewById(R.id.hourRate);
    }

    public double hourToWeek( float hourRate, int hourAmount ) {
        return ( hourRate * hourAmount );
    }

    public double hourToMonth( float hourRate, int hourAmount) {
        return ( hourRate * hourAmount * 4.345);
    }

    public double hourToYear( float hourRate, int hourAmount ) {
        return ( hourRate * hourAmount * 52.143);
    }

    public void calculateAll() {
        double weekSalary = hourToWeek( Float.parseFloat(hoursAmount.getText().toString()), Integer.parseInt(hourRate.getText().toString()) );
        double monthSalary = hourToMonth( Float.parseFloat(hoursAmount.getText().toString()), Integer.parseInt(hourRate.getText().toString()) );
        double yearSalary = hourToYear( Float.parseFloat(hoursAmount.getText().toString()), Integer.parseInt(hourRate.getText().toString()) );

        String salaryPerWeekRightSide = salaryPerWeek.getText().toString().substring( 5 );
        salaryPerWeek.setText( salaryPerWeekRightSide );
    }
}
