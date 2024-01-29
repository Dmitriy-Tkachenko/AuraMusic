package ru.tk4dmitriy.auramusic

import android.Manifest.permission.READ_EXTERNAL_STORAGE
import android.content.pm.PackageManager.PERMISSION_DENIED
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import ru.tk4dmitriy.auramusic.databinding.ActivityMainBinding
import ru.tk4dmitriy.screens.music.MusicScreenApi
import ru.tk4dmitriy.screens.music.ui.MusicFragment
import javax.inject.Inject
import javax.inject.Provider

class MainActivity : AppCompatActivity(), PermissionHandler {
    private lateinit var binding: ActivityMainBinding
    private val musicFragment by lazy { MusicFragment() }

    @Inject
    lateinit var musicScreenApi: Provider<MusicScreenApi>

    private val resultLauncherPermission =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { granted ->
            when(granted) {
                true -> handlePermissionGranted()
                false -> handlePermissionDenied()
            }
        }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as App).appComponent.inject(this)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            checkAndLaunchPermissionOrRationale(READ_EXTERNAL_STORAGE)
        }
    }

    override fun checkAndLaunchPermissionOrRationale(permission: String) {
        if (checkSelfPermission(permission) == PERMISSION_DENIED)
            if (shouldShowRequestPermissionRationale(READ_EXTERNAL_STORAGE)) handlePermissionRationale()
            else launchRequestPermission(READ_EXTERNAL_STORAGE)
        else handlePermissionGranted()
    }

    override fun launchRequestPermission(permission: String) {
        resultLauncherPermission.launch(permission)
    }

    override fun handlePermissionGranted() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, musicFragment, musicScreenApi.get().getTagFragment())
            .commit()
    }

    override fun handlePermissionDenied() {
        handlePermissionRationale()
    }

    override fun handlePermissionRationale() {
        AlertDialog.Builder(this).apply {
            setTitle(getString(R.string.alert_title))
            setMessage(R.string.alert_read_external_storage_permission)
            setNegativeButton(getString(R.string.alert_btn_close)) { dialog, _ ->
                dialog.cancel()
                finish()
            }
            setPositiveButton(getString(R.string.alert_btn_continue)) { _, _ ->
                resultLauncherPermission.launch(READ_EXTERNAL_STORAGE)
            }
            create()
            show()
        }
    }
}