package ytr.jniperformance;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private final int LOOP_COUNT = Integer.MAX_VALUE;

    private TextView mTvDesc;
    private TextView mTvText;
    private Button mBtnJni;
    private ProgressDialog mDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        mTvDesc.append(String.valueOf(LOOP_COUNT));

    }

    private void initView() {
        mTvDesc = (TextView) findViewById(R.id.tv_desc);
        mTvText = (TextView) findViewById(R.id.tv_show_text);
        mBtnJni = (Button) findViewById(R.id.btn_dotask);
        mDialog = new ProgressDialog(this);
        mDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        mDialog.setMessage("wait");
        mDialog.setCancelable(false);
    }


    public void click_doTask(View view) {
        new AsyncTask<Void, Void, Void>() {

            private long mJniTime;
            private long mJavaTime;

            @Override
            protected void onPreExecute() {
                mDialog.show();
            }

            @Override
            protected Void doInBackground(Void... params) {
                long jniStart = System.currentTimeMillis();
                JniWrapper.calculationTask(LOOP_COUNT);
                long jniStop = System.currentTimeMillis();
                mJniTime = jniStop - jniStart;


                long javaStart = System.currentTimeMillis();
                calculationTask(LOOP_COUNT);
                long javaStop = System.currentTimeMillis();
                mJavaTime = javaStop - javaStart;
                return null;
            }

            @Override
            protected void onPostExecute(Void params) {
                mDialog.cancel();
                mTvText.append("Jni cost time: " + String.valueOf(mJniTime) + "ms\n");
                mTvText.append("Java cost time: " + String.valueOf(mJavaTime) + "ms\n\n");
            }
        }.execute();
    }


    private static double calculationTask(int loop_count) {
        int i;
        double circle = 1;
        //Floating point operations are time consuming and loop the largest number of integers.
        for (i = 0; i < loop_count; i++) {
            circle *= 3.1415962;
        }
        return circle;
    }


}
