/*
 * Copyright 2018 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package androidx.navigation

import android.support.test.InstrumentationRegistry
import android.support.test.filters.SmallTest
import androidx.navigation.testing.TestNavigator
import androidx.navigation.testing.test
import org.junit.Assert.assertTrue
import org.junit.Test

@SmallTest
class NavHostTest {
    private val navController = NavController(InstrumentationRegistry.getTargetContext()).apply {
        navigatorProvider += TestNavigator()
    }
    private val navHost = NavHost { this@NavHostTest.navController }

    @Test
    fun createGraph() {
        val graph = navHost.createGraph(startDestination = DESTINATION_ID) {
            test(DESTINATION_ID)
        }
        assertTrue("Destination should be added to the graph",
                DESTINATION_ID in graph)
    }
}

private const val DESTINATION_ID = 1
