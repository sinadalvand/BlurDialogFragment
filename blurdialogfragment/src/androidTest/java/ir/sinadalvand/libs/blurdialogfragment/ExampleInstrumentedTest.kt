/*
 * *
 *  * Created by Sina Dalvand on 8/24/20 4:05 PM
 *  * Copyright (c) 2020 . All rights reserved.
 *  * Last modified 8/24/20 4:05 PM
 *
 */

package ir.sinadalvand.libs.blurdialogfragment

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("ir.sinadalvand.libs.blurfragment.test", appContext.packageName)
    }
}