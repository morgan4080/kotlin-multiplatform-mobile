import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable

actual fun getPlatform(): String = "Android ${android.os.Build.VERSION.SDK_INT}"

@Composable fun MainView(activity: AppCompatActivity) = App()
