package course.labs.activitylab;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class ActivityTwo extends Activity {

	private static final String RESTART_KEY = "restart";
	private static final String RESUME_KEY = "resume";
	private static final String START_KEY = "start";
	private static final String CREATE_KEY = "create";

	// String for LogCat documentation
	private final static String TAG = "Lab-ActivityTwo";

	// Lifecycle counters

	// TODO:
	// Create counter variables for onCreate(), onRestart(), onStart() and
	// onResume(), called mCreate, etc.
	// You will need to increment these variables' values when their
	// corresponding lifecycle methods get called
	private int mCounterCreate;
	private int mCounterRestart;
	private int mCounterStart;
	private int mCounterResume;

	// TODO: Create variables for each of the TextViews, called
        // mTvCreate, etc. 
	TextView mTvCreate;
	TextView mTvRestart;
	TextView mTvStart;
	TextView mTvResume;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_two);

		// TODO: Assign the appropriate TextViews to the TextView variables
		// Hint: Access the TextView by calling Activity's findViewById()
		// textView1 = (TextView) findViewById(R.id.textView1);

		mTvCreate = (TextView) findViewById(R.id.create);
		mTvRestart = (TextView) findViewById(R.id.restart);
		mTvStart = (TextView) findViewById(R.id.start);
		mTvResume = (TextView) findViewById(R.id.resume);


		Button closeButton = (Button) findViewById(R.id.bClose); 
		closeButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				// TODO:
				// This function closes Activity Two
				// Hint: use Context's finish() method
				finish();
			
			}
		});

		// Check for previously saved state
		if (savedInstanceState != null) {

			// TODO:
			// Restore value of counters from saved state
			// Only need 4 lines of code, one for every count variable
			mCounterCreate = savedInstanceState.getInt("counterCreate");
			mCounterRestart = savedInstanceState.getInt("counterRestart");
			mCounterStart = savedInstanceState.getInt("counterStart");
			mCounterResume = savedInstanceState.getInt("counterResume");

		}

		// TODO: Emit LogCat message
		Log.d(TAG, "Entering OnCreate(), increasing counter");



		// TODO:
		// Update the appropriate count variable
		// Update the user interface via the displayCounts() method
		mCounterCreate++;
		displayCounts();
	}

	// Lifecycle callback methods overrides

	@Override
	public void onStart() {
		super.onStart();

		// TODO: Emit LogCat message
		Log.d(TAG, "Entering OnStart(), increasing counter");

		// TODO:
		// Update the appropriate count variable
		// Update the user interface
		mCounterStart++;
		displayCounts();

	}

	@Override
	public void onResume() {
		super.onResume();

		// TODO: Emit LogCat message
		Log.d(TAG, "Entering OnStart(), increasing counter");

		// TODO:
		// Update the appropriate count variable
		// Update the user interface
		mCounterResume++;
		displayCounts();

	}

	@Override
	public void onPause() {
		super.onPause();

		// TODO: Emit LogCat message
		Log.d(TAG, "Entering OnPause()");
	}

	@Override
	public void onStop() {
		super.onStop();

		// TODO: Emit LogCat message
		Log.d(TAG, "Entering OnStop()");
	}

	@Override
	public void onRestart() {
		super.onRestart();

		// TODO: Emit LogCat message
		Log.d(TAG, "Entering OnRestart(), increasing counter");

		// TODO:
		// Update the appropriate count variable
		// Update the user interface
		mCounterRestart++;
		displayCounts();

	}

	@Override
	public void onDestroy() {
		super.onDestroy();

		// TODO: Emit LogCat message
		Log.d(TAG, "Entering OnDestroy()");
	}

	@Override
	public void onSaveInstanceState(Bundle savedInstanceState) {

		// TODO:
		// Save counter state information with a collection of key-value pairs
		// 4 lines of code, one for every count variable
		Log.d(TAG, "Entering onSaveInstanceState");
		savedInstanceState.putInt("counterCreate", mCounterCreate);
		savedInstanceState.putInt("counterRestart", mCounterRestart);
		savedInstanceState.putInt("counterStart", mCounterStart);
		savedInstanceState.putInt("counterResume", mCounterResume);
	}

	// Updates the displayed counters
	public void displayCounts() {
		mTvCreate.setText("onCreate() calls: " + mCounterCreate);
		mTvStart.setText("onStart() calls: " + mCounterStart);
		mTvResume.setText("onResume() calls: " + mCounterResume);
		mTvRestart.setText("onRestart() calls: " + mCounterRestart);
	
	}
}
