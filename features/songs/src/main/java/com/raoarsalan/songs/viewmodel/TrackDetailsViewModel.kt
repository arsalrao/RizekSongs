package com.raoarsalan.songs.viewmodel

import com.raoarsalan.core.utils.NavigationCommand
import com.raoarsalan.core.viewmodel.BaseViewModel


class TrackDetailsViewModel : BaseViewModel() {


    fun select() {
        navigationCommands.value = NavigationCommand.Back
    }

}