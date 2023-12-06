package com.auttasoft.dependencyinjectionkoin

import com.auttasoft.dependencyinjectionkoin.ui.theme.AppViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Created by AuttaphonL. on 06,ธันวาคม,2566
 */

val appModule = module {
    viewModel { AppViewModel() }
}