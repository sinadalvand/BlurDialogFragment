package ir.sinadalvand.app.blurdialogfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textView = findViewById<TextView>(R.id.helloTextView)
        textView.setOnClickListener {
            val blurDialogFragment = TestDialogFragment()
            blurDialogFragment.show(
                supportFragmentManager,
                "test_fragment"
            )
        }

    }
}
