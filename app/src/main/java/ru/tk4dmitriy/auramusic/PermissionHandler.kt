package ru.tk4dmitriy.auramusic

interface PermissionHandler {
    fun checkAndLaunchPermissionOrRationale(permission: String)
    fun launchRequestPermission(permission: String)
    fun handlePermissionGranted()
    fun handlePermissionDenied()
    fun handlePermissionRationale()
}