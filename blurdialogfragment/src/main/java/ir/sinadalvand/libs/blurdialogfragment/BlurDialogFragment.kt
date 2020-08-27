/*
 * *
 *  * Created by Sina Dalvand on 8/24/20 4:08 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 8/24/20 4:08 PM
 *
 */

package ir.sinadalvand.libs.blurdialogfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import eightbitlab.com.blurview.BlurView
import eightbitlab.com.blurview.RenderScriptBlur

/**
 * Fragment Blur Background That use {@see eightbitlab.com.blurview.BlurView} to make self background blur!
 *
 * </br>
 *
 * for using this lib you just need extend your DialogFragment from this class
 * and try to do not override {@see BlurDialogFragment#onCreateView(LayoutInflater,ViewGroup,Bundle) } or {@see BlurDialogFragment#onViewCreated(View,Bundle) }
 * instead you can use {@see BlurDialogFragment#onCreateView() } and return your layoutRes Id
 * </br>
 * but if used forbidden methods be sure you are call super of them
 *
 * @version 1.0.0
 * @author sina Dalvand
 */
abstract class BlurDialogFragment : DialogFragment() {


    private val BLUR_ID = 514214;

    private val DEFAULT_BLUR_RADIUS = 5f
    private val DEFAULT_BLUR_LIVE = false

    /**
     * return your layout id
     * @return Int
     */
    abstract fun onCreateView(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return blurInjector(inflater.inflate(onCreateView(), container, false))
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // this part is important to make injected background blur
        val blurView = view.findViewById<BlurView>(BLUR_ID)
        blurView.setupWith(requireActivity().window.decorView as ViewGroup)
                .setFrameClearDrawable(requireActivity().window.decorView.background)
                .setBlurAlgorithm(RenderScriptBlur(requireContext()))
                .setHasFixedTransformationMatrix(!liveBackground())
                .setBlurRadius(blurRadius())


    }

    /**
     * generate blur background and include content into that
     * @param container View?
     * @return ViewGroup?
     */
    private fun blurInjector(container: View?): ViewGroup? {
        val blurContainer = BlurView(requireContext())
        blurContainer.id = BLUR_ID
        blurContainer.addView(container)
        return blurContainer
    }


    /**
     * return blur radius to make your background blur as you can!
     * value must be  (0 < value < 25)
     * @return Float
     */
    fun blurRadius(): Float = DEFAULT_BLUR_RADIUS

    /**
     * if you have live background that means something that is moving while you are showing this Dialog Fragment
     * then you should return {@link Boolean#true} otherwise {@link Boolean#false}
     * @return Boolean
     */
    fun liveBackground(): Boolean = DEFAULT_BLUR_LIVE

}