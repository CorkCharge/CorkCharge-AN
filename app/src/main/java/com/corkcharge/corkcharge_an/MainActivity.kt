package com.corkcharge.corkcharge_an

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.corkcharge.corkcharge_an.ui.OnboardingWebViewScreen
import com.corkcharge.corkcharge_an.ui.theme.CorkChargeANTheme

class MainActivity : ComponentActivity() {

    // 최신 권장 방식: registerForActivityResult 사용
    private val permissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestMultiplePermissions()) { results ->
            val deniedList = results.filterValues { !it }.keys
            if (deniedList.isNotEmpty()) {
                Toast.makeText(
                    this,
                    "일부 권한이 거부되었습니다. 앱의 일부 기능이 제한될 수 있습니다.",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        // 요청할 권한 목록
        val permissions = mutableListOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.CALL_PHONE
        )

        // Android 10(Q) 이상에서 백그라운드 위치 권한 추가
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            permissions.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION)
        }

        // 아직 허용되지 않은 권한만 추려서 요청
        val permissionsToRequest = permissions.filter {
            ContextCompat.checkSelfPermission(this, it) == PackageManager.PERMISSION_DENIED
        }

        if (permissionsToRequest.isNotEmpty()) {
            permissionLauncher.launch(permissionsToRequest.toTypedArray())
        }

        // Compose UI 표시
        setContent {
            CorkChargeANTheme {
                OnboardingWebViewScreen()
            }
        }
    }
}
