package com.wangqingyun.learncampus.learndagger.modules.encapsulation

import com.wangqingyun.learncampus.learndagger.scopes.EncUIScope
import dagger.Module
import dagger.Provides
import java.util.*
import javax.inject.Named

/**
 * Created by wangqingyun on 10/01/2018.
 */

const val UI_TEXT = "UI_TEXT"

@Module
class EncUIModule {
    @EncUIScope
    @Provides
    @Named(UI_TEXT)
    fun provideText() = "大唐(${618 + Math.abs(Random().nextInt() % 50)})盛世来朝"
}