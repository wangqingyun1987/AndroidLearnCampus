package com.wangqingyun.learncampus.learndagger.modules

import dagger.Module
import dagger.Provides
import javax.inject.Named

/**
 * Created by wangqingyun on 10/01/2018.
 */

const val BIRD_DESC = "BIRD_DESC"

@Module
class BirdModule(val count: Int) {
    @Provides
    @Named(BIRD_DESC)
    fun provideBirdCount() = "There are $count bird types available!!"
}