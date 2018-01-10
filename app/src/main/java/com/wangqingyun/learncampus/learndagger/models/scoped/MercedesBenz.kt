package com.wangqingyun.learncampus.learndagger.models.scoped

import com.wangqingyun.learncampus.learndagger.modules.scoped.YEAR_OF_MANU
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

/**
 * Created by wangqingyun on 10/01/2018.
 */

@Singleton
data class MercedesBenz @Inject constructor(@Named(YEAR_OF_MANU) val year: Int)