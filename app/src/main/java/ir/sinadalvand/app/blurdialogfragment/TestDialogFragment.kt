package ir.sinadalvand.app.blurdialogfragment

import android.os.Bundle
import android.view.ViewGroup
import androidx.annotation.Nullable
import ir.sinadalvand.libs.blurdialogfragment.BlurDialogFragment

class TestDialogFragment: BlurDialogFragment() {

    override fun onCreateView(): Int {
        return R.layout.fragment_test
    }

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, R.style.FullScreenDialogStyle)
    }

    override fun onStart() {
        super.onStart()
        val dialog = dialog
        if (dialog != null) {
            val width = ViewGroup.LayoutParams.MATCH_PARENT
            val height = ViewGroup.LayoutParams.MATCH_PARENT
            dialog.window!!.setLayout(width, height)
        }
    }

}
