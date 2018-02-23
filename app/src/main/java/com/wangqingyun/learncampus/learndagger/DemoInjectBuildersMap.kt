package com.wangqingyun.learncampus.learndagger

import android.util.Log
import com.wangqingyun.learncampus.learndagger.components.injectmap.DaggerInjectMapComponent
import com.wangqingyun.learncampus.learndagger.components.injectmap.InjectMapSubComponent
import javax.inject.Inject
import javax.inject.Provider

/**
 * Created by wangqingyun on 23/02/2018.
 */

class DemoInjectBuildersMap {
    @Inject lateinit var buildersMap: Map<Class<*>, @JvmSuppressWildcards Provider<SubComponentBuilder<*>>>

    init {
        setupDependencyInjection()

        injectCohort()
    }

    private fun setupDependencyInjection() {
        DaggerInjectMapComponent.builder().build().inject(this)
    }

    private fun injectCohort() {
        buildersMap[DemoInjectBuildersCohort::class.java]?.get()?.build()?.run {
            if (this is InjectMapSubComponent) {
                val cohort = DemoInjectBuildersCohort()
                inject(cohort)
                cohort.doIt()
            }
        }
    }
}

class DemoInjectBuildersCohort {
    @Inject lateinit var text: String

    fun doIt() {
        Log.d("WQY", "my text is : $text")
    }
}