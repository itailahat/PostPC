package il.ac.huji.tipcalculator;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class TipCalculatorActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.tip_calculator, menu);
        return true;
    }
    
    public void CalculateTip(View view)
    {
    	EditText theBill = (EditText)findViewById(R.id.edtBillAmount);
    	String thestring = theBill.getText().toString();
    	if (null == thestring || thestring == "" || thestring.length()==0)
    	{
    		return;
    	}
    	double doubleBill = 0;
    	try
    	{
    	doubleBill = Double.parseDouble(theBill.getText().toString())*(12.0/100.0);
    	}
    	catch (NumberFormatException e)
    	{
    		return;
    	}
    	CheckBox roundBox = (CheckBox)findViewById(R.id.chkRound);
    	TextView result = (TextView)findViewById(R.id.txtTipResult);
    	if (roundBox.isChecked())
    	{
    		long integerBill = Math.round(doubleBill);
    		result.setText("Tip: $" + integerBill);
    	}
    	else
    	{
    		result.setText("Tip: $" + String.format("%.2f\n",(double)(Math.round(doubleBill*100))/100));
    	}
    }    
}
